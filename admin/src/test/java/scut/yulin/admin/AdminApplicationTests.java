package scut.yulin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;


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

}
