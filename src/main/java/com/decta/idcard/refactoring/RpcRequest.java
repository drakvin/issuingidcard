package com.decta.idcard.refactoring;

import ch.qos.logback.core.net.server.Client;

public class RpcRequest {

    private String jsonRpc;
    private String method;
    private String business;
    private String id;
    private String clientId;
    private Client client;
    private BusinessClient businessClient;

    public RpcRequest withJsonRpc(String jsonRpc) {
        this.jsonRpc = jsonRpc;
        return this;
    }


    public RpcRequest withMethod(String method) {
        this.method = method;
        return this;
    }

    public RpcRequest withId(String id) {
        this.id = id;
        return this;
    }

    public RpcRequest withParameters(Client client) {
        this.client = client;
        return this;
    }
    public RpcRequest withParameters(BusinessClient businessClient) {
        this.businessClient = businessClient;
        return this;
    }

    public RpcRequest withParameters(String clientId) {
        this.clientId = clientId;
        return this;
    }

}
