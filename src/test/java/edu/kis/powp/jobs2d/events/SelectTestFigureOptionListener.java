package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {
	@FunctionalInterface
	private interface FigureScript {
		void figureScript(Job2dDriver driver);
	}

	private final DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FigureScript figureScript = switch (e.getActionCommand()) {
			case "Figure Joe 1" -> FiguresJoe::figureScript1;
			case "Figure Joe 2" -> FiguresJoe::figureScript2;
            default -> throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        };
		figureScript.figureScript(driverManager.getCurrentDriver());
	}
}
