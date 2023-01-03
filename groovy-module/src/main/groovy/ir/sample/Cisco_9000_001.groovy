package ir.sample

import ir.moke.groovy.share.IOperator


public class ClassA {

}

public class ClassB {

}

public class classC implements IOperator {

    @Override
    String execute(Map<String, String> parameters) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();
        return null
    }

    @Override
    boolean isSuccess() {
        return false
    }
}