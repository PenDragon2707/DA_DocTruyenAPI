package stu.edu.vn.da_doctruyen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.edu.vn.da_doctruyen.Entity.ChuongTruyen;
import stu.edu.vn.da_doctruyen.Repository.ChuongTruyenRepository;

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
}
