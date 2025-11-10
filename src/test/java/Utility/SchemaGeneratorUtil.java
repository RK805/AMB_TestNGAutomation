package Utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.victools.jsonschema.generator.*;
import com.github.victools.jsonschema.module.jackson.JacksonModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SchemaGeneratorUtil {

    private static final Logger logger = LoggerFactory.getLogger(SchemaGeneratorUtil.class);

    public static void generateSchemaFromJson(String jsonResponse, String outputFolder, String schemaFilePrefix) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonResponse);

            // ✅ Configure Victools schema generator
            SchemaGeneratorConfigBuilder configBuilder =
                    new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2020_12, OptionPreset.PLAIN_JSON);

            configBuilder.with(new JacksonModule());
            SchemaGeneratorConfig config = configBuilder.build();

            SchemaGenerator generator = new SchemaGenerator(config);
            JsonNode schema = generator.generateSchema(jsonNode.getClass());

            // Convert schema to formatted JSON
            String schemaAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);

            // Ensure output folder exists
            File folder = new File(outputFolder);
            if (!folder.exists()) folder.mkdirs();

            // ✅ Fixed file name (no timestamp)
            String filePath = outputFolder + "/" + schemaFilePrefix + ".txt";

            // ✅ Overwrite existing file each time
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
                writer.write(schemaAsString);
            }

            logger.info("✅ JSON Schema generated and saved to: {}", filePath);
            System.out.println("✅ JSON Schema generated and saved to: " + filePath);

        } catch (Exception e) {
            logger.error("❌ Failed to generate JSON Schema: {}", e.getMessage(), e);
            System.err.println("❌ Failed to generate JSON Schema: " + e.getMessage());
        }
    }
}
