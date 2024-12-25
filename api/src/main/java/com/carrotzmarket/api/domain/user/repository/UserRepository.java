package com.carrotzmarket.api.domain.user.repository;

import com.carrotzmarket.db.region.RegionEntity;
import com.carrotzmarket.db.user.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository{

    @PersistenceContext
    private final EntityManager em;

    public UserEntity save(UserEntity userEntity) {
        UserEntity managedUser = em.merge(userEntity);
        em.flush();
        System.out.println("Saved UserEntity: " + managedUser);
        System.out.println("Entity after flush: " + managedUser);
        System.out.println("Entity contained in persistence context: " + em.contains(managedUser));
        UserEntity persistedUser = em.find(UserEntity.class, managedUser.getId());
        System.out.println("Entity from DB after flush: " + persistedUser);
        return managedUser;
    }

    public UserEntity saveAndFlush(UserEntity userEntity) {
        UserEntity managedUser = em.merge(userEntity);
        save(userEntity);
        em.flush();
        System.out.println("Saved UserEntity: " + managedUser);
        System.out.println("Entity after flush: " + managedUser);
        System.out.println("Entity contained in persistence context: " + em.contains(managedUser));
        UserEntity persistedUser = em.find(UserEntity.class, managedUser.getId());
        System.out.println("Entity from DB after flush: " + persistedUser);
        em.detach(userEntity);
        return userEntity;
    }

    public Optional<RegionEntity> findRegionById(Long regionid){
        RegionEntity region = em.find(RegionEntity.class, regionid);
        return Optional.ofNullable(region);
    }

    public Optional<UserEntity> findByLoginId(String loginId) {
        return em.createQuery("SELECT u FROM UserEntity u WHERE u.loginId = :loginId", UserEntity.class)
                .setParameter("loginId", loginId)
                .getResultStream()
                .findFirst();
    }

    public void deleteUserRegionsByUserId(Long userId) {
        em.createQuery("DELETE FROM UserRegionEntity ur WHERE ur.user.id = :userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }

    public void deleteByLoginId(String loginId) {
        UserEntity user = em.createQuery("SELECT u FROM UserEntity u WHERE u.loginId = :loginId", UserEntity.class)
                .setParameter("loginId", loginId)
                .getSingleResult();

        deleteUserRegionsByUserId(user.getId());
        em.remove(user);
    }

    public Optional<UserEntity> findById(Long id) {
        return Optional.ofNullable(em.find(UserEntity.class, id));
    }
}

