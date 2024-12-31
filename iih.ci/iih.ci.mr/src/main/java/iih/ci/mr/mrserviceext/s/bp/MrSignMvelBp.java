package iih.ci.mr.mrserviceext.s.bp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.en.pv.dto.d.ResultDTO;
import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

public class MrSignMvelBp {

	public String exec(String id_ent,String id_user) throws BizException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_ent", id_ent);
		map.put("id_user", id_user);
		Map<String, Object> rstMap = XapRuleAPI.exeRule(IMrSysParamConst.MR_MRSIGN_RULEPKG_CONST, map);
		return DealResult(rstMap);
	}
	
	
	/**
	 * 处理规则结果信息
	 * 
	 * @param rstMap
	 * @return
	 */
	public static String DealResult(Map<String, Object> rstMap) {
		ResultDTO rst = new ResultDTO();
		if (rstMap == null || rstMap.isEmpty()){
			rst.setFlag(FBoolean.TRUE);
			return "";
		}
		StringBuilder rstSb = new StringBuilder();
		boolean rstFlag = true;
		Set<String> rstKetSet = rstMap.keySet();
		
		for (String key : rstKetSet) {
			// 结果
			Object result = rstMap.get(key);
			if (result != null && !StringUtil.isEmptyWithTrim(result.toString())) {
				rstFlag = false;
				rstSb.append(result.toString());
			}
		}
		rst.setFlag(new FBoolean(rstFlag));
		rst.setMsg(rstSb.toString());
		return rstSb.toString();
	}
}
