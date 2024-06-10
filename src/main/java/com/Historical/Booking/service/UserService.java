package com.Historical.Booking.service;

import com.Historical.Booking.entity.*;
import com.Historical.Booking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private RoleRepository roleDao;
    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private GroupsRepository groupsRepository;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created user");
        roleDao.save(userRole);

        Role siteRole = new Role();
        siteRole.setRoleName("Site");
        siteRole.setRoleDescription("Default role for newly created site");
        roleDao.save(siteRole);

        Role schoolRole = new Role();
        schoolRole.setRoleName("School");
        schoolRole.setRoleDescription("Default role for newly created school");
        roleDao.save(schoolRole);

        Role groupsRole = new Role();
        groupsRole.setRoleName("groups");
        groupsRole.setRoleDescription("Default role for newly created private groups");
        roleDao.save(groupsRole);

        User adminUser = new User();
        adminUser.setId(1L);
        adminUser.setUserName("khadija");
        adminUser.setUserPassword(getEncodedPassword("12345"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }

    public Site registerNewSites(Site site) {
        Role role = roleDao.findById("Site").get();
        Set<Role> siteRoles = new HashSet<>();
        siteRoles.add(role);
        site.setRole(siteRoles);
        site.setUserPassword(getEncodedPassword(site.getUserPassword()));
        return siteRepository.save(site);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public School registerNewSchool(School school) {
        Role role = roleDao.findById("School").get();
        Set<Role> schoolRole = new HashSet<>();
        schoolRole.add(role);
        school.setRole(schoolRole);
        school.setUserPassword(getEncodedPassword(school.getUserPassword()));
        return schoolRepository.save(school);

    }

    public Groups registerNewGroups(Groups groups) {
        Role role = roleDao.findById("groups").get();
        Set<Role> groupsRole = new HashSet<>();
        groupsRole.add(role);
        groups.setRole(groupsRole);
        groups.setUserPassword(getEncodedPassword(groups.getUserPassword()));
        return groupsRepository.save(groups);

    }


}
