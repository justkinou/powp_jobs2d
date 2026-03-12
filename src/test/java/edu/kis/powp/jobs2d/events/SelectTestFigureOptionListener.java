package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {
	public static final String TestFigure1 = "Figure Joe 1";
	public static final String TestFigure2 = "Figure Joe 2";

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
		String actionCommand = e.getActionCommand();
		FigureScript figureScript = switch (actionCommand) {
			case TestFigure1 -> FiguresJoe::figureScript1;
			case TestFigure2 -> FiguresJoe::figureScript2;
            default -> throw new IllegalStateException("Unexpected value: " + actionCommand);
        };
		figureScript.figureScript(driverManager.getCurrentDriver());
	}
}
