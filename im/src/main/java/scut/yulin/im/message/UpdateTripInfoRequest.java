package scut.yulin.im.message;

/**
 * @Date 2021/6/11
 * @Author xieyulin
 * @Description 客户端向服务器请求更新其行程Request
 **/
public class UpdateTripInfoRequest implements Message {

  public static final String TYPE = "UPDATE_TRIP_INFO_REQUEST";

  /**
   * 请求旅程的uuid
   */
  private String tripUuid;

  /**
   * 消息编号
   */
  private String msgId;

  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

  public String getTripUuid() {
    return tripUuid;
  }

  public UpdateTripInfoRequest setTripUuid(String tripUuid) {
    this.tripUuid = tripUuid;
    return this;
  }
}
