package dev.mechstack.ms0623.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidationExceptionTest 
{
    @Test
    public void errorMessageIsSetToExceptionMessage()
    {
        String TEST_MESSAGE = "messageTest";
        try {
          throw new ValidationException(TEST_MESSAGE);
        }
        catch (Exception e) {
          assertEquals(TEST_MESSAGE, e.getMessage());
        }
    }
}
