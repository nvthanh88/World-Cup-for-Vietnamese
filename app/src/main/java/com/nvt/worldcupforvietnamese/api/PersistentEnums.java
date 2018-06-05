package com.nvt.worldcupforvietnamese.api;

import java.util.HashMap;
import java.util.Map;

public class PersistentEnums {
    public static <V, T extends Enum<T> & PersistentEnum<V>> Map<V, T> index(Class<T> clazz) {
        final T[] constants = clazz.getEnumConstants();
        final Map<V, T> r = new HashMap<V, T>();
        for(T t : constants) r.put(t.getValue(), t);
        return r;
    }
}
