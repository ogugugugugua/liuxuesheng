package scut.yulin.trip.model.social;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Date 2021/6/13
 * @Author xieyulin
 * @Description 旅行状态说说
 **/
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripStatus {

  @Id
  private String uuid;

  @Indexed
  private String userUuid;
  @Indexed
  private String tripUuid;
  private String userType;

  private String country;
  private String city;
  private String location;
  private String mood;
  private String content;

  private Integer likes;
  private List<String> comments;
  private Integer viewCounts;

  private Date createTime;
  private Boolean deleted;
}
