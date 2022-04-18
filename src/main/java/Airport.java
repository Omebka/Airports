import lombok.Getter;

@Getter
public class Airport {
    private final int number;
    private final String name;
    private final String settlement;
    private final String country;
    private final String codeIATA;
    private final String codeICAO;
    private final double latitude;
    private final double longitude;
    private final int elevationInFoot;
    private final String parameterThatIsAlwaysSomeNumber;
    private final String parameterThatIsAlwaysSomeLetter;
    private final String timeZone;
    private final String parameterThatIsAlwaysAirport;
    private final String parameterThatIsAlwaysOurAirports;

    private final String[] allVariables = new String[14];

    public Airport(int number,
                   String name,
                   String settlement,
                   String country,
                   String codeIATA,
                   String codeICAO,
                   double latitude,
                   double longitude,
                   int elevationInFoot,
                   String parameterThatIsAlwaysSomeNumber,
                   String parameterThatIsAlwaysSomeLetter,
                   String timeZone,
                   String parameterThatIsAlwaysAirport,
                   String parameterThatIsAlwaysOurAirports) {
        this.number = number;
        this.name = name;
        this.settlement = settlement;
        this.country = country;
        this.codeIATA = codeIATA;
        this.codeICAO = codeICAO;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevationInFoot = elevationInFoot;
        this.parameterThatIsAlwaysSomeNumber = parameterThatIsAlwaysSomeNumber;
        this.parameterThatIsAlwaysSomeLetter = parameterThatIsAlwaysSomeLetter;
        this.timeZone = timeZone;
        this.parameterThatIsAlwaysAirport = parameterThatIsAlwaysAirport;
        this.parameterThatIsAlwaysOurAirports = parameterThatIsAlwaysOurAirports;
        allVariables[0] = Integer.toString(number);
        allVariables[1] = name;
        allVariables[2] = settlement;
        allVariables[3] = country;
        allVariables[4] = codeIATA;
        allVariables[5] = codeICAO;
        allVariables[6] = Double.toString(latitude);
        allVariables[7] = Double.toString(longitude);
        allVariables[8] = Integer.toString(elevationInFoot);
        allVariables[9] = parameterThatIsAlwaysSomeNumber;
        allVariables[10] = parameterThatIsAlwaysSomeLetter;
        allVariables[11] = timeZone;
        allVariables[12] = parameterThatIsAlwaysAirport;
        allVariables[13] = parameterThatIsAlwaysOurAirports;
    }

    public static Airport airportFromStringArray(String[] array) throws WrongSizeOfArrayException {
        if (array.length != 14) {
            throw new WrongSizeOfArrayException();
        }
        return new Airport(
                Integer.parseInt(array[0]),
                array[1],
                array[2],
                array[3],
                array[4],
                array[5],
                Double.parseDouble(array[6]),
                Double.parseDouble(array[7]),
                Integer.parseInt(array[8]),
                array[9],
                array[10],
                array[11],
                array[12],
                array[13]);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < allVariables.length; i++) {
            result = result.concat(allVariables[i]);
            if (i != allVariables.length - 1) {
                result = result.concat("  |  ");
            }
        }

        return result;
    }

    public String toString(int desiredColumn) {
        String result = allVariables[desiredColumn - 1] + "  |  ";
        for (int i = 0; i < allVariables.length; i++) {
            if (i != desiredColumn - 1) {
                result = result.concat(allVariables[i]);
                if (i != allVariables.length - 1) {
                    result = result.concat("  |  ");
                }
            }
        }

        return result;
    }
}
