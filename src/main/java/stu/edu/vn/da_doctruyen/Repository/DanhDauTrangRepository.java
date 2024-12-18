package stu.edu.vn.da_doctruyen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.edu.vn.da_doctruyen.Entity.DanhDauTrang;

import java.util.List;

public interface DanhDauTrangRepository extends JpaRepository<DanhDauTrang, String> {
    List<DanhDauTrang> findByNguoiDungId(String nguoiDungId);


}
