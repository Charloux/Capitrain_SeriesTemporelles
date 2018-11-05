package parser.seed.transducer;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.seed.transducer.SeedTransducer;
import parser.seed.transducer.model.SeedTransducerPOJO;

import java.io.File;
import java.io.IOException;

public class SeedTransducerParser {


    public static void parse(File jsonFile) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        SeedTransducerPOJO seed = mapper.readValue(jsonFile, SeedTransducerPOJO.class);
        System.out.println("coucou" + seed);


    }

}