package iih.en.pv.s.rule;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnRuleConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.pv.s.bp.op.CheckPermitRegByMvelBp;
import iih.pi.reg.pat.d.PatDO;

import java.util.HashMap;
import java.util.Map;

import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 
 * 入院登记规则引擎校验
 * 
 * @author liubin
 * 
 * 下午4:28:54
 */
public class CheckIpRegitsRuleBP {
	/**
	 * 入院登记规则校验
	 * 
	 * @author liubin
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void check(RegRuleDTO regRule, EnHosRegDTO enHosRegDTO) throws BizException {
		if(EnValidator.isEmpty(regRule.getId_pat()))
			throw new BizException("规则引擎：患者信息不能为空！");
		PatDO patDo = (PatDO) new DAFacade().findByPK(PatDO.class, regRule.getId_pat());
		if(patDo == null)
			throw new BizException("规则引擎：患者信息不能为空！");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(PatDO.class.getSimpleName(), patDo);
		map.put(RegRuleDTO.class.getSimpleName(), regRule);
		map.put("SdStatus",enHosRegDTO.getSd_status());
		map.put("DtEntry",enHosRegDTO.getDt_entry().getDate().toString());
		map.put("SystemDate", EnAppUtils.getServerDate().toString());
		ResultDTO result = CheckMvelRuleResultPro.check(IEnRuleConst.EN_IP_RULEPKG_CONST, map);
	}
	
	/**
	 * 入院登记规则校验
	 * @author zhangpp
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public ResultDTO check2(EnHosPatDTO enHosPat, EnHosRegDTO EnHostReg) throws BizException {
		if(EnValidator.isEmpty(enHosPat.getId_pat())){
			throw new BizException("规则引擎：患者信息不能为空！");
		}
		PatDO patDo = (PatDO) new DAFacade().findByPK(PatDO.class, enHosPat.getId_pat());
		if(patDo == null){
			throw new BizException("规则引擎：患者信息不能为空！");
		}
		RegRuleDTO regRule= new RegRuleDTO();
		regRule.setId_pat(enHosPat.getId_pat());
		regRule.setId_dept(EnHostReg.getId_dep_phyadm());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(PatDO.class.getSimpleName(), patDo);
		map.put(RegRuleDTO.class.getSimpleName(), regRule);
		map.put("SdStatus",EnHostReg.getSd_status());
		map.put("DtEntry",EnHostReg.getDt_entry().getDate().toString());
		map.put("SystemDate", EnAppUtils.getServerDate().toString());	
		ResultDTO result = CheckMvelRuleResultPro.check(IEnRuleConst.EN_IP_RULEPKG_CONST, map);
		return result;
	}
	
	/**
	 * 入院登记规则校验
	 * 
	 * @author yhl
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public ResultDTO exec2(String pkgCode, String patId) throws BizException{
		if (!!EnValidator.isEmpty(pkgCode))
			throw new BizException("规则引擎：规则包编码不能为空！");
		if (!!EnValidator.isEmpty(patId))
			return new ResultDTO();
		PatDO pat = (PatDO) new DAFacade().findByPK(PatDO.class, patId);
		Map<String, Object> map = this.orzParam(pat);
		// 调用规则引擎 进行校验
		Map<String, Object> rstMap = XapRuleAPI.exeRule(pkgCode, map);
		ResultDTO result = new CheckPermitRegByMvelBp().DealResult(rstMap);
		return result;
	}
	/**
	 * 组装map信息
	 * @param patDo 患者信息
	 * @param deptId 部門id
	 * @param regDate入院时间
	 * @return
	 */
	private Map<String, Object> orzParam(PatDO patDo) {
		Map<String, Object> map = new HashMap<>();
		map.put(PatDO.class.getSimpleName(), patDo);
		return map;
	}
}
