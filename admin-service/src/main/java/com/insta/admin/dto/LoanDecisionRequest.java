package com.insta.admin.dto;

import lombok.Data;

@Data
public class LoanDecisionRequest {
  private String remarks;

  public String getRemarks() {
	return remarks;
  }

  public void setRemarks(String remarks) {
	this.remarks = remarks;
  }
}
