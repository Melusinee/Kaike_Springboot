package com.kaike.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.kaike.oss.service.OssService;
import com.kaike.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFileAvatar(MultipartFile file) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try{
            InputStream inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();

            // ----- 1. 在文件名里添加唯一随机的值 ---------------------
            String uuid = UUID.randomUUID().toString().replaceAll("-","");

            filename  = uuid+filename;

            // ------------------------------------------------------

            // ----- 2. 把文件按日期分类 ------------------------------
            String datePath = new DateTime().toString("yyyy/MM/dd");
            filename = datePath+"/"+filename;
            // ------------------------------------------------------

            // 上传文件流。
            ossClient.putObject(bucketName,filename, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();

            String url = "https://"+bucketName+"."+endpoint+"/"+filename;
            return url;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
