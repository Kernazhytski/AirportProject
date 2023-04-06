package com.example.server.services;

import com.example.server.models.Vehicle;
import com.example.server.repo.VehicleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private EntityManager entityManager;

    CriteriaBuilder criteriaBuilder;
    CriteriaQuery<Vehicle> criteriaQuery;
    Root<Vehicle> root;
    Predicate predicate;

    public void addVehicle(Vehicle vehicle) {
        vehicleRepo.save(vehicle);
    }

    public List<Vehicle> getList(String type) {
        if (type.equals("all")) {
            return vehicleRepo.findAll();
        } else {
            criteriaBuilder = entityManager.getCriteriaBuilder();

            // Создаем объект CriteriaQuery, который будет использоваться для построения запроса
            criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);

            // Создаем корневой объект, который представляет тип данных, по которым мы хотим выполнить запрос
            root = criteriaQuery.from(Vehicle.class);
            // Создаем условие для выборки записей
            // В данном случае мы выбираем записи, у которых поле "name" равно "John" и поле "email" равно "john@example.com"
            predicate = criteriaBuilder.and(
                    criteriaBuilder.equal(root.get("type"), type)
            );

            // Добавляем условие в запрос
            criteriaQuery.where(predicate);

            // Выполняем запрос и получаем результат
            return entityManager.createQuery(criteriaQuery).getResultList();
        }
    }
}
