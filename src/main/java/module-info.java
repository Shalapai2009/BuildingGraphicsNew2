module com.example.buildinggraphicsnew {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buildinggraphicsnew to javafx.fxml;
    exports com.example.buildinggraphicsnew;
}