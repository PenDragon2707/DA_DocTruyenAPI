package stu.edu.vn.da_doctruyen.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stu.edu.vn.da_doctruyen.Entity.ChuongTruyen;

@Repository
public interface ChuongTruyenRepository extends JpaRepository<ChuongTruyen, String> {
    List<ChuongTruyen> findByTruyenTranhId(String truyenTranhId);

}
