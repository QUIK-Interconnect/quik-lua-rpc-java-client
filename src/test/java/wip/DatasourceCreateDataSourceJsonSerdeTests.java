package wip;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.CreateDataSource;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceCreateDataSourceJsonSerdeTests {

    public static class RpcFullArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<CreateDataSource.Args> {

        @Override
        public CreateDataSource.Args getArgsObject() {

            return CreateDataSource.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .interval(CreateDataSource.Interval.INTERVAL_M5)
                    .param("4")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/CreateDataSource/full.args.json";
        }
    }

    public static class RpcWithoutParamArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<CreateDataSource.Args> {

        @Override
        public CreateDataSource.Args getArgsObject() {

            return CreateDataSource.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .interval(CreateDataSource.Interval.INTERVAL_M5)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/CreateDataSource/without_param.args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<CreateDataSource.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/CreateDataSource/result.json";
        }

        @Override
        public CreateDataSource.Result getExpectedObject() {

            return CreateDataSource.Result.builder()
                    .datasourceUUID("1")
                    .error(false)
                    .build();
        }
    }

    public static class RpcErrorResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<CreateDataSource.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/CreateDataSource/error.result.json";
        }

        @Override
        public CreateDataSource.Result getExpectedObject() {

            return CreateDataSource.Result.builder()
                    .error(true)
                    .errorDesc("2")
                    .build();
        }
    }
}
