package entity;

public class Param {
    private final String userId;
    private final String password;
    private final String service = "internet";
    private final String queryString;
    private final String operatorPwd = "";
    private final String operatorUserId = "";
    private final String validcode = "";
    private final String passwordEncrypt = "false";

    public Param(String userId, String password, String queryString) {
        this.userId = userId;
        this.password = password;
        this.queryString = queryString;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getPassword() {
        return this.password;
    }

    public String getService() {
        return "internet";
    }

    public String getQueryString() {
        return this.queryString;
    }

    public String getOperatorPwd() {
        return "";
    }

    public String getOperatorUserId() {
        return "";
    }

    public String getValidcode() {
        return "";
    }

    public String getPasswordEncrypt() {
        return "false";
    }

    public String toString() {
        return "userId=" + this.userId + "&password=" + this.password + "&service=internet&queryString=" + this.queryString + "&operatorPwd=&operatorUserId=&validcode=&passwordEncrypt=false";
    }
}
