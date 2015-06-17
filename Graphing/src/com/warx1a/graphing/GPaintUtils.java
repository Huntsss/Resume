package com.warx1a.graphing;

/**
 * Created by WJ001 on 6/14/15.
 */
public class GPaintUtils {
	
	public void drawLabels(final GGraph graph) {
		final int half_y = graph.canvas.getHeight() / 2;
		final int half_x = graph.canvas.getWidth() / 2;
		final int side_buffer = 10;
		final int axes_buffer = 50;
		graph.getGraphics().drawString(graph.x_label, half_x, graph.canvas.getHeight() - side_buffer);
		graph.getGraphics().drawString(graph.y_label, side_buffer, half_y);
		graph.getGraphics().drawLine(axes_buffer, 0, axes_buffer, graph.canvas.getHeight());
		graph.getGraphics().drawLine(0, graph.canvas.getHeight() - axes_buffer, graph.canvas.getWidth(), graph.canvas.getHeight() - axes_buffer);
	}
	
}
