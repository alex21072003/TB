import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    //Для открытия сессии для работы с БД
//    StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
//            .configure("hibernate.cfg.xml").build();
//    Metadata metadata = new MetadataSources(standardServiceRegistry)
//            .getMetadataBuilder()
//            .build();
//    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
//            .build();
//    Session session = sessionFactory.openSession();
//    Transaction transaction = (Transaction) session.beginTransaction();

    private final ServiceBotImages serviceBotImages = new ServiceBotImages();

    public InlineKeyboardButton back = InlineKeyboardButton.builder()
            .text("Назад")
            .callbackData("назад")
            .build();
    public InlineKeyboardButton moduleOne = InlineKeyboardButton.builder()
            .text("Вводный модуль")
            .callbackData("вводный модуль")
            .build();
    public InlineKeyboardButton enterModuleOne = InlineKeyboardButton.builder()
            .text("Введение в модуль")
            .callbackData("введение в модуль")
            .build();
    public InlineKeyboardButton whichProgramModuleOne = InlineKeyboardButton.builder()
            .text("Какие бывают программы")
            .callbackData("какие бывают программы")
            .build();
    public InlineKeyboardButton frotendModuleOne = InlineKeyboardButton.builder()
            .text("Веб-приложения. Frontend и backend")
            .callbackData("веб-приложения. Frontend и backend")
            .build();
    public InlineKeyboardButton targetsModuleOne = InlineKeyboardButton.builder()
            .text("Цели и области применения Java")
            .callbackData("цели и области применения Java")
            .build();
    public InlineKeyboardButton codeModuleOne = InlineKeyboardButton.builder()
            .text("Как выглядит программный код")
            .callbackData("как выглядит программный код")
            .build();
    public InlineKeyboardButton downloadModuleOne = InlineKeyboardButton.builder()
            .text("Установка среды разработки")
            .callbackData("установка среды разработки")
            .build();
    public InlineKeyboardButton firstModuleOne = InlineKeyboardButton.builder()
            .text("Пишем простое приложение")
            .callbackData("пишем простое приложение")
            .build();
    public InlineKeyboardButton fileModuleOne = InlineKeyboardButton.builder()
            .text("Упаковываем прил в 1 файл")
            .callbackData("упаковываем прил в 1 файл")
            .build();
    public InlineKeyboardButton languageModuleOne = InlineKeyboardButton.builder()
            .text("Особенности языка Java")
            .callbackData("особенности языка Java")
            .build();
    public InlineKeyboardButton practiseWork = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("практическая работа")
            .build();
    public InlineKeyboardButton moduleTwo = InlineKeyboardButton.builder()
            .text("Синтаксис языка. Часть 1")
            .callbackData("синтаксис языка. Часть 1")
            .build();
    public InlineKeyboardButton variablesModuleTwo = InlineKeyboardButton.builder()
            .text("Переменные")
            .callbackData("переменные")
            .build();
    public InlineKeyboardButton ifOrElseInModuleTwo = InlineKeyboardButton.builder()
            .text("Условные операторы “if”и “else”")
            .callbackData("условные операторы “if”и “else”")
            .build();
    public InlineKeyboardButton operationModuleTwo = InlineKeyboardButton.builder()
            .text("Булевы операции")
            .callbackData("булевы операции")
            .build();
    public InlineKeyboardButton prioritiesModuleTwo = InlineKeyboardButton.builder()
            .text("Приоритеты и скобки в условиях")
            .callbackData("приоритеты и скобки в условиях")
            .build();
    public InlineKeyboardButton conditionModuleTwo = InlineKeyboardButton.builder()
            .text("Вложенные условия")
            .callbackData("вложенные условия")
            .build();
    public InlineKeyboardButton operatorModuleTwo = InlineKeyboardButton.builder()
            .text("Тернарный оператор")
            .callbackData("тернарный оператор")
            .build();
    public InlineKeyboardButton commentModuleTwo = InlineKeyboardButton.builder()
            .text("Комментарии в коде")
            .callbackData("комментарии в коде")
            .build();
    public InlineKeyboardButton practiseWorkModuleTwo = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("практическая работа")
            .build();
    public InlineKeyboardButton moduleThree = InlineKeyboardButton.builder()
            .text("Синтаксис языка. Часть 2")
            .callbackData("синтаксис языка. Часть 2")
            .build();
    public InlineKeyboardButton forModuleThree = InlineKeyboardButton.builder()
            .text("Цикл “for”")
            .callbackData("цикл “for”")
            .build();
    public InlineKeyboardButton whileModuleThree = InlineKeyboardButton.builder()
            .text("Циклы “while” и “do while”")
            .callbackData("циклы “while” и “do while”")
            .build();
    public InlineKeyboardButton breakModuleThree = InlineKeyboardButton.builder()
            .text("Операторы “break” и “continue”")
            .callbackData("операторы “break” и “continue”")
            .build();
    public InlineKeyboardButton switchCaseModuleThree = InlineKeyboardButton.builder()
            .text("Оператор switch case")
            .callbackData("оператор switch case")
            .build();
    public InlineKeyboardButton codeModuleThree = InlineKeyboardButton.builder()
            .text("Разбираем сложный код")
            .callbackData("разбираем сложный код")
            .build();
    public InlineKeyboardButton practiseWorkModuleThree = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("практическая работа")
            .build();
    public InlineKeyboardButton moduleFour = InlineKeyboardButton.builder()
            .text("Объекты и классы. Часть 1. Методы и классы")
            .callbackData("о и к. Ч 1. М и к")
            .build();
    public InlineKeyboardButton methodsModuleFour = InlineKeyboardButton.builder()
            .text("Методы")
            .callbackData("методы")
            .build();
    public InlineKeyboardButton parameterModuleFour = InlineKeyboardButton.builder()
            .text("Параметры методов")
            .callbackData("параметры методов")
            .build();
    public InlineKeyboardButton returnModuleFour = InlineKeyboardButton.builder()
            .text("Возвращаемые значения")
            .callbackData("возвращаемые значения")
            .build();
    public InlineKeyboardButton objectsModuleFour = InlineKeyboardButton.builder()
            .text("Классы и объекты")
            .callbackData("классы и объекты")
            .build();
    public InlineKeyboardButton constructModuleFour = InlineKeyboardButton.builder()
            .text("Конструкторы")
            .callbackData("конструкторы")
            .build();
    public InlineKeyboardButton overloadMethodsModuleFour = InlineKeyboardButton.builder()
            .text("Перегрузка методов")
            .callbackData("перегрузка методов")
            .build();
    public InlineKeyboardButton viewsModuleFour = InlineKeyboardButton.builder()
            .text("Области видимости")
            .callbackData("области видимости")
            .build();
    public InlineKeyboardButton practiseModuleFour = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("практическая работа")
            .build();
    public InlineKeyboardButton moduleFive = InlineKeyboardButton.builder()
            .text("Объекты и классы. Часть 2. Инкапсуляция")
            .callbackData("о и к. Ч 2. Инкапсуляция")
            .build();
    public InlineKeyboardButton inkapsulationModuleFive = InlineKeyboardButton.builder()
            .text("Инкапсуляция")
            .callbackData("инкапсуляция")
            .build();
    public InlineKeyboardButton getterAndSetterModuleFive = InlineKeyboardButton.builder()
            .text("POJO-классы, геттеры и сеттеры")
            .callbackData("pOJO-к, г и с")
            .build();
    public InlineKeyboardButton imutableModuleFive = InlineKeyboardButton.builder()
            .text("Immutable-классы")
            .callbackData("immutable-классы")
            .build();
    public InlineKeyboardButton transmissionModuleFive = InlineKeyboardButton.builder()
            .text("Передача по ссылке или по значению")
            .callbackData("передача по с или по з")
            .build();
    public InlineKeyboardButton copyModuleFive = InlineKeyboardButton.builder()
            .text("Копирование объектов")
            .callbackData("копирование объектов")
            .build();
    public InlineKeyboardButton practiseWorkModuleFive = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("практическая работа")
            .build();
    public InlineKeyboardButton practiseWorkInkapsulationModulFive = InlineKeyboardButton.builder()
            .text("Практическая работа. Инкапсуляция")
            .callbackData("практическая работа. И")
            .build();
    public InlineKeyboardButton practiseWorkPOGOModuleFive = InlineKeyboardButton.builder()
            .text("Практическая работа. POJO-классы, геттеры и сеттеры")
            .callbackData("п р. POJO-классы, г и с")
            .build();
    public InlineKeyboardButton practiseWorkImutableModuleFive = InlineKeyboardButton.builder()
            .text("Практическая работа. Immutable-классы")
            .callbackData("п р. Immutable-классы")
            .build();
    public InlineKeyboardButton moduleSix = InlineKeyboardButton.builder()
            .text("Объекты и классы. Часть 3. Static, константы и enum")
            .callbackData("о и к. Часть 3. S, к и e")
            .build();
    public InlineKeyboardButton staticModuleSix = InlineKeyboardButton.builder()
            .text("Статические переменные")
            .callbackData("статические переменные")
            .build();
    public InlineKeyboardButton static2ModuleSix = InlineKeyboardButton.builder()
            .text("Статические методы")
            .callbackData("статические методы")
            .build();
    public InlineKeyboardButton constantModuleSix = InlineKeyboardButton.builder()
            .text("Константы")
            .callbackData("константы")
            .build();
    public InlineKeyboardButton enumModuleSix = InlineKeyboardButton.builder()
            .text("Enum")
            .callbackData("enum")
            .build();
    public InlineKeyboardButton staticInizilationModuleSix = InlineKeyboardButton.builder()
            .text("Статическая инициализация")
            .callbackData("статическая инициализация")
            .build();
    public InlineKeyboardButton practiseWorkModuleSix = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("практическая работа")
            .build();
    public InlineKeyboardButton practiseWorkMethods = InlineKeyboardButton.builder()
            .text("П р. Статические методы")
            .callbackData("п р. Статические методы")
            .build();
    public InlineKeyboardButton practiseWorkEnum = InlineKeyboardButton.builder()
            .text("Практическая работа. Enum")
            .callbackData("практическая работа. Enum")
            .build();
    public InlineKeyboardButton moduleSeven = InlineKeyboardButton.builder()
            .text("Примитивы")
            .callbackData("примитивы")
            .build();
    public InlineKeyboardButton primitivModuleSeven = InlineKeyboardButton.builder()
            .text("Примитивы и объекты")
            .callbackData("примитивы и объекты")
            .build();
    public InlineKeyboardButton viewModuleSeven = InlineKeyboardButton.builder()
            .text("Виды примитивов")
            .callbackData("виды примитивов")
            .build();
    public InlineKeyboardButton bitAndByteModuleSeven = InlineKeyboardButton.builder()
            .text("Биты и байты")
            .callbackData("биты и байты")
            .build();
    public InlineKeyboardButton numbersModuleSeven = InlineKeyboardButton.builder()
            .text("Числа")
            .callbackData("числа")
            .build();
    public InlineKeyboardButton symbwolsModuleSeven = InlineKeyboardButton.builder()
            .text("Символы")
            .callbackData("символы")
            .build();
    public InlineKeyboardButton classModuleSeven = InlineKeyboardButton.builder()
            .text("Классы-обёртки, boxing и unboxing")
            .callbackData("к-о, b и u")
            .build();
    public InlineKeyboardButton practiseWorkModuleSeven = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("практическая работа")
            .build();
    public InlineKeyboardButton moduleEight = InlineKeyboardButton.builder()
            .text("Числа и даты")
            .callbackData("числа и даты")
            .build();
    public InlineKeyboardButton operationModuleEight = InlineKeyboardButton.builder()
            .text("Операции с числами")
            .callbackData("операции с числами")
            .build();
    public InlineKeyboardButton inkrementModuleEight = InlineKeyboardButton.builder()
            .text("Инкремент и декремент")
            .callbackData("инкремент и декремент")
            .build();
    public InlineKeyboardButton createNumbersModuleEight = InlineKeyboardButton.builder()
            .text("Преобразование (приведение) чисел")
            .callbackData("преобразование чисел")
            .build();
    public InlineKeyboardButton subtractionModuleEight = InlineKeyboardButton.builder()
            .text("Точность вычислений")
            .callbackData("точность вычислений")
            .build();
    public InlineKeyboardButton dateModuleEight = InlineKeyboardButton.builder()
            .text("Дата и время")
            .callbackData("дата и время")
            .build();
    public InlineKeyboardButton timeModuleEight = InlineKeyboardButton.builder()
            .text("Метка времени (timestamp)")
            .callbackData("м в (timestamp)")
            .build();
    public InlineKeyboardButton practiseWorkAutoModelEight = InlineKeyboardButton.builder()
            .text("Практическая работа (автотесты)")
            .callbackData("п р (автотесты)")
            .build();
    public InlineKeyboardButton practiseWithBigNumbersModuleEight = InlineKeyboardButton.builder()
            .text("П р. Р с б и точными числами (автотесты)")
            .callbackData("п р. Р с б и точными числами")
            .build();
    public InlineKeyboardButton practiseWorkInTimeModuleEight = InlineKeyboardButton.builder()
            .text("Практическая работа. Метка времени (автотесты)")
            .callbackData("п р. Метка времени")
            .build();
    public InlineKeyboardButton moduleNine = InlineKeyboardButton.builder()
            .text("Строки")
            .callbackData("строки")
            .build();
    public InlineKeyboardButton stringsConstanModuleNine = InlineKeyboardButton.builder()
            .text("Строки, конкатенация и сравнение")
            .callbackData("строки, к и с")
            .build();
    public InlineKeyboardButton backStringsModuleNine = InlineKeyboardButton.builder()
            .text("Преобразование чисел в строки и обратно")
            .callbackData("преобразование ч в с и обратно")
            .build();

    public InlineKeyboardButton methodsWorkModuleNine = InlineKeyboardButton.builder()
        .text("Методы работы с подстроками")
        .callbackData("методы работы с подстроками")
        .build();
    public InlineKeyboardButton poolMethodNine = InlineKeyboardButton.builder()
            .text("String Pool")
            .callbackData("string Pool")
            .build();
    public InlineKeyboardButton practiseWorkModuleNine = InlineKeyboardButton.builder()
            .text("Практическая работа (автотесты)")
            .callbackData("практическая работа (автотесты)")
            .build();
    public InlineKeyboardButton practiseWorkAutoModelNine = InlineKeyboardButton.builder()
            .text("Практическая работа (автотесты)")
            .callbackData("практическая работа (автотесты)")
            .build();
    public InlineKeyboardButton moduleTen = InlineKeyboardButton.builder()
            .text("Массивы и списки")
            .callbackData("массивы и списки")
            .build();
    public InlineKeyboardButton createArrayModuleNine = InlineKeyboardButton.builder()
            .text("Создание массивов")
            .callbackData("создание массивов")
            .build();
    public InlineKeyboardButton workWithArray =InlineKeyboardButton.builder()
            .text("Работа с массивами в циклах")
            .callbackData("работа с массивами в циклах")
            .build();
    public InlineKeyboardButton bigArray = InlineKeyboardButton.builder()
            .text("Многомерные массивы")
            .callbackData("многомерные массивы")
            .build();
    public InlineKeyboardButton arrayModuleTen = InlineKeyboardButton.builder()
            .text("Класс Arrays")
            .callbackData("класс Arrays")
            .build();
    public InlineKeyboardButton practiseWorkArrayModuleTen = InlineKeyboardButton.builder()
            .text("Практическая работа. Массивы (автотесты)")
            .callbackData("п р. Массивы")
            .build();
    public InlineKeyboardButton listModuleTen = InlineKeyboardButton.builder()
            .text("Списки")
            .callbackData("списки")
            .build();
    public InlineKeyboardButton practiseListModuleTen = InlineKeyboardButton.builder()
            .text("Практическая работа. Списки — List (автотесты)")
            .callbackData("практическая работа. Списки")
            .build();
    public InlineKeyboardButton moduleEleven = InlineKeyboardButton.builder()
            .text("Коллекции Set, Map")
            .callbackData("коллекции Set, Map")
            .build();
    public InlineKeyboardButton hashSetModuleEleven = InlineKeyboardButton.builder()
            .text("Коллекция HashSet")
            .callbackData("коллекция HashSet")
            .build();
    public InlineKeyboardButton workHashSetModuleEleven = InlineKeyboardButton.builder()
            .text("Механизм работы HashSet")
            .callbackData("механизм работы HashSet")
            .build();
    public InlineKeyboardButton treSetModuleEleven = InlineKeyboardButton.builder()
            .text("Коллекция TreeSet")
            .callbackData("коллекция TreeSet")
            .build();
    public InlineKeyboardButton redTreesModuleEleven = InlineKeyboardButton.builder()
            .text("Красно-черные деревья")
            .callbackData("красно-черные деревья")
            .build();
    public InlineKeyboardButton practiseMap = InlineKeyboardButton.builder()
            .text("Практическая работа. Множества — Set (автотесты)")
            .callbackData("п р. М— Set (автотесты)")
            .build();
    public InlineKeyboardButton collectionModuleEleven =InlineKeyboardButton.builder()
            .text("Коллекции HashMap и TreeMap")
            .callbackData("коллекции HashMap и TreeMap")
            .build();
    public InlineKeyboardButton practiseWorkAutoMoDuleEleven = InlineKeyboardButton.builder()
            .text("Практическая работа. Map (автотесты)")
            .callbackData("п р. Map")
            .build();
    public InlineKeyboardButton moduleTwelve = InlineKeyboardButton.builder()
            .text("Comparator Iterator Collections")
            .callbackData("comparator Iterator Collections")
            .build();
    public InlineKeyboardButton choiceModuleTwelve = InlineKeyboardButton.builder()
            .text("Выбор подходящей коллекции")
            .callbackData("выбор подходящей коллекции")
            .build();
    public InlineKeyboardButton collectionModuleTwelve = InlineKeyboardButton.builder()
            .text("Преобразование массивов и коллекций")
            .callbackData("Преобразование м и к")
            .build();
    public InlineKeyboardButton iteratorModuleTwelve = InlineKeyboardButton.builder()
            .text("Итератор")
            .callbackData("итератор")
            .build();
    public InlineKeyboardButton classCollectionModuleTwelve = InlineKeyboardButton.builder()
            .text("Класс Collections")
            .callbackData("класс Collections")
            .build();
    public InlineKeyboardButton practiseCollectionModuleTwelve = InlineKeyboardButton.builder()
            .text("Практическая работа. Поиск в коллекциях (автотесты)")
            .callbackData("п р. Поиск в коллекциях")
            .build();
    public InlineKeyboardButton moduleThirteen = InlineKeyboardButton.builder()
            .text("Наследование")
            .callbackData("наследование")
            .build();
    public InlineKeyboardButton inheritanceModuleThirteen = InlineKeyboardButton.builder()
            .text("Наследование классов Java")
            .callbackData("наследование классов Java")
            .build();
    public InlineKeyboardButton methodsModuleThirteen = InlineKeyboardButton.builder()
            .text("Переопределение методов")
            .callbackData("переопределение методов")
            .build();
    public InlineKeyboardButton staticMethodsModuleThirteen = InlineKeyboardButton.builder()
            .text("Переопределение статических методов")
            .callbackData("переопределение статических м")
            .build();
    public InlineKeyboardButton objectModuleThirteen = InlineKeyboardButton.builder()
            .text("Класс Object")
            .callbackData("класс Object")
            .build();
    public InlineKeyboardButton modificationModuleThirteen = InlineKeyboardButton.builder()
            .text("Модификаторы доступа")
            .callbackData("модификаторы доступа")
            .build();
    public InlineKeyboardButton practiseWorkModuleThirteen = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("практическая работа")
            .build();
    private InlineKeyboardMarkup keyboardAllModules = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(moduleOne))
            .keyboardRow(List.of(moduleTwo))
            .keyboardRow(List.of(moduleThree))
            .keyboardRow(List.of(moduleFour))
            .keyboardRow(List.of(moduleFive))
            .keyboardRow(List.of(moduleSix))
            .keyboardRow(List.of(moduleSeven))
            .keyboardRow(List.of(moduleEight))
            .keyboardRow(List.of(moduleNine))
            .keyboardRow(List.of(moduleTen))
            .keyboardRow(List.of(moduleEleven))
            .keyboardRow(List.of(moduleTwelve))
            .keyboardRow(List.of(moduleThirteen))
            .build();

    private InlineKeyboardMarkup keyboardEmpty = InlineKeyboardMarkup.builder().build();

    private InlineKeyboardMarkup sendModuleOne = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(enterModuleOne))
            .keyboardRow(List.of(whichProgramModuleOne))
            .keyboardRow(List.of(frotendModuleOne))
            .keyboardRow(List.of(targetsModuleOne))
            .keyboardRow(List.of(codeModuleOne))
            .keyboardRow(List.of(downloadModuleOne))
            .keyboardRow(List.of(firstModuleOne))
            .keyboardRow(List.of(fileModuleOne))
            .keyboardRow(List.of(languageModuleOne))
            .keyboardRow(List.of(practiseWork))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwo = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(variablesModuleTwo))
            .keyboardRow(List.of(ifOrElseInModuleTwo))
            .keyboardRow(List.of(operationModuleTwo))
            .keyboardRow(List.of(prioritiesModuleTwo))
            .keyboardRow(List.of(conditionModuleTwo))
            .keyboardRow(List.of(operatorModuleTwo))
            .keyboardRow(List.of(commentModuleTwo))
            .keyboardRow(List.of(practiseWorkModuleTwo))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleThree = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(forModuleThree))
            .keyboardRow(List.of(whileModuleThree))
            .keyboardRow(List.of(breakModuleThree))
            .keyboardRow(List.of(switchCaseModuleThree))
            .keyboardRow(List.of(codeModuleThree))
            .keyboardRow(List.of(practiseWorkModuleThree))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleFour = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(methodsModuleFour))
            .keyboardRow(List.of(parameterModuleFour))
            .keyboardRow(List.of(returnModuleFour))
            .keyboardRow(List.of(objectsModuleFour))
            .keyboardRow(List.of(constructModuleFour))
            .keyboardRow(List.of(overloadMethodsModuleFour))
            .keyboardRow(List.of(viewsModuleFour))
            .keyboardRow(List.of(practiseModuleFour))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleFive = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(inkapsulationModuleFive))
            .keyboardRow(List.of(getterAndSetterModuleFive))
            .keyboardRow(List.of(imutableModuleFive))
            .keyboardRow(List.of(transmissionModuleFive))
            .keyboardRow(List.of(copyModuleFive))
            .keyboardRow(List.of(practiseWorkModuleFive))
            .keyboardRow(List.of(practiseWorkInkapsulationModulFive))
            .keyboardRow(List.of(practiseWorkPOGOModuleFive))
            .keyboardRow(List.of(practiseWorkImutableModuleFive))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleSix = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(staticModuleSix))
            .keyboardRow(List.of(static2ModuleSix))
            .keyboardRow(List.of(constantModuleSix))
            .keyboardRow(List.of(enumModuleSix))
            .keyboardRow(List.of(staticInizilationModuleSix))
            .keyboardRow(List.of(practiseWorkModuleSix))
            .keyboardRow(List.of(practiseWorkMethods))
            .keyboardRow(List.of(practiseWorkEnum))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleSeven = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(primitivModuleSeven))
            .keyboardRow(List.of(viewModuleSeven))
            .keyboardRow(List.of(bitAndByteModuleSeven))
            .keyboardRow(List.of(numbersModuleSeven))
            .keyboardRow(List.of(symbwolsModuleSeven))
            .keyboardRow(List.of(classModuleSeven))
            .keyboardRow(List.of(practiseWorkModuleSeven))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleEight = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(operationModuleEight))
            .keyboardRow(List.of(inkrementModuleEight))
            .keyboardRow(List.of(createNumbersModuleEight))
            .keyboardRow(List.of(subtractionModuleEight))
            .keyboardRow(List.of(dateModuleEight))
            .keyboardRow(List.of(timeModuleEight))
            .keyboardRow(List.of(practiseWorkAutoModelEight))
            .keyboardRow(List.of(practiseWithBigNumbersModuleEight))
            .keyboardRow(List.of(practiseWorkInTimeModuleEight))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleNine = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(stringsConstanModuleNine))
            .keyboardRow(List.of(backStringsModuleNine))
            .keyboardRow(List.of(methodsWorkModuleNine))
            .keyboardRow(List.of(poolMethodNine))
            .keyboardRow(List.of(practiseWorkModuleNine))
            .keyboardRow(List.of(practiseWorkAutoModelNine))
            .keyboardRow(List.of(back))
            .build();
    public InlineKeyboardMarkup sendModuleTen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(createArrayModuleNine))
            .keyboardRow(List.of(workWithArray))
            .keyboardRow(List.of(bigArray))
            .keyboardRow(List.of(arrayModuleTen))
            .keyboardRow(List.of(practiseWorkArrayModuleTen))
            .keyboardRow(List.of(listModuleTen))
            .keyboardRow(List.of(practiseListModuleTen))
            .keyboardRow(List.of(back))
            .build();
    public InlineKeyboardMarkup sendModuleEleven = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(hashSetModuleEleven))
            .keyboardRow(List.of(workHashSetModuleEleven))
            .keyboardRow(List.of(treSetModuleEleven))
            .keyboardRow(List.of(redTreesModuleEleven))
            .keyboardRow(List.of(practiseMap))
            .keyboardRow(List.of(collectionModuleEleven))
            .keyboardRow(List.of(practiseWorkAutoMoDuleEleven))
            .keyboardRow(List.of(back))
            .build();
    public InlineKeyboardMarkup sendModuleTwelve = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(choiceModuleTwelve))
            .keyboardRow(List.of(collectionModuleTwelve))
            .keyboardRow(List.of(iteratorModuleTwelve))
            .keyboardRow(List.of(classCollectionModuleTwelve))
            .keyboardRow(List.of(practiseCollectionModuleTwelve))
            .keyboardRow(List.of(back))
            .build();
    public InlineKeyboardMarkup sendModuleThirteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(inheritanceModuleThirteen))
            .keyboardRow(List.of(methodsModuleThirteen))
            .keyboardRow(List.of(staticMethodsModuleThirteen))
            .keyboardRow(List.of(objectModuleThirteen))
            .keyboardRow(List.of(modificationModuleThirteen))
            .keyboardRow(List.of(practiseWorkModuleThirteen))
            .keyboardRow(List.of(back))
            .build();



    @Override
    public String getBotUsername() {
        return "@java_tel_21_bot";
    }

    @Override
    public String getBotToken() {
        return "7382570433:AAFT0DYgwR1ghSLSxhP15CrmA5ChaT2NJf4";
    }

    @Override
    public void onUpdateReceived(Update update) {
        buttonTab(update);
        isCommand(update.getMessage());
    }

    public void isCommand(Message message) {
        String text = message.getText();
        if (text.equals("/menu")) {
            System.out.println(message.getFrom().getId());
            sendMenu(message.getFrom().getId(), "<b>Модули</b>", keyboardAllModules);
        } else {
            sendMenu(message.getFrom().getId(), "Для начала работы tg-бота напишите <b>\"/menu\"</b>", keyboardEmpty);
        }
    }

    public void buttonTab(Update update) {
        if (update.hasCallbackQuery()) {
            String idUser = update.getCallbackQuery().getMessage().getChatId().toString();
            int idMessage = update.getCallbackQuery().getMessage().getMessageId();
            String data = update.getCallbackQuery().getData();
            String queryId = update.getCallbackQuery().getId();

            EditMessageText editMessageText = EditMessageText.builder()
                    .chatId(idUser)
                    .messageId(idMessage)
                    .text("")
                    .build();

            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .chatId(idUser.toString())
                    .messageId(idMessage)
                    .build();


            if (data.equals("вводный модуль")) {
                editMessageText.setText("Вводный модуль");
                editMessageReplyMarkup.setReplyMarkup(sendModuleOne);


                //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("введение в модуль")) {
                editMessageText.setText("Введение в модуль");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Введение в модуль.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("какие бывают программы")) {
                editMessageText.setText("Какие бывают программы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Какие бывают программы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("веб-приложения. Frontend и backend")) {
                editMessageText.setText("Веб-приложения. Frontend и backend");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Веб-приложения. Frontend и backend.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("цели и области применения Java")) {
                editMessageText.setText("Цели и области применения Java");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Цели и области применения Java.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("как выглядит программный код")) {
                editMessageText.setText("Как выглядит программный код");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Как выглядит программный код.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("установка среды разработки")) {
                editMessageText.setText("Установка среды разработки");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Установка JDK и среды разработки IntelliJ IDEA.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("пишем простое приложение")) {
                editMessageText.setText("Пишем простое приложение");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Пишем простое приложение.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("упаковываем прил в 1 файл")) {
                editMessageText.setText("Упаковываем прил в 1 файл");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Упаковываем приложение в один файл.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("особенности языка Java")) {
                editMessageText.setText("Особенности языка Java");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Особенности языка Java.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа")) {
                editMessageText.setText("Практическая работа");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа1.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (data.equals("синтаксис языка. Часть 1")) {
                editMessageText.setText("Синтаксис языка. Часть 1");
                editMessageReplyMarkup.setReplyMarkup(sendModuleTwo);


                //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("переменные")) {
                editMessageText.setText("Переменные");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Переменные.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("условные операторы “if”и “else”")) {
                editMessageText.setText("Условные операторы “if”и “else”");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Условные операторы If else.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("булевы операции")) {
                editMessageText.setText("Булевы операции");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Булевы операции.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("приоритеты и скобки в условиях")) {
                editMessageText.setText("Приоритеты и скобки в условиях");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Приоритеты и скобки в условиях.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("вложенные условия")) {
                editMessageText.setText("Вложенные условия");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Вложенные условия.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("Тернарный оператор")) {
                editMessageText.setText("Тернарный оператор");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Тернарный оператор.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("комментарии в коде")) {
                editMessageText.setText("Комментарии в коде");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Комментарии в коде.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа")) {
                editMessageText.setText("Практическая работа");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа 3.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (data.equals("синтаксис языка. Часть 2")) {
                editMessageText.setText("Синтаксис языка. Часть 2");
                editMessageReplyMarkup.setReplyMarkup(sendModuleThree);


                //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("цикл “for”")) {
                editMessageText.setText("Цикл “for”");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Цикл “for”.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("циклы “while” и “do while”")) {
                editMessageText.setText("Циклы “while” и “do while”");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Циклы “while” и “do while”.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("операторы “break” и “continue”")) {
                editMessageText.setText("Операторы “break” и “continue”");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Операторы “break” и “continue”.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("оператор “switch … case”")) {
                editMessageText.setText("Оператор “switch … case”");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Оператор “switch … case”.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("разбираем сложный код")) {
                editMessageText.setText("Разбираем сложный код");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Разбираем сложный код.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа")) {
                editMessageText.setText("Практическая работа");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа 4.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (data.equals("о и к. Ч 1. М и к")) {
                editMessageText.setText("Объекты и классы. Часть 1. Методы и классы");
                editMessageReplyMarkup.setReplyMarkup(sendModuleFour);


                //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("методы")) {
                editMessageText.setText("Методы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Методы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("параметры методов")) {
                editMessageText.setText("Параметры методов");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Параметры методов.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("возвращаемые значения")) {
                editMessageText.setText("Возвращаемые значения");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Возвращаемые значения.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("классы и объекты")) {
                editMessageText.setText("Классы и объекты");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Классы и объекты.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("конструкторы")) {
                editMessageText.setText("Конструкторы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конструкторы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("перегрузка методов")) {
                editMessageText.setText("Перегрузка методов");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Перегрузка методов.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("области видимости")) {
                editMessageText.setText("Области видимости");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Области видимости.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа")) {
                editMessageText.setText("Практическая работа");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа 5.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (data.equals("о и к. Ч 2. Инкапсуляция")) {
                editMessageText.setText("Объекты и классы. Часть 2. Инкапсуляция");
                editMessageReplyMarkup.setReplyMarkup(sendModuleFive);


                //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("инкапсуляция")) {
                editMessageText.setText("Инкапсуляция");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Инкапсуляция.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("pOJO-классы, геттеры и сеттеры")) {
                editMessageText.setText("POJO-классы, геттеры и сеттеры");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "POJO-классы, геттеры и сеттеры.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("immutable-классы")) {
                editMessageText.setText("Immutable-классы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Immutable-классы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("передача по ссылке или по значению")) {
                editMessageText.setText("Передача по ссылке или по значению");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Передача по ссылке или по значению.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("копирование объектов")) {
                editMessageText.setText("Копирование объектов");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Копирование объектов.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("Практическая работа")) {
                editMessageText.setText("практическая работа");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа. Инкапсуляция")) {
                editMessageText.setText("Практическая работа. Инкапсуляция");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Инкапсуляция.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа. POJO-классы, геттеры и сеттеры")) {
                editMessageText.setText("Практическая работа. POJO-классы, геттеры и сеттеры");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. POJO-классы, геттеры и сеттеры.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа. Immutable-классы")) {
                editMessageText.setText("Практическая работа. Immutable-классы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Immutable-классы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (data.equals("о и к. Часть 3. S, к и e")) {
                editMessageText.setText("Объекты и классы. Часть 3. Static, константы и enum");
                editMessageReplyMarkup.setReplyMarkup(sendModuleSix);


                //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("статические переменные")) {
                editMessageText.setText("Статические переменные");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Статические переменные.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("статические методы")) {
                editMessageText.setText("Статические методы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Статические методы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("константы")) {
                editMessageText.setText("Константы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Константы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("enum")) {
                editMessageText.setText("Enum");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Enum.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("статическая инициализация")) {
                editMessageText.setText("Статическая инициализация");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Статическая инициализация.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа")) {
                editMessageText.setText("Практическая работа");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа 7.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа. Статические методы")) {
                editMessageText.setText("Практическая работа. Статические методы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Статические методы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа. Enum")) {
                editMessageText.setText("Практическая работа. Enum");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Enum.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (data.equals("примитивы")) {
                editMessageText.setText("Примитивы");
                editMessageReplyMarkup.setReplyMarkup(sendModuleSeven);


                //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("примитивы и объекты")) {
                editMessageText.setText("Примитивы и объекты");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Примитивы и объекты.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("виды примитивов")) {
                editMessageText.setText("Виды примитивов");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Виды примитивов.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("биты и байты")) {
                editMessageText.setText("Биты и байты");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Биты и байты.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("числа")) {
                editMessageText.setText("Числа");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Числа.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("символы")) {
                editMessageText.setText("Символы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Символы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("классы-обёртки, boxing и unboxing")) {
                editMessageText.setText("Классы-обёртки, boxing и unboxing");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Классы-обертки.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа")) {
                editMessageText.setText("Практическая работа");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа 8.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (data.equals("числа и даты")) {
                editMessageText.setText("Числа и даты");
                editMessageReplyMarkup.setReplyMarkup(sendModuleEight);


                //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("операции с числами")) {
                editMessageText.setText("Операции с числами");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Операции с числами.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("инкремент и декремент")) {
                editMessageText.setText("Инкремент и декремент");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Инкремент и декремент.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("преобразование (приведение) чисел")) {
                editMessageText.setText("Преобразование (приведение) чисел");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Преобразование (приведение).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("точность вычислений")) {
                editMessageText.setText("Точность вычислений");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Точность вычислений.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("дата и время")) {
                editMessageText.setText("Дата и время");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Дата и время.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("метка времени (timestamp)")) {
                editMessageText.setText("Метка времени (timestamp)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Метка времени (timestamp).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа (автотесты)")) {
                editMessageText.setText("Практическая работа (автотесты)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа (автотесты).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п р. Р с б и точными числами (автотесты)")) {
                editMessageText.setText("П р. Р с б и точными числами (автотесты)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Работа с большими и точными числами (автотесты).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа. Метка времени (автотесты)")) {
                editMessageText.setText("Практическая работа. Метка времени (автотесты)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Метка времени (автотесты).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }if (data.equals("строки")) {
                    editMessageText.setText("Строки");
                    editMessageReplyMarkup.setReplyMarkup(sendModuleNine);


                    //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("строки, к и с")) {
                editMessageText.setText("Строки, конкатенация и сравнение");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Строки, конкатенация и сравнение.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("преобразование ч в с и обратно")) {
                editMessageText.setText("Преобразование чисел в строки и обратно");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Преобразование чисел в строки и обратно.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("методы работы с подстроками")) {
                editMessageText.setText("Методы работы с подстроками");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Методы работы с подстроками.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("string Pool")) {
                editMessageText.setText("String Pool");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "String Pool.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа (автотесты)")) {
                editMessageText.setText("Практическая работа (автотесты)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа 9.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа (автотесты)")) {
                editMessageText.setText("Практическая работа (автотесты)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа (автотесты).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }if (data.equals("массивы и списки")) {
                    editMessageText.setText("Массивы и списки");
                    editMessageReplyMarkup.setReplyMarkup(sendModuleTen);


                    //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("создание массивов")) {
                editMessageText.setText("Создание массивов");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Создание массивов.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("работа с массивами в циклах")) {
                editMessageText.setText("Работа с массивами в циклах");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Работа с массивами в циклах.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("многомерные массивы")) {
                editMessageText.setText("Многомерные массивы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Многомерные массивы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("класс Arrays")) {
                editMessageText.setText("Класс Arrays");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Класс Arrays.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п р. Массивы")) {
                editMessageText.setText("Практическая работа. Массивы (автотесты)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Массивы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("списки")) {
                editMessageText.setText("Списки");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Списки.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("Практическая работа. Списки")) {
                editMessageText.setText("Практическая работа. Списки — List (автотесты)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Списки.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }if (data.equals("коллекции Set, Map")) {
                    editMessageText.setText("Коллекции Set, Map");
                    editMessageReplyMarkup.setReplyMarkup(sendModuleEleven);


                    //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("коллекция HashSet")) {
                editMessageText.setText("Коллекция HashSet");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Коллекция HashSet.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("механизм работы HashSet")) {
                editMessageText.setText("Механизм работы HashSet");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Механизм работы HashSet.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("коллекция TreeSet")) {
                editMessageText.setText("Коллекция TreeSet");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Коллекция TreeSet.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("красно-черные деревья")) {
                editMessageText.setText("Красно-черные деревья");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Красно-чёрные деревья.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п р. М— Set (автотесты)")) {
                editMessageText.setText("Практическая работа. Множества — Set (автотесты)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "п р. М— Set (автотесты).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (data.equals("коллекции HashMap и TreeMap")) {
                editMessageText.setText("Коллекции HashMap и TreeMap");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Коллекции HashMap и TreeMap.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п р. Map")) {
                editMessageText.setText("Практическая работа. Map (автотесты)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа 10.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }if (data.equals("comparator Iterator Collections")) {
                    editMessageText.setText("Comparator Iterator Collections");
                    editMessageReplyMarkup.setReplyMarkup(sendModuleTwelve);


                    //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("наследование классов Java")) {
                editMessageText.setText("Наследование классов Java");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Наследование классов Java.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("выбор подходящей коллекции")) {
                editMessageText.setText("Выбор подходящей коллекции");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Выбор подходящей коллекции.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("Преобразование м и к")) {
                editMessageText.setText("Преобразование массивов и коллекций");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Преобразование массивов и коллекций.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("итератор")) {
                editMessageText.setText("Итератор");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Итератор.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("модификаторы доступа")) {
                editMessageText.setText("Модификаторы доступа");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Модификаторы доступа.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п р. Поиск в коллекциях")) {
                editMessageText.setText("Практическая работа. Поиск в коллекциях (автотесты)");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Поиск в коллекциях (автотесты).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }if (data.equals("наследование")) {
                    editMessageText.setText("Наследование");
                    editMessageReplyMarkup.setReplyMarkup(sendModuleThirteen);


                    //Последняя кнопка для сохранения всех данных в БД
//            else if (data.equals("end app")) {
//                editMessageText.setText("Saved data in DataBase and the application is completed!");
//
//                try {
//                    //Для закрытия сессии при работе с БД
////                    transaction.commit();
////                    sessionFactory.close();
//
////                    //Open session and other
////                    standardServiceRegistry = new StandardServiceRegistryBuilder()
////                            .configure("hibernate.cfg.xml").build();
////                    metadata = new MetadataSources(standardServiceRegistry)
////                            .getMetadataBuilder()
////                            .build();
////                    sessionFactory = metadata.getSessionFactoryBuilder()
////                            .build();
////                    session = sessionFactory.openSession();
////                    transaction = (Transaction) session.beginTransaction();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
            } else if (data.equals("Наследование классов Java")) {
                editMessageText.setText("наследование классов Java");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Наследование классов Java.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("переопределение методов")) {
                editMessageText.setText("Переопределение методов");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Переопределение методов.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("переопределение статических м")) {
                editMessageText.setText("Переопределение статических методов");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Переопределение статических методов.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("класс Object")) {
                editMessageText.setText("Класс Object");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Класс Object.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("практическая работа")) {
                editMessageText.setText("Практическая работа");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Веб-приложения. Frontend и backend.pdf");
//                    materialForCourse.setName("Веб-приложения. Frontend и backend");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Веб-приложения. Frontend и backend");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Веб-приложения. Frontend и backend(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа 11.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }



            } else if (data.equals("назад")) {
                editMessageText.setText("Модули");
                editMessageReplyMarkup.setReplyMarkup(keyboardAllModules);
            }

            AnswerCallbackQuery answerCallbackQuery = AnswerCallbackQuery.builder()
                    .callbackQueryId(queryId)
                    .build();

            try {
                execute(answerCallbackQuery);
                execute(editMessageText);
                execute(editMessageReplyMarkup);
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }

    public void sendMenu(Long who, String txt, InlineKeyboardMarkup km) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .parseMode("HTML")
                .text(txt)
                .replyMarkup(km)
                .build();

        try {
            execute(sm);
        } catch (TelegramApiException tae) {
            throw new RuntimeException(tae);
        }
    }
}