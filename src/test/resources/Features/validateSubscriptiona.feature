Feature: validate the Subscription Packages – Type & Price and Currency for all Countries (SA /
  Kuwait and Baharin)


@testcase1 (priority=1)
Scenario Outline: I want to validate the subscription packages for countries

  Given I select "<country>"
  When I scroll to "<package>"
  Then "<currency>" is shown as "<coin>"
  And "<price>" per month is "<amount>"

Examples:

  | country | package           | currency         | coin | price            | amount |
  | Lebanon | lite-selection    | currency-lite    | USD  | currency-lite    | 2.4    |
  | Lebanon | classic-selection | classic-lite     | USD  | currency-classic | 4.8    |
  | Lebanon | premium-selection | currency-premium | USD  | currency-premium | 7.2    |
  | Egypt   | lite-selection    | currency-lite    | USD  | currency-lite    | 0.25   |
  | Egypt   | classic-selection | classic-lite     | USD  | currency-classic | 0.5    |
  | Egypt   | premium-selection | currency-premium | USD  | currency-premium | 1      |
  | UAE     | lite-selection    | currency-lite    | USD  | currency-lite    | 5.4    |
  | UAE     | classic-selection | classic-lite     | USD  | currency-classic | 10.9   |
  | UAE     | premium-selection | currency-premium | USD  | currency-premium | 16.3   |
