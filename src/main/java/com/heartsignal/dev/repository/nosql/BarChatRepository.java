package com.heartsignal.dev.repository.nosql;

import com.heartsignal.dev.domain.nosql.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarChatRepository extends MongoRepository<Chat, String> {

}