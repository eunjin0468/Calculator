package org.example.lv3;

public enum Operator {
    PLUS("+"){
        @Override //추상 메서드 재정의
        public double apply(double a, double b) {
            return a+b;
        }
    },
    MINUS("-"){
        @Override
        public double apply(double a, double b){
            return a-b;
        }
    },
    MULTIPLY("*"){
        @Override
        public double apply(double a, double b){
            return a*b;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double a, double b){
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return a/b;
        }
    };

    private final String symbol; //연산 기호 저장

    //생성자
    Operator(String symbol) {
        this.symbol = symbol;
    }

    //기호 꺼내기
    public String getSymbol() {
        return symbol;
    }

    //연산자 동작
    //추상 메서드 (각 연산자가 구현함), 모든 연산자들이 공통 메서드를 갖게 하기 위함
    public abstract double apply(double a, double b);

    //기호로 enum찾기
    public static Operator fromSymbol(String symbol){
        for (Operator op:values()){
            if(op.getSymbol().equals(symbol)){
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + symbol + " (사용 가능: +, -, *, /)");
    }
}