package stu.edu.vn.da_doctruyen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.edu.vn.da_doctruyen.Entity.DanhDauTrang;
import stu.edu.vn.da_doctruyen.Entity.GiaoDich;

import java.util.List;
import java.util.Optional;

public interface DanhDauTrangRepository extends JpaRepository<DanhDauTrang, String> {
    Optional<DanhDauTrang> findByNguoiDungIdAndChuongTruyenId(String nguoiDungId, String chuongTruyenId);
    List<DanhDauTrang> findByNguoiDungId(String nguoiDungId);
}