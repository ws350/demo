package classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Desc:
 * @Auth: vansn
 * @Date: 2021/11/1 下午2:52
 */
public class MyClassLoaderTest {

    static class MyClassLoader extends  ClassLoader{
        private String classpath;

        public MyClassLoader(String classpath){
            this.classpath = classpath;
        }
        //加载文件信息
        private byte[] loadByte(String name) throws IOException {
            name = name.replaceAll("\\.","/");
            FileInputStream fis = new FileInputStream(classpath +"/"+name+".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;

        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try{
                byte[] data =   loadByte(name);
                //将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组
                return defineClass(name,data,0,data.length);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }

        }

        public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
            MyClassLoader classLoader = new MyClassLoader("D:/test");
            Class clazz = classLoader.loadClass("com.tuling");
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("sout",null);
            method.invoke(obj,null);
            System.out.println();

        }



    }
}
