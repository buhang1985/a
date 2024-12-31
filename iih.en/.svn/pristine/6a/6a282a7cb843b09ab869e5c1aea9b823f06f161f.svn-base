package iih.en.pv.s.bp.op.ws;

import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
/**
 * 设置操作员上下文
 * @param code
 * @throws BizException
 */
public class SetPsnDocContextBP {

	public void exec(String code) throws BizException{
		if(EnValidator.isEmpty(code)){
			throw new BizException("未传入操作员编码");
		}
		IPsndocMDORService rservice = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psndoc = rservice.findByAttrValString("Code", code);
		if(EnValidator.isEmpty(psndoc))
		{
			throw new BizException("未检索到操作员，编码为"+code);
		}
		Context.get().setDeptId(psndoc[0].getId_dep()); 
		Context.get().setOrgId(psndoc[0].getId_org());
		Context.get().setGroupId(psndoc[0].getId_group());
		Context.get().setStuffId(psndoc[0].getId_psndoc());
	}
}
