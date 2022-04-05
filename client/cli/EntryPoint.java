package client.cli;

import app.src.hello.Hello;

public class EntryPoint {
    public static void main(String args[]) {
        Hello h = new Hello();
        System.out.println(h.random());
    }
}
