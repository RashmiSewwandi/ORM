import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        /*Student student = new Student();
        student.setId("C002");
        customer.setName("Rashmi");
        customer.setAddress("Colombo");
        customer.setSalary(50000);*/

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        // session.update(customer);
        // session.save(customer);
        // session.delete(customer);
       /* session.get(Customer.class, session.getSession());
        System.out.println(customer.getAddress());*/

        transaction.commit();

        session.close();



    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("views/LoginForm.fxml"));
        primaryStage.setTitle("Sipsewana Institute (v-1.0.0)");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
