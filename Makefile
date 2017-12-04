all:
	javac -classpath ./lib/junit-4.12.jar  -d build src/src/edu/colostate/cs/cs414/tba/**/*.java

compile:
	javac -classpath ./lib/junit-4.12.jar  -d build src/src/edu/colostate/cs/cs414/tba/**/*.java

test:
	cd build && java -cp ../lib/junit-4.12.jar:../lib/hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore edu.colostate.cs.cs414.tba.tests.TestAll & cd ..

clean:
	rm -rf build && mkdir build

run:
	cd build && java -cp . edu.colostate.cs.cs414.tba.services.GymSystem
