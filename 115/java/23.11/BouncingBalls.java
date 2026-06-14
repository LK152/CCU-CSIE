import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBalls extends Application {
   private static final int PANE_WIDTH = 600;
   private static final int PANE_HEIGHT = 400;
   private static final int RADIUS = 12;
   private static final double SPEED = 3.0;
   private static final int MAX_BALLS = 20;
   private static final double CENTER_X = PANE_WIDTH / 2.0;
   private static final double CENTER_Y = PANE_HEIGHT / 2.0;

   private final Random random = new Random();
   private final List<Ball> balls = new ArrayList<>(MAX_BALLS);

   private Pane pane;
   private Button startButton;
   private Button restartButton;
   private Label countLabel;
   private boolean started = false;

   private static class Ball {
      final Circle circle;
      double dx;
      double dy;

      Ball(Circle circle, double dx, double dy) {
         this.circle = circle;
         this.dx = dx;
         this.dy = dy;
      }
   }

   @Override
   public void start(Stage stage) {
      pane = new Pane();
      pane.setPrefSize(PANE_WIDTH, PANE_HEIGHT);
      pane.setMinSize(PANE_WIDTH, PANE_HEIGHT);
      pane.setMaxSize(PANE_WIDTH, PANE_HEIGHT);
      pane.setStyle("-fx-background-color: white;");
      pane.setOnMouseClicked(e -> handlePaneClick());

      startButton = new Button("開始");
      startButton.setOnAction(e -> handleStart());

      restartButton = new Button("重來");
      restartButton.setOnAction(e -> handleRestart());

      countLabel = new Label();

      HBox controls = new HBox(10, startButton, restartButton, countLabel);
      controls.setAlignment(Pos.CENTER_LEFT);
      controls.setPadding(new Insets(8));

      BorderPane root = new BorderPane();
      root.setCenter(pane);
      root.setBottom(controls);

      resetToInitial();

      Timeline timeline = new Timeline(
         new KeyFrame(Duration.millis(16), e -> updateBalls()));
      timeline.setCycleCount(Animation.INDEFINITE);
      timeline.play();

      Scene scene = new Scene(root, PANE_WIDTH, PANE_HEIGHT + 50);
      stage.setTitle("Bouncing Balls");
      stage.setScene(scene);
      stage.show();
   }

   private void resetToInitial() {
      balls.clear();
      pane.getChildren().clear();
      started = false;
      startButton.setDisable(false);
      addBallAtCenter(Color.BLUE, 0, 0);
   }

   private void handleStart() {
      if (started) {
         return;
      }
      started = true;
      startButton.setDisable(true);

      Ball blueBall = balls.get(0);
      double angle = random.nextDouble() * 2.0 * Math.PI;
      blueBall.dx = SPEED * Math.cos(angle);
      blueBall.dy = SPEED * Math.sin(angle);
   }

   private void handleRestart() {
      resetToInitial();
   }

   private void handlePaneClick() {
      if (!started || balls.size() >= MAX_BALLS) {
         return;
      }
      Color color = Color.hsb(random.nextDouble() * 360.0, 0.8, 0.9);
      double angle = random.nextDouble() * 2.0 * Math.PI;
      addBallAtCenter(color, SPEED * Math.cos(angle), SPEED * Math.sin(angle));
   }

   private void addBallAtCenter(Color color, double dx, double dy) {
      Circle circle = new Circle(CENTER_X, CENTER_Y, RADIUS, color);
      balls.add(new Ball(circle, dx, dy));
      pane.getChildren().add(circle);
      updateCount();
   }

   private void updateCount() {
      countLabel.setText("目前球數：" + balls.size() + " / " + MAX_BALLS);
   }

   private void updateBalls() {
      for (Ball ball : balls) {
         Circle c = ball.circle;
         c.setCenterX(c.getCenterX() + ball.dx);
         c.setCenterY(c.getCenterY() + ball.dy);

         if (c.getCenterX() - RADIUS < 0) {
            c.setCenterX(RADIUS);
            ball.dx = -ball.dx;
         }
         else if (c.getCenterX() + RADIUS > PANE_WIDTH) {
            c.setCenterX(PANE_WIDTH - RADIUS);
            ball.dx = -ball.dx;
         }

         if (c.getCenterY() - RADIUS < 0) {
            c.setCenterY(RADIUS);
            ball.dy = -ball.dy;
         }
         else if (c.getCenterY() + RADIUS > PANE_HEIGHT) {
            c.setCenterY(PANE_HEIGHT - RADIUS);
            ball.dy = -ball.dy;
         }
      }
   }

   public static void main(String[] args) {
      launch(args);
   }
}
