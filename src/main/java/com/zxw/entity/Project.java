package com.zxw.entity;

import javax.persistence.*;

/**
 * @author duchenguang
 * @date 2018/7/10.
 */

@Entity
@Table(name = "")//填表名
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //其他属性


  //get和set方法
}
