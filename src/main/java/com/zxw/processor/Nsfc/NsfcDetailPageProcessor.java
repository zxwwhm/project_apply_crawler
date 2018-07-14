package com.zxw.processor.Nsfc;

import com.zxw.entity.Project;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
        String html = page.getHtml().toString();
        Document document = Jsoup.parse(html);

        Elements content=document.select("#ess_ctr1181_ModuleContent > tbody > tr > td > ul");
        String title =content.select("div.title_xilan > h1").text();
        //String date = document.select("#ess_ctr1181_ModuleContent > tbody > tr > td > ul > div:nth-child(3) > div.line_xilan").text();
        String detail = content.select("div.content_xilan").text();
        Elements appendix = content.select("#zoom > p:nth-child(3) > a");
        String appendixUrl = "http://www.nsfc.gov.cn/" + appendix.attr("href");
        String appendixName=content.select("#zoom > p:nth-child(3) > a > span").text();

        Project project = new Project(title, detail,appendixUrl,appendixName);
        List<Project> projectList = new ArrayList<>();
        projectList.add(project);
        page.putField("projectLists", projectList);
    }

    @Override
    public Site getSite() {
        return Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5");
    }

    public static void main(String[] args) {
        Spider spider = Spider.create(new NsfcDetailPageProcessor());
        spider.addUrl("http://www.nsfc.gov.cn/publish/portal0/tab452/info72454.htm");
        spider.run();
    }
}

