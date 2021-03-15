package com.example.demo.order;

public interface OrderServcie {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
