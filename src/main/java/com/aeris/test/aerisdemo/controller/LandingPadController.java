/* ---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.controller.LandingPadController.java
 * Date:   2023/08/20
 * ---------------------------------------------------------------------------------------
 */

package com.aeris.test.aerisdemo.controller;

//~--- non-JDK imports --------------------------------------------------------

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @return String
     */
    @RequestMapping("/get-data")
    public String serviceGetData() {
        String responseStr;

        responseStr = " LandingPadController : get-data ";

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
        String responseStr;

        responseStr = " LandingPadController : get-image ";
        System.out.println( responseStr );

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
        String responseStr;

        responseStr = " LandingPadController : get-info ";
        System.out.println( responseStr );

        // Return
        return( responseStr );
    }
}

/* ---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.controller.LandingPadController.java
 * Date:   2023/08/20
 * --------------------------------------------------------------------------------------- */
