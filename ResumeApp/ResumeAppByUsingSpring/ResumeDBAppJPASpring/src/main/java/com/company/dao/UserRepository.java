/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SRSHD
 */
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom{
    
}
