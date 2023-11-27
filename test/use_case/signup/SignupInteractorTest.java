package use_case.signup;

import data_access.InMemoryUserDataAccessObject;
import entity.UserFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignupInteractorTest {

    @Test
    public void successTest() {
        SignupInputData inputData = new SignupInputData("me", "password", "password", 19, 80, 190, "male", "john");
        assertEquals("me", inputData.getUsername());

        SignupDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("me", user.getUsername());
                assertTrue(userRepository.existsByName("john"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

        };
            SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, new UserFactory());
            interactor.execute(inputData);
    }

}



