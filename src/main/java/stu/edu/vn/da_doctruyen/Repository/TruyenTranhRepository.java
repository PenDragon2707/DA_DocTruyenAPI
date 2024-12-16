package stu.edu.vn.da_doctruyen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.edu.vn.da_doctruyen.Entity.TruyenTranh;

import java.util.List;

public interface TruyenTranhRepository extends JpaRepository<TruyenTranh, String> {
    List<TruyenTranh> findByTheLoai(String theLoai);


}
