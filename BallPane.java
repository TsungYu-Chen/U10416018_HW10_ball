//U10416018 陳宗佑

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.security.SecureRandom;
import javafx.scene.control.Button;
import javafx.application.Application;

public class BallPane extends Pane{
	public final double radius = 20;
	private double x = radius, y = radius;
	private double dx = 1, dy = 1;
	private Circle circle = new Circle(x, y, radius);
	private Timeline animation;
	Button button1 = new Button("Y");
	Button button2 = new Button("X");
	
	
        
		

	public BallPane() {
		SecureRandom random = new SecureRandom();
		int R = (int) (Math.random( )*256);
        int G = (int)(Math.random( )*256);
        int B = (int)(Math.random( )*256);
		circle.setFill(Color.rgb(R,G,B));	// Set ball color
		getChildren().add(circle);	// Place a ball into this pane
		// Create an animation for moving the ball
		animation = new Timeline(new KeyFrame(Duration.millis(100), e -> moveBall()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();	// Start animation
		
		button2.setLayoutX(0);
		button2.setLayoutY(0);
		getChildren().add(button2);
		button1.setLayoutX(45);
		button1.setLayoutY(0);
		getChildren().add(button1);
		button1.setPrefSize(40,20);
		button2.setPrefSize(40,20);
	}
	
	public void play() {
		animation.play();
	}
	
	public void pause() {
		animation.pause();
	}
	
	public void increaseSpeed() {
		animation.setRate(animation.getRate() + 0.1);
	}
	
	public void decreaseSpeed() {
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
	}
	
	public DoubleProperty rateProperty() {
		return animation.rateProperty();
	}
	public void change(){
		SecureRandom random = new SecureRandom();
		int R = (int)(Math.random( )*256);
        int G = (int)(Math.random( )*256);
        int B = (int)(Math.random( )*256);
		circle.setFill(Color.rgb(R,G,B));	// Set ball color
	}

	protected void moveBall() {
		// Checkboundaries
		if(x < radius || x > getWidth() - radius) {
			change();
			dx *= -1;	// Change ball move direction
		}
		if(y < radius || y > getHeight() - radius) {
			change();
			dy *= -1;
		}
		
		// Adjust ball position
		x += dx;
		y += dy;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
	public void moveY(){
		dy *= -1;
		y -= dy;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
	public void moveX(){
		dx *= -1;
		x -= dx;
		circle.setCenterY(y);
		circle.setCenterX(x);
	}
	
}
