package info.md7.graphhopperdemo.payload.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoutingResponse {

    VehicleDTO vehicle;
    List<RouteDTO> routes;
}
