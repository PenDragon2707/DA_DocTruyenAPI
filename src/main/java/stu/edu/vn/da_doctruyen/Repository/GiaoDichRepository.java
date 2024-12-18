package stu.edu.vn.da_doctruyen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.edu.vn.da_doctruyen.Entity.GiaoDich;

import java.util.List;
import java.util.Optional;

public interface GiaoDichRepository extends JpaRepository<GiaoDich, String> {
    Optional<GiaoDich> findByChuongTruyenIdAndNguoiDungId(String chuongTruyenId, String nguoiDungId);
    List<GiaoDich> findByNguoiDungId(String nguoiDungId);
}
