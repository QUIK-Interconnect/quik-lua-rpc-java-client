package wip.structures;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimitDelete;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import wip.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class FuturesLimitDeleteJsonSerdeTests {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<FuturesLimitDelete> {

        @Override
        public String getJsonPath() {
            return "json/structures/FuturesLimitDelete.json";
        }

        @Override
        public FuturesLimitDelete getExpectedObject() {

            return FuturesLimitDelete.builder()
                    .firmId("1")
                    .limitType(2)
                    .build();
        }
    }
}
