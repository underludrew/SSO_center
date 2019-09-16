package only.yyq.SSOCenter.Utils.jsonUtil;

public class jsonUtil {
//    static String result;
//    static String url;

   public String get(String result,String url){
        String model="{\n" +
                "    \"data\": {\n" +
                "        \"result\":\""+result+"\",\n" +
                "        \"url\":\""+url+"\"\n" +
                "    }" +
                "    }";
        return model;
   }

}
