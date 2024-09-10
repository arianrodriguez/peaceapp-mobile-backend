package com.upc.pre.peaceapp.models;

import com.upc.pre.peaceapp.shared.documentation.models.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "alerts")
public class Alert extends AuditableAbstractAggregateRoot<Alert> {
    @Getter
    @Column(name = "location", nullable = false, length = 100)
    private String location;

    @Getter
    @Setter
    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Getter
    @Column(name = "description", nullable = true, length = 255)
    private String description;

    @Getter
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    public Alert(String location, String type, String description, Long idUser) {
        this.location = location;
        this.type = type;
        this.description = description;
        this.idUser = idUser;
    }

    public Alert() {
    }
}
