package com.gre.cloudpicturebackend.vo.space.analyze;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceUserAnalyzeResponse implements Serializable {

    private static final long serialVersionUID = -4315906260301729512L;

    /**
     * 时间区间
     */
    private String period;

    /**
     * 上传数量
     */
    private Long count;
}
