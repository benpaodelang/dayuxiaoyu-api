package com.dayuxiaoyu.api.util;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zyp
 * @version 1.0
 * @time 16/5/16 19/18
 */
public class ValidationUtils {

  private static Validator validator =  Validation.buildDefaultValidatorFactory().getValidator();

  /**
   * 验证
   * @param obj
   * @param <T>
   * @return
   */
  public static <T> ValidationResult validateEntity(T obj){
    ValidationResult result = new ValidationResult();
    Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);
    if(set!=null&&set.size()>0){
      result.setHasErrors(true);
      Map<String,String> errorMsg = new HashMap<String,String>();
      for(ConstraintViolation<T> cv : set){
        errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
      }
      result.setErrorMsg(errorMsg);
    } else {
      result.setHasErrors(false);
    }
    return result;
  }

}
