package com.volvic20.Volvic20.service;

import com.volvic20.Volvic20.models.Customer;
import com.volvic20.Volvic20.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlgorithmService {
    /**
     * Assigns available vehicles to awaiting customers based on closest distance
     * @param vehicles List of all vehicles
     * @param customers List of all customers
     * @return Map of vehicle IDs to assigned customer IDs
     */
    public Map<String, String> assignVehiclesToCustomers(List<Vehicle> vehicles, List<Customer> customers) {
        Map<String, String> assignments = new HashMap<>();

        // Filter for available vehicles and awaiting customers
        List<Vehicle> availableVehicles = vehicles.stream()
                .filter(Vehicle::isAvailable)
                .toList();

        List<Customer> awaitingCustomers = customers.stream()
                .filter(Customer::isAwaitingService)
                .toList();

        // For each vehicle, find the closest unassigned customer
        for (Vehicle vehicle : availableVehicles) {
            double shortestDistance = Double.MAX_VALUE;
            Customer closestCustomer = null;

            for (Customer customer : awaitingCustomers) {
                // Skip if customer is already assigned
                if (assignments.containsValue(customer.getId())) {
                    continue;
                }

                double distance = calculateDistance(
                        vehicle.getCoordX(),
                        vehicle.getCoordY(),
                        customer.getCoordX(),
                        customer.getCoordY()
                );

                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    closestCustomer = customer;
                }
            }

            // If we found a customer to assign
            if (closestCustomer != null) {
                assignments.put(vehicle.getId(), closestCustomer.getId());

                // Update entities
                vehicle.setAvailable(false);
                vehicle.setCustomerId(closestCustomer.getId());
                closestCustomer.setAwaitingService(false);
            }
        }

        return assignments;
    }

    /**
     * Calculates Manhattan distance between two points using float coordinates
     */
    private double calculateDistance(float x1, float y1, float x2, float y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}