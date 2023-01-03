package ir.moke.groovy.share;

import java.util.Map;

public interface IOperator {

    String execute(Map<String, String> parameters);

    boolean isSuccess();
}
