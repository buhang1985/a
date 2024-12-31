package iih.hp.cp.hpcpimplstatdto;

import java.util.List;

/**
 * 
 * @author chenxiang
 *
 * @date 2019年12月19日下午6:00:33
 *
 * @classpath iih.hp.cp.hpcpimplstatdto.HpcpimplStatisticsDTO
 *
 * description: 临床路径病种实施情况统计类
 *
 */
public class HpcpimplStatisticsDTO {

	/**
	 * 病种实施情况统计数据
	 */
	private List<HpcpimplStatDTO> hpcpimplStatList;
	
	/**
	 * 路径匹配人数合计
	 */
	private Integer allMatchNum;

	public List<HpcpimplStatDTO> getHpcpimplStatList() {
		return hpcpimplStatList;
	}

	public void setHpcpimplStatList(List<HpcpimplStatDTO> hpcpimplStatList) {
		this.hpcpimplStatList = hpcpimplStatList;
	}

	public Integer getAllMatchNum() {
		return allMatchNum;
	}

	public void setAllMatchNum(Integer allMatchNum) {
		this.allMatchNum = allMatchNum;
	}
}
