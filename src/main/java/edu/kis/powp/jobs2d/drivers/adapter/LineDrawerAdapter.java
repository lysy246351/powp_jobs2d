package edu.kis.powp.jobs2d.drivers.adapter;

import javax.swing.JPanel;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter implements Job2dDriver{
    private int startX = 0, startY = 0;
	private  DrawPanelController drawPanelController;
	private Line line;

	public enum Line {
		BASIC,
		DOTTED,
		SPECIAL
	}
	
	public LineDrawerAdapter(Line line) {
		this.drawPanelController = DrawerFeature.getDrawerController();
		this.line = line;
	}

    @Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	private ILine getLine(Line line){
		switch(line){
			case BASIC:
				return LineFactory.getBasicLine();
			case DOTTED:
				return LineFactory.getDottedLine();
			case SPECIAL:
				return LineFactory.getSpecialLine();
			default:
				return LineFactory.getBasicLine();
		}
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = getLine(this.line);
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);
		this.drawPanelController.drawLine(line);
		this.setPosition(x, y);
	}

	@Override
	public String toString() {
		return "Line Drawer Adapter";
	}
}
