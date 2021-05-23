package scut.yulin.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import scut.yulin.security.component.DynamicAccessDecisionManager;
import scut.yulin.security.component.DynamicSecurityFilter;
import scut.yulin.security.component.DynamicSecurityMetadataSource;
import scut.yulin.security.component.DynamicSecurityService;
import scut.yulin.security.component.JwtAuthenticationTokenFilter;
import scut.yulin.security.component.RestAuthenticationEntryPoint;
import scut.yulin.security.component.RestfulAccessDeniedHandler;
import scut.yulin.security.util.JwtTokenUtil;


/**
 * 对SpringSecurity的配置的扩展，支持自定义白名单资源路径和查询用户逻辑
 * Created by macro on 2019/11/5.
 */

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired(required = false)
    private DynamicSecurityService dynamicSecurityService;

//    @Autowired
//    private StudentAdminService studentAdminService;

    /**
     * 用于配置需要拦截的url路径、jwt过滤器及出异常后的处理器
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
//                .authorizeRequests();
//        //不需要保护的资源路径允许访问
//        for (String url : ignoreUrlsConfig().getUrls()) {
//            registry.antMatchers(url).permitAll();
//        }
//        //允许跨域请求的OPTIONS请求
//        registry.antMatchers(HttpMethod.OPTIONS)
//                .permitAll();
//        // 任何请求需要身份认证
//        registry.and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                // 关闭跨站请求防护及不使用session
//                .and()
//                .csrf()
//                .disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                // 自定义权限拒绝处理类
//                .and()
//                .exceptionHandling()
//                .accessDeniedHandler(restfulAccessDeniedHandler())
//                .authenticationEntryPoint(restAuthenticationEntryPoint())
//                // 自定义权限拦截器JWT过滤器
//                .and()
//                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//        //有动态权限配置时添加动态权限校验过滤器
//        if(dynamicSecurityService!=null){
//            registry.and().addFilterBefore(dynamicSecurityFilter(), FilterSecurityInterceptor.class);
//        }
        httpSecurity
            // 由于使用的是JWT，我们这里不需要csrf
            .csrf()
            .disable()
            // 基于token，所以不需要session
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            // 允许对于网站静态资源的无授权访问
            .antMatchers(HttpMethod.GET,
                "/",
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/swagger-resources/**",
                "/v2/api-docs/**"
            )
            .permitAll()
            // 对登录注册要允许匿名访问
            .antMatchers("/admin/student/login", "/admin/student/register")
            .permitAll()
            //跨域请求会先进行一次options请求
            .antMatchers(HttpMethod.OPTIONS)
            .permitAll()
            // 除上面外的所有请求全部需要鉴权认证
            .anyRequest()
            .authenticated();

        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
            .accessDeniedHandler(restfulAccessDeniedHandler())
            .authenticationEntryPoint(restAuthenticationEntryPoint());
    }

    /**
     * 用于配置UserDetailsService及PasswordEncoder；
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    /**
     * SpringSecurity定义的用于对密码进行编码及比对的接口，目前使用的是BCryptPasswordEncoder
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    /**
//     * 定义的核心接口，用于根据用户名获取用户信息，需要自行实现
//     * @return
//     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//        //获取登录用户信息
//        return username -> {
//            Student admin = studentAdminService.getStudentByAccountName(username);
//            if (admin != null) {
//                return new AdminUserDetails(admin);
//            }
//            throw new UsernameNotFoundException("用户名或密码错误");
//        };
//    }




    /**
     * 在用户名和密码校验前添加的过滤器，如果有jwt的token，会自行根据token信息进行登录
     * @return
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * 对用户的未授信凭据进行认证，认证通过则返回授信状态的凭据，否则将抛出认证异常AuthenticationException
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 当用户没有访问权限时的处理器，用于返回JSON格式的处理结果；
     * @return
     */
    @Bean
    public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
        return new RestfulAccessDeniedHandler();
    }

    /**
     * 当未登录或token失效时，返回JSON格式的结果
     * @return
     */
    @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    /**
     * 白名单路径配置类
     * @return
     */
    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }

    /**
     * JwtToken生成的工具类
     * @return
     */
    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

    /**
     * 动态权限决策管理器，用于判断用户是否有访问权限
     * @return
     */
    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicAccessDecisionManager dynamicAccessDecisionManager() {
        return new DynamicAccessDecisionManager();
    }

    /**
     * 动态权限过滤器，用于实现基于路径的动态权限过滤
     * @return
     */
    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityFilter dynamicSecurityFilter() {
        return new DynamicSecurityFilter();
    }

    /**
     * 动态权限数据源，用于获取动态权限规则
     * @return
     */
    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource() {
        return new DynamicSecurityMetadataSource();
    }

}
