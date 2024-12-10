package com.tecsup.orientatec.services;

import com.tecsup.orientatec.models.Test;
import com.tecsup.orientatec.models.User;
import com.tecsup.orientatec.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public List<Test> getTestsByUsuario(User usuario) {
        return testRepository.findTestsByUserId(usuario);
    }

    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    public Test findById(Integer id) {
        return testRepository.findById(id).orElse(null);
    }
}