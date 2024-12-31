package iih.pi.patsrvpkg.dto;

import iih.pi.patsrvpkg.pipatsrvpkggr.d.PiPatSrvPkggrDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class PiPatSrvPkgGrpDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * 分组
	 */
	public PiPatSrvPkggrDO getPiPatSrvPkggrDO(){
		return ((PiPatSrvPkggrDO) getAttrVal("PiPatSrvPkggrDO"));
	}
	
	/**
	 * 分组
	 */
	public void setPiPatSrvPkggrDO(PiPatSrvPkggrDO piPatSrvPkggrDO){
		setAttrVal("PiPatSrvPkggrDO", piPatSrvPkggrDO);
	}
	
	/**
	 * 明细及对应服务项目
	 * @return FArrayList
	 */
	public FArrayList getItem() {
		return ((FArrayList) getAttrVal("Item"));
	}
	/**
	 * 明细及对应服务项目
	 * @param Item
	 */
	public void setItem(FArrayList Item) {
		setAttrVal("Item", Item);
	}
}
