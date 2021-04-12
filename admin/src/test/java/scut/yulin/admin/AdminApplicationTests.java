package scut.yulin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scut.yulin.common.constant.ResultCode;
import scut.yulin.common.vo.ResponseVO;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


@SpringBootTest
class AdminApplicationTests {
    @Autowired
    DataSource dataSource;

    /**
     * 测试数据库连通性
     * @throws SQLException
     */
    @Test
    void contextLoads() throws SQLException {
        System.out.println("获取的数据库连接为:"+dataSource.getConnection().toString());
        System.out.println("获取的数据库连接为:"+dataSource.getConnection().getMetaData());
        System.out.println("获取的数据库连接为:"+dataSource.toString());
    }

    @Test
    void testErrorCode(){
        System.out.println(new ResponseVO(ResultCode.VALIDATE_FAILED.getCode(), "test", 1));
        System.out.println(ResponseVO.failed("failed"));
    }

    @Test
    void testExceptionHandler() throws SQLIntegrityConstraintViolationException {
        throw new SQLIntegrityConstraintViolationException("test handler");
    }
}
