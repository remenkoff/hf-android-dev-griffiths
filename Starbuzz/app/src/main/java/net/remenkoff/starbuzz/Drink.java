package net.remenkoff.starbuzz;

final class Drink {

    // MARK: - Public Type Interface
    static final Drink[] drinks = {
        new Drink(
                "Latte",
                "A couple of espresso shots with steamed milk",
                R.drawable.latte
        ),
        new Drink(
                "Cappuccino",
                "Espresso, hot milk, and a steamed milk foam",
                R.drawable.cappuccino
        ),
        new Drink(
                "Filter",
                "Highest quality beans roasted and brewed fresh",
                R.drawable.filter
        )
    };

    // MARK: - Public Instance Interface
    final String name;
    final String desc;
    final int imageResourceId;

    // MARK: - Instantiation
    private Drink(String name, String desc, int imageResourceId) {
        this.name = name;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
    }

    // MARK: - Super Overrides
    @Override
    public String toString() {
        return name;
    }
}
