package com.recipapp.service;

import com.recipapp.error.ResourceNotFoundException;
import com.recipapp.model.AbstractDocument;
import com.recipapp.model.SequenceIdentifier;
import com.recipapp.repository.DocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public abstract class AbstractDocumentService<O extends AbstractDocument> {

    @Autowired
    private SequenceService sequenceService;

    public O save(O document) {
        O modifiedDoc = this.preCreation(document);
        if (modifiedDoc.getId() == null) {
            modifiedDoc.setId(this.sequenceService.getNextSeq(getSequenceId()));
        }
        this.getRecipeRepository().save(modifiedDoc);
        return this.get(modifiedDoc.getId());
    }

    public O update(O document, Long id) {
        document.setId(id);
        return this.save(document);
    }


    public O get(Long id) {
        Optional<O> byId = getRecipeRepository().findByIdAndDeletedIsFalse(id);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return byId.get();
    }


    public O delete(Long id) {
        O document = this.get(id);
        document.setDeleted(true);
        return this.update(document, id);
    }

    protected abstract O preCreation(O document);

    protected abstract SequenceIdentifier getSequenceId();

    protected abstract DocumentRepository<O> getRecipeRepository();

}
