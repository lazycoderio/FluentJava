package io.lazycoder.helpers;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class DB {

    public User GetUser(HashMap<String, Object> userProps){
        return new User(userProps);
    }

    public String getFromES(String id){
        Map<String, Object> record = new LinkedHashMap<String, Object>();
        record.put("Date", LocalDateTime.now().toString());

        Settings settings = Settings.builder()
                .put("cluster.name", "myClusterName").build();
        TransportClient client = new PreBuiltTransportClient(settings);

        GetResponse response = client.prepareGet("TestUsers", "user", id).get();

        return GetUser(response.getFields());

    }

    public String storeInES(User user){
        Map<String, Object> record = new LinkedHashMap<String, Object>();
        record.put("Date", LocalDateTime.now().toString());
        record.put("user_record", user);

        Settings settings = Settings.builder()
                .put("cluster.name", "myClusterName").build();
        TransportClient client = new PreBuiltTransportClient(settings);

        IndexResponse response = client.prepareIndex("TestUsers", "user")
                .setSource(record)
                .get();

        return response.getId();
    }
}
