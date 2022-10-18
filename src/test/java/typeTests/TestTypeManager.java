package typeTests;

import org.junit.jupiter.api.Test;
import pogoeinstein.type.TypeManager;

public class TestTypeManager {
    @Test
    public void TestTypeManager(){
        TypeManager typeManager = new TypeManager();
        typeManager.parseTypesFromResources();

        typeManager.getAllTypes().forEach(type -> {
            System.out.println("Type: " + type.getName());
            System.out.println("\tEffectiveness:");
            type.getEffectivenessMap().forEach((key, value) -> {
                System.out.println("\t\tAgainst " + key + ": " + value.toString());
            });
        });

        System.out.println();

    }
}
