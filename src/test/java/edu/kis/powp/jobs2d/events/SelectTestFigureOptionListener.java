package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.DriverToAbstractDroverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {
	public static final String TestFigureJoe1 = "Figure Joe 1";
	public static final String TestFigureJoe2 = "Figure Joe 2";
	public static final String TestFigureJane = "Figure Jane";

	private final DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Job2dDriver driver = driverManager.getCurrentDriver();
		String actionCommand = e.getActionCommand();
		switch (actionCommand) {
			case TestFigureJoe1 -> {
				FiguresJoe.figureScript1(driver);
			}
			case TestFigureJoe2 -> {
				FiguresJoe.figureScript2(driver);
			}
			case TestFigureJane -> {
				FiguresJane.figureScript(new DriverToAbstractDroverAdapter(driver));
			}
            default -> throw new IllegalStateException("Unexpected value: " + actionCommand);
        };
	}
}
