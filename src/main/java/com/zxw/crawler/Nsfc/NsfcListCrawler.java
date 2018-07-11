package com.zxw.crawler.Nsfc;

import com.zxw.processor.Nsfc.NsfcBriefPageProcessor;
import com.zxw.processor.Nsfc.NsfcDetailPageProcessor;
import com.zxw.repository.ProjectRepo;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

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
  private ProjectRepo projectRepo;

  public void run(){
    Spider spider = Spider.create(briefPageProcessor);

  }
}
