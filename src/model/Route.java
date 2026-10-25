package model;

public record Route(String travelMode, Location from, Location to,
                    double distanceKm, double durationMinutes) {

    @Override
    public String toString() {
        return String.format("[%s] %s -> %s: %.1f km, about %.0f min",
                travelMode, from.name(), to.name(), distanceKm, durationMinutes);
    }
}