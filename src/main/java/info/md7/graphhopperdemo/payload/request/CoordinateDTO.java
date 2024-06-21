package info.md7.graphhopperdemo.payload.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Schema(title = "Coordinates")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoordinateDTO {

    @Schema(title = "Latitude", required = true)
    @NotNull(message = "Latitude cannot be empty")
    Double latitude;

    @Schema(title = "Longitude", required = true)
    @NotNull(message = "Longitude cannot be empty")
    Double longitude;

}
