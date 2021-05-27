package scut.yulin.portal;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 旅客浏览行程历史
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelerReadHistory {

  @Id
  private String uuid;

  @Indexed
  private String travelerUuid;
  @Indexed
  private String tripUuid;
  @Indexed
  private String studentUuid;

  private String travelerName;
  private Double tripPrice;
  private String title;
  private String description;
  private String classification;
  private Date departTime;
  private Integer duration;

  private Date createTime;

}
