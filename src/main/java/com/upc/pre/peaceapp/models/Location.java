package com.upc.pre.peaceapp.models;

import com.upc.pre.peaceapp.shared.documentation.models.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "locations")
public class Location extends AuditableAbstractAggregateRoot<Location> {
    @Getter
    @Setter
    @Column(name="latitude", nullable = false, length = 30)
    private String aLatitude;

    @Getter
    @Setter
    @Column(name="longitude", nullable = false, length = 30)
    private String aLongitude;

    public Location(String aLatitude, String aLongitude) {
        this.aLatitude = aLatitude;
        this.aLongitude = aLongitude;
    }

    public Location() {
    }
}
