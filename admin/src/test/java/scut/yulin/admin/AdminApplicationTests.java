package scut.yulin.admin;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scut.yulin.admin.service.RedisService;
import scut.yulin.common.constant.ResultCode;
import scut.yulin.common.vo.ResponseVO;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


@SpringBootTest
class AdminApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    RedisService redisService;

    /**
     * 测试数据库连通性
     *
     * @throws SQLException
     */
    @Test
    void contextLoads() throws SQLException {
        System.out.println("获取的数据库连接为:" + dataSource.getConnection().toString());
        System.out.println("获取的数据库连接为:" + dataSource.getConnection().getMetaData());
        System.out.println("获取的数据库连接为:" + dataSource.toString());
    }

    @Test
    void testErrorCode() {
        System.out.println(new ResponseVO(ResultCode.VALIDATE_FAILED.getCode(), "test", 1));
        System.out.println(ResponseVO.failed("failed"));
    }

    @Test
    void testExceptionHandler() throws SQLIntegrityConstraintViolationException {
        throw new SQLIntegrityConstraintViolationException("test handler");
    }

    @Test
    void testRedis() {
        redisService.set("tel", "0608100167");
        System.out.println(redisService.get("tel"));
    }

    @Test
    void testUUID() {
        UUID uuid = UUID.fastUUID();
        System.out.println(uuid.getMostSignificantBits());
        System.out.println(uuid);
    }

    @Test
    void testSnowFlake() {
        //参数1为终端ID
        //参数2为数据中心ID
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        for (int i = 0; i < 10; i++) {
            long id = snowflake.nextId();
            System.out.println(id);
        }

    }
}
