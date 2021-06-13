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
 * @Description 社交系统中的游记
 **/
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Blog {

  @Id
  private String uuid;

  @Indexed
  private String travelerUuid;
  @Indexed
  private String tripUuid;
  @Indexed
  private String studentUuid;

  private String title;
  private String content;

  private Double tripPrice;
  private String classification;
  private Date departTime;
  private Integer duration;
  private Boolean publicBlog;
  private Boolean original;
  private String status;
  private Integer likes;
  private List<String> comments;
  private Integer viewCounts;

  private Date createTime;
  private Date updateTime;
  private Boolean deleted;
}
