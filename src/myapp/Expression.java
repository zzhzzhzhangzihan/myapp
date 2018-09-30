package myapp;
import java.util.Random;
public class Expression {
	Random random=new Random();
    Calc c=new Calc();
    public Fraction fraction_create(int r) {
        int choose=random.nextInt(2)+1;
        int denominator=1;
        int numerator=0;
        if(choose==1) { //ÕûÊý
            numerator=random.nextInt(r);
            denominator=1;      
        }else {
        denominator=random.nextInt(r)+1;
        numerator=random.nextInt(r*r+1);
        while(numerator/denominator>=r) {
            denominator=random.nextInt(r)+1;
            numerator=random.nextInt(r+1);}     
        }
        return new Fraction( numerator , denominator ); 
    }
    public char operator_create() {
        int oper=random.nextInt(4);    
        char sign;
        switch (oper) {
        case 0:
            sign='+';           
            break;
        case 1:
            sign='-';
            break;
        case 2:
            sign='¡Á';
            break;
        case 3:
            sign='¡Â';
            break;
        default:
            sign='+';
        }
        return sign;
    }
    public String getexp(int r) {
        String expression="";
         int ran=random.nextInt(3);
         switch (ran) {
         case 0:
             expression=oneopexp(r);
             break;
         case 1:
             expression=twoopexp(r);
             break;
         case 2:
             expression=threeopexp(r);
             break;
         }
         return expression;
    }
    public String oneopexp(int r) {
        Fraction f1=fraction_create(r);
        Fraction f2=fraction_create(r); 
        char op=operator_create();
        String exp ="";
        switch (op) {
        case '+':
            exp= f1+" + "+f2;
            break;
        case '-':
            if(!f1.isgreaterthan2(f2)) {
            Fraction temp;
            temp=f1;f1=f2;f2=temp;
            }
            exp= f1+" - "+f2;
            break;
        case '¡Á':
            exp= f1+" ¡Á "+f2;
            break;
        case '¡Â':
            while(f2.isZero()) {
                f2=fraction_create(r);
            }
            exp= f1+" ¡Â "+f2;
            break;
        }
        return exp;
    }
    public String twoopexp(int r){
        Fraction f1=fraction_create(r);
        Fraction f2=fraction_create(r);
        Fraction f3=fraction_create(r);
        
        char op1=operator_create();
        char op2=operator_create();
        String exp ="";
        String exp1="";
        switch (op1) {
        case '+':
            
            exp= f1+" + "+f2;
            break;
        case '-':
            if(!f1.isgreaterthan2(f2)) {
            Fraction temp;
            temp=f1;f1=f2;f2=temp;
            }
            
            exp= f1+" - "+f2;
            break;
        case '¡Á':
            
            exp= f1+" ¡Á "+f2;
            break;
        case '¡Â':
            while(f2.isZero()) {
                f2=fraction_create(r);
            }
            
            exp= f1+" ¡Â "+f2;
            break;
        }
        switch (op2) {
        case '+':
            
            exp1=exp+" + "+f3;
            break;
        case '-':
            if(!c.calculate(exp).isgreaterthan2(f3)) {  
                
            exp1= f3+" - "+"("+exp+")";
            }else {
                
            exp1= exp+" - "+f3;}
            break;
        case '¡Á':
            
            exp1= "("+exp+")"+" ¡Á "+f3;
            break;
        case '¡Â':
            while(f3.isZero()) {
                f3=fraction_create(r);
            }
            
            exp1="("+exp+")"+" ¡Â "+f3;
            break;
        }       
        
        return exp1;
    }
        public String threeopexp(int r){
            Fraction f1=fraction_create(r);
            Fraction f2=fraction_create(r);
            Fraction f3=fraction_create(r);
            Fraction f4=fraction_create(r);

            char op1=operator_create();
            char op2=operator_create();
            char op3=operator_create();
            String exp ="";
            String exp1="";
            String exp2="";
            switch (op1) {
            case '+':
                
                exp= f1+" + "+f2;
                break;
            case '-':
                if(!f1.isgreaterthan2(f2)) {
                Fraction temp;
                temp=f1;f1=f2;f2=temp;
                }
                
                exp= f1+" - "+f2;
                break;
            case '¡Á':
                
                exp= f1+" ¡Á "+f2;
                break;
            case '¡Â':
                while(f2.isZero()) {
                    f2=fraction_create(r);
                }
                
                exp= f1+" ¡Â "+f2;
                break;
            }
            switch (op2) {
            case '+':
                
                exp1=exp+" + "+f3;
                break;
            case '-':
                if(!c.calculate(exp).isgreaterthan2(f3)) {
                    
                exp1= f3+" - "+"("+exp+")";
                }else {
                
                exp1= exp+" - "+f3;}
                break;
            case '¡Á':
                
                exp1= "("+exp+")"+" ¡Á "+f3;
                break;
            case '¡Â':
                while(f3.isZero()) {
                    f3=fraction_create(r);
                }
                
                exp1="("+exp+")"+" ¡Â "+f3;
                break;
            }   
            switch (op3) {
            case '+':
                
                exp2=exp1+" + "+f4;
                break;
            case '-':
                if(!c.calculate(exp1).isgreaterthan2(f4)) {
                    
                exp2= f4+" - "+"("+exp1+")";
                }else {
                    
                exp2= exp1+" - "+f4;}
                break;
            case '¡Á':
                
                exp2= "("+exp1+")"+" ¡Á "+f4;
                break;
            case '¡Â':
                while(f4.isZero()) {
                    f4=fraction_create(r);
                }
                
                exp2="("+exp1+")"+" ¡Â "+f4;
                break;
            }
            
            return exp2;
        }
}
