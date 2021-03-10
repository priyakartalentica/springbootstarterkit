package com.mysql.publicationmanagement.controller;

import com.mysql.publicationmanagement.dto.ProfileDTO;
import com.mysql.publicationmanagement.model.Profile;
import com.mysql.publicationmanagement.service.ProfileService;
import com.mysql.publicationmanagement.serviceImpl.ProfileServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;



    @GetMapping
    public List<ProfileDTO> listAll(){
        return profileService.getAllProfiles();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ProfileDTO get(@PathVariable Long id){

        return profileService.getProfileById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileDTO create(@RequestBody ProfileDTO profileDTO){

        return profileService.createProfile(profileDTO);
    }

    @RequestMapping(value="{id}",method=RequestMethod.PUT)
    public ProfileDTO update( @PathVariable Long id, @RequestBody ProfileDTO profileDTO){
        return profileService.updateProfile(id,profileDTO);

    }

   @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){

        profileService.deleteProfile(id);
    }




}
