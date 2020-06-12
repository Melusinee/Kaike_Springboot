package com.kaike.eduservice.service;

import com.kaike.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaike.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author Melusine
 * @since 2020-05-28
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);

    List<OneSubject> getAllOneTwoSubject();
}
