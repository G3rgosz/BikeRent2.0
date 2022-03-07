package control;

import java.util.Vector;
import model.DatabaseModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import model.BikeModel;
import model.DatabaseConnection;
import model.MemberModel;

public class DatabaseController {

	private DatabaseModel dbModel;
    private Connection conn;
    
    public DatabaseController() {
        
        dbModel = new DatabaseModel();
    }

    protected boolean setDatabase() {
        
        DatabaseConnection dbConn = new DatabaseConnection();
        dbConn.setConnection();
        conn = dbConn.getConnection();
        
        if( conn != null ) {
           return true; 
        }else {
            return false;
        }
    }
    
    public Vector<Vector<Object>> getMembers() {
        
        Vector<Vector<Object>> members = new Vector<>();
        ResultSet rs = dbModel.getMember( conn, "__GETMEMBERS__" );
        
        try {
            while( rs.next() ) {
                
                Vector<Object> member = new Vector<>();
                member.add( rs.getString( "name" ));
                member.add( rs.getString( "email" ));
                member.add( rs.getString( "phone" ));
                member.add( rs.getString( "address" ));
                member.add( rs.getString( "identity" ));
                
                members.add( member );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return members;
    }
    
    public Vector<Vector<Object>> getBikes() {
        
        Vector<Vector<Object>> bikes = new Vector<>();
        ResultSet rs = dbModel.getBike( conn, "__GETBIKES__" );
        
        try {
            while( rs.next() ) {
                
                Vector<Object> bike = new Vector<>();
                bike.add( rs.getString( "type" ));
                bike.add( rs.getString( "design" ));
                bike.add( rs.getString( "size" ));
                bike.add( rs.getString( "brake" ));
                bike.add( rs.getString( "speed" ));
                bike.add( rs.getString( "brand" ));
                bike.add( rs.getString( "code" ));
               
                bikes.add( bike );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bikes;
    }
    
    public Vector<Vector<Object>> getRents() {
        
        Vector<Vector<Object>> rents = new Vector<>();
        ResultSet rs = dbModel.getRents( conn, "__GETRENTS__");
        
        try {
            while( rs.next() ) {
                
                Vector<Object> rent = new Vector<>();
                rent.add( rs.getString( "name" ));
                rent.add( rs.getString( "code" ));
                rent.add( rs.getString( "startdate" ));
                rent.add( rs.getString( "enddate" ));
                rent.add( rs.getString( "deposit" ));
                
                rents.add( rent );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rents;
    }
    
    public boolean setMemberData( MemberModel model ) {
        
        boolean success = dbModel.setMember( conn,  model );
        
        return success;
    }
    
    public boolean setBikeData( BikeModel model ) {
        
        boolean success = dbModel.setBike( conn, model );
        
        return success;
    }
}
