package com.ruinscraft.townie.api;

import java.util.UUID;

public interface IResident {

    UUID getMojangId();

    String getUsername();

    long getFirstSeen();

    long getLastSeen();

}
