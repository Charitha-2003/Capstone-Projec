package com.insta.customer.controller;

import com.insta.customer.dto.LoanView;
import com.insta.customer.dto.UpdateLoanStatusRequest;
import com.insta.customer.store.LoanStore;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/customer")
@RequiredArgsConstructor
@CrossOrigin
public class InternalLoanController {

  private final LoanStore store = new LoanStore();

  @GetMapping("/loans/pending")
  public ResponseEntity<List<LoanView>> pending(){
    return ResponseEntity.ok(store.pending());
  }

  @PutMapping("/loans/{id}/status")
  public ResponseEntity<LoanView> update(@PathVariable long id, @RequestBody UpdateLoanStatusRequest req){
    var updated = store.update(id, req.getStatus(), req.getRemarks1());
    return updated==null ? ResponseEntity.notFound().build() : (ResponseEntity<LoanView>) ResponseEntity.ok(updated);
  }
}
