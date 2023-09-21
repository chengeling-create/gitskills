import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        exit();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1://加密
                    System.out.println("==============================");
                    System.out.println("欢迎使用密码管理系统");
                    System.out.println("==============================");
                    System.out.print("请输入要加密的数字密码：");
                    String input = scanner.nextLine();
                    char[] c = input.toCharArray();
                    char temp;
                    ArrayList m = new ArrayList();
                    for (int i = 0; i < c.length; i++) {
                        temp = (char) (c[i] + (i + 1) + 3);
                        m.add(temp);
                    }
                    Collections.swap(m, 0, m.toArray().length - 1);
                    Collections.reverse(m);
                    System.out.print("加密后的结果是： ");
                    for (int i = 0; i < m.size(); i++) {
                        System.out.print(m.get(i));
                    }
                    System.out.println("");
                    break;


                case 2://解密
                    System.out.println("==============================");
                    System.out.println("欢迎使用密码管理系统");
                    System.out.println("==============================");
                    System.out.print("请输入要解密的密码：");
                    String input1 = scanner.nextLine();
                    char[] d = input1.toCharArray();
                    char temp1;
                    for (int i=0;i<d.length/2;i++){
                        temp1=d[i];
                        d[i]=d[d.length-1-i];
                        d[d.length-1-i]=temp1;
                    }
                    char temp2;
                    temp2=d[0];
                    d[0]=d[d.length-1];
                    d[d.length-1]=temp2;
                    ArrayList n = new ArrayList();
                    for (int i = 0; i < d.length; i++) {
                        temp1 = (char)(d[i] - (i + 1) - 3);
                        n.add(temp1);
                    }
                    for (int i = 0; i <n.size(); i++) {
                        System.out.print(n.get(i));
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("==============================");
                    System.out.println("欢迎使用密码管理系统");
                    System.out.println("==============================");
                    System.out.print("请输入要判断强度的密码：");
                    String pass = scanner.next();
                    String regexA = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{1,7}$";
                    String regexB = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
                    String regexC = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
                    String regexD = "^[0-9]{8,}$";
                    String regexE = "^[a-z]{8,}$";
                    String regexF = "^[A-Z]{8,}$";
                    if (pass.matches(regexA) || pass.matches(regexD)|| pass.matches(regexE)|| pass.matches(regexF)) {
                        System.out.println("密码强度为弱强度");
                    }
                    else if (pass.matches(regexB)) {
                        if (pass.matches(regexC)) {
                            System.out.println("密码强度为强强度");
                        } else
                            System.out.println("密码强度为中强度");
                    }

                    System.out.println("");
                    break;

                case 4:
                    System.out.println("==============================");
                    System.out.println("欢迎使用密码管理系统");
                    System.out.println("==============================");
                    System.out.print("密码生成长度：");
                    int num = scanner.nextInt();
                    Random sc=new Random(num);
                    String UPPER_WORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    String LOWER_WORD_CHARS = "abcdefghijklmnopqrstuvwxyz";
                    String NUMBER_CHARS = "0123456789";

            }

            scanner = new Scanner(System.in);
            System.out.println("按任意键返回");
            String input = scanner.nextLine();
            if (input.length() > 0) {
                System.exit(0);
            }
            exit();
        }
    }
    public static void exit() {
        System.out.println("==============================");
        System.out.println("欢迎使用密码管理系统");
        System.out.println("==============================");
        System.out.println("请选择操作：");
        System.out.println("1. 加密");
        System.out.println("2. 解密");
        System.out.println("3. 判断密码强度");
        System.out.println("4. 密码生成");
        System.out.println("5. 退出");
        System.out.println(" ");
        System.out.print("请输入选项序号：");
    }
}
