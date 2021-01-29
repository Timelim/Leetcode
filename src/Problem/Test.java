package Problem;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.math.BigDecimal;

public class Test {
    public void test(){
        double A1=0.862+0.06685;
        double A2=0.10691;
        double x0=0.0135;
        double p=1.36272;
        double y=0.9;
        double x;

        System.out.println("A1: "+A1);
        double tmp1=y-A2;
        System.out.println("y-A2: "+tmp1);
        double tmp2=A1-A2;
        System.out.println("A1-A2: "+tmp2);
        double tmp3=tmp2/tmp1;
        System.out.println("(y-A2)/(A1-A2): "+tmp3);
        double tmp4=tmp3-1.0;
        System.out.println("(y-A2)/(A1-A2)-1.0: "+tmp4);
        x=Math.pow(tmp4,1.0/p)*x0;
        System.out.println("x: "+x);

    }
    public void test2(){
        BigDecimal A1=new BigDecimal(0.862);
        BigDecimal A2=new BigDecimal(0.10691);
        BigDecimal x0=new BigDecimal(0.0135);
        BigDecimal p=new BigDecimal(1.36272);
        BigDecimal y=new BigDecimal(0.9);
        BigDecimal x;

        BigDecimal tmp1=A1.subtract(A2);
        System.out.println(tmp1);
        BigDecimal tmp2=y.subtract(A2);
        System.out.println(tmp2);
        BigDecimal tmp3=tmp1.divide(tmp2);
        System.out.println(tmp3);
        BigDecimal tmp4=tmp3.subtract(BigDecimal.valueOf(1.0));
        System.out.println(tmp4);
    }
    public static void main(String[] args) {
        Test t= new Test();
        t.test();

    }
}
