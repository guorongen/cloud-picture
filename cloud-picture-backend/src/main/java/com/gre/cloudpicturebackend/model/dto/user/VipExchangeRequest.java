package com.gre.cloudpicturebackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class VipExchangeRequest implements Serializable {

    private static final long serialVersionUID = -8302342077170899917L;

    private Long userId;

    private String vipCode;
}
