package ComplexJson;

public class de {
    public static void main(String[] args) {
        String Url = "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss";

// Split the URL using "code=" as the delimiter and get the second part
        String partialcode = Url.split("code=")[0];

// Split the partial code using "&scope" as the delimiter and get the first part
        String code = partialcode.split("&scope")[0];

// Print the extracted authorization code
        System.out.println(code);

    }
}
