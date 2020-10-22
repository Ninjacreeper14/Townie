package com.ruinscraft.townie.api;

import java.util.UUID;

public interface ILocation {

    UUID getId();

    String getWorldName();

    double getX();

    double getY();

    double getZ();

    double getYaw();

    double getPitch();

}
