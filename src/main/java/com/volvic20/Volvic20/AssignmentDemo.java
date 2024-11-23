package com.volvic20.Volvic20;

import com.volvic20.Volvic20.models.Customer;
import com.volvic20.Volvic20.models.Vehicle;
import com.volvic20.Volvic20.service.AlgorithmService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AssignmentDemo {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        Random random = new Random(42); // Using seed for reproducible results

        // Create 25 vehicles with random coordinates between 0 and 50
        for (int i = 1; i <= 25; i++) {
            float x = random.nextFloat() * 50;
            float y = random.nextFloat() * 50;
            vehicles.add(new Vehicle("v" + i, x, y, null));
        }

        // Create 25 customers with random coordinates between 0 and 50
        for (int i = 1; i <= 25; i++) {
            float x = random.nextFloat() * 50;
            float y = random.nextFloat() * 50;
            customers.add(new Customer("c" + i, x, y));
        }

        // Create and use the assignment service
        AlgorithmService service = new AlgorithmService();
        Map<String, String> assignments = service.assignVehiclesToCustomers(vehicles, customers);

        // Print initial state
        System.out.println("Initial State:");
        System.out.println("\nVehicles:");
        for (Vehicle v : vehicles) {
            System.out.printf("Vehicle %s at (%.2f,%.2f)%n",
                    v.getId(), v.getCoordX(), v.getCoordY());
        }

        System.out.println("\nCustomers:");
        for (Customer c : customers) {
            System.out.printf("Customer %s at (%.2f,%.2f)%n",
                    c.getId(), c.getCoordX(), c.getCoordY());
        }

        // Print assignments with distances
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
                System.out.printf("Vehicle %s (%.2f,%.2f) -> Customer %s (%.2f,%.2f) | Distance: %.2f%n",
                        v.getId(), v.getCoordX(), v.getCoordY(),
                        c.getId(), c.getCoordX(), c.getCoordY(),
                        distance);
            }
        }

        // Calculate and print statistics
        double totalDistance = assignments.entrySet().stream()
                .mapToDouble(assignment -> {
                    Vehicle v = vehicles.stream()
                            .filter(vehicle -> vehicle.getId().equals(assignment.getKey()))
                            .findFirst()
                            .orElse(null);
                    Customer c = customers.stream()
                            .filter(customer -> customer.getId().equals(assignment.getValue()))
                            .findFirst()
                            .orElse(null);
                    if (v != null && c != null) {
                        return Math.abs(v.getCoordX() - c.getCoordX()) +
                                Math.abs(v.getCoordY() - c.getCoordY());
                    }
                    return 0.0;
                })
                .sum();

        System.out.println("\nStatistics:");
        System.out.printf("Total assignments made: %d%n", assignments.size());
        System.out.printf("Average distance per assignment: %.2f%n", totalDistance / assignments.size());
        System.out.printf("Total cumulative distance: %.2f%n", totalDistance);

        // Print unassigned customers if any
        List<Customer> unassignedCustomers = customers.stream()
                .filter(Customer::isAwaitingService)
                .toList();

        if (!unassignedCustomers.isEmpty()) {
            System.out.println("\nUnassigned Customers:");
            for (Customer c : unassignedCustomers) {
                System.out.printf("Customer %s at (%.2f,%.2f)%n",
                        c.getId(), c.getCoordX(), c.getCoordY());
            }
        }
    }

}