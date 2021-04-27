package scut.yulin.trip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scut.yulin.trip.mbg.mapper.CommentDao;

@SpringBootTest
class TripApplicationTests {

  class obj{
    Integer serial;
    String str;

    public obj(Integer serial, String str) {
      this.serial = serial;
      this.str = str;
    }

    public Integer getSerial() {
      return serial;
    }

    public void setSerial(Integer serial) {
      this.serial = serial;
    }

    public String getStr() {
      return str;
    }

    public void setStr(String str) {
      this.str = str;
    }

    @Override
    public String toString() {
      return "obj{" +
          "serial=" + serial +
          ", str='" + str + '\'' +
          '}';
    }
  }

  @Autowired
  CommentDao commentDao;

  @Test
  void contextLoads() {
  }

  @Test
  void testLinkedList(){
    obj o1 = new obj(1,"test1");
    obj o2 = new obj(2,"test2");
    obj o3 = new obj(3,"test3");
    obj o4 = new obj(4,"test4");

    List<obj> list = new LinkedList<>();
    list.add(o3);
    list.add(o1);
    list.add(o4);
    list.add(o2);

    System.out.println(list.toString());
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

  @Test
  void testDate() {
    SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//如2016-08-10 20:40
    String aTime = "2021-02-02 21:40";
    String dTime = "2021-02-01 12:30";
    Date arrivalTime = null;
    Date departureTime = null;
    Date duration = null;
    Date earliestDate = null;
    String baseDate = "1970-01-01 00:";
    String earliest = "1970-01-01 00:00";
    //时间相关的处理
    try {
      earliestDate = simpleFormat.parse(earliest);
      departureTime = simpleFormat.parse(dTime);
      arrivalTime = simpleFormat.parse(aTime);
      long from = departureTime.getTime();
      long to = arrivalTime.getTime();
      int minutes = (int) ((to - from) / (1000 * 60));
      System.out.println("minutes====>" + minutes);
      String durationString = baseDate + minutes;
      duration = simpleFormat.parse(durationString);
      System.out.println(duration.toString());

      int _day = (int) ((duration.getTime() - earliestDate.getTime()) / (1000 * 60 * 60 * 24));
      int _hours = (int) ((duration.getTime() - earliestDate.getTime()) / (1000 * 60 * 60));
      int _mins = (int) ((duration.getTime() - earliestDate.getTime()) / (1000 * 60));
      System.out.println("day: " + _day + "\thours:" + _hours + "\tmins:" + _mins);

    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  void getDuration(){
    SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//如2016-08-10 20:40
    String aTime = "2021-02-02 21:40";
    String dTime = "2021-02-01 12:30";
    Date arrivalTime = null;
    Date departureTime = null;
    Date duration = null;
    Date earliestDate = null;
    String baseDate = "1970-01-01 00:";
    String earliest = "1970-01-01 00:00";
    //时间相关的处理
    try {
      earliestDate = simpleFormat.parse(earliest);
      departureTime = simpleFormat.parse(dTime);
      arrivalTime = simpleFormat.parse(aTime);
      long from = departureTime.getTime();
      long to = arrivalTime.getTime();
      int minutes = (int) ((to - from) / (1000 * 60));
      System.out.println("minutes====>" + minutes);
      String durationString = baseDate + minutes;
      duration = simpleFormat.parse(durationString);
      System.out.println(duration.toString());

      long diff = duration.getTime() - earliestDate.getTime();
      long _day = diff / (1000 * 60 * 60 * 24);;
      long _hours = (diff-_day*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
      long _mins = (diff-_day*(1000 * 60 * 60 * 24)-_hours*(1000* 60 * 60))/(1000* 60);
      System.out.println("day: " + _day + "\thours:" + _hours + "\tmins:" + _mins);

    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
