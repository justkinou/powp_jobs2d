package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.features.LineTypeFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectLineTypeOptionListener implements ActionListener {
    public static final String LineTypeBasic = "Basic";
    public static final String LineTypeDotted = "Dotted";
    public static final String LineTypeSpecial= "Special";

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        LineTypeFeature.LineType lineType = switch (actionCommand) {
            case LineTypeBasic -> LineTypeFeature.LineType.Basic;
            case LineTypeDotted -> LineTypeFeature.LineType.Dotted;
            case LineTypeSpecial -> LineTypeFeature.LineType.Special;
            default -> throw new IllegalStateException("Unexpected value: " + actionCommand);
        };
        LineTypeFeature.setLineType(lineType);
    }
}
