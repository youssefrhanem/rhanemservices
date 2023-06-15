package com.rhanem.notification;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class Notification {


    @javax.persistence.Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )
    private Integer notificationId;
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
