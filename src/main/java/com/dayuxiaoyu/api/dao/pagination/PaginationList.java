package com.dayuxiaoyu.api.dao.pagination;

import java.util.ArrayList;

/**
 * @author zhaoyang
 * @version V1.0
 * @Title:PaginationList.java
 * @Description:带分页信息的List实现类，作为分页结果返回
 * @date Jan 17, 2014 10:02:14 AM
 */

public class PaginationList<T> extends ArrayList<T> {
  private static final long serialVersionUID = -6059628280162549106L;

  private PaginationInfo paginationInfo = null;

  public PaginationInfo getPaginationInfo() {
    return paginationInfo;
  }

  public void setPaginationInfo(PaginationInfo paginationInfo) {
    this.paginationInfo = paginationInfo;
  }

  public Integer getCurrentPage() {
    return this.paginationInfo.getCurrentPage();
  }

  public Integer getRecordPerPage() {
    return this.paginationInfo.getRecordPerPage();
  }

  public Integer getTotalPage() {
    return this.paginationInfo.getTotalPage();
  }

  public Long getTotalRecord() {
    return this.paginationInfo.getTotalRecord();
  }
}
