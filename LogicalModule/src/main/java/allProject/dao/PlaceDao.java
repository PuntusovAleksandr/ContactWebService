package allProject.dao;

import allProject.entity.Place;

import java.util.Set;

/**
 * Created by Aleksandr on 26.03.2015.
 */
public interface PlaceDao {
    void addPlace(Place place);
    void deletePlace(Place place);
    Set<Place> getAllPlace();
}
