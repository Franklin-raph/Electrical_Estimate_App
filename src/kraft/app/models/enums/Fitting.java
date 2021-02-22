package kraft.app.models.enums;

public enum Fitting {
    WALL_BRACKET(Box.Y_WAY_BOX),
    CEILING_LIGHT(Box.FOUR_WAY_BOX),
    FAN(Box.FOUR_WAY_BOX),
    AC_POINT(Box.Y_WAY_BOX),
    AC_SWITCH(Box.FOUR_WAY_BOX),
    REGULATOR(Box.KNOCKOUT_BOX_3X3),
    SWITCH(Box.KNOCKOUT_BOX_3X3),
    SOCKET(Box.KNOCKOUT_BOX_3X3),
    DOUBLE_GANG_SOCKET(Box.KNOCKOUT_BOX_3X6),
    COOKER_UNIT(Box.KNOCKOUT_BOX_3X6),
    TV_POINT(Box.KNOCKOUT_BOX_3X3),
    WATER_HEATER_POINT(Box.Y_WAY_BOX),
    WATER_HEATER_SWITCH(Box.KNOCKOUT_BOX_3X3);

    public Box box;
    Fitting(Box box) {
        this.box = box;
    }
}
