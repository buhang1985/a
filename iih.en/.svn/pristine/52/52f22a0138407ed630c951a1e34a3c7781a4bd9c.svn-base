package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.desc.EnDepDODesc;
import iih.en.pv.enres.i.IEndepRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取就诊科室
 * @author yank
 *
 */
public class GetEntDepListBP {
	/**
	 * 获取就诊科室
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public EnDepDO[] exec(String entId) throws BizException{
		if(EnValidator.isEmpty(entId)){
			throw new BizException("entId为空");
		}
		String whereStr = String.format("%s.ID_ENT='%s'", EnDepDODesc.TABLE_ALIAS_NAME,entId);
		String orderStr = String.format("%s.DT_B DESC ", EnDepDODesc.TABLE_ALIAS_NAME);
		IEndepRService enDepRService = ServiceFinder.find(IEndepRService.class);
		return enDepRService.find(whereStr, orderStr, FBoolean.FALSE);
	}
}
