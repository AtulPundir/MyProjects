package com.ap.design.lld_design.rewardsranking;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomerRankingServiceRedis {
    private final StringRedisTemplate redisTemplate;
    private final ZSetOperations<String, String> zSetOps;

    public CustomerRankingServiceRedis(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.zSetOps = redisTemplate.opsForZSet();
    }

    // Add customer to ranking
    public void addCustomer(String customerId, double rewardPoints) {
        zSetOps.incrementScore("customer_rankings", customerId, rewardPoints);      //ZINCRBY
    }

    // Get top-N customers
    public Set<String> getTopNCustomers(int n) {
        return zSetOps.reverseRange("customer_rankings", 0, n - 1);
    }

    // Get rank of a specific customer
    public Long getCustomerRank(String customerId) {
        return zSetOps.reverseRank("customer_rankings", customerId);
    }

    public Long getCustomerRankAscPoints(String customerId) {
        return zSetOps.rank("customer_rankings", customerId);
    }

    public static void main(String[] args) {

        //LettuceConnectionFactory factory = new LettuceConnectionFactory("redis.myserver.com", 6380);
        //factory.setPassword("mySecretPassword"); // Set password if authentication is needed
        //factory.afterPropertiesSet(); // Ensure initialization

        // Create Redis connection factory
        RedisConnectionFactory redisConnectionFactory = new LettuceConnectionFactory();
        ((LettuceConnectionFactory) redisConnectionFactory).afterPropertiesSet();  //Ensure proper initialization

        // Initialize StringRedisTemplate
        StringRedisTemplate redisTemplate = new StringRedisTemplate(redisConnectionFactory);

        // Create ranking service
        CustomerRankingServiceRedis rankingService = new CustomerRankingServiceRedis(redisTemplate);

        // Add customers and test ranking
        /*rankingService.addCustomer("C123", 7000);
        rankingService.addCustomer("C456", 3900);
        rankingService.addCustomer("C124", 8000);
        rankingService.addCustomer("C457", 5900);
        rankingService.addCustomer("C125", 6000);
        rankingService.addCustomer("C458", 7900);*/

       // rankingService.addCustomer("C459", 70);
   
        Set<String> topCustomers = rankingService.getTopNCustomers(10);
      

        System.out.println("Top Customers: " + topCustomers);
        System.out.println("Rank of C123: " + rankingService.getCustomerRank("C458"));
        System.out.println("Rank Asc of C458: " + rankingService.getCustomerRankAscPoints("C458"));

        ZSetOperations<String, String> zSetOps =redisTemplate.opsForZSet();

        System.out.println("RANGE BY SCORE ");
        System.out.println(zSetOps.rangeByScore("customer_rankings",5000,12000));

        //Set<V> rangeByScore(K key, double min, double max, long offset, long count);
        System.out.println(zSetOps.rangeByScore("customer_rankings",5000,12000,5000,9000));
        System.out.println(zSetOps.rangeByScore("customer_rankings",5000,12000,3,1));

        System.out.println("RANGE WITH SCORE ");
        System.out.println(zSetOps.rangeWithScores("customer_rankings",5000,12000));

        System.out.println("RANGE BY SCORE WITH SCORE ");
        System.out.println(zSetOps.rangeByScoreWithScores("customer_rankings",5000,12000));

        //Set<TypedTuple<V>> rangeByScoreWithScores(K key, double min, double max, long offset, long count);
        System.out.println(zSetOps.rangeByScoreWithScores("customer_rankings",5000,12000, 3,2));
        System.out.println(zSetOps.rangeByScoreWithScores("customer_rankings",5000,12000, 3,1));


    }
}
