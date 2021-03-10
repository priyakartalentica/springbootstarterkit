package com.mysql.publicationmanagement.serviceImpl;

import com.mysql.cj.log.ProfilerEvent;
import com.mysql.cj.x.protobuf.MysqlxPrepare;
import com.mysql.publicationmanagement.converter.ProfileMapper;
import com.mysql.publicationmanagement.converterImpl.ProfileMapperImpl;
import com.mysql.publicationmanagement.dto.ProfileDTO;
import com.mysql.publicationmanagement.model.Profile;
import com.mysql.publicationmanagement.repositories.ProfileRepository;
import com.mysql.publicationmanagement.service.ProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl  implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    private ProfileMapper profileMapper;

    public ProfileServiceImpl() {
        profileMapper=new ProfileMapperImpl();
    }

    @Override
    public List<ProfileDTO> getAllProfiles() {
        List<Profile> profileList= profileRepository.findAll();
        return profileMapper.toProfileDTOList(profileList);
    }

    @Override
    public ProfileDTO getProfileById(Long profileId) {
        return profileMapper.toProfileDTO(profileRepository.getOne(profileId));

    }

    @Override
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        return profileMapper.toProfileDTO(profileRepository.saveAndFlush(profileMapper.toProfile(profileDTO)));
    }

    @Override
    public ProfileDTO updateProfile(Long Id, ProfileDTO profileDTO) {
        Profile oldProfile=profileRepository.getOne(Id);
        oldProfile.setImage(profileDTO.getImage());
        oldProfile.setBioData(profileDTO.getBiodata());
        return profileMapper.toProfileDTO(oldProfile);
    }

    @Override
    public void deleteProfile(Long Id) {
        profileRepository.deleteById(Id);
    }
}
