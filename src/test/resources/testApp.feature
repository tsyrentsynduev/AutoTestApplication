Feature:Выполнение тестового задания на приложении <Giphy>


  Scenario:Проверка отображения gif-изображений и проверка поиска по различным значениям
    Given Открылось приложение
    When  Проверить отображение элементов домашнего экрана
    And   Нажать на гифку - проверить, что мы остались на домашнем экране
    And   Прокрутить домашний экран вниз - проверить, что подгружаются новые гифки
    Given Нажать на поиск - проверить отображение элементов на экране поиска
    When  Выполнить поиск по пробелам
    Then  Нет результатов поиска
    When  Выполнить поиск по значению test
    Then  В результатах поиска отображаются гифки
    And   Прокрутить экран поиска вниз - проверить, что подгружаются новые гифки
    And   Нажать на гифку - проверить, что мы остались на экране поиска
    When  Выполнить поиск по очень длинному значению
    Then  Нет результатов поиска
    When  Выполнить поиск по спец символам
    Then  Нет результатов поиска
    Given Кликнуть на поле ввода в строке поиска - проверить отображение клавиатуры
    When  Нажать на экране поиска кнопку <Назад> в шапке
    Then  Проверить, что мы вернулись на домашний экран
    Given Нажать на поиск - проверить отображение элементов на экране поиска
    When  Нажать на аппаратную кнопку <Назад>
    Then  Проверить, что мы вернулись на домашний экран
    When  Нажать на аппаратную кнопку <Назад>
    Then  Проверить, что приложение закрылось





