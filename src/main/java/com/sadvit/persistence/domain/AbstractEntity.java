package com.sadvit.persistence.domain;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Метод устанавливает поля переданного обьекта в поля текущего.
     * @param object преобразуется в нужный тип
     */
    public abstract void exchange(Object object);

}