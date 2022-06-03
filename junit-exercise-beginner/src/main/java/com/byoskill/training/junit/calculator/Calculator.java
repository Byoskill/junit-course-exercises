package com.byoskill.training.junit.calculator;

public class Calculator {
    
    private float result = 0.0f;
    
    public void add(float value) {
        result += value;
    }

    public void minus(float value) {
        result -= value;
    }

    public void divide(float value) {
        result /= value;
    }
    
    public float getCurrentResult() {
        return result;
    }
    
    public boolean isZeroResult() {
        return result == 0.0;
    }
    
    public void reset() {
        result = 0;
    }
}
