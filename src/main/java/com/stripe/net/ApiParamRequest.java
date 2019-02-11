package com.stripe.net;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ApiParamRequest {

  public Map<String, Object> toMap() {
    JsonObject json = ApiResource.GSON.toJsonTree(this).getAsJsonObject();
    return populateMapFromJsonObject(json);
  }

  private Object deserializeJsonPrimitive(JsonPrimitive element) {
    if (element.isBoolean()) {
      return element.getAsBoolean();
    } else if (element.isNumber()) {
      return element.getAsNumber();
    } else {
      return element.getAsString();
    }
  }

  private Object[] deserializeJsonArray(JsonArray arr) {
    Object[] elems = new Object[arr.size()];
    Iterator<JsonElement> elemIter = arr.iterator();
    int i = 0;
    while (elemIter.hasNext()) {
      JsonElement elem = elemIter.next();
      elems[i++] = deserializeJsonElement(elem);
    }
    return elems;
  }

  private Object deserializeJsonElement(JsonElement element) {
    if (element.isJsonNull()) {
      return null;
    } else if (element.isJsonObject()) {
      return populateMapFromJsonObject(element.getAsJsonObject());
    } else if (element.isJsonPrimitive()) {
      return deserializeJsonPrimitive(element.getAsJsonPrimitive());
    } else if (element.isJsonArray()) {
      return deserializeJsonArray(element.getAsJsonArray());
    } else {
      System.err.println("Unknown JSON element type for element " + element + ". "
          + "If you're seeing this messaage, it's probably a bug in the Stripe Java "
          + "library. Please contact us by email at support@stripe.com.");
      return null;
    }
  }

  private Map<String, Object> populateMapFromJsonObject(JsonObject jsonObject) {
    Map<String, Object> objectMap = new LinkedHashMap<>();
    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
      String key = entry.getKey();
      JsonElement element = entry.getValue();
      objectMap.put(key, deserializeJsonElement(element));
    }
    return objectMap;
  }
}

