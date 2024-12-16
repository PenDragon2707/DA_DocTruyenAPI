package stu.edu.vn.da_doctruyen.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import stu.edu.vn.da_doctruyen.Entity.NguoiDung;
import stu.edu.vn.da_doctruyen.Service.NguoiDungService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/nguoidung")
public class NguoiDungController {
    @Autowired
    private NguoiDungService service;

    @GetMapping
    public List<NguoiDung> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public NguoiDung getUserById(@PathVariable String id) {
        return service.getUserById(id);
    }

    @GetMapping("/tenDangNhap/{tenDangNhap}")
    public NguoiDung getUserByTenDangNhap(@PathVariable String tenDangNhap) { return service.getUserByTenDangNhap(tenDangNhap); }

    @PostMapping
    public NguoiDung saveUser(@RequestBody NguoiDung user) {
        return service.saveUser(user);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody NguoiDung user) {
        try {
            NguoiDung existingUser = service.getUserByTenDangNhap(user.getTenDangNhap());
            if (existingUser != null)
            {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Tên đăng nhập đã tồn tại");
            }
            NguoiDung newUser = service.createUser(user);
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi thêm ngươ dùng mới");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        service.deleteUser(id);
    }
}