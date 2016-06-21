package nioTest;

/**
 *  간단하게 종료를 나타내는  클래스
 * */
public class Abortable {   
    public boolean done = false;   
       
    public Abortable() {   
        init();   
    }   
       
    public void init() {   
        done = false;   
    }   
       
    public boolean isDone() {   
        return done;   
    }   
}  