package com.kaike.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaike.commonutils.R;
import com.kaike.eduservice.entity.EduCourse;
import com.kaike.eduservice.entity.EduTeacher;
import com.kaike.eduservice.service.EduCourseService;
import com.kaike.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eduservice/indexfront")
@CrossOrigin
public class IndexFrontController {

    @Autowired
    private EduCourseService eduCourseService;

    @Autowired
    private EduTeacherService eduTeacherService;

    // 查询前8条热门课程，前4个名师
    @GetMapping("index")
    public R index(){
        // 查询前8个热门课程
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        wrapper.last("limit 8");
        List<EduCourse> list = eduCourseService.list(wrapper);

        QueryWrapper<EduTeacher> wrapper2 = new QueryWrapper<>();
        wrapper2.orderByDesc("id");
        wrapper.last("limit 4");
        List<EduTeacher> list2 = eduTeacherService.list(wrapper2);

        return R.ok().data("eduList",list).data("teacherList",list2);
    }

}
