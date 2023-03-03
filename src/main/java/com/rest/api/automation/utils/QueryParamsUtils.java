package com.rest.api.automation.utils;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class QueryParamsUtils {
    Map<String, List<String>> queryParamsList = new HashMap<String, List<String>>();
    Map<String, Object> queryParams1 = new HashMap<String, Object>();
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    public QueryParamsUtils setQueryParams(String key, String value) {
        queryParams.put(key, value);
        return this;
    }

    public QueryParamsUtils setQueryParamsList(String key, List<String> value) {
        queryParamsList.put(key, value);
        return this;
    }

    public QueryParamsUtils setQueryParams(String key, int value) {
        queryParams1.put(key, value);
        return this;
    }

    public void clearQueryParams() {
        queryParams.clear();
        queryParamsList.clear();
    }
}