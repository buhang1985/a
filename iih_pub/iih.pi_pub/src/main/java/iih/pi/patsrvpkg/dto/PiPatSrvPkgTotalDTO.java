package iih.pi.patsrvpkg.dto;

import iih.pi.patsrvpkg.patsrvpkg.d.PiPatSrvPkgDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class PiPatSrvPkgTotalDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务包
	 */
	public PiPatSrvPkgDO getPiPatSrvPkgDO(){
		return ((PiPatSrvPkgDO) getAttrVal("PiPatSrvPkgDO"));
	}
	
	/**
	 * 服务包
	 */
	public void setPiPatSrvPkgDO(PiPatSrvPkgDO piPatSrvPkgDO){
		setAttrVal("PiPatSrvPkgDO", piPatSrvPkgDO);
	}
	
	/**
	 * 分组
	 * @return FArrayList
	 */
	public FArrayList getGroup() {
		return ((FArrayList) getAttrVal("Group"));
	}
	/**
	 * 分组
	 * @param Detail
	 */
	public void setGroup(FArrayList Group) {
		setAttrVal("Group", Group);
	}
}
