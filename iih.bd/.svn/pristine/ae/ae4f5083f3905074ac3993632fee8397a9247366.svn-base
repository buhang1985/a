package iih.bd.pp.s.bp;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.bdprewarn.d.TypeEnum;
import iih.bd.pp.bdprewarn.d.desc.BdPreWarnDODesc;
import iih.bd.pp.bdprewarn.i.IBdprewarnMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取预交金警告策略
 * @author ly 2018/07/11
 *
 */
public class GetPreWarnInfoBP {

	/**
	 * 获取预交金警告策略
	 * 优先科室策略
	 * @param depId 科室id
	 * @param patcaId 患者分类id
	 * @param codeEntp 就诊类型编码
	 * @return 
	 * @throws BizException
	 */
	public BdPreWarnDO exec(String depId,String patcaId,String codeEntp) throws BizException{
		
		this.validate(depId, patcaId, codeEntp);
		
		String a0 = BdPreWarnDODesc.TABLE_ALIAS_NAME;
		String whereSql = String.format("%s.%s = '%s' and %s.%s = '%s' and (%s.%s = '%s' ", 
				a0,BdPreWarnDO.ID_PATCA, patcaId, 
				a0,BdPreWarnDO.CODE_ENTP,codeEntp,
				a0,BdPreWarnDO.EU_PREWARNTP, TypeEnum.WHOLEHOS);
		
		if(!StringUtil.isEmpty(depId)){
			whereSql += String.format(" or (%s.%s = '%s' and %s.%s = '%s')",
					a0,BdPreWarnDO.EU_PREWARNTP, TypeEnum.DEPARTMENT,
					a0,BdPreWarnDO.ID_DEP, depId);
		}
		whereSql += ")";
		
		IBdprewarnMDORService rService = ServiceFinder.find(IBdprewarnMDORService.class);
		BdPreWarnDO[] warnDos = rService.find(whereSql, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(warnDos))
			return null;
		
		for (BdPreWarnDO warnDO : warnDos) {
			if(TypeEnum.DEPARTMENT.equals(warnDO.getEu_prewarntp()))
				return warnDO;
		}
		
		return warnDos[0];
	}
	
	/**
	 * 校验
	 * @param depId
	 * @param patcaId
	 * @param codeEntp
	 * @throws BizException
	 */
	private void validate(String depId,String patcaId,String codeEntp)throws BizException{
		
		if(StringUtil.isEmpty(patcaId)){
			throw new ArgumentNullException("获取预交金警告策略", "患者分类id");
		}
		
		if(StringUtil.isEmpty(codeEntp)){
			throw new ArgumentNullException("获取预交金警告策略", "就诊类型编码");
		}
	}
}
