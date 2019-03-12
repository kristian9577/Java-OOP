package MordorCrueltyPlan;

public class Gandalf {
    private int foodPoints;

    public Gandalf() {
    }

    public void eatFood(String food) {
        switch (food.toLowerCase()) {
            case "cram":
                foodPoints += 2;
                break;
            case "lembas":
                foodPoints += 3;
                break;
            case "apple":
                foodPoints += 1;
                break;
            case "melon":
                foodPoints += 1;
                break;
            case "honeycake":
                foodPoints += 5;
                break;
            case "mushrooms":
                foodPoints -= 10;
                break;
            default:
                foodPoints -= 1;
                break;
        }
    }

    public int getFoodPoints() {
        return this.foodPoints;
    }

    public String getMood() {
        if (this.foodPoints < -5) {
            return "Angry";
        } else if (this.foodPoints < 0) {
            return "Sad";
        } else if (this.foodPoints < 15) {
            return "Happy";
        } else {
            return "JavaScript";
        }
    }
}
