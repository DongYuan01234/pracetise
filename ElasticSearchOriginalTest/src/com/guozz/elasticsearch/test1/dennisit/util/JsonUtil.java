package com.guozz.elasticsearch.test1.dennisit.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import com.guozz.elasticsearch.test1.dennisit.data.Medicine;


public class JsonUtil {

	/**
     * ʵ�ֽ�ʵ�����ת����json����
     * @param medicine    Medicine����
     * @return
     */
    public static String obj2JsonData(Medicine medicine){
        String jsonData = null;
        try {
            //ʹ��XContentBuilder����json����
            XContentBuilder jsonBuild = XContentFactory.jsonBuilder();
            jsonBuild.startObject()
            .field("id",medicine.getId())
            .field("name", medicine.getName())
            .field("funciton",medicine.getFunction())
            .endObject();
            jsonData = jsonBuild.string();
            //System.out.println(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }
    /**
     * ���������ת����json
     * @param object
     * @return
     */
    public static String object2Json(Object object){
    	ObjectMapper mapper = new ObjectMapper();  
		 String json="";
		try {
			json = mapper.writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return json;
    }
}
