package strategy;

import model.Location;
import model.Route;

public class CycleStrategy implements RouteStrategy {

    private static final String MODE = "Cycle";
    private static final double BIKE_LANE_DETOUR_FACTOR = 1.15;
    private static final double AVERAGE_SPEED_KMH = 15.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = from.distanceToKm(to) * BIKE_LANE_DETOUR_FACTOR;
        double durationMinutes = distanceKm / AVERAGE_SPEED_KMH * 60;
        return new Route(MODE, from, to, distanceKm, durationMinutes);
    }
}
