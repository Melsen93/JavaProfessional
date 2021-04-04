import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class ArrayHandlerTest {

    private final ArrayHandler arrayHandler = new ArrayHandler();

    @ParameterizedTest
    @MethodSource("dataForSuccessGettingValuesAfterLastFour")
    void getValuesAfterLastFour(int[] originalArray, int[] expectedResultArray) {
        int[] actualResultArray = arrayHandler.getValuesAfterLastFour(originalArray);
        Assertions.assertArrayEquals(expectedResultArray, actualResultArray);
    }

    private static Stream<Arguments> dataForSuccessGettingValuesAfterLastFour() {
        List<Arguments> arguments = new ArrayList<Arguments>() {{
            add(Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[]{5}));
            add(Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{}));
            add(Arguments.arguments(new int[]{4, 1, 2, 4, 3, 4, 5}, new int[]{5}));
            add(Arguments.arguments(new int[]{4, 1, 2, 3, 5}, new int[]{1, 2, 3, 5}));
        }};
        return arguments.stream();

    }

    @Test
    public void getValuesAfterLastFourWaitException() {
        int[] originalArray = {1, 2, 3};
        Assertions.assertThrows(RuntimeException.class, () ->
                arrayHandler.getValuesAfterLastFour(originalArray));
    }

    @ParameterizedTest
    @MethodSource("dataForFindFourOrOneNumberInArray")
    void findFourOrOneNumberInArray(int[] array, boolean expectedResult) {
        boolean actualResult = arrayHandler.findFourOrOneNumberInArray(array);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> dataForFindFourOrOneNumberInArray() {
        List<Arguments> arguments = new ArrayList<Arguments>() {{
            add(Arguments.arguments(new int[]{	1,	1,	1,	4,	4,	1, 4, 4	}, true));
            add(Arguments.arguments(new int[]{	1,	1,	1,	1,	1,	1 }, false));
            add(Arguments.arguments(new int[]{	4,	4,	4,	4},	false));
            add(Arguments.arguments(new int[]{	1,	4,	4,	1,	1,	4, 3 },	false));
            }};
            return arguments.stream();
}
    }



