package com.example.demo.order;

import com.example.demo.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
