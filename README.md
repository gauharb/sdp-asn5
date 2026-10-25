# Assignment #5 - Strategy Pattern (Route Planning)

Java 17 implementation of the Strategy pattern. A `Navigator` plans a route
between two locations using an interchangeable travel-mode algorithm
(car, walk, cycle) that can be switched at runtime.

## Project structure

```
src/
  Main.java                    Client: picks and switches strategies
  context/Navigator.java       Context: delegates to the current strategy
  model/Location.java          A named point with latitude/longitude
  model/Route.java             Result of planning (mode, distance, duration)
  strategy/RouteStrategy.java  Strategy interface
  strategy/CarStrategy.java    Concrete strategy
  strategy/WalkStrategy.java   Concrete strategy
  strategy/CycleStrategy.java  Concrete strategy
docs/REPORT.md                 Report for Moodle
```

## How to build and run

### IntelliJ IDEA
1. Open the project folder, mark `src` as the Sources Root, and set the SDK to JDK 17.
2. Run `Main`.

### Command line
```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out Main
```

On Windows PowerShell:
```powershell
mkdir out -Force
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out Main
```

## How to add a new strategy

1. Create a class in `src/strategy/` that implements `RouteStrategy`, for example `BusStrategy`:

```java
package strategy;

import model.Location;
import model.Route;

public class BusStrategy implements RouteStrategy {
    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = from.distanceToKm(to) * 1.25;
        return new Route("Bus", from, to, distanceKm, distanceKm / 30.0 * 60);
    }
}
```

2. In the client code, use it: `navigator.setStrategy(new BusStrategy());`

No existing class (`Navigator`, `CarStrategy`, ...) needs to change.