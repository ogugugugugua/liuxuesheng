package scut.yulin.im.handler;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import scut.yulin.im.message.SendResponse;
import scut.yulin.im.message.SendToUserRequest;
import scut.yulin.im.message.UpdateTripInfoRequest;
import scut.yulin.im.util.WebSocketUtil;
import scut.yulin.trip.dto.trip.QueryTripDTO;
import scut.yulin.trip.service.TripService;

/**
 * @Date 2021/6/11
 * @Author xieyulin
 * @Description 更新行程请求handler
 **/
@Component
public class UpdateTripInfoRequestHandler implements MessageHandler<UpdateTripInfoRequest> {

  @Autowired
  private TripService tripService;

  @Override
  public void execute(WebSocketSession session, UpdateTripInfoRequest message) {
    // 这里，假装直接成功
    SendResponse sendResponse = new SendResponse().setMsgId(message.getMsgId()).setCode(0);
    WebSocketUtil.send(session, SendResponse.TYPE, sendResponse);

    // 根据tripUUID在数据库中查找对应的旅程信息
    String tripInfo = JSONUtil
        .parseObj(tripService.getTripByUUID(new QueryTripDTO(message.getTripUuid()), true))
        .toJSONString(2);
    // 创建转发的消息
    SendToUserRequest sendToUserRequest = new SendToUserRequest().setMsgId(message.getMsgId())
        .setContent(tripInfo);
    // 发送回给自己
    WebSocketUtil.send(session, SendToUserRequest.TYPE, sendToUserRequest);
  }

  @Override
  public String getType() {
    return UpdateTripInfoRequest.TYPE;
  }
}
