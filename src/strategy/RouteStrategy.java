package strategy;

import model.Location;
import model.Route;

public interface RouteStrategy {

    Route buildRoute(Location from, Location to);
}
