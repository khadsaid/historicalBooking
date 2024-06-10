package com.Historical.Booking.controller;

import com.Historical.Booking.entity.Site;
import com.Historical.Booking.repository.SiteRepository;
import com.Historical.Booking.service.SiteService;
import com.Historical.Booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class SiteController {
    @Autowired
    private UserService userService;
    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SiteService siteService;

    @PostMapping("/Sites")
    public Site registerNewSite(@RequestBody Site site){
        return userService.registerNewSites(site);
    }

    @GetMapping("/Sites")
    public List<Site> getAllSites(){
        return siteService.fetchAllSites();
    }

    @DeleteMapping("/Sites/{Id}")
    public void DeleteSites(@PathVariable Long Id){
        siteService.deleteSitebyId(Id);
    }
    @PutMapping("/Sites/{Id}")
    public ResponseEntity<Site> updateSite(@PathVariable Long Id,@RequestBody Site site){
        site.setId(Id);
        return ResponseEntity.ok(siteService.updateSite(site));
    }

//    @PostMapping("/Sites")
//    public ResponseEntity<Site> registerNewSite(@RequestParam("site") Site site, @RequestParam("image") MultipartFile image) {
//        try {
//            Site registeredSite = siteService.registerNewSite(site, image);
//            return new ResponseEntity<>(registeredSite, HttpStatus.CREATED);
//        } catch (DataIntegrityViolationException e) {
//            // Handle unique constraint violations
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        } catch (IOException e) {
//            // Handle image processing errors
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/{Id}/image")
    public ResponseEntity<Site> uploadSiteImage(@PathVariable("Id") Long Id,
                                                @RequestParam("image") MultipartFile image) {
        Optional<Site> siteOptional = siteRepository.findById(Id);
        if (!siteOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Site site = siteOptional.get();
        try {
            byte[] imageData = image.getBytes();
            site.setImage(imageData);
            siteRepository.save(site);
            return ResponseEntity.ok(site);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
