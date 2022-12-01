module com.furu.hibernatefxexamen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires com.jfoenix;

    opens com.furu.hibernatefxexamen to javafx.fxml;
    opens entity to org.hibernate.orm.core;

    exports com.furu.hibernatefxexamen;
}