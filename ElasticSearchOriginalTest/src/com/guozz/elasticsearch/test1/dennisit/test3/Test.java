package com.guozz.elasticsearch.test1.dennisit.test3;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.highlight.HighlightField;

import com.guozz.elasticsearch.test1.dennisit.cluster.ESClient;

public class Test {

	public void search() throws IOException {
        // �Զ��弯Ⱥ�������
        String clusterName = "elasticsearch_pudongping";

        // ��ȡ�ͻ���
        Client client = ESClient.initClient(clusterName);

        // ������ѯ����,����productindex��ʾҪ��ѯ��������Ϊproductindex
        SearchRequestBuilder searchRequestBuilder = client
                .prepareSearch("productindex");

        // ���ò�ѯ��������,setTypes("productType1", "productType2","productType3");
        // �����趨�ڶ������������
        searchRequestBuilder.setTypes("productIndex");

        // ���ò�ѯ���� 1.SearchType.DFS_QUERY_THEN_FETCH = ��ȷ��ѯ 2.SearchType.SCAN =
        // ɨ���ѯ,����
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        // ���ò�ѯ�ؼ���
        searchRequestBuilder
                .setQuery(QueryBuilders.matchQuery("title", "Acer"));

        // ��ѯ���������˼۸���4000-5000�� ���ﷶΧΪ[4000,5000]����հ���,������������۸�Ϊ4000�ͼ۸�Ϊ5000������
        searchRequestBuilder.setPostFilter(FilterBuilders.rangeFilter("price")
                .from(4000).to(5000));

        // ��ҳӦ��
        searchRequestBuilder.setFrom(0).setSize(60);

        // �����Ƿ񰴲�ѯƥ�������
        searchRequestBuilder.setExplain(true);

        // ִ������,����������Ӧ��Ϣ
        SearchResponse response = searchRequestBuilder.execute().actionGet();

        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map<String, Object> result = hit.getSource();
            // ��ӡmap����:{id=26, onSale=true, title=���Acer��3, price=4009.0,
            // description=null, createDate=1380530123140, type=2}
            System.out.println(result);
        }
        System.out.println("search success ..");

    }
	
	public void searchHighLight() throws IOException {
        // �Զ��弯Ⱥ�������
        String clusterName = "elasticsearch_pudongping";
        
        // ��ȡ�ͻ���
        Client client = ESClient.initClient(clusterName);    

        // ������ѯ����,����productindex��ʾҪ��ѯ��������Ϊproductindex
        SearchRequestBuilder searchRequestBuilder = client
                .prepareSearch("productindex");

        // ���ò�ѯ��������,setTypes("productType1", "productType2","productType3");
        // �����趨�ڶ������������
        searchRequestBuilder.setTypes("productIndex");

        // ���ò�ѯ���� 1.SearchType.DFS_QUERY_THEN_FETCH = ��ȷ��ѯ 2.SearchType.SCAN = ɨ���ѯ,����
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        // ���ò�ѯ�ؼ���
        searchRequestBuilder
                .setQuery(QueryBuilders.matchQuery("title", "Acer"));

        // ��ѯ���������˼۸���4000-5000�� ���ﷶΧΪ[4000,5000]����հ���,������������۸�Ϊ4000�ͼ۸�Ϊ5000������
        searchRequestBuilder.setPostFilter(FilterBuilders.rangeFilter("price")
                .from(4000).to(5000));

        // ��ҳӦ��
        searchRequestBuilder.setFrom(0).setSize(60);

        // �����Ƿ񰴲�ѯƥ�������
        searchRequestBuilder.setExplain(true);
        
        //���ø�����ʾ
        searchRequestBuilder.addHighlightedField("title");
        searchRequestBuilder.setHighlighterPreTags("<span style=\"color:red\">");
         searchRequestBuilder.setHighlighterPostTags("</span>");
        // ִ������,����������Ӧ��Ϣ
        SearchResponse response = searchRequestBuilder.execute().actionGet();
        
        //��ȡ�������ĵ����
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            //���ĵ��е�ÿһ������ת��json��ֵ
            String json = hit.getSourceAsString();
            //��json��ֵת���ɶ�Ӧ��ʵ�����
            Product product = mapper.readValue(json, Product.class);  
            
            //��ȡ��Ӧ�ĸ�����
            Map<String, HighlightField> result = hit.highlightFields();    
            //���趨�ĸ�������ȡ��ָ����
            HighlightField titleField = result.get("title");  
            //ȡ�ö���ĸ�����ǩ
            Text[] titleTexts =  titleField.fragments();    
            //Ϊtitle��ֵ�����Զ���ĸ�����ǩ
            String title = "";  
            for(Text text : titleTexts){    
                  title += text;  
            }
            //��׷���˸�����ǩ�Ĵ�ֵ������䵽��Ӧ�Ķ���
            product.setTitle(title);
            //��ӡ������ǩ׷����ɺ��ʵ�����
            System.out.println(product);
        }
        System.out.println("search success ..");

    }
}
