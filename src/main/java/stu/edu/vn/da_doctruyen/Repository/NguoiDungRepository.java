package stu.edu.vn.da_doctruyen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.edu.vn.da_doctruyen.Entity.NguoiDung;

import java.util.Optional;


public interface NguoiDungRepository extends JpaRepository<NguoiDung, String>
{ Optional<NguoiDung> findByTenDangNhap(String tenDangNhap);
}
