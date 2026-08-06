package com.example.config.controller;

import com.example.config.model.Agent;
import com.example.config.model.Option;
import com.example.config.model.Route;
import com.example.config.service.AiAgentService;
import com.example.config.service.AiccConfigService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 神策电销召回 Webhook 参数配置接口。
 *
 * 设计原则：
 * - 所有接口对外统一为 GET + 裸数组 [{name, value, detail?}]
 * - 内部按 channelType 分流到不同下游数据源
 * - 下游 API 有的走真实调用（TODO），API 没有的走静态维护
 *
 * 数据源一览：
 *   manual（AICC）: 话术=静态  路由=API(routeList)
 *   ai（AI Agent）: 话术=API(flow/list)  路由=API(route/list)
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    private final AiAgentService aiAgentService;
    private final AiccConfigService aiccConfigService;

    public ConfigController(AiAgentService aiAgentService,
                            AiccConfigService aiccConfigService) {
        this.aiAgentService = aiAgentService;
        this.aiccConfigService = aiccConfigService;
    }

    /**
     * GET /config/channelTypes
     * 触达通道类型。静态数据，仅 manual / ai 两种。
     */
    @GetMapping("/channelTypes")
    public List<Option> channelTypes() {
        return Arrays.asList(
                new Option("manual", "人工触达"),
                new Option("ai", "AI触达")
        );
    }

    /**
     * GET /config/scenes?channelType=manual → AICC 话术（静态维护）
     * GET /config/scenes?channelType=ai     → AI Agent（flow/list API）
     */
    @GetMapping("/scenes")
    public List<Agent> scenes(@RequestParam(defaultValue = "manual") String channelType) {
        if ("ai".equalsIgnoreCase(channelType)) {
            return aiAgentService.queryAgents();
        }
        return aiccConfigService.queryScenes();
    }

    /**
     * GET /config/routes?channelType=manual → AICC 路由（routeList API）
     * GET /config/routes?channelType=ai     → AI Agent 路由（route/list API）
     */
    @GetMapping("/routes")
    public List<Route> routes(@RequestParam(defaultValue = "manual") String channelType) {
        if ("ai".equalsIgnoreCase(channelType)) {
            return aiAgentService.queryRoutes();
        }
        return aiccConfigService.queryRoutes();
    }
}
