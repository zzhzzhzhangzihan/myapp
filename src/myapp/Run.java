package myapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run {

    public static void main(String[] args) throws IOException  {
        Scanner scan=new Scanner(System.in);
        String command=null;
        Create create=new Create();
        String nr="^\\-n\\s+\\d+\\s+\\-r\\s+\\d+$||^\\-r\\s+\\d+\\s+\\-n\\s+\\d+$";
        String ea="^\\-e\\s+\\S+\\s+\\-a\\s+\\S+$";
        int n = 0;
        int r = 0;
        String exercisesfile=null;
        String answersfile=null;
        System.out.println("题目生成程序");
        System.out.println("-r 题目中数值（至少为1的自然数）");
        System.out.println("-n 题目数量（至少为1的自然数）");
        System.out.println("请按照下面的格式输入命令");
        System.out.println("例：-n 10 -r 10 或 -r 10 -n 10 (-r和-n命令需要一起使用)"); 
        while(scan.hasNextLine()) {
            if (scan.hasNextLine()) {
                command = scan.nextLine();}            
        Pattern pa = Pattern.compile(nr);
        Matcher ma = pa.matcher(command);
        Pattern p = Pattern.compile(ea);
        Matcher m = p.matcher(command);
        if(!(ma.matches()||m.matches())) {
            System.out.println("命令格式错误，请重新输入(-r和-n命令需要一起使用哦)");
            continue;
        }
        String[] c=command.split("\\s+");
        if(c[0].equals("-n")&&c[2].equals("-r")) {
            n=Integer.parseInt(c[1]);
            r=Integer.parseInt(c[3]);
            create.cr(n,r);
            System.out.println("练习Exercises.txt和答案Answers.txt已生成，放置在本程序的当前目录下");
        }
        else if(c[0].equals("-r")&&c[2].equals("-n")){
            r=Integer.parseInt(c[1]);
            n=Integer.parseInt(c[3]);
            create.cr(n,r);
            System.out.println("题目Exercises.txt和答案Answers.txt已生成，放置在本程序的当前目录下");
        }
        System.out.println("如果需要请保存，再次使用程序时上一次生成的文件将会被覆盖");
        n=0;
        r=0;
        }   
        
    }
}