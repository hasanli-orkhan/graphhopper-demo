package info.md7.graphhopperdemo.service.impl;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import com.graphhopper.util.Translation;
import com.graphhopper.util.shapes.GHPoint;
import info.md7.graphhopperdemo.mapper.CustomMapper;
import info.md7.graphhopperdemo.payload.request.RoutingRequest;
import info.md7.graphhopperdemo.payload.response.RouteDTO;
import info.md7.graphhopperdemo.service.RoutingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoutingServiceImpl implements RoutingService {

    private final GraphHopper graphHopper;
    private final CustomMapper customMapper;

    @Override
    public List<RouteDTO> routing(RoutingRequest routingRequest) {
        GHRequest ghRequest = new GHRequest();
        ghRequest.setLocale("us");
        ghRequest.setProfile(routingRequest.getProfile().toLowerCase());
        routingRequest.getCoordinates().forEach(coordinate -> ghRequest.addPoint(new GHPoint(coordinate.getLatitude(), coordinate.getLongitude())));
        return getRoutesFromGraphhopper(ghRequest, routingRequest.isBestPathEnabled());
    }


    @Override
    public List<RouteDTO> getRoutesFromGraphhopper(GHRequest ghRequest, boolean bestPath) {
        GHResponse response = graphHopper.route(ghRequest);
        if (response.hasErrors()) {
            final String exceptionMessage = response.getErrors().toString();
            log.error(exceptionMessage);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exceptionMessage);
        }
        if (bestPath) {
            ResponsePath path = response.getBest();
            Translation translation = graphHopper.getTranslationMap().getWithFallBack(ghRequest.getLocale());
            return List.of(customMapper.toRouteDTO(path, translation));
        } else {
            List<ResponsePath> paths = response.getAll();
            Translation translation = graphHopper.getTranslationMap().getWithFallBack(ghRequest.getLocale());
            return paths.stream().map(path -> customMapper.toRouteDTO(path, translation)).toList();
        }
    }

}
