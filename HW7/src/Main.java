import java.lang.reflect.Method;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws Exception {
        //noinspection rawtypes
        Class c = MyClass.class;
        Object testObj = c.newInstance();
        Method[] methods = c.getDeclaredMethods();
        ArrayList<Method> al = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        for (Method o : c.getDeclaredMethods()) {
            if (o.isAnnotationPresent(Test.class)) {
                al.add(o);
            }
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) beforeMethod = o;
                else throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) afterMethod = o;
                else throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");
            }
            al.sort((o1, o2) -> o2.getAnnotation(Test.class).priority()-o1.getAnnotation(Test.class).priority());
        }


        if (beforeMethod != null) beforeMethod.invoke(testObj, (Object[]) null);
        for (Method o : al) o.invoke(testObj, (Object[]) null);
        if (afterMethod != null) afterMethod.invoke(testObj, (Object[]) null);
    }
}