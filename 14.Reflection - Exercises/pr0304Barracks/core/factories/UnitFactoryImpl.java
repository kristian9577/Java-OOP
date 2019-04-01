package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "pr0304Barracks.models.units.";

    @Override
    public Unit createUnit(String unitType)  {

        //TODO solve problem 3

        Unit unit = null;

        try {
            Class<? extends Unit> unitClass =
                    (Class<? extends Unit>) Class
                            .forName(UnitFactoryImpl.UNITS_PACKAGE_NAME + unitType);
            Constructor constructor = unitClass.getDeclaredConstructor();
            constructor.setAccessible(true);
           unit= (Unit) constructor.newInstance();
        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }

        return unit;
    }
}
