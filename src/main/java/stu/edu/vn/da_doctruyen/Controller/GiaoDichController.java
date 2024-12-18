package stu.edu.vn.da_doctruyen.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stu.edu.vn.da_doctruyen.Entity.GiaoDich;
import stu.edu.vn.da_doctruyen.Entity.NguoiDung;
import stu.edu.vn.da_doctruyen.Service.GiaoDichService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/search/{chuongTruyenId}/{nguoiDungId}")
    public ResponseEntity<Optional<GiaoDich>> getTransactionByChuongTruyenIdAndNguoiDungId(
            @PathVariable String chuongTruyenId,
            @PathVariable String nguoiDungId) {
        Optional<GiaoDich> giaoDich = service.getTransactionByChuongTruyenIdAndNguoiDungId(chuongTruyenId, nguoiDungId);
        return ResponseEntity.ok(giaoDich);
    }

    @GetMapping("/user/{nguoiDungId}")
    public List<GiaoDich> getTransactionByNguoiDungId(@PathVariable String nguoiDungId) {
        return service.getTransactionByNguoiDungId(nguoiDungId);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveTransaction(@RequestBody GiaoDich transaction) {
        GiaoDich newGD = service.saveTransaction(transaction);
        return ResponseEntity.ok(newGD);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable String id) {
        service.deleteTransaction(id);
    }
}
