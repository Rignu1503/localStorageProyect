package com.rigo.local.storage.localStorageProyect.infrastructure.services;

import com.rigo.local.storage.localStorageProyect.api.dto.request.ClientRequest;
import com.rigo.local.storage.localStorageProyect.api.dto.response.BasicResponse.ClientResponse;
import com.rigo.local.storage.localStorageProyect.domain.entities.ClientEntity;
import com.rigo.local.storage.localStorageProyect.domain.repositories.ClientRepository;
import com.rigo.local.storage.localStorageProyect.infrastructure.adstract_services.IClientService;
import com.rigo.local.storage.localStorageProyect.infrastructure.mappers.ClientMapper;
import com.rigo.local.storage.localStorageProyect.utils.enums.ErrorMessages;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;


    @Override
    public ClientResponse create(ClientRequest request) throws BadRequestException {

        ClientEntity newClient = this.clientMapper.toEntity(request);
        ClientEntity savedClient = this.clientRepository.save(newClient);

        return this.clientMapper.toResponse(savedClient);
    }

    @Override
    public void delete(Long id) throws BadRequestException {

        ClientEntity product = this.find(id);
        this.clientRepository.delete(product);
    }

    @Override
    public Page<ClientResponse> getAll(Pageable pageable) {
        return this.clientRepository.findAll(pageable).map(this.clientMapper::toResponse);
    }

    @Override
    public ClientResponse update(Long id, ClientRequest request) throws BadRequestException {

        ClientEntity client = this.find(id);
        this.clientMapper.update(request, client);

        return this.clientMapper.toResponse(client);
    }

    private ClientEntity find(Long id) throws BadRequestException {
        return this.clientRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("client")));
    }
}
