package com.example.config.controller;

import com.example.config.model.Agent;
import com.example.config.model.Option;
import com.example.config.model.Route;
import com.example.config.service.AiAgentService;
import com.example.config.service.AiccMockService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 神策电销召回 Webhook 参数配置接口。
 * 所有接口均为 GET，便于神策平台直接通过 URL 拉取下拉选项。
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    private final AiAgentService aiAgentService;
    private final AiccMockService aiccMockService;

    public ConfigController(AiAgentService aiAgentService,
                            AiccMockService aiccMockService) {
        this.aiAgentService = aiAgentService;
        this.aiccMockService = aiccMockService;
    }

    // ==================== channelType 下拉 ====================

    /**
     * GET /config/channelTypes
     * 获取电销触达通道类型下拉选项
     */
    @GetMapping("/channelTypes")
    public List<Option> channelTypes() {
        return Arrays.asList(
                new Option("manual", "人工触达"),
                new Option("ai", "AI触达")
        );
    }

    // ==================== 话术模板 / AI Agent 下拉 ====================

    /**
     * GET /config/scenes?channelType=manual   → AICC 话术模板列表
     * GET /config/scenes?channelType=ai       → AI Agent 列表
     * 根据触达通道类型返回对应的话术/Agent 下拉选项
     */
    @GetMapping("/scenes")
    public List<Agent> scenes(@RequestParam(defaultValue = "manual") String channelType) {
        if ("ai".equalsIgnoreCase(channelType)) {
            // 模拟 POST /openapi/aiagent/flow/list
            return aiAgentService.queryAgents();
        }
        // 默认 manual：AICC 话术模板（Mock）
        return aiccMockService.queryScenes();
    }

    // ==================== 呼叫路由下拉 ====================

    /**
     * GET /config/routes?channelType=manual   → AICC 呼叫路由列表
     * GET /config/routes?channelType=ai       → AI Agent 呼叫路由列表
     * 根据触达通道类型返回对应的呼叫路由下拉选项
     */
    @GetMapping("/routes")
    public List<Route> routes(@RequestParam(defaultValue = "manual") String channelType) {
        if ("ai".equalsIgnoreCase(channelType)) {
            // 模拟 POST /openapi/aiagent/route/list
            return aiAgentService.queryRoutes();
        }
        // 默认 manual：AICC 路由列表（模拟 POST /callcentre/api/v3/routeList）
        return aiccMockService.queryRoutes();
    }
}
