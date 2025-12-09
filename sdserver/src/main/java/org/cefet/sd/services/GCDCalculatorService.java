package org.cefet.sd.services;

public class GCDCalculatorService {
    public int calculateGCD(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int tmp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = tmp;
        }
        return firstNumber;
    }
}
