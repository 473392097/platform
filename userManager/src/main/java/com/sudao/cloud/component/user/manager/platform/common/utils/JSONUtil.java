package com.sudao.cloud.component.user.manager.platform.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/9.
 */
public class JSONUtil {

    private static final Logger logger = LoggerFactory.getLogger(JSONUtil.class);
    private static final ObjectMapper mapper = ObjectMapperHolder.getObjectMapper();

    public static String getStringJSONValue(JSONObject obj, String key){
        if (obj.containsKey(key)){
            return obj.getString(key);
        }
        return "";
    }

    public static int getIntJSONValue(JSONObject obj, String key){
        if (obj.containsKey(key)){
            return obj.getIntValue(key);
        }
        return 99;
    }

    public static double getDoubleJSONValue(JSONObject obj, String key){
        if (obj.containsKey(key)){
            return obj.getDoubleValue(key);
        }
        return 99;
    }

    public static long getLongJSONValue(JSONObject obj, String key){
        if (obj.containsKey(key)){
            return obj.getLongValue(key);
        }
        return 99;
    }

    public static boolean getBooleanJSONValue(JSONObject obj, String key){
        if (obj.containsKey(key)){
            return obj.getBooleanValue(key);
        }
        return false;
    }

    public static JSONObject getJSONObjectValue(JSONObject obj, String key) {
        if (obj.containsKey(key)){
            if (obj.get(key) instanceof JSONObject) {
                return obj.getJSONObject(key);
            } else {
                return null;
            }
        }
        return null;
    }

    public static JSONArray getJSONArrayValue(JSONObject obj, String key) {
        if (obj.containsKey(key)){
            return obj.getJSONArray(key);
        }
        return null;
    }

    public static <T> T fromJsonQuietly(String json, Class<T> type) {
        try {
            json = json.replaceAll("'", "\"");
            return fromJson(json, type);
        } catch (Exception e) {
            logger.error("fromJson failed: {}", e.getMessage(), e);
        }
        return null;
    }

    public static <T> List<T> fromListJson(String json, Class<T> type) {
        if (type == null || json == null) {
            return null;
        }
        try {
            json = json.replaceAll("'", "\"");
            JavaType javaType = getCollectionType(ArrayList.class, type);
            List<T> lst = (List<T>) mapper.readValue(json, javaType);
            return lst;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJsonIgnoreNull(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            String json = mapper.writeValueAsString(obj);

            return json;
        } catch (Exception e) {
            logger.error("toJson failed: {}", e.getMessage(), e);
        }
        return null;
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static <T> T fromJson(String json, Class<T> type) {
        if (type == null || json == null) {
            return null;
        }
        try {
            json = json.replaceAll("'", "\"");
            return mapper.readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, String> fromJsonQuietly(String json) {
        try {
            if (json != null) {
                return mapper.readValue(json, new TypeReference<HashMap<String, String>>() {
                });
            }
        } catch (Exception e) {
            logger.error("fromJsonQuietly failed: {}", e.getMessage(), e);
        }
        return null;
    }

    public static String toJsonQuietly(Object obj) {
        try {
            return toJson(obj);
        } catch (Exception e) {
            logger.error("toJson failed: {}", e.getMessage(), e);
        }
        return null;
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            String json = mapper.writeValueAsString(obj);
            return json;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class ObjectMapperHolder {
        public static ObjectMapper getObjectMapper() {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(org.codehaus.jackson.map.DeserializationConfig.Feature.USE_ANNOTATIONS);
            mapper.disable(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.disable(org.codehaus.jackson.map.DeserializationConfig.Feature.WRAP_EXCEPTIONS);

            mapper.disable(org.codehaus.jackson.map.SerializationConfig.Feature.USE_ANNOTATIONS);
            return mapper;
        }
    }

    public static void main(String[] args){
        List<Long> ids = new ArrayList<>();
        ids.add(1001L);
        ids.add(1002L);
        ids.add(1003L);

        String json = toJson(ids);
        System.out.println("json: "+json);

        List<Long> target = fromJsonQuietly(json, List.class);
        System.out.println("target: "+target);
    }
}
