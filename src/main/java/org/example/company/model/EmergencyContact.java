package org.example.company.model;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmergencyContact {
    private String email;
    private String phone;

    public EmergencyContact() {}

    public EmergencyContact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
