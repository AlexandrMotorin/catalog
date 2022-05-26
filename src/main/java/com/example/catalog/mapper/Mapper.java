package com.example.catalog.mapper;

public interface Mapper <F,T>{
    F mapTo(T t);
    T mapFrom(F f);
}
