package stu.edu.vn.da_doctruyen.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_truyentranh")
public class TruyenTranh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer truyenTranhId;
    private String tenTruyen;
    private String theLoai;
    private String tacGia;
    private String anhBia;

    @Enumerated(EnumType.STRING)
    private TrangThai trangThai;
    @Lob
    private String moTa;
    private String nguoiDungId;

    public enum TrangThai {
        DANG_PHAT_HANH, HOAN_THANH
    }
}

