package stu.edu.vn.da_doctruyen.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
@Data
@Entity
@Table(name = "tbl_giaodich")

public class GiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer giaoDichId;
    private String nguoiDungId;
    private BigDecimal soTien;
    private Date ngayGiaoDich;
}
