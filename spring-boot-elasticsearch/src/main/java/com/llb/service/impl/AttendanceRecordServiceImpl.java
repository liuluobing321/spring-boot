package com.llb.service.impl;

import com.llb.entity.AttendanceRecord;
import com.llb.service.AttendanceRecordService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liuluobing
 * @Description:
 * @Date: 2019/9/28 17:17
 */
@Service
public class AttendanceRecordServiceImpl implements AttendanceRecordService {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Override
	public List<AttendanceRecord> findUserByDate() {

		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		boolQueryBuilder.must(QueryBuilders.termQuery("workDate", "2019-07-02"));
		SearchQuery searchQuery = new NativeSearchQuery(boolQueryBuilder);
		return elasticsearchTemplate.queryForList(searchQuery, AttendanceRecord.class);

	}

	@Override
	public AttendanceRecord findUser() {
		TermsAggregationBuilder terms = AggregationBuilders.terms("userId.keyword");
		TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("timeResult.code", "2047");
		SearchQuery searchQuery=new NativeSearchQueryBuilder()
				.withIndices("att_common_bussiness_attendance")
				.withTypes("attendance_record")
				.addAggregation(terms)
				.withQuery(termQueryBuilder)
				.build();


		return null;
	}
}
