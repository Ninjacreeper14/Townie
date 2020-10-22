package com.ruinscraft.townie.classic;

import com.ruinscraft.townie.api.ITownie;
import com.ruinscraft.townie.api.TConfig;
import com.ruinscraft.townie.api.storage.ICommunityStorage;
import com.ruinscraft.townie.api.storage.IResidentStorage;
import com.ruinscraft.townie.api.storage.IRoleStorage;
import com.ruinscraft.townie.classic.storage.MySQLCommunityStorage;
import com.ruinscraft.townie.classic.storage.MySQLResidentStorage;
import com.ruinscraft.townie.classic.storage.MySQLRoleStorage;

public class TownieClassic implements ITownie {

    private TConfig config;
    private ICommunityStorage communityStorage;
    private IResidentStorage residentStorage;
    private IRoleStorage roleStorage;

    public TownieClassic(TConfig config) {
        this.config = config;
    }

    @Override
    public TConfig getTConfig() {
        return config;
    }

    @Override
    public ICommunityStorage getCommunityStorage() {
        return communityStorage;
    }

    @Override
    public IResidentStorage getResidentStorage() {
        return residentStorage;
    }

    @Override
    public IRoleStorage getRoleStorage() {
        return roleStorage;
    }

    @Override
    public void enable() {
        // Setup storage
        if (config.storageType.equals("mysql")) {
            String host = config.storageMysqlHost;
            int port = config.storageMysqlPort;
            String database = config.storageMysqlDatabase;
            String username = config.storageMysqlUsername;
            String password = config.storageMysqlPassword;

            communityStorage = new MySQLCommunityStorage(host, port, database, username, password);
            roleStorage = new MySQLRoleStorage(host, port, database, username, password);
            residentStorage = new MySQLResidentStorage(host, port, database, username, password);
        } else {
            throw new RuntimeException("No storage implementation found");
        }
    }

    @Override
    public void disable() {

    }

}
