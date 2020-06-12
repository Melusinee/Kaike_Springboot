package com.kaike.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaike.eduservice.entity.EduCourse;
import com.kaike.eduservice.entity.EduCourseDescription;
import com.kaike.eduservice.entity.vo.CourseInfoVo;
import com.kaike.eduservice.entity.vo.CoursePublishVo;
import com.kaike.eduservice.mapper.EduCourseMapper;
import com.kaike.eduservice.service.EduChapterService;
import com.kaike.eduservice.service.EduCourseDescriptionService;
import com.kaike.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaike.eduservice.service.EduVideoService;
import com.kaike.servicebase.exceptionhandler.KaikeException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Melusine
 * @since 2020-05-30
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    @Autowired
    private EduVideoService eduVideoService;

    @Autowired
    private EduChapterService chapterService;

    @Override
//    @Cacheable(value = "courseInfo",key = "'getCourseInfoVo'")
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
         // 1. 向课程表添加课程基本信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int insert = baseMapper.insert(eduCourse);

        if(insert <= 0){
         throw new KaikeException(20001,"添加课程信息失败");
        }

        String cid = eduCourse.getId();

        // 2. 向课程简介表添加课程简介
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(courseInfoVo.getDescription());
        eduCourseDescription.setId(cid);
        courseDescriptionService.save(eduCourseDescription);
        return cid;
    }

    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        EduCourse eduCourse = baseMapper.selectById(courseId);
        EduCourseDescription courseDescription = courseDescriptionService.getById(courseId);

        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(eduCourse,courseInfoVo);
        courseInfoVo.setDescription(courseDescription.getDescription());
        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int update = baseMapper.updateById(eduCourse);
        if(update == 0){
            throw new KaikeException(20001,"修改信息失败");
        }

        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setId(courseInfoVo.getId());
        eduCourseDescription.setDescription(courseInfoVo.getDescription());
        courseDescriptionService.updateById(eduCourseDescription);
    }

    @Override
    public CoursePublishVo publishCourseInfo(String id) {
        return baseMapper.getPublishCourseInfo(id);
    }

    @Override
    public void removeCourse(String courseId) {
        // 1. 删除小节
        eduVideoService.removeVideoByCourseId(courseId);
        // 2. 删除章节
        chapterService.removeChapterByCourseId(courseId);
        // 3. 删除描述
        courseDescriptionService.removeById(courseId);
        // 4. 删除课程本身
        int result = baseMapper.deleteById(courseId);
//        System.out.println(result);
        if(result == 0){
            throw new KaikeException(20001,"删除失败");
        }
    }
}
