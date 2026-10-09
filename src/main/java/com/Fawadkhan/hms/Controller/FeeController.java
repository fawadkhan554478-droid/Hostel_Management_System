package com.Fawadkhan.hms.Controller;

import com.Fawadkhan.hms.Entity.Fee;
import com.Fawadkhan.hms.Service.FeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    private final FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    // CREATE
    @PostMapping
    public Fee createFee(@RequestBody Fee fee) {
        return feeService.createFee(fee);
    }

    // GET ALL
    @GetMapping
    public List<Fee> getAllFees() {
        return feeService.getAllFees();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Fee> getFeeById(@PathVariable Long id) {

        return feeService.getFeeById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public Fee updateFee(@PathVariable Long id, @RequestBody Fee fee) {

        return feeService.updateFee(id, fee);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteFee(@PathVariable Long id) {

        feeService.deleteFee(id);

        return "Fee deleted successfully";
    }
}
