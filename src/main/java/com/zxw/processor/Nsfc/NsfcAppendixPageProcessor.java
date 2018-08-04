package com.zxw.processor.Nsfc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author duchenguang
 * @date 2018/7/11.
 */

@Component
public class NsfcAppendixPageProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        page.setCharset("utf-8");
        String idStr = page.getUrl().regex("\\?id=(\\d+)$").get();
       //  Document document = page.getHtml().getDocument();
        /*String html=page.getHtml().toString();
        Document document=Jsoup.parse(html);*/
        String urlStr=page.getUrl().toString();


        String s = page.getUrl().toString();

        int start = s.lastIndexOf(".");

        String target = s.substring(start);

        if (target.equals("doc")) {

            String FileName = idStr ;
            File file = null;
            FileOutputStream fos = null;


            int num = 0;
            file = new File( "D:\\webmagic"+"\\"+FileName+".doc");
            try {
                if (!file.exists()) {

                        file.createNewFile();
                        fos = new FileOutputStream(file);
                        URL url = new URL(urlStr);
                        URLConnection connection = url.openConnection();
                        connection.setConnectTimeout(5000);
                        InputStream in = connection.getInputStream();
                        //缓冲数据
                        byte[] size=new byte[1024];
                        //先读到bytes中
                        while ((num=in.read(size))!=-1){
                            fos.write(size,0,num);
                        }
                        //关闭IO
                        fos.close();
                        in.close();


                }
            } catch (IOException e) {
                e.printStackTrace();
            }


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


}
