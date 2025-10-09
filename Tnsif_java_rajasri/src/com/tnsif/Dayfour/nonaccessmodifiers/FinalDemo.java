package com.tnsif.Dayfour.nonaccessmodifiers;


class FinalVariableDemo {
    final int VAR = 100;  // final variable (constant)

    void showVar() {
        System.out.println("Final variable VAR = " + VAR);
        // VAR = 200;  // ❌ Error: cannot assign a value to final variable
    }

    public static void main(String[] args) {
        FinalVariableDemo fvd = new FinalVariableDemo();
        fvd.showVar();
    }
}

// 2️⃣ Final method demonstration
class FinalMethodDemo {
    final void display() {  // final method
        System.out.println("Final method display called");
    }
}

class ChildMethodDemo extends FinalMethodDemo {
    // ❌ Cannot override final method
    /*
    void display() {
        System.out.println("Trying to override final method"); 
    }
    */

    public static void main(String[] args) {
        ChildMethodDemo child = new ChildMethodDemo();
        child.display();  // calls parent final method
    }
}