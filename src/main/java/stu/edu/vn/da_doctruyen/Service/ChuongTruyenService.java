package stu.edu.vn.da_doctruyen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.edu.vn.da_doctruyen.Entity.ChuongTruyen;
import stu.edu.vn.da_doctruyen.Repository.ChuongTruyenRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ChuongTruyenService {
    @Autowired
    private ChuongTruyenRepository repository;

    public List<ChuongTruyen> getAllChapters() {
        return repository.findAll();
    }

    public ChuongTruyen getChapterById(String id) {
        return repository.findById(id).orElse(null);
    }

    public ChuongTruyen saveChapter(ChuongTruyen chapter) {
        return repository.save(chapter);
    }

    public void deleteChapter(String id) {
        repository.deleteById(id);
    }

    public List<ChuongTruyen> getChaptersByTruyenTranhId(String truyenTranhId) {
        return repository.findByTruyenTranhId(truyenTranhId);
    }

    // Phương thức lấy danh sách hình ảnh từ chương truyện
    public List<String> getChapterImagesById(String chapterId) {
        ChuongTruyen chapter = repository.findById(chapterId)
                .orElseThrow(() -> new RuntimeException("Chapter not found"));

        // Parse chuỗi hình ảnh thành danh sách
        return parseImages(chapter.getHinhAnhTruyen());
    }

    private List<String> parseImages(String images) {
        if (images == null || images.isEmpty()) {
            return new ArrayList<>(); // Trả về danh sách rỗng nếu không có hình ảnh
        }

        // Tách chuỗi theo dấu phẩy v       à chuyển thành danh sách
        return Arrays.asList(images.split(","));
    }
}
