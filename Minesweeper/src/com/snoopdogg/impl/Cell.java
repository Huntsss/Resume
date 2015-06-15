package com.snoopdogg.impl;

/**
 *  This file is part of Minesweeper.

    Minesweeper is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Minesweeper is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Cell {
	
	private final int rows, columns, cellWidth, cellHeight;
	
	private ArrayList<Tile> gameTiles = new ArrayList<>();
	
	public Cell(final int rows, final int columns, final int cellWidth, final int cellHeight) {
		this.rows = rows;
		this.columns = columns;
		this.cellWidth = cellWidth;
		this.cellHeight = cellHeight;
	}
	
	public int rows() {
		return rows;
	}
	
	public int columns() {
		return columns;
	}
	
	public Dimension recommendedDimensions() {
		final int recommendedX = (columns * cellWidth);
		final int recommendedY = (rows * cellHeight);
		return new Dimension(recommendedX, recommendedY);
	}
	
	public int cellCount() {
		return rows * columns;
	}
	
	public void drawCellBoundaries(final BufferedImage canvas, final Graphics2D g1, final Color color) {
		g1.setColor(color);
		g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for(int i =0; i < columns; i++) {
			final int verticalLine = i * cellWidth;
			g1.drawLine(verticalLine, 0, verticalLine, canvas.getHeight());
		}
		for(int i =0; i < rows; i++) {
			final int horizontalLine = i * cellHeight;
			g1.drawLine(0, horizontalLine, canvas.getWidth(), horizontalLine);
		}
	}
	
	public void createTiles() {
		for(int i = 0; i < columns; i++) {
			for(int x = 0; x < rows; x++) {
				gameTiles.add(new Tile(i * cellWidth,x * cellHeight, cellWidth, cellHeight));
			}
		}
	}
	
	public synchronized ArrayList<Tile> getGameTiles() {
		synchronized(gameTiles) {
			return gameTiles;
		}
	}

}
