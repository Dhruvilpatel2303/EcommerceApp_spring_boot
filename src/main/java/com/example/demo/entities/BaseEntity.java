package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @CreatedDate
    @Column(nullable = false,updatable = false)
    private Instant created_at;


    @LastModifiedDate
    @Column(nullable = false)
    private Instant updated_at;


    @PrePersist
    public void onCreate(){
        Instant now= Instant.now();
        this.created_at=now;
        this.updated_at=now;
    }


    @PreUpdate

    public void onUpdate(){
        this.updated_at=Instant.now();
    }
}
