package stu.edu.vn.da_doctruyen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.edu.vn.da_doctruyen.Entity.TruyenTranh;
import stu.edu.vn.da_doctruyen.Repository.TruyenTranhRepository;

import java.util.List;

@Service
public class TruyenTranhService {
    @Autowired
    private TruyenTranhRepository repository;

    public List<TruyenTranh> getAllComics() {
        return repository.findAll();
    }

    public TruyenTranh getComicById(String id) {
        return repository.findById(id).orElse(null);
    }

    public TruyenTranh saveComic(TruyenTranh comic) {
        return repository.save(comic);
    }

    public void deleteComic(String id) {
        repository.deleteById(id);
    }
}
