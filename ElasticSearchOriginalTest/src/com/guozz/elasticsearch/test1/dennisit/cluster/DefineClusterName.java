package com.guozz.elasticsearch.test1.dennisit.cluster;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class DefineClusterName {

	/**�����иò���ʵ��ʱ,�Ѿ��ڱ��ؽ����˶�Ӧ��������datum*/
    public static void main(String[] args) {
        
        //�Զ��弯Ⱥ�������
        String clusterName = "elasticsearch_pudongping"; 
        
        //�����и��ļ�Ⱥ�������
        Settings settings = ImmutableSettings.settingsBuilder()
        .put("cluster.name", clusterName).build();
        
        //������Ⱥ,�󶨼�Ⱥ�ڵĻ���
        TransportClient client = new TransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress("192.168.0.149", 9300));
        client.addTransportAddress(new InetSocketTransportAddress("192.168.0.162", 9300));
        
        //����
        GetResponse response = client.prepareGet("datum", "datum", ""+130)
          .execute()
          .actionGet();
        
        ObjectMapper mapper = new ObjectMapper();
        Datum datum= mapper.convertValue(response.getSource(), Datum.class);
        
        System.out.println("��Ѷ����:"+datum.getTitle() );
        
        //�رս��
        client.close();    
    }
}
