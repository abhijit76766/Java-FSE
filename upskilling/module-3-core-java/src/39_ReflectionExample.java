import java.lang.reflect.Method;

class ReflectionTarget {
    public void greet(String name) {
        System.out.println("Hello " + name);
    }
}

class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ReflectionTarget");
        Object target = clazz.getDeclaredConstructor().newInstance();
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
        Method greet = clazz.getDeclaredMethod("greet", String.class);
        greet.invoke(target, "Codex");
    }
}

