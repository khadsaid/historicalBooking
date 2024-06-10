package com.Historical.Booking.service;

import com.Historical.Booking.entity.School;
import com.Historical.Booking.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;


    public List<School> fetchAllSchools() {return schoolRepository.findAll();}

    public School  fetchById(Long Id) {return schoolRepository.findById(Id).get();}

    public void deleteSchoolById(Long Id) {schoolRepository.deleteById(Id);}

    public School updateSchool(School school){

        School newSchool = schoolRepository.findById(school.getId()).get();
        newSchool.setSchoolName(school.getSchoolName());
        newSchool.setSchoolAddress(school.getSchoolAddress());
        newSchool.setAmountOfTechers(school.getAmountOfTechers());
        newSchool.setAmountOfStudents(school.getAmountOfStudents());
        newSchool.setSchoolType(school.getSchoolType());
        newSchool.setPhoneNumber(school.getPhoneNumber());
        newSchool.setDate(school.getDate());
        School updateSchool = schoolRepository.save(newSchool);
        return schoolRepository.save(updateSchool);
    }
}
