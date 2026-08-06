package com.example.config.service;

import com.example.config.model.Agent;
import com.example.config.model.Route;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * AI Agent（AI 触达通道）参数服务。
 *
 * 数据来源：
 *   AI Agent — ✅ POST /openapi/aiagent/flow/list
 *              → 当前 Mock，接入凭证后改为真实 API 调用
 *              → 解析 autoFlowId → value, name → name, desc → description
 *
 *   呼叫路由 — ✅ POST /openapi/aiagent/route/list
 *              → 当前 Mock，接入凭证后改为真实 API 调用
 *              → 解析 routeId → value, routeName → name
 */
@Service
public class AiAgentService {

    // ==================== AI Agent 列表（API → Mock） ====================

    /**
     * 数据来源：POST /openapi/aiagent/flow/list
     * TODO: 接入 NXLink 凭证后，替换为真实 HTTP 调用
     */
    public List<Agent> queryAgents() {
        return Arrays.asList(
                new Agent("agent_001", "GP召回-智能客服Agent",
                        "处理GP电销召回场景，流失用户召回话术"),
                new Agent("agent_002", "GP营销机器人",
                        "GP营销外呼场景，高价值用户营销话术"),
                new Agent("agent_003", "GP售后助手",
                        "GP售后问题处理，用户满意度回访话术")
        );
    }

    // ==================== 呼叫路由（API → Mock） ====================

    /**
     * 数据来源：POST /openapi/aiagent/route/list
     * TODO: 接入 NXLink 凭证后，替换为真实 HTTP 调用
     */
    public List<Route> queryRoutes() {
        return Arrays.asList(
                new Route("route_ai_001", "GP-东南亚客服线路",
                        "APAC 香港线路，适用于GP菲律宾用户"),
                new Route("route_ai_002", "GP-海外营销线路",
                        "APAC 新加坡线路，适用于GP海外用户"),
                new Route("route_ai_003", "GP-国内备用线路",
                        "国内备用线路，适用于跨境容灾场景")
        );
    }
}
