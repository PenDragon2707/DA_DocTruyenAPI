package stu.edu.vn.da_doctruyen.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.edu.vn.da_doctruyen.Entity.GiaoDich;
import stu.edu.vn.da_doctruyen.Service.GiaoDichService;

import java.util.List;

@RestController
@RequestMapping("/api/giaodich")
public class GiaoDichController {
    @Autowired
    private GiaoDichService service;

    @GetMapping
    public List<GiaoDich> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/{id}")
    public GiaoDich getTransactionById(@PathVariable String id) {
        return service.getTransactionById(id);
    }

    @PostMapping
    public GiaoDich saveTransaction(@RequestBody GiaoDich transaction) {
        return service.saveTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable String id) {
        service.deleteTransaction(id);
    }
}
