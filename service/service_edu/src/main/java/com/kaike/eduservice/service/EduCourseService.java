package com.kaike.eduservice.service;

import com.kaike.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaike.eduservice.entity.vo.CourseInfoVo;
import com.kaike.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Melusine
 * @since 2020-05-30
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);
}
