package com.example.tk.repository;

import com.example.tk.entities.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
    @Query(value = "Select * from orders o where (o.nameorder = ?1 or ?1 is null or ?1 like '' ) ",nativeQuery = true)
    List<Order> order (String name);


}
