package model;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

//    <NumCode>392</NumCode>
//<CharCode>JPY</CharCode>
//<Nominal>100</Nominal>
//    <Name>Японских иен</Name>
//<Value>53,3673</Value>
@Entity
@Table(name = "jpymodel")
public class JPYModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "num_code",columnDefinition = "INTEGER default 392")
    private Integer numCode;
    @Column(name = "char_code",columnDefinition = "VARCHAR(30) default 'JPY'")
    private String charCode;

    private Integer nominal;
    @Column(name = "name",columnDefinition = "VARCHAR(30) default 'японская йена'")
    private String name;

    private Double value;
    @Column(name = "time_receipt", columnDefinition = "timestamp default now()")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date timeReceipt;
    public JPYModel() {
        this.numCode=392;
        this.name="йена";
        this.charCode="JPY";
    }

    public JPYModel(Integer nominal, Double value) {
        this();
        this.nominal = nominal;
        this.value = value;
    }



    public Integer getNumCode() {
        return numCode;
    }

    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Date getTimeReceipt() {
        return timeReceipt;
    }

    public void setTimeReceipt(Date timeReceipt) {
        this.timeReceipt = timeReceipt;
    }

    @Override
    public String toString() {
        return "JPYModel{" +
                "id=" + id +
                ", numCode=" + numCode +
                ", charCode='" + charCode + '\'' +
                ", nominal=" + nominal +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", timeReceipt=" + timeReceipt +
                '}';
    }
}
