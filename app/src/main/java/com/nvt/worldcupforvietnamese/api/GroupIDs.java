package com.nvt.worldcupforvietnamese.api;

import java.util.Map;

public enum GroupIDs implements PersistentEnum<String> {
    GROUP_A("A","793"),
    GROUP_B("B","794"),
    GROUP_C("C","795"),
    GROUP_D("Group D","796"),
    GROUP_E("Group E","797"),
    GROUP_F("Group F","798"),
    GROUP_G("Group G","799"),
    GROUP_H("Group H","800"),
    ;

    private static final Map<String,GroupIDs> INDEX = PersistentEnums.index(GroupIDs.class);

    GroupIDs(String displayName, String value) {
        this.displayName = displayName;
        this.value = value;
    }

    private String displayName;
    private String value;
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public Map<String, ? extends PersistentEnum<String>> getAll() {
        return INDEX;
    }
    public static GroupIDs parse(String value) {
        return value == null ? null : INDEX.get(value);
    }
}
