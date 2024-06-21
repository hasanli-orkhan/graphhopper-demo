package info.md7.graphhopperdemo.controller;

import info.md7.graphhopperdemo.payload.request.RoutingRequest;
import info.md7.graphhopperdemo.payload.response.RouteDTO;
import info.md7.graphhopperdemo.service.RoutingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Endpoints for routing")
@RestController
@RequestMapping("/api/v1/routing")
@RequiredArgsConstructor
public class RoutingController {

    private final RoutingService routingService;

    @Operation(description = "Retrieve routes")
    @PostMapping
    public List<RouteDTO> getRoutes(@Valid @RequestBody RoutingRequest routingRequest) {
        return routingService.routing(routingRequest);
    }
}
