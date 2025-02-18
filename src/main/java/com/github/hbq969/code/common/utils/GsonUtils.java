package com.github.hbq969.code.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author : hbq969@gmail.com
 * @description : Gson工具类
 * @createTime : 2023/12/21 13:36
 */
public class GsonUtils {
    private final static Gson GSON = new Gson();

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }

    public static <T> T fromJson(String str, Class<T> clz) {
        return GSON.fromJson(str, clz);
    }

    public static <T> List<T> parseArray(String str, TypeToken<List<T>> token) {
        return GSON.fromJson(str, token.getType());
    }
}
