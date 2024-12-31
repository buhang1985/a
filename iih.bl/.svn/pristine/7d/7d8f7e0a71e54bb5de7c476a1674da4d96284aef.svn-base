package iih.bl.st.s.bp.ip;

import java.util.HashMap;
import java.util.Map;

import com.enterprisewechat.cp.util.StringUtils;

import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blauditip.i.IBlauditipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 校验患者医保审核状态
 * @author wangyanjun
 *
 */
public class IpHpAuditStatusCheckBp {
	
	/**
	 * 校验患者医保审核状态
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	public FMap exec(String id_ent) throws BizException{
		
		IBlauditipMDORService blauditipMDORService = ServiceFinder.find(IBlauditipMDORService.class);
		checkParam(id_ent);

		FMap map = new FMap();
		String whereStr = "id_ent = '"+id_ent+"'";
		BlAuditIp[] blAuditIp = blauditipMDORService.find(whereStr, "dt_audit_hp desc", FBoolean.FALSE);
		if(blAuditIp==null && blAuditIp.length==0){
			map.put("0", "医保未审核");
		}else if(("N".equals(blAuditIp[0].getFg_pass_hp().booleanValue()||"~".equals(blAuditIp[0].getFg_pass_hp().booleanValue())|| blAuditIp[0].getFg_pass_hp() ==null)&&(blAuditIp[0].getId_emp_canc_hp()== null || "~".equals(blAuditIp[0].getFg_pass_hp().booleanValue())))){
			map.put("0", "医保未审核");
		}else if("N".equals(blAuditIp[0].getFg_pass_hp().booleanValue() && blAuditIp[0].getId_emp_canc_hp()!= null && !"~".equals(blAuditIp[0].getId_emp_canc_hp()))){
			map.put("1", "医保审核未通过");
		}else if("N".equals(blAuditIp[0].getFg_pass_hp().booleanValue())){
			map.put("2", "通过医保审核");
		}
		return map;
	}
	
	/**
	 * 校验入参
	 * 
	 * @param patRegAndDistrInfo
	 * @throws BizException
	 */
	private void checkParam(String id_ent) throws BizException {
		if (StringUtils.isEmpty(id_ent)) {
			throw new BizException("患者就诊id不允许为空。");
		}
	}
	
}
