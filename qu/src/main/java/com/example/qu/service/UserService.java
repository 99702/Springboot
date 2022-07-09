package com.example.qu.service;

import com.example.qu.dto.userdto.GetAUserDTO;
import com.example.qu.dto.userdto.RegisterAUserDTO;
import com.example.qu.entity.User;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface UserService {
    User registerUser(RegisterAUserDTO user)  throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException ;
    GetAUserDTO getSingleUser(Long userId);

    List<GetAUserDTO> getAllUser();
    List<GetAUserDTO> searchUsers(Map<String, String> allParams);

    List<GetAUserDTO> fetchByAttrExact(Map<String, String> allParams) throws ParseException;

    Map<String, Long> fetchUserStatistics();
}
