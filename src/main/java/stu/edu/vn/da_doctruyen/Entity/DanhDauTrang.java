package stu.edu.vn.da_doctruyen.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_danhdautrang")
public class DanhDauTrang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer danhDauTrangId;
    private String nguoiDungId;
    private String chuongTruyenId;
    private String tenChuong;
    private String tenTruyen;

}
