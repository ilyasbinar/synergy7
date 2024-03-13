package org.example;

import java.util.StringJoiner;

public class StringConcatenation {
    public static void main(String[] args) {
        String str1 = "String";
        String str2 = "Concat";
        String str3 = "Binar";
        String str4 = "Binar";
        String str5 = "Binar";
        String str7 = "Binar";
        String str8= "Binar";
        String str9 = "Binar";
        String str10 = "Binar";

        String result = str1 +"-"+ str2;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1).append(str2).append(str3);

//        String result = str1.concat(str2);

//        String result = String.join(",", str1, str2); //mudah untuk membuat CSV
//        String splitResult[] = result.split(",");

        String result2 = String.format("%s %s %s", str1, str2, str3);

        System.out.println(result2);

        String binar = "binar";

//        for(int i=0;i<10;i++){
//            binar = binar+" "+ binar;
//        }

        System.out.println(binar);

        StringBuffer buffer = new StringBuffer();
        buffer.append("Binar");
        buffer.append("accademy");

        String resultBuffer = buffer.toString();

        System.out.println(buffer);
        System.out.println(resultBuffer);


        StringBuilder builder = new StringBuilder();
        builder.append("String");
        builder.append(1);
        String builderResult = builder.toString();
        System.out.println(builderResult);

        StringJoiner joiner = new StringJoiner("");
        joiner.add("String");
        joiner.add("Concat");

        System.out.println(joiner);

        String a = "Binar";
        if(a.equals("binar")){
            System.out.println("a adalah binar");
        } else if (a.equalsIgnoreCase("binar")) {
            System.out.println("a adalah binar(incasesensitive)");
        }

    }
}
