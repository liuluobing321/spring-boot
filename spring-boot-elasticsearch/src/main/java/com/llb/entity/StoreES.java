package com.llb.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author: liuluobing
 * @Description:
 * @Date: 2019/9/28 15:45
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "platform_foreign_website",type = "store")
public class StoreES {
	@Id
	private String id;
	private String storeName;
	private Double longitude;
	private Double latitude;
	private boolean isdelete;
	private String address;

}
