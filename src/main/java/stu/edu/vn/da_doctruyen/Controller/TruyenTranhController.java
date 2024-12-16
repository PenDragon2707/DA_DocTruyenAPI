package stu.edu.vn.da_doctruyen.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.edu.vn.da_doctruyen.Entity.TruyenTranh;
import stu.edu.vn.da_doctruyen.Service.TruyenTranhService;

import java.util.List;

@RestController
@RequestMapping("/api/truyentranh")
public class TruyenTranhController {
    @Autowired
    private TruyenTranhService service;

    @GetMapping
    public List<TruyenTranh> getAllComics() {
        return service.getAllComics();
    }

    @GetMapping("/{id}")
    public TruyenTranh getComicById(@PathVariable String id) {
        return service.getComicById(id);
    }

    @PostMapping
    public TruyenTranh saveComic(@RequestBody TruyenTranh comic) {
        return service.saveComic(comic);
    }

    @DeleteMapping("/{id}")
    public void deleteComic(@PathVariable String id) {
        service.deleteComic(id);
    }

    @GetMapping("/theloai")
    public List<String> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/theloai/{theLoai}")
    public List<TruyenTranh> searchTruyenByCategory(@PathVariable String theLoai) {
        return service.getTruyenByCategory(theLoai);
    }

}
