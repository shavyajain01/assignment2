@tag
Feature: To validate rates API

  @tag1
  Scenario: Rates API
    Given I am providing base api
    When I try to hit the request
    Then I validate the outcomes for status code and json body
    @tag2
  Scenario: Rates API2
    Given API2 for foreign exchange
    When Posted with correct info
    Then Validate positive response code recieved
    
    
    #this is negative scenarios for incorrect api 
      @tag3
  Scenario: Rates API3 Negative Scenario
    Given API3 for foreign exchange
    When Posted with incorrect info
   Then Validate positive response code recieved in request
    
    #THIS IS neghative scenarios for incorrect apiik key
    @tag4
  Scenario: Rates API4 Negative Scenario
    Given API4 for foreign exchange incorrect url
    When Posted with incorrect info url
    Then Validate positive response error code recieved in request 