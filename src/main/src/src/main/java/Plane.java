public class Plane {

    private String make;
    private String model;
    private String number;
    private int maxAltitudeMeters;
    private int currentAltitudeMeters;
    private boolean landingGearEnabled;

    public Plane(String make, String model, String number,
                 int maxAltitudeMeters) {

        if (maxAltitudeMeters < 100) {
            throw new IllegalArgumentException(
                "Maximum altitude must be at least 100 meters."
            );
        }

        this.make = make;
        this.model = model;
        this.number = number;
        this.maxAltitudeMeters = maxAltitudeMeters;
        this.currentAltitudeMeters = 0;
        this.landingGearEnabled = true;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public int getMaxAltitudeMeters() {
        return maxAltitudeMeters;
    }

    public int getCurrentAltitudeMeters() {
        return currentAltitudeMeters;
    }

    public boolean getLandingGearEnabled() {
        return landingGearEnabled;
    }

    public boolean enableLandingGear() {
        if (currentAltitudeMeters > 100) {
            return false;
        }

        landingGearEnabled = true;
        return true;
    }

    public boolean disableLandingGear() {
        if (currentAltitudeMeters < 100) {
            return false;
        }

        landingGearEnabled = false;
        return true;
    }

    public boolean changeAltitude(int meters) {

        long requestedAltitude =
            (long) currentAltitudeMeters + meters;

        int minAllowed = landingGearEnabled ? 0 : 100;

        int maxAllowed = landingGearEnabled
            ? Math.min(100, maxAltitudeMeters)
            : maxAltitudeMeters;

        int newAltitude = (int) Math.max(
            minAllowed,
            Math.min(requestedAltitude, maxAllowed)
        );

        currentAltitudeMeters = newAltitude;

        return requestedAltitude == newAltitude;
    }
}
