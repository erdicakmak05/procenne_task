Feature: Test
  Scenario Outline: Kullanici
    Given Kullanici "ProcenneUrl" sayfasina gider
    And Kullanici Demo Request butonuna tiklar
    And Kullanici Name textbox'ini "<nameOrnekleri>" girer
    Examples:
    |nameOrnekleri|
    |Erdi|
    |Meryem|
    |Ayşe|