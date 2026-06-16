package com.gre.cloudpicturebackend.vo;

import cn.hutool.core.bean.BeanUtil;
import com.gre.cloudpicturebackend.model.entity.SpaceUser;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SpaceUserVO implements Serializable {

    private static final long serialVersionUID = -4551295572258737716L;

    private Long id;

    private Long spaceId;

    private Long userId;

    private String spaceRole;

    private Date createTime;

    private Date updateTime;

    private UserVO user;

    private SpaceVO space;

    public static SpaceUser voToObj(SpaceUserVO spaceUserVO) {
        if (spaceUserVO == null) {
            return null;
        }
        SpaceUser spaceUser = new SpaceUser();
        BeanUtil.copyProperties(spaceUserVO, spaceUser);
        return spaceUser;
    }

    public static SpaceUserVO objToVo(SpaceUser spaceUser) {
        if (spaceUser == null) {
            return null;
        }
        SpaceUserVO spaceUserVO = new SpaceUserVO();
        BeanUtil.copyProperties(spaceUser, spaceUserVO);
        return spaceUserVO;
    }
}
