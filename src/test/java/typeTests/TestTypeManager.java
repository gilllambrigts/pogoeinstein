package typeTests;

import org.junit.jupiter.api.Test;
import pogoeinstein.type.TypeManager;

public class TestTypeManager {
    @Test
    public void TestTypeManager(){
        TypeManager typeManager = new TypeManager();
        typeManager.parseTypesFromResources();



    }
}
