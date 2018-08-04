package com.zxw.pipeline;

import com.zxw.entity.Appendix;
import com.zxw.repository.AppendixRepo;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.util.List;


@Component
public class AppendixPipeline implements Pipeline {
    @Resource
    private AppendixRepo appendixRepo;
    @Override
    public void process(ResultItems resultItems, Task task){
        List<Appendix> appendixList=resultItems.get("appendixLists");
        if(appendixList!=null){
            appendixRepo.save(appendixList);
        }
    }
}
