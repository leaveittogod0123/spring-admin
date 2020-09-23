package com.noyo0123.backoffice.service;

import com.noyo0123.backoffice.controller.ifs.CrudInterface;
import com.noyo0123.backoffice.model.entity.User;
import com.noyo0123.backoffice.model.network.Header;
import com.noyo0123.backoffice.model.network.request.UserApiRequest;
import com.noyo0123.backoffice.model.network.response.UserApiResponse;
import com.noyo0123.backoffice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository; // 이 부분은  엔티티 respository에 대한 서비스를 따로 사용함 ~  추상화 관련해서 또 정리 할 것임

    // 1. request data 가져오기
    // 2. user 생성
    // 3. 생성된 데이터 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request Data
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED") // 후에 enum으로
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        // 생성된 데이터 -> userApiResponse return

        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        // id -> repository getOne, getById
        Optional<User> optional = userRepository.findById(id);
        // user -> userApiResponse return
        return optional.map(user -> response(user))
                .orElseGet(()-> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        // 1. data

        UserApiRequest userApiRequest = request.getData();

        // 2. id -> user 데이터를 찾고
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional.map(user -> {
            // 3. update
            // Accessors(chain=true)
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());
            return user;
            // 4. userApiResponse
        }).map(user -> userRepository.save(user))           // update -> newUser
                .map(user -> response(user))                // userApiResponse
                .orElseGet(()->Header.ERROR("데이터없음"));

    }

    @Override
    public Header delete(Long id) {
        // id -> repository -> user
        Optional<User> optional = userRepository.findById(id); // 사용자가 없을 수도 있기 때문에 optional이 편함

        // repository -> delete

        return optional.map( user -> {
            userRepository.delete(user);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터없음")); // 없는 경우 에러처리

        // response return
    }

    private Header<UserApiResponse> response (User user) {
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .status(user.getStatus())
                .phoneNumber(user.getPhoneNumber())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        return Header.OK(userApiResponse);
    }
}
