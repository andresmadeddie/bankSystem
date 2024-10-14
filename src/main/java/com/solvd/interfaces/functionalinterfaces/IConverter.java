package com.solvd.interfaces.functionalinterfaces;

public interface IConverter<A, R>{
    A convert (A aObject, R rate);
}
