package stu.edu.vn.da_doctruyen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.edu.vn.da_doctruyen.Entity.ChuongTruyen;
import stu.edu.vn.da_doctruyen.Entity.DanhDauTrang;
import stu.edu.vn.da_doctruyen.Entity.TruyenTranh;
import stu.edu.vn.da_doctruyen.Repository.ChuongTruyenRepository;
import stu.edu.vn.da_doctruyen.Repository.DanhDauTrangRepository;
import stu.edu.vn.da_doctruyen.Repository.TruyenTranhRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DanhDauTrangService {
    @Autowired
    private DanhDauTrangRepository repository;
    @Autowired
    private ChuongTruyenRepository chuongTruyenRepository;
    @Autowired
    private TruyenTranhRepository truyenTranhRepository;

    public Map<String, List<DanhDauTrang>> getAllBookmarksGroupedByUserId(String userId) {
        List<DanhDauTrang> bookmarks = repository.findByNguoiDungId(userId);
        return bookmarks.stream()
                .collect(Collectors.groupingBy(DanhDauTrang::getNguoiDungId));
    }

    public List<DanhDauTrang> getAllBookmarks() {
        return repository.findAll();
    }

    public DanhDauTrang getBookmarkById(String id) {
        return repository.findById(id).orElse(null);
    }

    public DanhDauTrang saveBookmark(String nguoiDungId, String chuongtruyenId) {
        DanhDauTrang danhDauTrang = new DanhDauTrang();
        ChuongTruyen chuongTruyen = chuongTruyenRepository.findById(chuongtruyenId).orElse(null);

        if (chuongTruyen != null) {
            TruyenTranh truyenTranh = truyenTranhRepository.findById(chuongTruyen.getTruyenTranhId()).orElse(null);

            if (truyenTranh != null) {
                danhDauTrang.setTenTruyen(truyenTranh.getTenTruyen());
            }
            danhDauTrang.setTenChuong(chuongTruyen.getTenChuong());
        }

        danhDauTrang.setNguoiDungId(nguoiDungId);
        danhDauTrang.setChuongTruyenId(chuongtruyenId);

        return repository.save(danhDauTrang);
    }


    public void deleteBookmark(String id) {
        repository.deleteById(id);
    }


}

