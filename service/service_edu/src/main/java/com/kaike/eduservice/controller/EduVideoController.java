package com.kaike.eduservice.controller;


import com.kaike.commonutils.R;
import com.kaike.eduservice.client.VodClient;
import com.kaike.eduservice.entity.EduVideo;
import com.kaike.eduservice.service.EduVideoService;
import com.kaike.servicebase.exceptionhandler.KaikeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author Melusine
 * @since 2020-05-30
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    // 注入vodclient
    @Autowired
    private VodClient vodClient;

    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        eduVideoService.save(eduVideo);
        return R.ok();
    }

    // 删小节的时候，同时把阿里云的视频删除
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id){
        // 根据小节id获取视频id
        EduVideo video = eduVideoService.getById(id);
        String videoSourceId = video.getVideoSourceId();

        if(StringUtils.isEmpty(videoSourceId)){
            R result = vodClient.removeAlyVideo(videoSourceId);
            if(result.getCode() == 20001){
                throw new KaikeException(20001,"删除视频失败，熔断器");
            }
        }

        eduVideoService.removeById(id);
        return R.ok();
    }

}

