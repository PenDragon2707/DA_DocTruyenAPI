package stu.edu.vn.da_doctruyen.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu.edu.vn.da_doctruyen.Entity.ChuongTruyen;
import stu.edu.vn.da_doctruyen.Service.ChuongTruyenService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/image/{id}")
    public List<String> getImagebyID(@PathVariable String id) {
        ChuongTruyen chuongTruyen = service.getImageById(Integer.valueOf(id));

        if (chuongTruyen != null && chuongTruyen.getHinhAnhTruyen() != null) {
            String[] imageNames = chuongTruyen.getHinhAnhTruyen().split(",");
            return Arrays.asList(imageNames);
        } else {
            return new ArrayList<>();
        }
    }

    @GetMapping("/truyentranh/{truyenTranhId}")
    public List<ChuongTruyen> getChaptersByTruyenTranhId(@PathVariable String truyenTranhId) {
        return service.getChaptersByTruyenTranhId(truyenTranhId);
    }

}
