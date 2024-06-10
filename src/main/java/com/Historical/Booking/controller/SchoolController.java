package com.Historical.Booking.controller;

import com.Historical.Booking.entity.School;
import com.Historical.Booking.entity.Site;
import com.Historical.Booking.service.SchoolService;
import com.Historical.Booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v2")
@RestController
@CrossOrigin(originPatterns = "*")
public class SchoolController {

    @Autowired
    private UserService userService;

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/school")
    public  School registerNewSite(@RequestBody School school){return userService.registerNewSchool(school);}


    @GetMapping("/school")
    public List<School> getAllSchool(){return schoolService.fetchAllSchools();}

    @DeleteMapping("/School{Id}")
    public void deleteSchool(@PathVariable Long Id){schoolService.deleteSchoolById(Id);}

    @PutMapping("/school{Id}")
    public ResponseEntity<School> updateSchool(@PathVariable long Id, @RequestBody School school){
        school.setId(Id);
        return ResponseEntity.ok(schoolService.updateSchool(school));
    }
}