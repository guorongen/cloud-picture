package com.gre.cloudpicturebackend.model.dto.user;

import com.gre.cloudpicturebackend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户查询请求
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQueryRequest extends PageRequest implements Serializable {

    private Long id;

    private String userName;

    private String userAccount;

    private String userProfile;

    private String userRole;

    private static final long serialVersionUID = 1L;
}
