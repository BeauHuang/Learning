import org.junit.Test;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/12 0:02
 * @Version 1.0
 */
public class Test01 {

   @Test
    public void test01(){
       C a = new A();
       a.test();
   }

    @Test
    public void test02(){

        System.out.println(A.class.isAssignableFrom(B.class));
        System.out.println(B.class.isAssignableFrom(A.class));
    }

}


class A extends B implements C{


}

class B{
    public void test() {
        System.out.println("执行了！");
    }
}

interface C{

    void test();
}