package com.gre.cloudpicturebackend.api.aliyunai;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.gre.cloudpicturebackend.api.aliyunai.model.CreateOutPaintingTaskRequest;
import com.gre.cloudpicturebackend.api.aliyunai.model.CreateOutPaintingTaskResponse;
import com.gre.cloudpicturebackend.api.aliyunai.model.GetOutPaintingTaskResponse;
import com.gre.cloudpicturebackend.exception.BusinessException;
import com.gre.cloudpicturebackend.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AliYunAiApi {

    @Value("${aliYunAi.apiKey}")
    private String apiKey;

    // 创建任务地址
    public static final String CREATE_OUT_PAINTING_TASK_URL = "https://dashscope.aliyuncs.com/api/v1/services/aigc/image2image/out-painting";

    // 查询任务状态
    public static final String GET_OUT_PAINTING_TASK_URL = "https://dashscope.aliyuncs.com/api/v1/tasks/%s";

    /**
     * 创建任务
     */
    public CreateOutPaintingTaskResponse createOutPaintingTask(CreateOutPaintingTaskRequest request) {
        if (request == null) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "扩图参数为空");
        }
        // 发送请求
        HttpRequest httpRequest = HttpRequest.post(CREATE_OUT_PAINTING_TASK_URL)
                .header("Authorization", "Bearer " + apiKey)
                // 必须开启异步处理
                .header("X-DashScope-Async", "enable")
                .header("Content-Type", "application/json")
                .body(JSONUtil.toJsonStr(request));
        // 处理响应
        try (HttpResponse response = httpRequest.execute()) {
            if (!response.isOk()) {
                log.error("请求异常：{}", response.body());
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "AI 扩图失败");
            }
            CreateOutPaintingTaskResponse createOutPaintingTaskResponse = JSONUtil.toBean(response.body(), CreateOutPaintingTaskResponse.class);
            if (createOutPaintingTaskResponse.getCode() != null) {
                String message = createOutPaintingTaskResponse.getMessage();
                log.error("请求异常：{}", message);
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "AI 扩图失败，" + message);
            }
            return createOutPaintingTaskResponse;
        }
    }

    /**
     * 查询创建的任务结果
     */
    public GetOutPaintingTaskResponse getOutPaintingTask(String taskId) {
        if (taskId == null) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "任务ID不能为空");
        }
        String url = String.format(GET_OUT_PAINTING_TASK_URL, taskId);
        try (HttpResponse response = HttpRequest.get(url)
                .header("Authorization", "Bearer " + apiKey)
                .execute()) {
            if (!response.isOk()) {
                log.error("请求异常：{}", response.body());
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "获取任务结果失败");
            }
            return JSONUtil.toBean(response.body(), GetOutPaintingTaskResponse.class);
        }
    }
}
