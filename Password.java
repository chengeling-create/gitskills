import javax.swing.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class Password extends JFrame{
    public void launchFrame(){
        this.setTitle("菜单页面");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        exit();

        Password f=new Password();
        f.launchFrame();

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("请选择操作");

        JMenuItem sub1 = new JMenuItem("加密");
        JMenuItem sub2 = new JMenuItem("解密");
        JMenuItem sub3 = new JMenuItem("判断密码强度");
        JMenuItem sub4 = new JMenuItem("密码生成");

        fileMenu.add(sub1);
        fileMenu.add(sub2);
        fileMenu.add(sub3);
        fileMenu.add(sub4);

        menuBar.add(fileMenu);

        f.setJMenuBar(menuBar);
        f.setVisible(true);


        while (isRunning) {
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
                    boolean password=false;
                    for (int i = 0; i < c.length; i++) {
                        if (c[i]>='a'&&c[i]<='z'||c[i]>='A'&&c[i]<='Z'||c[i]>='0'&&c[i]<='9') {
                            password = true;
                        }
			                else{
                                password = false;
                                break;
                            }
                    }
                    if (password=true){
                                //每个字符的ASCII码加上它在字符串中的位置(1开始)和偏移值3
                        for (int i = 0; i < c.length; i++) {
                                    temp = (char) (c[i] + (i + 1) + 3);
                                    m.add(temp);
                                }
                        //将字符串的第一位和最后一位调换顺序
                                Collections.swap(m, 0, m.toArray().length - 1);
                        //将字符串反转
                                Collections.reverse(m);
                                System.out.print("加密后的结果是： ");
                                for (int i = 0; i < m.size(); i++) {
                                    System.out.print(m.get(i));
                                }
                    }
                    if (password=false)
                        System.out.println("密码输入错误");
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
		    //将字符串反转
                    for (int i=0;i<d.length/2;i++){
                        temp1=d[i];
                        d[i]=d[d.length-1-i];
                        d[d.length-1-i]=temp1;
                    }
                    char temp2;
		    //将字符串的第一位和最后一位调换顺序
                    temp2=d[0];
                    d[0]=d[d.length-1];
                    d[d.length-1]=temp2;
                    ArrayList n = new ArrayList();
		    //将每个字符的ASCII码减去它在字符串中的位置(1开始)和偏移值3
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
                    System.out.print("密码生成长度（大于等于8）：");
                    int num = scanner.nextInt();
                    String passwords = PasswordGenerator.generatePassword(num);
                    System.out.println("生成的密码: " + passwords);
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

class PasswordGenerator {
        private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
        private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String DIGITS = "0123456789";

        public  static String generatePassword(int length) {
            StringBuilder password = new StringBuilder();

            // 添加至少一个小写字母、一个大写字母和一个数字
            password.append(getRandomChar(LOWER_CASE));
            password.append(getRandomChar(UPPER_CASE));
            password.append(getRandomChar(DIGITS));

            // 添加随机字符，直到达到所需的长度
            while (password.length() < length) {
                String charSet = getRandomCharSet();
                password.append(getRandomChar(charSet));
            }

            // 打乱密码中的字符顺序
            shuffle(password);

            return password.toString();
        }

        private  static char getRandomChar(String charSet) {
            Random random = new Random();
            int index = random.nextInt(charSet.length());
            return charSet.charAt(index);
        }

        private  static String getRandomCharSet() {
            Random random = new Random();
            int randomIndex = random.nextInt(3);
            switch (randomIndex) {
                case 0:
                    return LOWER_CASE;
                case 1:
                    return UPPER_CASE;
                case 2:
                    return DIGITS;
                default:
                    return "";
            }
        }

        private static void shuffle(StringBuilder password) {
            Random random = new Random();
            for (int i = password.length() - 1; i > 0; i--) {
                int index = random.nextInt(i + 1);
                char temp = password.charAt(index);
                password.setCharAt(index, password.charAt(i));
                password.setCharAt(i, temp);
            }
        }
    }
