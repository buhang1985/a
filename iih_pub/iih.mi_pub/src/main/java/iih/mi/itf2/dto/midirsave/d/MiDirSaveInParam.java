package iih.mi.itf2.dto.midirsave.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保目录保存入参 DTO数据 
 * 
 */
public class MiDirSaveInParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 明细
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 明细
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
}