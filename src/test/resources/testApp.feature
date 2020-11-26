Feature:Выполнение тестового задания на приложении <Giphy>

  Scenario:Открыть приложение - проверить отображение элементов главного экрана
    Given Открылось приложение
    When   Я проверяю отображение элементов главного экрана

  Scenario:Перейти на экран поиска и проверить инструмент поиска при вводе разных значений
    Given Открылся экран поиска
    When   Я ввел пробел в поисковую строку
    Then Нет результатов поиска
    And  Я ввел значение <test> в поисковую строку
    Then Отобразились результаты поиска по значению <test>
    And Я ввел очень длинное значение в поисковую строку
    Then Нет результатов поиска
    And Я ввел спец символы в поисковую строку
    Then Нет результатов поиска

  Scenario:Вернуться на главный экран и проверить, что переход произошел
    Given Открыт экран поиска
    When  Я нажал на кнопку <Назад>
    Then  Произошел переход на главный экран

  Scenario:Перейти на экран поиска и нажать аппаратную кнопку <Назад>, проверить переход и выйти из приложения аппаратной кнопкой <Назад>
    Given Открылся экран поиска
    When  Я нажал на аппаратную кнопку <Назад>
    Then  Произошел переход на главный экран
    When  Я нажал на аппаратную кнопку <Назад>





