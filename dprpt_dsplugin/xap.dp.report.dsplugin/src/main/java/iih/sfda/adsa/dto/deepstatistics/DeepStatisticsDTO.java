package iih.sfda.adsa.dto.deepstatistics;


/**
 * 事件统计分析信息 DTO数据 
 * 
 */
public class DeepStatisticsDTO {
	private String name_parent;
	private Integer count_parent;
	private String name;
	private Integer count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getName_parent() {
		return name_parent;
	}
	public void setName_parent(String name_parent) {
		this.name_parent = name_parent;
	}
	public Integer getCount_parent() {
		return count_parent;
	}
	public void setCount_parent(Integer count_parent) {
		this.count_parent = count_parent;
	}
	
	
	
}