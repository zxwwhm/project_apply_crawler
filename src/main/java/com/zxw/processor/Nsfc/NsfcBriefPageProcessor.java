package com.zxw.processor.Nsfc;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */

@Component
public class NsfcBriefPageProcessor implements PageProcessor {

  @Override
  public void process(Page page) {

  }

  @Override
  public Site getSite() {
    return Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5");
  }
}
