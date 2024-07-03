package com.example.caffeinecache;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.concurrent.TimeUnit;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CaffeineCacheApplication {

    private static Cache<String, Person> manualCache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();

    public static void main(String[] args) {

//        manualCache() ;
//        synchronousLoading() ;
        asynchronousLoading() ;

    }

    private static void manualCache() {
        Person dataObject1 = manualCache.getIfPresent("person1") ;

       System.out.println(dataObject1) ;

        Person dataObject2 = manualCache
                .get("person2", k -> new Person("테스트2", 25, "75", "180"));

        System.out.println(dataObject2) ;
        System.out.println(manualCache.getIfPresent("person2")) ;
    }

    private static void synchronousLoading() {
        LoadingCache<String, Person> synchronousLoadingCache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .build(k -> new Person()) ;

        Person dataObject = synchronousLoadingCache.get("person");
        System.out.println(dataObject) ;
    }

    private static void asynchronousLoading() {
        AsyncLoadingCache<String, Person> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .buildAsync(k -> new Person());
    }



}