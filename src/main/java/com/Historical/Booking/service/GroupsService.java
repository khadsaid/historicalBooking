package com.Historical.Booking.service;

import com.Historical.Booking.entity.Groups;
import com.Historical.Booking.entity.School;
import com.Historical.Booking.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
@Service
public class GroupsService {

    @Autowired
   private GroupsRepository groupsRepository;


    public void deleteGroupsById(Long Id) {
        groupsRepository.deleteById(Id);
    }


    public List<Groups> fetchAllGroups() {
        return groupsRepository.findAll();
    }

    public Groups updateGroups(Groups groups) {
        Groups newGroups = groupsRepository.findById(groups.getId()).get();
        newGroups.setGroupName(groups.getGroupName());
        newGroups.setGroupType(groups.getGroupType());
        newGroups.setDate(groups.getDate());
        newGroups.setAddress(groups.getAddress());
        newGroups.setTotalNumber(groups.getTotalNumber());
        newGroups.setPhoneNumber(groups.getPhoneNumber());
        Groups updateGroups = groupsRepository.save(newGroups);
        return  groupsRepository.save(updateGroups);
    }
}
