module com.example.w23comp1008lhvideogame {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.w23comp1008lhvideogame to javafx.fxml;
    exports com.example.w23comp1008lhvideogame;
}