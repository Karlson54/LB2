# Керування бібліотекою

## Опис програми

Ця програма розроблена для ефективного керування бібліотекою та обліку її ресурсів. Головна мета програми - надати зручний інтерфейс для додавання, видачі та повернення книг та DVD-дисків, а також реєстрації читачів бібліотеки.

## Опис роботи програми

Програма складається з наступних ключових сутностей:

### **Item (Предмет)**

- `getTitle()`: Повертає назву предмету.
- `getUniqueID()`: Повертає унікальний ідентифікатор предмету.
- `isBorrowed()`: Повертає стан предмету (взятий чи ні).
- `borrowItem()`: Позначає предмет як взятий.
- `returnItem()`: Позначає предмет як повернутий в бібліотеку.
- `abstract void borrowItem(Patron patron)`: Абстрактний метод для видачі предмету читачу.
- `abstract void returnItem(Patron patron)`: Абстрактний метод для повернення предмету в бібліотеку.

### **Library (Бібліотека)**

- `registerPatron(Patron patron)`: Реєстрація нового читача в бібліотеці.
- `lendItem(Patron patron, Item item)`: Видача предмету читачу.
- `returnItem(Patron patron, Item item)`: Повернення предмету в бібліотеку.
- `add(Item item)`: Додавання предмету до колекції бібліотеки.
- `remove(Item item)`: Видалення предмету з колекції бібліотеки.
- `listAvailable()`: Виведення списку доступних для видачі предметів.
- `listBorrowed()`: Виведення списку взятих читачами предметів.

### **Patron (Читач)**

- `borrow(Item item)`: Взяття предмету на руки читачем.
- `returnItem(Item item)`: Повернення предмету в бібліотеку.

## Перевірені сценарії

1. **Додавання предметів**: Перевірка можливості додавання книг і DVD-дисків до колекції бібліотеки.

2. **Додавання читачів**: Перевірка реєстрації нових читачів в бібліотеці.

3. **Видача і повернення предметів**: Перевірка видачі і повернення книг та DVD-дисків читачам, а також зміни стану предметів після видачі та повернення.

4. **Відображення доступних предметів**: Перевірка виведення на екран списку доступних для видачі предметів.

5. **Відображення взятих предметів**: Перевірка виведення на екран списку предметів, взятих читачами.

6. **Невдалий спроби взяти вже взятий предмет**: Перевірка системи, яка не дозволяє читачам взяти вже взятий предмет.

Після виконання цих перевірених сценаріїв можна бути впевненим, що програма працює правильно і відповідає своїм основним функціям.

## Аналіз Тестів

Програма була протестована за допомогою низки автоматизованих тестів для перевірки її коректності та надійності. Основні перевірені сценарії включають:

1. **Додавання предметів**:
    - *Опис*: Тест перевіряє можливість додавання книг і DVD-дисків до колекції бібліотеки. Впевнюємось, що предмети додаються до бібліотеки.

2. **Додавання читачів**:
    - *Опис*: Тест перевіряє правильність реєстрації нових читачів в бібліотеці. Впевнюємось, що читачі коректно реєструються.

3. **Видача і повернення предметів**:
    - *Опис*: Тест перевіряє, чи правильно видаються та повертаються книги та DVD-диски читачами, а також, чи змінюється стан предметів після видачі та повернення.

4. **Відображення доступних предметів**:
    - *Опис*: Тест перевіряє правильність виведення на екран списку доступних для видачі предметів. Впевнюємось, що вивід коректний.

5. **Відображення взятих предметів**:
    - *Опис*: Тест перевіряє правильність виведення на екран списку предметів, взятих читачами. Впевнюємось, що вивід коректний.

6. **Невдалий спроби взяти вже взятий предмет**:
    - *Опис*: Тест перевіряє систему на наявність обмежень, які не дозволяють читачам взяти вже взятий предмет. Впевнюємось, що такі спроби обмежені.

Ці тести допомагають забезпечити коректну роботу програми та переконатися в її надійності та стабільності. Якщо виникають помилки або проблеми, вони можуть бути виявлені та виправлені під час тестування.
