package org.example.lv2;

import org.example.lv3.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//calculate(int a, int b, char operator) 메서드로 사칙연산 수행, 결과 저장
public class Calculator {
    //연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    private List<Double> resultHistory = new ArrayList<>();
    private static final int MAX_RESULTS = 5;

    //게터 메서드 구현
    public List<Double> getResultHistory() {
        return this.resultHistory;
    }

    //세터 메서드 구현
    public void setResultHistory(List<Double> resultHistory) {
        this.resultHistory = resultHistory;
    }

    //연산후 게터 resultHisoty 비우기
    public void removeFirstResult() {
        if (!resultHistory.isEmpty()) {
            resultHistory.remove(0);
        }
    }

    public <T extends Number> Double calculate(T a, T b, char operator) {
        double firstValue = a.doubleValue();
        double secondValue = b.doubleValue();
        Operator op = Operator.fromSymbol(String.valueOf(operator));
        double result = op.apply(firstValue, secondValue);

        if (resultHistory.size() >= MAX_RESULTS){
            resultHistory.remove(0);
        }
        //결과 저장
        resultHistory.add(result);
        return result;
    }
    public List<Double> searchBiggerThan(double value){
        return resultHistory.stream()
                .filter(r->r>value)
                .collect(Collectors.toList());
    }
}

