package stu.edu.vn.da_doctruyen.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.edu.vn.da_doctruyen.Entity.DanhDauTrang;
import stu.edu.vn.da_doctruyen.Service.DanhDauTrangService;

import java.util.List;

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

    @PostMapping
    public DanhDauTrang saveBookmark(@RequestBody DanhDauTrang bookmark) {
        return service.saveBookmark(bookmark);
    }

    @DeleteMapping("/{id}")
    public void deleteBookmark(@PathVariable String id) {
        service.deleteBookmark(id);
    }
}