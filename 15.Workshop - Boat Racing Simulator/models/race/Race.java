package models.race;

import models.boat.Boat;
import models.boat.MotorBoats;
import exceptions.ArgumentException;
import exceptions.DuplicateModelException;

import java.util.HashSet;
import java.util.Set;

public class Race {

    private double distance;
    private double windSpeed;
    private double currentSpeed;

    private Set<Boat> participants;
    private boolean allowMotorBoats;

    public Race(double distance, double windSpeed, double currentSpeed, boolean allowMotorBoats) {
        this.distance = distance;
        this.windSpeed = windSpeed;
        this.currentSpeed = currentSpeed;
        this.allowMotorBoats = allowMotorBoats;
        this.participants = new HashSet<>();
    }

    public void addParticipant(Boat newParticipant) throws DuplicateModelException, ArgumentException {
        if(!this.areMotorBoatsAllowed()&& newParticipant instanceof MotorBoats){
            throw new ArgumentException();
        }

        boolean added = this.participants.add(newParticipant);
        if(!added){
            throw  new DuplicateModelException();
        }
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Set<Boat> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Boat> participants) {
        this.participants = participants;
    }

    public boolean areMotorBoatsAllowed() {
        return allowMotorBoats;
    }

    public void setAllowMotorBoats(boolean allowMotorBoats) {
        this.allowMotorBoats = allowMotorBoats;
    }
}
