package com.zxw.processor;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.handler.SubPageProcessor;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */

@Component
public class NsfcDetailPageProcessor implements SubPageProcessor {

  @Override
  public MatchOther processPage(Page page) {
    return null;
  }

  @Override
  public boolean match(Request request) {
    return false;
  }
}
