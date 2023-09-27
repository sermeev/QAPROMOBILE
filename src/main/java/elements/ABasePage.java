package elements;

import com.codeborne.selenide.Selenide;

public abstract class ABasePage<T> {
    public T open() {
        Selenide.open();
        return (T) this;
    }
}
