package com.zxw.entity;

import javax.persistence.*;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */

@Entity
@Table(name = "project")//填表名
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private  String date;
  private String detail;
  private String url;

  public Project(){

  }

  //其他属性


  //get和set方法


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Project(String title, String date, String detail, String url) {
    this.title = title;
    this.date = date;
    this.detail = detail;
    this.url = url;
  }
  public Project(String title,String date,String url){
    this.title=title;
    this.date=date;
    this.url=url;
  }

  @Override
  public String toString() {
    return "Project{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", date='" + date + '\'' +
            ", detail='" + detail + '\'' +
            ", url='" + url + '\'' +
            '}';
  }
}
