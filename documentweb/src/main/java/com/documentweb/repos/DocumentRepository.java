package com.documentweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.documentweb.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
