package com.rigo.local.storage.localStorageProyect.infrastructure.services;


import com.rigo.local.storage.localStorageProyect.api.dto.request.UserRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.UserResponse;
import com.rigo.local.storage.localStorageProyect.api.errors.DuplicateEntryException;
import com.rigo.local.storage.localStorageProyect.domain.entities.UserEntity;
import com.rigo.local.storage.localStorageProyect.domain.repositories.UserRepository;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IUserService;
import com.rigo.local.storage.localStorageProyect.infrastructure.mappers.UserMapper;
import com.rigo.local.storage.localStorageProyect.utils.enums.ErrorMessages;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponse create(UserRequest request) throws BadRequestException {

        UserEntity userEmail = this.userRepository.findByEmail(request.getEmail());

        if (userEmail != null)  throw new DuplicateEntryException(request.getEmail());

        UserEntity newClient = this.userMapper.toEntity(request);
        UserEntity savedClient = this.userRepository.save(newClient);

        return this.userMapper.toResponse(savedClient);
    }

    @Override
    public void delete(Long id) throws BadRequestException {


        UserEntity product = this.find(id);
        this.userRepository.delete(product);

    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        return this.userRepository.findAll(pageable).map(this.userMapper::toResponse);
    }

    @Override
    public UserResponse update(Long id, UserRequest request) throws BadRequestException {

        UserEntity client = this.find(id);
        this.userMapper.update(request, client);

        return this.userMapper.toResponse(client);

    }

    private UserEntity find(Long id) throws BadRequestException {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("client")));
    }
}
