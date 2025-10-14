package org.example.company.model;
import jakarta.persistence.*;


@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ContactInfo contactInfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="phone", column = @Column(name = "emergency_phone")),
            @AttributeOverride(name ="email", column = @Column(name = "emergency_email"))
    })
    private EmergencyContact emergencyContact;

    public UserProfile() {}
    public UserProfile(ContactInfo contactInfo, EmergencyContact emergencyContact) {
        this.contactInfo = contactInfo;
        this.emergencyContact = emergencyContact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }




}



