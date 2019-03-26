package p01_SingleResponsibility.p01_DrawingShape;

import p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class RendererImpl implements Renderer {
    @Override
    public void render(Shape shape) {
        System.out.println("draw shape");
    }
}
