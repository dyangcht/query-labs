package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

  private Long id;
  // private String quote;
  // private String content;
  private String name;
  private String birth;
  private String eyes;

  public Value() {
  }

  public Long getId() {
    return this.id;
  }

  /*
   * public String getQuote() { return this.quote; }
   * 
   * public String getContent() { return this.content; }
   */

  public String getName() {
    return this.name;
  }

  public String getBirth() {
    return this.birth;
  }

  public String getEyes() {
    return this.eyes;
  }

  public void setId(Long id) {
    this.id = id;
  }

  /*
   * public void setQuote(String quote) { this.quote = quote; }
   * 
   * public void setContent(String content) { this.content = content; }
   */

  public void setName(String name) {
    this.name = name;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public void setEyes(String eyes) {
    this.eyes = eyes;
  }

  @Override
  public String toString() {
    return "{" + "\"birth\":" + birth + ",\"name\":\"" + name + "\"" + ",\"eyes\":\"" + eyes + "\"}";
  }
}