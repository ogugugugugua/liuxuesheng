package scut.yulin.trip.dto.country_code;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Date 2021/5/3
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@NoArgsConstructor
@ToString
public class InsertCountryCodeDTO {
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

  public InsertCountryCodeDTO(String uuid, String cn, String en, String phone_code) {
    this.uuid = uuid;
    this.cn = cn;
    this.en = en;
    this.phoneCode = phone_code;
  }
}
