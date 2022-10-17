package pogoeinstein.gender;

import pogoeinstein.settings.environment.Settings;

public class Gender {

    private String genderName;
    private Integer genderId;
    public Gender(Integer genderId){
        this.genderId = genderId;
        this.genderName = Settings.getGenderMap().get(genderId);
    }


    public Integer getGenderId() {
        return genderId;
    }


    public String getGenderName() {
        return genderName;
    }

}
