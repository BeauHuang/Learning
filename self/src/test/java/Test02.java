import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/5/8 23:05
 * @Version 1.0
 */
public class Test02 {

    @Test
    public void test01(){
        List<Integer> res1 = Arrays.asList(1, 2, 3);
        List<Integer> res2 = new ArrayList<>(res1);

        System.out.println(res1.getClass());
        System.out.println(res2.getClass());
    }
}
