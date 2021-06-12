package scut.yulin.im.handler;


import com.alibaba.druid.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import scut.yulin.im.message.SendResponse;
import scut.yulin.im.message.SendToGroupRequest;
import scut.yulin.im.message.UserJoinGroupNoticeResponse;
import scut.yulin.im.util.WebSocketUtil;

@Component
public class SendToGroupHandler implements MessageHandler<SendToGroupRequest> {

  @Override
  public void execute(WebSocketSession session, SendToGroupRequest message) {

    if (StringUtils.isEmpty(message.getGroupId())) {
      WebSocketUtil.send(session, SendResponse.TYPE,
          new UserJoinGroupNoticeResponse().setCode(0).setMessage("GroupId未传入"));
      return;
    }
    String currentUser = WebSocketUtil.getCurrentUser(session);
    message.setNickName(currentUser);
    // 通知消息已收到
    SendResponse sendResponse = new SendResponse().setMsgId(message.getMsgId()).setCode(0);
    WebSocketUtil.send(session, SendResponse.TYPE, sendResponse);
    // 在组内广播
    WebSocketUtil.broadcastInGroup(message.getGroupId(), message.getTYPE(), message);
  }

  @Override
  public String getType() {
    return SendToGroupRequest.TYPE;
  }

}
