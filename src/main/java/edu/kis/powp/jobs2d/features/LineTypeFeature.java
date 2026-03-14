package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.events.SelectLineTypeOptionListener;

public class LineTypeFeature {
    public enum LineType {
        Basic,
        Dotted,
        Special,
    }

    private static LineType lineType;

    public static void setupLineTypePlugin(Application application) {
        SelectLineTypeOptionListener selectLineTypeOptionListener = new SelectLineTypeOptionListener();

        application.addComponentMenu(LineTypeFeature.class, "Line type", 1);
        application.addComponentMenuElement(LineTypeFeature.class, SelectLineTypeOptionListener.LineTypeBasic, selectLineTypeOptionListener);
        application.addComponentMenuElement(LineTypeFeature.class, SelectLineTypeOptionListener.LineTypeDotted, selectLineTypeOptionListener);
        application.addComponentMenuElement(LineTypeFeature.class, SelectLineTypeOptionListener.LineTypeSpecial, selectLineTypeOptionListener);
    }

    public static LineType getLineType() {
        return lineType;
    }

    public static void setLineType(LineType lineType) {
        LineTypeFeature.lineType = lineType;
    }
}
