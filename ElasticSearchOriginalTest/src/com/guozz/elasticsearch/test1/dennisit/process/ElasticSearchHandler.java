package com.guozz.elasticsearch.test1.dennisit.process;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import com.guozz.elasticsearch.test1.dennisit.data.DataFactory;
import com.guozz.elasticsearch.test1.dennisit.data.Medicine;

public class ElasticSearchHandler {

	private Client client;

    public ElasticSearchHandler(){    
        //ʹ�ñ�����Ϊ�ڵ�
        this("192.168.19.177");
    }
    
    public ElasticSearchHandler(String ipAddress){
        //��Ⱥ���ӳ�ʱ����
        /*  
              Settings settings = ImmutableSettings.settingsBuilder().put("client.transport.ping_timeout", "10s").build();
            client = new TransportClient(settings);
         */
        client = new TransportClient().addTransportAddress(new InetSocketTransportAddress(ipAddress, 8200));
    }
    
    
    /**
     * ��������,����������֮��,����elasticsearch-0.20.6\data\elasticsearch\nodes\0���������㿴
     * @param indexName  Ϊ����������һ��es��Ⱥ�п����ж�������⡣ ���Ʊ���ΪСд
     * @param indexType  TypeΪ�������ͣ�����������ͬ�������²�ͬ���͵����ݵģ�һ���������¿����ж���������͡�
     * @param jsondata     json��ʽ�����ݼ���
     * 
     * @return
     */
    public void createIndexResponse(String indexname, String type, List<String> jsondata){
        //���������� ��Ҫע�����.setRefresh(true)����һ��Ҫ����,�����һ�ν����������Ҳ�������
        IndexRequestBuilder requestBuilder = client.prepareIndex(indexname, type).setRefresh(true);
        for(int i=0; i<jsondata.size(); i++){
            requestBuilder.setSource(jsondata.get(i)).execute().actionGet();
        }     
         
    }
    
    /**
     * ��������
     * @param client
     * @param jsondata
     * @return
     */
    public IndexResponse createIndexResponse(String indexname, String type,String jsondata){
        IndexResponse response = client.prepareIndex(indexname, type)
            .setSource(jsondata)
            .execute()
            .actionGet();
        return response;
    }
    
    /**
     * ִ������
     * @param queryBuilder
     * @param indexname
     * @param type
     * @return
     */
    public List<Medicine>  searcher(QueryBuilder queryBuilder, String indexname, String type){
        List<Medicine> list = new ArrayList<Medicine>();
        SearchResponse searchResponse = client.prepareSearch(indexname).setTypes(type)
        .setQuery(queryBuilder)
        .execute()
        .actionGet();
        SearchHits hits = searchResponse.getHits();
        System.out.println("��ѯ����¼��=" + hits.getTotalHits());
        SearchHit[] searchHists = hits.getHits();
        if(searchHists.length>0){
            for(SearchHit hit:searchHists){
                Integer id = (Integer)hit.getSource().get("id");
                String name =  (String) hit.getSource().get("name");
                String function =  (String) hit.getSource().get("funciton");
                list.add(new Medicine(id, name, function));
            }
        }
        return list;
    }
    
    
    public static void main(String[] args) {
        ElasticSearchHandler esHandler = new ElasticSearchHandler();
        List<String> jsondata = DataFactory.getInitJsonData();
        String indexname = "indexdemo";
        String type = "typedemo";
        esHandler.createIndexResponse(indexname, type, jsondata);
        //��ѯ����
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "��ð"); //fieldQuery("name", "��ð");
        /*QueryBuilder queryBuilder = QueryBuilders.boolQuery()
          .must(QueryBuilders.termQuery("id", 1));*/
        List<Medicine> result = esHandler.searcher(queryBuilder, indexname, type);
        for(int i=0; i<result.size(); i++){
            Medicine medicine = result.get(i);
            System.out.println("(" + medicine.getId() + ")ҩƷ����:" +medicine.getName() + "\t\t" + medicine.getFunction());
        }
    }
}
