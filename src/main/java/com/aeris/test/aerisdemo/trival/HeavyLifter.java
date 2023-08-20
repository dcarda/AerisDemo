/*---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.trival.HeavyLifter.java
 * Date:   2023/08/20
 * ---------------------------------------------------------------------------------------
 */
package com.aeris.test.aerisdemo.trival;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

//~--- non-JDK imports --------------------------------------------------------

import ucar.nc2.NetcdfFile;
import ucar.nc2.NetcdfFiles;

/**
 * Package:    com.aeris.test.aerisdemo.trival
 * Class:      HeavyLifter.java
 * Desc:       ...
 *
 * @author     Daniel Carda
 *
 * Maintenance History:
 * <p><pre>
 *   yyyy mm dd  Who               Description
 *   ----------  ----------------  ----------------------------------------------------
 *   2023/08/20  JavaDan           Initial Module Creation...
 * </pre>
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
        String returnStr = null;

        // Diagnostic:  Print out the values.
        System.out.println( "getData : timeIndex=" + timeIndex );
        System.out.println( "getData : zIndex=" + zIndex );

        //
        try(NetcdfFile ncfile = NetcdfFiles.open( "/concentration.timeseries.nc" )) {

            returnStr = "{\n" +
                    "  \"X-Data\": \"22.44\",\n" +
                    "  \"Y-Data\": \"88.88888\",\n" +
                    "  \"CONC-data\": \"3.14\",\n" +
                    "}";
        }
        catch( IOException ioe ) {

            // Handle less-cool exceptions here
            // logger("Problem reading NetCDF file");
            System.out.println( "bad error" );
        }

        // Return the results
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
     *
     */
    public String getImage( String timeIndex,
                            String zIndex ) {
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
        String returnStr = null;

        //
        try(NetcdfFile ncfile = NetcdfFiles.open( "/concentration.timeseries.nc" )) {

            // Load up the return string
            returnStr = ncfile.getDetailInfo();
        }
        catch( IOException ioe ) {

            // Handle less-cool exceptions here
            // logger("Problem reading NetCDF file");
            System.out.println( "bad error" );
        }

        // Return the response
        return( returnStr );
    }
}

/* ---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.trival.HeavyLifter.java
 * Date:   2023/08/20
 * --------------------------------------------------------------------------------------- */


