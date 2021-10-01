package com.example.consumingrest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

  private List<Data> data;
  private Long draw;
  private Long recordsFiltered;
  private Long recordsTotal;

  public Quote() {
  }

  public List<Data> getData() {
    return data;
  }

  public void setData(List<Data> data) {
    this.data = data;
  }

  public Long getDraw() {
    return draw;
  }

  public void setDraw(Long draw) {
    this.draw = draw;
  }

  public Long getRecordsFiltered() {
    return recordsFiltered;
  }

  public void setRecordsFiltered(Long recordsFiltered) {
    this.recordsFiltered = recordsFiltered;
  }

  public Long getRecordsTotal() {
    return recordsTotal;
  }

  public void setRecordsTotal(Long recordsTotal) {
    this.recordsTotal = recordsTotal;
  }

  @Override
  public String toString() {
    return "{" + "\"data\":" + data + ", \"draw\":\"" + draw + "\", \"recordsFiltered\":\"" + recordsFiltered
        + "\", \"recordsTotal\":\"" + recordsTotal + "\"}";
  }
}