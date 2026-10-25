package strategy;

import model.Location;
import model.Route;

public class CarStrategy implements RouteStrategy {

    private static final String MODE = "Car";
    private static final double ROAD_DETOUR_FACTOR = 1.30;
    private static final double AVERAGE_SPEED_KMH = 50.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = from.distanceToKm(to) * ROAD_DETOUR_FACTOR;
        double durationMinutes = distanceKm / AVERAGE_SPEED_KMH * 60;
        return new Route(MODE, from, to, distanceKm, durationMinutes);
    }
}
