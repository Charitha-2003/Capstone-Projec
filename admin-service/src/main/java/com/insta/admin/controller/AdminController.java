package com.insta.admin.controller;

import com.insta.admin.dto.LoanDecisionRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/admin") @RequiredArgsConstructor @CrossOrigin
public class AdminController {
  @SuppressWarnings("null")
@GetMapping("/loans/pending") @Operation(summary="List pending loans")
  public ResponseEntity<Object> pending(){ AdminController service = null;
  return ResponseEntity.ok(service.pending()); }
  @SuppressWarnings("null")
@PutMapping("/loans/{id}/approve") @Operation(summary="Approve loan")
  public ResponseEntity<Object> approve(@PathVariable Long id, @RequestBody(required=false) LoanDecisionRequest req){ AdminController service = null;
  return ResponseEntity.ok(service.approve(id, req)); }
  @SuppressWarnings("null")
@PutMapping("/loans/{id}/reject") @Operation(summary="Reject loan")
  public ResponseEntity<Object> reject(@PathVariable Long id, @RequestBody(required=false) LoanDecisionRequest req){ AdminController service = null;
  return ResponseEntity.ok(service.reject(id, req)); }
}
