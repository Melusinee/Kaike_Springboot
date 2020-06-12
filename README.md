# Kiake_Springboot
# 在线教育机构后台管理系统
这个项目是模仿https://www.bilibili.com/video/BV1y7411y7am?t=3&p=178 这个教程所做出来的在线教育机构后台管理系统。
所有前端代码均为教程提供，仅跟随教程进行了vue的修改

# 后端功能：
## 侧边菜单栏 
   效果图：https://github.com/Melusinee/Kaike_Springboot/blob/master/image-folder/%E4%BE%A7%E8%BE%B9%E6%A0%8F.PNG"
## 讲师管理：
   * 讲师列表：列出讲师，且根据条件查询相应讲师 <br>
      效果图：https://github.com/Melusinee/Kaike_Springboot/blob/master/image-folder/%E8%AE%B2%E5%B8%88%E5%88%97%E8%A1%A8.PNG
   * 添加讲师: 在表单内填写讲师名称和信息等，提交后即可加入数据库内<br>
      效果图：https://github.com/Melusinee/Kaike_Springboot/blob/master/image-folder/%E6%B7%BB%E5%8A%A0%E8%AE%B2%E5%B8%88.PNG
## 课程分类管理：
   * 课程树状图：可以根据当前数据库内的课程结构画出对应的树状图，并且提供查询功能，输入关键字即可查询对应的课程<br>
     效果图： https://github.com/Melusinee/Kaike_Springboot/blob/master/image-folder/%E8%AF%BE%E7%A8%8B%E5%88%86%E7%B1%BB%E6%A0%91%E7%8A%B6%E5%9B%BE.PNG
   * 添加课程分类：可以上传符合格式的excel文件，可以自动生成树状图并在课程树状图页面进行更新<br>
      效果图： https://github.com/Melusinee/Kaike_Springboot/blob/master/image-folder/%E8%AF%BE%E7%A8%8B%E6%B7%BB%E5%8A%A0.PNG
        
## 课程管理
  * 课程列表：列出当前数据库所有的课程及其详细信息，且可以通过查询条件功能查询对于课程<br>
      效果图：https://github.com/Melusinee/Kaike_Springboot/blob/master/image-folder/%E8%AF%BE%E7%A8%8B%E5%88%97%E8%A1%A8.PNG
  * 课程上传：
      * 课程上传：可以填写想要新建课程的详细信息，并且添加对应的讲师，这里可选择的讲师是必须在讲师管理板块内存在的<br>
      效果图：https://github.com/Melusinee/Kaike_Springboot/blob/master/image-folder/%E5%8F%91%E5%B8%83%E8%AF%BE%E7%A8%8B.PNG
      * 添加课程章节：可以新建课程内章节，自定义章节在课程内的顺序 <br>
      效果图：https://github.com/Melusinee/Kaike_Springboot/blob/master/image-folder/%E6%B7%BB%E5%8A%A0%E8%AF%BE%E7%A8%8B%E7%AB%A0%E8%8A%82.PNG
      * 添加课程小节：可以在添加的章节中再额外添加小节，小节自带顺序，且可以在小节页面上传视频，上传完视频后会储存在阿里云上 <br>
      效果图：https://github.com/Melusinee/Kaike_Springboot/blob/master/image-folder/%E6%B7%BB%E5%8A%A0%E5%B0%8F%E8%8A%82.PNG
