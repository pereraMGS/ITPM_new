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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddSubjectController implements Initializable{

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
    private Text addSubTopic;

    @FXML
    private Label offeredYearL;

    @FXML
    private ComboBox<?> selelectOfferedYear;

    @FXML
    private Label offeredSemL;

    @FXML
    private RadioButton semOne;

    @FXML
    private RadioButton semTwo;

    @FXML
    private Label subNameL;

    @FXML
    private TextField inputSubName;

    @FXML
    private Label subCodeL;

    @FXML
    private TextField inputSubCode;

    @FXML
    private Label lecHrsL;

    @FXML
    private TextField inputLecHrs;

    @FXML
    private Label tuteHrsL;

    @FXML
    private TextField inputTuteHrs;

    @FXML
    private Label labHrsL;

    @FXML
    private TextField inputLabHrs;

    @FXML
    private Label evaluHrsL;

    @FXML
    private TextField inputevaluationHrs;

    @FXML
    private Button clearbtn;

    @FXML
    private Button savebtn;

    @FXML
    private HBox headerBar;

    @FXML
    private ImageView companyLogo;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField seachBox;

    @FXML
    void btnSearch(ActionEvent event) {

    }

    @FXML
    void clearBtn(ActionEvent event) {

    }

    @FXML
    void saveBtn(ActionEvent event) {

		String name = inputSubName.getText();
		String code = inputSubCode.getText();
		String lecHrs = inputLecHrs.getText();
		String tuteHrs = inputTuteHrs.getText();
		String labHrs = inputLabHrs.getText();
		String EvaHrs = inputevaluationHrs.getText();
		
		if(name.isEmpty()||code.isEmpty()||lecHrs.isEmpty()||tuteHrs.isEmpty()||labHrs.isEmpty()||EvaHrs.isEmpty()) {
			Alert alert =new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please Fill All Data");
			alert.showAndWait();
		}
		else {
			//call data insert method
			InsertSubject(); 
			
		}
		
		try {
			//after the save button clicked it will be redirect ManageSubject.fxml
			Parent root =FXMLLoader.load(getClass().getResource("ManageSubject.fxml"));
			Scene scene = new Scene(root);
			Stage stage =new Stage();
			stage.setScene(scene);
			stage.show();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    private void InsertSubject() {
		
    	Connection con =getConnection();
		String query ="insert into subject (Year,Semester,Name,Code,LectureHourse,TutorialHourse,LabHourse,EvaluationHourse) values(?,?,?,?,?,?,?,?)";
		try {
			
		preparedStatement = getConnection().prepareStatement(query);
		preparedStatement.setString(1, combobox.getValue());
		preparedStatement.setString(2, getReadioButtons());
		preparedStatement.setString(3, inputSubName.getText());
		preparedStatement.setString(4, inputSubCode.getText());
		preparedStatement.setString(5, inputLecHrs.getText());
		preparedStatement.setString(6, inputTuteHrs.getText());
		preparedStatement.setString(7, inputLabHrs.getText());
		preparedStatement.setString(8, inputevaluationHrs.getText());
		preparedStatement.execute();
		
		JOptionPane.showMessageDialog(null, "Insert Successfully");
		
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
	}

	@FXML
    void semesterRadioBtn(ActionEvent event) {
    	
    	getReadioButtons();
    }
    
    private String getReadioButtons() {
		
    	String message ="";
    	if(semOne.isSelected()) {
    	message += semOne.getText() +"\n";
    	}

    	if(semTwo.isSelected()) {
    	message += semTwo.getText() +"\n";
    	}

    	System.out.println(message);
    	return message;
	}
    
    @FXML
    public ComboBox<String> combobox;

    ObservableList <String> List = FXCollections.observableArrayList("2018" , "2019", "2020", "2021");

	String query =null;
	ResultSet resultsset =null;
	PreparedStatement preparedStatement;
	Subject subject;

	private Connection getConnection() {
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
			combobox.setItems(List);
		}
}
