package net.remenkoff.workout;

import androidx.annotation.NonNull;

final class Workout {

    // MARK: - Public Type Properties
    public static final Workout[] workouts = {
        new Workout(
            "The Limb Loosener",
            "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"
        ),
        new Workout(
            "Core Agony",
            "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"
        ),
        new Workout(
            "The Wimp Special",
            "5 Pull-ups\n10 Push-ups\n15 Squats"
        ),
        new Workout(
            "Strength and Length",
            "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups"
        )
    };

    // MARK: - Public Instance Properties
    public final String name;
    public final String desc;

    // MARK: - Instantiation
    private Workout(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    // MARK: - Super Overrides
    @Override
    public String toString() {
        return name;
    }

}
