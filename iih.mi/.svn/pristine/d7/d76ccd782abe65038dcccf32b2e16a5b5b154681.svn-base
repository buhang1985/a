package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp;

import iih.bd.base.utils.AppUtils;
import iih.mi.mc.dto.d.MiMcSpecDrugLimitDTO;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.qry.GetSpecLimitListQry;

import java.util.HashMap;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 医保特殊病校验
 * 
 * @author LIM
 * @since 2019-09-26
 *
 */
public class MiCheckSpecillBP {
	/**
	 * 查询患者医保特病诊断（病种）限制药品
	 * 
	 * @param idHp
	 *            医保计划id
	 * @param idPat
	 *            患者id
	 * @param Integer
	 *            医生站开单模式
	 * @return
	 * @throws BizException
	 */
	public HashMap<String, MiMcSpecDrugLimitDTO>  exec(String idHp, String idPat, Integer orderMode) throws BizException {
		HashMap<String, MiMcSpecDrugLimitDTO>  specLimitMap= new HashMap<String, MiMcSpecDrugLimitDTO>();
		// 1.获取患者特殊病限制药品
		FDateTime serDate = AppUtils.getServerDateTime();
		GetSpecLimitListQry qry = new GetSpecLimitListQry(idHp, idPat, serDate,orderMode);
		@SuppressWarnings("unchecked")
		List<MiMcSpecDrugLimitDTO> mispecDoList = (List<MiMcSpecDrugLimitDTO>) new DAFacade()
				.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null),
						new BeanListHandler(MiMcSpecDrugLimitDTO.class));
		if (!ListUtil.isEmpty(mispecDoList)) {
			for (MiMcSpecDrugLimitDTO mispecDo : mispecDoList) {
				if (StringUtil.isEmpty(mispecDo.getId_mm()))
					continue;
				//说明：病种信息在医疗单中，病种和物品是绑定的，所以map的key为病种id+id_mm
				//    诊断和物品由于在医生站没法建立对应关系，所以map的key为id_mm
				if (orderMode == 0) {
					//组织病种限制药品map
					if (!StringUtil.isEmpty(mispecDo.getId_dsdef())&& !specLimitMap.containsKey(mispecDo.getId_dsdef()+mispecDo.getId_mm())) {
						specLimitMap.put(mispecDo.getId_dsdef()+mispecDo.getId_mm(), mispecDo);
					}
				} else {
					// 组织诊断限制药品map
					if (!StringUtil.isEmpty(mispecDo.getId_didef())&& !specLimitMap.containsKey(mispecDo.getId_mm())) {
						specLimitMap.put(mispecDo.getId_mm(), mispecDo);
					}
				}
			}

		}
		return specLimitMap;
	}
}
