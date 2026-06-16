package com.gre.cloudpicturebackend.manager.auth;

import com.gre.cloudpicturebackend.model.entity.Picture;
import com.gre.cloudpicturebackend.model.entity.Space;
import com.gre.cloudpicturebackend.model.entity.SpaceUser;
import lombok.Data;

@Data
public class SpaceUserAuthContext {

    /**
     * 临时参数，不同请求对应的id可能不同
     */
    private Long id;

    /**
     * 图片id
     */
    private Long pictureId;

    /**
     * 空间id
     */
    private Long spaceId;

    /**
     * 空间用户id
     */
    private Long spaceUserId;

    /**
     * 图片信息
     */
    private Picture picture;

    /**
     * 空间信息
     */
    private Space space;

    /**
     * 空间用户信息
     */
    private SpaceUser spaceUser;
}
