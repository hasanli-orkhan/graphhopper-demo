package info.md7.graphhopperdemo.config;

import com.graphhopper.GraphHopper;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;
import com.graphhopper.util.CustomModel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class GraphHopperConfig {

    private final GhProperties ghProperties;

    @Bean
    public GraphHopper graphHopper() {
        GraphHopper hopper = new GraphHopper();
        hopper.setOSMFile(ghProperties.getMapPath());
        hopper.setGraphHopperLocation(ghProperties.getCachePath());
        hopper.setProfiles(List.of(
                new Profile("car_fastest").setVehicle("car").setWeighting("custom").setTurnCosts(true).setCustomModel(new CustomModel()),
                new Profile("foot_fastest").setVehicle("foot").setWeighting("custom").setTurnCosts(false)
        ));
        hopper.getCHPreparationHandler().setCHProfiles(List.of(
                new CHProfile("car_fastest"),
                new CHProfile("foot_fastest")
        ));
        hopper.setEncodedValuesString("max_weight,max_height,max_width");
        hopper.setStoreOnFlush(true);
        hopper.importOrLoad();

        return hopper;
    }
}
