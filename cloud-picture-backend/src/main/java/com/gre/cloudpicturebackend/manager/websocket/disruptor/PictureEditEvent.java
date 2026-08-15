package com.gre.cloudpicturebackend.manager.websocket.disruptor;

import com.gre.cloudpicturebackend.manager.websocket.model.PictureEditRequestMessage;
import com.gre.cloudpicturebackend.model.entity.User;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

/**
 * 图片编辑事件
 */
@Data
public class PictureEditEvent {

    /**
     * 消息
     */
    private PictureEditRequestMessage pictureEditRequestMessage;

    /**
     * 当前用户的session
     */
    private WebSocketSession session;

    /**
     * 当前用户
     */
    private User user;

    /**
     * 图片id
     */
    private Long pictureId;
}
