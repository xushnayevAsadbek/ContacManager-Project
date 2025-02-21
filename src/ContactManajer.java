import java.util.Scanner;

public class ContactManajer {
     Contact [] contactArray = new Contact[10];
     int contactIndex = 0;
    public void start(){
        boolean b = true;
       
        while (b) {
            menu();
            int n = getMenuNumber();
            switch (n) {
                case 1:
                    Contact contact = addContact();
                    addToArray(contact);

                    break;
                    case 2:
                    printContactList();
                    break;
                    case 3:
                    String query = getQuery();
                    search(query);
                    break;
                    case 4:
                    String phone = deleteContact();   
                    deleteContactFromArray(phone);
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

      public  Contact addContact(){
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

    public  boolean isValidContact(Contact contact){
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

    public  void addToArray(Contact contact){
        if (!isValidContact(contact)) {
            return;
        }
        if (isPhoneExist(contact.phone)) {
            System.out.println("Phone number exists");
            return;
        }
        
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

    public  void printContactList(){
        for(Contact c : contactArray){
            if (c != null) {
                System.out.println(c.name + " " + c.surname + " " + c.phone);
            }
        }
    }

    public  String getQuery(){
        System.out.print("Enter query: ");
        Scanner scanner =new Scanner(System.in);
        return scanner.next();
    }
    public  void search(String query){
        query = query.toLowerCase();
        for(Contact contact : contactArray){
            if (contact == null) {
                continue;
            }            
                if(contact.name.toLowerCase().contains(query) 
                || contact.surname.toLowerCase().contains(query) 
                || contact.phone.contains(query)){
                 System.out.println(contact.name + " " + contact.surname + " " + contact.phone);
                }
            
        } 
    }
    public  boolean isPhoneExist(String phone){
        for(Contact contact : contactArray){
            if (contact != null && contact.phone.equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public  String  deleteContact(){
        System.out.print("Enter phone ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();

    }

    public  void deleteContactFromArray(String phone){
        for(int i=0; i< contactArray.length; i++){
            Contact contact = contactArray[i] ;
            if (contact != null && contact.phone.equals(phone)) {
                contactArray[i] = null;
                System.out.println("Contact deleted ");
                break;                
            }
        }
    }

    public  void menu (){
          System.out.println("** Menu **");  
          System.out.println("1. Add contact");  
          System.out.println("2. Add List ");  
          System.out.println("3. Search ");  
          System.out.println("4. Delete Contact ");  
          System.out.println("0. Exit ");  
    }
    public  int getMenuNumber(){
        System.out.print("Choose menu: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

   
}

