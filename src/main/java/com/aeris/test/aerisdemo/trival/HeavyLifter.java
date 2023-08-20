/* ---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.trival.HeavyLifter.java
 * Date:   2023/08/20
 * ---------------------------------------------------------------------------------------
 *
 * Copyright, (c) 2020 - Carda Technologies, LLC
 * All rights reserved.
 */

/*---------------------------------------------------------------------------------------
* Class:  com.aeris.test.aerisdemo.trival.HeavyLifter.java
* Date:   2023/08/20
* ---------------------------------------------------------------------------------------
 */
package com.aeris.test.aerisdemo.trival;

/**
 * Package:    com.aeris.test.aerisdemo.trival
 * Class:      HeavyLifter.java
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
public class HeavyLifter {

    /**
     * Method: getData
     *
     * @return String
     *
     * @param timeIndex
     *        The time index value
     * @param zIndex
     *        The Z-Index value.
     */
    public String getData( String timeIndex,
                           String zIndex ) {
        String returnStr;

        // Diagnostic:  Print out the values.
        System.out.println( "getData : timeIndex=" + timeIndex );
        System.out.println( "getData : zIndex=" + zIndex );

        // Return the results
        returnStr = "   HeavyLifter : getData";

        // Return the response
        return( returnStr );
    }

    /**
     * Method: getImage
     *
     * @param timeIndex
     *        The time index value
     * @param zIndex
     *        The Z-Index value.
     *
     * @return String

     */
    public String getImage(String timeIndex, String zIndex) {
        String returnStr;

        // Diagnostic:  Print out the values.
        System.out.println( "getData : timeIndex=" + timeIndex );
        System.out.println( "getData : zIndex=" + zIndex );

        // Return the results
        returnStr = "   HeavyLifter : getImage";

        // Return the response
        return( returnStr );
    }

    /**
     * Method: getInfo
     *
     * @return String
     */
    public String getInfo() {
        String returnStr;

        //
        returnStr = "   HeavyLifter : getInfo";

        // Return the response
        return( returnStr );
    }
}

/* ---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.trival.HeavyLifter.java
 * Date:   2023/08/20
 * --------------------------------------------------------------------------------------- */

