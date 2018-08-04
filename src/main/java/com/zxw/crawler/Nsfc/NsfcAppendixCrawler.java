package com.zxw.crawler.Nsfc;

import com.zxw.entity.Appendix;
import com.zxw.entity.Project;
import com.zxw.processor.Nsfc.NsfcAppendixPageProcessor;
import com.zxw.repository.AppendixRepo;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duchenguang
 * @date 2018/7/11.
 */


@Component("NsfcAppendixCrawler")
public class NsfcAppendixCrawler {
    @Resource
    private NsfcAppendixPageProcessor nsfcAppendixPageProcessor;
    @Resource
    private AppendixRepo appendixRepo;


public void run(){
    List<Appendix> urlList=appendixRepo.findAll();
    Spider spider = Spider.create(nsfcAppendixPageProcessor)
            .addRequest(getRequestsByUrls(urlList))
            .addPipeline(new FilePipeline("D://webmagic"));
            // .addPipeline(projectPipeLine);
            //.addUrl("http://www.nsfc.gov.cn/publish/portal0/tab568");
          //  .addPipeline(new FilePipeline("D:\\webmagic\\"));


    spider.run();


}
    private static Request[] getRequestsByUrls(List<Appendix> urlList) {
        List<Request> requestList = urlList.stream()
                .map(appendix -> new Request(appendix.getUrl()+"?id="+appendix.getId()))
                .collect(Collectors.toList());
        Request[] requests = new Request[requestList.size()];
        return requestList.toArray(requests);
    }
}
