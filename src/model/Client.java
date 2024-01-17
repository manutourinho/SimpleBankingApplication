package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Client {

    private String name;
    private String ssnDocument;
    private BigDecimal annualIncome;
    private ClientType type = ClientType.PERSONAL;
    private LocalDateTime lastUpdate = LocalDateTime.now();

    public Client() {}      // parameterless constructor

    public Client(String name, String ssnDocument, BigDecimal annualIncome, ClientType type) {
        this.name = name;
        this.ssnDocument = ssnDocument;
        this.annualIncome = annualIncome;
        this.type = type;

    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsnDocument() {
        return ssnDocument;
    }

    public void setSsnDocument(String ssnDocument) {
        this.ssnDocument = ssnDocument;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
