package ru.hostapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "procedures")
public class Procedure extends AbstractNamedEntity {

    @Column(name = "specialist", nullable = false)
    @NotBlank
    @Size(max = 100)
    private String specialist;

    @Column(name = "price", nullable = false)
    @NotNull
    private BigDecimal price;

    @Column(name = "date", nullable = false)
    @NotBlank
    @Size(max = 100)
    private String date;

    @Column(name = "room", nullable = false)
    @NotNull
    private Integer room;

    public Procedure(){

    }

    public Procedure(Procedure procedure){
        this(procedure.getId(), procedure.getName(), procedure.getSpecialist(), procedure.getPrice(), procedure.getDate(), procedure.getRoom());
    }

    public Procedure(Integer id, String name, String specialist, BigDecimal price, String date, Integer room) {
        super(id, name);
        this.specialist = specialist;
        this.price = price;
        this.date = date;
        this.room = room;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "procedureId=" + id +
                ", name='" + name +
                ", specialist='" + specialist +
                ", price=" + price +
                ", date='" + date +
                ", room=" + room +
                '}';
    }
}
