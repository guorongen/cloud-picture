package com.gre.cloudpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gre.cloudpicturebackend.model.dto.picture.PictureQueryRequest;
import com.gre.cloudpicturebackend.model.dto.picture.PictureReviewRequest;
import com.gre.cloudpicturebackend.model.dto.picture.PictureUploadByBatchRequest;
import com.gre.cloudpicturebackend.model.dto.picture.PictureUploadRequest;
import com.gre.cloudpicturebackend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gre.cloudpicturebackend.model.entity.User;
import com.gre.cloudpicturebackend.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author Administrator
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-11-17 21:24:28
*/
public interface PictureService extends IService<Picture> {

    /**
     * 校验图片
     *
     * @param picture
     */
    void validPicture(Picture picture);

    /**
     * 上传图片
     *
     * @param inputSource
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(Object inputSource, PictureUploadRequest pictureUploadRequest, User loginUser);

    /**
     * 获取脱敏后的图片数据
     *
     * @param picture
     * @param request
     * @return
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    /**
     * 分页获取脱敏后的图片列表
     *
     * @param picturePage
     * @param request
     * @return
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    /**
     * 获取查询对象
     * @param pictureQueryRequest
     * @return
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    /**
     * 填充审核参数
     *
     * @param picture
     * @param loginUser
     */
    void fillReviewParams(Picture picture, User loginUser);

    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest
     * @param loginUser
     * @return
     */
    Integer uploadPictureByBatch(PictureUploadByBatchRequest pictureUploadByBatchRequest, User loginUser);

    /**
     * 清理图片
     * @param oldPicture
     */
    void clearPictureFile(Picture oldPicture);
}
