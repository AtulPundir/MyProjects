package com.ap.pre.designpatterns.strategy;

public enum StrategyByEnum {

    SALE {
        @Override
        public int disPercentage() {
            return 10;
            
        }
    }, REPUBLIC {
        @Override
        public int disPercentage() {
           return 20;
        }
    }, FREEDOM {
        @Override
        public int disPercentage() {
           return 50;
        }
    };


    public abstract int disPercentage();

}
