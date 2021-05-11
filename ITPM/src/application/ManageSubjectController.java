package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ManageSubjectController implements Initializable {
	
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
    private Text manageLecTopic;

    @FXML
    private TableView<Subject> manageSubTable;

    @FXML
    private TableColumn<Subject, String> tvYear;

    @FXML
    private TableColumn<Subject, String> tvSem;

    @FXML
    private TableColumn<Subject, String> tvName;

    @FXML
    private TableColumn<Subject, String> tvCode;

    @FXML
    private TableColumn<Subject, String> tvTuteHrs;

    @FXML
    private TableColumn<Subject, String> tvLabHrs;

    @FXML
    private TableColumn<Subject, String> tvevaluHrs;

    @FXML
    private TableColumn<Subject, String> tvLecHrs;

    @FXML
    private Label offeredYearL;

  

    @FXML
    private Label tuteHrsL;

    @FXML
    private TextField inputTuteHrs;

    @FXML
    private Label offeredSemL;

    @FXML
    private RadioButton semOne;

    @FXML
    private RadioButton semTwo;

    @FXML
    private Label labHrsL;

    @FXML
    private TextField inputLabHrs;

    @FXML
    private Label subNameL;

    @FXML
    private TextField inputSubName;

    @FXML
    private Label evaluHrsL;

    @FXML
    private TextField inputevaluationHrs;

    @FXML
    private Label subCodeL;

    @FXML
    private TextField inputSubCode;

    @FXML
    private Label lecHrsL;

    @FXML
    private TextField inputLecHrs;

    @FXML
    private Button updateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button clearbtn;

    @FXML
    private HBox headerBar;

    @FXML
    private ImageView companyLogo;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField seachBox;

    @FXML
    void BtnDelete(ActionEvent event) {

    }

    @FXML
    void btnSearch(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @FXML
    void clearBtn(ActionEvent event) {

    }
    
    @FXML
    public ComboBox<String> combobox;

    ObservableList <String> List = FXCollections.observableArrayList( "2018" , "2019" , "2020", "2021");
    
    int index =-1;
	
	String query =null;
	ResultSet resultsset =null;
	PreparedStatement preparedStatement;
	Subject subject;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		combobox.setItems(List);
		showSubject();
		RefreshTable();
	}
	
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
			
		//show data in table
		public void showSubject() {
			
			ObservableList<Subject> list = getSubjectList();
			
			tvYear.setCellValueFactory(new PropertyValueFactory<Subject, String>("Year"));
			tvSem.setCellValueFactory(new PropertyValueFactory<Subject, String>("sem"));
			tvName.setCellValueFactory(new PropertyValueFactory<Subject, String>("name"));
			tvCode.setCellValueFactory(new PropertyValueFactory<Subject, String>("code"));
			tvTuteHrs.setCellValueFactory(new PropertyValueFactory<Subject, String>("lecHrs"));
			tvLabHrs.setCellValueFactory(new PropertyValueFactory<Subject, String>("tuteHrs"));
			tvevaluHrs.setCellValueFactory(new PropertyValueFactory<Subject, String>("labHrs"));
			tvLecHrs.setCellValueFactory(new PropertyValueFactory<Subject, String>("EvaHrs"));
			
			manageSubTable.setItems(list);
			
		}
		

		/*In this method When user 
		click the one record from table, 
		all the details in that record will 
		be loaded in the respected fields 
		below*/
		@FXML
		void getSelected (MouseEvent event) {
			index = manageSubTable.getSelectionModel().getFocusedIndex();
			if(index <= -1) {
				return;
			}
			inputSubCode.setText(tvCode.getCellData(index).toString());
			inputSubName.setText(tvName.getCellData(index).toString());
			inputTuteHrs.setText(tvTuteHrs.getCellData(index).toString());
			inputLabHrs.setText(tvLabHrs.getCellData(index).toString());
			inputevaluationHrs.setText(tvevaluHrs.getCellData(index).toString());
			inputLecHrs.setText(tvLecHrs.getCellData(index).toString());
			
		}
		
		//Update Method
		public void EditSubject() {
			
		try {
			Connection con =getConnection();
			String val1 = inputSubCode.getText();
			String val2 =inputSubName.getText();
			String val3 =inputTuteHrs.getText();
			String val4 =inputLabHrs.getText();
			String val5 =inputevaluationHrs.getText();
			String val6 =inputLecHrs.getText();
			
			String query ="update subject set Code ='"+val1+"',Name ='"+val2+"',TutorialHourse ='"+val3+"',LabHourse ='"+val4+"',EvaluationHourse ='"+val5+"',LectureHourse ='"+val6+"', where Code='"+val1+"'";
			
			
			preparedStatement = getConnection().prepareStatement(query);
			preparedStatement.execute();
			
			
			
			JOptionPane.showMessageDialog(null, "Updated Successfully");
			RefreshTable();
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
		//After the Update is done auto refresh the page and Updated data display in table
	public void RefreshTable() {
		
		tvCode.setCellValueFactory(new PropertyValueFactory<Subject, String>("Code"));
		tvName.setCellValueFactory(new PropertyValueFactory<Subject, String>("Name"));
		tvTuteHrs.setCellValueFactory(new PropertyValueFactory<Subject, String>("TutorialHourse"));
		tvLabHrs.setCellValueFactory(new PropertyValueFactory<Subject, String>("LabHourse"));
		tvevaluHrs.setCellValueFactory(new PropertyValueFactory<Subject, String>("EvaluationHourse"));
		tvLecHrs.setCellValueFactory(new PropertyValueFactory<Subject, String>("LectureHourse"));
		
		ObservableList<Subject> list = getSubjectList();
		manageSubTable.setItems(list);
		

		
	}

	//Delete Method
	public void DeleteSubject() {
		Connection con =getConnection();
		String query ="delete from subject where Code =?";
		
		try {
			preparedStatement = getConnection().prepareStatement(query);
			preparedStatement.setString(1, inputSubCode.getText());
			preparedStatement.execute();
			JOptionPane.showMessageDialog(null, "Deleted Successfully");
			RefreshTable();
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
		
		//View data
		private ObservableList<Subject> getSubjectList() {
			ObservableList<Subject> subjectList =FXCollections.observableArrayList();
			Connection con = getConnection();
			String query ="SELECT * FROM subject";
			Statement st;
			ResultSet rs;
			
			try {
				st =con.createStatement();
				rs =st.executeQuery(query);
				Subject subject;
				while(rs.next()) {
					subject =new Subject(rs.getString("Year"), rs.getString("Semester"), rs.getString("Name"), rs.getString("Code"), rs.getString("LectureHourse"), rs.getString("TutorialHourse"), rs.getString("LabHourse"), rs.getString("EvaluationHourse"));
					subjectList.add(subject);
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return subjectList;
		}
		
}