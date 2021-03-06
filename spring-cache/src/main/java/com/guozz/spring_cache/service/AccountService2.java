package com.guozz.spring_cache.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

import com.google.common.base.Optional;
import com.guozz.spring_cache.domain.Account;

/**
 * @author guozhizhong
 * @version 2016-12-21 10:00:11
 */
public class AccountService2 {

	 private final Logger logger = LoggerFactory.getLogger(AccountService2.class);	
	 
	 
	 // 
	 /**
	  * 使用了一个缓存名叫 accountCache</br>
	  * 这个注释的意思是，当调用这个方法的时候，会从一个名叫 accountCache 的缓存中查询，</br>
	  * 如果没有，则执行实际的方法（即查询数据库），并将执行的结果存入缓存中，否则返回缓存中的对象。</br>
	  * 这里的缓存中的 key 就是参数 accountName，value 就是 Account 对象。</br>
	  * “accountCache”缓存是在 spring*.xml 中定义的名称。我们还需要一个 spring 的配置文件来支持基于注释的缓存
	  * @param accountName
	  * @return
	  */
	 @Cacheable(value="accountCache")
	 public Account getAccountByName(String accountName) {
	        // 方法内部实现不考虑缓存逻辑，直接实现业务
	        logger.info("real querying account... {}", accountName);
	        Optional<Account> accountOptional = getFromDB(accountName);
	        if (!accountOptional.isPresent()) {
	            throw new IllegalStateException(String.format("can not find account by account name : [%s]", accountName));
	        }
	 
	        return accountOptional.get();
	    }
	 
	    private Optional<Account> getFromDB(String accountName) {
	        logger.info("real querying db... {}", accountName);
	        //Todo query data from database
	        return Optional.fromNullable(new Account(accountName));
	    }
}
