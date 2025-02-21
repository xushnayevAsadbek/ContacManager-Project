import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean b = true;
        Contact [] contactArray = new Contact[1];
        int contactIndex = 0;
        while (b) {
            menu();
            int n = getMenuNumber();
            switch (n) {
                case 1:
                    Contact contact = addContact();
                    if (isValidContact(contact)) {
                        if(contactIndex == contactArray.length){
                            Contact[] newArr = new Contact[contactArray.length * 2];
                            for(int i =0 ; i<contactArray.length ; i++){
                                newArr[i] = contactArray[i];
                            }
                            contactArray = newArr;
                            System.out.println("New Array Created");
                        }
                        

                        contactArray[contactIndex] = contact;
                        contactIndex ++ ;
                    System.out.println("Contact added. ");

                     } 

                    break;
                    case 2:
                    for(Contact c : contactArray){
                        if (c != null) {
                            System.out.println(c.name + " " + c.surname + " " + c.phone);
                        }
                    }
                    break;
                    case 3:
                    
                    break;
                    case 4:
                    
                    break;
                    case 0:
                    b= false;
                    break;
                default:
                    System.out.println("Please choose current number ");
            }
        }
        System.out.println("The end");

    }
    public static Contact addContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.next();

        System.out.print("Enter surname: ");
        String surname = scanner.next();

        System.out.print("Enter phone: ");
        String phone = scanner.next();

        Contact contact = new Contact();
        contact.name = name;
        contact.surname = surname;
        contact.phone = phone;
        return contact;
    }

    public static boolean isValidContact(Contact contact){
        if (contact.name == null || contact.name.trim().length()<3) {
            System.out.println("Contact name is wrong");
            return false;
        }
        if (contact.surname == null || contact.surname.trim().length()<3) {
            System.out.println("Contact surname is wrong");
            return false;
        }
        if (contact.phone == null || contact.phone.trim().length() !=12 || !contact.phone.startsWith("998")) {
            System.out.println("Contact phone is wrong");
            return false;
        }
        char [] phoneArr = contact.phone.toCharArray();
        for(char c: phoneArr){
            if(!Character.isDigit(c)){
                System.out.println("Contact phone is wrong");
            return false;
            }
        }
            return true ;
    }

    public static void menu (){
          System.out.println("** Menu **");  
          System.out.println("1. Add contact");  
          System.out.println("2. Add List ");  
          System.out.println("3. Search ");  
          System.out.println("4. Delete Contact ");  
          System.out.println("0. Exit ");  
    }
    public static int getMenuNumber(){
        System.out.print("Choose menu: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

   
   
}