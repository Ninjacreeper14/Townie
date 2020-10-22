package com.ruinscraft.townie.api;

import com.ruinscraft.townie.api.storage.ICommunityStorage;
import com.ruinscraft.townie.api.storage.IResidentStorage;
import com.ruinscraft.townie.api.storage.IRoleStorage;

public interface ITownie {

    TConfig getTConfig();

    ICommunityStorage getCommunityStorage();

    IResidentStorage getResidentStorage();

    IRoleStorage getRoleStorage();

    void enable();

    void disable();

}
