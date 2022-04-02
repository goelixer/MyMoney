 /**
 * This is the fastest money transaction app.Also available for Android and MacOS.
 * DEVELOPER:- AAYUSH KUMAR,SANYAM GOEL & PRABHAT TOMAR
 * VERSION:- 1.332v89
 * Note:- Program will not work if "..../data/tid" directory doesn't exist.
 */

import java.util.Scanner;
import java.io.*; 
public class MyMoney_App
{
    String pno;
    String name;
    double bal;
    MyMoney_App()
    {
        pno="";
        name="";
        bal=0.0;
    }

    MyMoney_App(String no)
    {
        pno=d_Ret(1,no);
        name=d_Ret(5,no);
        bal=Double.parseDouble(d_Ret(4,no));
    }
    
    public static void main(String args[])
    {
        MyMoney_App obj=new MyMoney_App();
        Scanner sc=new Scanner(System.in);
        obj.security();
        System.out.println("\f********************************************************************************");
        System.out.println("                                |************|");
        System.out.println("                                |MY MONEY APP|");
        System.out.println("                                |************|");
        System.out.println("\n              <<<<<<<<<We support cashless economy>>>>>>>>>>\n");
        obj.typeWrite("  This is the fastest money transaction app. We thank you for using this.");
        System.out.println("**********************************************************************************");
        MyMoney_App ob=new MyMoney_App(obj.pno);
        obj=null;
        ob.display_menu();
        sc.close();
    }
    
    public void security()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\f%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Welcome To MyMoney Security System. Choose Your Option To Continue.");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("1.LogIn(\"For Old Users.\")");
        System.out.println("2.SignUp(\"For New Users.\")");
        try{
            for(int i=0;i>=-1;i++)
            {
                System.out.print("");
                byte choise=sc.nextByte();
                switch(choise)
                {
                    case 1:
                    {
                        Login();
                        break;
                    }
                    case 2:
                    {
                        Signup();
                        break;
                    }
                    default:
                    {
                        System.out.println("Wrong Choise Enter Again.");
                        continue;
                    }
                }
                break;
            }
        }
        catch(java.util.InputMismatchException ex)
        {   
            System.out.println("Don't try to play with me.");
            System.exit(0);
        }
    }

    public void Login()
    {
        System.out.print('\f');
        Scanner sc=new Scanner(System.in);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<WELCOME>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Please enter your Phone no.");
        pno=sc.nextLine();
        System.out.println("**********************************************");
        try{
            FileInputStream fin=new FileInputStream("data/pnos.bin");
            DataInputStream din=new DataInputStream(fin);
            boolean EOF=false;
            byte stop=0;
            while(!EOF)
            {
                if(stop>4)
                {
                    System.out.println("Attempts exceeded the limit.");
                    System.exit(0);
                }
                else if(wrong_Format(pno))
                {
                    System.out.println("Not a valid format.Enter your no. again.");
                    pno=sc.nextLine();
                    System.out.println("**********************************************");
                    stop++;
                    continue;
                }
                try{
                    if(pno.equals(din.readUTF()))
                    {
                        break;
                    }
                }
                catch(EOFException ee)
                {
                    System.out.println("Your no.is not registered please try again.");
                    pno=sc.nextLine();
                    System.out.println("**********************************************");
                    stop++;
                    fin=new FileInputStream("data/pnos.bin");
                    din=new DataInputStream(fin);
                    continue;
                }
                catch(IOException e)
                {
                    System.out.println("Something went wrong or server failed.\nPlease try Again Later.");
                }
            }
            System.out.println("Please enter your password.");
            for(int i=0;i>-1;i++)
            {
                String pass=sc.nextLine();
                System.out.println("**********************************************");
                if(pass.equals(d_Ret(2,pno)))
                {
                    System.out.println("You are logged in now you can proceed.");
                    break;
                }
                else if(i>4)
                {
                    System.out.println("Attempts exceeded the limit.");
                    System.exit(0);
                }
                else
                {
                    System.out.println("Please try again.");
                    continue;
                }
                din.close();
                fin.close();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Their is an error in server.Please try later.");
            System.exit(0);
        }
        catch(IOException e)
        {
            System.out.println("Their is an error in server.");
        }
    }

    public void Signup()
    {
        System.out.print('\f');
        Scanner sc=new Scanner(System.in);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<WELCOME>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Please enter your Phone no.");
        pno=sc.nextLine();
        System.out.println("**********************************************");
        for(int j=0;j>-1;j++)
        {
            if(wrong_Format(pno))
            {
                System.out.println("Not a valid format.Please enter again.");
                pno=sc.nextLine();
                System.out.println("**********************************************");
            }
            else{break;}
        }
        try
        {
            FileOutputStream fout1=new FileOutputStream("data/pnos.bin",true);
            DataOutputStream dout1=new DataOutputStream(fout1);
            FileInputStream fin=new FileInputStream("data/pnos.bin");
            DataInputStream din=new DataInputStream(fin);
            boolean EOF=false;
            Test:while(!EOF)
            {
                try{
                    if(pno.equals(din.readUTF()))
                    {
                        fin=new FileInputStream("data/pnos.bin");
                        din=new DataInputStream(fin);
                        System.out.println("Your account already exist.");
                        System.out.println("Please use a different no.");
                        pno=sc.nextLine();
                        System.out.println("**********************************************");
                        continue Test;
                    }
                }
                catch(EOFException e)
                {
                    EOF=true;
                }
                catch(IOException e)
                {
                    System.out.println("Something went wrong.");
                }
            }
            System.out.println("Please enter your Email");
            String em=sc.nextLine();
            System.out.println("**********************************************");
            FileOutputStream fout=new FileOutputStream("data/"+pno+".mma",true);
            DataOutputStream dout=new DataOutputStream(fout);
            System.out.println("Please enter your Name.");
            name=sc.nextLine();
            System.out.println("**********************************************");
            System.out.println("Please enter your password.");
            String pass=sc.nextLine();
            System.out.println("**********************************************");
            while(pass.equals(""))
            {
                System.out.println("Blank Passwords Are Not Allowed.\nPlease Try Again.");
                pass=sc.nextLine();
                System.out.println("**********************************************");
                continue;
            }
            System.out.println("Please confirm your password.");
            confirm:for(int i=0;i>-1;i++)
            {
                System.out.print("");
                String temp=sc.nextLine();
                System.out.println("**********************************************");
                if(pass.equals(temp))
                {
                    byte loop=0;
                    while(loop!=1)
                    {
                        String code=code_Gen();
                        System.out.println("Please re-enter the captcha below: ("+code+")");
                        String c2=sc.nextLine();
                        System.out.println("**********************************************");
                        if(c2.equals(code))
                        {
                            dout1.writeUTF(pno);
                            dout.writeUTF(pno);
                            dout.writeUTF(pass);
                            dout.writeUTF(em);
                            dout.writeUTF(Double.toString(bal));
                            dout.writeUTF(name);
                            System.out.println("Your Account is succesfully created.Thanks for visiting.");
                            loop=1;
                        }
                    }
                    break;
                }
                else if(i>3)
                {
                    System.out.println("Attempts Exceeded The Limit.\nTry Again Later.");
                    break;
                }
                else
                {
                    System.out.println("Please try again.");
                    continue confirm;
                }
            }
            dout1.close();
            fout1.close();
            dout.close();
            fout.close();
            fin.close();
            din.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Something went Wrong Please try again later."); 
            System.exit(0);
        }
        catch(IOException ee)
        {
            System.out.println("Something went Wrong Please try again later.");
            System.exit(0);
        }
        System.out.println("Redirecting to Main Screen.");
        typeWrite("**********************************************************************");
    }
    
    public void display_menu()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("                               WELCOME Mr."+name);
            System.out.println("Wallet Balance:- "+bal+"Rs.");
            System.out.println("***************************************************");
            String arr[]={"You can change your password is settings.","EveryTime recheck the amount before paying.","Get 10% cashback on every mobile recharge.","You can checkyour last three transactions.","Being cashless asure that your money is secure."};
            int a=(int)(Math.random()*5);
            System.out.println("Suggestion:- "+arr[a]);
            System.out.println("***************************************************");
            System.out.println("\t\t\t  Please choose any option.");
            System.out.println("\n\t\t\t\t1.Pay bills\n\n\t\t\t\t2.Load money\n\n\t\t\t\t3.Check transactions\n\n\t\t\t\t4.Profile Settings\n\n\t\t\t\t5.Exit");
            byte choise=sc.nextByte();
            switch(choise)
            {
                case 1:
                {pay_Bill();
                    break;}
                case 2:
                {load_Money();
                    break;}
                case 3:
                {check_Trans();
                    break;}
                case 4:
                {setting();
                    break;}
                case 5:
                {exit();
                    break;}
                default:
                {
                    System.out.println("Wrong Choise.");
                    back_Main();
                }
            }
        }
        catch(java.util.InputMismatchException e)
        {
            System.out.println("Don't try to play with me.");
            return;
        }
    }
    
    public void pay_Bill()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\fPlease select the option from below.");
        System.out.println("\t\t1.Mobile Recharge\n\n\t\t2.MyMoney to MyMoney\n\n\t\t3.Back");
        try{
            byte choise=sc.nextByte();
            switch(choise)
            {
                case 1:
                {
                    mobile_Rec();
                    break;
                }
                case 2:
                {
                    trans();
                    break;
                }
                case 3:
                {
                    System.out.println("\f");
                    display_menu();
                    break;
                }
                default:
                {
                    System.out.println("Wrong choise.");
                    back_Main();
                }
            }
        }
        catch(java.util.InputMismatchException e)
        {
            System.out.println("Don't try to play with me.");
            return;
        }
    }
    
    public void mobile_Rec()
    {
        try{
            String tid="MR@";
            Scanner sc=new Scanner(System.in);
            System.out.println("\f!!!!!!!!!!!!!Get 10% cashback on every mobile recharge.!!!!!!!!!!!!!!");
            System.out.println("Please enter the mobile no.");
            String no=sc.nextLine();
            for(int j=0;j>-1;j++)
            {
                if(wrong_Format(no))
                {
                    System.out.println("Not a valid format.Please enter again.");
                    no=sc.nextLine();
                    System.out.println("**********************************************");
                }
                else{break;}
            }
            tid=tid+no+"@";
            System.out.println("**********************************************");
            System.out.println("Please select the operator.");
            String arr1[]={"Aircel","Airtel","BSNL","!dea","JIO","MTNL","Reliance","TATA Docomo","Telenor","Vodafone"};
            for(int i=0;i<arr1.length;i++)
            {
                System.out.println("\t\t"+(i+1)+"."+arr1[i]+"\n");
            }
            byte c1=sc.nextByte();
            tid=tid+arr1[c1-1]+"@";
            System.out.println("**********************************************");
            System.out.println("Please select the circle.");
            String arr2[]={"Andhra Pradesh","Bihar","Chattisgarh","Delhi","Gujarat","Maharashtra","UP West","UP East","Uttarakhand","Other"};
            for(int i=0;i<arr2.length;i++)
            {
                System.out.println("\t\t"+(i+1)+"."+arr2[i]+"\n");
            }
            byte c2=sc.nextByte();
            tid=tid+arr2[c2-1]+"@";
            System.out.println("**********************************************");
            double amt=accept_Amt("You don't have enough money.Don't try to fool a machine.",bal);
            tid=tid+amt+"@";
            System.out.println("**********************************************");
            String tm=sc.nextLine();
            byte loop=0;
            while(loop!=1)
            {
                String code=code_Gen();
                System.out.println("Please re-enter the captcha below: ("+code+")");
                tm=sc.nextLine();
                if(tm.equals(code))
                {
                    System.out.println("**********************************************");
                    System.out.println("Payment Succesfull.");
                    bal=bal-amt+(amt/10);
                    tm=Double.toString(bal);
                    d_Write(4,tm,pno);
                    System.out.print("GENERATING RECEIPT  ");
                    typeWrite("*********************************************************");
                    write_Tid(tid);
                    System.out.println("\f");
                    receipt(tid);
                    back_Main();
                    loop=1;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Don't try to play with me.");
            return;
        }
    }
    
    public void trans()
    {
        String tid="MM@";
        Scanner sc=new Scanner(System.in);
        System.out.println("\fPlease enter the user Phone no.");
        String no=sc.nextLine();
        for(int j=0;j>-1;j++)
        {
            if(wrong_Format(no))
            {
                System.out.println("Not a valid format.Please enter again.");
                no=sc.nextLine();
                System.out.println("**********************************************");
            }
            else{break;}
        }
        try{
            FileInputStream fin=new FileInputStream("data/pnos.bin");
            DataInputStream din=new DataInputStream(fin);
            boolean EOF=false;
            byte stop=0;
            while(!EOF)
            {
                if(stop>4)
                {
                    System.out.println("Attempts exceeded the limit.");
                    System.exit(0);
                }
                try{
                    if(no.equals(din.readUTF()))
                    {
                        tid=tid+no+"@";
                        break;
                    }
                }
                catch(EOFException ee)
                {
                    System.out.println("**********************************************");
                    System.out.println("This no.is not registered please try again.");
                    no=sc.nextLine();
                    stop++;
                    fin=new FileInputStream("data/pnos.bin");
                    din=new DataInputStream(fin);
                    continue;
                }
                catch(IOException e)
                {;}
            }
        }
        catch(FileNotFoundException e)
        {;}
        System.out.println("**********************************************");
        double amt=accept_Amt("You don't have enough money.Don't try to fool a machine.",bal);
        tid=tid+amt+"@";
        byte loop=0;
        while(loop!=1)
        {
            System.out.println("**********************************************");
            String code=code_Gen();
            System.out.println("Please re-enter the captcha below: ("+code+")");
            String tm=sc.nextLine();
            if(tm.equals(code))
            {
                System.out.println("**********************************************");
                System.out.println("Payment Succesfull.");
                bal=bal-amt;
                tm=Double.toString(bal);
                d_Write(4,tm,pno);
                double tbal=Double.parseDouble(d_Ret(4,no));
                tm=Double.toString(tbal+amt);
                d_Write(4,tm,no);
                System.out.print("GENERATING RECEIPT  ");
                typeWrite("************************************************************");
                write_Tid(tid);
                System.out.println("\f");
                receipt(tid);
                back_Main();
                loop=1;
            }
        }
    }
    
    void load_Money()
    {
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("\fPlease select the medium to load money.\n\t\t1.NET Banking\n\n\t\t2.Debit Card\n\n\t\t3.Credit Card\n\n\t\t4.Back");
            byte choise=sc.nextByte();
            switch(choise)
            {
                case 1:
                {   
                    System.out.println("\fPlease select the bank.\n");
                    String arr[]={"Axis Bank","HDFC Bank","ICICI Bank","State Bank Of India","Allahbad Bank","Bandhan Bank","Bank Of Baroda","Canara Bank","Corporation Bank","IDBI Bank","Kottak Bank","Union Bank Of India","Syndicate Bank","Yes Bank"};
                    for(int i=0;i<arr.length;i++)
                    {
                        System.out.println("\t\t"+(i+1)+"."+arr[i]+"\n");
                    }
                    choise=sc.nextByte();
                    if(choise>14||choise<1)
                    {String a=arr[15];}
                    System.out.println("**********************************************");
                    System.out.println("Please enter the account no.");
                    String s=sc.nextLine();
                    s=sc.nextLine();
                    System.out.println("**********************************************");
                    double amt=accept_Amt("Amount is more than the limit.Please try again.",10000.0);
                    byte loop=0;
                    while(loop!=1)
                    {
                        System.out.println("**********************************************");
                        String code=code_Gen();
                        System.out.println("Please re-enter the captcha below: ("+code+")");
                        s=sc.nextLine();
                        if(s.equals(code))
                        {
                            System.out.println("**********************************************");
                            System.out.println("Fully Loaded.");
                            bal=bal+amt;
                            String tm=Double.toString(bal);
                            d_Write(4,tm,pno);
                            back_Main();
                            loop=1;
                        }
                    }
                    break;
                }
                case 2:
                {   
                    System.out.println("Please select card type.\n\t\t1.Visa/Master Card\n\n\t\t2.Rupay Debit Card\n\n\t\t3.SBI Mastero Card\n\n\t\t4.CitiBank Mastero Card");
                    choise=sc.nextByte();
                    System.out.println("**********************************************");
                    System.out.println("Please enter the owner name.");
                    String n=sc.nextLine();
                    n=sc.nextLine();
                    System.out.println("**********************************************");
                    System.out.println("Please enter the card no.");
                    n=sc.nextLine();
                    System.out.println("**********************************************");
                    System.out.println("Please enter the Expiry date.");
                    n=sc.nextLine();
                    System.out.println("**********************************************");
                    System.out.println("Please enter the CVV.");
                    n=sc.nextLine();
                    System.out.println("**********************************************");
                    double amt=accept_Amt("Amount is more than the limit.Please try again.",10000.0);
                    System.out.println("**********************************************");
                    System.out.println("Fully Loaded.");
                    bal=bal+amt;
                    String tm=Double.toString(bal);
                    d_Write(4,tm,pno);
                    back_Main();
                    break;
                }
                case 3:
                {   
                    System.out.println("Please enter the owner name.");
                    String n=sc.nextLine();
                    n=sc.nextLine();
                    System.out.println("**********************************************");
                    System.out.println("Please enter the card no.");
                    n=sc.nextLine();
                    System.out.println("**********************************************");
                    System.out.println("Please enter the Expiry date.");
                    n=sc.nextLine();
                    System.out.println("**********************************************");
                    System.out.println("Please enter the CVV.");
                    n=sc.nextLine();
                    System.out.println("**********************************************");
                    double amt=accept_Amt("Amount is more than the limit.Please try again.",10000.0);
                    System.out.println("**********************************************");
                    System.out.println("Fully Loaded.");
                    bal=bal+amt;
                    String tm=Double.toString(bal);
                    d_Write(4,tm,pno);
                    back_Main();
                    break;
                }
                case 4:
                {
                    back_Main();
                    break;
                }
                default:
                {
                    System.out.println("Wrong choise.");
                    back_Main();
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Don't try to play with me.");
            return;
        }
        catch(java.util.InputMismatchException e)
        {
            System.out.println("Don't try to play with me.");
            return;
        }
    }
    
    void setting()
    {
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("\fPlease enter you choise.\n\n\t\t1.Change name\n\n\t\t2.Change password\n\n\t\t3.LOG OUT\n\n\t\t4.About\n\n\t\t5.Clear Transactions\n\n\t\t6.Back");
            byte choise=sc.nextByte();
            String s=sc.nextLine();
            System.out.println("***************************************************");
            switch(choise)
            {
                case 1:
                {
                    System.out.println("Please enter your name.");
                    s=sc.nextLine();
                    System.out.println("***************************************************");
                    d_Write(5,s,pno);
                    MyMoney_App ob=new MyMoney_App(pno);
                    ob.back_Main();
                    break;
                }
                case 2:
                {
                    System.out.println("Please enter your previous password.");
                    s=sc.nextLine();
                    System.out.println("***************************************************");
                    if(s.equals(d_Ret(2,pno)))
                    {
                        System.out.println("Please enter your new password.");
                        s=sc.nextLine();
                        System.out.println("***************************************************");
                        System.out.println("Please confirm your password.");
                        int i=1;
                        while(i>0)
                        {
                            if(s.equals(sc.nextLine()))
                            {
                                d_Write(2,s,pno);
                                System.out.println("***************************************************");
                                System.out.println("Your password has been changed.");
                                break;
                            }
                            else if(i>4)
                            {
                                System.out.println("Attempts Exceeded The Limit.");
                                break;
                            }
                            else
                            {
                                System.out.println("***************************************************");
                                System.out.println("Please try again.");
                                i++;
                            }
                        }
                    }
                    else{System.out.println("Wrong Password.");}
                    back_Main();
                    break;
                }
                case 3:
                {
                    MyMoney_App ob=new MyMoney_App();
                    String arr[]={};
                    main(arr);
                    break;
                }
                case 4:
                {
                    System.out.println("\f****************************************************************************");
                    System.out.println("                                    $----$");
                    System.out.println("                                    ||\\/||");
                    System.out.println("                                    ||  ||");
                    System.out.println("                                    $----$");
                    System.out.println();
                    System.out.println("                                MY MONEY APP");
                    System.out.println("                                Ver 1.332v89");
                    System.out.println("                  \u00A9SANYAM GOEL,AYUSH KUMAR & PRABHAT TOMAR");
                    System.out.println("******************************************************************************");
                    System.out.println("                Helpline:- 1234567890   PRESS ENTER TO GET BACK");
                    System.out.println("******************************************************************************");
                    s=sc.nextLine();
                    System.out.println("\f");
                    display_menu();
                    break;
                }
                case 5:
                {
                    try
                    {
                        FileOutputStream fout=new FileOutputStream("data/tid/"+pno+".tid");
                        DataOutputStream dout=new DataOutputStream(fout);
                    }
                    catch(FileNotFoundException e)
                    {;}
                    back_Main();
                    break;
                }
                case 6:
                {
                    back_Main();
                    break;
                }
                default:
                {
                    System.out.println("Wrong Choise.");
                    back_Main();
                }
            }
        }
        catch(java.util.InputMismatchException e)
        {
            System.out.println("Don't try to play with me.");
            return;
        }
    }
    
    public void exit()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("\f.....                          ");
        System.out.println(".....");
        System.out.print("|0 0|");
        System.out.print("  Do You Want To Exit???  ");
        System.out.println("|0 0|");
        System.out.print("| ^ |          1.YES           ");
        System.out.println("| ^ |");
        System.out.print("'''''          2.NO            ");
        System.out.println("'''''");
        try
        {   byte choise=sc.nextByte();
            switch(choise)
            {
                case 1:System.exit(0);
                break;
                case 2:System.out.println("\f");
                display_menu();
                break;
                default:
                {
                    System.out.println("Wrong choise");
                    back_Main();
                }
            }
        }
        catch(java.util.InputMismatchException e)
        {
            System.out.println("Don't try to play with me.");
            return;
        }
    }
    
    String d_Ret(int num,String no)
    {
        String dat="";
        try{
            FileInputStream fin=new FileInputStream("data/"+no+".mma");
            DataInputStream din=new DataInputStream(fin);
            for(int i=0;i<num;i++)
            {
                dat=din.readUTF();
            }
            din.close();
            fin.close();
        }
        catch(FileNotFoundException e)
        {;}
        catch(IOException e)
        {;}
        return dat;
    }

    public void typeWrite(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            System.out.print(s.charAt(i));
            for(int j=0;j<8E6;j++)
            {
                ;
            }
        }
        System.out.println();
    }

    public String code_Gen()
    {
        int st=(int)(Math.random()*5000);
        String st1="";
        for(int i=0;i<3;i++)
        {
            int s=122-((int)(Math.random()*26));
            char ch=(char)s;
            st1=st1+ch;
        }
        st1=st+st1;
        return st1;
    }

    public void d_Write(int n,String st,String no)
    {
        try{
            FileInputStream fin=new FileInputStream("data/"+no+".mma");
            DataInputStream din=new DataInputStream(fin);
            String arr[]=new String[5];
            for(int i=0;i<5;i++)
            {
                arr[i]=din.readUTF();
            }
            FileOutputStream fout=new FileOutputStream("data/"+no+".mma");
            fout=new FileOutputStream("data/"+no+".mma",true);
            DataOutputStream dout=new DataOutputStream(fout);
            for(int j=1;j<=5;j++)
            {
                if(j==n)
                {
                    dout.writeUTF(st);
                }
                else
                {
                    dout.writeUTF(arr[j-1]);
                }
            }
            dout.close();
            fout.close();
            din.close();
            fin.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Their is some error in server.");
            System.exit(0);
        }
        catch(IOException e)
        {;}
    }

    void receipt(String s)
    {
        System.out.println("                  Receipt\n");
        System.out.println("Sender detail:- "+pno+"("+name+")");
        String arr[]=new String[5];
        System.out.print("Task detail:- ");
        for(int i=0,j=0,a=0;j<s.length();j++)
        {
            if(s.charAt(j)=='@')
            {
                arr[i]=s.substring(a,j);
                i++;
                a=j+1;
            }
        }
        if(arr[0].equals("MR"))
        {
            System.out.println("Mobile Recharge");
            System.out.println("Receiver Details:- "+arr[1]);
            System.out.println("More info:- "+arr[2]+" "+arr[3]);
            System.out.println("Amount:- "+arr[4]+"Rs.");
        }
        else
        {
            System.out.println("MyMoney to MyMoney");
            System.out.println("Receiver Details:- "+arr[1]+"("+d_Ret(6,arr[1])+")");
            System.out.println("Amount:- "+arr[2]+"Rs.");
        }
    }

    double accept_Amt(String sen,double a)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the amount.");
        double amt=sc.nextDouble();
        String s=sc.nextLine();
        int i=0;
        while(i!=1)
        {   
            if(amt>a||amt<0)
            {
                System.out.println("**********************************************");
                System.out.println(sen);
                amt=sc.nextDouble();
                s=sc.nextLine();
            }
            else{i=1;}
        }
        return amt;
    }

    void write_Tid(String t)
    {
        try
        {
            FileOutputStream fout=new FileOutputStream("data/tid/"+pno+".tid",true);
            DataOutputStream dout=new DataOutputStream(fout);
            dout.writeUTF(t);
            dout.close();
        }
        catch(FileNotFoundException e)
        {System.exit(0);}
        catch(IOException e)
        {System.exit(0);}
    }

    void check_Trans()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\f");
        try{
            FileInputStream fin=new FileInputStream("data/tid/"+pno+".tid");
            DataInputStream din=new DataInputStream(fin);
            boolean EOF=false;
            int i=0;
            while(!EOF)
            {
                try{
                    System.out.println();
                    String tmp=din.readUTF();
                    System.out.print((i+1)+".");
                    receipt(tmp);
                    i+=1;
                }
                catch(EOFException e)
                {
                    if(i<=0)
                    {
                        System.out.println("\fNO TRANSACTIONS YET...........");
                    }
                    EOF=true;
                }
                catch(IOException e)
                {
                    System.out.println("Their is some error in server.");
                    System.exit(0);
                }
            }
            back_Main();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("\fNO TRANSACTIONS YET...........");
            back_Main();
        }
    }

    boolean wrong_Format(String no)
    {
        boolean ret=false;
        try
        {
            long tmp=Long.parseLong(no);
            if(tmp<1000000000l||tmp>9999999999l)
            {
                ret=true;
            }
            else{ret=false;}
        }
        catch(NumberFormatException e)
        {ret=true;}
        return ret;
    }

    void back_Main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Press ENTER to get back.");
        String s=sc.nextLine();
        System.out.println("\f");
        display_menu();
    }
}
