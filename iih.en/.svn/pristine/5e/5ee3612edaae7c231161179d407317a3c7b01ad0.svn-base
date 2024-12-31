package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.d.desc.EntDiDODesc;
import iih.en.pv.entdi.i.IEntdiRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取就诊诊断记录
 * @author yank
 *
 */
public class GetEntDiListBP {
	/**
	 * 获取就诊诊断记录
	 * @param entId 就诊id
	 * @return 就诊记录集合
	 * @throws BizException
	 */
	public EntDiDO[] exec(String entId) throws BizException{
		if(EnValidator.isEmpty(entId)){
			throw new BizException("entId为空");
		}
		String whereStr = String.format("%s.ID_ENT='%s'", EntDiDODesc.TABLE_ALIAS_NAME,entId);
		String orderStr = String.format("%s.DT_DIAG ", EntDiDODesc.TABLE_ALIAS_NAME);
		IEntdiRService enDiRService = ServiceFinder.find(IEntdiRService.class);
		return enDiRService.find(whereStr, orderStr, FBoolean.FALSE);
	}
}
