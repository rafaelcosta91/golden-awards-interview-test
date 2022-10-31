package br.com.texo.goldenawardsinterviewtest.enums;

public enum IntervalType {
    MAX(0), MIN(999);
    
    IntervalType(int value) {
        this.value = value;
    }

    Integer value;
    
    public Integer getValue() {
        return this.value;
    }
}
