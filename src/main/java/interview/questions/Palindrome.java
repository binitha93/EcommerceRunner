package interview.questions;

class Palindrome {
    public static void main(String[] args) {
       String str = "Madam";
       String revstr = "";
       int size = str.length();
       for(int i=size-1;i>=0;i--){
               revstr = revstr + str.charAt(i);
           }
       
       System.out.println("The orginal string:"+str+"\nThe reverssed string:"+revstr);
       if(revstr.equalsIgnoreCase(str))
    	   System.out.println("string is a palindrome");
       else
    	   System.out.println("string is not a palindrome");
    }
}