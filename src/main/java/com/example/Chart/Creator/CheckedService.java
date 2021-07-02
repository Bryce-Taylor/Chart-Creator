package com.example.Chart.Creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckedService {
    @Autowired
    private CheckedRepository checkedRepository;

    public List<Checked> getAllChecked(){
        return checkedRepository.findAll();
    }

    public void save(Checked checked) {
        checkedRepository.save(checked);
    }

    public List<Checked> findByUserName(User user){
        return checkedRepository.findByUser(user.getUserName());
    }

    public Optional<Checked> getChecked(Long id) {
        return checkedRepository.findById(id);
    }

}
