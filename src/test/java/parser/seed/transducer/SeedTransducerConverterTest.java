package parser.seed.transducer;

import conf.TestConfiguration;
import model.seed.transducer.SeedTransducer;
import org.junit.Test;
import parser.seed.transducer.errors.SeedTransducerParsingErrorType;
import parser.seed.transducer.model.SeedTransducerParsingResult;
import parser.seed.transducer.process.SeedTransducerConverter;
import utils.Comparator;
import utils.SeedTransducerMock;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SeedTransducerConverterTest {

    @Test
    public void convertTest() {

        SeedTransducer seed = SeedTransducerMock.get();

        SeedTransducerParsingResult res = SeedTransducerConverter.convert(new File(TestConfiguration.TEST_FILE_PATH.getValue() + "seedTransducerExample.json"));
        assertTrue("Seed is present so no errors", res.getSeedTransducer().isPresent());
        assertFalse("Parsing OK so no errors", res.hasErrors());
        assertEquals("Seed Name", seed.getName(), res.getSeedTransducer().get().getName());
        assertEquals("Seed init state", seed.getInitState(), res.getSeedTransducer().get().getInitState());
        assertEquals("Seed states", seed.getStates(), res.getSeedTransducer().get().getStates());
        assertTrue("Seed arcs", Comparator.compare(seed, res.getSeedTransducer().get()));

    }

    @Test
    public void convertTest_missingStates() {

        File jsonFile = new File(TestConfiguration.TEST_FILE_PATH_SEED_TRANSDUCER_PARSER.getValue() + "convertTest_missingStates.json");
        SeedTransducerParsingResult res = SeedTransducerConverter.convert(jsonFile);

        assertFalse("No parsing because errors", res.getSeedTransducer().isPresent());
        assertTrue("Parsing KO so errors", res.hasErrors());
        assertEquals("Error amount checking", 26, res.getParsingErrors().size());

        assertEquals("Error checking ", SeedTransducerParsingErrorType.MISSING_PROPERTY_IN_SEED_TRANSDUCER, res.getParsingErrors().get(0).getErrorType());
        assertTrue("Error message ", res.getParsingErrors().get(0).getErrorMsg().contains("\"states\""));

    }


}
