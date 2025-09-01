package com.insta.admin.feign;

import com.insta.admin.dto.LoanView;
import com.insta.admin.dto.UpdateLoanStatusRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name="customer-service", path="/internal/customer")
public interface CustomerClient {
  @GetMapping("/loans/pending")
  List<LoanView> getPendingLoans();

  @PutMapping("/loans/{loanId}/status")
  LoanView updateLoanStatus(@PathVariable("loanId") Long loanId, @RequestBody UpdateLoanStatusRequest req);
}
