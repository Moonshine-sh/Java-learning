package org.example.screensaver;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.security.KeyPair;
import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.*;


public class PeriodicalScopeConfigurer implements Scope {
    Map<String, Map.Entry<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (map.containsKey(name)) {
            Map.Entry<LocalTime, Object> entry = map.get(name);
            int secondSinceLastRequest = now().getSecond() - entry.getKey().getSecond();
            if (secondSinceLastRequest > 3) {
                map.put(name, new AbstractMap.SimpleEntry<>(now(), objectFactory.getObject()));
            }
        } else {
            map.put(name, new AbstractMap.SimpleEntry<>(now(), objectFactory.getObject()));
        }

        return map.get(name).getValue();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
