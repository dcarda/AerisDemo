/*---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.controller.LandingPadController.java
 * Date:   2023/08/20
 * ---------------------------------------------------------------------------------------
 */
package com.aeris.test.aerisdemo.controller;

//~--- non-JDK imports --------------------------------------------------------

import org.springframework.web.bind.annotation.RequestMapping;
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
 * <p><pre>
 *  yyyy mm dd  Who               Description
 *  ----------  ----------------  ----------------------------------------------------
 *  2023/08/20  JavaDan           Initial Module Creation...
 * </pre>
 *
 */
@RestController
public class LandingPadController {

    /**
     * Method: serviceGetData
     *
     * @return String
     */
    @RequestMapping("/get-data")
    public String serviceGetData() {
        String      responseStr;
        HeavyLifter heavyLifter = new HeavyLifter();

        responseStr = heavyLifter.getData();

//      responseStr = " LandingPadController : get-data ";
        // Return
        return( responseStr );
    }

    /**
     * Method: serviceGetImage
     *
     * @return String
     */
    @RequestMapping("/get-image")
    public String serviceGetImage() {
        String      responseStr;
        HeavyLifter heavyLifter = new HeavyLifter();

        responseStr = heavyLifter.getImage();

//      responseStr = " LandingPadController : get-image ";
//      System.out.println( responseStr );
        // Return
        return( responseStr );
    }

    /**
     * Method: serviceGetInfo
     *
     * @return String
     */
    @RequestMapping("/get-info")
    public String serviceGetInfo() {
        String      responseStr;
        HeavyLifter heavyLifter = new HeavyLifter();

        responseStr = heavyLifter.getInfo();

//      responseStr = " LandingPadController : get-info ";
//      System.out.println( responseStr );
        // Return
        return( responseStr );
    }
}

/* ---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.controller.LandingPadController.java
 * Date:   2023/08/20
 * --------------------------------------------------------------------------------------- */
