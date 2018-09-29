package com.dayuxiaoyu.api.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyp
 * @version 1.0
 * @time 16/5/16 19/33
 */
public class ValidationResult {

  // 校验结果是否有错
  private boolean hasErrors;

  // 校验错误信息
  private Map<String, String> errorMsg = new HashMap<String, String>();

  public boolean isHasErrors() {
    return hasErrors;
  }

  public void setHasErrors(boolean hasErrors) {
    this.hasErrors = hasErrors;
  }

  public Map<String, String> getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(Map<String, String> errorMsg) {
    this.errorMsg = errorMsg;
  }

  @Override
  public String toString() {
    if (!hasErrors) {
      return "success";
    } else {
      StringBuilder stringBuilder = new StringBuilder("");
      for (String key : errorMsg.keySet()) {
        stringBuilder.append(key);
        stringBuilder.append(":");
        stringBuilder.append(errorMsg.get(key));
        stringBuilder.append(";");
      }
      return stringBuilder.toString();
    }
  }

  public void addErrMsg(String key, String message) {
    errorMsg.put(key, message);
  }

  /**
   * 合并校验结果
   * 
   * @param validationResult
   */
  public void mergeResult(ValidationResult validationResult) {
    if (validationResult.isHasErrors()) {
      setHasErrors(true);
    }
    if (errorMsg == null) {
      errorMsg = new HashMap<String, String>();
    }
    if (validationResult.getErrorMsg() != null) {
      errorMsg.putAll(validationResult.getErrorMsg());
    }
  }
}
