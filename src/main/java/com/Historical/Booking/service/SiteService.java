package com.Historical.Booking.service;

import com.Historical.Booking.entity.Site;
import com.Historical.Booking.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class SiteService {
    private final String IMAGE_UPLOAD_DIRECTORY = "C:/Users/Khadija/Download";
    @Autowired
    private SiteRepository repository;

    public List<Site>  fetchAllSites(){
        return repository.findAll();
    }
    public Site fetchSiteById(Long Id){
        return repository.findById(Id).get();
    }

    public void deleteSitebyId(Long Id){
        repository.deleteById(Id);
    }
    public Site updateSite(Site site) {
        Site newSite = repository.findById(site.getId()).get();
        newSite.setUserName(site.getUserName());
        newSite.setSiteName(site.getSiteName());
        newSite.setUserLastName(site.getUserLastName());
        newSite.setSiteLocation(site.getSiteLocation());
        newSite.setUserPassword(site.getUserPassword());
        newSite.setUserFirstName(site.getUserFirstName());
        Site updateSite = repository.save(newSite);
        return repository.save(updateSite);
    }
//    public Site registerNewSite(Site site, MultipartFile image) throws IOException {
//        // Process the image file
//        if (image != null && !image.isEmpty()) {
//            // Get the original file name
//            String originalFileName = image.getOriginalFilename();
//            // Generate a new file name to avoid name collisions
//            String fileName = System.currentTimeMillis() + "-" + originalFileName;
//            // Set the content type
//            site.setSiteImageContentType(image.getContentType());
//            // Save the image file
//            Path imagePath = Paths.get(IMAGE_UPLOAD_DIRECTORY, fileName);
//            Files.copy(image.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
//            // Convert the image file to a byte array
//            site.setSiteImage(image.getBytes());
//        }
//        return repository.save(site); // Add this return statement
//    }
}
