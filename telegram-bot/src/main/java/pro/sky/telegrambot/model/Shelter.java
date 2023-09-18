package pro.sky.telegrambot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Модель приюта.
 */
@Entity(name = "shelter")
public class Shelter {

    @Id
    @GeneratedValue
    private Long id;

    private String descriptionOfCatShelter;
    private String descriptionOfDogShelter;


    private String workingTimeOfCatShelter;
    private String workingTimeOfDogShelter;

    private String addressOfCatShelter;
    private String addressOfDogShelter;

    private String arriveOfCatShelter;
    private String arriveOfDogShelter;


    private String passOfCatShelter;
    private String passOfDogShelter;

    private String safetyGuideOfCatShelter;
    private String safetyGuideOfDogShelter;


    private String sendContact;

    private String volunteerCall;

    /**
     * Создает новый экземпляр приюта.
     */
    public Shelter() {

    }

    /**
     * Создает новый экземпляр приюта с заданными параметрами.
     *
     * @param id                      идентификатор приюта
     * @param descriptionOfCatShelter описание приюта для кошек
     * @param descriptionOfDogShelter описание приюта для собак
     * @param workingTimeOfCatShelter рабочее время приюта для кошек
     * @param workingTimeOfDogShelter рабочее время приюта для собак
     * @param addressOfCatShelter     адрес приюта для кошек
     * @param addressOfDogShelter     адрес приюта для собак
     * @param arriveOfCatShelter      информация о приезде в приют для кошек
     * @param arriveOfDogShelter      информация о приезде в приют для собак
     * @param passOfCatShelter        информация о проходе в приют для кошек
     * @param passOfDogShelter        информация о проходе в приют для собак
     * @param safetyGuideOfCatShelter правила безопасности для посещения приюта для кошек
     * @param safetyGuideOfDogShelter правила безопасности для посещения приюта для собак
     * @param sendContact             отправить контакт приюта
     * @param volunteerCall           вызвать волонтера
     */
    public Shelter(Long id, String descriptionOfCatShelter, String descriptionOfDogShelter,
                   String workingTimeOfCatShelter, String workingTimeOfDogShelter, String
                           addressOfCatShelter, String addressOfDogShelter, String arriveOfCatShelter,
                   String arriveOfDogShelter, String passOfCatShelter, String passOfDogShelter, String safetyGuideOfCatShelter,
                   String safetyGuideOfDogShelter, String sendContact, String volunteerCall) {
        this.id = id;
        this.descriptionOfCatShelter = descriptionOfCatShelter;
        this.descriptionOfDogShelter = descriptionOfDogShelter;
        this.workingTimeOfCatShelter = workingTimeOfCatShelter;
        this.workingTimeOfDogShelter = workingTimeOfDogShelter;
        this.addressOfCatShelter = addressOfCatShelter;
        this.addressOfDogShelter = addressOfDogShelter;
        this.arriveOfCatShelter = arriveOfCatShelter;
        this.arriveOfDogShelter = arriveOfDogShelter;
        this.passOfCatShelter = passOfCatShelter;
        this.passOfDogShelter = passOfDogShelter;
        this.safetyGuideOfCatShelter = safetyGuideOfCatShelter;
        this.safetyGuideOfDogShelter = safetyGuideOfDogShelter;
        this.sendContact = sendContact;
        this.volunteerCall = volunteerCall;
    }

    /**
     * Возвращает строковое представление данного приюта.
     *
     * @return строковое представление приюта
     */
    @Override
    public String toString() {
        return "Shelter{" +
                "id=" + id +
                ", descriptionOfCatShelter='" + descriptionOfCatShelter + '\'' +
                ", descriptionOfDogShelter='" + descriptionOfDogShelter + '\'' +
                ", workingTimeOfCatShelter='" + workingTimeOfCatShelter + '\'' +
                ", workingTimeOfDogShelter='" + workingTimeOfDogShelter + '\'' +
                ", addressOfCatShelter='" + addressOfCatShelter + '\'' +
                ", addressOfDogShelter='" + addressOfDogShelter + '\'' +
                ", arriveOfCatShelter='" + arriveOfCatShelter + '\'' +
                ", arriveOfDogShelter='" + arriveOfDogShelter + '\'' +
                ", passOfCatShelter='" + passOfCatShelter + '\'' +
                ", passOfDogShelter='" + passOfDogShelter + '\'' +
                ", safetyGuideOfCatShelter='" + safetyGuideOfCatShelter + '\'' +
                ", safetyGuideOfDogShelter='" + safetyGuideOfDogShelter + '\'' +
                ", sendContact='" + sendContact + '\'' +
                ", volunteerCall='" + volunteerCall + '\'' +
                '}';
    }

    /**
     * Возвращает идентификатор приюта.
     *
     * @return идентификатор приюта
     */
    public Long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор приюта.
     *
     * @param id идентификатор приюта
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Возвращает описание приюта для кошек.
     *
     * @return описание приюта для кошек
     */
    public String getDescriptionOfCatShelter() {
        return descriptionOfCatShelter;
    }

    /**
     * Устанавливает описание приюта для кошек.
     *
     * @param descriptionOfCatShelter описание приюта для кошек
     */
    public void setDescriptionOfCatShelter(String descriptionOfCatShelter) {
        this.descriptionOfCatShelter = descriptionOfCatShelter;
    }

    /**
     * Возвращает описание приюта для собак.
     *
     * @return описание приюта для собак
     */
    public String getDescriptionOfDogShelter() {
        return descriptionOfDogShelter;
    }

    /**
     * Устанавливает описание приюта для собак.
     *
     * @param descriptionOfDogShelter описание приюта для собак
     */
    public void setDescriptionOfDogShelter(String descriptionOfDogShelter) {
        this.descriptionOfDogShelter = descriptionOfDogShelter;
    }

    public String getWorkingTimeOfCatShelter() {
        return workingTimeOfCatShelter;
    }

    public void setWorkingTimeOfCatShelter(String workingTimeOfCatShelter) {
        this.workingTimeOfCatShelter = workingTimeOfCatShelter;
    }

    public String getWorkingTimeOfDogShelter() {
        return workingTimeOfDogShelter;
    }

    public void setWorkingTimeOfDogShelter(String workingTimeOfDogShelter) {
        this.workingTimeOfDogShelter = workingTimeOfDogShelter;
    }

    public String getAddressOfCatShelter() {
        return addressOfCatShelter;
    }

    public void setAddressOfCatShelter(String addressOfCatShelter) {
        this.addressOfCatShelter = addressOfCatShelter;
    }

    public String getAddressOfDogShelter() {
        return addressOfDogShelter;
    }

    public void setAddressOfDogShelter(String addressOfDogShelter) {
        this.addressOfDogShelter = addressOfDogShelter;
    }

    public String getArriveOfCatShelter() {
        return arriveOfCatShelter;
    }

    public void setArriveOfCatShelter(String arriveOfCatShelter) {
        this.arriveOfCatShelter = arriveOfCatShelter;
    }

    public String getArriveOfDogShelter() {
        return arriveOfDogShelter;
    }

    public void setArriveOfDogShelter(String arriveOfDogShelter) {
        this.arriveOfDogShelter = arriveOfDogShelter;
    }

    public String getPassOfCatShelter() {
        return passOfCatShelter;
    }

    public void setPassOfCatShelter(String passOfCatShelter) {
        this.passOfCatShelter = passOfCatShelter;
    }

    public String getPassOfDogShelter() {
        return passOfDogShelter;
    }

    public void setPassOfDogShelter(String passOfDogShelter) {
        this.passOfDogShelter = passOfDogShelter;
    }

    public String getSafetyGuideOfCatShelter() {
        return safetyGuideOfCatShelter;
    }

    public void setSafetyGuideOfCatShelter(String safetyGuideOfCatShelter) {
        this.safetyGuideOfCatShelter = safetyGuideOfCatShelter;
    }

    public String getSafetyGuideOfDogShelter() {
        return safetyGuideOfDogShelter;
    }

    public void setSafetyGuideOfDogShelter(String safetyGuideOfDogShelter) {
        this.safetyGuideOfDogShelter = safetyGuideOfDogShelter;
    }

    public String getSendContact() {
        return sendContact;
    }

    public void setSendContact(String sendContact) {
        this.sendContact = sendContact;
    }

    public String getVolunteerCall() {
        return volunteerCall;
    }

    public void setVolunteerCall(String volunteerCall) {
        this.volunteerCall = volunteerCall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelter shelter = (Shelter) o;
        return Objects.equals(id, shelter.id) && Objects.equals(descriptionOfCatShelter,
                shelter.descriptionOfCatShelter) && Objects.equals(descriptionOfDogShelter,
                shelter.descriptionOfDogShelter) && Objects.equals(workingTimeOfCatShelter,
                shelter.workingTimeOfCatShelter) && Objects.equals(workingTimeOfDogShelter,
                shelter.workingTimeOfDogShelter) && Objects.equals(addressOfCatShelter,
                shelter.addressOfCatShelter) && Objects.equals(addressOfDogShelter,
                shelter.addressOfDogShelter) && Objects.equals(arriveOfCatShelter,
                shelter.arriveOfCatShelter) && Objects.equals(arriveOfDogShelter,
                shelter.arriveOfDogShelter) && Objects.equals(passOfCatShelter,
                shelter.passOfCatShelter) && Objects.equals(passOfDogShelter,
                shelter.passOfDogShelter) && Objects.equals(safetyGuideOfCatShelter,
                shelter.safetyGuideOfCatShelter) && Objects.equals(safetyGuideOfDogShelter,
                shelter.safetyGuideOfDogShelter) && Objects.equals(sendContact,
                shelter.sendContact) && Objects.equals(volunteerCall, shelter.volunteerCall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descriptionOfCatShelter, descriptionOfDogShelter,
                workingTimeOfCatShelter, workingTimeOfDogShelter, addressOfCatShelter,
                addressOfDogShelter, arriveOfCatShelter, arriveOfDogShelter, passOfCatShelter,
                passOfDogShelter, safetyGuideOfCatShelter, safetyGuideOfDogShelter, sendContact,
                volunteerCall);
    }
}








