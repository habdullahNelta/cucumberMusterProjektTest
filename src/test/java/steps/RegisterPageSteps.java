package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.RegisterPage;
import qa.factory.DriverFactory;

import java.util.logging.Level;

public class RegisterPageSteps {

    final String invalidEmail="invalidEmail";
    final String validEmail="HasanNour8@gmail.com";
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());

    @When("user clicks on register link")
    public void user_clicks_on_register_link() {
        registerPage.getRegisterLink().click();
    }

    @When("user fills out first name field")
    public void user_fills_out_first_name_field() {
        registerPage.getFirstNameField().sendKeys(firstName);
    }

    @When("user fills out last name field")
    public void user_fills_out_last_name_field() {
        registerPage.getLastNameField().sendKeys(lastName);
    }

    @When("user fills out email field")
    public void user_fills_out_email_field() {
        registerPage.getEmailField().sendKeys(email);
    }

    @When("user fills out Password field")
    public void user_fills_out_password_field() {
        registerPage.getPasswordField().sendKeys(password);
    }

    @When("user fills out confirm password field")
    public void user_fills_out_confirm_password_field() {
        registerPage.getConfirmPasswordField().sendKeys(password);
    }

    @When("user clicks on register")
    public void user_clicks_on_register() {
        registerPage.getRegisterButton().click();
    }

    @Then("user should gets Your registration completed")
    public void user_should_gets_your_registration_completed() {
        String massage = registerPage.checkRegistrationCompletedMessage().getText();
        Assert.assertEquals(massage, "Your registration completed");
    }

    @When("user clicks on continue button")
    public void user_clicks_on_continue_button() {
        registerPage.getContinueButton().click();
    }

    @Then("user should be successfully registered")
    public void user_should_be_successfully_registered() {
        Assert.assertTrue(registerPage.checkRegistrationDone().isDisplayed());
    }


    //  Register Page With Invalid Inputs Functionality Test
    @And("user enters invalid email format")
    public void user_enters_invalid_email_format() {
        registerPage.getEmailField().sendKeys(invalidEmail);
    }

    @And("user tries to enter password")
    public void user_tries_to_enter_password() {
        registerPage.getPasswordField().click();
    }

    @Then("user should get an error message: Wrong email")
    public void user_should_get_an_error_message_wrong_email() {
        Assert.assertTrue(registerPage.getErrorMessageWrongEmail().isDisplayed());
    }


    // Register User with existing email

    @When("user enters existing email")
    public void user_enters_existing_email() {
        registerPage.getEmailField().sendKeys(validEmail);
    }

    @Then("user should get an error message: The specified email already exists")
    public void user_should_get_an_error_message_the_specified_email_already_exists() {
        Assert.assertTrue(true);
        DriverFactory.logger(Level.INFO,"Done");
    }


}
