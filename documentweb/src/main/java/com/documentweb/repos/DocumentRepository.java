package com.documentweb.repos;

import org.springframework.data.repository.CrudRepository;

import com.documentweb.entities.Document;

public interface DocumentRepository extends CrudRepository<Document, Long>{

}
