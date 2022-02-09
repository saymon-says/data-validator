[![Actions Status](https://github.com/saymon-says/java-project-lvl3/workflows/my-project-check/badge.svg)](https://github.com/saymon-says/java-project-lvl3/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/8bd4bd6398096305575e/maintainability)](https://codeclimate.com/github/saymon-says/java-project-lvl3/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/8bd4bd6398096305575e/test_coverage)](https://codeclimate.com/github/saymon-says/java-project-lvl3/test_coverage)
### Описание
___
Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных. Подобных библиотек множество в каждом языке, так как практически все программы работают с внешними данными, которые нужно проверять на корректность. В первую очередь речь идет про данные форм заполняемых пользователями. По мотивам библиотеки yup.
### Реализовано
___
Проверка может проходить по трем валидаторам для каждого типа входящих данных (строки, числа, структура Map).

Валидаторы строк:
* required – любая непустая строка
* minLength – строка равна или длиннее указанного числа
* contains – строка содержит определённую подстроку

Валидаторы чисел:
* required – любое число включая ноль
* positive – положительное число
* range – диапазон в который должны попадать числа включая границы

Валидаторы Map:
* required – требуется тип данных Map
* sizeof – количество пар ключ-значений в объекте Map должно быть равно заданному
* shape - вложенная валидация
### Технологии и подход к разработке
___
* утилита Make
* наследование и предикаты;
* TDD c использованием JUnit5+jacoco;
* CodeClimate, Github Action.
### Требования
___
* OpenJDK_14
* Gradle 7.2
* Make