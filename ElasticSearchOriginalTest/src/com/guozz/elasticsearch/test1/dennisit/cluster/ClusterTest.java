package com.guozz.elasticsearch.test1.dennisit.cluster;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

/**�����иò���ʵ��ʱ,�Ѿ��ڱ��ؽ����˶�Ӧ��������datum*/
public class ClusterTest {

	public static void main(String[] args) {
		//��������һ���ڵ�,�����Զ�����ͬ���ε�es��Ⱥ,һ��ǰ�����es�ļ�Ⱥ��(cluster.name)�������Ҫ����һ�¡�
        String clusterName = "elasticsearch_pudp"; //��Ⱥ�������
        
        /**
         * Ĭ�ϵĻ�����һ���ڵ�,es��Ⱥ���Զ���������һЩ�����ķ�Ƭ,�����������ڵ������Ϊһ���ͻ��˶���ȥ��������,
         * ��Ϳ������ð�node.data���ó�false�� node.client���ó�true��
         */
        Node node = NodeBuilder.nodeBuilder().clusterName(clusterName).client(true).node(); 
        
        //�������,���뵽ָ����Ⱥ
        node.start();
        
        //��ȡ�ڵ�������,ʹ��prepareGet����datum�������� ��������Ϊdatum,��������¼ΨһidֵΪ150�ü�¼
        GetResponse response = node.client().prepareGet("datum", "datum", ""+150).execute().actionGet();
        
        //����ӳ��ģ��
        ObjectMapper mapper = new ObjectMapper();
        //���������response�е�ֵת����ָ���Ķ���ģ��,Datum���Լ�������һ����ѯModel����
        Datum datum= mapper.convertValue(response.getSource(), Datum.class);
        
        //��ӡ��������л�ȡ�Ķ�����Ӧ������
        System.out.println("��Ѷ����:"+datum.getTitle() );
        
        //�رս��
        node.close();
	}
}
