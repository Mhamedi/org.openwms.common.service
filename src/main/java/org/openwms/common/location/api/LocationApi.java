/*
 * Copyright 2018 Heiko Scherrer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openwms.common.location.api;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * A LocationApi deals with {@code Location}s.
 *
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 */
@FeignClient(name = "common-service", qualifier = "locationApi", decode404 = true)
public interface LocationApi {

    /**
     * Find and return a {@code Location} representation by the given {@code locationPK}.
     *
     * @param locationPK The business key of the Location
     * @return Never {@literal null}
     * @throws IllegalArgumentException in case the given locationPK is not valid
     */
    @GetMapping(value = "/v1/locations", params = {"locationPK"})
    @Cacheable("locations")
    Optional<LocationVO> findLocationByCoordinate(@RequestParam("locationPK") String locationPK);

    /**
     * Find and return a {@code Location} representation by the given {@code plcCode}.
     *
     * @param plcCode The PLC code
     * @return Never {@literal null}
     */
    @GetMapping(value = "/v1/locations", params = {"plcCode"})
    @Cacheable("locations")
    Optional<LocationVO> findLocationByPlcCode(@RequestParam("plcCode") String plcCode);

    /**
     * Find and return all {@link LocationVO}s that belong to one or more
     * {@code LocationGroupVO}s identified by their {@code locationGroupNames}.
     *
     * @param locationGroupNames A list of LocationGroup names.
     * @return All Location instances or an empty list
     */
    @GetMapping(value = "/v1/locations", params = {"locationGroupNames"})
    @Cacheable("locations")
    List<LocationVO> findLocationsForLocationGroups(@RequestParam("locationGroupNames") List<String> locationGroupNames);

    /**
     * Update the state of a {@code Location} with the given {@code errorCode}.
     *
     * @param pKey The persistent key of the Location
     * @param errorCode The error code
     */
    @PatchMapping(value = "/v1/locations/{pKey}")
    @CacheEvict(cacheNames = "locations", allEntries = true)
    void updateState(@PathVariable(name = "pKey") String pKey, @RequestBody ErrorCodeVO errorCode);


    /**
     * Find and return all {@code Location}s that match the area/aisle/x/y/z criteria.
     *
     * @param area The Area to search for or '%'
     * @param aisle The Aisle to search for or '%'
     * @param x The X to search for or '%'
     * @param y The Y to search for or '%'
     * @param z The Z to search for or '%'
     * @return All Location instances or an empty list
     */
    @GetMapping(value = "/v1/locations", params = {"area", "aisle", "x", "y", "z"})
    List<LocationVO> findLocations(
            @RequestParam(value = "area", required = false) String area,
            @RequestParam(value = "aisle", required = false) String aisle,
            @RequestParam(value = "x", required = false) String x,
            @RequestParam(value = "y", required = false) String y,
            @RequestParam(value = "z", required = false) String z
    );
}
