package com.rest.api.automation.utils;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.LinkedHashMap;

public class RestAPIUtils {
    static String env;

    //Get the environment details to run the tests
    public static String getEnvToRun() {
        String url = null;
        if (System.getProperty("environment") != null) {
            env = System.getProperty("environment");
        } else {
            env = ConfigHelper.returnPropVal("config", "environment");
        }
        switch (env.toLowerCase()) {
            case "qa":
            case "test":
                url = ConfigHelper.GetBaseUrl("testUrl");
                break;
            case "dev":
                url = ConfigHelper.GetBaseUrl("devUrl");
                break;
            default:
                System.out.println("Invalid case");
        }
        return url;
    }

    // Get DbEnvDetails
    public static String getDbEnvDetails() {
        String dbEnv = null;
        if (System.getProperty("environment") != null) {
            env = System.getProperty("environment");
        } else {
            env = ConfigHelper.returnPropVal("config", "environment");
        }
        switch (env.toLowerCase()) {
            case "qa":
            case "test":
                dbEnv = TestConstants.ENV_QA;
                break;
            case "dev":
                dbEnv = TestConstants.ENV_QA;
                break;
            default:
                System.out.println("Invalid Environment in Config.properties file");
        }
        return dbEnv;
    }

    public static String getDbName(String db_Name, String environment) {
        if (environment.equalsIgnoreCase("")) {
            System.out.println("Inappropriate or empty Environment");
        } else if (environment.equalsIgnoreCase(TestConstants.ENV_QA)
                || environment.equalsIgnoreCase(TestConstants.ENV_DEV)) {
            return db_Name;
        }
        return "Inappropriate or null DB name";
    }

    /**
     * Handling only one Key
     *
     * @param response
     * @param key
     * @return Handling only one Key
     * @deprecated
     */
    public static String getSpecificJsonAttribute(Response response, String key) {
        JSONObject json = new JSONObject(response.asString());
        JSONObject data = json.getJSONObject("data");
        return data.getString(key);
    }

    /**
     * @param response
     * @param key
     * @return Returns json Attribute to any number of keys, The keys can be 1 to
     * anyNumber, the method will handle all keys and returns the required
     * attributes from response
     */
    public static LinkedHashMap<String, String> getSpecificJsonAttribute(Response response, String[] key) { //specific data from response
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        JSONObject json = new JSONObject(response.asString());
        JSONObject data = json.getJSONObject("data");
        for (int i = 0; i < key.length; i++) {
            map.put(key[i], data.getString(key[i]));
        }
        return map;
    }

    /**
     * Extends the jsonObject to retrieve value. For Instance the JSONObject data
     * has nested JSONObject user which has user details or any nested JSONObject
     * Need to pass that nested JSONObject as String, the method will merge that
     * with data and retrieves to fetch the values.
     *
     * @param response
     * @param object
     * @param key
     * @return
     */
    public static LinkedHashMap<String, String> getSpecificJsonAttribute(Response response, String object,
                                                                         String[] key) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        JSONObject json = new JSONObject(response.asString());
        JSONObject data = json.getJSONObject("data");
        JSONObject dataObject = data.getJSONObject(object);
        for (int i = 0; i < key.length; i++) {
            map.put(key[i], dataObject.getString(key[i]));
        }
        return map;
    }
}