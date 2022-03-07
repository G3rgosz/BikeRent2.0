package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class DatabaseModel {
    
    public DatabaseModel() {
    }
    
    private String[] getSql( String fileName ) {
        
        String filePath = "sql/" + fileName + ".sql";
        String[] sql = null;
        try {
            
           Path path = Path.of( filePath );
           String content = Files.readString( path );
           
           sql = content.split( ";" ); 
           
        } catch ( IOException ex ) {
            
            ex.printStackTrace();
        }
        
        return sql;
    }
    
    public ResultSet getMember( Connection conn, String fileName ) {
        
        String[] sql = getSql( fileName );
        
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            
           stmt = conn.createStatement();
           rs = stmt.executeQuery( sql[ 0 ] );
            
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public ResultSet getBike( Connection conn, String fileName ) {
        
        String[] sql = getSql( fileName );
        
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            
           stmt = conn.createStatement();
           rs = stmt.executeQuery( sql[ 0 ] );
            
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public ResultSet getRents( Connection conn, String fileName ) {

        String sql[] = getSql( fileName );
        
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            
           stmt = conn.createStatement();
           rs = stmt.executeQuery( sql[ 0 ] );
            
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public boolean setMember( Connection conn, MemberModel member ) {
        
        String[] sql = getSql( "__SETMEMBER__" );
        PreparedStatement pstmt = null;
        
        try {
            
            pstmt = conn.prepareStatement( sql[ 0 ]);
            pstmt.setString( 1, member.getName() );
            pstmt.setString( 2, member.getEmail() );
            pstmt.setString( 3, member.getPhone() );
            pstmt.setString( 4, member.getAddress() );
            pstmt.setString( 5, member.getIdentity() );
            pstmt.executeQuery();
            
            return true;
            
        } catch ( SQLException ex ) {
            
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean setBike( Connection conn, BikeModel model ) {
        
        String[] sql = getSql( "__SETBIKE__" );
        
        PreparedStatement pstmt = null;
        try {
            
            pstmt = conn.prepareStatement( sql[ 0 ]);//, Statement.RETURN_GENERATED_KEYS 
            pstmt.setString( 1, model.getBrand() );
            ResultSet id1 = pstmt.executeQuery();
            int brand_id = 0;
            while(id1.next()) {
            	brand_id = id1.getInt(1);
            }
            	
//            		pstmt.getGeneratedKeys();
//            int brand_id = 0;
//            if ( id1.next() ) {
//				brand_id = id1.getInt( 1 );
//			}
            
            pstmt = null;
            pstmt = conn.prepareStatement( sql[ 1 ]);
            pstmt.setString( 1, model.getBrake() );
            ResultSet id2 = pstmt.executeQuery();
            int brake_id = 0;
            while(id2.next()) {
            	brake_id = id2.getInt(1);
            }
            
            pstmt = null;
            pstmt = conn.prepareStatement( sql[ 2 ]);
            pstmt.setString( 1, model.getDesign() );
            ResultSet id3 = pstmt.executeQuery();
            int design_id = 0;
            while(id3.next()) {
            	design_id = id3.getInt(1);
            }
            
            pstmt = null;
            pstmt = conn.prepareStatement( sql[ 3 ]);
            pstmt.setString( 1, model.getSize() );
            ResultSet id4 = pstmt.executeQuery();
            int size_id = 0;
            while(id4.next()) {
            	size_id = id4.getInt(1);
            }
            
            pstmt = null;
            pstmt = conn.prepareStatement( sql[ 4 ]);
            pstmt.setString( 1, model.getType() );
            ResultSet id5 = pstmt.executeQuery();
            int type_id = 0;
            while(id5.next()) {
            	type_id = id5.getInt(1);
            }
            
            
            pstmt = null;
            pstmt = conn.prepareStatement( sql[ 5 ]);
            pstmt.setString( 1, model.getCode() );
            pstmt.setInt( 2, model.getSpeed() );
            pstmt.setInt( 3, brand_id );
            pstmt.setInt( 4, brake_id );
            pstmt.setInt( 5, design_id );
            pstmt.setInt( 6, size_id );
            pstmt.setInt( 7, type_id );
            pstmt.executeQuery();
            
            return true;
            
        } catch ( SQLException ex ) {
            ex.printStackTrace();
            return false;
        }
        
    }
}
