package com.recipapp.service;

import com.recipapp.model.AbstractDocument;
import com.recipapp.model.SequenceIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class AbstractDocumentService<O extends AbstractDocument, I> {

    @Autowired
    private SequenceService sequenceService;

    public O save(O document) {
        O modifiedDoc = this.preCreation(document);
        if (modifiedDoc.getId() == null) {
            modifiedDoc.setId(this.sequenceService.getNextSeq(getSequenceId()));
        }
        return this.getRecipeRepository().save(modifiedDoc);
    }

    protected abstract O preCreation(O document);

    protected abstract SequenceIdentifier getSequenceId();

    protected abstract MongoRepository<O, I> getRecipeRepository();

}
