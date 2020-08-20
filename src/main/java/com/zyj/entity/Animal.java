package com.zyj.entity;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class Animal {

    @XStreamAlias("Name")
    private String name;

    @XStreamOmitField //序列化时忽略该属性
    private int age;

    private int gender;

    public static void main(String[] args) {

        Animal cat = new Animal("cat", 3, 0);
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{Animal.class});
        xStream.autodetectAnnotations(true);
        String str = "<xml>"+
                "<Name>123</Name>"+
                "</xml>";
        System.out.println(xStream.fromXML(str));

    }

}
