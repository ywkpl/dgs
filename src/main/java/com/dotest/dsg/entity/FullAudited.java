package com.dotest.dsg.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class FullAudited implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private Date creationTime;
    @Column(updatable = false)
    private Long creatorUserId;
    private Date lastModificationTime;
    private Long lastModifierUserId;

    @PrePersist
    protected void onCreate() {
        if (creationTime == null) {
            creationTime = new Date();
        }
    }
    @Column(columnDefinition = "bit default 0")
    @Builder.Default
    private Boolean isDeleted=false;
    private Long deleterUserId;
    public Date deletionTime;
}
