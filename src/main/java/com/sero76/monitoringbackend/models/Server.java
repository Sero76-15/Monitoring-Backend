package com.sero76.monitoringbackend.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Server {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String url;

    @Column
    @Enumerated(EnumType.STRING)
    private ServerStatus serverStatus;
}
