package scut.yulin.trip;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scut.yulin.trip.mbg.mapper.CommentDao;

@SpringBootTest
class TripApplicationTests {
    @Autowired
    CommentDao commentDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testImplement() {
//        Flight flight = new Flight();
//        flight.setList(new ArrayList<>());
//        flight.getList().add(new Flight2("f2"));
//        System.out.println(flight.getList());
//        System.out.println("ok");
    }

    @Test
    void testComment() {
//        Comment comment = new Comment(
//                IdUtil.randomUUID(),
//                IdUtil.randomUUID(),
//                IdUtil.randomUUID(),
//                IdUtil.randomUUID(),
//                "comment content1"
//        );
//        int insertResult = commentDao.insert(comment);
//        System.out.println(insertResult);
    }
}
