package net.remenkoff.beeradviser;

import java.util.ArrayList;
import java.util.List;

final class BeerExpert {

    // MARK: - Public Instance Interface

    // Method requires refactoring because of l10n (see `values-ru` resource).
    List<String> getBrands(String beerColor) {

        List<String> brands = new ArrayList<>();

        switch (beerColor.toLowerCase()) {
            case "light":
                brands.add("Krušovice");
                brands.add("Miller Genuine Draft");
                break;

            case "amber":
                brands.add("Jack Amber");
                brands.add("Red Moose");
                break;

            case "brown":
                brands.add("Manns Brown Ale");
                brands.add("Newcastle Brown Ale");
                break;

            case "dark":
                brands.add("Guinness");
                brands.add("Marston's Oyster Stout");
                break;

            default:
                brands.add("Unknown beer color provided...");
        }

        return brands;
    }

}
