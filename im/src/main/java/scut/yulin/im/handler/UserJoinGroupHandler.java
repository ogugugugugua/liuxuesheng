package scut.yulin.im.handler;


import com.alibaba.druid.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import scut.yulin.im.message.SendResponse;
import scut.yulin.im.message.UserJoinGroupNoticeResponse;
import scut.yulin.im.message.UserJoinGroupRequest;
import scut.yulin.im.util.WebSocketUtil;

@Component
public class UserJoinGroupHandler implements MessageHandler<UserJoinGroupRequest> {

  @Override
  public void execute(WebSocketSession session, UserJoinGroupRequest message) {

    if (StringUtils.isEmpty(message.getGroupId())) {
      WebSocketUtil.send(session, SendResponse.TYPE,
          new UserJoinGroupNoticeResponse().setCode(0).setMessage("GroupId未传入"));
      return;
    }
    String currentUser = WebSocketUtil.getCurrentUser(session);
    // 通知消息已收到
    WebSocketUtil.send(session, SendResponse.TYPE, new UserJoinGroupNoticeResponse().setCode(0));
    // 添加到组里
    WebSocketUtil.addGroupSession(message.getGroupId(), session, currentUser);
    // 通知组员
    WebSocketUtil.broadcastInGroup(message.getGroupId(), UserJoinGroupRequest.TYPE,
        new UserJoinGroupRequest().setNickname(currentUser));
  }

  @Override
  public String getType() {
    return UserJoinGroupRequest.TYPE;
  }

}
