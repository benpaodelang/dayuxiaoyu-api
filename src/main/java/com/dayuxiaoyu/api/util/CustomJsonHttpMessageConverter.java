package com.dayuxiaoyu.api.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author zyp
 * @version 1.0
 * @time 16/12/20 17/01
 */
public class CustomJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
  public final static Charset UTF8     = Charset.forName("UTF-8");

  private Charset charset  = UTF8;

  private SerializerFeature[] features = new SerializerFeature[0];

  public CustomJsonHttpMessageConverter(){
    super(new MediaType("application", "json", UTF8), new MediaType("application", "*+json", UTF8));
  }

  @Override
  protected boolean supports(Class<?> clazz) {
    return true;
  }

  public Charset getCharset() {
    return this.charset;
  }

  public void setCharset(Charset charset) {
    this.charset = charset;
  }

  public SerializerFeature[] getFeatures() {
    return features;
  }

  public void setFeatures(SerializerFeature... features) {
    this.features = features;
  }

  @Override
  protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException,
          HttpMessageNotReadableException {

    String content = getContent(inputMessage.getBody());
    return JSON.parseObject(content, clazz);
  }

  @Override
  protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException,
          HttpMessageNotWritableException {

    OutputStream out = outputMessage.getBody();
    String text = JSON.toJSONString(obj, features);
    byte[] bytes = text.getBytes(charset);
    out.write(bytes);
  }


  /**
   * 从流中读取字符串
   *
   * @param input
   * @return
   */
  private String getContent(InputStream input) throws UnsupportedEncodingException {
    StringBuffer pojoStr = new StringBuffer(200);
    BufferedReader read = new BufferedReader(new InputStreamReader(input,"utf-8"));
    try {
      String info = null;
      while (null != (info = read.readLine())) {
        pojoStr.append(info.trim());
      }
      return pojoStr.toString();
    } catch (Exception e) {
      return StringUtils.EMPTY;
    } finally {
      try {
        if (null != read) {
          read.close();
        }
      } catch (IOException e) {
        return StringUtils.EMPTY;
      }
      read = null;
    }
  }
}
