/*---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.controller.LandingPadController.java
 * Date:   2023/08/20
 * ---------------------------------------------------------------------------------------
 */
package com.aeris.test.aerisdemo.controller;

//~--- non-JDK imports --------------------------------------------------------

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aeris.test.aerisdemo.trival.HeavyLifter;

/**
 * Package:    com.aeris.test.aerisdemo.controller
 * Class:      LandingPadController.java
 * Desc:       ...
 *
 * @author     Daniel Carda
 *
 * Maintenance History:
  <p><pre>
   yyyy mm dd  Who               Description
   ----------  ----------------  ----------------------------------------------------
   2023/08/20  JavaDan           Initial Module Creation...
  </pre>
 *
 */
@RestController
public class LandingPadController {

    /**
     * Method: serviceGetData
     *
     * /get-data, params to include time index and z index, returns json response that
     * includes x, y, and concentration data.
     *
     * @param timeIndex
     *        The time index value
     * @param zIndex
     *        The Z-Index value.
     *
     * @return String
     */
    @RequestMapping("/get-data")
    public String serviceGetData( @RequestParam("timeIndex") String timeIndex,
                                  @RequestParam("zIndex") String    zIndex ) {
        String      responseStr;
        HeavyLifter heavyLifter = new HeavyLifter();

        // Get the response from the class which does all the heavy lifting.
        responseStr = heavyLifter.getData( timeIndex, zIndex );

        // Return the results
        return( responseStr );
    }

    /**
     * Method: serviceGetImage
     *
     *
     * /get-image, params to include time index and z index, returns png visualization of
     * concentration.
     *
     * @param timeIndex
     *        The time index value
     * @param zIndex
     *        The Z-Index value.
     *
     * @return String
     */
    @RequestMapping("/get-image")
    public String serviceGetImage( @RequestParam("timeIndex") String timeIndex,
                                   @RequestParam("zIndex") String    zIndex ) {
        String      responseStr;
        HeavyLifter heavyLifter = new HeavyLifter();

        // Get the response from the class which does all the heavy lifting.
        responseStr = heavyLifter.getImage(timeIndex, zIndex);

        // Return the results
        return( responseStr );
    }

    /**
     * Method: serviceGetInfo
     *
     *
     * get-info, returns the NetCDF detailed information.
     *  @param timeIndex
     *         Param Desc...
     *  @param zIndex
     *         Param Desc...
     * @return String
     */
    @RequestMapping("/get-info")
    public String serviceGetInfo() {
        String      responseStr;
        HeavyLifter heavyLifter = new HeavyLifter();

        // Get the response from the class which does all the heavy lifting.
        responseStr = heavyLifter.getInfo();

        // Return the results
        return( responseStr );
    }
}

/* ---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.controller.LandingPadController.java
 * Date:   2023/08/20
 * --------------------------------------------------------------------------------------- */
