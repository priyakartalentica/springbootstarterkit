package com.mysql.publicationmanagement.service;

import com.mysql.publicationmanagement.dto.ProfileDTO;

import java.util.List;

public interface ProfileService {
    List<ProfileDTO> getAllProfiles();
    ProfileDTO getProfileById(Long profileId);
    ProfileDTO createProfile(ProfileDTO profileDTO);
    ProfileDTO updateProfile(Long Id,ProfileDTO profileDTO);
    void deleteProfile(Long Id);

}
