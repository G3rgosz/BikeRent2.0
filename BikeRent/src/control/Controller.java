
package control;


public class Controller {

    public Controller() {
        
        DatabaseController dbCtr = new DatabaseController();
        new ViewController( dbCtr );
        
    }
    
    
}
