package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author www
 * @version 1.0
 * @date 2021/9/23
 * @effect
 */
public class ReflectionTest {
    public Object copy(Object object)throws Exception{
        //获取对象类型
        Class classType = object.getClass();
        System.out.println("Class:"+classType.getName());

        //通过默认构造方法创建一个新的对象
        Object objectCopy = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});

        //获取对象所有属性
        Field fields[] = classType.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            //字段名称
            String fieldName = field.getName();

            String firstLetter = fieldName.substring(0,1).toUpperCase();
            //获取和属性对应的getXXX()方法的名字
            String getMethodName = "get"+firstLetter+fieldName.substring(1);
            ////获取和属性对应的setXXX()方法的名字
            String setMethodName = "set"+firstLetter+fieldName.substring(1);

            //获取和属性对应的getXXX()方法
            Method getMethod = classType.getMethod(getMethodName,new Class[]{});
            //获取和属性对应的setXXX()方法
            Method setMethod = classType.getMethod(setMethodName,new Class[]{field.getType()});

            //调用原对象getXXX()方法
            Object value = getMethod.invoke(object,new Object[]{});
            System.out.println(fieldName+":"+value);
            //调用拷贝setXXX()方法
            setMethod.invoke(objectCopy,new Object[]{value});
        }
        return objectCopy;
    }

    public static void main(String[] args) throws Exception{
        Customer customer = new Customer();
        customer.setId(10L);
        customer.setName("adam");
        customer.setAge(3);

        new ReflectionTest().copy(customer);
    }
}
