package pro.sky.telegrambot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommandType {
    // CALLBACK
    START_CALLBACK("start_"), SHELTER_CALLBACK("shelter_"), INFO_CALLBACK("info_"),
    GET_CALLBACK("get_"), REPORT_CALLBACK("report_"), VOLUNTEER_CALLBACK("volunteer_"),
    SEND_CONTACT_CALLBACK("sendContact_"), ADDRESS_CALLBACK("address_"), CAR_PASS_CALLBACK("pass_"),
    ARRIVE_CALLBACK("arrive_"), SAFETY_GUIDE_CALLBACK("guide_"),
    WORKING_TIME_CALLBACK("workingTime_"), ABOUT_SHELTER_CALLBACK("about_"),

    // callback_2_level

    RULES_CALLBACK("Rules_"), DOCUMENTS_CALLBACK("Documents for adopt"),
    TRANSPORTING_CALLBACK("Transporting"),

    //MESSAGE
    START_MESSAGE("/start"), FORM_MESSAGE("/form");
    private final String command;
}
