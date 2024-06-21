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
public class InstructionDTO {

    String turnDescription;
    double distance;
    long time;
    int sign;
    String name;
    List<PointDTO> points = new ArrayList<>();
}
