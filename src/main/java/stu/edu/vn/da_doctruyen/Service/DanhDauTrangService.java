package stu.edu.vn.da_doctruyen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.edu.vn.da_doctruyen.Entity.DanhDauTrang;
import stu.edu.vn.da_doctruyen.Repository.DanhDauTrangRepository;

import java.util.List;

@Service
public class DanhDauTrangService {
    @Autowired
    private DanhDauTrangRepository repository;

    public List<DanhDauTrang> getAllBookmarks() {
        return repository.findAll();
    }

    public DanhDauTrang getBookmarkById(String id) {
        return repository.findById(id).orElse(null);
    }

    public DanhDauTrang saveBookmark(DanhDauTrang bookmark) {
        return repository.save(bookmark);
    }

    public void deleteBookmark(String id) {
        repository.deleteById(id);
    }
}
