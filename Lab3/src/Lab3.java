import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shape_editor.ShapeObjectsEditor;

import java.util.Objects;

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
        Button btnPoint = createToolbarButton("images/point.png", "Point");
        Button btnLine = createToolbarButton("images/line.png", "Line");
        Button btnEllipse = createToolbarButton("images/ellipse.png", "Ellipse");
        Button btnRectangle = createToolbarButton("images/rectangle.png", "Rectangle");

        toolBar.getItems().addAll(btnPoint, btnLine, btnEllipse, btnRectangle);

        VBox menuAndToolbar = new VBox(menuBar, toolBar);
        layout.setTop(menuAndToolbar);

        rectangle.setOnAction(actionEvent -> shapeEditor.startRectangleEditor(scene, drawingArea));
        line.setOnAction(actionEvent -> shapeEditor.startLineEditor(scene, drawingArea));
        point.setOnAction(actionEvent -> shapeEditor.startPointEditor(scene, drawingArea));
        ellipse.setOnAction(actionEvent -> shapeEditor.startEllipseEditor(scene, drawingArea));

        btnRectangle.setOnAction(actionEvent -> shapeEditor.startRectangleEditor(scene, drawingArea));
        btnLine.setOnAction(actionEvent -> shapeEditor.startLineEditor(scene, drawingArea));
        btnPoint.setOnAction(actionEvent -> shapeEditor.startPointEditor(scene, drawingArea));
        btnEllipse.setOnAction(actionEvent -> shapeEditor.startEllipseEditor(scene, drawingArea));

        stage.setScene(scene);
        stage.setTitle("Lab2");
        stage.show();
    }

    private Button createToolbarButton(String imagePath, String tooltipText) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        ImageView imageView = new ImageView(image);

        Button button = new Button();
        button.setGraphic(imageView);

        Tooltip tooltip = new Tooltip(tooltipText);
        Tooltip.install(button, tooltip);

        return button;
    }

    public static void main(String[] args) {
        launch();
    }
}
