package com.zxw.crawler.Nsfc;

import com.zxw.pipeline.ProjectPipeLine;
import com.zxw.processor.Nsfc.NsfcBriefPageProcessor;
import com.zxw.processor.Nsfc.NsfcDetailPageProcessor;
import com.zxw.repository.ProjectRepo;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import javax.annotation.Resource;

/**
 * 自然基金项目申报信息抓取
 * @author duchenguang
 * @date 2018/7/10.
 */

@Component("NsfcListCrawler")
public class NsfcListCrawler {

  @Resource
  private NsfcBriefPageProcessor briefPageProcessor;

  @Resource
  private NsfcDetailPageProcessor detailPageProcessor;
  @Resource
  ProjectPipeLine projectPipeLine;
  @Resource
  private ProjectRepo projectRepo;


  public void run(){
    Site site = Site.me().setCycleRetryTimes(20).setSleepTime(500).setTimeOut(5000)

            .setUserAgent("User-Agent:Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
    Spider spider = Spider.create(briefPageProcessor)
           // .addPipeline(projectPipeLine);
            .addUrl("http://www.nsfc.gov.cn/publish/portal0/tab568")
            .addPipeline(projectPipeLine);


            spider.run();


  }
}
