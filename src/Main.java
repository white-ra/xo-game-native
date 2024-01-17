import core.DependencyInjectionContainer;
import core.ServiceLocator;

public class Main {
    public static void main(String[] args) {
        new DependencyInjectionContainer(new ServiceLocator()).initInstance();
    }
}