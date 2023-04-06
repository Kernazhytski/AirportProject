package com.example.server.services;


import com.example.server.DTO.person.PersonNameProfession;
import com.example.server.models.Person;
import com.example.server.repo.PersonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonService {
    @Autowired
    private EntityManager entityManager;

    CriteriaBuilder criteriaBuilder;
    CriteriaQuery<Person> criteriaQuery;
    Root<Person> root;
    Predicate predicate;

    List<Person> responceList;

    @Autowired
    private PersonRepo personRepo;

    public void addPerson(Person p) {
        personRepo.save(p);
    }

    public List<?> getList(String param, String fields) {

        if (param.equals("all")) {
            responceList = personRepo.findAll();
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
            responceList = entityManager.createQuery(criteriaQuery).getResultList();
        }
        switch (fields) {
            case "NameProfession":
                System.out.println(Arrays.toString(responceList.toArray()));
                List<PersonNameProfession> personNameProfessions = responceList.stream().map(p -> new PersonNameProfession(
                                p.getId(),
                                p.getFirstName(),
                                p.getSecondName(),
                                p.getProfession()))
                        .collect(Collectors.toList());
                System.out.println(Arrays.toString(personNameProfessions.toArray()));
                return personNameProfessions;
            default:
                return responceList;
        }

    }
}
