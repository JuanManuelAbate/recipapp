package com.recipapp.service;

import com.recipapp.model.Sequence;
import com.recipapp.model.SequenceIdentifier;
import com.recipapp.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SequenceService {

    @Autowired
    private SequenceRepository sequenceRepository;

    public Long getNextSeq(SequenceIdentifier id) {
        Optional<Sequence> currentSeq = sequenceRepository.findById(id.getSeqId());
        Sequence sequence = currentSeq.isPresent() ? currentSeq.get() : new Sequence(id.getSeqId(), 0L);
        sequenceRepository.save(sequence.increment());
        return sequence.getSeq();
    }

    public SequenceRepository getSequenceRepository() {
        return sequenceRepository;
    }

    public void setSequenceRepository(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

}
