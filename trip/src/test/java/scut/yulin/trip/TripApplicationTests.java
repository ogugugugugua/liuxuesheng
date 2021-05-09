package scut.yulin.trip;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scut.yulin.trip.dto.country_code.InsertCountryCodeDTO;
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

  @Test
  void testJsonParser(){
    String json = "[{\"cn\":\"阿富汗\",\"en\":\"Afghanistan\",\"phone_code\":\"+93\"},\n"
        + "{\"cn\":\"阿尔巴尼亚\",\"en\":\"Albania\",\"phone_code\":\"+355\"},\n"
        + "{\"cn\":\"阿尔及利亚\",\"en\":\"Algeria\",\"phone_code\":\"+213\"},\n"
        + "{\"cn\":\"美属萨摩亚\",\"en\":\"American Samoa\",\"phone_code\":\"+684\"},\n"
        + "{\"cn\":\"安道尔\",\"en\":\"Andorra\",\"phone_code\":\"+376\"},\n"
        + "{\"cn\":\"安哥拉\",\"en\":\"Angola\",\"phone_code\":\"+244\"},\n"
        + "{\"cn\":\"安圭拉\",\"en\":\"Anguilla\",\"phone_code\":\"+1264\"},\n"
        + "{\"cn\":\"南极洲\",\"en\":\"Antarctica\",\"phone_code\":\"+672\"},\n"
        + "{\"cn\":\"安提瓜和巴布达\",\"en\":\"Antigua and Barbuda\",\"phone_code\":\"+1268\"},\n"
        + "{\"cn\":\"阿根廷\",\"en\":\"Argentina\",\"phone_code\":\"+54\"},\n"
        + "{\"cn\":\"亚美尼亚\",\"en\":\"Armenia\",\"phone_code\":\"+374\"},\n"
        + "{\"cn\":\"阿鲁巴\",\"en\":\"Aruba\",\"phone_code\":\"+297\"},\n"
        + "{\"cn\":\"澳大利亚\",\"en\":\"Australia\",\"phone_code\":\"+61\"},\n"
        + "{\"cn\":\"奥地利\",\"en\":\"Austria\",\"phone_code\":\"+43\"},\n"
        + "{\"cn\":\"阿塞拜疆\",\"en\":\"Azerbaijan\",\"phone_code\":\"+994\"},\n"
        + "{\"cn\":\"巴林\",\"en\":\"Bahrain\",\"phone_code\":\"+973\"},\n"
        + "{\"cn\":\"孟加拉国\",\"en\":\"Bangladesh\",\"phone_code\":\"+880\"},\n"
        + "{\"cn\":\"巴巴多斯\",\"en\":\"Barbados\",\"phone_code\":\"+1246\"},\n"
        + "{\"cn\":\"白俄罗斯\",\"en\":\"Belarus\",\"phone_code\":\"+375\"},\n"
        + "{\"cn\":\"比利时\",\"en\":\"Belgium\",\"phone_code\":\"+32\"},\n"
        + "{\"cn\":\"伯利兹\",\"en\":\"Belize\",\"phone_code\":\"+501\"},\n"
        + "{\"cn\":\"贝宁\",\"en\":\"Benin\",\"phone_code\":\"+229\"},\n"
        + "{\"cn\":\"百慕大\",\"en\":\"Bermuda\",\"phone_code\":\"+1441\"},\n"
        + "{\"cn\":\"不丹\",\"en\":\"Bhutan\",\"phone_code\":\"+975\"},\n"
        + "{\"cn\":\"玻利维亚\",\"en\":\"Bolivia\",\"phone_code\":\"+591\"},\n"
        + "{\"cn\":\"波黑\",\"en\":\"Bosnia and Herzegovina\",\"phone_code\":\"+387\"},\n"
        + "{\"cn\":\"博茨瓦纳\",\"en\":\"Botswana\",\"phone_code\":\"+267\"},\n"
        + "{\"cn\":\"巴西\",\"en\":\"Brazil\",\"phone_code\":\"+55\"},\n"
        + "{\"cn\":\"英属维尔京群岛\",\"en\":\"British Virgin Islands\",\"phone_code\":\"+1284\"},\n"
        + "{\"cn\":\"文莱\",\"en\":\"Brunei Darussalam\",\"phone_code\":\"+673\"},\n"
        + "{\"cn\":\"保加利亚\",\"en\":\"Bulgaria\",\"phone_code\":\"+359\"},\n"
        + "{\"cn\":\"布基纳法索\",\"en\":\"Burkina Faso\",\"phone_code\":\"+226\"},\n"
        + "{\"cn\":\"缅甸\",\"en\":\"Burma\",\"phone_code\":\"+95\"},\n"
        + "{\"cn\":\"布隆迪\",\"en\":\"Burundi\",\"phone_code\":\"+257\"},\n"
        + "{\"cn\":\"柬埔寨\",\"en\":\"Cambodia\",\"phone_code\":\"+855\"},\n"
        + "{\"cn\":\"喀麦隆\",\"en\":\"Cameroon\",\"phone_code\":\"+237\"},\n"
        + "{\"cn\":\"加拿大\",\"en\":\"Canada\",\"phone_code\":\"+1\"},\n"
        + "{\"cn\":\"佛得角\",\"en\":\"Cape Verde\",\"phone_code\":\"+238\"},\n"
        + "{\"cn\":\"开曼群岛\",\"en\":\"Cayman Islands\",\"phone_code\":\"+1345\"},\n"
        + "{\"cn\":\"中非\",\"en\":\"Central African Republic\",\"phone_code\":\"+236\"},\n"
        + "{\"cn\":\"乍得\",\"en\":\"Chad\",\"phone_code\":\"+235\"},\n"
        + "{\"cn\":\"智利\",\"en\":\"Chile\",\"phone_code\":\"+56\"},\n"
        + "{\"cn\":\"中国\",\"en\":\"China\",\"phone_code\":\"+86\"},\n"
        + "{\"cn\":\"圣诞岛\",\"en\":\"Christmas Island\",\"phone_code\":\"+61\"},\n"
        + "{\"cn\":\"科科斯（基林）群岛\",\"en\":\"Cocos (Keeling) Islands\",\"phone_code\":\"+61\"},\n"
        + "{\"cn\":\"哥伦比亚\",\"en\":\"Colombia\",\"phone_code\":\"+57\"},\n"
        + "{\"cn\":\"科摩罗\",\"en\":\"Comoros\",\"phone_code\":\"+269\"},\n"
        + "{\"cn\":\"刚果（金）\",\"en\":\"Democratic Republic of the Congo\",\"phone_code\":\"+243\"},\n"
        + "{\"cn\":\"刚果（布）\",\"en\":\"Republic of the Congo\",\"phone_code\":\"+242\"},\n"
        + "{\"cn\":\"库克群岛\",\"en\":\"Cook Islands\",\"phone_code\":\"+682\"},\n"
        + "{\"cn\":\"哥斯达黎加\",\"en\":\"Costa Rica\",\"phone_code\":\"+506\"},\n"
        + "{\"cn\":\"科特迪瓦\",\"en\":\"Cote d'Ivoire\",\"phone_code\":\"+225\"},\n"
        + "{\"cn\":\"克罗地亚\",\"en\":\"Croatia\",\"phone_code\":\"+385\"},\n"
        + "{\"cn\":\"古巴\",\"en\":\"Cuba\",\"phone_code\":\"+53\"},\n"
        + "{\"cn\":\"塞浦路斯\",\"en\":\"Cyprus\",\"phone_code\":\"+357\"},\n"
        + "{\"cn\":\"捷克\",\"en\":\"Czech Republic\",\"phone_code\":\"+420\"},\n"
        + "{\"cn\":\"丹麦\",\"en\":\"Denmark\",\"phone_code\":\"+45\"},\n"
        + "{\"cn\":\"吉布提\",\"en\":\"Djibouti\",\"phone_code\":\"+253\"},\n"
        + "{\"cn\":\"多米尼克\",\"en\":\"Dominica\",\"phone_code\":\"+1767\"},\n"
        + "{\"cn\":\"多米尼加\",\"en\":\"Dominican Republic\",\"phone_code\":\"+1809\"},\n"
        + "{\"cn\":\"厄瓜多尔\",\"en\":\"Ecuador\",\"phone_code\":\"+593\"},\n"
        + "{\"cn\":\"埃及\",\"en\":\"Egypt\",\"phone_code\":\"+20\"},\n"
        + "{\"cn\":\"萨尔瓦多\",\"en\":\"El Salvador\",\"phone_code\":\"+503\"},\n"
        + "{\"cn\":\"赤道几内亚\",\"en\":\"Equatorial Guinea\",\"phone_code\":\"+240\"},\n"
        + "{\"cn\":\"厄立特里亚\",\"en\":\"Eritrea\",\"phone_code\":\"+291\"},\n"
        + "{\"cn\":\"爱沙尼亚\",\"en\":\"Estonia\",\"phone_code\":\"+372\"},\n"
        + "{\"cn\":\"埃塞俄比亚\",\"en\":\"Ethiopia\",\"phone_code\":\"+251\"},\n"
        + "{\"cn\":\"福克兰群岛（马尔维纳斯）\",\"en\":\"Falkland Islands (Islas Malvinas)\",\"phone_code\":\"+500\"},\n"
        + "{\"cn\":\"法罗群岛\",\"en\":\"Faroe Islands\",\"phone_code\":\"+298\"},\n"
        + "{\"cn\":\"斐济\",\"en\":\"Fiji\",\"phone_code\":\"+679\"},\n"
        + "{\"cn\":\"芬兰\",\"en\":\"Finland\",\"phone_code\":\"+358\"},\n"
        + "{\"cn\":\"法国\",\"en\":\"France\",\"phone_code\":\"+33\"},\n"
        + "{\"cn\":\"法属圭亚那\",\"en\":\"French Guiana\",\"phone_code\":\"+594\"},\n"
        + "{\"cn\":\"法属波利尼西亚\",\"en\":\"French Polynesia\",\"phone_code\":\"+689\"},\n"
        + "{\"cn\":\"加蓬\",\"en\":\"Gabon\",\"phone_code\":\"+241\"},\n"
        + "{\"cn\":\"格鲁吉亚\",\"en\":\"Georgia\",\"phone_code\":\"+995\"},\n"
        + "{\"cn\":\"德国\",\"en\":\"Germany\",\"phone_code\":\"+49\"},\n"
        + "{\"cn\":\"加纳\",\"en\":\"Ghana\",\"phone_code\":\"+233\"},\n"
        + "{\"cn\":\"直布罗陀\",\"en\":\"Gibraltar\",\"phone_code\":\"+350\"},\n"
        + "{\"cn\":\"希腊\",\"en\":\"Greece\",\"phone_code\":\"+30\"},\n"
        + "{\"cn\":\"格陵兰\",\"en\":\"Greenland\",\"phone_code\":\"+299\"},\n"
        + "{\"cn\":\"格林纳达\",\"en\":\"Grenada\",\"phone_code\":\"+1473\"},\n"
        + "{\"cn\":\"瓜德罗普\",\"en\":\"Guadeloupe\",\"phone_code\":\"+590\"},\n"
        + "{\"cn\":\"关岛\",\"en\":\"Guam\",\"phone_code\":\"+1671\"},\n"
        + "{\"cn\":\"危地马拉\",\"en\":\"Guatemala\",\"phone_code\":\"+502\"},\n"
        + "{\"cn\":\"根西岛\",\"en\":\"Guernsey\",\"phone_code\":\"+1481\"},\n"
        + "{\"cn\":\"几内亚\",\"en\":\"Guinea\",\"phone_code\":\"+224\"},\n"
        + "{\"cn\":\"几内亚比绍\",\"en\":\"Guinea-Bissau\",\"phone_code\":\"+245\"},\n"
        + "{\"cn\":\"圭亚那\",\"en\":\"Guyana\",\"phone_code\":\"+592\"},\n"
        + "{\"cn\":\"海地\",\"en\":\"Haiti\",\"phone_code\":\"+509\"},\n"
        + "{\"cn\":\"梵蒂冈\",\"en\":\"Holy See (Vatican City)\",\"phone_code\":\"+379\"},\n"
        + "{\"cn\":\"洪都拉斯\",\"en\":\"Honduras\",\"phone_code\":\"+504\"},\n"
        + "{\"cn\":\"香港\",\"en\":\"Hong Kong (SAR)\",\"phone_code\":\"+852\"},\n"
        + "{\"cn\":\"匈牙利\",\"en\":\"Hungary\",\"phone_code\":\"+36\"},\n"
        + "{\"cn\":\"冰岛\",\"en\":\"Iceland\",\"phone_code\":\"+354\"},\n"
        + "{\"cn\":\"印度\",\"en\":\"India\",\"phone_code\":\"+91\"},\n"
        + "{\"cn\":\"印度尼西亚\",\"en\":\"Indonesia\",\"phone_code\":\"+62\"},\n"
        + "{\"cn\":\"伊朗\",\"en\":\"Iran\",\"phone_code\":\"+98\"},\n"
        + "{\"cn\":\"伊拉克\",\"en\":\"Iraq\",\"phone_code\":\"+964\"},\n"
        + "{\"cn\":\"爱尔兰\",\"en\":\"Ireland\",\"phone_code\":\"+353\"},\n"
        + "{\"cn\":\"以色列\",\"en\":\"Israel\",\"phone_code\":\"+972\"},\n"
        + "{\"cn\":\"意大利\",\"en\":\"Italy\",\"phone_code\":\"+39\"},\n"
        + "{\"cn\":\"牙买加\",\"en\":\"Jamaica\",\"phone_code\":\"+1876\"},\n"
        + "{\"cn\":\"日本\",\"en\":\"Japan\",\"phone_code\":\"+81\"},\n"
        + "{\"cn\":\"约旦\",\"en\":\"Jordan\",\"phone_code\":\"+962\"},\n"
        + "{\"cn\":\"哈萨克斯坦\",\"en\":\"Kazakhstan\",\"phone_code\":\"+73\"},\n"
        + "{\"cn\":\"肯尼亚\",\"en\":\"Kenya\",\"phone_code\":\"+254\"},\n"
        + "{\"cn\":\"基里巴斯\",\"en\":\"Kiribati\",\"phone_code\":\"+686\"},\n"
        + "{\"cn\":\"朝鲜\",\"en\":\"North Korea\",\"phone_code\":\"+850\"},\n"
        + "{\"cn\":\"韩国\",\"en\":\"South Korea\",\"phone_code\":\"+82\"},\n"
        + "{\"cn\":\"科威特\",\"en\":\"Kuwait\",\"phone_code\":\"+965\"},\n"
        + "{\"cn\":\"吉尔吉斯斯坦\",\"en\":\"Kyrgyzstan\",\"phone_code\":\"+996\"},\n"
        + "{\"cn\":\"老挝\",\"en\":\"Laos\",\"phone_code\":\"+856\"},\n"
        + "{\"cn\":\"拉脱维亚\",\"en\":\"Latvia\",\"phone_code\":\"+371\"},\n"
        + "{\"cn\":\"黎巴嫩\",\"en\":\"Lebanon\",\"phone_code\":\"+961\"},\n"
        + "{\"cn\":\"莱索托\",\"en\":\"Lesotho\",\"phone_code\":\"+266\"},\n"
        + "{\"cn\":\"利比里亚\",\"en\":\"Liberia\",\"phone_code\":\"+231\"},\n"
        + "{\"cn\":\"利比亚\",\"en\":\"Libya\",\"phone_code\":\"+218\"},\n"
        + "{\"cn\":\"列支敦士登\",\"en\":\"Liechtenstein\",\"phone_code\":\"+423\"},\n"
        + "{\"cn\":\"立陶宛\",\"en\":\"Lithuania\",\"phone_code\":\"+370\"},\n"
        + "{\"cn\":\"卢森堡\",\"en\":\"Luxembourg\",\"phone_code\":\"+352\"},\n"
        + "{\"cn\":\"澳门\",\"en\":\"Macao\",\"phone_code\":\"+853\"},\n"
        + "{\"cn\":\"前南马其顿\",\"en\":\"The Former Yugoslav Republic of Macedonia\",\"phone_code\":\"+389\"},\n"
        + "{\"cn\":\"马达加斯加\",\"en\":\"Madagascar\",\"phone_code\":\"+261\"},\n"
        + "{\"cn\":\"马拉维\",\"en\":\"Malawi\",\"phone_code\":\"+265\"},\n"
        + "{\"cn\":\"马来西亚\",\"en\":\"Malaysia\",\"phone_code\":\"+60\"},\n"
        + "{\"cn\":\"马尔代夫\",\"en\":\"Maldives\",\"phone_code\":\"+960\"},\n"
        + "{\"cn\":\"马里\",\"en\":\"Mali\",\"phone_code\":\"+223\"},\n"
        + "{\"cn\":\"马耳他\",\"en\":\"Malta\",\"phone_code\":\"+356\"},\n"
        + "{\"cn\":\"马绍尔群岛\",\"en\":\"Marshall Islands\",\"phone_code\":\"+692\"},\n"
        + "{\"cn\":\"马提尼克\",\"en\":\"Martinique\",\"phone_code\":\"+596\"},\n"
        + "{\"cn\":\"毛里塔尼亚\",\"en\":\"Mauritania\",\"phone_code\":\"+222\"},\n"
        + "{\"cn\":\"毛里求斯\",\"en\":\"Mauritius\",\"phone_code\":\"+230\"},\n"
        + "{\"cn\":\"马约特\",\"en\":\"Mayotte\",\"phone_code\":\"+269\"},\n"
        + "{\"cn\":\"墨西哥\",\"en\":\"Mexico\",\"phone_code\":\"+52\"},\n"
        + "{\"cn\":\"密克罗尼西亚\",\"en\":\"Federated States of Micronesia\",\"phone_code\":\"+691\"},\n"
        + "{\"cn\":\"摩尔多瓦\",\"en\":\"Moldova\",\"phone_code\":\"+373\"},\n"
        + "{\"cn\":\"摩纳哥\",\"en\":\"Monaco\",\"phone_code\":\"+377\"},\n"
        + "{\"cn\":\"蒙古\",\"en\":\"Mongolia\",\"phone_code\":\"+976\"},\n"
        + "{\"cn\":\"蒙特塞拉特\",\"en\":\"Montserrat\",\"phone_code\":\"+1664\"},\n"
        + "{\"cn\":\"摩洛哥\",\"en\":\"Morocco\",\"phone_code\":\"+212\"},\n"
        + "{\"cn\":\"莫桑比克\",\"en\":\"Mozambique\",\"phone_code\":\"+258\"},\n"
        + "{\"cn\":\"纳米尼亚\",\"en\":\"Namibia\",\"phone_code\":\"+264\"},\n"
        + "{\"cn\":\"瑙鲁\",\"en\":\"Nauru\",\"phone_code\":\"+674\"},\n"
        + "{\"cn\":\"尼泊尔\",\"en\":\"Nepal\",\"phone_code\":\"+977\"},\n"
        + "{\"cn\":\"荷兰\",\"en\":\"Netherlands\",\"phone_code\":\"+31\"},\n"
        + "{\"cn\":\"荷属安的列斯\",\"en\":\"Netherlands Antilles\",\"phone_code\":\"+599\"},\n"
        + "{\"cn\":\"新喀里多尼亚\",\"en\":\"New Caledonia\",\"phone_code\":\"+687\"},\n"
        + "{\"cn\":\"新西兰\",\"en\":\"New Zealand\",\"phone_code\":\"+64\"},\n"
        + "{\"cn\":\"尼加拉瓜\",\"en\":\"Nicaragua\",\"phone_code\":\"+505\"},\n"
        + "{\"cn\":\"尼日尔\",\"en\":\"Niger\",\"phone_code\":\"+227\"},\n"
        + "{\"cn\":\"尼日利亚\",\"en\":\"Nigeria\",\"phone_code\":\"+234\"},\n"
        + "{\"cn\":\"纽埃\",\"en\":\"Niue\",\"phone_code\":\"+683\"},\n"
        + "{\"cn\":\"诺福克岛\",\"en\":\"Norfolk Island\",\"phone_code\":\"+6723\"},\n"
        + "{\"cn\":\"北马里亚纳\",\"en\":\"Northern Mariana Islands\",\"phone_code\":\"+1\"},\n"
        + "{\"cn\":\"挪威\",\"en\":\"Norway\",\"phone_code\":\"+47\"},\n"
        + "{\"cn\":\"阿曼\",\"en\":\"Oman\",\"phone_code\":\"+968\"},\n"
        + "{\"cn\":\"巴基斯坦\",\"en\":\"Pakistan\",\"phone_code\":\"+92\"},\n"
        + "{\"cn\":\"帕劳\",\"en\":\"Palau\",\"phone_code\":\"+680\"},\n"
        + "{\"cn\":\"巴拿马\",\"en\":\"Panama\",\"phone_code\":\"+507\"},\n"
        + "{\"cn\":\"巴布亚新几内亚\",\"en\":\"Papua New Guinea\",\"phone_code\":\"+675\"},\n"
        + "{\"cn\":\"巴拉圭\",\"en\":\"Paraguay\",\"phone_code\":\"+595\"},\n"
        + "{\"cn\":\"秘鲁\",\"en\":\"Peru\",\"phone_code\":\"+51\"},\n"
        + "{\"cn\":\"菲律宾\",\"en\":\"Philippines\",\"phone_code\":\"+63\"},\n"
        + "{\"cn\":\"波兰\",\"en\":\"Poland\",\"phone_code\":\"+48\"},\n"
        + "{\"cn\":\"葡萄牙\",\"en\":\"Portugal\",\"phone_code\":\"+351\"},\n"
        + "{\"cn\":\"波多黎各\",\"en\":\"Puerto Rico\",\"phone_code\":\"+1809\"},\n"
        + "{\"cn\":\"卡塔尔\",\"en\":\"Qatar\",\"phone_code\":\"+974\"},\n"
        + "{\"cn\":\"留尼汪\",\"en\":\"Reunion\",\"phone_code\":\"+262\"},\n"
        + "{\"cn\":\"罗马尼亚\",\"en\":\"Romania\",\"phone_code\":\"+40\"},\n"
        + "{\"cn\":\"俄罗斯\",\"en\":\"Russia\",\"phone_code\":\"+7\"},\n"
        + "{\"cn\":\"卢旺达\",\"en\":\"Rwanda\",\"phone_code\":\"+250\"},\n"
        + "{\"cn\":\"圣赫勒拿\",\"en\":\"Saint Helena\",\"phone_code\":\"+290\"},\n"
        + "{\"cn\":\"圣基茨和尼维斯\",\"en\":\"Saint Kitts and Nevis\",\"phone_code\":\"+1869\"},\n"
        + "{\"cn\":\"圣卢西亚\",\"en\":\"Saint Lucia\",\"phone_code\":\"+1758\"},\n"
        + "{\"cn\":\"圣皮埃尔和密克隆\",\"en\":\"Saint Pierre and Miquelon\",\"phone_code\":\"+508\"},\n"
        + "{\"cn\":\"圣文森特和格林纳丁斯\",\"en\":\"Saint Vincent and the Grenadines\",\"phone_code\":\"+1784\"},\n"
        + "{\"cn\":\"萨摩亚\",\"en\":\"Samoa\",\"phone_code\":\"+685\"},\n"
        + "{\"cn\":\"圣马力诺\",\"en\":\"San Marino\",\"phone_code\":\"+378\"},\n"
        + "{\"cn\":\"圣多美和普林西比\",\"en\":\"Sao Tome and Principe\",\"phone_code\":\"+239\"},\n"
        + "{\"cn\":\"沙特阿拉伯\",\"en\":\"Saudi Arabia\",\"phone_code\":\"+966\"},\n"
        + "{\"cn\":\"塞内加尔\",\"en\":\"Senegal\",\"phone_code\":\"+221\"},\n"
        + "{\"cn\":\"塞尔维亚和黑山\",\"en\":\"Serbia and Montenegro\",\"phone_code\":\"+381\"},\n"
        + "{\"cn\":\"塞舌尔\",\"en\":\"Seychelles\",\"phone_code\":\"+248\"},\n"
        + "{\"cn\":\"塞拉利\",\"en\":\"Sierra Leone\",\"phone_code\":\"+232\"},\n"
        + "{\"cn\":\"新加坡\",\"en\":\"Singapore\",\"phone_code\":\"+65\"},\n"
        + "{\"cn\":\"斯洛伐克\",\"en\":\"Slovakia\",\"phone_code\":\"+421\"},\n"
        + "{\"cn\":\"斯洛文尼亚\",\"en\":\"Slovenia\",\"phone_code\":\"+386\"},\n"
        + "{\"cn\":\"所罗门群岛\",\"en\":\"Solomon Islands\",\"phone_code\":\"+677\"},\n"
        + "{\"cn\":\"索马里\",\"en\":\"Somalia\",\"phone_code\":\"+252\"},\n"
        + "{\"cn\":\"南非\",\"en\":\"South Africa\",\"phone_code\":\"+27\"},\n"
        + "{\"cn\":\"西班牙\",\"en\":\"Spain\",\"phone_code\":\"+34\"},\n"
        + "{\"cn\":\"斯里兰卡\",\"en\":\"Sri Lanka\",\"phone_code\":\"+94\"},\n"
        + "{\"cn\":\"苏丹\",\"en\":\"Sudan\",\"phone_code\":\"+249\"},\n"
        + "{\"cn\":\"苏里南\",\"en\":\"Suriname\",\"phone_code\":\"+597\"},\n"
        + "{\"cn\":\"斯瓦尔巴岛和扬马延岛\",\"en\":\"Svalbard\",\"phone_code\":\"+47\"},\n"
        + "{\"cn\":\"斯威士兰\",\"en\":\"Swaziland\",\"phone_code\":\"+268\"},\n"
        + "{\"cn\":\"瑞典\",\"en\":\"Sweden\",\"phone_code\":\"+46\"},\n"
        + "{\"cn\":\"瑞士\",\"en\":\"Switzerland\",\"phone_code\":\"+41\"},\n"
        + "{\"cn\":\"叙利亚\",\"en\":\"Syria\",\"phone_code\":\"+963\"},\n"
        + "{\"cn\":\"台湾\",\"en\":\"Taiwan\",\"phone_code\":\"+886\"},\n"
        + "{\"cn\":\"塔吉克斯坦\",\"en\":\"Tajikistan\",\"phone_code\":\"+992\"},\n"
        + "{\"cn\":\"坦桑尼亚\",\"en\":\"Tanzania\",\"phone_code\":\"+255\"},\n"
        + "{\"cn\":\"泰国\",\"en\":\"Thailand\",\"phone_code\":\"+66\"},\n"
        + "{\"cn\":\"巴哈马\",\"en\":\"The Bahamas\",\"phone_code\":\"+1242\"},\n"
        + "{\"cn\":\"冈比亚\",\"en\":\"The Gambia\",\"phone_code\":\"+220\"},\n"
        + "{\"cn\":\"多哥\",\"en\":\"Togo\",\"phone_code\":\"+228\"},\n"
        + "{\"cn\":\"托克劳\",\"en\":\"Tokelau\",\"phone_code\":\"+690\"},\n"
        + "{\"cn\":\"汤加\",\"en\":\"Tonga\",\"phone_code\":\"+676\"},\n"
        + "{\"cn\":\"特立尼达和多巴哥\",\"en\":\"Trinidad and Tobago\",\"phone_code\":\"+1868\"},\n"
        + "{\"cn\":\"突尼斯\",\"en\":\"Tunisia\",\"phone_code\":\"+216\"},\n"
        + "{\"cn\":\"土耳其\",\"en\":\"Turkey\",\"phone_code\":\"+90\"},\n"
        + "{\"cn\":\"土库曼斯坦\",\"en\":\"Turkmenistan\",\"phone_code\":\"+993\"},\n"
        + "{\"cn\":\"特克斯和凯科斯群岛\",\"en\":\"Turks and Caicos Islands\",\"phone_code\":\"+1649\"},\n"
        + "{\"cn\":\"图瓦卢\",\"en\":\"Tuvalu\",\"phone_code\":\"+688\"},\n"
        + "{\"cn\":\"乌干达\",\"en\":\"Uganda\",\"phone_code\":\"+256\"},\n"
        + "{\"cn\":\"乌克兰\",\"en\":\"Ukraine\",\"phone_code\":\"+380\"},\n"
        + "{\"cn\":\"阿拉伯联合酋长国\",\"en\":\"United Arab Emirates\",\"phone_code\":\"+971\"},\n"
        + "{\"cn\":\"英国\",\"en\":\"United Kingdom\",\"phone_code\":\"+44\"},\n"
        + "{\"cn\":\"美国\",\"en\":\"United States\",\"phone_code\":\"+1\"},\n"
        + "{\"cn\":\"乌拉圭\",\"en\":\"Uruguay\",\"phone_code\":\"+598\"},\n"
        + "{\"cn\":\"乌兹别克斯坦\",\"en\":\"Uzbekistan\",\"phone_code\":\"+998\"},\n"
        + "{\"cn\":\"瓦努阿图\",\"en\":\"Vanuatu\",\"phone_code\":\"+678\"},\n"
        + "{\"cn\":\"委内瑞拉\",\"en\":\"Venezuela\",\"phone_code\":\"+58\"},\n"
        + "{\"cn\":\"越南\",\"en\":\"Vietnam\",\"phone_code\":\"+84\"},\n"
        + "{\"cn\":\"美属维尔京群岛\",\"en\":\"Virgin Islands\",\"phone_code\":\"+1340\"},\n"
        + "{\"cn\":\"瓦利斯和富图纳\",\"en\":\"Wallis and Futuna\",\"phone_code\":\"+681\"},\n"
        + "{\"cn\":\"也门\",\"en\":\"Yemen\",\"phone_code\":\"+967\"},\n"
        + "{\"cn\":\"赞比亚\",\"en\":\"Zambia\",\"phone_code\":\"+260\"},\n"
        + "{\"cn\":\"津巴布韦\",\"en\":\"Zimbabwe\",\"phone_code\":\"+263\"}]";
    JSONArray array = JSONUtil.parseArray(json);
    List<Map> maps = JSONUtil.toList(array, Map.class);
    System.out.println(maps.get(0).get("en"));
    for (int i = 0; i < 10; i++) {
      InsertCountryCodeDTO dto = new InsertCountryCodeDTO(IdUtil.randomUUID(),
          (String) maps.get(i).get("cn"), (String) maps.get(i).get("en"),
          (String) maps.get(i).get("phone_code"));
      System.out.println(dto);
    }
  }
}
