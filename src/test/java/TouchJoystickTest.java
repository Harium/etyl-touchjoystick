import com.harium.etyl.commons.event.MouseEvent;
import com.harium.etyl.commons.event.PointerEvent;
import com.harium.etyl.commons.event.PointerState;
import com.harium.etyl.input.touch.TouchJoystick;
import org.junit.Assert;
import org.junit.Test;

public class TouchJoystickTest {

    @Test
    public void testInitialSetup() {
        TouchJoystick joystick = new TouchJoystick(20,20, 20);
        Assert.assertEquals(0, joystick.getAngle(), 0);
        Assert.assertFalse(joystick.isActive());
    }

    @Test
    public void testUpdate() {
        int x = 20;
        int y = 20;
        int radius = 20;

        TouchJoystick joystick = new TouchJoystick(x, y, radius);
        joystick.updateMouse(new PointerEvent(MouseEvent.MOUSE_BUTTON_LEFT, PointerState.PRESSED, x+radius, y+radius));
        Assert.assertTrue(joystick.isActive());

        joystick.updateMouse(new PointerEvent(MouseEvent.MOUSE_BUTTON_LEFT, PointerState.PRESSED, 20, 40));
        Assert.assertEquals(180, joystick.getAngle(), 0);
    }

}
