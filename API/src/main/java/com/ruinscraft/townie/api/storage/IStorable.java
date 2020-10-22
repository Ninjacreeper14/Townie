package com.ruinscraft.townie.api.storage;

import java.util.concurrent.CompletableFuture;

public interface IStorable<T> {

    CompletableFuture<Void> save(T t);

    CompletableFuture<T> load(int id);

}
