package info.md7.graphhopperdemo.mapper;

import com.graphhopper.util.Translation;
import info.md7.graphhopperdemo.payload.response.InstructionDTO;
import info.md7.graphhopperdemo.payload.response.PointDTO;
import info.md7.graphhopperdemo.payload.response.RouteDTO;

import java.util.List;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class CustomMapper {

    public InstructionDTO toInstructionDTO(
            com.graphhopper.util.Instruction instruction, Translation tr) {
        InstructionDTO instructionDto = new InstructionDTO();
        instructionDto.setDistance(instruction.getDistance()); // distance in meters
        instructionDto.setTime(instruction.getTime()); // time in millis
        instructionDto.setTurnDescription(instruction.getTurnDescription(tr));
        instructionDto.setName(instruction.getName());
        instructionDto.setSign(instruction.getSign());
        List<PointDTO> points = StreamSupport.stream(instruction.getPoints().spliterator(), false)
                .map(ghPoint3D -> new PointDTO(ghPoint3D.getLat(), ghPoint3D.getLon())).toList();
        instructionDto.setPoints(points);
        return instructionDto;
    }


    public RouteDTO toRouteDTO(
            com.graphhopper.ResponsePath responsePath, Translation tr) {
        RouteDTO path = new RouteDTO();
        path.setDescription(responsePath.getDescription());
        path.setDistance(responsePath.getDistance()); // distance in meters
        path.setAscend(responsePath.getAscend());
        path.setDescend(responsePath.getDescend());
        path.setRouteWeight(responsePath.getRouteWeight());
        path.setTime(responsePath.getTime()); // time in millis
        path.setPointsOrder(responsePath.getPointsOrder());
        List<InstructionDTO> instructions = responsePath.getInstructions().stream()
                .map(instruction -> toInstructionDTO(instruction, tr))
                .toList();
        path.setInstructions(instructions);
        return path;
    }
}
