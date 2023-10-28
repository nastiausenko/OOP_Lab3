import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shape_editor.ShapeObjectsEditor;

public class Lab3 extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        Pane drawingArea = new Pane();
        layout.setCenter(drawingArea);
        Scene scene = new Scene(layout, 700, 500);

        ShapeObjectsEditor shapeEditor = new ShapeObjectsEditor();

        MenuBar menuBar = new MenuBar();
        drawingArea.setMaxHeight(scene.getHeight() - menuBar.getHeight());
        Menu file = new Menu("File");
        Menu shapes = new Menu("Shapes");
        Menu help = new Menu("Help");

        menuBar.getMenus().addAll(file, shapes, help);

        MenuItem point = new MenuItem("Point");
        MenuItem line = new MenuItem("Line");
        MenuItem ellipse = new MenuItem("Ellipse");
        MenuItem rectangle = new MenuItem("Rectangle");

        shapes.getItems().addAll(point, line, ellipse, rectangle);

        ToolBar toolBar = new ToolBar();
        Button btnPoint = new Button("Point");
        Button btnLine = new Button("Line");
        Button btnEllipse = new Button("Ellipse");
        Button btnRectangle = new Button("Rectangle");

        toolBar.getItems().addAll(btnPoint, btnLine, btnEllipse, btnRectangle);

        VBox menuAndToolbar = new VBox(menuBar, toolBar);
        layout.setTop(menuAndToolbar);

        rectangle.setOnAction(actionEvent -> {
            shapeEditor.startRectangleEditor(scene, drawingArea);
            stage.setTitle("Rectangle");
        });
        line.setOnAction(actionEvent -> {
            shapeEditor.startLineEditor(scene, drawingArea);
            stage.setTitle("Line");
        });
        point.setOnAction(actionEvent -> {
            shapeEditor.startPointEditor(scene, drawingArea);
            stage.setTitle("Point");
        });
        ellipse.setOnAction(actionEvent -> {
            shapeEditor.startEllipseEditor(scene, drawingArea);
            stage.setTitle("Ellipse");
        });

        stage.setScene(scene);
        stage.setTitle("Lab2");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
