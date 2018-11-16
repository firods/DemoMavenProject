#Author: shrikantfirodiya4@gmail.com
@All
Feature: Verify Weather APIs
    @Cityname
    Scenario: Verify weather APIs using city name
    Given Get Weather data
    When Get Weather by city name
    Then Verify Weather by city name response
    @CityID
    Scenario: Verify weather APIs using city id
    Given Get Weather data
    When Get Weather by city ID
    Then Verify Weather by city ID response
    @Cityzipcode
    Scenario: Verify weather APIs using city ZipCode
    Given Get Weather data
    When Get Weather by city ZipCode
    Then Verify Weather by city ZipCode response
    @Multiplecity
    Scenario: Verify weather APIs using MultiplecityIDs
    Given Get Weather data
    When Get Weather by multiplecityIDs
    Then Verify Weather by multiplecityIDs response