package info.md7.graphhopperdemo.service;

import com.graphhopper.GHRequest;
import info.md7.graphhopperdemo.payload.request.RoutingRequest;
import info.md7.graphhopperdemo.payload.response.RouteDTO;

import java.util.List;

public interface RoutingService {

    List<RouteDTO> routing(RoutingRequest routingRequest);

    List<RouteDTO> getRoutesFromGraphhopper(GHRequest ghRequest, boolean bestPath);
}
