@tag
Feature: Login Application
  Background:
  Given initialise the driver

  @tag1
  Scenario Outline: Login with various data
      Given Navigate to application
      When user enters login credentials with <username> and <password>
      Then validate login successful
    Examples:
      |username|password|
      |test@rs.com|Test@123|






