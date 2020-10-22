package com.ruinscraft.townie.api;

import com.ruinscraft.townie.api.community.CommunityPermission;

import java.util.Set;
import java.util.UUID;

public interface IRole {

    UUID getId();

    String getName();

    Set<CommunityPermission> getPermissions();

    default boolean hasPermission(CommunityPermission permission) {
        return getPermissions().contains(permission);
    }

}
