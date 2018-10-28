Feature: Open Main Page
  This feature opens main web page

  @hotel_search_0
  Scenario: Open main page
    Given Opened main web page
    And Find search field
    And Input data into the city field
    |city                                         |
    |New York, New York, United States Of America |

    And Input check in date tomorrow

    And Point count of check out days
    |days |
    |7    |

    #And Click on Edit or add rooms button
    And Click on Rooms list and select More options

    And Select count of Rooms
    |rooms |
    |1     |

    And Select count of Adults
    |adults |
    |1      |

    And Select number of Children
    |children |
    |2        |

    And Select age of Children
    |age1 |age2  |
    |2    |3     |

    And Press search button
    Then Opened search page