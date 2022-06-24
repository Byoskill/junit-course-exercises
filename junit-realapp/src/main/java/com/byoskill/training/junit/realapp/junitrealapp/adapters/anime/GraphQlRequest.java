package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

import java.util.HashMap;
import java.util.Map;

public class GraphQlRequest {

    private String query;
    private Map<String, Object> variables = new HashMap<String, Object>();

    public GraphQlRequest() {
    }

    public GraphQlRequest(String query, Map<String, Object> variables) {
        this.query = query;
        this.variables = variables;
    }

    public GraphQlRequest(String req) {
        this.query = req;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public void putVariable(String key, Object value) {
        this.variables.put(key, value);
    }
}
