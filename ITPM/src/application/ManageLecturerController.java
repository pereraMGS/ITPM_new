package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ManageLecturerController {

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
    private TableView<?> manageLecTable;

    @FXML
    private Label lecNameL;

    @FXML
    private TextField inputLecName;

    @FXML
    private Label centerL;

    @FXML
    private ComboBox<?> selectCenter;

    @FXML
    private Label empIdL;

    @FXML
    private TextField inputEmpID;

    @FXML
    private Label buildingL;

    @FXML
    private ComboBox<?> selectBuilding;

    @FXML
    private Label facultyL;

    @FXML
    private ComboBox<?> selectFaculty;

    @FXML
    private Label levelL;

    @FXML
    private ComboBox<?> selectLevel;

    @FXML
    private Label deptL;

    @FXML
    private ComboBox<?> selectDept;

    @FXML
    private Label rankL;

    @FXML
    private TextField inputRank;

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

}
