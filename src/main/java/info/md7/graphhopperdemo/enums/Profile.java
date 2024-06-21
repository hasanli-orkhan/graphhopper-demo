package info.md7.graphhopperdemo.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Profile {

    CAR_FASTEST("car_fastest"),
    FOOT_SHORTEST("foot_shortest");

    final String value;
}
