Feature: As a logged-in user, you see the form with datas You should be able to add yours datas so fill the form

  Scenario Outline: The user is logged and must complete form with data
    Given you see empty fields to fill datas
    And you have completed the alias"<alias>", address"<address>" and city"<city>" fields
    When you wrote zip"<zip>" into field
    And you chose field with country"<country>"
    Then you should add yours phone"<phone>"
    And click button 'save', yours datas should save

    Examples:
      | alias  | address | city   | zip    | country        | phone     |
      | Dedixs | Lawowa  | Poznań | 61-680 | United Kingdom | 666990981 |