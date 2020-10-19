import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    //指定路径
    private String path ;

    public MyClassLoader(String classPath){
        path=classPath;
    }

    public static void main(String[] args) throws Exception {
        //这个类class的路径
        String classPath = "D://architect_workspace/src/Hello.class";
        MyClassLoader myClassLoader = new MyClassLoader(classPath);
        //类的全称
        String packageNamePath = "Hello";

        //加载Hello这个class文件
        Class<?> Hello = myClassLoader.loadClass(packageNamePath);

        //利用反射获取main方法
        Method method = Hello.getDeclaredMethod("hello");
        Object object = Hello.newInstance();
        method.invoke(object);
    }


}