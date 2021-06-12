package scut.yulin.im.message;

/**
 * 用户加入指定群组响应
 */
public class UserJoinGroupNoticeResponse implements Message {

  public static final String TYPE = "USER_JOIN_GROUP_RESPONSE";

  /**
   * 响应状态码
   */
  private Integer code;
  /**
   * 响应提示
   */
  private String message;

  public Integer getCode() {
    return code;
  }

  public UserJoinGroupNoticeResponse setCode(Integer code) {
    this.code = code;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public UserJoinGroupNoticeResponse setMessage(String message) {
    this.message = message;
    return this;
  }

}
