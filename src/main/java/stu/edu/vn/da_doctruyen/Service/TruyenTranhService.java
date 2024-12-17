package stu.edu.vn.da_doctruyen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.edu.vn.da_doctruyen.Entity.TruyenTranh;
import stu.edu.vn.da_doctruyen.Repository.TruyenTranhRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getAllCategories() {
        return repository.findAll()
                .stream()
                .flatMap(comic -> Arrays.stream(comic.getTheLoai().split(",")))  // Tách chuỗi theo dấu phẩy
                .map(String::trim) // Loại bỏ khoảng trắng thừa
                .distinct() // Loại bỏ trùng lặp
                .collect(Collectors.toList());
    }

    public List<TruyenTranh> getTruyenByCategory(String theLoai) {
        return repository.findAll()
                .stream()
                .filter(comic -> Arrays.stream(comic.getTheLoai().split(",")) // Tách thể loại bằng dấu phẩy
                        .map(String::trim) // Loại bỏ khoảng trắng
                        .anyMatch(genre -> genre.equalsIgnoreCase(theLoai))) // So khớp thể loại
                .collect(Collectors.toList());
    }

    public List<TruyenTranh> findByTen(String tenTruyen) {
        if (tenTruyen == null || tenTruyen.trim().isEmpty()) {
            return getAllComics(); // Trả về tất cả truyện tranh nếu không có tên tìm kiếm.
        }

        String searchTerm = tenTruyen.length() >= 2 ? tenTruyen.substring(0, 2) : tenTruyen;

        return repository.findByTenTruyenLike(searchTerm.trim());
    }


}

