import java.io.*;
import java.util.*;

public class StudentInfo {
    List<Student> list;
    public StudentInfo()
    {
        list=new ArrayList<Student>();
    }
    public int student_system()throws Exception
    {
        System.out.println("    学生管理界面\n[option]\n1.增加学生\n2.删除学生\n3.返回\n4.学生管理系统");
        DataInputStream in = new DataInputStream(new FileInputStream("E:\\WorkStation\\Mycodes\\java\\MyProject\\src\\main\\student.txt"));
        BufferedReader d  = new BufferedReader(new InputStreamReader(in));
        String stu;
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        while((stu=d.readLine())!=null){
            String data[]=stu.split("，");
            Student student=new Student(data[0],data[2],data[1],Integer.valueOf(data[5]));
            student.set_stu_cla(data[3]);
            student.set_stu_pro(data[4]);
            list.add(student);
        }
        d.close();
        return a;
    }
    public void add_student()
    {
        System.out.println("[添加学生信息]\n请输入学生信息\n姓名 学号 性别 班级 专业 分数");
        Scanner sc=new Scanner(System.in);
        String stu_name=sc.next();
        String stu_num=sc.next();
        String stu_sex=sc.next();
        String stu_cla=sc.next();
        String stu_pro=sc.next();
        int stu_score=sc.nextInt();
        Student student=new Student(stu_name,stu_sex,stu_num,stu_score);
        student.set_stu_cla(stu_cla);
        student.set_stu_pro(stu_pro);
        list.add(student);
        System.out.println("添加成功");
    }
    public void delete_student()
    {
        System.out.println("请输入删除学生的名字");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        Iterator<Student> ite=list.iterator();
        int e=0;
        while(ite.hasNext())
        {
            String s=ite.next().stu_name;
            if(name.equals(s))
            {
                ite.remove();
                System.out.println("删除成功");
                e=1;
            }
        }
        if(e==0)System.out.println("学生中无此人");
    }
    public void System_down()throws Exception
    {
        FileWriter fw=new FileWriter("src/main/student.txt");
        for(int i=0;i<list.size();i++)
        {
            Student student=list.get(i);
            fw.write(student.stu_name+"，"+student.stu_num+"，"+student.stu_sex+"，"+student.stu_cla+"，"+student.stu_pro+"，"+student.stu_score+"\n");
        }
        fw.flush();
        fw.close();
        System.out.println("更新成功");
    }
    public void manage_stu_info()
    {
        while (true)
        {
            try {
                System.out.println("    学生信息管理界面\n1.修改学生信息\n2.查询学生信息\n3.学生排名\n4.退出");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                if (choice == 1) {
                    alter_stu_info();
                    System_down();
                } else if (choice == 2) {
                    find_stu_info();
                } else if (choice == 3) {
                    find_score();
                }
                else break;
            }
            catch (Exception e){e.printStackTrace();}
        }
    }
    public void find_score()//成绩菜单
    {
        System.out.println("    成绩查询菜单\n1.成绩排名\n2.成绩分布\n3.返回");
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            int choice=sc.nextInt();
            if(choice==1){stu_rank();}
            else if(choice==2){stu_score_distribute();}
            else {break;}
        }
    }
    public void stu_rank()
    {
        Student[] students=new Student[list.size()];
        for(int i=0;i<list.size();i++)
        {
            students[i]=list.get(i);
        }
        for(int i=0;i<students.length;i++)
        {
            for(int j=i+1;j<students.length;j++)
            {
                if(students[i].stu_score<students[j].stu_score)
                {
                    Student e=students[i];
                    students[i]=students[j];
                    students[j]=e;
                }
            }
        }
        for(int i=0;i<students.length;i++)
        {
            System.out.println((i+1)+".:"+students[i].stu_name+" "+students[i].stu_score);

        }
    }
    public void stu_score_distribute()
    {
        int[] score=new int[5];
        for(int i=0;i<list.size();i++)
        {
            int sco=list.get(i).stu_score;
            switch (sco/10)
            {
                case 6:{score[1]++;break;}
                case 7:{score[2]++;break;}
                case 8:{score[3]++;break;}
                case 9:{score[4]++;break;}
                default:{score[0]++;break;}
            }
        }
        for(int i=0;i<5;i++)
            System.out.println(score[i]);
    }
    public void alter_stu_info()
    {
        System.out.println("输入修改学生的姓名");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        int e=0;
        for(int i=0;i<list.size();i++)
        {
            if(name.equals(list.get(i).stu_name)){
                System.out.println("修改学生班级+专业");
                String cla=sc.next();
                String pro=sc.next();
                list.get(i).set_stu_cla(cla);
                list.get(i).set_stu_pro(pro);
                e=1;
                break;
            }
        }
        if(e==0)System.out.println("无此人");
    }
    public void find_stu_info()
    {
        System.out.println("输入学号");
        Scanner sc=new Scanner(System.in);
        String num=sc.next();
        int e=0;
        for(int i=0;i<list.size();i++)
        {
            if(num.equals(list.get(i).stu_num)){
                System.out.println(list.get(i).stu_name+"\n"+list.get(i).stu_num);
                e=1;
                break;
            }
        }
        if(e==0)System.out.println("无此人");
    }
}
