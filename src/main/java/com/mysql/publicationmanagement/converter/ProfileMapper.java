package com.mysql.publicationmanagement.converter;

import com.mysql.publicationmanagement.model.Profile;
import com.mysql.publicationmanagement.dto.ProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper( ProfileMapper.class );
    ProfileDTO toProfileDTO(Profile profile);
    Profile toProfile(ProfileDTO profileDTO);
    List<ProfileDTO> toProfileDTOList(List<Profile> profileList);
    List<Profile> toProfileList(List<ProfileDTO> profileDTOList);
}
