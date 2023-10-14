package com.interview.corejava;

class Greeting implements Cloneable {
    String message;

    public Greeting(String message) {
        this.message = message;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

public class CloneableInterfaceDemo {
    public static void main(String[] args) {
        Greeting g1 = new Greeting("this is original");
        System.out.println("Original: " + g1.getMessage());
        try {
            Greeting g2 = (Greeting) g1.clone();
            System.out.println("Clone: " + g2.getMessage());
            g2.setMessage("this is now clone");

            System.out.println("Original: " + g1.getMessage());
            System.out.println("Clone: " + g2.getMessage());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
