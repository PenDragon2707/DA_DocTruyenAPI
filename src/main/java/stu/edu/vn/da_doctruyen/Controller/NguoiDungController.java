package stu.edu.vn.da_doctruyen.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.edu.vn.da_doctruyen.Entity.NguoiDung;
import stu.edu.vn.da_doctruyen.Service.NguoiDungService;

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

    @PostMapping
    public NguoiDung saveUser(@RequestBody NguoiDung user) {
        return service.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        service.deleteUser(id);
    }
}
