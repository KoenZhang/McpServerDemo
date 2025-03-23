package top.dreamcenter.demo;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


public class CommonTests {

    @Test
    public void testWeather() {
        ServerParameters parameters = ServerParameters.builder("java")
                .args("-jar", "jar包绝对路径")
                .build();

        McpSyncClient client = McpClient.sync(new StdioClientTransport(parameters)).build();

        McpSchema.ListToolsResult listToolsResult = client.listTools();
        System.out.println(listToolsResult);

        McpSchema.CallToolResult callToolResult = client.callTool(new McpSchema.CallToolRequest("getWeather",
                Map.of("city", "北京")));
        System.out.println(callToolResult);

        List<McpSchema.Content> content = callToolResult.content();
        Assertions.assertNotNull(content);
        Assertions.assertEquals(content.size(), 1);


        String text = ((McpSchema.TextContent) content.get(0)).text();
        System.out.println(text);
        Assertions.assertEquals(text, "\"北京的温度是2\"");

        client.closeGracefully();
    }
}
