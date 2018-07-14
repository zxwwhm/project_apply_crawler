package com.zxw.crawler.Nsfc;

import com.zxw.entity.Project;
import com.zxw.pipeline.ProjectPipeLine;
import com.zxw.processor.Nsfc.NsfcBriefPageProcessor;
import com.zxw.processor.Nsfc.NsfcDetailPageProcessor;
import com.zxw.repository.ProjectRepo;

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

public class NsfcDetailCrawler {
    @Resource
    private NsfcBriefPageProcessor briefPageProcessor;

    @Resource
    private NsfcDetailPageProcessor detailPageProcessor;
    @Resource
    ProjectPipeLine projectPipeLine;
    @Resource
    private ProjectRepo projectRepo;



    public void runCrawler(){

        while(true){

            List<String> urlList=projectRepo.findDistinctUrl();

            Site site = Site.me().setCycleRetryTimes(20).setSleepTime(500).setTimeOut(5000)

                    .setUserAgent("User-Agent:Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
            Spider spider = Spider.create(detailPageProcessor)
                  .addRequest(getRequestsByUrls(urlList))
                    .addUrl("http://www.nsfc.gov.cn/publish/portal0/tab568");
                   // .addPipeline(projectPipeLine);
             spider.run();
        }



    }

    private static Request[] getRequestsByUrls(List<String> urlList) {
        List<Request> requestList = urlList.stream()
                .map(Request::new)
                .collect(Collectors.toList());
        Request[] requests = new Request[requestList.size()];
        return requestList.toArray(requests);
    }


}



