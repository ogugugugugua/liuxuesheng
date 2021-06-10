package scut.yulin.es.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Date 2021/5/30
 * @Author xieyulin
 * @Description 用于ES的目的地schedule
 **/
@Data
@Document(indexName = "destination")
public class EsDestination {

}
