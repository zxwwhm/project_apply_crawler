package com.zxw;

import com.zxw.crawler.Nsfc.NsfcAppendixCrawler;
import com.zxw.crawler.Nsfc.NsfcDetailCrawler;
import com.zxw.crawler.Nsfc.NsfcListCrawler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */

public class Client {
  public static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
//    YourCrawler crawler = (YourChatCrawler) ac.getBean("YourChatCrawler");
//    crawler.run();
   /*NsfcListCrawler nsfcListCrawler=(NsfcListCrawler) ac.getBean("NsfcListCrawler");
    nsfcListCrawler.run();*/
    /*NsfcDetailCrawler nsfcDetailCrawler=(NsfcDetailCrawler) ac.getBean("NsfcDetailCrawler");
    nsfcDetailCrawler.runCrawler();*/
    NsfcAppendixCrawler nsfcAppendixCrawler=(NsfcAppendixCrawler)ac.getBean("NsfcAppendixCrawler");
    nsfcAppendixCrawler.run();
  }
}
