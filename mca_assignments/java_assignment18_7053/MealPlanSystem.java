interface MealPlan { }

class VegetarianMeal implements MealPlan {
    public String toString() { return "Vegetarian Meal"; }
}

class VeganMeal implements MealPlan {
    public String toString() { return "Vegan Meal"; }
}

class KetoMeal implements MealPlan {
    public String toString() { return "Keto Meal"; }
}

class HighProteinMeal implements MealPlan {
    public String toString() { return "High-Protein Meal"; }
}

class Meal<T extends MealPlan> {
    private T meal;

    Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() { return meal; }
    public String toString() { return meal.toString(); }
}

class MealGenerator {
    public static <T extends MealPlan> Meal<T> generateMeal(T plan) {
        return new Meal<>(plan);
    }
}

public class MealPlanSystem {
    public static void main(String[] args) {
        Meal<VegetarianMeal> veg = MealGenerator.generateMeal(new VegetarianMeal());
        Meal<VeganMeal> vegan = MealGenerator.generateMeal(new VeganMeal());
        Meal<KetoMeal> keto = MealGenerator.generateMeal(new KetoMeal());
        Meal<HighProteinMeal> highP = MealGenerator.generateMeal(new HighProteinMeal());

        System.out.println(veg);
        System.out.println(vegan);
        System.out.println(keto);
        System.out.println(highP);
    }
}
