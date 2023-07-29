package com.voron.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "subscriptions")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;
    @ManyToOne
    @JoinColumn(name = "publication_id", nullable = false)
    private Publication publication;
    @Column(nullable = false)
    private Date subscriptionDate;

}
