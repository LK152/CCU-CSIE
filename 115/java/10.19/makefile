JAVAC = javac
JAVA = java
SOURCES = CarbonFootprint.java Building.java Car.java Bicycle.java CarbonFootprintTest.java
CLASSES = $(SOURCES:.java=.class)
MAIN = CarbonFootprintTest

%.class: %.java
	$(JAVAC) $<

$(CLASSES): $(SOURCES)
	$(JAVAC) $(SOURCES)

run: $(CLASSES)
	$(JAVA) $(MAIN)

clean:
	rm -f *.class
	@echo "Cleaned up .class files."
