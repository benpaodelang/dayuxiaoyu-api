package com.dayuxiaoyu.api.web.response;


import com.dayuxiaoyu.api.common.ResultEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyp
 * @version 1.0
 * @time 16/12/20 13/46
 */
public class BaseListResponse<T> extends BaseResponse {

  public BaseListResponse(ResultEnum resultEnum) {
    super(resultEnum);
  }

  private Integer currentPage = 0;

  private Integer totalPage = 0;

  private Long totalRecord = new Long(0);

  private List<T> list = new ArrayList<T>();

  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public Integer getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(Integer totalPage) {
    this.totalPage = totalPage;
  }

  public Long getTotalRecord() {
    return totalRecord;
  }

  public void setTotalRecord(Long totalRecord) {
    this.totalRecord = totalRecord;
  }

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }
}
