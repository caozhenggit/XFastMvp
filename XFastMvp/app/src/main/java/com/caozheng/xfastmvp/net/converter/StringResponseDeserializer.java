package com.caozheng.xfastmvp.net.converter;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * @author caozheng
 * @date 2018/1/6
 * <p>
 * describe:
 */

public class StringResponseDeserializer implements JsonDeserializer<BaseResponse<String>> {
    private Gson gson = new Gson();

    @Override
    public BaseResponse<String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        if (json.isJsonObject()) {
            JsonObject asJsonObject = json.getAsJsonObject();
            JsonElement data = asJsonObject.get("data");
            JsonElement code = asJsonObject.get("code");
            JsonElement msg = asJsonObject.get("message");

            baseResponse.setCode(code.getAsInt());
            baseResponse.setMsg(msg.getAsString() == null ? "" : msg.getAsString());
            if (data != null) {
                if (data.isJsonArray() || data.isJsonObject()) {
                    String s = gson.toJson(data);
                    baseResponse.setData(s);
                    return baseResponse;
                } else if (data.isJsonNull()) {
                    //data为null,不做处理
                } else {
                    baseResponse.setData(data.getAsString());
                }
            }
        }
        return baseResponse;
    }
}
