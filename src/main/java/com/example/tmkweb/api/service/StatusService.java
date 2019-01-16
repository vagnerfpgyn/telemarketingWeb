package com.example.tmkweb.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.tmkweb.api.model.Status;
import com.example.tmkweb.api.repository.StatusRepository;


@Service
public class StatusService {
	
	@Autowired
	StatusRepository statusRepository;

	public Status atualizar(long id_status, Status status) {
		Status statusSalvo = statusRepository.findOne(id_status);
		if (statusSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(status, statusSalvo, "id_status");
		return statusRepository.save(statusSalvo);
	}	
}
