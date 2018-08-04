package com.zxw.crawler.Nsfc;

import com.zxw.entity.Project;
import com.zxw.pipeline.AppendixPipeline;
import com.zxw.pipeline.ProjectPipeLine;
import com.zxw.processor.Nsfc.NsfcBriefPageProcessor;
import com.zxw.processor.Nsfc.NsfcDetailPageProcessor;
import com.zxw.repository.ProjectRepo;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duchenguang
 * @date 2018/7/11.
 */

@Component("NsfcDetailCrawler")
public class NsfcDetailCrawler {
    @Resource
    private NsfcBriefPageProcessor briefPageProcessor;

    @Resource
    private NsfcDetailPageProcessor detailPageProcessor;
    @Resource
    ProjectPipeLine projectPipeLine;
    @Resource
    private ProjectRepo projectRepo;
    @Resource
    AppendixPipeline appendixPipeline;



    public void runCrawler(){
            List<Project> urlList=projectRepo.findAll();
            Spider spider = Spider.create(detailPageProcessor)
                         .addRequest(getRequestsByUrls(urlList))
                        .addPipeline(projectPipeLine);
                     //   .addPipeline(appendixPipeline);


             spider.run();
    }

    private static Request[] getRequestsByUrls(List<Project> urlList) {
        List<Request> requestList = urlList.stream()
                .map(project -> new Request(project.getUrl()+"?id="+project.getId()))
                .collect(Collectors.toList());
        Request[] requests = new Request[requestList.size()];
        return requestList.toArray(requests);
    }


}



