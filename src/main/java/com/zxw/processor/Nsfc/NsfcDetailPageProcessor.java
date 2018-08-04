package com.zxw.processor.Nsfc;

import com.zxw.entity.Appendix;
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

import java.util.ArrayList;
import java.util.List;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */

@Component
public class NsfcDetailPageProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        page.setCharset("utf-8");
        // 从URL中得到id
       /* String idStr = page.getUrl().regex("\\?id=(\\d+)$").get();
        Long projectId = Long.parseLong(idStr);
        Document document = page.getHtml().getDocument();*/
        String html = page.getHtml().toString();
        Document document = Jsoup.parse(html);

        Elements content=document.select("#ess_ctr1181_ModuleContent > tbody > tr > td > ul");
        String detail = content.select("div.content_xilan").text();

        List<Appendix> appendixList=new ArrayList<>();
        Elements requests = content.select("#zoom > p > a");
        for (Element e:
                requests
             ) {
            if(!e.equals("")) {
                String url = "http://www.nsfc.gov.cn" + e.attr("href");
                String title = e.select("span").text();
                String parent="1";
                        //

                Appendix appendix = new Appendix(title, url,parent);
                appendixList.add(appendix);
            }

        }

        if(!appendixList.isEmpty()){
            page.putField("appendixLists",appendixList);
        }
       // page.putField("projectId", projectId);
        page.putField("detail", detail);
    }

    @Override
    public Site getSite() {
        return Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5")
            .setSleepTime(1000)
            .setRetryTimes(3);
    }

    public static void main(String[] args) {
        Spider spider = Spider.create(new NsfcDetailPageProcessor());
        spider.addUrl("http://www.nsfc.gov.cn/publish/portal0/tab568/info74042.htm");
        spider.run();
    }
}

//#zoom > p:nth-child(47) > a > span
//#zoom > p:nth-child(48) > a > span