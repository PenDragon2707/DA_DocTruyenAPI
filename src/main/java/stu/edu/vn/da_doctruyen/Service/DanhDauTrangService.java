package stu.edu.vn.da_doctruyen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.edu.vn.da_doctruyen.Entity.ChuongTruyen;
import stu.edu.vn.da_doctruyen.Entity.DanhDauTrang;
import stu.edu.vn.da_doctruyen.Entity.TruyenTranh;
import stu.edu.vn.da_doctruyen.Repository.ChuongTruyenRepository;
import stu.edu.vn.da_doctruyen.Repository.DanhDauTrangRepository;
import stu.edu.vn.da_doctruyen.Repository.NguoiDungRepository;
import stu.edu.vn.da_doctruyen.Repository.TruyenTranhRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DanhDauTrangService {
    @Autowired
    private DanhDauTrangRepository repository;
    @Autowired
    private ChuongTruyenRepository chuongTruyenRepository;
    @Autowired
    private TruyenTranhRepository truyenTranhRepository;

    public List<DanhDauTrang> getAllBookmarksGroupedByUserId(String nguoiDungId) {
        return repository.findByNguoiDungId(nguoiDungId);
    }

    public List<DanhDauTrang> getAllBookmarks() {
        return repository.findAll();
    }

    public DanhDauTrang getBookmarkById(String id) {
        return repository.findById(id).orElse(null);
    }

    public DanhDauTrang saveBookmark(String nguoiDungId, String chuongtruyenId) {
        DanhDauTrang danhDauTrang = new DanhDauTrang();
        danhDauTrang.setNguoiDungId(null);
        danhDauTrang.setNguoiDungId(nguoiDungId);
        danhDauTrang.setChuongTruyenId(chuongtruyenId);
        return repository.save(danhDauTrang);
    }

    public void deleteBookmark(String id) {
        repository.deleteById(id);
    }

    public Map<String, String> getChapterAndStoryNameByChapterId(String chuongtruyenId) {
        ChuongTruyen chuongTruyen = chuongTruyenRepository.findById(chuongtruyenId).orElse(null);
        if (chuongTruyen != null) {
            String truyenId = chuongTruyen.getTruyenTranhId();
            TruyenTranh truyenTruyen = truyenTranhRepository.findById(truyenId).orElse(null);

            if (truyenTruyen != null) {
                return Map.of(
                        "tenChuong", chuongTruyen.getTenChuong(),
                        "tenTruyen", truyenTruyen.getTenTruyen()
                );
            }
        }
        return Map.of("error", "Không tìm thấy thông tin chương hoặc truyện");
    }

    public Optional<DanhDauTrang> getBookmarkByNguoiDungIdAndChuongTruyenId(String nguoiDungId, String chuongTruyenId) {
        return repository.findByNguoiDungIdAndChuongTruyenId(nguoiDungId, chuongTruyenId);
    }
}