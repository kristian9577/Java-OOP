import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

import java.lang.reflect.Field;

public class TireTests {

    @Test
    public void alarmIsOnWhenPressureIsOutOfLimit() throws NoSuchFieldException, IllegalAccessException {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(Double.valueOf(16));
        Alarm alarm = new Alarm(sensor);

        Field field = Alarm.class.getDeclaredField("sensor");
        field.setAccessible(true);
        field.set(alarm, sensor);


        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmIsOnWhenPressureIsGreaterThanUpper() {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(Double.valueOf(22));

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmIsOnWhenPressureIsBetweenTheLimits()  {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(Double.valueOf(19));

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}
