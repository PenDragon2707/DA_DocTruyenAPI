package stu.edu.vn.da_doctruyen.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "tbl_chuongtruyen")
public class ChuongTruyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chuongTruyenId;
    private String truyenTranhId;
    private String tenChuong;
    private Date ngayPhatHanh;
    private String hinhAnhTruyen;
}
