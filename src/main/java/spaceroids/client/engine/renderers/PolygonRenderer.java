package spaceroids.client.engine.renderers;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import spaceroids.client.models.GameObject;

public class PolygonRenderer implements Renderer{
  public PolygonRenderer() {

  }

  @Override
  public void Render(GraphicsContext gc, GameObject gameObject) {
    float x = gameObject.getTransform().getPosition().getX();
    float y = gameObject.getTransform().getPosition().getY();
    float angle = gameObject.getTransform().getRotation().getAngle();

    gc.translate(x, y);
    gc.rotate(angle);

//    System.out.println(angle);
    gc.setFill(Color.GREEN);
    gc.setStroke(Color.BLUE);
    gc.fillPolygon(new double[]{0, 20, 0, -20},
        new double[]{20, -20, -10, -20}, 4);

    gc.rotate(-angle);
    gc.translate(-x, -y);
  }
}
