package com.dayuxiaoyu.api.common;

/**
 * @author zyp
 * @version 1.0
 * @time 16/12/20 11/27
 */
public enum ResultEnum {

  success(0,"成功"),
  validFail(-2,"信息校验失败"),
  systemFail(-1,"系统异常");

  private Integer resultCode;

  private String resultDesc;

  ResultEnum(Integer resultCode, String resultDesc) {
    this.resultCode = resultCode;
    this.resultDesc = resultDesc;
  }

  public Integer getResultCode() {
    return resultCode;
  }

  public String getResultDesc() {
    return resultDesc;
  }
}
