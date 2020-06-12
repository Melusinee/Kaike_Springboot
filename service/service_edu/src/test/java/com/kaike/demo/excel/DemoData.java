package com.kaike.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {

    @ExcelProperty(value = "学生编号",index = 0)
    private Integer studentNo;
    @ExcelProperty(value = "学生姓名",index = 1)
    private String studentName;
}
