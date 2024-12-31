package iih.en.pv.s.bp.op;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 检查患者是否已经挂了此号
 * @author yank
 *
 */
public class CheckHasRegedBP {
	/**
	 * 是否已经挂号
	 * @param patId 患者id
	 * @param schId 排班id
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String patId,String schId) throws BizException{
		return FBoolean.FALSE;
	}
}
