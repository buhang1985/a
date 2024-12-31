package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 分方医嘱到临床医嘱分方数据信息列表集合的转换操作BP
 */
public class TLCiOr2CiOrPresSplitListBP2 extends CiOr2CiOrPresSplitListBP{
	
	/**
	 * 分方医嘱格式化为分方数据DTO
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	protected OrderPresSplitDTO[] ciOrs2CiOrPresSplitDTOs(CiOrderDO[] ciors) throws BizException{
		CiOrs2CiOrPresSplitDTOsBP bp=new TLCiOrs2CiOrPresSplitDTOsBP();
		return bp.exec(ciors);
	}
	
	
}
