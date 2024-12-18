package stu.edu.vn.da_doctruyen.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
@Table(name = "tbl_nguoidung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nguoiDungId;
    private String tenDangNhap;
    private String email;
    private String matKhau;
    private BigDecimal soDu;
    @Enumerated(EnumType.STRING)
    private PhanQuyen phanQuyen;
    public enum PhanQuyen {
        USER,ADMIN;
    }


}
