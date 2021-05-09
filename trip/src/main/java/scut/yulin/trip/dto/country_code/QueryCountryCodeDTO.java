package scut.yulin.trip.dto.country_code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.trip.dto.PageQueryDTO;

/**
 * @Date 2021/5/3
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryCountryCodeDTO extends PageQueryDTO {

  /**
   * uuid
   */
  private String uuid;

  /**
   * 中文名
   */
  private String cn;

  /**
   * 英文名
   */
  private String en;

  /**
   * 电话前缀
   */
  private String phoneCode;
}
