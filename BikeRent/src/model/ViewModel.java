
package model;

import java.util.Vector;


public class ViewModel {

    public ViewModel() {
    }
    
    public Vector<String> getMemberColumnNames() {
        
        Vector<String> columnNames = new Vector<>();
        
        columnNames.add( "N�v" );
        columnNames.add( "Email" );
        columnNames.add( "Telefon" );
        columnNames.add( "C�m" );
        columnNames.add( "Ig. sz�m" );
        
        return columnNames;
    }
    
    public Vector<String> getBikeColumnNames() {
        
        Vector<String> columnNames = new Vector<>();
        
        columnNames.add( "St�lus" );
        columnNames.add( "Nem" );
        columnNames.add( "M�ret" );
        columnNames.add( "F�k" );
        columnNames.add( "Sebess�g" );
        columnNames.add( "M�rka" );
        columnNames.add( "V�zsz�m" );
        
        return columnNames;
    }
    
    public Vector<String> getRentColumnNames() {
        
        Vector<String> columnNames = new Vector<>();
        
        columnNames.add( "N�v" );
        columnNames.add( "Ker�kp�r" );
        columnNames.add( "Ki d�tum" );
        columnNames.add( "Be d�tum" );
        columnNames.add( "Let�t" );
        
        return columnNames;
    }
}
