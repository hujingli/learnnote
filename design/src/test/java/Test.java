/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 03 日
 * @Description
 * @since
 */
public class Test extends Parent {

    Test(int x, int y) {
        super(x, y);
    }

    public void hello() {
        System.out.println(this.x + "==" + this.y);
        System.out.println(super.x + "===" + super.y);
    }

    public static void main(String[] args) {
        Test test = new Test(10, 10){
            {

            }
        };
    }

    @Override
    public String toString() {
        return "Test{" +
                "x=" + x +
                "} " + super.toString();
    }
}

class Parent{
    int x ,y;

    Parent(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
