package com.volvic20.Volvic20;

import com.volvic20.Volvic20.models.Customer;
import com.volvic20.Volvic20.models.Vehicle;
import com.volvic20.Volvic20.service.AlgorithmService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssignmentDemo {
    public static void main(String[] args) {
        // Create some test vehicles with float coordinates
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("v1", 0.0f, 0.0f, null));    // vehicle at (0.0,0.0)
        vehicles.add(new Vehicle("v2", 10.5f, 10.5f, null));  // vehicle at (10.5,10.5)
        vehicles.add(new Vehicle("v3", 5.5f, 5.5f, null));    // vehicle at (5.5,5.5)

        // Create some test customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("c1", 1.5f, 1.5f));      // customer near (0,0)
        customers.add(new Customer("c2", 8.5f, 8.5f));      // customer near (10.5,10.5)
        customers.add(new Customer("c3", 15.5f, 15.5f));    // customer far from others

        // Create and use the assignment service
        AlgorithmService service = new AlgorithmService();
        Map<String, String> assignments = service.assignVehiclesToCustomers(vehicles, customers);

        // Print initial state
        System.out.println("Initial State:");
        System.out.println("Vehicles:");
        for (Vehicle v : vehicles) {
            System.out.printf("Vehicle %s at (%.1f,%.1f)%n",
                    v.getId(), v.getCoordX(), v.getCoordY());
        }

        System.out.println("\nCustomers:");
        for (Customer c : customers) {
            System.out.printf("Customer %s at (%.1f,%.1f)%n",
                    c.getId(), c.getCoordX(), c.getCoordY());
        }

        // Print assignments
        System.out.println("\nAssignments:");
        for (Map.Entry<String, String> assignment : assignments.entrySet()) {
            Vehicle v = vehicles.stream()
                    .filter(vehicle -> vehicle.getId().equals(assignment.getKey()))
                    .findFirst()
                    .orElse(null);

            Customer c = customers.stream()
                    .filter(customer -> customer.getId().equals(assignment.getValue()))
                    .findFirst()
                    .orElse(null);

            if (v != null && c != null) {
                double distance = Math.abs(v.getCoordX() - c.getCoordX()) +
                        Math.abs(v.getCoordY() - c.getCoordY());
                System.out.printf("Vehicle %s at (%.1f,%.1f) assigned to Customer %s at (%.1f,%.1f) - Distance: %.1f%n",
                        v.getId(), v.getCoordX(), v.getCoordY(),
                        c.getId(), c.getCoordX(), c.getCoordY(),
                        distance);
            }
        }

        // Print final state
        System.out.println("\nFinal State:");
        System.out.println("Vehicles available:");
        for (Vehicle v : vehicles) {
            System.out.printf("Vehicle %s: available=%s, customerId=%s%n",
                    v.getId(), v.isAvailable(), v.getCustomerId());
        }

        System.out.println("\nCustomers awaiting service:");
        for (Customer c : customers) {
            System.out.printf("Customer %s: awaitingService=%s%n",
                    c.getId(), c.isAwaitingService());
        }
    }
}