package com.zxw.processor.Nsfc;

import com.zxw.entity.Project;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.PlainText;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */

@Component
public class NsfcBriefPageProcessor implements PageProcessor {

  @Override
  public void process(Page page) {
    page.setCharset("utf-8");
    String html=page.getHtml().toString();
    Document document=Jsoup.parse(html);

    Elements requests=document.select("#ess_ctr1413_ModuleContent > tbody > tr > td > ul > ul > li.clearfix");
    List<Project> projectList=new ArrayList<>();
// List<String> reCheckUrl=new ArrayList<>();
    for (Element e:requests
            ) {
      Elements content=e.select("a");
      String url="http://www.nsfc.gov.cn/"+content.attr("href");
      String title=content.attr("title");
      String date=e.select("span.fr").text().trim();

      Project project=new Project(title,date,url);
      projectList.add(project);
    }

    int currentPageNum=Integer.parseInt(document.select("#ess_ctr1413_ListC_Info_AspNetPager > table > tbody > tr > td.Normal > font").text().trim());
    if(currentPageNum==1){
      PlainText lastPageUrl = new PlainText(document.select("#ess_ctr1413_ListC_Info_AspNetPager > table > tbody > tr > td:nth-child(1) > a:nth-last-child(2)").attr("href"));
      int lastPageNum = Integer.parseInt(lastPageUrl.regex("page(\\d+)\\.htm").get());
      for(int i=2;i<=lastPageNum;i++){
        String addUrl = "http://www.nsfc.gov.cn/publish/portal0/tab568/module1413/page"+i+".htm";
        page.addTargetRequest(addUrl);
        System.out.println(addUrl);
      }
    }
    if (!projectList.isEmpty()){
      page.putField("projectLists",projectList);
    }
  }

  @Override
  public Site getSite() {
    return Site.me()
            .setRetryTimes(3)
            .setSleepTime(500)
            .setCharset("UTF-8")
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5");
  }

  public static void main(String[] args) {
    Spider spider = Spider.create(new NsfcBriefPageProcessor());
    spider.addUrl("http://www.nsfc.gov.cn/publish/portal0/tab568/");
    spider.run();
  }
}
