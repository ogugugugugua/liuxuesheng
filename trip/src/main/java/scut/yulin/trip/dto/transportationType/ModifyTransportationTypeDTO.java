package scut.yulin.trip.dto.transportationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * 用于修改可用交通类型
 * 存在原因是数据库表中对type进行了唯一索引，所以对于错误的可用交通类型输入应该允许超级管理员进行修改
 */
public class ModifyTransportationTypeDTO extends QueryTransportationTypeDTO{
  /**
   * 类型
   */
  private String type;

  /**
   * 中文名
   */
  private String cnName;
}
