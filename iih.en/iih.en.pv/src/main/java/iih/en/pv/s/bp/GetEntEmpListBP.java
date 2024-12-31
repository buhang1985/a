package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.d.desc.EnPsnDODesc;
import iih.en.pv.enres.i.IEnpsnRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取就诊医护人员
 * @author yank
 *
 */
public class GetEntEmpListBP {
	/**
	 * 获取就诊医护人员
	 * @param entId 就诊id
	 * @param roleTp 角色类型，如果为空，则是查询全部
	 * @return
	 * @throws BizException
	 */
	public EnPsnDO[] exec(String entId,String roleTp) throws BizException{
		if(EnValidator.isEmpty(entId)){
			throw new BizException("entId为空");
		}
		String whereStr="";
		if(!EnValidator.isEmpty(roleTp)){
			whereStr = String.format("%s.ID_ENT='%s' AND %s.SD_EMPROLE='%s'", EnPsnDODesc.TABLE_ALIAS_NAME,entId,EnPsnDODesc.TABLE_ALIAS_NAME,roleTp);
		}else{
			whereStr = String.format("%s.ID_ENT='%s' ", EnPsnDODesc.TABLE_ALIAS_NAME,entId);
		}
		String orderStr = String.format("%s.DT_B ", EnPsnDODesc.TABLE_ALIAS_NAME);
		IEnpsnRService enDepRService = ServiceFinder.find(IEnpsnRService.class);
		return enDepRService.find(whereStr, orderStr, FBoolean.FALSE);
	}
}
