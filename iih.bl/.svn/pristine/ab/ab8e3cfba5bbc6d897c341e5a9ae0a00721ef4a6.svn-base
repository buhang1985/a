package iih.bl.cg.s.cglogic.util;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;

/**
 * 
 * 合并记账结果
 * @author ly 2019/03/14
 *
 */
public class BlCombineAccRltUtil {

	/**
	 * 合并记账结果
	 * @param rltFrom 合并源
	 * @param rltTo 合并目标
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static void combine(BlCgAccountRltDTO rltFrom, BlCgAccountRltDTO rltTo) throws BizException{
		
		if(FBoolean.TRUE.equals(rltTo.getFg_success()) && 
				FBoolean.FALSE.equals(rltFrom.getFg_success())){
			
			rltTo.setFg_success(rltFrom.getFg_success());
			rltTo.setErr_msg(rltFrom.getErr_msg());
			rltTo.setExcptionstack(rltFrom.getExcptionstack());
		}
		
		//合并单患者列表
		if(rltTo.getError_entlist() == null){
			rltTo.setError_entlist(new FArrayList());
		}
		
		if(rltFrom.getError_entlist() != null && rltFrom.getError_entlist().size() > 0){
			rltTo.getError_entlist().addAll(rltFrom.getError_entlist());
		}
	}
}
