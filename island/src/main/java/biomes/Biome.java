package biomes;

import meshcomponents.MyPolygon;

public abstract class Biome {
    double minimumElevation;
    double maximumElevation;

    double minimumHumidity;
    double maximumHumidity;

    double minimumSoilAbsorptionLevel;
    double maximumSoilAbsorptionLevel;


    public double getMinimumElevation() {
        return this.minimumElevation;
    }

    public double getMaximumElevation() {
        return this.maximumElevation;
    }

    public double getMinimumHumidity() {
        return this.minimumHumidity;
    }

    public double getMaximumHumidity() {
        return this.maximumHumidity;
    }

    public double getMinimumSoilAbsorptionLevel() {
        return this.minimumSoilAbsorptionLevel;
    }

    public double getMaximumSoilAbsorptionLevel() {
        return this.maximumSoilAbsorptionLevel;
    }
}
