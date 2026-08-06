package com.example.config.service;

import com.example.config.model.Agent;
import com.example.config.model.Route;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * AI Agent 参数模拟服务。
 * 当前为 Mock 模式，后续接入真实接口时，
 * 将内部实现替换为 POST 调用 /openapi/aiagent/flow/list 和 /openapi/aiagent/route/list。
 */
@Service
public class AiAgentService {

    /**
     * 模拟调用 POST /openapi/aiagent/flow/list
     * 返回可用的 AI Agent 话术列表
     */
    public List<Agent> queryAgents() {
        Agent a1 = new Agent();
        a1.setId("agent_001");
        a1.setName("GP召回-智能客服Agent");
        a1.setDescription("处理GP电销召回场景，流失用户召回话术");

        Agent a2 = new Agent();
        a2.setId("agent_002");
        a2.setName("GP营销机器人");
        a2.setDescription("GP营销外呼场景，高价值用户营销话术");

        Agent a3 = new Agent();
        a3.setId("agent_003");
        a3.setName("GP售后助手");
        a3.setDescription("GP售后问题处理，用户满意度回访话术");

        return Arrays.asList(a1, a2, a3);
    }

    /**
     * 模拟调用 POST /openapi/aiagent/route/list
     * 返回可用的呼叫路由列表
     */
    public List<Route> queryRoutes() {
        return Arrays.asList(
                new Route("route_ai_001", "GP-东南亚客服线路", "APAC 香港线路，适用于GP菲律宾用户"),
                new Route("route_ai_002", "GP-海外营销线路", "APAC 新加坡线路，适用于GP海外用户"),
                new Route("route_ai_003", "GP-国内备用线路", "国内备用线路，适用于跨境容灾场景")
        );
    }
}
