package top.dreamcenter.demo.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {

    @Tool(description = "获取城市的温度")
    public String getWeather(@ToolParam(description = "城市名称") String city) throws UnsupportedEncodingException {
        String decodeCity = new String(city.getBytes("GBK"), StandardCharsets.UTF_8);
        return decodeCity + "的温度是" + decodeCity.length();
    }

}
