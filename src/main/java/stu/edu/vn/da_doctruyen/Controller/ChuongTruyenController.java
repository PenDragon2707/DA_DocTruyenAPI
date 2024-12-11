package stu.edu.vn.da_doctruyen.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.edu.vn.da_doctruyen.Entity.ChuongTruyen;
import stu.edu.vn.da_doctruyen.Service.ChuongTruyenService;

import java.util.List;

@RestController
@RequestMapping("/api/chuongtruyen")
public class ChuongTruyenController {
    @Autowired
    private ChuongTruyenService service;

    @GetMapping
    public List<ChuongTruyen> getAllChapters() {
        return service.getAllChapters();
    }

    @GetMapping("/{id}")
    public ChuongTruyen getChapterById(@PathVariable String id) {
        return service.getChapterById(id);
    }

    @PostMapping
    public ChuongTruyen saveChapter(@RequestBody ChuongTruyen chapter) {
        return service.saveChapter(chapter);
    }

    @DeleteMapping("/{id}")
    public void deleteChapter(@PathVariable String id) {
        service.deleteChapter(id);
    }
}
