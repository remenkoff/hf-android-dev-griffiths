package net.remenkoff.bitsandpizzas;

public final class Pizza {

    // MARK: - Public Type Properties
    public static final Pizza[] pizzas = {
            new Pizza("Diavolo", R.drawable.diavolo),
            new Pizza("Funghi", R.drawable.funghi)
    };

    // MARK: - Public Instance Properties
    final String name;
    final int imageResID;

    // MARK: - Instantiation
    private Pizza(String name, int imageResID) {
        this.name = name;
        this.imageResID = imageResID;
    }

}
