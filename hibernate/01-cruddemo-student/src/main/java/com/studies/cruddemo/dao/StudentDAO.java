package com.studies.cruddemo.dao;

import com.studies.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);
}
