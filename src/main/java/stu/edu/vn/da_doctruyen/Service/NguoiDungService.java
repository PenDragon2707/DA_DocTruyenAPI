package stu.edu.vn.da_doctruyen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.edu.vn.da_doctruyen.Entity.NguoiDung;
import stu.edu.vn.da_doctruyen.Repository.NguoiDungRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class NguoiDungService {
    @Autowired
    private NguoiDungRepository repository;

    public List<NguoiDung> getAllUsers() {
        return repository.findAll();
    }

    public NguoiDung getUserById(String id) {
        return repository.findById(id).orElse(null);
    }

    public NguoiDung getUserByTenDangNhap(String tenDangNhap) {
        return repository.findByTenDangNhap(tenDangNhap).orElse(null);
    }

    public NguoiDung saveUser(NguoiDung user) {
        return repository.save(user);
    }

    public NguoiDung createUser(NguoiDung user) {
        user.setNguoiDungId(null);
        return repository.save(user);
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}