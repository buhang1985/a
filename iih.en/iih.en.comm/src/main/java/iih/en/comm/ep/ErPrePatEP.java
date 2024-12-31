package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;
import iih.en.er.pre.d.EnErPrePatDO;
import iih.en.er.pre.i.IEnerprepatCudService;
import iih.en.er.pre.i.IEnerprepatRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * EN_ERPRE_PAT EP
 * 
 * @author liubin
 *
 */
public class ErPrePatEP {
	
	/**
	 * 获取预检患者信息 By Id_erpre
	 * 
	 * @param erPreId
	 * @return
	 * @throws BizException
	 */
	public EnErPrePatDO getErPrePatByPreId(String erPreId) throws BizException{
		if(EnValidator.isEmpty(erPreId))
			return null;
		EnErPrePatDO[] erPrePats = getErPrePatRServ().findByAttrValString(EnErPrePatDO.ID_ERPRE, erPreId);
		return EnValidator.isEmpty(erPrePats) ? null : erPrePats[0];
	}
	/**
	 * 保存预检患者信息
	 * 
	 * @param erPrePats
	 * @return
	 * @throws BizException
	 */
	public EnErPrePatDO[] save(EnErPrePatDO[] erPrePats) throws BizException{
		if(EnValidator.isEmpty(erPrePats))
			return null;
		return getErPrePatCudServ().save(erPrePats);
	}
	/**
	 * 获取EN_ERPRE_PAT查询服务
	 * @return
	 */
	public IEnerprepatRService getErPrePatRServ(){
		return ServiceFinder.find(IEnerprepatRService.class);
	}
	/**
	 * 获取EN_ERPRE操作服务
	 * @return
	 */
	public IEnerprepatCudService getErPrePatCudServ(){
		return ServiceFinder.find(IEnerprepatCudService.class);
	}
}
