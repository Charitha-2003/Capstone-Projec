package com.insta.customer.store;

import com.insta.customer.dto.LoanView;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class LoanStore {
  private final Map<Long, LoanView> db = new ConcurrentHashMap<>();
  private final AtomicLong seq = new AtomicLong(1000);

  @PostConstruct
  void seed(){
    for(int i=0;i<3;i++){
      LoanView v = new LoanView();
      v.setId(seq.incrementAndGet());
      v.setCustomerId(500L + i);
      v.setLoanType("PERSONAL");
      v.setAmount(BigDecimal.valueOf(100000 + i*50000));
      v.setStatus("PENDING");
      v.setRemarks(null);
      v.setAppliedAt(LocalDateTime.now().minusDays(i));
      db.put(v.getId(), v);
    }
  }

  public List<LoanView> pending(){
    List<LoanView> list = new ArrayList<>();
    for(LoanView v: db.values()) if ("PENDING".equals(v.getStatus())) list.add(v);
    

	return null;
  }

  public LoanView update(long id, String status, String remarks){
    LoanView v = db.get(id);
    if(v==null) return null;
    v.setStatus(status);
    v.setRemarks(remarks);
    return v;
  }
}
