package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddLecturerController implements Initializable {
	
	@FXML
    private HBox headerBar;

    @FXML
    private ImageView companyLogo;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField seachBox;

    @FXML
    private Text dashBoard;

    @FXML
    private Text addLec;

    @FXML
    private Text manageLec;

    @FXML
    private Text addSub;

    @FXML
    private Text manageSub;

    @FXML
    private Text daysAndHrs;

    @FXML
    private Text addStdnGrp;

    @FXML
    private Text manageStdnGrp;

    @FXML
    private Text addTags;

    @FXML
    private Text manageTags;

    @FXML
    private Text addLocation;

    @FXML
    private Text manageLocation;

    @FXML
    private Text addSession;

    @FXML
    private Text manageSession;

    @FXML
    private Label lecNameL;

    @FXML
    private TextField inputLecName;

    @FXML
    private Label empIdL;

    @FXML
    private TextField inputEmpID;

    @FXML
    private Label facultyL;

    @FXML
    private ComboBox<?> selectFaculty;

    @FXML
    private Label deptL;

    @FXML
    private ComboBox<?> selectDept;

    @FXML
    private Label centerL;

    @FXML
    private ComboBox<?> selectCenter;

    @FXML
    private Label buildingL;

    @FXML
    private ComboBox<?> selectBuilding;

    @FXML
    private Label levelL;

    @FXML
    private Label lecHrsL;

    @FXML
    private CheckBox monday;

    @FXML
    private CheckBox tuesday;

    @FXML
    private CheckBox wednesday;

    @FXML
    private CheckBox thursday;

    @FXML
    private CheckBox friday;

    @FXML
    private CheckBox saturday;

    @FXML
    private CheckBox sunday;

    @FXML
    private TextField inputLechrs;

    @FXML
    private RadioButton am;

    @FXML
    private RadioButton pm;

    @FXML
    private Label rankL;

    @FXML
    private TextField inputRank;
    
    @FXML
    private TextField inputLevel;

    @FXML
    private Button generateRankbtn;

    @FXML
    private Button clearbtn;

    @FXML
    private Button savebtn;
    
    @FXML
    void lectureDays(ActionEvent event) {

    	getCheckBox();
    }
    
    void AddLecturer(ActionEvent event) {
    	
    }

    private String getCheckBox() {
		
    	String message1 ="";
    	if(monday.isSelected()) {
    	message1 += monday.getText() +"\n";
    	}
    	if(tuesday.isSelected()) {
    	message1 += tuesday.getText() +"\n";
    	}
    	if(wednesday.isSelected()) {
    	message1 += wednesday.getText() +"\n";
    	}
    	if(thursday.isSelected()) {
        	message1 += thursday.getText() +"\n";
        }
    	if(friday.isSelected()) {
        	message1 += friday.getText() +"\n";
        }
    	if(saturday.isSelected()) {
        	message1 += saturday.getText() +"\n";
        }
    	if(sunday.isSelected()) {
        	message1 += sunday.getText() +"\n";
        }

    	System.out.println(message1);
    	return message1;
	}

	@FXML
    void GenerateRanks(MouseEvent event) {

    	String empID = inputEmpID.getText();
    	String level = inputLevel.getText();
    	
    	String result = empID + "." + level;
    	
    	inputRank.setText(result);
    }

    @FXML
    void clear(MouseEvent event) {

    }

    @FXML
    void clearBtn(ActionEvent event) {

    }
    
    @FXML
    void AMorPM(ActionEvent event) {
    	
    	getReadioButtons();
    }
    
    private String getReadioButtons() {
		
    	String message ="";
    	if(am.isSelected()) {
    	message += am.getText() +"\n";
    	}

    	if(pm.isSelected()) {
    	message += pm.getText() +"\n";
    	}

    	System.out.println(message);
    	return message;
	}

	@FXML
    public ComboBox<String> combobox1;

    ObservableList <String> List1 = FXCollections.observableArrayList("Computing" , "Business Management", "IT", "Engineering", "Humanity and Science");
    
    @FXML
    public ComboBox<String> combobox2;

    ObservableList <String> List2 = FXCollections.observableArrayList("Computing" , "Business Management", "IT", "Engineering", "Humanity and Science");

    @FXML
    public ComboBox<String> combobox3;

    ObservableList <String> List3 = FXCollections.observableArrayList("Malabe" , "Metro", "Kandy");
    
    @FXML
    public ComboBox<String> combobox4;

    ObservableList <String> List4 = FXCollections.observableArrayList("Main Building" , "New Building");
    


    	

    private void InserLecturer() {
    	
    	Connection con =getConnection();
		String query ="insert into lecturer (ID,Name,Faculty,Department,Center,Building,Level,Rank,Hourse) values(?,?,?,?,?,?,?,?,?)";
		try {
			
		preparedStatement = getConnection().prepareStatement(query);
		preparedStatement.setString(1, inputEmpID.getText());
		preparedStatement.setString(2, inputLecName.getText());
		preparedStatement.setString(3, combobox1.getValue());
		preparedStatement.setString(4, combobox2.getValue());
		preparedStatement.setString(5, combobox3.getValue());
		preparedStatement.setString(6, combobox4.getValue());
		preparedStatement.setString(7, inputRank.getText());
		preparedStatement.setString(8, inputLevel.getText());
		preparedStatement.setString(9, getCheckBox()+inputLechrs.getText()+getReadioButtons());
		preparedStatement.execute();
		
		JOptionPane.showMessageDialog(null, "Insert Successfully");
		
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
	}

	@FXML
    void saveBtn(ActionEvent event) {
		String id = inputEmpID.getText();
		String name = inputLecName.getText();
		String level = inputLevel.getText();
		String rank = inputRank.getText();
		String activeHrs = inputLechrs.getText();
		
		if(id.isEmpty()||name.isEmpty()||level.isEmpty()||rank.isEmpty()||activeHrs.isEmpty()) {
			Alert alert =new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please Fill All Data");
			alert.showAndWait();
		}
		else {
			//call data insert method
			InserLecturer(); 
			
		}
		
		try {
			//after the save button clicked it will be redirect ManageLecturer.fxml
			Parent root =FXMLLoader.load(getClass().getResource("ManageLecturer.fxml"));
			Scene scene = new Scene(root);
			Stage stage =new Stage();
			stage.setScene(scene);
			stage.show();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    

    @FXML
    void search(MouseEvent event) {

    }
    
    String query =null;
	ResultSet resultsset =null;
	PreparedStatement preparedStatement;
	Lecturer lecturer;
	
	
	
	
	//DB connection
	public Connection getConnection() {
		Connection con;
		try{
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/abcinstitute", "root","");
			return con;
			
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
			return null;
			
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			combobox1.setItems(List1);
			combobox2.setItems(List2);
			combobox3.setItems(List3);
			combobox4.setItems(List4);
		}
		
	
}
