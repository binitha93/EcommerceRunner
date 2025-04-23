package interview;

class Palindrome {
    public static void main(String[] args) {
       String str = "Madam";
       String revstr = null;
       int size = str.length();
       for(int i=size;i>=0;i--){
               revstr = revstr + str.charAt(i);
           }
       if(revstr.equalsIgnoreCase(revstr))
       System.out.println("string is a palindrome");
    }
}