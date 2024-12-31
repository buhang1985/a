package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.enflw.d.EnFlwDO;
import iih.en.pv.enflw.d.desc.EnFlwDODesc;
import iih.en.pv.enflw.i.IEnflwCudService;
import iih.en.pv.enflw.i.IEnflwRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医生关注EP
 * 
 * @author liubin
 *
 */
public class EntFlwEP {
	/**
	 * 获取用户关注
	 * 
	 * @param entId
	 * @param empId
	 * @return
	 * @throws BizException
	 */
	public EnFlwDO[] getEnFlwDO(String entId, String empId) throws BizException{
		if(EnValidator.isEmpty(entId)
				|| EnValidator.isEmpty(empId))
			return null;
		String whereStr = String.format(" %s.Id_ent = '%s' and %s.Id_emp = '%s' ", 
				EnFlwDODesc.TABLE_ALIAS_NAME, entId,
				EnFlwDODesc.TABLE_ALIAS_NAME, empId);
		return getRServ().find(whereStr, null, FBoolean.FALSE);
	}
	/**
	 * 保存用户关注
	 * 
	 * @param entId
	 * @param empId
	 * @return
	 * @throws BizException
	 */
	public EnFlwDO[] addEnFlw(String entId, String empId) throws BizException{
		EnFlwDO enFlw = new EnFlwDO();
		enFlw.setStatus(DOStatus.NEW);
		enFlw.setId_ent(entId);
		enFlw.setId_emp(empId);
		enFlw.setId_grp(Context.get().getGroupId());
		enFlw.setId_org(Context.get().getOrgId());
		return getCudServ().save(new EnFlwDO[]{enFlw});
	}
	/**
	 * 取消用户关注
	 * 
	 * @param entId
	 * @param empId
	 * @return
	 * @throws BizException
	 */
	public void cancEnFlw(String entId, String empId) throws BizException{
		EnFlwDO[] enFlws = getEnFlwDO(entId, empId);
		if(EnValidator.isEmpty(enFlws))
			return;
		getCudServ().delete(enFlws);
	}
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IEnflwRService getRServ(){
		return ServiceFinder.find(IEnflwRService.class);
	}
	/**
	 * 获取操作服务
	 * 
	 * @return
	 */
	public IEnflwCudService getCudServ(){
		return ServiceFinder.find(IEnflwCudService.class);
	}
}
