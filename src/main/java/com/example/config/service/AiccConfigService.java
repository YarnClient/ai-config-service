package com.example.config.service;

import com.example.config.model.Agent;
import com.example.config.model.Route;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * AICC Callbot v3（人工触达通道）参数服务。
 *
 * 数据来源：
 *   话术模板 — ❌ AICC 无公开的"话术列表查询"接口
 *             （intentList / strategyList 均需要 sceneID 作为入参，无法反向枚举）
 *             → 静态维护，业务方新增话术后手工同步到此
 *
 *   呼叫路由 — ✅ POST /callcentre/api/v3/routeList
 *             → 当前 Mock，接入凭证后改为真实 API 调用
 */
@Service
public class AiccConfigService {

    // ==================== 话术模板（静态配置） ====================

    /**
     * 数据来源：静态维护（无下游查询接口）
     * TODO: 业务方新增 AICC 话术后，在此同步新增条目
     */
    public List<Agent> queryScenes() {
        return Arrays.asList(
                new Agent("scene_gp_recall_001", "GP召回-流失召回话术",
                        "针对流失用户的人工电销召回话术模板"),
                new Agent("scene_gp_recall_002", "GP召回-高价值召回话术",
                        "针对高价值用户的人工电销召回话术模板"),
                new Agent("scene_gp_recall_003", "GP召回-活动通知话术",
                        "GP活动通知场景的人工电销话术模板")
        );
    }

    // ==================== 呼叫路由（API → Mock） ====================

    /**
     * 数据来源：POST /callcentre/api/v3/routeList
     * TODO: 接入 AICC 凭证后，替换为真实 HTTP 调用
     *       body: {}
     *       解析 routeData[].routeID → value, routeName → name, routeDesc → description
     */
    public List<Route> queryRoutes() {
        return Arrays.asList(
                new Route("route_manual_001", "GP-人工坐席组A",
                        "华东人工坐席组，工作日 9:00-18:00"),
                new Route("route_manual_002", "GP-人工坐席组B",
                        "华南人工坐席组，工作日 10:00-19:00"),
                new Route("route_manual_003", "GP-人工坐席组C",
                        "海外人工坐席组，多语种支持")
        );
    }
}
