/* ---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.AerisdemoApplication.java
 * Date:   2023/08/20
 * ---------------------------------------------------------------------------------------
 *
 */

package com.aeris.test.aerisdemo;

//~--- non-JDK imports --------------------------------------------------------
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Package:    com.aeris.test.aerisdemo
 * Class:      AerisdemoApplication.java
 * Desc:       ...
 *
 * @author     Daniel Carda
 *
 * Maintenance History:
 * <p><pre>
 * yyyy mm dd  Who               Description
 * ----------  ----------------  ----------------------------------------------------
 * 2023/08/20  JavaDan           Initial Module Creation...
 * </pre>
 *
 */
@SpringBootApplication
public class AerisdemoApplication {

    private static final Logger logger = LoggerFactory.getLogger( AerisdemoApplication.class );

    /**
     * Method: main
     *
     * @param args
     *         Param Desc...
     */
    public static void main( String[] args ) {
        logger.debug( "AerisdemoApplication - Starting Application" );
        SpringApplication.run( AerisdemoApplication.class, args );
    }
}

/* ---------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------
 * Class:  com.aeris.test.aerisdemo.AerisdemoApplication.java
 * Date:   2023/08/20
 * --------------------------------------------------------------------------------------- */
