package org.itstack.demo.desgin;

import java.util.concurrent.TimeUnit;

public interface CacheService {

    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeOut, TimeUnit timeUnit);

    void del(String key);
}
