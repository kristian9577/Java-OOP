package commands;

public class CreateBoatEngine {

    private String model;
    private double horsePower;
    private double dicplacement;
    private String type;

    public CreateBoatEngine withModel(String model){
        this.model=model;

        return this;
    }
    public CreateBoatEngine withHorsePower(double horsePower){
        this.horsePower=horsePower;

        return this;
    }

}
