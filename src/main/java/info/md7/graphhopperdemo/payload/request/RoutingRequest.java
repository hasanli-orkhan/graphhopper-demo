package info.md7.graphhopperdemo.payload.request;

import info.md7.graphhopperdemo.enums.Profile;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import info.md7.graphhopperdemo.validator.ValueOfEnum;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoutingRequest {

    @Schema(title = "List of coordinates", required = true)
    @Size(min = 2)
    @NotEmpty(message = "Coordinates cannot be null or empty")
    List<@Valid CoordinateDTO> coordinates;

    @Schema(title = "Profile for routing.", required = true)
    @ValueOfEnum(enumClass = Profile.class)
    String profile = "CAR_FASTEST";

    @Schema(title = "Get only best path or all paths (if exists)")
    boolean bestPathEnabled = true;
}
