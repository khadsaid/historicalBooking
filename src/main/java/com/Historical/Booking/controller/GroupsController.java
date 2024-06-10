package com.Historical.Booking.controller;

import com.Historical.Booking.entity.Groups;
import com.Historical.Booking.entity.School;
import com.Historical.Booking.service.GroupsService;
import com.Historical.Booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v3")
@RestController
@CrossOrigin(originPatterns = "*")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;
    @Autowired
    private UserService userService;


    @PostMapping("/groups")
    public Groups registerNewGroups(@RequestBody Groups groups){return userService.registerNewGroups(groups);}


    @GetMapping("/groups")
    public List<Groups> getAllGroups(){return groupsService.fetchAllGroups();}

    @DeleteMapping("/groups{Id}")
    public void deleteGroups(@PathVariable Long Id){groupsService.deleteGroupsById(Id);}

    @PutMapping("/groups{Id}")
    public ResponseEntity<Groups> updateGroups(@PathVariable long Id, @RequestBody Groups groups){
        groups.setId(Id);
        return ResponseEntity.ok(groupsService.updateGroups(groups));
    }
}
