package com.example.Chart.Creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckedService {

    private Checked checked;

    @Autowired
    private CheckedRepository checkedRepository;

    public List<Checked> getAllChecked(String user){
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
    public Checked get(long id) {
        return checkedRepository.findById(id).get();
    }

    public List<Checked> getAllUsersJoined(){
        List<Checked> listJoined = (List<Checked>) checkedRepository.findAll();

        listJoined.removeIf(checked -> !checked.getIsJoined());

        return listJoined;
    }


    public Checked getName(String user){
        return (Checked) checkedRepository.findByName(user);
    }



}
