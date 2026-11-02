
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlaneTest {

    @Test
    public void testConstructorAndGetters() {
        Plane plane = new Plane("Boeing", "747", "P101", 12000);

        assertEquals("Boeing", plane.getMake());
        assertEquals("747", plane.getModel());
        assertEquals("P101", plane.getNumber());
        assertEquals(12000, plane.getMaxAltitudeMeters());
        assertEquals(0, plane.getCurrentAltitudeMeters());
        assertTrue(plane.getLandingGearEnabled());
    }

    @Test
    public void testInvalidMaximumAltitude() {
        assertThrows(IllegalArgumentException.class, () ->
            new Plane("Boeing", "747", "P101", 50)
        );
    }

    @Test
    public void testEnableLandingGear() {
        Plane plane = new Plane("Boeing", "747", "P101", 12000);

        assertTrue(plane.enableLandingGear());
        plane.changeAltitude(100);
        assertTrue(plane.enableLandingGear());
    }

    @Test
    public void testCannotEnableGearAbove100() {
        Plane plane = new Plane("Boeing", "747", "P101", 12000);

        plane.changeAltitude(100);
        plane.disableLandingGear();
        plane.changeAltitude(1);

        assertFalse(plane.enableLandingGear());
        assertFalse(plane.getLandingGearEnabled());
    }

    @Test
    public void testDisableLandingGear() {
        Plane plane = new Plane("Boeing", "747", "P101", 12000);

        assertFalse(plane.disableLandingGear());
        plane.changeAltitude(100);

        assertTrue(plane.disableLandingGear());
        assertFalse(plane.getLandingGearEnabled());
    }

    @Test
    public void testChangeAltitudeWithGearEnabled() {
        Plane plane = new Plane("Boeing", "747", "P101", 12000);

        assertTrue(plane.changeAltitude(50));
        assertEquals(50, plane.getCurrentAltitudeMeters());

        assertFalse(plane.changeAltitude(100));
        assertEquals(100, plane.getCurrentAltitudeMeters());

        assertFalse(plane.changeAltitude(-150));
        assertEquals(0, plane.getCurrentAltitudeMeters());
    }

    @Test
    public void testChangeAltitudeWithGearDisabled() {
        Plane plane = new Plane("Boeing", "747", "P101", 12000);

        plane.changeAltitude(100);
        plane.disableLandingGear();

        assertTrue(plane.changeAltitude(500));
        assertEquals(600, plane.getCurrentAltitudeMeters());

        assertFalse(plane.changeAltitude(20000));
        assertEquals(12000, plane.getCurrentAltitudeMeters());

        assertFalse(plane.changeAltitude(-20000));
        assertEquals(100, plane.getCurrentAltitudeMeters());
    }

    @Test
    public void testZeroAltitudeChange() {
        Plane plane = new Plane("Boeing", "747", "P101", 12000);

        assertTrue(plane.changeAltitude(0));
        assertEquals(0, plane.getCurrentAltitudeMeters());
    }
}
