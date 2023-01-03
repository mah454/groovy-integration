package ir.moke.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import ir.moke.groovy.share.IOperator;
import org.codehaus.groovy.jsr223.GroovyScriptEngineFactory;
import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public class OperatorManager {
    public static void run(File scriptFile) {
        try {
            GroovyScriptEngineImpl engine = (GroovyScriptEngineImpl) new GroovyScriptEngineFactory().getScriptEngine();
            GroovyClassLoader classLoader = new GroovyClassLoader();

            classLoader.parseClass(new GroovyCodeSource(scriptFile));
            engine.setClassLoader(classLoader);

            Class<?>[] loadedClasses = engine.getClassLoader().getLoadedClasses();

            Class<?> operatorImplClass = Arrays.stream(loadedClasses)
                    .filter(IOperator.class::isAssignableFrom)
                    .findFirst().orElse(null);

            if (operatorImplClass != null) {
                String result = invokeMethod(operatorImplClass);
                System.out.println(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String invokeMethod(Class<?> item) {
        try {
            Object instance = item.getConstructor().newInstance();
            Method execute = item.getDeclaredMethod("execute", Map.class);
            return (String) execute.invoke(instance, new Object[]{null});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
