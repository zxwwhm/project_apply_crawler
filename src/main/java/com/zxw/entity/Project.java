package com.zxw.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

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
  private String date;
  private String detail;
  private String url;
  private String appendixUrl;
  private String appendixName;
  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  private Date createTime;

  @Temporal(TemporalType.TIMESTAMP)
  @UpdateTimestamp
  private Date updateTime;

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

  /*public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }*/

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

  public String getAppendixUrl() {
    return appendixUrl;
  }

  public void setAppendixUrl(String appendixUrl) {
    this.appendixUrl = appendixUrl;
  }

  public String getAppendixName() {
    return appendixName;
  }

  public void setAppendixName(String appendixName) {
    this.appendixName = appendixName;
  }

  public Project(String title, String date, String detail, String url, Date createTime, Date updateTime, String appendixUrl,String appendixName) {
    this.title = title;
    this.date = date;
    this.detail = detail;
    this.url = url;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.appendixUrl=appendixUrl;
    this.appendixName=appendixName;
  }

 public Project(String title, String date, String url){
    this.title=title;
    this.date=date;
    this.url=url;
  }
  public Project(String title,String detail,String appendixUrl,String appendixName){
    this.title=title;
    this.detail=detail;
    this.appendixUrl=appendixUrl;
    this.appendixName=appendixName;

  }

  @Override
  public String toString() {
    return "Project{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", date='" + date + '\'' +
            ", detail='" + detail + '\'' +
            ", url='" + url + '\'' +
            ", appendixUrl='" + appendixUrl + '\'' +
            ", appendixName='" + appendixName + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
