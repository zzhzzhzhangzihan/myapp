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
        System.out.println("��Ŀ���ɳ���");
        System.out.println("-r ��Ŀ����ֵ������Ϊ1����Ȼ����");
        System.out.println("-n ��Ŀ����������Ϊ1����Ȼ����");
        System.out.println("�밴������ĸ�ʽ��������");
        System.out.println("����-n 10 -r 10 �� -r 10 -n 10 (-r��-n������Ҫһ��ʹ��)"); 
        while(scan.hasNextLine()) {
            if (scan.hasNextLine()) {
                command = scan.nextLine();}            
        Pattern pa = Pattern.compile(nr);
        Matcher ma = pa.matcher(command);
        Pattern p = Pattern.compile(ea);
        Matcher m = p.matcher(command);
        if(!(ma.matches()||m.matches())) {
            System.out.println("�����ʽ��������������(-r��-n������Ҫһ��ʹ��Ŷ)");
            continue;
        }
        String[] c=command.split("\\s+");
        if(c[0].equals("-n")&&c[2].equals("-r")) {
            n=Integer.parseInt(c[1]);
            r=Integer.parseInt(c[3]);
            create.cr(n,r);
            System.out.println("��ϰExercises.txt�ʹ�Answers.txt�����ɣ������ڱ�����ĵ�ǰĿ¼��");
        }
        else if(c[0].equals("-r")&&c[2].equals("-n")){
            r=Integer.parseInt(c[1]);
            n=Integer.parseInt(c[3]);
            create.cr(n,r);
            System.out.println("��ĿExercises.txt�ʹ�Answers.txt�����ɣ������ڱ�����ĵ�ǰĿ¼��");
        }
        System.out.println("�����Ҫ�뱣�棬�ٴ�ʹ�ó���ʱ��һ�����ɵ��ļ����ᱻ����");
        n=0;
        r=0;
        }   
        
    }
}