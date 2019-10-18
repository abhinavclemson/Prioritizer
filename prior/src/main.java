import java.util.Scanner;

public class main{
    public static void main(String args[])  {
        int option, priority, flag = 1;
        //Integer[] listItem = new Integer[10] ;
        Integer item = null;
        Integer inp= null ;
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        Prioritizer<Integer> p1 = new prior<Integer>(Integer::compareTo);
        Prioritizer<Integer> p3= new prior3<Integer>(Integer::compareTo);

        System.out.println("Select one of the prioritizer");
        System.out.println("1) Prioritizer1");
        System.out.println("3) Prioritizer3");
        while (!sc.hasNextInt()) {
            sc.next();
        }
        priority = sc.nextInt();


        while (flag == 1) {

            System.out.println("Select one of the options");
            System.out.println("1) Insert");
            System.out.println("2) Remove Any");
            System.out.println("3) Remove Next In Index");
            System.out.println("4) Get Size");
            System.out.println("5) Exit");

            while (!sc.hasNextInt()) {
                sc.next();
            }
            option = sc.nextInt();

            if (priority == 1) {
                if (option == 1) {
                    if (p1.isInsertionPhase()) {
                        System.out.println("Enter the number you want to insert");
                        item = (Integer) input.nextInt();
                        p1.insert(item);
                    } else {
                        p1.changePhase();
                        System.out.println("Enter the number you want to insert");
                        item = (Integer) input.nextInt();
                        p1.insert(item);
                    }
                }
                else if (option == 2) {
                    if (p1.isInsertionPhase()) {
                        p1.changePhase();
                        System.out.println("Enter the 1 to remove first in order ,2 to remove any and 3 to move on:");
                        inp= (Integer) input.nextInt();
                        while (inp!=1 || inp!=0){
                            if(inp==1){
                                p1.removeNextInOrder();
                                break;
                        }
                        else if(inp==2){
                            p1.removeAny();
                            break;

                        }
                        else{break;}
                        }
                    }
                }
                else if (option == 3) {
                    if (p1.isInsertionPhase()) {
                        p1.changePhase();
                        p1.removeNextInOrder();
                    } else {
                        p1.removeNextInOrder();
                    }
                } else if (option == 4) {
                    System.out.println("Size of the array is " + p1.size());
                } else {
                    flag = 0;
                    break;
                }
            }
            else if (priority == 3) {
                if (option == 1) {
                    if (p3.isInsertionPhase()) {
                        System.out.println("Enter the number you want to insert");
                        item = (Integer) input.nextInt();
                        p3.insert(item);
                    } else if (option==2){
                        p3.changePhase();
                        System.out.println("Enter the number you want to insert");
                        item = (Integer) input.nextInt();
                        p3.insert(item);

                    }
                    else if (option==3){
                        p3.removeNextInOrder();
                        System.out.println("Operation Successful");

                    }
                    else if (option==4){
                        System.out.println("The size of the array "+p3.size());
                    }
                    else{
                        System.out.println("Exit Successful!");
                        flag=0;
                        break;
                    }
                }
            }else{
                flag=0;
                break;
            }
        }
    }
}