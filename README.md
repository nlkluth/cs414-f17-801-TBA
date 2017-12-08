# cs414-f17-801-TBA

## DEMO pt5 - [https://youtu.be/B--8MVoSlUE](https://youtu.be/B--8MVoSlUE)

[![Build Status](https://travis-ci.org/nlkluth/cs414-f17-801-TBA.svg?branch=master)](https://travis-ci.org/nlkluth/cs414-f17-801-TBA) <-- click to see Travis build status (forgot to mention in demo)

### Run test
##### with ant
- `$ ant` runs all steps:
  - `$ ant compile` compiles to build directory
  - `$ ant test` runs tests

##### with make
- `$ make test`

##### without make
- `$ cd build`
- `$ java -cp ../lib/junit-4.12.jar:../lib/hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore edu.colostate.cs.cs414.tba.gymmanagement.TestAll`

### Run program
##### with make
- `$make run`

##### without make
- `$ cd build && java -cp . edu.colostate.cs.cs414.tba.application.GymSystem`
