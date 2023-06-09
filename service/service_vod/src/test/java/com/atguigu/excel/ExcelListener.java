package com.atguigu.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

public class ExcelListener extends AnalysisEventListener<User> {

    //一行一行读取excel内容，把每行内容封装到user对象
    // 从excel第二行开始读取 ----第一行是表头
    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        System.out.println(user);
    }

    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头："+headMap);
    }

    //所有操作方法执行之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
