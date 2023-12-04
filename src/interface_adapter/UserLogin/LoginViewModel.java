package interface_adapter.UserLogin;

import entity.User;

public class LoginViewModel {
    public LoginViewModel(User user) {
    }

    public class LoginPresenter {
        private final LoginView view;

        public LoginPresenter(LoginView view) {
            this.view = view;
        }

        public void presentLoginSuccess(User user) {
            // Transform the UserData into a ViewModel
            LoginViewModel viewModel = new LoginViewModel(user);
            // Update the view with the new ViewModel
            view.showLoginSuccess(viewModel);
        }

        public void presentLoginFailure(String errorMessage) {
            // Pass the error message directly to the view
            view.showLoginError(errorMessage);
        }

        // Inner interface to decouple presenter from the actual view implementation
        public interface LoginView {
            void showLoginSuccess(LoginViewModel userViewModel);
            void showLoginError(String message);
        }
    }
    public LoginState getState(){
        return state;
    }
}
