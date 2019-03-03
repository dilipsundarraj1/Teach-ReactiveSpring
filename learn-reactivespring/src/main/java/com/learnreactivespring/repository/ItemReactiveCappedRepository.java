package com.learnreactivespring.repository;

import com.learnreactivespring.document.Item;
import com.learnreactivespring.document.ItemCapped;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemReactiveCappedRepository extends ReactiveMongoRepository<ItemCapped,String> {


    @Tailable
    Flux<ItemCapped> findItemsBy();
}
