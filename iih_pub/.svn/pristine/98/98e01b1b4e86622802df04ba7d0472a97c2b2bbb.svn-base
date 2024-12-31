package iih.sc.sch.dto.d;

import java.util.ArrayList;
import java.util.List;

import iih.sc.sch.scsch.d.ScSchDO;

/**
 * 分析结果
 * @author yank
 *
 */
public class AnalyseResult {
	//已经存在的排班
	private List<ScSchDO> existedSchList = new ArrayList<ScSchDO>();
	//已使用或过时的排班
	private List<ScSchDO> usedOrPastSchList = new ArrayList<ScSchDO>();
	//可以删除的排班
	private List<String> canDeleteSchIdList = new ArrayList<String>();
	public AnalyseResult(){
		
	}
	
	public List<ScSchDO> getExistedSchList() {
		return existedSchList;
	}
	public void setExistedSchList(List<ScSchDO> existedSchList) {
		this.existedSchList = existedSchList;
	}
	public List<ScSchDO> getUsedOrPastSchList() {
		return usedOrPastSchList;
	}
	public void setUsedOrPastSchList(List<ScSchDO> usedOrPastSchList) {
		this.usedOrPastSchList = usedOrPastSchList;
	}
	public List<String> getCanDeleteSchIdList() {
		return canDeleteSchIdList;
	}
	public void setCanDeleteSchIdList(List<String> canDeleteSchIdList) {
		this.canDeleteSchIdList = canDeleteSchIdList;
	}

}
