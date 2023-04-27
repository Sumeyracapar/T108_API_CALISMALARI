package pojos;

public class JsonPlaceHolderReqBodyPojo {


    // 1 -



    private String title;

    private String body;

    private  int userId;

    private int id;


    // 2-

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // 3- Tüm varianleri iceren parametreli bir constructor olusturalim


    public JsonPlaceHolderReqBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;


        // 4- Parametreli constructar olusturdugum icin bir tane de parametrresiz constructar  olusturuyorum

    }

    public JsonPlaceHolderReqBodyPojo() {
        }


     // 5 - toString() mrthodu olusturuyorum


    @Override
    public String toString() {
        return "JsonPlaceHolderReqBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}

