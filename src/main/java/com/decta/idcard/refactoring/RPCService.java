package com.decta.idcard.refactoring;

import ch.qos.logback.core.net.server.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RPCService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private Connection connection;

    public RpcResponse registerNewClient(Client client) {
        getLogMessage(client);
        RpcRequest request = new RpcRequest()
                .withJsonRpc("2.0")
                .withMethod("REGISTER_NEW_CLIENT")
                .withId("1")
                .withParameters(client);
        RpcResponse response = getRpcLogDebug(request, "POST");
        return response;
    }

    public RpcResponse registerNewBusinessClient(BusinessClient client) throws RPCServiceException {
        log.debug("Register new client RPC service called with parameters - " + client);
        RpcRequest request = new RpcRequest()
                .withJsonRpc("2.0")
                .withMethod("REGISTER_NEW__BUSINESS_CLIENT")
                .withId("1")
                .withParameters(client);
        RpcResponse response = getRpcLogDebug(request, "POST");
        throwServiceException(response);
        return response;
    }

    public RpcResponse editClients(Client client) throws RPCServiceException {
        getLogMessage(client);

        RpcRequest request = new RpcRequest()
                .withJsonRpc("2.0")
                .withMethod("EDIT_CLIENT")
                .withId("1")
                .withParameters(client);

        RpcResponse response = getRpcLogDebug(request, "PATCH");
        throwServiceException(response);
        return response;
    }

    public RpcResponse getPrivateClientsList(String clientId) throws RPCServiceException {
        log.debug("Register new client RPC service called with parameters - " + clientId);
        RpcRequest request = new RpcRequest()
                .withJsonRpc("2.0")
                .withMethod("GET_REGISTERED_CLIENTS")
                .withId("1")
                .withParameters(clientId);
        log.debug("Register new client RPC request prepared with parameters - " + request);
        RpcResponse response = null;
        try {
            response = connection.exchange(request, "GET");
        } catch (Exception e) {
            log.info("RPC call failed");
        }
        log.debug("Register new client RPC response received - " + response);
        throwServiceException(response);
        return response;
    }


    private RpcResponse getRpcLogDebug(RpcRequest request, String post) {
        log.debug("Register new client RPC request prepared with parameters - " + request);
        RpcResponse response = null;
        try {

            response = connection.exchange(request,"POST");
        } catch (Exception e) {
            log.info("RPC call failed");
        }
        log.debug("Register new client RPC response received - " + response);
        return response;
    }

    private void getLogMessage(Client client) {
        log.debug("Register new client RPC service called with parameters - " + client);
    }

    private void throwServiceException(RpcResponse response) throws RPCServiceException {
        if (response.getErrorCode() != 0) throw new RPCServiceException("Unknown exception");
    }

}


