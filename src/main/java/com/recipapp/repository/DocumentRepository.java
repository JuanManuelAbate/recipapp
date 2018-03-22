package com.recipapp.repository;

import com.recipapp.model.AbstractDocument;
import com.recipapp.model.Recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DocumentRepository<D extends AbstractDocument> extends MongoRepository<D, Long> {

    Optional<D> findByIdAndDeletedIsFalse(Long id);

    Page<D> findAllByDeletedIsFalse(Pageable pageable);

}
