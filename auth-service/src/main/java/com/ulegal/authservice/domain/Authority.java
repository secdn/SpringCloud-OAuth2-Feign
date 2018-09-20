package com.ulegal.authservice.domain;

import com.ulegal.authservice.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author secdn
 * @create 2018-08-22
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Authority extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String value;
}
