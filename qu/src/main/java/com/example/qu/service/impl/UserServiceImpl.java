package com.example.qu.service.impl;

import com.example.qu.dto.userdto.GetAUserDTO;
import com.example.qu.dto.userdto.RegisterAUserDTO;

import com.example.qu.entity.User;
import com.example.qu.mapping.Converter;
import com.example.qu.repository.UserRepository;
import com.example.qu.service.UserService;
import com.example.qu.utils.AES;
import com.example.qu.utils.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Converter converter;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AES aes;

    @Override
    public User registerUser(RegisterAUserDTO user) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        // encrypt password using bcrypt password generator
        // and encrypt mobile with aes
        String algorithm = "AES/CBC/PKCS5Padding";
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setMobile(aes.encryptText(algorithm, user.getMobile(), AESUtil.convertKeyToSecretKey()));
//        user.setName(aes.encryptText(algorithm, user.getName(), this.generateKey(128), AESUtil.generateIv()));

        return userRepository.save(converter.DTOToEntity(user));
   };
    @Override
    public GetAUserDTO getSingleUser(Long userId){
        return converter.EntityToDto(
                userRepository.findById(userId).get());
//                userRepository.fetchById(userId).get());
    }

    @Override
    public List<GetAUserDTO> getAllUser() {
        return converter.EntityListToDtoList(userRepository.findAll());
    }

    @Override
    public List<GetAUserDTO> searchUsers(Map<String, String> allParams) {
        //          allParams:  name, email, enabled, role
        String name = allParams.get("name");
        String email = allParams.get("email");
        Boolean enabled = Boolean.parseBoolean(allParams.get("enabled"));
        String role = allParams.get("role");

        List<User> results = new ArrayList<>();
        if(name != null){
            results.addAll(userRepository.findByNameContainingIgnoreCase(name));
        }
        if(email != null){
            results.addAll(userRepository.findByEmailIgnoreCase(email));
        }
        if(enabled){
            results.addAll(userRepository.findByEnabled(enabled));
        }
        if(role != null){
            results.addAll(userRepository.findByRole(role));
        }
        return converter.EntityListToDtoList(results);
    }

    // jpql queries list
    @Override
    public List<GetAUserDTO> fetchByAttrExact(Map<String, String> allParams) throws ParseException {
        String name = allParams.get("name");
        String email = allParams.get("email");
        Boolean enabled = Boolean.parseBoolean(allParams.get("enabled"));
        String mobileStr = allParams.get("mobile");
        String role = allParams.get("role");
//        Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(allParams.get("dob"));
        List<GetAUserDTO> results = new ArrayList<>();


        if(name != null){
            List<User> userList = userRepository.fetchByNameExact(name);
            List<GetAUserDTO> getAUserDTOList = new ArrayList<>();
            for(User user: userList){
                GetAUserDTO getAUserDTO = this.setterForGetAUserDTO(user);
                getAUserDTOList.add(getAUserDTO);
            }
            results.addAll(getAUserDTOList);
        }
        if(email != null){
            User user = userRepository.fetchByEmailExact(email);
            GetAUserDTO getAUserDTO = this.setterForGetAUserDTO(user);
            results.add(getAUserDTO);
        }

        if(mobileStr != null){
            User user = userRepository.fetchByMobileExact(mobileStr);
            GetAUserDTO getAUserDTO = this.setterForGetAUserDTO(user);
            results.add(getAUserDTO);
        }
        if(enabled){
            List<User> userList = userRepository.fetchByEnabled(enabled);
            List<GetAUserDTO> getAUserDTOList = new ArrayList<>();
            for(User user: userList){
                GetAUserDTO getAUserDTO = this.setterForGetAUserDTO(user);
                getAUserDTOList.add(getAUserDTO);
            }
            results.addAll(getAUserDTOList);
        }
        if(allParams.get("dob") != null){
            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(allParams.get("dob"));
            System.out.println(dob);
            List<User> userList = userRepository.fetchBydobExact(dob);
            List<GetAUserDTO> getAUserDTOList = new ArrayList<>();
            if(dob != null){
                for(User user: userList){
                    GetAUserDTO getAUserDTO = this.setterForGetAUserDTO(user);
                    getAUserDTOList.add(getAUserDTO);
                }
                results.addAll(getAUserDTOList);
            }
        }

        if(role != null){
            List<User> userList = userRepository.fetchByRoleExact(role);
            List<GetAUserDTO> getAUserDTOList = new ArrayList<>();
            for(User user: userList){
                GetAUserDTO getAUserDTO = this.setterForGetAUserDTO(user);
                getAUserDTOList.add(getAUserDTO);
            }
            results.addAll(getAUserDTOList);
        }
        return results;
    }

    @Override
    public Map<String, Long> fetchUserStatistics() {
        Map<String, Long> statsDict = new HashMap<>();
        Long totalUser = userRepository.fetchTotalUser();
        Long totalEnabledUser = userRepository.fetchTotalEnabledUser();
        Long totalNotEnabledUser = userRepository.fetchTotalNotEnabledUser();
        Long totalUSER = userRepository.fetchTotalUSER();
        Long totalADMIN = userRepository.fetchTotalADMIN();
        statsDict.put("total_user", totalUser);
        statsDict.put("total_enabled_user", totalEnabledUser);
        statsDict.put("total_not_enabled_user", totalNotEnabledUser);
        statsDict.put("total_ADMIN", totalADMIN);
        statsDict.put("total_USER", totalUSER);
        return statsDict;
    }

    private GetAUserDTO setterForGetAUserDTO(User user) {
        GetAUserDTO getAUserDTO = new GetAUserDTO();
        getAUserDTO.setName(user.getName());
        getAUserDTO.setEmail(user.getEmail());
        getAUserDTO.setMobile(user.getMobile());
        getAUserDTO.setProfilePic(user.getProfilePic());
        return getAUserDTO;
    }


    // private SecretKey generateKey(int n) throws NoSuchAlgorithmException {
    //     KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    //     keyGenerator.init(n);
    //     return keyGenerator.generateKey();
    }
}
