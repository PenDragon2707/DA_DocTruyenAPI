package stu.edu.vn.da_doctruyen.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stu.edu.vn.da_doctruyen.Entity.DanhDauTrang;
import stu.edu.vn.da_doctruyen.Service.DanhDauTrangService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/danhdautrang")
public class DanhDauTrangController {

    @Autowired
    private DanhDauTrangService service;

    @GetMapping
    public List<DanhDauTrang> getAllBookmarks() {
        return service.getAllBookmarks();
    }

    @GetMapping("/{id}")
    public DanhDauTrang getBookmarkById(@PathVariable String id) {
        return service.getBookmarkById(id);
    }

    @PostMapping("/save/{nguoiDungId}/{chuongtruyenId}")
    public ResponseEntity<DanhDauTrang> saveBookmark(@PathVariable("nguoiDungId") String nguoiDungId,
                                                     @PathVariable("chuongtruyenId") String chuongtruyenId) {
        try {
            DanhDauTrang danhDauTrang = service.saveBookmark(nguoiDungId, chuongtruyenId);

            if (danhDauTrang != null) {
                return ResponseEntity.ok(danhDauTrang); // Trả về thành công với dấu trang
            } else {
                return ResponseEntity.status(400).body(null); // Trả về lỗi nếu không lưu được
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable String id) {
        try {
            service.deleteBookmark(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build(); // Trả về lỗi nếu có ngoại lệ
        }
    }

    @GetMapping("/nguoidung/{id}")
    public List<DanhDauTrang> getBookmarksGroupedByUserId(@PathVariable String id) {
        return service.getAllBookmarksGroupedByUserId(id);
    }

    @GetMapping("/truyen/{chuongtruyenId}")
    public Map<String, String> getChapterAndStoryName(@PathVariable String chuongtruyenId) {
        return service.getChapterAndStoryNameByChapterId(chuongtruyenId);
    }

    @GetMapping("/search/{chuongTruyenId}/{nguoiDungId}")
    public ResponseEntity<Optional<DanhDauTrang>> getBookmarkByChuongTruyenIdAndNguoiDungId(
            @PathVariable String chuongTruyenId,
            @PathVariable String nguoiDungId) {
        Optional<DanhDauTrang> danhDauTrang = service.getBookmarkByNguoiDungIdAndChuongTruyenId(nguoiDungId, chuongTruyenId);
        return ResponseEntity.ok(danhDauTrang);
    }
}