package com.example.server.services;


import com.example.server.models.Person;
import com.example.server.repo.PersonRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonService {

    @Autowired
    private EntityManager entityManager;

    CriteriaBuilder criteriaBuilder;
    CriteriaQuery<Person> criteriaQuery;
    Root<Person> root;
    Predicate predicate;

    @Autowired
    private PersonRepo personRepo;

    public void addPerson(Person p) {
        personRepo.save(p);
    }

    public List<Person> getList(String param) {
        if (param.equals("all")) {
            return personRepo.findAll();
        } else {
            // Получаем объект CriteriaBuilder, который используется для создания критериев
            criteriaBuilder = entityManager.getCriteriaBuilder();

            // Создаем объект CriteriaQuery, который будет использоваться для построения запроса
            criteriaQuery = criteriaBuilder.createQuery(Person.class);

            // Создаем корневой объект, который представляет тип данных, по которым мы хотим выполнить запрос
            root = criteriaQuery.from(Person.class);
            // Создаем условие для выборки записей
            // В данном случае мы выбираем записи, у которых поле "name" равно "John" и поле "email" равно "john@example.com"
            predicate = criteriaBuilder.and(
                    criteriaBuilder.equal(root.get("profession"), param)
            );

            // Добавляем условие в запрос
            criteriaQuery.where(predicate);

            // Выполняем запрос и получаем результат
            return entityManager.createQuery(criteriaQuery).getResultList();
        }
    }
}
