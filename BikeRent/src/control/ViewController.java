
package control;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.BikeModel;
import model.MemberModel;
import model.ViewModel;
import view.BikeForm;


public class ViewController {
    
    private BikeForm bikeFrm;
    private ViewModel viewMdl;
    private BikeModel bikeMdl;
    private Vector<Vector<Object>> tableData;
    private DatabaseController dbCtr;

    public ViewController( DatabaseController dbCtr ) {
        
        this.dbCtr = dbCtr;
        bikeFrm = new BikeForm();
        viewMdl = new ViewModel();
        initComponents();
        initListeners();
        start();
    }
    
    private void initComponents() {
        
        if( dbCtr.setDatabase() ){
            bikeFrm.setStatusLbl( "Kapcsolat OK" );
        }
    }
    
    private void initListeners() {
        
        bikeFrm.getExitBtn().addActionListener( event -> { exit(); });
        bikeFrm.getDeleteBtn().addActionListener( event -> { delete(); });
        bikeFrm.getEditBtn().addActionListener( event -> { edit(); });
        bikeFrm.getSaveBtn().addActionListener( event -> { save(); });
        bikeFrm.getSearchBtn().addActionListener( event -> { search(); });
        bikeFrm.getTableTb().addChangeListener( event -> { initTables(); });
    }
    
    private void start() {
        
        initTables();
        bikeFrm.setVisible( true );
    }
    
    private void initTables() {
        
        Vector<String> columnNames = new Vector<>();
        //tableData = new Vector<>();
        switch (bikeFrm.getTableTb().getSelectedIndex()) {
            case 0:
                {
                    columnNames = viewMdl.getMemberColumnNames();
                    tableData = dbCtr.getMembers();
                    tableData.add( null );
                    TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
                    bikeFrm.getMemberTbl().setModel( tablMdl );
                    break;
                }
            case 1:
                {
                    columnNames = viewMdl.getBikeColumnNames();
                    tableData = dbCtr.getBikes();
                    tableData.add( null );
                    TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
                    bikeFrm.getBikeTbl().setModel( tablMdl );
                    break;
                }
            case 2:
                {
                    columnNames = viewMdl.getRentColumnNames();
                    tableData = dbCtr.getRents();
                    tableData.add( null );
                    TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
                    bikeFrm.getRentTbl().setModel( tablMdl );
                    break;
                }
        }
    }
    
    private void search() {

    }
    
    private void save() {
        
        if(bikeFrm.getTableTb().getSelectedIndex()== 0) {
            MemberModel memModel = new MemberModel();
            
            int row = bikeFrm.getMemberTbl().getSelectedRow();
            memModel.setName(bikeFrm.getMemberTbl().getValueAt(row, 0).toString());
            memModel.setEmail(bikeFrm.getMemberTbl().getValueAt(row, 1).toString());
            memModel.setPhone(bikeFrm.getMemberTbl().getValueAt(row, 2).toString());
            memModel.setAddress(bikeFrm.getMemberTbl().getValueAt(row, 3).toString());
            memModel.setIdentity(bikeFrm.getMemberTbl().getValueAt(row, 4).toString());
            
            boolean success = dbCtr.setMemberData(memModel);
            
            if(success) {
                bikeFrm.setStatusLbl("Sikeres kiírás!");
                initTables();
            }else{
                bikeFrm.setStatusLbl("Hiba a kiírás során!");
            }
        }else if (bikeFrm.getTableTb().getSelectedIndex()== 1) {
            
            BikeModel model = new BikeModel();
            
            int row = bikeFrm.getMemberTbl().getSelectedRow();
            model.setType(bikeFrm.getBikeTbl().getValueAt(row, 0).toString());
            model.setDesign(bikeFrm.getBikeTbl().getValueAt(row, 1).toString());
            model.setSize(bikeFrm.getBikeTbl().getValueAt(row, 2).toString());
            model.setBrake(bikeFrm.getBikeTbl().getValueAt(row, 3).toString());
            model.setSpeed(bikeFrm.getBikeTbl().getValueAt(row, 4).toString());
            model.setBrand(bikeFrm.getBikeTbl().getValueAt(row, 5).toString());
            model.setCode(bikeFrm.getBikeTbl().getValueAt(row, 6).toString());
            
            boolean success = dbCtr.setBikeData(model);
            
            if(success) {
                bikeFrm.setStatusLbl("Sikeres kiírás!");
                initTables();
            }else {
				bikeFrm.setStatusLbl("Hiba a kiírás során!");
			}
        }
        
    }

    private void edit() {
        System.out.println("módosít gomb");
    }
    
    private void delete() {
        System.out.println("törlés gomb");
    }
    
    private void exit() {
        
        System.exit( 0 );
    }
}
