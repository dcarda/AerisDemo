
![alt text](https://www.aeris.com/wp-content/uploads/2022/01/aeris-logo.svg)

# AerisDemo
This is the code for the Aeris test.

This demonistrates how I like to put applications together.  

Due to my unfamiliarity with NetCDF, and I think my machine is starting to overheat, I was not able to complete items b) and c).

In any case, I think this should give you an indication of the type of code I can write.

Thank you,
Daniel Carda


## Before you run

In the buildIt.sh, you are going to have to modify lines 54, and 419.  These reflect my local Docker repo and 
you're going to have to make them reflect yours.

If you're running from a command line you'll need to update and source the ./setEnv.sh.  This is how I set my environment 
parameters.

##  Running

In a perfect world, you should just be able to run:

    ./buildIt.sh

It should build and launch the Docker container.  Keep an eye on the output, I dump a lot of diagnostic information.  :-)

The URL's youre interested in would be:

    http://localhost:8080/get-data?timeIndex=DATA1&zIndex=DATA2
    http://localhost:8080/get-image?timeIndex=DATA1&zIndex=DATA2
    http://localhost:8080/get-info


## BuildIt.sh

buildIt.sh is a utility program I use to automate tasks.  If you want to see the functions available then at the command prompt:

    ./buildIt.sh help

You should see this output.

Task Selection

     buildIt.sh                <-- Build And Run Docker container<default>

     buildIt.sh  clean         <-- Deep Clean All Artifacts
     buildIt.sh  resolve       <-- Will try and resolve Maven dependencies
     buildIt.sh  tree          <-- Displays a Maven dependency tree
     buildIt.sh  info          <-- Show information about the artifact
     buildIt.sh  launch        <-- Launch the NetCDF viewer

## Conclusion

This was fun!  Contact me if you have any questions!


