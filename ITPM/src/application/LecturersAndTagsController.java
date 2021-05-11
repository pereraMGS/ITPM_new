package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class LecturersAndTagsController {


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
    private Label selectLecL;

    @FXML
    private ComboBox<?> selectLecturer;

    @FXML
    private Label selectTagL;

    @FXML
    private ComboBox<?> selectTags;

    @FXML
    private Label selectedLecL;

    @FXML
    private TextField showLecTF;

    @FXML
    private Button nextBtn;

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
    void btnSearch(ActionEvent event) {

    }

    @FXML
    void clearBtn(ActionEvent event) {

    }

    @FXML
    void genRankBtn(ActionEvent event) {

    }

}
