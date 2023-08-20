#!/bin/bash
set -euo pipefail
IFS=$'\n\t'
echo -ne "\e]0;      ?   Ares Demo Application Build   ?\a"

clear
#================================================================
#
#          FILE:  buildIt.sh
#
#         USAGE:  ./buildIt.sh
#
#   DESCRIPTION:  This is used to build the Aeris Demo project
#
#       OPTIONS:  ---
#  REQUIREMENTS:  ---
#          BUGS:  ---
#         NOTES:  ---
#        AUTHOR:  Daniel Carda,
#                 CodeWarrior@CardaTechnologies.com
#       VERSION:  1.0
#       CREATED:  08/20/2023
#      REVISION:  ---
#
#================================================================

startDir=$(pwd)

#  These are used for timing.
begin=$(date +"%s")
startingTime=$(date +"%D %T.%3N")


#===  FUNCTION   ================================================
#         Name:  build_DockerArtifact()
#  --------------------------------------------------------------
#  Description:  This will build the Docker container.
#   Parameters:  None
#      Returns:  None
#================================================================
function build_DockerArtifact() {

    echo
    echo
    echo

    # =======================================================================
    #  Build Docker container

    echo "-----------------------------------------------------------------------"
    echo
    echo "Y" | docker system prune -a

    docker build -t codewarrior23/personal-repository:AerisDemo .

    docker images


#    mvn     \
#      clean \
#      package
#
#    # Check results.
#    if [ $? -ne 0 ]; then
#        echo
#        echo "Build Failure: The application build has failed for some reason."
#        terminationAbnormal
#    fi

    # Display information about the artifact.
    #  display_ArtifactInformation
} # ---  End Function build_DockerArtifact()




#===  FUNCTION   ================================================
#         Name:  build_JarArtifact()
#  --------------------------------------------------------------
#  Description:  This will build the main EAR artifact.
#   Parameters:  None
#      Returns:  None
#================================================================
function build_JarArtifact() {

    echo
    echo
    echo

    # =======================================================================
    #  Build everything
    mvn     \
      clean \
      package

    # Check results.
    if [ $? -ne 0 ]; then
        echo
        echo "Build Failure: The application build has failed for some reason."
        terminationAbnormal
    fi

    # Display information about the artifact.
    #  display_ArtifactInformation
} # ---  End Function build_JarArtifact()

#===  FUNCTION   ================================================
#         Name:  build_JarArtifact_noTests()
#  --------------------------------------------------------------
#  Description:  This will build the main EAR artifact but will
#                not run the JUnit tests.
#   Parameters:  None
#      Returns:  None
#================================================================
function build_JarArtifact_noTests() {

    echo
    echo
    echo

    # =======================================================================
    #  Build everything
    mvn          \
      clean      \
      package    \
      -DskipTests

    # Check results.
    if [ $? -ne 0 ]; then
        echo
        echo "Build Failure: The application build has failed for some reason."
        terminationAbnormal
    fi

    # Display information about the artifact.
    display_ArtifactInformation

} # ---  End Function build_JarArtifact_noTests()

#===  FUNCTION   ================================================
#         Name:  resolve_dependencies()
#  --------------------------------------------------------------
#  Description:  This will issue the maven command to try and
#                resolve all the Jar dependancies.
#   Parameters:  None
#      Returns:  None
#================================================================
function resolve_dependencies() {

  # =======================================================================
  #  Try and resolve the Jar dependencies
  mvn dependency:resolve

  # Check results.
  if [ $? -ne 0 ]; then
    echo
    echo "Failure: Could Not Resolve Maven Dependencies..."
    terminationAbnormal
  fi
} # ---  End Function resolve_dependencies()

#===  FUNCTION   ================================================
#         Name:  dependency_tree()
#  --------------------------------------------------------------
#  Description:  This will issue the maven command to try and
#                resolve all the Jar dependancies.
#   Parameters:  None
#      Returns:  None
#================================================================
function dependency_tree() {

  # =======================================================================
  #  Try and resolve the Jar dependencies
  mvn dependency:tree

  # Check results.
  if [ $? -ne 0 ]; then
    echo
    echo "Failure: Could Not Resolve Maven Dependencies..."
    terminationAbnormal
  fi
} # ---  End Function dependency_tree()

#===  FUNCTION   ================================================
#         Name:  delete_Artifacts()
#  --------------------------------------------------------------
#  Description:  This will run the Maven site build.
#   Parameters:  None
#      Returns:  None
#================================================================
function delete_Artifacts() {

    # =======================================================================
    echo "Cleaning up files and directories..."

    #  --------------------------------------------------
    # Hammer Time!!!
    #  --------------------------------------------------

    rm --force --recursive ./target/
    if [ $? -ne 0 ]; then
        echo
        echo "Failure: Cannot Delete: ./target/"
        terminationAbnormal
    fi
    echo -ne "."

    # Maven Clean
    mvn clean
} # ---  End Function delete_Artifacts()

#===  FUNCTION   ================================================
#         Name:  display_ArtifactInformation()
#  --------------------------------------------------------------
#  Description:  Displays size of compiled artifact and internal
#                contents of MANIFEST.MF file.
#   Parameters:  None
#      Returns:  None
#================================================================
function display_ArtifactInformation() {

    echo
    echo
    echo "-----------------------------------------------------------------------"
    echo "File Information: "
    cd target/
    echo "  "
    ls -l  CogEngine-*.jar
    cd ..

    #  Time to print out the manifest information.
    echo
    echo
    echo "-----------------------------------------------------------------------"
    echo "                 ***  JAR MANIFEST INFORMATION  ***  "
    echo

    cd target/
    unzip -p CogEngine-*.jar META-INF/MANIFEST.MF >file.txt
    tail -37 file.txt
}  # ---  End Function display_ArtifactInformation()

#===  FUNCTION   ================================================
#         Name:  display_MainHeader()
#  --------------------------------------------------------------
#  Description:  Displays header.
#   Parameters:  None
#      Returns:  None
#================================================================
function display_MainHeader() {

    echo
    echo
    echo
    echo "-----------------------------------------------------------------------"
    echo "                      Built By: Daniel Carda"
    echo "-----------------------------------------------------------------------"
    echo
    echo
    echo
} # ---  End Function display_MainHeader()

#===  FUNCTION   ================================================
#         Name:  display_TaskChoices()
#  --------------------------------------------------------------
#  Description:  Displays header.
#   Parameters:  None
#      Returns:  None
#================================================================
function display_TaskChoices() {

    echo "-----------------------------------------------------------------------"
    echo " Task Selection"
    echo
    if [ $1 == "--help" ]; then
        echo "     ${0##*/}                <-- Build And Run Tests <default>"
        echo "     ${0##*/}  clean         <-- Deep Clean All Artifacts"
        echo "     ${0##*/}  site          <-- Build Maven Site Reports"

        echo "     ${0##*/}  resolve       <-- Will try and resolve Maven dependencies"
        echo "     ${0##*/}  tree          <-- Displays a Maven dependency tree"
        echo "     ${0##*/}  info          <-- Show information about the artifact"
        echo "     ${0##*/}  launch        <-- Launch the NetCDF viewer"
    fi
} # ---  End Function display_TaskChoices()

#===  FUNCTION   ================================================
#         Name:  terminationNormal()
#  --------------------------------------------------------------
#  Description:  Exits cleanly.
#   Parameters:  None
#      Returns:  None
#================================================================
function terminationNormal() {

    echo
    echo
    echo
    echo "-----------------------------------------------------------------------"
    echo "     Normal Program Termination..."
    echo

    echo "            Program Start: " $startingTime
    local endingTime=$(date +"%D %T.%3N")
    echo "       Normal Termination: " $endingTime

    local termin=$(date +"%s")
    local difftimelps=$(($termin - $begin))
    echo
    echo

    # Figure out the individual components of time
    local DAYS=$((difftimelps / 60 / 60 / 24))
    local HOURS=$((difftimelps / 60 / 60 % 24))
    local MINUTES=$((difftimelps / 60 % 60))
    local SECONDS=$((difftimelps % 60))

    # Change the header based on seconds
    if [ $difftimelps -eq $SECONDS ]; then
        echo "             Elapsed Time... "
        echo
    else
        echo "       Total Elapsed Time:  $difftimelps  (Seconds)"
        echo
    fi

    # Print out the individual time elements.
    [[ $DAYS -gt 0 ]] && printf '                         Days:  %02d \n' $DAYS
    [[ $HOURS -gt 0 ]] && printf '                        Hours:  %02d \n' $HOURS
    [[ $MINUTES -gt 0 ]] && printf '                      Minutes:  %02d \n' $MINUTES
    printf '                      Seconds:  %02d \n' $SECONDS

    echo
    echo "All Systems Nominal..."
    echo "-----------------------------------------------------------------------"
    echo
    echo
    #  Exit status code
    exit 0
} # ---  End Function terminationNormal()

#===  FUNCTION   ================================================
#         Name:  terminationAbnormal()
#  --------------------------------------------------------------
#  Description:  Exits poorly...
#   Parameters:  None
#      Returns:  None
#================================================================
function terminationAbnormal() {

    echo
    echo
    echo
    echo "-----------------------------------------------------------------------"
    echo "     ***  Abnormal Termination  ***"
    echo

    echo "            Program Start: " $startingTime
    local endingTime=$(date +"%D %T.%3N")
    echo "     Abnormal Termination: " $endingTime

    local termin=$(date +"%s")
    local difftimelps=$(($termin - $begin))
    echo
    echo

    # Figure out the individual components of time
    local DAYS=$((difftimelps / 60 / 60 / 24))
    local HOURS=$((difftimelps / 60 / 60 % 24))
    local MINUTES=$((difftimelps / 60 % 60))
    local SECONDS=$((difftimelps % 60))

    # Change the header based on seconds
    if [ $difftimelps -eq $SECONDS ]; then
        echo "             Elapsed Time... "
        echo
    else
        echo "       Total Elapsed Time:  $difftimelps  (Seconds)"
        echo
    fi

    # Print out the individual time elements.
    [[ $DAYS -gt 0 ]] && printf '                         Days:  %02d \n' $DAYS
    [[ $HOURS -gt 0 ]] && printf '                        Hours:  %02d \n' $HOURS
    [[ $MINUTES -gt 0 ]] && printf '                      Minutes:  %02d \n' $MINUTES
    printf '                      Seconds:  %02d \n' $SECONDS

    echo
    echo "Build Is In An Abend State..."
    echo "-----------------------------------------------------------------------"
    echo
    echo
    #  Exit status code
    exit 1
} # ---  End Function terminationAbnormal()

# =======================================================================
# MAIN SCRIPTING LOGIC
# =======================================================================

# This is the deployable artifact.  We will rename later.
numberOfArgs=$#
#paramterArg=$1

clear
display_MainHeader

# The $# will check to see if there were any parameters.  If none, then
# this is just a regular compile and build.
if [ $# -eq 0 ]; then
    # if block code
    # Delete all the artifacts
    delete_Artifacts

    # Build Main EAR Artifact
    build_JarArtifact

    build_DockerArtifact

    docker run -p 8080:8080  codewarrior23/personal-repository:AerisDemo

else
    # =====================================================================
    #  Well, looks like they want to do something specific.

    if [ $1 == "--help" ]; then
        display_TaskChoices $1

    elif [ $1 == "clean" ]; then
        # Delete all the artifacts
        delete_Artifacts
        # End the program
        terminationNormal

    elif [ $1 == "resolve" ]; then
        resolve_dependencies
        # End the program
        terminationNormal

    elif [ $1 == "launch" ]; then
        java -Xmx1g -jar ./src/tools/toolsUI-5.5.3.jar

        # End the program
        terminationNormal

    elif [ $1 == "tree" ]; then
        dependency_tree
        # End the program
        terminationNormal
    fi

fi #  End:  If/Else

