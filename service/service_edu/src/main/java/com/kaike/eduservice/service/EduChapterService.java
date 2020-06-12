package com.kaike.eduservice.service;

import com.kaike.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaike.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Melusine
 * @since 2020-05-30
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
