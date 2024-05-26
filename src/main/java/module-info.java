module dev.hiruna.epfetf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens dev.hiruna.epfetf to javafx.fxml;
    exports dev.hiruna.epfetf;
}