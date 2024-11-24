package com.example.model;

import com.example.services.ServiceBotImages;
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

    public InlineKeyboardButton whatArePrograms = InlineKeyboardButton.builder()
            .text("Какие бывают программы")
            .callbackData("какие бывают программы")
            .build();

    public InlineKeyboardButton webAppFrontAndBack = InlineKeyboardButton.builder()
            .text("Веб-приложения. Frontend и backend")
            .callbackData("веб-приложения. Frontend и backend")
            .build();

    public InlineKeyboardButton goalsAndAreaApplicationJava = InlineKeyboardButton.builder()
            .text("Цели и области применения Java")
            .callbackData("цели и области применения Java")
            .build();

    public InlineKeyboardButton howLooksProgrammingCode = InlineKeyboardButton.builder()
            .text("Как выглядит программный код")
            .callbackData("как выглядит программный код")
            .build();

    public InlineKeyboardButton downloadIntellijIdea = InlineKeyboardButton.builder()
            .text("Скачать среду разработки")
            .callbackData("скачать среду разработки")
            .url("https://www.jetbrains.com/ru-ru/idea/download/?section=windows")
            .build();

    public InlineKeyboardButton whiteSimpleApp = InlineKeyboardButton.builder()
            .text("Пишем простое приложение")
            .callbackData("пишем простое приложение")
            .build();

    public InlineKeyboardButton jarFile = InlineKeyboardButton.builder()
            .text("Упаковка jar-файла")
            .callbackData("упаковка jar-файла")
            .url("https://docs.google.com/document/d/1YM1mylggI9d1ZkxenWfHRGxn_NK38FJ-1JrHj2eeR1E/edit#heading=h.9yiytdaelm8b")
            .build();

    public InlineKeyboardButton featuresJava = InlineKeyboardButton.builder()
            .text("Особенности языка Java")
            .callbackData("особенности языка Java")
            .build();

    public InlineKeyboardButton practiceWorkModuleOne = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Вводный модуль")
            .build();

    public InlineKeyboardButton moduleTwo = InlineKeyboardButton.builder()
            .text("Синтаксис языка, часть 1")
            .callbackData("синтаксис языка, часть 1")
            .build();
    public InlineKeyboardButton variables = InlineKeyboardButton.builder()
            .text("Переменные")
            .callbackData("переменные")
            .build();
    public InlineKeyboardButton ifAndElseIf = InlineKeyboardButton.builder()
            .text("Условные операторы “if”и “else”")
            .callbackData("условные операторы “if”и “else”")
            .build();

    public InlineKeyboardButton booleanOperation = InlineKeyboardButton.builder()
            .text("Булевы операции")
            .callbackData("булевы операции")
            .build();

    public InlineKeyboardButton priorityAndStaplesInConditions = InlineKeyboardButton.builder()
            .text("Приоритеты и скобки в условиях")
            .callbackData("приоритеты и скобки в условиях")
            .build();

    public InlineKeyboardButton nestedConditions = InlineKeyboardButton.builder()
            .text("Вложенные условия")
            .callbackData("вложенные условия")
            .build();

    public InlineKeyboardButton threeOperator = InlineKeyboardButton.builder()
            .text("Тернарный оператор")
            .callbackData("тернарный оператор")
            .build();

    public InlineKeyboardButton commentsInCode = InlineKeyboardButton.builder()
            .text("Комментарии в коде")
            .callbackData("комментарии в коде")
            .build();

    public InlineKeyboardButton codeMakeApp = InlineKeyboardButton.builder()
            .text("Разбираем код готового приложения")
            .callbackData("разбираем код готового приложения")
            .build();

    public InlineKeyboardButton practiceWorkModuleTwo = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по с я часть 1")
            .build();

    public InlineKeyboardButton moduleThree = InlineKeyboardButton.builder()
            .text("Синтаксис языка, часть 2")
            .callbackData("синтаксис языка, часть 2")
            .build();
    public InlineKeyboardButton cycleFor = InlineKeyboardButton.builder()
            .text("Цикл “for”")
            .callbackData("цикл “for”")
            .build();
    public InlineKeyboardButton cycleWhileAndDoWhile = InlineKeyboardButton.builder()
            .text("Циклы “while” и “do while”")
            .callbackData("циклы “while” и “do while”")
            .build();

    public InlineKeyboardButton switchCase = InlineKeyboardButton.builder()
            .text("Оператор switch case")
            .callbackData("оператор switch case")
            .build();

    public InlineKeyboardButton difficultCode = InlineKeyboardButton.builder()
            .text("Разбираем сложный код")
            .callbackData("разбираем сложный код")
            .build();

    public InlineKeyboardButton workLocalRepository = InlineKeyboardButton.builder()
            .text("Работа с локальным репозиторием")
            .callbackData("работа с локальным репозиторием")
            .build();

    public InlineKeyboardButton practiceWorkModuleThree = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по с я часть 2")
            .build();

    public InlineKeyboardButton moduleFour = InlineKeyboardButton.builder()
            .text("Методы и классы")
            .callbackData("методы и классы")
            .build();

    public InlineKeyboardButton methods = InlineKeyboardButton.builder()
            .text("Методы")
            .callbackData("методы")
            .build();

    public InlineKeyboardButton parametersMethods = InlineKeyboardButton.builder()
            .text("Параметры методов")
            .callbackData("параметры методов")
            .build();

    public InlineKeyboardButton returnsValues = InlineKeyboardButton.builder()
            .text("Возвращаемые значения")
            .callbackData("возвращаемые значения")
            .build();

    public InlineKeyboardButton classAndObjects = InlineKeyboardButton.builder()
            .text("Классы и объекты")
            .callbackData("классы и объекты")
            .build();

    public InlineKeyboardButton constructors = InlineKeyboardButton.builder()
            .text("Конструкторы")
            .callbackData("конструкторы")
            .build();

    public InlineKeyboardButton overloadMethods = InlineKeyboardButton.builder()
            .text("Перегрузка методов")
            .callbackData("перегрузка методов")
            .build();

    public InlineKeyboardButton areaVisibility = InlineKeyboardButton.builder()
            .text("Области видимости")
            .callbackData("области видимости")
            .build();

    public InlineKeyboardButton practiceWorkModuleFour = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Методы и классы")
            .build();

    public InlineKeyboardButton moduleFive = InlineKeyboardButton.builder()
            .text("Инкапсуляция")
            .callbackData("инкапсуляция")
            .build();
    public InlineKeyboardButton encapsulation = InlineKeyboardButton.builder()
            .text("Инкапсуляция")
            .callbackData("инкапсуляция")
            .url("https://blog.skillfactory.ru/glossary/inkapsulyacziya/")
            .build();
    public InlineKeyboardButton pojo = InlineKeyboardButton.builder()
            .text("POJO-классы, геттеры и сеттеры")
            .callbackData("POJO-классы, гет и сет")
            .build();

    public InlineKeyboardButton immutable = InlineKeyboardButton.builder()
            .text("Immutable-классы")
            .callbackData("immutable-классы")
            .build();

    public InlineKeyboardButton linkOrValue = InlineKeyboardButton.builder()
            .text("Передача по ссылке или по значению")
            .callbackData("ссылка или значение")
            .build();

    public InlineKeyboardButton copyObjects = InlineKeyboardButton.builder()
            .text("Копирование объектов")
            .callbackData("копирование объектов")
            .build();

    public InlineKeyboardButton practiceWorkModuleFive = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Инкапсуляция")
            .build();

    public InlineKeyboardButton moduleSix = InlineKeyboardButton.builder()
            .text("Static, константы и enum")
            .callbackData("static, константы и enum")
            .build();
    public InlineKeyboardButton staticVariables = InlineKeyboardButton.builder()
            .text("Статические переменные")
            .callbackData("cтатические переменные")
            .build();
    public InlineKeyboardButton staticMethods = InlineKeyboardButton.builder()
            .text("Статические методы")
            .callbackData("cтатические методы")
            .build();
    public InlineKeyboardButton constants = InlineKeyboardButton.builder()
            .text("Константы")
            .callbackData("константы")
            .build();
    public InlineKeyboardButton enumTopic = InlineKeyboardButton.builder()
            .text("Enum")
            .callbackData("enum")
            .build();
    public InlineKeyboardButton staticInitialization = InlineKeyboardButton.builder()
            .text("Статическая инициализация")
            .callbackData("cтатическая инициализация")
            .build();
    public InlineKeyboardButton practiceWorkModuleSix = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по static, константы и enum")
            .build();
    public InlineKeyboardButton moduleSeven = InlineKeyboardButton.builder()
            .text("Примитивы")
            .callbackData("примитивы")
            .build();
    public InlineKeyboardButton primitivesAndObjects = InlineKeyboardButton.builder()
            .text("Примитивы и объекты")
            .callbackData("примитивы и объекты")
            .build();
    public InlineKeyboardButton typesOfPrimitives = InlineKeyboardButton.builder()
            .text("Виды примитивов")
            .callbackData("виды примитивов")
            .build();
    public InlineKeyboardButton bitsAndBytes = InlineKeyboardButton.builder()
            .text("Биты и байты")
            .callbackData("биты и байты")
            .build();
    public InlineKeyboardButton numbers = InlineKeyboardButton.builder()
            .text("Числа")
            .callbackData("числа")
            .build();
    public InlineKeyboardButton symbols = InlineKeyboardButton.builder()
            .text("Символы")
            .callbackData("символы")
            .build();
    public InlineKeyboardButton wrapperClasses = InlineKeyboardButton.builder()
            .text("Классы-обертки")
            .callbackData("классы-обертки")
            .build();
    public InlineKeyboardButton practiceWorkModuleSeven = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Примитивам")
            .build();

    public InlineKeyboardButton moduleEight = InlineKeyboardButton.builder()
            .text("Числа и даты")
            .callbackData("числа и даты")
            .build();

    public InlineKeyboardButton operationsWithNumbers = InlineKeyboardButton.builder()
            .text("Операции с числами")
            .callbackData("операции с числами")
            .build();

    public InlineKeyboardButton incrementAndDecrement = InlineKeyboardButton.builder()
            .text("Инкремент и декремент")
            .callbackData("инкремент и декремент")
            .build();
    public InlineKeyboardButton updateNumbers = InlineKeyboardButton.builder()
            .text("Преобразование (приведение) чисел")
            .callbackData("преобразование(приведение) чисел")
            .build();
    public InlineKeyboardButton endCalculates = InlineKeyboardButton.builder()
            .text("Точность вычислений")
            .callbackData("точность вычислений")
            .build();
    public InlineKeyboardButton workWithBigAndEndNumbers = InlineKeyboardButton.builder()
            .text("Работа с большими и точными числами")
            .callbackData("работа с б и т числами")
            .build();
    public InlineKeyboardButton dateAndTime = InlineKeyboardButton.builder()
            .text("Дата и время")
            .callbackData("дата и время")
            .build();
    public InlineKeyboardButton timestamp = InlineKeyboardButton.builder()
            .text("Метка времени (timestamp)")
            .callbackData("timestamp")
            .build();
    public InlineKeyboardButton practiceWorkModuleEight = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Числа и даты")
            .build();

    public InlineKeyboardButton moduleNine = InlineKeyboardButton.builder()
            .text("Строки")
            .callbackData("строки")
            .build();
    public InlineKeyboardButton linesSumAndComparing = InlineKeyboardButton.builder()
            .text("Строки, конкатенация и сравнение")
            .callbackData("строки, к и с")
            .build();

    public InlineKeyboardButton updateNumberToLinesAndReverse = InlineKeyboardButton.builder()
            .text("Преобразование чисел в строки и обратно")
            .callbackData("преобразование ч в с и о")
            .build();
    public InlineKeyboardButton symbolsAndCoding = InlineKeyboardButton.builder()
            .text("Символы и кодировки")
            .callbackData("символы и кодировки")
            .build();
    public InlineKeyboardButton methodsWorkWithLines = InlineKeyboardButton.builder()
            .text("Методы работы с подстроками")
            .callbackData("методы работы с подс")
            .build();
    public InlineKeyboardButton stringPool = InlineKeyboardButton.builder()
            .text("String Pool")
            .callbackData("string Pool")
            .build();
    public InlineKeyboardButton regulars = InlineKeyboardButton.builder()
            .text("Регулярные выражения")
            .callbackData("регулярные выражения")
            .build();
    public InlineKeyboardButton practiceWorkModuleNine = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Строки")
            .build();

    public InlineKeyboardButton moduleTen = InlineKeyboardButton.builder()
            .text("Массивы и списки")
            .callbackData("массивы и списки")
            .build();

    public InlineKeyboardButton createArrays = InlineKeyboardButton.builder()
            .text("Создание массивов")
            .callbackData("создание массивов")
            .build();

    public InlineKeyboardButton workWithArraysInCycles = InlineKeyboardButton.builder()
            .text("Работа с массивами в циклах")
            .callbackData("работа с м в циклах")
            .build();
    public InlineKeyboardButton manyArrays = InlineKeyboardButton.builder()
            .text("Многомерные массивы")
            .callbackData("многомерные массивы")
            .build();
    public InlineKeyboardButton classArrays = InlineKeyboardButton.builder()
            .text("Класс Arrays")
            .callbackData("класс Arrays")
            .build();
    public InlineKeyboardButton practiceWorkModuleTenArrays = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Массивы")
            .build();
    public InlineKeyboardButton list = InlineKeyboardButton.builder()
            .text("Списки")
            .callbackData("списки")
            .build();
    public InlineKeyboardButton practiceWorkModuleTenList = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Списки")
            .build();
    public InlineKeyboardButton moduleEleven = InlineKeyboardButton.builder()
            .text("Коллекции Set, Map")
            .callbackData("коллекции Set, Map")
            .build();

    public InlineKeyboardButton hashSet = InlineKeyboardButton.builder()
            .text("Коллекция HashSet")
            .callbackData("коллекция HashSet")
            .build();
    public InlineKeyboardButton mechanismWorkHashSet = InlineKeyboardButton.builder()
            .text("Механизм работы HashSet")
            .callbackData("м р HashSet")
            .build();
    public InlineKeyboardButton collectionTreeSet = InlineKeyboardButton.builder()
            .text("Коллекция TreeSet")
            .callbackData("коллекция TreeSet")
            .build();
    public InlineKeyboardButton redBlackTrees = InlineKeyboardButton.builder()
            .text("Красно-черные деревья")
            .callbackData("к-ч деревья")
            .build();
    public InlineKeyboardButton practiceWorkModuleTenSet = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Множества Set")
            .build();
    public InlineKeyboardButton collectionsHashMapAndTreeMap = InlineKeyboardButton.builder()
            .text("Коллекции HashMap и TreeMap")
            .callbackData("к HashMap и TreeMap")
            .build();
    public InlineKeyboardButton practiceWorkModuleElevenMap = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Map")
            .build();
    public InlineKeyboardButton moduleTwelve = InlineKeyboardButton.builder()
            .text("Comparator iterator Collections")
            .callbackData("c i Collections")
            .build();
    public InlineKeyboardButton choiceSuitableCollection = InlineKeyboardButton.builder()
            .text("Выбор подходящей коллекции")
            .callbackData("выбор п к")
            .build();

    public InlineKeyboardButton transformationArraysAndCollections = InlineKeyboardButton.builder()
            .text("Преобразование массивов и коллекций")
            .callbackData("преобразование м и к")
            .build();
    public InlineKeyboardButton iterator = InlineKeyboardButton.builder()
            .text("Итератор")
            .callbackData("итератор")
            .build();
    public InlineKeyboardButton classCollections = InlineKeyboardButton.builder()
            .text("Класс Collections")
            .callbackData("класс Collections")
            .build();
    public InlineKeyboardButton practiceWorkModuleTwelveSearchInCollections = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Поиск в коллекциях")
            .build();
    public InlineKeyboardButton moduleThirteen = InlineKeyboardButton.builder()
            .text("Наследование")
            .callbackData("наследование")
            .build();
    public InlineKeyboardButton extendClassJava = InlineKeyboardButton.builder()
            .text("Наследование классов Java")
            .callbackData("наследование классов Java")
            .build();
    public InlineKeyboardButton redefinitionMethods = InlineKeyboardButton.builder()
            .text("Переопределение методов")
            .callbackData("переопределение методов")
            .build();
    public InlineKeyboardButton redefinitionStaticMethods = InlineKeyboardButton.builder()
            .text("Переопределение статических методов")
            .callbackData("переопределение с методов")
            .build();
    public InlineKeyboardButton classObject = InlineKeyboardButton.builder()
            .text("Класс Object")
            .callbackData("класс Object")
            .build();
    public InlineKeyboardButton modificationAccess = InlineKeyboardButton.builder()
            .text("Модификаторы доступа")
            .callbackData("модификаторы доступа")
            .build();

    public InlineKeyboardButton practiceWorkModuleThirteenExtend = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по Наследование")
            .build();
    public InlineKeyboardButton moduleFourteen = InlineKeyboardButton.builder()
            .text("Абстрактные классы и интерфейсы")
            .callbackData("абстрактные классы и интерфейсы")
            .build();
    public InlineKeyboardButton abstractClasses = InlineKeyboardButton.builder()
            .text("Абстрактные классы")
            .callbackData("абстрактные классы")
            .build();

    public InlineKeyboardButton interfaces = InlineKeyboardButton.builder()
            .text("Интерфейсы")
            .callbackData("интерфейсы")
            .build();
    public InlineKeyboardButton interfacesInJava = InlineKeyboardButton.builder()
            .text("Интерфейсы в языке Java")
            .callbackData("интерфейсы в языке Java")
            .build();
    public InlineKeyboardButton methodsWithDefaultRealisation = InlineKeyboardButton.builder()
            .text("Методы с дефолтной реализацией в интерфейсах")
            .callbackData("методы с д р в и")
            .build();
    public InlineKeyboardButton polymorphism = InlineKeyboardButton.builder()
            .text("Полиморфизм")
            .callbackData("полиморфизм")
            .build();

    public InlineKeyboardButton nestedClasses = InlineKeyboardButton.builder()
            .text("Вложенные классы")
            .callbackData("вложенные классы")
            .build();

    public InlineKeyboardButton practiceWorkModuleFourteen = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по А к и интерфейсы")
            .build();

    public InlineKeyboardButton moduleFifteen = InlineKeyboardButton.builder()
            .text("Deployment")
            .callbackData("deployment")
            .build();
    public InlineKeyboardButton maven = InlineKeyboardButton.builder()
            .text("Maven")
            .callbackData("maven")
            .build();

    public InlineKeyboardButton commandMavenAndPlugins = InlineKeyboardButton.builder()
            .text("Команды Maven. Плагины")
            .callbackData("к Maven. Плагины")
            .build();
    public InlineKeyboardButton gradle = InlineKeyboardButton.builder()
            .text("Система автоматической сборки Gradle")
            .callbackData("система автоматической сборки Gradle")
            .build();
    public InlineKeyboardButton installationGradle = InlineKeyboardButton.builder()
            .text("Установка системы Gradle")
            .callbackData("установка с Gradle")
            .build();
    public InlineKeyboardButton workWithGradleInIntelliJIDEA = InlineKeyboardButton.builder()
            .text("Работа с Gradle в IntelliJ IDEA")
            .callbackData("р с Gradle в I I")
            .build();

    public InlineKeyboardButton docker = InlineKeyboardButton.builder()
            .text("Docker")
            .callbackData("docker")
            .build();

    public InlineKeyboardButton generatedDocumentJavadoc = InlineKeyboardButton.builder()
            .text("Генерация документации Javadoc")
            .callbackData("г д Javadoc")
            .build();
    public InlineKeyboardButton resultsPassedTopic = InlineKeyboardButton.builder()
            .text("Итоги пройденных тем")
            .callbackData("итоги пройденных тем")
            .build();

    public InlineKeyboardButton moduleSixteen = InlineKeyboardButton.builder()
            .text("Функциональное програмирование в Java. Ч. 1")
            .callbackData("ф п в Java.ч.1")
            .build();
    public InlineKeyboardButton generics = InlineKeyboardButton.builder()
            .text("Дженерики")
            .callbackData("дженерики")
            .build();
    public InlineKeyboardButton functionInterfacesPartOne = InlineKeyboardButton.builder()
            .text("Функциональные интерфейсы. Часть 1")
            .callbackData("ф и. Часть 1")
            .build();
    public InlineKeyboardButton lambdaExpressions = InlineKeyboardButton.builder()
            .text("Лямбда-выражения")
            .callbackData("лямбда-выражения")
            .build();
    public InlineKeyboardButton classOptional = InlineKeyboardButton.builder()
            .text("Класс Optional")
            .callbackData("класс Optional")
            .build();
    public InlineKeyboardButton annotations = InlineKeyboardButton.builder()
            .text("Аннотации")
            .callbackData("аннотации")
            .build();
    public InlineKeyboardButton lombok = InlineKeyboardButton.builder()
            .text("Lombok")
            .callbackData("lombok")
            .build();
    public InlineKeyboardButton practiceWorkModuleSixteen = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по ф и. Часть 1")
            .build();

    public InlineKeyboardButton moduleSeventeen = InlineKeyboardButton.builder()
            .text("Функциональное програмирование в Java. Ч. 2. Stream API")
            .callbackData("ф п в Java.ч.2.Stream API")
            .build();
    public InlineKeyboardButton introductionStreamAPI = InlineKeyboardButton.builder()
            .text("Введение в Stream API")
            .callbackData("в в Stream API")
            .build();
    public InlineKeyboardButton createStream = InlineKeyboardButton.builder()
            .text("Создание Stream")
            .callbackData("создание Stream")
            .build();
    public InlineKeyboardButton intermediateOperators = InlineKeyboardButton.builder()
            .text("Промежуточные операторы")
            .callbackData("промежуточные операторы")
            .build();
    public InlineKeyboardButton terminalOperators = InlineKeyboardButton.builder()
            .text("Терминальные операторы")
            .callbackData("терминальные операторы")
            .build();
    public InlineKeyboardButton parallelReduceCombinationOperators = InlineKeyboardButton.builder()
            .text("Parallel, reduce и комбинирование операторов")
            .callbackData("p, r и к операторов")
            .build();
    public InlineKeyboardButton practiceWorkModuleSeventeen = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по ф и. Ч 2. S API")
            .build();

    public InlineKeyboardButton moduleEighteen = InlineKeyboardButton.builder()
            .text("Исключение, отладка и логирование")
            .callbackData("исключение, отладка и логирование")
            .build();
    public InlineKeyboardButton exceptionsNeed = InlineKeyboardButton.builder()
            .text("Что такое исключения и зачем они нужны")
            .callbackData("что такое и и з они нужны")
            .build();
    public InlineKeyboardButton typeExceptions = InlineKeyboardButton.builder()
            .text("Типы исключений")
            .callbackData("типы исключений")
            .build();
    public InlineKeyboardButton processingExceptions = InlineKeyboardButton.builder()
            .text("Обработка исключений")
            .callbackData("обработка исключений")
            .build();
    public InlineKeyboardButton createOwnExceptions = InlineKeyboardButton.builder()
            .text("Создание собственных исключений")
            .callbackData("с с исключений")
            .build();
    public InlineKeyboardButton debuggingApp = InlineKeyboardButton.builder()
            .text("Отладка приложений")
            .callbackData("отладка приложений")
            .build();
    public InlineKeyboardButton logging = InlineKeyboardButton.builder()
            .text("Логирование")
            .callbackData("логирование")
            .build();
    public InlineKeyboardButton practiceWorkModuleEighteen = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по и, о и л")
            .build();

    public InlineKeyboardButton moduleNineteen = InlineKeyboardButton.builder()
            .text("Работа с файлами и сетью")
            .callbackData("работа с файлами и сетью")
            .build();
    public InlineKeyboardButton classFile = InlineKeyboardButton.builder()
            .text("Класс File")
            .callbackData("класс File")
            .build();
    public InlineKeyboardButton readFilesWithHelpFilesInputStream = InlineKeyboardButton.builder()
            .text("Чтение файлов с помощью FileInputStream")
            .callbackData("ч ф с п FileInputStream")
            .build();
    public InlineKeyboardButton readFilesWithHelpFilesBufferedReader = InlineKeyboardButton.builder()
            .text("Чтение файлов с помощью BufferedReader")
            .callbackData("ч ф с п BufferedReader")
            .build();
    public InlineKeyboardButton readFilesWithHelpClassFiles = InlineKeyboardButton.builder()
            .text("Чтение файлов с помощью класса Files")
            .callbackData("ч ф с п класса Files")
            .build();
    public InlineKeyboardButton writeInFile = InlineKeyboardButton.builder()
            .text("Запись в файл")
            .callbackData("запись в файл")
            .build();
    public InlineKeyboardButton javaNIOAPI = InlineKeyboardButton.builder()
            .text("Java NIO API")
            .callbackData("java NIO API")
            .build();
    public InlineKeyboardButton relationFiles = InlineKeyboardButton.builder()
            .text("Табличные файлы")
            .callbackData("табличные файлы")
            .build();
    public InlineKeyboardButton structureXMLAndHTMLFiles = InlineKeyboardButton.builder()
            .text("Структура XML и HTML-файлов")
            .callbackData("с XML и HTML-ф")
            .build();
    public InlineKeyboardButton parsingHTMLFiles = InlineKeyboardButton.builder()
            .text("Парсинг HTML-файлов")
            .callbackData("п HTML-файлов")
            .build();
    public InlineKeyboardButton formatJSONAndParsingJSONFiles = InlineKeyboardButton.builder()
            .text("Формат JSON и парсинг JSON файлов")
            .callbackData("ф JSON и п JSON ф")
            .build();
    public InlineKeyboardButton formatJSON = InlineKeyboardButton.builder()
            .text("Формат JSON")
            .callbackData("формат JSON")
            .build();
    public InlineKeyboardButton configFiles = InlineKeyboardButton.builder()
            .text("Конфигурационные файлы")
            .callbackData("конфигурационные файлы")
            .build();
    public InlineKeyboardButton practiceWorkModuleNineteen = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п Р по р с ф и с")
            .build();

    public InlineKeyboardButton moduleTwenty = InlineKeyboardButton.builder()
            .text("Работа с MySQL в Java")
            .callbackData("работа с MySQL в Java")
            .build();
    public InlineKeyboardButton installationMySQL = InlineKeyboardButton.builder()
            .text("Установка MySQL")
            .callbackData("установка MySQL")
            .build();
    public InlineKeyboardButton connectionThroughJDBC = InlineKeyboardButton.builder()
            .text("Подключение через JDBC")
            .callbackData("подключение через JDBC")
            .build();
    public InlineKeyboardButton queryWithoutResultSet = InlineKeyboardButton.builder()
            .text("Запросы без ResultSet")
            .callbackData("запросы без ResultSet")
            .build();
    public InlineKeyboardButton hibernateConnectionAndSettings = InlineKeyboardButton.builder()
            .text("Hibernate — подключение и настройка")
            .callbackData("hibernate — п и н")
            .build();
    public InlineKeyboardButton changeInBase = InlineKeyboardButton.builder()
            .text("Hibernate: изменение данных в базе")
            .callbackData("hibernate: изменение д в базе")
            .build();
    public InlineKeyboardButton connectionOneToMany = InlineKeyboardButton.builder()
            .text("Связи ManyToOne и OneToMany")
            .callbackData("с ManyToOne и OneToMany")
            .build();
    public InlineKeyboardButton connectionManyToMany = InlineKeyboardButton.builder()
            .text("Связь ManyToMany")
            .callbackData("связь ManyToMany")
            .build();
    public InlineKeyboardButton hibernateQueryBuilder = InlineKeyboardButton.builder()
            .text("Hibernate query builder")
            .callbackData("hibernate query builder")
            .build();
    public InlineKeyboardButton lazyDownloadData = InlineKeyboardButton.builder()
            .text("Ленивая загрузка данных")
            .callbackData("ленивая загрузка данных")
            .build();
    public InlineKeyboardButton whereAndOrderBy = InlineKeyboardButton.builder()
            .text("Where и OrderBy")
            .callbackData("where и OrderBy")
            .build();
    public InlineKeyboardButton hql = InlineKeyboardButton.builder()
            .text("HQL")
            .callbackData("hql")
            .build();
    public InlineKeyboardButton practiceWorkModuleTwentyNumberOne = InlineKeyboardButton.builder()
            .text("Практическая работа №1")
            .callbackData("практическая работа №1")
            .build();
    public InlineKeyboardButton practiceWorkModuleTwentyNumberTwo = InlineKeyboardButton.builder()
            .text("Практическая работа №2")
            .callbackData("практическая работа №2")
            .build();
    public InlineKeyboardButton moduleTwentyOne = InlineKeyboardButton.builder()
            .text("Протокол HTTP")
            .callbackData("протокол HTTP")
            .build();
    public InlineKeyboardButton protocolHTTPRequestAndResponse = InlineKeyboardButton.builder()
            .text("Протокол HTTP. Запрос и ответ")
            .callbackData("п HTTP. З и о")
            .build();
    public InlineKeyboardButton methodsHTTPRequestGetAndPOST = InlineKeyboardButton.builder()
            .text("Методы HTTP-запросов GET и POST")
            .callbackData("м HTTP-з GET и POST")
            .build();
    public InlineKeyboardButton anotherMethodsHTTPRequest = InlineKeyboardButton.builder()
            .text("Другие методы HTTP-запросов")
            .callbackData("д методы HTTP-запросов")
            .build();
    public InlineKeyboardButton statusCodesHTTPResponse = InlineKeyboardButton.builder()
            .text("Статус-коды HTTP-ответов")
            .callbackData("статус-коды HTTP-ответов")
            .build();
    public InlineKeyboardButton addressNetworkResource = InlineKeyboardButton.builder()
            .text("Адресация сетевых ресурсов")
            .callbackData("а сетевых ресурсов")
            .build();
    public InlineKeyboardButton restTheoryAndPractice = InlineKeyboardButton.builder()
            .text("REST: теория и практика")
            .callbackData("rest: теория и практика")
            .build();
    public InlineKeyboardButton httpHeaders = InlineKeyboardButton.builder()
            .text("HTTP-заголовки")
            .callbackData("http-заголовки")
            .build();
    public InlineKeyboardButton versionsProtocolFTTPAndHTTPS = InlineKeyboardButton.builder()
            .text("Версии протокола HTTP и HTTPS")
            .callbackData("в п HTTP и HTTPS")
            .build();
    public InlineKeyboardButton moduleTwentyTwo = InlineKeyboardButton.builder()
            .text("Разработка веб-приложения. Ч. 1")
            .callbackData("разработка веб-приложения. Ч. 1")
            .build();
    public InlineKeyboardButton acquaintanceWithFrameworkSpring = InlineKeyboardButton.builder()
            .text("Знакомство с фреймворком Spring")
            .callbackData("з с ф Spring")
            .build();
    public InlineKeyboardButton inversionOfControlAndDependencyInjection = InlineKeyboardButton.builder()
            .text("Inversion of Control и Dependency Injection")
            .callbackData("i of c и d Injection")
            .build();
    public InlineKeyboardButton beanAndLifeCycle = InlineKeyboardButton.builder()
            .text("Bean и его жизненный цикл")
            .callbackData("bean и его ж ц")
            .build();
    public InlineKeyboardButton controllersAnnotation = InlineKeyboardButton.builder()
            .text("Контроллеры. Аннотации @Controller и @RestController")
            .callbackData("@Controller и @RestController")
            .build();
    public InlineKeyboardButton servicesAnnotationService = InlineKeyboardButton.builder()
            .text("Сервисы. Аннотация @Service")
            .callbackData("с. А @Service")
            .build();
    public InlineKeyboardButton configurationSpringApp = InlineKeyboardButton.builder()
            .text("Конфигурация Spring-приложений")
            .callbackData("конфигурация Spring-приложений")
            .build();
    public InlineKeyboardButton practiceWorkModuleTwentyTwoNumberOne = InlineKeyboardButton.builder()
            .text("Практическая работа №1")
            .callbackData("практическая работа №1")
            .build();
    public InlineKeyboardButton practiceWorkModuleTwentyTwoNumberTwo = InlineKeyboardButton.builder()
            .text("Практическая работа №2")
            .callbackData("практическая работа №2")
            .build();
    public InlineKeyboardButton moduleTwentyThree = InlineKeyboardButton.builder()
            .text("Разработка веб-приложения. Ч. 2")
            .callbackData("разработка веб-приложения. Ч. 2")
            .build();
    public InlineKeyboardButton workWithDataBaseSpringDateJPA = InlineKeyboardButton.builder()
            .text("Работа с базой данных. Spring Data JPA")
            .callbackData("р с б д. Spring Data JPA")
            .build();
    public InlineKeyboardButton connectionToDataBase = InlineKeyboardButton.builder()
            .text("Подключение к базе данных")
            .callbackData("п к базе данных")
            .build();
    public InlineKeyboardButton entityAndRepository = InlineKeyboardButton.builder()
            .text("Сущности и репозитории")
            .callbackData("сущности и репозитории")
            .build();
    public InlineKeyboardButton connectionBetweenEntity = InlineKeyboardButton.builder()
            .text("Связи между сущностями")
            .callbackData("с между сущностями")
            .build();
    public InlineKeyboardButton versionationDataBaseLiquibase = InlineKeyboardButton.builder()
            .text("Версионирование баз данных. Liquibase")
            .callbackData("в баз данных. Liquibase")
            .build();
    public InlineKeyboardButton practiceWorkModuleThreeteen = InlineKeyboardButton.builder()
            .text("Практическая работа")
            .callbackData("п р по Р веб-приложения. Ч. 2")
            .build();

//    public InlineKeyboardButton endWorkWithDB = InlineKeyboardButton.builder()
//            .text("Завершить работу тг-бота!")
//            .callbackData("end app")
//            .build();

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
            .keyboardRow(List.of(moduleFourteen))
            .keyboardRow(List.of(moduleFifteen))
            .keyboardRow(List.of(moduleSixteen))
            .keyboardRow(List.of(moduleSeventeen))
            .keyboardRow(List.of(moduleEighteen))
            .keyboardRow(List.of(moduleNineteen))
            .keyboardRow(List.of(moduleTwenty))
            .keyboardRow(List.of(moduleTwentyOne))
            .keyboardRow(List.of(moduleTwentyTwo))
            .keyboardRow(List.of(moduleTwentyThree))
//            .keyboardRow(List.of(endWorkWithDB))
            .build();

    private InlineKeyboardMarkup keyboardEmpty = InlineKeyboardMarkup.builder().build();

    private InlineKeyboardMarkup sendModuleOne = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(whatArePrograms))
            .keyboardRow(List.of(webAppFrontAndBack))
            .keyboardRow(List.of(goalsAndAreaApplicationJava))
            .keyboardRow(List.of(howLooksProgrammingCode))
            .keyboardRow(List.of(downloadIntellijIdea))
            .keyboardRow(List.of(whiteSimpleApp))
            .keyboardRow(List.of(jarFile))
            .keyboardRow(List.of(featuresJava))
            .keyboardRow(List.of(practiceWorkModuleOne))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwo = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(variables))
            .keyboardRow(List.of(ifAndElseIf))
            .keyboardRow(List.of(booleanOperation))
            .keyboardRow(List.of(priorityAndStaplesInConditions))
            .keyboardRow(List.of(nestedConditions))
            .keyboardRow(List.of(threeOperator))
            .keyboardRow(List.of(commentsInCode))
            .keyboardRow(List.of(codeMakeApp))
            .keyboardRow(List.of(practiceWorkModuleTwo))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleThree = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(cycleFor))
            .keyboardRow(List.of(cycleWhileAndDoWhile))
            .keyboardRow(List.of(switchCase))
            .keyboardRow(List.of(difficultCode))
            .keyboardRow(List.of(workLocalRepository))
            .keyboardRow(List.of(practiceWorkModuleThree))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleFour = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(methods))
            .keyboardRow(List.of(parametersMethods))
            .keyboardRow(List.of(returnsValues))
            .keyboardRow(List.of(classAndObjects))
            .keyboardRow(List.of(constructors))
            .keyboardRow(List.of(overloadMethods))
            .keyboardRow(List.of(areaVisibility))
            .keyboardRow(List.of(practiceWorkModuleFour))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleFive = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(encapsulation))
            .keyboardRow(List.of(pojo))
            .keyboardRow(List.of(immutable))
            .keyboardRow(List.of(linkOrValue))
            .keyboardRow(List.of(copyObjects))
            .keyboardRow(List.of(practiceWorkModuleFive))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleSix = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(staticVariables))
            .keyboardRow(List.of(staticMethods))
            .keyboardRow(List.of(constants))
            .keyboardRow(List.of(enumTopic))
            .keyboardRow(List.of(staticInitialization))
            .keyboardRow(List.of(practiceWorkModuleSix))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleSeven = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(primitivesAndObjects))
            .keyboardRow(List.of(typesOfPrimitives))
            .keyboardRow(List.of(bitsAndBytes))
            .keyboardRow(List.of(numbers))
            .keyboardRow(List.of(symbols))
            .keyboardRow(List.of(wrapperClasses))
            .keyboardRow(List.of(practiceWorkModuleSeven))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleEight = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(operationsWithNumbers))
            .keyboardRow(List.of(incrementAndDecrement))
            .keyboardRow(List.of(updateNumbers))
            .keyboardRow(List.of(endCalculates))
            .keyboardRow(List.of(workWithBigAndEndNumbers))
            .keyboardRow(List.of(dateAndTime))
            .keyboardRow(List.of(timestamp))
            .keyboardRow(List.of(practiceWorkModuleEight))
            .keyboardRow(List.of(back))
            .build();

    private InlineKeyboardMarkup sendModuleNine = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(linesSumAndComparing))
            .keyboardRow(List.of(updateNumberToLinesAndReverse))
            .keyboardRow(List.of(symbolsAndCoding))
            .keyboardRow(List.of(methodsWorkWithLines))
            .keyboardRow(List.of(stringPool))
            .keyboardRow(List.of(regulars))
            .keyboardRow(List.of(practiceWorkModuleNine))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(createArrays))
            .keyboardRow(List.of(workWithArraysInCycles))
            .keyboardRow(List.of(manyArrays))
            .keyboardRow(List.of(classArrays))
            .keyboardRow(List.of(practiceWorkModuleTenArrays))
            .keyboardRow(List.of(list))
            .keyboardRow(List.of(practiceWorkModuleTenList))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleEleven = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(hashSet))
            .keyboardRow(List.of(mechanismWorkHashSet))
            .keyboardRow(List.of(collectionTreeSet))
            .keyboardRow(List.of(redBlackTrees))
            .keyboardRow(List.of(practiceWorkModuleTenSet))
            .keyboardRow(List.of(collectionsHashMapAndTreeMap))
            .keyboardRow(List.of(practiceWorkModuleElevenMap))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwelve = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(choiceSuitableCollection))
            .keyboardRow(List.of(transformationArraysAndCollections))
            .keyboardRow(List.of(iterator))
            .keyboardRow(List.of(classCollections))
            .keyboardRow(List.of(practiceWorkModuleTwelveSearchInCollections))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleThirteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(extendClassJava))
            .keyboardRow(List.of(redefinitionMethods))
            .keyboardRow(List.of(redefinitionStaticMethods))
            .keyboardRow(List.of(classObject))
            .keyboardRow(List.of(modificationAccess))
            .keyboardRow(List.of(practiceWorkModuleThirteenExtend))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleFourteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(abstractClasses))
            .keyboardRow(List.of(interfaces))
            .keyboardRow(List.of(interfacesInJava))
            .keyboardRow(List.of(methodsWithDefaultRealisation))
            .keyboardRow(List.of(polymorphism))
            .keyboardRow(List.of(nestedClasses))
            .keyboardRow(List.of(practiceWorkModuleFourteen))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleFifteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(maven))
            .keyboardRow(List.of(commandMavenAndPlugins))
            .keyboardRow(List.of(gradle))
            .keyboardRow(List.of(installationGradle))
            .keyboardRow(List.of(workWithGradleInIntelliJIDEA))
            .keyboardRow(List.of(docker))
            .keyboardRow(List.of(generatedDocumentJavadoc))
            .keyboardRow(List.of(resultsPassedTopic))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleSixteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(generics))
            .keyboardRow(List.of(functionInterfacesPartOne))
            .keyboardRow(List.of(lambdaExpressions))
            .keyboardRow(List.of(classOptional))
            .keyboardRow(List.of(annotations))
            .keyboardRow(List.of(lombok))
            .keyboardRow(List.of(practiceWorkModuleSixteen))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleSeventeen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(introductionStreamAPI))
            .keyboardRow(List.of(createStream))
            .keyboardRow(List.of(intermediateOperators))
            .keyboardRow(List.of(terminalOperators))
            .keyboardRow(List.of(practiceWorkModuleSeventeen))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleEighteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(exceptionsNeed))
            .keyboardRow(List.of(typeExceptions))
            .keyboardRow(List.of(processingExceptions))
            .keyboardRow(List.of(createOwnExceptions))
            .keyboardRow(List.of(debuggingApp))
            .keyboardRow(List.of(logging))
            .keyboardRow(List.of(practiceWorkModuleEighteen))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleNineteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(classFile))
            .keyboardRow(List.of(readFilesWithHelpFilesInputStream))
            .keyboardRow(List.of(readFilesWithHelpFilesBufferedReader))
            .keyboardRow(List.of(readFilesWithHelpClassFiles))
            .keyboardRow(List.of(writeInFile))
            .keyboardRow(List.of(javaNIOAPI))
            .keyboardRow(List.of(relationFiles))
            .keyboardRow(List.of(structureXMLAndHTMLFiles))
            .keyboardRow(List.of(parsingHTMLFiles))
            .keyboardRow(List.of(formatJSONAndParsingJSONFiles))
            .keyboardRow(List.of(formatJSON))
            .keyboardRow(List.of(configFiles))
            .keyboardRow(List.of(practiceWorkModuleNineteen))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwenty = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(installationMySQL))
            .keyboardRow(List.of(connectionThroughJDBC))
            .keyboardRow(List.of(queryWithoutResultSet))
            .keyboardRow(List.of(hibernateConnectionAndSettings))
            .keyboardRow(List.of(changeInBase))
            .keyboardRow(List.of(connectionOneToMany))
            .keyboardRow(List.of(connectionManyToMany))
            .keyboardRow(List.of(hibernateQueryBuilder))
            .keyboardRow(List.of(lazyDownloadData))
            .keyboardRow(List.of(whereAndOrderBy))
            .keyboardRow(List.of(hql))
            .keyboardRow(List.of(practiceWorkModuleTwentyNumberOne))
            .keyboardRow(List.of(practiceWorkModuleTwentyNumberTwo))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwentyOne = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(protocolHTTPRequestAndResponse))
            .keyboardRow(List.of(methodsHTTPRequestGetAndPOST))
            .keyboardRow(List.of(anotherMethodsHTTPRequest))
            .keyboardRow(List.of(statusCodesHTTPResponse))
            .keyboardRow(List.of(addressNetworkResource))
            .keyboardRow(List.of(restTheoryAndPractice))
            .keyboardRow(List.of(httpHeaders))
            .keyboardRow(List.of(versionsProtocolFTTPAndHTTPS))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwentyTwo = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(acquaintanceWithFrameworkSpring))
            .keyboardRow(List.of(inversionOfControlAndDependencyInjection))
            .keyboardRow(List.of(beanAndLifeCycle))
            .keyboardRow(List.of(controllersAnnotation))
            .keyboardRow(List.of(servicesAnnotationService))
            .keyboardRow(List.of(configurationSpringApp))
            .keyboardRow(List.of(practiceWorkModuleTwentyTwoNumberOne))
            .keyboardRow(List.of(practiceWorkModuleTwentyTwoNumberTwo))
            .keyboardRow(List.of(back))
            .build();
    private InlineKeyboardMarkup sendModuleTwentyThree = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(workWithDataBaseSpringDateJPA))
            .keyboardRow(List.of(connectionToDataBase))
            .keyboardRow(List.of(entityAndRepository))
            .keyboardRow(List.of(connectionBetweenEntity))
            .keyboardRow(List.of(versionationDataBaseLiquibase))
            .keyboardRow(List.of(practiceWorkModuleThreeteen))
            .keyboardRow(List.of(back))
            .build();

//    @Override
//    public String getBotUsername() {
//        return "@ogar_study_java_tg_bot";
//    }
//
//    @Override
//    public String getBotToken() {
//        return "7538872645:AAE-Mm6MFvLB5mMOsq0q_zcwMy8nJQrv-zs";
//    }

    @Override
    public String getBotUsername() {
        return "@study_ogar_tg_bot";
    }

    @Override
    public String getBotToken() {
        return "6555564889:AAHYOcRgwqmbg-iUK8-L4y3KLoxgCIJ1b-0";
    }


    @Override
    public void onUpdateReceived(Update update) {
        buttonTab(update);
        isCommand(update.getMessage());
    }

    public void isCommand(Message message) {
        String text = message.getText();
        if (text.equals("/menu")) {
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
            } else if (data.equals("какие бывают программы")) {
                editMessageText.setText("Какие бывают программы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Какие бывают программы.pdf");
//                    materialForCourse.setName("Какие бывают программы");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Какие бывают программы");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Какие бывают программы(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Какие бывают программы(get DB).pdf");

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

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Веб-приложения. Frontend и backend(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("цели и области применения Java")) {
                editMessageText.setText("Цели и области применения Java");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Цели и области применения Java.pdf");
//                    materialForCourse.setName("Цели и области применения Java");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Цели и области применения Java");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Цели и области применения Java(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Цели и области применения Java(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("как выглядит программный код")) {
                editMessageText.setText("Как выглядит программный код");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Как выглядит программный код.pdf");
//                    materialForCourse.setName("Как выглядит программный код");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Как выглядит программный код");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Как выглядит программный код(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Как выглядит программный код(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("пишем простое приложение")) {
                editMessageText.setText("Пишем простое приложение");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Пишем простое приложение.pdf");
//                    materialForCourse.setName("Пишем простое приложение");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Пишем простое приложение");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Пишем простое приложение(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Пишем простое приложение(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("особенности языка Java")) {
                editMessageText.setText("Особенности языка Java");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Особенности языка Java.pdf");
//                    materialForCourse.setName("Особенности языка Java");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Особенности языка Java");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Особенности языка Java(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Особенности языка Java(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Вводный модуль")) {
                editMessageText.setText("Практическая работа по Вводный модуль");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Практическая работа по Вводный модуль.pdf");
//                    materialForCourse.setName("Практическая работа по Вводный модуль");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Практическая работа по Вводный модуль");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Практическая работа по Вводный модуль(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа по Вводный модуль(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("синтаксис языка, часть 1")) {
                editMessageText.setText("Синтаксис языка, часть 1");
                editMessageReplyMarkup.setReplyMarkup(sendModuleTwo);
            } else if (data.equals("переменные")) {
                editMessageText.setText("Переменные");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Переменные.pdf");
//                    materialForCourse.setName("Переменные");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Переменные");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Переменные(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Переменные(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("условные операторы “if”и “else”")) {
                editMessageText.setText("Условные операторы “if”и “else”");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Условные операторы “if”и “else”.pdf");
//                    materialForCourse.setName("Условные операторы “if”и “else”");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Условные операторы “if”и “else”");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Условные операторы “if”и “else”(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Условные операторы  if и  else (get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("булевы операции")) {
                editMessageText.setText("Булевы операции");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Булевы операции.pdf");
//                    materialForCourse.setName("Булевы операции");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Булевы операции");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Булевы операции(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Булевы операции(get DB).pdff");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("приоритеты и скобки в условиях")) {
                editMessageText.setText("Приоритеты и скобки в условиях");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                  Ниже закоментированный код, нужно раскомментировать для сохранения в БД
//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Приоритеты и скобки в условиях.pdf");
//                    materialForCourse.setName("Приоритеты и скобки в условиях");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Приоритеты и скобки в условиях");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Приоритеты и скобки в условиях(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Приоритеты и скобки в условиях(getDB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("вложенные условия")) {
                editMessageText.setText("Вложенные условия");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Вложенные условия.pdf");
//                    materialForCourse.setName("Вложенные условия");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Вложенные условия");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Вложенные условия(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Вложенные условия(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("тернарный оператор")) {
                editMessageText.setText("Тернарный оператор");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Тернарный оператор.pdf");
//                    materialForCourse.setName("Тернарный оператор");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Тернарный оператор");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Тернарный оператор(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Тернарный оператор(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("комментарии в коде")) {
                editMessageText.setText("Комментарии в коде");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Комментарии в коде.pdf");
//                    materialForCourse.setName("Комментарии в коде");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Комментарии в коде");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Комментарии в коде(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Комментарии в коде(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("разбираем код готового приложения")) {
                editMessageText.setText("Разбираем код готового приложения");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Road-camera.pdf");
//                    materialForCourse.setName("Road-camera");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Road-camera");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Road-camera(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Road-camera(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по с я часть 1")) {
                editMessageText.setText("Практическая работа по Синтаксис языка, часть 1");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Практическая работа по Синтаксис языка часть 1.pdf");
//                    materialForCourse.setName("Практическая работа по Синтаксис языка часть 1");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Практическая работа по Синтаксис языка часть 1");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Практическая работа по Синтаксис языка часть 1(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа по Синтаксис языка часть 1(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("синтаксис языка, часть 2")) {
                editMessageText.setText("Синтаксис языка, часть 2");
                editMessageReplyMarkup.setReplyMarkup(sendModuleThree);
            } else if (data.equals("цикл “for”")) {
                editMessageText.setText("Цикл “for”");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Цикл “for”.pdf");
//                    materialForCourse.setName("Цикл “for”");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Цикл “for”");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Цикл “for”(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Цикл “for”(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("циклы “while” и “do while”")) {
                editMessageText.setText("Циклы “while” и “do while”");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Циклы “while” и “do while”.pdf");
//                    materialForCourse.setName("Циклы “while” и “do while”");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Циклы “while” и “do while”");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Циклы “while” и “do while”(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Циклы “while” и “do while”(get DB).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("оператор switch case")) {
                editMessageText.setText("Оператор switch case");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Оператор “switch case”.pdf");
//                    materialForCourse.setName(Оператор “switch case”");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Оператор “switch case”");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Оператор “switch case”(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Оператор “switch case”(get DB).pdf")));

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Оператор switch case.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("разбираем сложный код")) {
                editMessageText.setText("Разбираем сложный код");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Разбираем сложный код.pdf");
//                    materialForCourse.setName(Разбираем сложный код");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Разбираем сложный код");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Разбираем сложный код(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Разбираем сложный код(get DB).pdf")));

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Разбираем сложный код.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("работа с локальным репозиторием")) {
                editMessageText.setText("Работа с локальным репозиторием");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Работа с локальным репозиторием.pdf");
//                    materialForCourse.setName(Работа с локальным репозиторием");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Работа с локальным репозиторием");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Работа с локальным репозиторием(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Работа с локальным репозиторием(get DB).pdf")));

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Работа с локальным репозиторием.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по с я часть 2")) {
                editMessageText.setText("Практическая работа по Синтаксис языка, часть 2");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Практическая работа по Синтаксис языка, часть 2.pdf");
//                    materialForCourse.setName(Практическая работа по Синтаксис языка, часть 2");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Практическая работа по Синтаксис языка, часть 2");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Практическая работа по Синтаксис языка, часть 2(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Практическая работа по Синтаксис языка, часть 2(get DB).pdf")));

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа по Синтаксис языка, часть 2.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("методы и классы")) {
                editMessageText.setText("Методы и классы");
                editMessageReplyMarkup.setReplyMarkup(sendModuleFour);
            } else if (data.equals("методы")) {
                editMessageText.setText("Методы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Методы.pdf");
//                    materialForCourse.setName(Методы");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Методы");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Методы(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Методы(get DB).pdf")));

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
//                    File pdfFile = new File("Параметры методов.pdf");
//                    materialForCourse.setName(Параметры методов");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Параметры методов");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Параметры методов(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Параметры методов(get DB).pdf")));

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
//                    File pdfFile = new File("Возвращаемые значения.pdf");
//                    materialForCourse.setName(Возвращаемые значения");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Возвращаемые значения");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Возвращаемые значения(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Возвращаемые значения(get DB).pdf")));

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
//                    File pdfFile = new File("Классы и объекты.pdf");
//                    materialForCourse.setName(Классы и объекты");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Классы и объекты");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Классы и объекты(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Классы и объекты(get DB).pdf")));

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
//                    File pdfFile = new File("Конструкторы.pdf");
//                    materialForCourse.setName("Конструкторы");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Конструкторы");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Конструкторы(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Конструкторы(get DB).pdf")));

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
//                    File pdfFile = new File("Перегрузка методов.pdf");
//                    materialForCourse.setName("Перегрузка методов");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Перегрузка методов");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Перегрузка методов(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Перегрузка методов(get DB).pdf")));

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
//                    File pdfFile = new File("Области видимости.pdf");
//                    materialForCourse.setName("Области видимости");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Области видимости");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Области видимости(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Области видимости(get DB).pdf")));

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Области видимости.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Методы и классы")) {
                editMessageText.setText("Практическая работа по Методы и классы");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Практическая работа по Методы и классы.pdf");
//                    materialForCourse.setName("Практическая работа по Методы и классы");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "ППрактическая работа по Методы и классы");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Практическая работа по Методы и классы(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Практическая работа по Методы и классы(get DB).pdf")));
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа по Методы и классы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("инкапсуляция")) {
                editMessageText.setText("Инкапсуляция");
                editMessageReplyMarkup.setReplyMarkup(sendModuleFive);
            } else if (data.equals("POJO-классы, гет и сет")) {
                editMessageText.setText("POJO-классы, геттеры и сеттеры");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("POJO-классы, геттеры и сеттеры.pdf");
//                    materialForCourse.setName("POJO-классы, геттеры и сеттеры");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "POJO-классы, геттеры и сеттеры");
//                    FileOutputStream fileOutputStream = new FileOutputStream("POJO-классы, геттеры и сеттеры(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("POJO-классы, геттеры и сеттеры(get DB).pdf")));

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
//                    File pdfFile = new File("Immutable-классы.pdf");
//                    materialForCourse.setName("Immutable-классы");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Immutable-классы");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Immutable-классы(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Immutable-классы(get DB).pdf")));

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Immutable-классы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("ссылка или значение")) {
                editMessageText.setText("Ссылка или значение");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Передача по ссылке или по значению.pdf");
//                    materialForCourse.setName("Передача по ссылке или по значению");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Передача по ссылке или по значению");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Передача по ссылке или по значению(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Передача по ссылке или по значению(get DB).pdf")));

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
//                    File pdfFile = new File("Копирование объектов.pdf");
//                    materialForCourse.setName("Копирование объектов");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Копирование объектов");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Копирование объектов(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Копирование объектов(get DB).pdf")));

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Копирование объектов.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Инкапсуляция")) {
                editMessageText.setText("Практическая работа по Инкапсуляция");

                try {
                    //alter table materials_for_courses modify column file_data longblob;

//                    MaterialForCourse materialForCourse = new MaterialForCourse();
//                    File pdfFile = new File("Практическая работа по Инкапсуляция.pdf");
//                    materialForCourse.setName("Практическая работа по Инкапсуляция");
//                    byte[] fileData = Files.readAllBytes(pdfFile.toPath());
//                    materialForCourse.setFileData(fileData);
//                    session.save(materialForCourse);
//
//
//                    MaterialForCourse getMaterialForCourse = session.get(MaterialForCourse.class, "Практическая работа по Инкапсуляция");
//                    FileOutputStream fileOutputStream = new FileOutputStream("Практическая работа по Инкапсуляция(get DB).pdf");
//                    fileOutputStream.write(getMaterialForCourse.getFileData());

                    //Ниже раскомментировать при работе с БД
                    //sendDocument.setDocument(new InputFile(new File("Практическая работа по Инкапсуляция(get DB).pdf")));

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа по Инкапсуляция.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("static, константы и enum")) {
                editMessageText.setText("Static, константы и enum");
                editMessageReplyMarkup.setReplyMarkup(sendModuleSix);
            } else if (data.equals("cтатические переменные")) {
                editMessageText.setText("Cтатические переменные");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Статические переменные.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("cтатические методы")) {
                editMessageText.setText("Cтатические методы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Статические методы.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("константы")) {
                editMessageText.setText("Константы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Константы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("enum")) {
                editMessageText.setText("Enum");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Enum.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("cтатическая инициализация")) {
                editMessageText.setText("Статическая инициализация");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Статическая инициализация.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по static, константы и enum")) {
                editMessageText.setText("Практическая работа по Static, константы и enum");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа по Static, константы и enum.pdf");

                    execute(sendDocument);
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("примитивы")) {
                editMessageText.setText("Примитивы");
                editMessageReplyMarkup.setReplyMarkup(sendModuleSeven);
            } else if (data.equals("примитивы и объекты")) {
                editMessageText.setText("Примитивы и объекты");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Примитивы и объекты.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("виды примитивов")) {
                editMessageText.setText("Виды примитивов");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Виды примитивов.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("биты и байты")) {
                editMessageText.setText("Биты и байты");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Биты и байты.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("числа")) {
                editMessageText.setText("Числа");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Числа.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("символы")) {
                editMessageText.setText("Символы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Символы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("классы-обертки")) {
                editMessageText.setText("Классы-обертки");
                try {

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Классы-обертки.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Примитивам")) {
                editMessageText.setText("Практическая работа по Примитивам");
                try {

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа по Примитивам.pdf");

                    execute(sendDocument);
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("числа и даты")) {
                editMessageText.setText("Числа и даты");
                editMessageReplyMarkup.setReplyMarkup(sendModuleEight);
            } else if (data.equals("операции с числами")) {
                editMessageText.setText("Операции с числами");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Операции с числами.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("инкремент и декремент")) {
                editMessageText.setText("Инкремент и декремент");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Инкремент и декремент.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("преобразование(приведение) чисел")) {
                editMessageText.setText("Преобразование (приведение) чисел");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Преобразование (приведение).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("точность вычислений")) {
                editMessageText.setText("Точность вычислений");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект. Точность вычислений.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("работа с б и т числами")) {
                editMessageText.setText("Работа с большими и точными числами");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект. Работа с большими и точными числами.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("дата и время")) {
                editMessageText.setText("Дата и время");
                try {

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект. Дата и время.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("timestamp")) {
                editMessageText.setText("Метка времени (timestamp)");
                try {

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект. Метка времени (timestamp).pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Числа и даты")) {
                editMessageText.setText("Практическая работа по Числа и даты");
                try {

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа по Числа и даты.docx");

                    execute(sendDocument);
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("строки")) {
                editMessageText.setText("Строки");
                editMessageReplyMarkup.setReplyMarkup(sendModuleNine);
            } else if (data.equals("строки, к и с")) {
                editMessageText.setText("Строки, конкатенация и сравнение");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект Строки, конкатенация и сравнение.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("преобразование ч в с и о")) {
                editMessageText.setText("Преобразование чисел в строки и обратно");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект Преобразование чисел в строки и обратно.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("символы и кодировки")) {
                editMessageText.setText("Символы и кодировки");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Символы и кодировки.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("методы работы с подс")) {
                editMessageText.setText("Методы работы с подстроками");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект Методы работы с подстроками.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("string Pool")) {
                editMessageText.setText("String Pool");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект. String Pool.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("регулярные выражения")) {
                editMessageText.setText("Регулярные выражения");
                try {

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Регулярные выражения.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Строки")) {
                editMessageText.setText("Практическая работа по Строкам");
                try {

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа по Строки.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("массивы и списки")) {
                editMessageText.setText("Массивы и списки");
                editMessageReplyMarkup.setReplyMarkup(sendModuleTen);
            } else if (data.equals("создание массивов")) {
                editMessageText.setText("Создание массивов");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Создание массивов.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("работа с м в циклах")) {
                editMessageText.setText("Работа с массивами в циклах");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Работа с массивами в циклах.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("многомерные массивы")) {
                editMessageText.setText("Многомерные массивы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Многомерные массивы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("класс Arrays")) {
                editMessageText.setText("Класс Arrays");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Класс Arrays.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Массивы")) {
                editMessageText.setText("Практическая работа. Массивы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Массивы.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("списки")) {
                editMessageText.setText("Списки");
                try {

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Списки.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Списки")) {
                editMessageText.setText("Практическая работа. Списки List");
                try {

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Списки   List.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("коллекции Set, Map")) {
                editMessageText.setText("Коллекции Set, Map");
                editMessageReplyMarkup.setReplyMarkup(sendModuleEleven);
            } else if (data.equals("коллекция HashSet")) {
                editMessageText.setText("Коллекция HashSet");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Коллекция HashSet.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("м р HashSet")) {
                editMessageText.setText("Механизм работы HashSet");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Механизм работы HashSet.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("коллекция TreeSet")) {
                editMessageText.setText("Коллекция TreeSet");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Коллекция TreeSet.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("к-ч деревья")) {
                editMessageText.setText("Красно-черные деревья");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Красно-черные деревья.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Множества Set")) {
                editMessageText.setText("Практическая работа Множества Set");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа Множества Set.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("к HashMap и TreeMap")) {
                editMessageText.setText("Коллекции HashMap и TreeMap");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Коллекции HashMap и TreeMap.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Map")) {
                editMessageText.setText("Практическая работа. Map");
                try {

                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Map.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("c i Collections")) {
                editMessageText.setText("Comparator iterator Collections");
                editMessageReplyMarkup.setReplyMarkup(sendModuleTwelve);
            } else if (data.equals("выбор п к")) {
                editMessageText.setText("Выбор подходящей коллекции");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Выбор подходящей коллекции.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("преобразование м и к")) {
                editMessageText.setText("Преобразование массивов и коллекций");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Преобразование массивов и коллекций.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("итератор")) {
                editMessageText.setText("Итератор");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Итератор.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("класс Collections")) {
                editMessageText.setText("Класс Collections");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Класс Collections.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Поиск в коллекциях")) {
                editMessageText.setText("Практическая работа. Поиск в коллекциях");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Поиск в коллекциях.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("наследование")) {
                editMessageText.setText("Наследование");
                editMessageReplyMarkup.setReplyMarkup(sendModuleThirteen);
            } else if (data.equals("наследование классов Java")) {
                editMessageText.setText("Наследование классов Java");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект. Наследование классов Java.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("переопределение методов")) {
                editMessageText.setText("Переопределение методов");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект. Переопределение методов.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("переопределение с методов")) {
                editMessageText.setText("Переопределение статических методов");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект. Переопределение статических методов.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("класс Object")) {
                editMessageText.setText("Класс Object");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект. Класс Objec.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("модификаторы доступа")) {
                editMessageText.setText("Модификаторы доступа");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Конспект. Модификаторы доступа.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по Наследование")) {
                    editMessageText.setText("Практическая работа. Наследование");
                    try {
                        SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Наследование.docx");

                        execute(sendDocument);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
            } else if (data.equals("абстрактные классы и интерфейсы")) {
                editMessageText.setText("Абстрактные классы и интерфейсы");
                editMessageReplyMarkup.setReplyMarkup(sendModuleFourteen);
            } else if (data.equals("абстрактные классы")) {
                editMessageText.setText("Абстрактные классы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Абстрактные классы.docx");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("интерфейсы")) {
                editMessageText.setText("Интерфейсы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Интерфейсы.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("интерфейсы в языке Java")) {
                editMessageText.setText("интерфейсы в языке Java");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Интерфейсы в языке Java.docx");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("методы с д р в и")) {
                editMessageText.setText("Методы с дефолтной реализацией в интерфейсах");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Методы с дефолтной реализацией в интерфейсах.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("полиморфизм")) {
                editMessageText.setText("Полиморфизм");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Полиморфизм.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("вложенные классы")) {
                editMessageText.setText("Вложенные классы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Вложенные классы.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по А к и интерфейсы")) {
                editMessageText.setText("Практическая работа. Абстрактные классы и интерфейсы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Абстрактные классы и интерфейсы.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("deployment")) {
                editMessageText.setText("Deployment");
                editMessageReplyMarkup.setReplyMarkup(sendModuleFifteen);
            } else if (data.equals("maven")) {
                editMessageText.setText("Maven");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Maven.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("к Maven. Плагины")) {
                editMessageText.setText("Команды Maven. Плагины");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Команды Maven. Плагины.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("система автоматической сборки Gradle")) {
                editMessageText.setText("Система автоматической сборки Gradle");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Система автоматической сборки Gradle.docx");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("установка с Gradle")) {
                editMessageText.setText("Установка системы Gradle");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Установка системы Gradle.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("р с Gradle в I I")) {
                editMessageText.setText("Работа с Gradle в IntelliJ IDEA");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Работа с Gradle в IntelliJ IDEA.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("docker")) {
                editMessageText.setText("Docker");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Docker.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("г д Javadoc")) {
                editMessageText.setText("Генерация документации Javadoc");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Генерация документации Javadoc.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("итоги пройденных тем")) {
                editMessageText.setText("Итоги пройденных тем");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Итоги пройденных тем.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("ф п в Java.ч.1")) {
                editMessageText.setText("Функциональное програмирование в Java. Ч. 1");
                editMessageReplyMarkup.setReplyMarkup(sendModuleSixteen);
            } else if (data.equals("дженерики")) {
                editMessageText.setText("Дженерики");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Дженерики.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("ф и. Часть 1")) {
                editMessageText.setText("Функциональные интерфейсы. Часть 1");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Функциональные интерфейсы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("лямбда-выражения")) {
                editMessageText.setText("Лямбда-выражения");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Лямбда-выражения.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("класс Optional")) {
                editMessageText.setText("Класс Optional");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Класс Optional.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("аннотации")) {
                editMessageText.setText("Аннотации");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Аннотации.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("lombok")) {
                editMessageText.setText("Lombok");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Lombok.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по ф и. Часть 1")) {
                editMessageText.setText("Практическая работа. Функциональное программирование в Java. Часть 1");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Функциональное программирование в Java. Часть 1.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("ф п в Java.ч.2.Stream API")) {
                editMessageText.setText("Функциональное програмирование в Java. Ч. 2. Stream API");
                editMessageReplyMarkup.setReplyMarkup(sendModuleSeventeen);
            } else if (data.equals("в в Stream API")) {
                editMessageText.setText("Введение в Stream API");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Введение в Stream AP.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("создание Stream")) {
                editMessageText.setText("Создание Stream");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Создание Stream.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("промежуточные операторы")) {
                editMessageText.setText("Промежуточные операторы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Промежуточные операторы.pdf");
                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("терминальные операторы")) {
                editMessageText.setText("Терминальные операторы");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Терминальные операторы.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("p, r и к операторов")) {
                editMessageText.setText("Parallel, reduce и комбинирование операторов");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Parallel, reduce и комбинирование операторов.pdf");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("п Р по ф и. Ч 2. S API")) {
                editMessageText.setText("Практическая работа. Функциональное програмирование в Java. Ч. 2. Stream API");
                try {
                    SendDocument sendDocument = serviceBotImages.createSendDocument(idUser, "Практическая работа. Функциональное программирование в Java. Часть 2. Stream API.docx");

                    execute(sendDocument);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (data.equals("исключение, отладка и логирование")) {
                editMessageText.setText("Исключение, отладка и логирование");
                editMessageReplyMarkup.setReplyMarkup(sendModuleEighteen);
            } else if (data.equals("работа с файлами и сетью")) {
                editMessageText.setText("Работа с файлами и сетью");
                editMessageReplyMarkup.setReplyMarkup(sendModuleNineteen);
            } else if (data.equals("работа с MySQL в Java")) {
                editMessageText.setText("Работа с MySQL в Java");//
                editMessageReplyMarkup.setReplyMarkup(sendModuleTwenty);
            } else if (data.equals("протокол HTTP")) {
                editMessageText.setText("Протокол HTTP");
                editMessageReplyMarkup.setReplyMarkup(sendModuleTwentyOne);
            } else if (data.equals("разработка веб-приложения. Ч. 1")) {
                editMessageText.setText("Разработка веб-приложения. Ч. 1");
                editMessageReplyMarkup.setReplyMarkup(sendModuleTwentyTwo);
            } else if (data.equals("разработка веб-приложения. Ч. 2")) {
                editMessageText.setText("Разработка веб-приложения. Ч. 2");
                editMessageReplyMarkup.setReplyMarkup(sendModuleTwentyThree);
            }

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
            else if (data.equals("назад")) {
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
