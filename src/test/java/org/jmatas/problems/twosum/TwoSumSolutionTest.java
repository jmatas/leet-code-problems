package org.jmatas.problems.twosum;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoSumSolutionTest {

    private TwoSumSolution solution;

    @BeforeEach
    public void setUp() {
        solution = new TwoSumSolution();
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void given_test_cases(String testCaseName, int[] nums, int target, int[] expectedResult) {
        // Arrange

        // Action
        int[] result = solution.twoSum(nums, target);

        // Assert
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(

                arguments("Example 1",
                        new int[] {2, 7, 11, 15},
                        9,
                        new int[] {0, 1}),

                arguments("Example 2",
                        new int[] {3, 2, 4},
                        6,
                        new int[] {1, 2}),

                arguments("Example 3",
                        new int[] {3, 3},
                        6,
                        new int[] {0, 1}));
    }
}
