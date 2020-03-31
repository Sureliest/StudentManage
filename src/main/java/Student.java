public class Student {
    public String stu_name;//学生姓名
    public String stu_num;//学生学号
    public String stu_sex;//学生性别
    public String stu_ide;//学生身份证号
    public String stu_cla;//学生班级
    public String stu_pro;//学生专业
    public int stu_score;//学会成绩

    public Student(String name, String sex, String num, int score) {
        stu_name = name;
        stu_sex = sex;
        stu_num = num;
        stu_score = score;
    }
    //获取信息
    public void get_stu_info(){
        System.out.println("姓名："+stu_name);
        System.out.println("学号："+stu_num);
        System.out.println("专业："+stu_pro);
        System.out.println("班级："+stu_cla);
    }
    //设置信息
    public void set_stu_cla(String cla) {
        stu_cla=cla;
    }
    public void set_stu_pro(String pro) { stu_pro=pro;}
}
