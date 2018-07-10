package com.zxw.crawler;

import com.zxw.processor.NsfcBriefPageProcessor;
import com.zxw.processor.NsfcDetailPageProcessor;
import com.zxw.repository.ProjectRepo;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.handler.CompositePageProcessor;

import javax.annotation.Resource;

/**
 * 自然基金项目申报信息抓取
 * @author duchenguang
 * @date 2018/7/10.
 */

@Component("NsfcCrawler")
public class NsfcCrawler {

  @Resource
  private NsfcBriefPageProcessor briefPageProcessor;

  @Resource
  private NsfcDetailPageProcessor detailPageProcessor;

  @Resource
  private ProjectRepo projectRepo;

  public void run(){
    Site site = Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5");
    CompositePageProcessor pageProcessor = new CompositePageProcessor(site);
    pageProcessor.addSubPageProcessor(briefPageProcessor);
    pageProcessor.addSubPageProcessor(detailPageProcessor);
    Spider spider = Spider.create(pageProcessor);

  }
}
