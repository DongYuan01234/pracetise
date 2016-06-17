package com.guozz.elasticsearch.test1.dennisit.cluster;


import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

/**
 * description:
 *
 * @author <a href='mailto:dennisit@163.com'> Cn.pudp (En.dennisit)</a> Copy Right since 2013-9-29 
 *
 * com.bbf.client.ESClient.java
 *
 */

public class ESClient {

    
    /**�����иò���ʵ��ʱ,�Ѿ��ڱ��ؽ����˶�Ӧ��������datum*/
    public static void main(String[] args) {
        
        
        //�Զ��弯Ⱥ�������
        String clusterName = "elasticsearch_pudongping"; 
        
        //�����и��ļ�Ⱥ������� ��������client.transport.sniffΪtrue��ʹ�ͻ���ȥ��̽������Ⱥ��״̬
        Settings settings = ImmutableSettings.settingsBuilder()
        .put("cluster.name", clusterName).put("client.transport.sniff", true).build();   
        
        //�����ͻ��˶���
        TransportClient client = new TransportClient(settings);
        
        //�ͻ��˶����ʼ����Ⱥ�ڽ��,�󶨶��ip
        //client.addTransportAddress(new InetSocketTransportAddress("192.168.0.149", 9300));
        client.addTransportAddress(new InetSocketTransportAddress("192.168.0.162", 9300));
        
        
        //����,����Id��ѯ
        GetResponse response = client.prepareGet("datum", "datum", ""+130)
          .execute()
          .actionGet();
        
        //��ѯ���ӳ��ɶ�����
        ObjectMapper mapper = new ObjectMapper();
        Datum datum= mapper.convertValue(response.getSource(), Datum.class);
        
        System.out.println("��Ѷ���:" + datum.getId() +"\t��Ѷ����:"+datum.getTitle()  );
        
        //�����ѯ����ѯ,��һ������ΪҪ��ѯ�Ĺؼ���,�ڶ�������ΪҪ�������������еĶ�Ӧ�������͵���
        QueryBuilder query = QueryBuilders.multiMatchQuery("������", "keyword");  
        //��һ������datum��ʾ������,�ڶ�������datum��ʾ��������,from��ʾ��ʼ��λ�� size��ʾ��ѯ������ ,����mysql�е�limit3,5
        SearchResponse searchResponse = client.prepareSearch("datum").setTypes("datum").setQuery(query).setFrom(3).setSize(5).execute().actionGet(); 
        
 
        //���������ת��Ϊlist���϶���
        List<Datum> lists  = getBeans(searchResponse);
        
        System.out.println("��ѯ�����Ľ����:" + lists.size());
        for(Datum dtm: lists){
            System.out.println("��Ѷ���:" + dtm.getId() +"\t��Ѷ����:"+dtm.getTitle());
        }
        
        //�رտͻ���
        client.close();    

    }
    
    /**
     * �Ӳ�ѯ���ļ�¼�л�ȡjson��ֵ,ת����<code>Datum</code>����
     *
     * @author <a href='mailto:dennisit@163.com'> Cn.pudp (En.dennisit)</a> Copy Right since 2013-9-24 ����09:24:29
     *                
     * @param response
     *                     ��ѯ�����<code>GetResponse</code>
     * @return
     *                     ����<code>Datum</code>����
     */
    public static Datum getResponseToObject(GetResponse response){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(response.getSource(), Datum.class);
    }
    
    
    /**
     * ����ѯ���Ķ��󼯺Ϸ�װ��List����
     *
     * @author <a href='mailto:dennisit@163.com'>Cn.pudp(En.dennisit)</a> Copy Right since 2013-9-27 ����02:31:26
     *                
     * @param  response
     * @return
     */
    public static List<Datum> getBeans(SearchResponse response) {
        SearchHits hits = response.getHits();
        ObjectMapper mapper = new ObjectMapper();
        List<Datum> datumList = new ArrayList<Datum>();
        for (SearchHit hit : hits) {  
            String json = hit.getSourceAsString();
            Datum dtm = new Datum();
           
            try {
                dtm = mapper.readValue(json, Datum.class);
                datumList.add(dtm);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return datumList;
    }

	public static Client initClient(String clusterName) {
		 Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", clusterName).put("client.transport.ping_timeout", "10s").build();
		 Client  client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 8300));
		return client;
	}
    
}
