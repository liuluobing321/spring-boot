package com.llb.service.impl;

import com.llb.entity.StoreES;
import com.llb.service.StoreESService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liuluobing
 * @Description:
 * @Date: 2019/9/28 15:51
 */
@Service
public class StoreESServiceImpl implements StoreESService {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Override
	public List<StoreES> findStore() {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		boolQueryBuilder.must(QueryBuilders.matchAllQuery());
		GeoDistanceQueryBuilder geoDistanceQueryBuilder = new GeoDistanceQueryBuilder("location");
		geoDistanceQueryBuilder.distance("3km");
		geoDistanceQueryBuilder.point(39.638482, 118.160074);
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withIndices("platform_foreign_website")
				.withTypes("store")
				.withFilter(geoDistanceQueryBuilder)
				.build();
		return elasticsearchTemplate.queryForList(searchQuery, StoreES.class);
	}
}
