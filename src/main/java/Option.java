import java.util.Scanner;

public class Option {
    private int ide;
    public int option()
    {
        System.out.println("    (Design by 温柔白夜)学生管理系统-v1.0: \n[option]\n1.用户登录\n0.系统退出");
        Scanner sc=new Scanner(System.in);
        ide=sc.nextInt();
        switch (ide)
        {
            case 1:{
                System.out.println("    用户登录界面");
                UserLogin ul=new UserLogin();
                ul.login();
                System.out.println("    系统退出..请稍等");
                break;
            }
            case 0:{
                System.out.println("    系统退出..请稍等");
                break;
            }
        }
        return ide;
    }
}
