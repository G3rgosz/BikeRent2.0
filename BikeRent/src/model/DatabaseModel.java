
package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

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
    public boolean setMember(Connection conn, MemberModel member) {
        
        String[] sql = getSql( "setMember" );
        
        PreparedStatement pstmt = null;
        
        try {
            
            pstmt = conn.prepareStatement( sql[0] );
            pstmt.setString( 1 , member.getName());
            pstmt.setString( 2 , member.getEmail());
            pstmt.setString( 3 , member.getPhone());
            pstmt.setString( 4 , member.getAddress());
            pstmt.setString( 5 , member.getIdentity());
            pstmt.executeQuery();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean setBike(Connection conn, BikeModel bike) {
        
        String[] sql = getSql("setBike");
        PreparedStatement pstmt = null;
        try {
        	pstmt = conn.prepareStatement(sql[0], Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bike.getBrand());
            pstmt.executeQuery();
            ResultSet id1 = pstmt.getGeneratedKeys();
            int brand_Id = 0;
            if(id1.next()) {
            	brand_Id = id1.getInt(1);
            }
            pstmt = null;
        	pstmt = conn.prepareStatement(sql[0], Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bike.getBrake());
            pstmt.executeQuery();
            ResultSet id2 = pstmt.getGeneratedKeys();
            int brake_Id = 0;
            if(id2.next()) {
            	brake_Id = id2.getInt(1);
            }
            pstmt = null;
        	pstmt = conn.prepareStatement(sql[0], Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bike.getDesign());
            pstmt.executeQuery();
            ResultSet id3 = pstmt.getGeneratedKeys();
            int design_Id = 0;
            if(id3.next()) {
            	design_Id = id3.getInt(1);
            }
            pstmt = null;
        	pstmt = conn.prepareStatement(sql[0], Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bike.getSize());
            pstmt.executeQuery();
            ResultSet id4 = pstmt.getGeneratedKeys();
            int size_Id = 0;
            if(id4.next()) {
            	size_Id = id4.getInt(1);
            }
            pstmt = null;
        	pstmt = conn.prepareStatement(sql[0], Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bike.getType());
            pstmt.executeQuery();
            ResultSet id5 = pstmt.getGeneratedKeys();
            int type_Id = 0;
            if(id5.next()) {
            	type_Id = id5.getInt(1);
            }
            pstmt = null;
            pstmt = conn.prepareStatement(sql[5]);
        	pstmt.setString(1, bike.getCode());
        	pstmt.setInt(2, bike.getSpeed());
        	pstmt.setInt(3, brand_Id);
        	pstmt.setInt(4, brake_Id);
        	pstmt.setInt(5, design_Id);
        	pstmt.setInt(6, size_Id);
        	pstmt.setInt(7, type_Id);
        	pstmt.execute();
        	
        	return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            
            return false;
        }
    }
}
