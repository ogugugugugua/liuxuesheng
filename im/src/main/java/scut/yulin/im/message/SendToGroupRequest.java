package scut.yulin.im.message;

/**
 * 发送给指定群组的群聊消息的 Message
 */
public class SendToGroupRequest implements Message {

  public static final String TYPE = "SEND_TO_GROUP_REQUEST";

  /**
   * 消息编号
   */
  private String msgId;
  /**
   * 群组编号
   */
  private String groupId;
  /**
   * 内容
   */
  private String content;
  /**
   * 昵称
   */
  private String nickName;

  public String getContent() {
    return content;
  }

  public SendToGroupRequest setContent(String content) {
    this.content = content;
    return this;
  }

  public String getMsgId() {
    return msgId;
  }

  public SendToGroupRequest setMsgId(String msgId) {
    this.msgId = msgId;
    return this;
  }

  public static String getTYPE() {
    return TYPE;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
}
