package com.guozz.elasticsearch.test1.dennisit.process;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.deletebyquery.DeleteByQueryResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
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

import com.guozz.elasticsearch.test1.dennisit.data.DataFactory;
import com.guozz.elasticsearch.test1.dennisit.data.Medicine;
import com.guozz.elasticsearch.test1.dennisit.util.JsonUtil;

public class ElasticSearchHandler {

	private Client client;

    public ElasticSearchHandler(){    
        //ʹ�ñ�����Ϊ�ڵ�
        this("127.0.0.1");
    }
    
    public ElasticSearchHandler(String ipAddress){
        //��Ⱥ���ӳ�ʱ����
        Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "cupid-es").put("client.transport.ping_timeout", "10s").build();
        client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(ipAddress, 8300));
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
    	//��������ʱ�жϴ������Ƿ����
    	if(isExistsIndex(indexname)){
    		  DeleteIndexResponse deleteIndexResponse = client.admin().indices()    
                      .prepareDelete(indexname)    
                      .execute().actionGet();    
    		  System.out.println(deleteIndexResponse.getHeaders());  
    	}
        //���������� ��Ҫע�����.setRefresh(true)����һ��Ҫ����,�����һ�ν����������Ҳ�������
        IndexRequestBuilder requestBuilder = client.prepareIndex(indexname, type).setRefresh(true);
        for(int i=0; i<jsondata.size(); i++){
            requestBuilder.setSource(jsondata.get(i)).execute().actionGet();
        }     
         
    }
    
    
    /**
     * �ж�ָ���������������Ƿ����
     * @param indexName ������
     * @param indexType ��������
     * @return  ���ڣ�true; �����ڣ�false;
     */
    public boolean isExistsType(String indexName,String indexType){
        TypesExistsResponse  response = 
        		client.admin().indices()
                .typesExists(new TypesExistsRequest(new String[]{indexName}, indexType)
                ).actionGet();
        System.out.println( JsonUtil.object2Json(response));
        return response.isExists();
    }
    
    /**
     * �ж�ָ�����������Ƿ����
     * @param indexName ������
     * @return  ���ڣ�true; �����ڣ�false;
     */
    public boolean isExistsIndex(String indexName){
        IndicesExistsResponse  response = 
        		client.admin().indices().exists( 
                        new IndicesExistsRequest().indices(new String[]{indexName})).actionGet();
        System.out.println( JsonUtil.object2Json(response));
        return response.isExists();
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
    
    

    /**
     * ��������
     * @throws Exception
     */
	public void BulkInput() throws Exception {  
	    List<IndexRequest> requests = new ArrayList<IndexRequest>();  
	    for (int i = 0; i < 100000; i++) {  
	    	Medicine medicine = new Medicine();  
	    	medicine.setId(i+100);
	    	medicine.setName("name"+i);
	    	medicine.setFunction("function"+i);
	        String index = "indexdemo"; // �൱�����ݿ���  
	        String type = "typedemo"; // �൱�ڱ���  
	  
	        String json =JsonUtil.object2Json(medicine);
	  
	        IndexRequest request = client  
	                .prepareIndex(index, type, medicine.getId()+"").setSource(json)  
	                .request();  
	        requests.add(request);  
	    }  
	  
	    BulkRequestBuilder bulkRequest = client.prepareBulk();  
	  
	    for (IndexRequest request : requests) {  
	        bulkRequest.add(request);  
	    }  
	  
	    BulkResponse bulkResponse = bulkRequest.execute().actionGet();  
	    //System.out.println(JsonUtil.object2Json(bulkResponse));
	    if (bulkResponse.hasFailures()) {  
	        System.out.println("����������������");  
	    }  
	} 
    
	/**
	 * �÷����Ǹ���index��type��_Id�����������м�¼��ɾ����������ʵ�ʵĲ��������У��÷���Ӧ�ý��٣���Ҫ����_Id����ֱ�ӻ�ȡ
	 * @param indexName
	 * @param indexType
	 * @param id
	 */
	public void deleteById(String indexName,String indexType,String id){
		DeleteResponse response = client
		        .prepareDelete(indexName, indexType, id)
		              .execute()
		              .actionGet();
		System.out.println(response.toString());
	}
	/**
	 * �÷����Ǹ��ݲ�ѯ�Ĺ��������е�����ɾ�������Ծ���ָ����ѯ�������Ƚϳ��á�
	 * @param indexName
	 * @param indexType
	 * @param id
	 */
	public void deleteByCondition(String indexName,String indexType,QueryBuilder queryBuilder){
		DeleteByQueryResponse response = client.prepareDeleteByQuery(indexName)
		        .setTypes(indexType)
		        .setQuery(queryBuilder)
		        .execute().actionGet();
		System.out.println(response.toString());
	}
	
    public static void main(String[] args) {
        ElasticSearchHandler esHandler = new ElasticSearchHandler();
        List<String> jsondata = DataFactory.getInitJsonData();
        String indexName = "indexdemo";
        String indexType = "typedemo";
        esHandler.createIndexResponse(indexName, indexType, jsondata);
        //��ѯ����
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "��ð��"); //fieldQuery("name", "��ð");

        List<Medicine> result = esHandler.searcher(queryBuilder, indexName, indexType);
        for(int i=0; i<result.size(); i++){
            Medicine medicine = result.get(i);
            System.out.println("(" + medicine.getId() + ")ҩƷ����:" +medicine.getName() + "\t\t" + medicine.getFunction());
        }
    }
}
