package scut.yulin.security.component;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import scut.yulin.security.util.JwtTokenUtil;

/**
 * JWT登录授权过滤器（前置过滤器？）负责处理HTTPHeader中的基本认证信息
 * 当用户登录成功后，以后所有的请求都会携带一个 JWT 令牌，携带 JWT 令牌的请求将在这个过滤器中进行验证
 * 验证成功后，将登录主体信息放入 SecurityContextHolder 中即可。
 *
 * @author xieyulin
 * @date 2021/05/19
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory
        .getLogger(JwtAuthenticationTokenFilter.class);
    @Autowired
    private UserDetailsService adminService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            // The part after "Bearer "，在JWT中获取服务器给客户端的token
            String authToken = authHeader.substring(this.tokenHead.length());
            // 在token中解析出来用户名
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            LOGGER.info("checking username:{}", username);
            // 用户名不为空，获取的到，就使用当前过滤器进行验证身份信息。获取不到，则继续执行正常的过滤链。
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 根据用户名找到该用户的信息
                UserDetails userDetails = this.adminService.loadUserByUsername(username);
                // 通过对比「token中的用户信息」和「数据库中找到的用户信息」验证token的有效性
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    // 貌似是将「用户信息』+『用户权限』一起放在「UsernamePasswordAuthenticationToken」这个验证令牌里了
                    // 这个对象实现了Authentication接口，Authentication接口封装了验证信息
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    // 将请求的信息设到「UsernamePasswordAuthenticationToken」中去，包括ip、session等内容
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    LOGGER.info("authenticated user:{}", username);
                    // 将登录主体信息放入「SecurityContextHolder」中
                    // SecurityContextHolder是ThreadLocal的一个封装
                    // 创建成功之后，塞进去，此次登陆所有的请求都会通过SecurityContextPersisenceFilter去SecurityContextHolder拿那个Authentication。
                    // SecurityContextHolder在整个过滤器的最前面。
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
