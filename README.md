﻿# OtusSpringHW 

Домашнее задание #1:

Программа по проведению тестирования студентов
В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопрсов). Программа должна спросить у пользователя фамилию и имя, спросить 5 вопросов из CSV-файла и вывести результат тестирования.

Все сервисы в программе должны решать строго определённую задачу. Зависимости должны быть настроены в IoC контейнере.

Опционально: сервисы, по возможности, покрыть тестами.

### 19-03-18 Доработки:
- Переименование классов.
- Добавление исключения QuestionsFileLoadingException.
- Работа с консолью вынесена в сервис ConsoleService.
- Тесты для QuestionsDAO. 