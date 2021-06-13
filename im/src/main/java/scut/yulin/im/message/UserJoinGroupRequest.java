package scut.yulin.im.message;

/**
 * 用户加入指定群聊的请求Message
 */
public class UserJoinGroupRequest implements Message {

  public static final String TYPE = "USER_JOIN_GROUP_NOTICE_REQUEST";

  /**
   * 昵称
   */
  private String nickname;
  /**
   * 组id
   */
  private String groupId;

  public String getNickname() {
    return nickname;
  }

  public UserJoinGroupRequest setNickname(String nickname) {
    this.nickname = nickname;
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
}
