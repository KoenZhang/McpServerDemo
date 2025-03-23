package top.dreamcenter.demo;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SSETests {

    @Test
    public void testSSE() {

        McpSyncClient client = McpClient.sync(new HttpClientSseClientTransport("http://localhost:8080")).build();
        System.out.println(client.listTools());

        McpSchema.CallToolResult callToolResult = client.callTool(new McpSchema.CallToolRequest("getWeather", Map.of("city", "乌鲁木齐")));
        System.out.println(callToolResult);

        client.closeGracefully();
    }

}
