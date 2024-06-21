package info.md7.graphhopperdemo.payload.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VehicleDTO {

    String vehicleId;
    String vehicleType;
    String driverId;
}
