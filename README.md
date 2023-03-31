Вам необходимо реализовать менеджер товаров, который умеет:

добавлять товары в репозиторий,
искать товары.
Что нужно сделать:

Разработайте базовый класс Product, содержащий ID, название, стоимость.
Разработайте два унаследованных от Product класса: Book с текстовыми полями «название» и «автор» и Smartphone с текстовыми полями «название» и «производитель»; общие поля вынесите в родителя.
Разработайте репозиторий, позволяющий сохранять Product, получать все сохранённые Product и удалять по ID. Для этого репозиторий будет хранить у себя поле с типом Product[] (массив товаров).
Разработайте менеджера, который умеет добавлять Product в репозиторий и осуществлять поиск по ним. Для этого вам нужно создать класс, конструктор которого будет принимать параметром репозиторий, а также с методом publiс void add(Product product) и методом поиска (см. ниже).
Как осуществлять поиск
У менеджера должен быть метод searchBy(String text), который возвращает массив найденных товаров.

public class ProductManager {
  // добавьте необходимые поля, конструкторы и методы

  public Product[] searchBy(String text) {
    Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
    for (Product product: repository.findAll()) {
      if (matches(product, text)) {
        // "добавляем в конец" массива result продукт product
      }
    }
    return result;
  }

  // метод определения соответствия товара product запросу search
  public boolean matches(Product product, String search) {
    if (product.getName().contains(search)) {
      return true;
    } else {
      return false;
    }
    // или в одну строку:
    // return product.getName().contains(search);
  }
}

Менеджер при переборе всех продуктов, хранящихся в репозитории, должен для каждого продукта вызывать определённый в классе менеджера же метод matches, который проверяет, соответствует ли продукт поисковому запросу.

При проверке на соответствие запросу товара мы проверяем вхождение запроса в текст названия товара.

Напишите тесты на менеджер и репозиторий, добившись 100% покрытия по бранчам методов с логикой.

Итого: отправьте на проверку ссылку на репозиторий GitHub с вашим проектом.
