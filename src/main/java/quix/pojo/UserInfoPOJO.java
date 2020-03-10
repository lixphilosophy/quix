package quix.pojo;


import quix.domain.UserSubmission;

import java.util.ArrayList;
import java.util.List;

public class UserInfoPOJO {

    private int userId;
    private String userName;
    private String userPassword;
    private int userStatus;
    private String firstName;
    private String lastName;
    private String email;
    private String birthDate;
    private int groupID;
    private String address;
    List<UserSubmissionPOJO> userSubmissionPOJOs = new ArrayList<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<UserSubmissionPOJO> getUserSubmissionPOJOs() {
        return userSubmissionPOJOs;
    }

    public void setUserSubmissionPOJOs(List<UserSubmissionPOJO> userSubmissionPOJOs) {
        this.userSubmissionPOJOs = userSubmissionPOJOs;
    }
}
