package com.gre.cloudpicturebackend.vo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.gre.cloudpicturebackend.model.entity.Picture;
import com.gre.cloudpicturebackend.model.entity.Space;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 空间视图
 */
@Data
public class SpaceVO implements Serializable {

    private static final long serialVersionUID = -1368083350601741138L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long userId;

    private String spaceName;

    private Integer spaceLevel;

    private Integer spaceType;

    private Long maxSize;

    private Long maxCount;

    private Long totalSize;

    private Long totalCount;

    private Date createTime;

    private Date editTime;

    private Date updateTime;

    private UserVO user;

    /**
     * 权限列表
     */
    private List<String> permissionList = new ArrayList<>();

    /**
     * 封装类转对象
     */
    private static Space voToObj(SpaceVO spaceVO) {
        if (spaceVO == null) {
            return null;
        }
        Space space = new Space();
        BeanUtil.copyProperties(spaceVO, space);
        return space;
    }

    /**
     * 对象转封装类
     */
    public static SpaceVO objToVo(Space space) {
        if (space == null) {
            return null;
        }
        SpaceVO spaceVO = new SpaceVO();
        BeanUtil.copyProperties(space, spaceVO);
        return spaceVO;
    }
}
