package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;

public class SelectFigureJaneOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectFigureJaneOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractDriverAdapter driver = new AbstractDriverAdapter(driverManager.getCurrentDriver());
		FiguresJane.figureScript(driver);
	}
}
