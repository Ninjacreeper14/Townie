package com.ruinscraft.townie.api.community;

import com.ruinscraft.townie.api.ILocation;
import com.ruinscraft.townie.api.IResident;
import com.ruinscraft.townie.api.IRole;

import java.util.Map;
import java.util.UUID;

public interface ICommunity {

    //

    UUID getId();

    String getName();

    String getBoard();

    long getCreatedTime();

    boolean isPublic();

    boolean isOpen();

    //

    Map<IResident, IRole> getMembers();

    ILocation getSpawnPoint();

}
