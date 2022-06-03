package com.byoskill.training.junit.calculator;

public class Calculator {
    
    private float result = 0.0f;
    
    public void add(int value) {
        result += value;
    }

    public void remove(int value) {
        result -= value;
    }

    public void divide(int value) {
        result /= value;
    }
    
    public float getCurrentResult() {
        return result;
    }
    
    public boolean isZeroResult() {
        return result == 0;
    }
}
