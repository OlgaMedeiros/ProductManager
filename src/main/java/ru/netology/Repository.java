package ru.netology;


public class Repository {
    private Product[] products = new Product[0];  //изначально в массиве Product 0 ячеек

    public Product[] findAll() {
        return products;
    }

    public void save(Product product) {         // сохраняем продукты
        Product[] tmp = new Product[products.length + 1];   //временный массив с длиной на одну ячейку больше, чем в Product
        for (int i = 0; i < products.length; i++) {   //цикл
            tmp[i] = products[i];  //присваиваем ячейке tmp product

        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void removeByID(int id) {   //удаляем продукт по Id
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
            products = tmp;
        }
    }

    public Product[] findById(int id) {
        for (Product item : products) {
            if (item.getId() == id) {
                return new Product[]{item};
            }
        }
        return null;
    }
}

