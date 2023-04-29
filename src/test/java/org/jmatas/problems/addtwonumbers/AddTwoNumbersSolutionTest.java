package org.jmatas.problems.addtwonumbers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.jmatas.problems.addtwonumbers.AddTwoNumbersSolution.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AddTwoNumbersSolutionTest {

    private AddTwoNumbersSolution solution;

    @BeforeEach
    public void setUp() {
        solution = new AddTwoNumbersSolution();
    }

    @Test
    void transform_from_numeric_to_list_test() {
        // Arrange
        String givenNumber = "23423423443436151413431";

        // Action
        ListNode listNode = solution.toListNode(givenNumber);
        String result = solution.toDecimal(listNode);

        // Assert
        assertThat(result).isEqualTo(givenNumber);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void given_test_cases(String testCaseName, ListNode summand1, ListNode summand2, ListNode expectedResult) {
        // Arrange

        // Action
        ListNode result = solution.addTwoNumbers(summand1, summand2);

        // Assert
        ListNode resultCurrent = result;
        ListNode expectedResultCurrent = expectedResult;
        do {
            assertThat(resultCurrent.val).isEqualTo(expectedResultCurrent.val);
            resultCurrent = resultCurrent.next;
            expectedResultCurrent = expectedResultCurrent.next;
        } while (expectedResultCurrent != null);
    }

    private static Stream<Arguments> testCases() {
        new ListNode(2, new ListNode(4, new ListNode(3)));
        return Stream.of(

                arguments("Example 1",
                        new ListNode(2, new ListNode(4, new ListNode(3))),
                        new ListNode(5, new ListNode(6, new ListNode(4))),
                        new ListNode(7, new ListNode(0, new ListNode(8)))),
                arguments("Example 2",
                        new ListNode(0),
                        new ListNode(0),
                        new ListNode(0)),
                arguments("Example 3",
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))),
                        new ListNode(8,
                                new ListNode(9, new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))))),
                arguments("Example 4",
                        new ListNode(9),
                        new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))))),
                        new ListNode(0, new ListNode(0,
                                new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0,
                                        new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1)))))))))))));
    }
}
