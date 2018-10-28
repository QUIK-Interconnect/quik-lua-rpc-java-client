package wip;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.T;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceTJsonSerdeTests {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<T.Args> {

        @Override
        public T.Args getArgsObject() {
            return new T.Args("1", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/T/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<T.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/T/result.json";
        }

        @Override
        public T.Result getExpectedObject() {

            return T.Result.builder()
                    .year(1)
                    .month(2)
                    .day(3)
                    .weekDay(4)
                    .hour(5)
                    .min(6)
                    .sec(7)
                    .ms(8)
                    .count(9)
                    .build();
        }
    }
}
