package strategy;

public class Navigation {

    private RouteStrategy routeStrategy;

    public Navigation(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public RouteStrategy getRouteStrategy() {
        return routeStrategy;
    }

}
