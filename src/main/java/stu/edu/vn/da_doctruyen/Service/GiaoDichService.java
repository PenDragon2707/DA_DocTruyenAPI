package stu.edu.vn.da_doctruyen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.edu.vn.da_doctruyen.Entity.GiaoDich;
import stu.edu.vn.da_doctruyen.Repository.GiaoDichRepository;

import java.util.List;

@Service
public class GiaoDichService {
    @Autowired
    private GiaoDichRepository repository;

    public List<GiaoDich> getAllTransactions() {
        return repository.findAll();
    }

    public GiaoDich getTransactionById(String id) {
        return repository.findById(id).orElse(null);
    }

    public GiaoDich saveTransaction(GiaoDich transaction) {
        return repository.save(transaction);
    }

    public void deleteTransaction(String id) {
        repository.deleteById(id);
    }
}
