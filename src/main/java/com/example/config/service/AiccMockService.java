package com.example.config.service;

import com.example.config.model.Agent;
import com.example.config.model.Route;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * AICC（人工触达通道）参数模拟服务。
 * AICC Callbot v3 没有公开的"话术列表查询"接口，
 * 因此 sceneID（话术模板）和 routeID（路由）均使用 Mock 数据。
 */
@Service
public class AiccMockService {

    /**
     * 模拟 AICC 话术模板列表
     */
    public List<Agent> queryScenes() {
        Agent s1 = new Agent();
        s1.setId("scene_gp_recall_001");
        s1.setName("GP召回-流失召回话术");
        s1.setDescription("针对流失用户的人工电销召回话术模板");

        Agent s2 = new Agent();
        s2.setId("scene_gp_recall_002");
        s2.setName("GP召回-高价值召回话术");
        s2.setDescription("针对高价值用户的人工电销召回话术模板");

        Agent s3 = new Agent();
        s3.setId("scene_gp_recall_003");
        s3.setName("GP召回-活动通知话术");
        s3.setDescription("GP活动通知场景的人工电销话术模板");

        return Arrays.asList(s1, s2, s3);
    }

    /**
     * 模拟调用 POST /callcentre/api/v3/routeList
     * 返回可用的 AICC 呼叫路由列表
     */
    public List<Route> queryRoutes() {
        return Arrays.asList(
                new Route("route_manual_001", "GP-人工坐席组A", "华东人工坐席组，工作日 9:00-18:00"),
                new Route("route_manual_002", "GP-人工坐席组B", "华南人工坐席组，工作日 10:00-19:00"),
                new Route("route_manual_003", "GP-人工坐席组C", "海外人工坐席组，多语种支持")
        );
    }
}
