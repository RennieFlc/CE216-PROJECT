module com.example.ce216project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ce216project to javafx.fxml;
    exports com.example.ce216project;
}