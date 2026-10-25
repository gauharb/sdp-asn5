package strategy;

import model.Location;
import model.Route;

public class WalkStrategy implements RouteStrategy {

    private static final String MODE = "Walk";
    private static final double PATH_DETOUR_FACTOR = 1.10;
    private static final double AVERAGE_SPEED_KMH = 5.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = from.distanceToKm(to) * PATH_DETOUR_FACTOR;
        double durationMinutes = distanceKm / AVERAGE_SPEED_KMH * 60;
        return new Route(MODE, from, to, distanceKm, durationMinutes);
    }
}