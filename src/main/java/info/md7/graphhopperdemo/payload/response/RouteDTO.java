package info.md7.graphhopperdemo.payload.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteDTO {

    List<InstructionDTO> instructions = new ArrayList<>();
    List<String> description;
    double distance;
    double ascend;
    double descend;
    double routeWeight;
    long time;
    List<Integer> pointsOrder = new ArrayList<>();
}
