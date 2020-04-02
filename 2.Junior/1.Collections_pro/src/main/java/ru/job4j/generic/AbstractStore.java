package ru.job4j.generic;

/**
 * Сделать интерфейс Store<T extends Base>,
 * где Base - это абстрактный класс для моделей c методами String getId();
 * Пример приведен выше.
 * <p>
 * 1. Сделать два класса User, и Role, которые наследуют Base класс.
 * 2. Сделать два класса хранилища UserStore и RoleStore. Внутри для хранения данных использовать SimpleArray.
 * 3. Помните. про инкапсуляцию. Вам нельзя изменять интерфейс Store. Например. replace(int index,  T model) - нельзя делать. Так как мы изменили входящий параметр.
 * <p>
 * 4. После реализации проверьте можно ли избавиться от дублирования кода в вашем проекте. UserStore и RoleStore будут иметь один и тот же функционал. Общий для них функционал необходимо вынести в абстрактный класс AbstractStore.
 * <p>
 * 5. Помните, что хранилище должны быть жестко ограничены хранимым типом. Например для UserStore тип хранимых данных должен быть User.
 *
 * @param <T>
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> container;

    public AbstractStore(int size) {
        this.container = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        this.container.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = 0;
        for (T current : this.container) {
            if (id.equals(current.getId())) {
                this.container.set(index, model);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = 0;
        for (T current : this.container) {
            if (id.equals(current.getId())) {
                this.container.remove(index);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T current : this.container) {
            if (id.equals(current.getId())) {
                result = current;
                break;
            }
        }
        return result;
    }
}
