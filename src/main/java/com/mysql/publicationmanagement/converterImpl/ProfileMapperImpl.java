package com.mysql.publicationmanagement.converterImpl;

import com.mysql.publicationmanagement.converter.ProfileMapper;
import com.mysql.publicationmanagement.dto.ProfileDTO;
import com.mysql.publicationmanagement.model.Profile;

import java.util.ArrayList;
import java.util.List;

public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public ProfileDTO toProfileDTO(Profile profile) {
        ProfileDTO dto=new ProfileDTO();
        dto.setBiodata(profile.getBioData());
        dto.setImage(profile.getImage());
        dto.setUserID(profile.getUser().getUserId());
        dto.setProfileId(profile.getProfileId());
        return dto;
    }

    @Override
    public Profile toProfile(ProfileDTO profileDTO) {
        Profile profile=new Profile();
        profile.setBioData(profileDTO.getBiodata());
        profile.setImage(profileDTO.getImage());
        profile.setProfileId(profileDTO.getProfileId());
        profile.getUser().setUserId(profileDTO.getUserID());
        return profile;
    }

    @Override
    public List<ProfileDTO> toProfileDTOList(List<Profile> profileList) {
        List<ProfileDTO> dtoList=new ArrayList<>();
        for(Profile profile:profileList){
            dtoList.add(toProfileDTO(profile));
        }
        return dtoList;
    }

    @Override
    public List<Profile> toProfileList(List<ProfileDTO> profileDTOList) {
        List<Profile> profileList= new ArrayList<>();
        for(ProfileDTO dto: profileDTOList){
            profileList.add(toProfile(dto));
        }
        return profileList;
    }
}
