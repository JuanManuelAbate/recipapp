package com.recipapp.service;

import com.recipapp.model.Sequence;
import com.recipapp.model.SequenceIdentifier;
import com.recipapp.repository.SequenceRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SequenceServiceTest {

    public static final long DEFAULT_COUNTER = 4L;
    public static final Long EXPECTED_INCREMENTED_VALUE = Long.valueOf(5);
    public static final Long EXPECTED_INITIAL_VALUE = Long.valueOf(1);

    @Mock
    private SequenceRepository repo;
    private SequenceService service;

    @Before
    public void setUp() {
        initMocks(this);
        service = new SequenceService();
        service.setSequenceRepository(repo);
    }

    @Test
    public void testIncrementExistent() {
        when(repo.findById(SequenceIdentifier.INGREDIENT.getSeqId()))
                .thenReturn(Optional.of(new Sequence(SequenceIdentifier.INGREDIENT.getSeqId(), DEFAULT_COUNTER)));
        assertEquals("Sequence was not incremented correctly",
                service.getNextSeq(SequenceIdentifier.INGREDIENT), EXPECTED_INCREMENTED_VALUE);
        Mockito.verify(repo).save(new Sequence(SequenceIdentifier.INGREDIENT.getSeqId(), EXPECTED_INCREMENTED_VALUE));
    }

    @Test
    public void testIncrementNonExistent(){
        when(repo.findById(SequenceIdentifier.INGREDIENT.getSeqId()))
                .thenReturn(Optional.empty());
        assertEquals("Sequence was not created correctly",
                service.getNextSeq(SequenceIdentifier.INGREDIENT), EXPECTED_INITIAL_VALUE);
        Mockito.verify(repo).save(new Sequence(SequenceIdentifier.INGREDIENT.getSeqId(), EXPECTED_INITIAL_VALUE));

    }

}
