import java.io.*;
import java.util.Scanner;

public class UserLogin {
    public void login()
    {
        int a;
        while(true)
        {
            System.out.println("[option]\n1.登录\n2.注册\n3.返回");
            Scanner sc=new Scanner(System.in);
            a=sc.nextInt();
            if(a==3)break;
            else if(a==1){
                System.out.println("用户名");
                String name=sc.next();
                System.out.println("密码");
                String pwd=sc.next();
                int c=-1;
                try{c=is_user(name,pwd);}
                catch (Exception e){e.printStackTrace();}
                if(c==1){
                    System.out.println("登录成功");
                    try{
                        while (true)
                        {
                            StudentInfo st=new StudentInfo();
                            int choice=st.student_system();
                            if(choice==3){ break;}
                            else if(choice==1){st.add_student();st.System_down();}
                            else if(choice==2){st.delete_student();st.System_down();}
                            else {st.manage_stu_info();}
                        }
                    }
                    catch (Exception e){e.printStackTrace();}
                }
                else if(c==0)System.out.println("用户名或密码错误");
                else {System.out.println("无用户请先注册");}
            }
            else {
                try{
                    add_user();
                }
                catch (Exception e){e.printStackTrace();}
            }
        }
    }
    public static int is_user(String name,String pwd)throws Exception
    {

        FileInputStream file=new FileInputStream("src/main/UserInfo.txt");
        if(file.available()==0){file.close();return 2;}
        file.close();
        String data;
        DataInputStream in = new DataInputStream(new FileInputStream("src/main/UserInfo.txt"));
        BufferedReader d  = new BufferedReader(new InputStreamReader(in));
        while ((data=d.readLine())!=null)
        {
            String info[]=data.split(" ");
            if(info[0].equals(name)&&(info[1].equals(pwd))){
                return 1;
            }
        }
        return 0;
    }
    public static void add_user()throws  Exception
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("注册用户名称");
        String name=sc.next();
        System.out.println("注册用户密码");
        String pwd=sc.next();
        FileWriter fw=new FileWriter("src/main/UserInfo.txt",true);
        System.out.println("注册成功");
        fw.write(name+" "+pwd+"\n");
        fw.flush();
        fw.close();
    }
}
