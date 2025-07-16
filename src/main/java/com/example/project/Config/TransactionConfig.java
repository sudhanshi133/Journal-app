package com.example.project.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {
    private PlatformTransactionManager add(MongoDatabaseFactory databaseFactory) {
        return new MongoTransactionManager(databaseFactory);
    }
}
// Spring Boot auto-configures transaction manager, but defining it manually gives control:
// 1) Use specific DB for transactions in multi-DB setups
// 2) Customize rollback or use manual transactions
// 3) (Advanced) Add timeout or custom logic via wrappers
// 4) Fail fast if Mongo doesn’t support transactions (like in standalone mode)
// I DID NOT MAKE A REPLICA so i made a standalone mongo db. which means it would not support transaction
