package com.ulegal.authservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ulegal.authservice.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author secdn
 * @create 2018-08-22
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String value;

    @JsonIgnore
    @ManyToMany(targetEntity =Authority.class,fetch = FetchType.EAGER)
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();

}
