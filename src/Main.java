import context.Navigator;
import model.Location;
import model.Route;
import strategy.CarStrategy;
import strategy.CycleStrategy;
import strategy.RouteStrategy;
import strategy.WalkStrategy;


public class Main {

    public static void main(String[] args) {
        Location start = new Location("Astana IT University", 51.0900, 71.4180);
        Location finish = new Location("Khan Shatyr", 51.1325, 71.4045);

        Navigator navigator = new Navigator(new CarStrategy());
        System.out.println("Initial strategy: car");
        System.out.println(navigator.planRoute(start, finish));

        System.out.println("\nSwitching to walking at runtime...");
        navigator.setStrategy(new WalkStrategy());
        System.out.println(navigator.planRoute(start, finish));

        System.out.println("\nSwitching to cycling at runtime...");
        navigator.setStrategy(new CycleStrategy());
        System.out.println(navigator.planRoute(start, finish));

        System.out.println("\nAdding a new strategy (e-scooter) without modifying existing classes...");
        RouteStrategy scooter = (from, to) -> {
            double distanceKm = from.distanceToKm(to) * 1.15;
            return new Route("E-scooter", from, to, distanceKm, distanceKm / 20.0 * 60);
        };
        navigator.setStrategy(scooter);
        System.out.println(navigator.planRoute(start, finish));
    }
}
