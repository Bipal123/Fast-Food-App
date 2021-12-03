package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.dto.OrderHistory;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderHistory, Integer> {
}
