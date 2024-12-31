package iih.bl.hp.hpque.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpIndicationRuleEnum;
import iih.bd.pp.service.i.IPpQueService;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import xap.lui.core.scriptrule.XapScriptAPI;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetHpIndicationBp {
	/**
	 * 根据id_pat，就诊的主医保计划，医嘱项目，返回含医保适应症提示的医疗服务数组
	 * 
	 * @param bdHpIndicationDTOArr
	 *            (患者主键,主医保计划,医疗服务数组)
	 * @return 含医保适应症提示的医疗服务数组
	 *         （患者主键,主医保计划,医疗服务相关数据，医保目录类型sd_hpsrvtp,id_hpsrvtp，判断方式
	 *         ，系统判断结果fg_indic，医保限制条件des_hplimit）
	 * @throws BizException
	 */
	public BdHpIndicationDTO[] exec(BdHpIndicationDTO[] bdHpIndicationDTOArr) throws BizException {
		// TODO Auto-generated method stub
		IPpQueService iPpQueService = ServiceFinder.find(IPpQueService.class);

		// 1.获得药品分类
		HPSrvorcaDO[] hPSrvorcaDOArr = null;
		List<String> id_srvLst = new ArrayList<String>();
		for (BdHpIndicationDTO bdHpIndicationDTO : bdHpIndicationDTOArr) {
			if (bdHpIndicationDTO == null) {
				// String xx="";
				continue;
			}
			if (bdHpIndicationDTO.getId_mm() == null || bdHpIndicationDTO.getId_mm().trim().length() == 0) {
				hPSrvorcaDOArr = iPpQueService.getHPSrvorcaDOByIdsrvIdHP(bdHpIndicationDTO.getId_hp(), new String[] { bdHpIndicationDTO.getId_srv() });
			} else {
				hPSrvorcaDOArr = iPpQueService.getHPSrvorcaDOByIdmmIdHP(bdHpIndicationDTO.getId_hp(), new String[] { bdHpIndicationDTO.getId_mm() });
			}
			if (hPSrvorcaDOArr == null || hPSrvorcaDOArr.length == 0) {
				bdHpIndicationDTO.setFg_indic(FBoolean.FALSE);// 保外,系统判断结果
				bdHpIndicationDTO.setDes_hplimit("不在医保目录对照表中"); // 医保限制条件
				bdHpIndicationDTO.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);// 来源于自定义档案
				bdHpIndicationDTO.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
				bdHpIndicationDTO.setCode_hpindicjudged(null);// 判断方式
			} else {
				if (hPSrvorcaDOArr[0].getSd_hpsrvtp() != null && hPSrvorcaDOArr[0].getSd_hpsrvtp().equals(IBdPpCodeTypeConst.SD_HP_BJ_THREE)) // 丙级
				{
					// 医保目录等级 = 丙级
					// 适应症判断方式 = 任意
					// 系统判断结果 = 任意
					// 适应症描述信息 = 任意

					// Fg_hpindicjudged:判断方式
					// Fg_indic:系统判断结果
					// Id_hpsrvtp:医保目录类型
					// Sd_hpsrvtp:医保目录类型
					// Des_hplimit：医保限制条件

					bdHpIndicationDTO.setFg_indic(FBoolean.FALSE);// 保外,系统判断结果
					bdHpIndicationDTO.setDes_hplimit(hPSrvorcaDOArr[0].getDes()); // 医保限制条件
					bdHpIndicationDTO.setSd_hpsrvtp(hPSrvorcaDOArr[0].getSd_hpsrvtp());
					bdHpIndicationDTO.setId_hpsrvtp(hPSrvorcaDOArr[0].getId_hpsrvtp());
					bdHpIndicationDTO.setCode_hpindicjudged(null);// 判断方式
				} else {
					if (hPSrvorcaDOArr[0].getEu_hpsrvctrtp() != null && hPSrvorcaDOArr[0].getEu_hpsrvctrtp().equals(HpIndicationRuleEnum.NO_CONTROL))// 不控制
					{
						// 医保目录等级 = 甲级或乙级
						// 适应症判断方式 = 01 不控制
						// 系统判断结果 = 任意
						// 适应症描述信息 = 任意

						// Fg_hpindicjudged:判断方式
						// Fg_indic:系统判断结果
						// Id_hpsrvtp:医保目录类型
						// Sd_hpsrvtp:医保目录类型
						// Des_hplimit：医保限制条件

						bdHpIndicationDTO.setFg_indic(FBoolean.TRUE);// 保外,系统判断结果
						bdHpIndicationDTO.setDes_hplimit(hPSrvorcaDOArr[0].getDes()); // 医保限制条件
						bdHpIndicationDTO.setSd_hpsrvtp(hPSrvorcaDOArr[0].getSd_hpsrvtp());
						bdHpIndicationDTO.setId_hpsrvtp(hPSrvorcaDOArr[0].getId_hpsrvtp());
						bdHpIndicationDTO.setCode_hpindicjudged(hPSrvorcaDOArr[0].getEu_hpsrvctrtp());// 判断方式
					} else if (hPSrvorcaDOArr[0].getEu_hpsrvctrtp() != null && hPSrvorcaDOArr[0].getEu_hpsrvctrtp().equals(HpIndicationRuleEnum.DOC_CONFIRM)) // 医生控制
					{
						// 医保目录等级 = 甲级或乙级
						// 适应症判断方式 = 21 医生判断及确认
						// 系统判断结果 = 任意
						// 适应症描述信息 = 任意

						// Fg_hpindicjudged:判断方式
						// Fg_indic:系统判断结果
						// Id_hpsrvtp:医保目录类型
						// Sd_hpsrvtp:医保目录类型
						// Des_hplimit：医保限制条件
						// 需要
						bdHpIndicationDTO.setFg_indic(null);// 保外,系统判断结果
						bdHpIndicationDTO.setDes_hplimit(hPSrvorcaDOArr[0].getDes()); // 医保限制条件
						bdHpIndicationDTO.setSd_hpsrvtp(hPSrvorcaDOArr[0].getSd_hpsrvtp());
						bdHpIndicationDTO.setId_hpsrvtp(hPSrvorcaDOArr[0].getId_hpsrvtp());
						bdHpIndicationDTO.setCode_hpindicjudged(hPSrvorcaDOArr[0].getEu_hpsrvctrtp());// 判断方式

					} else // 11或12,获取系统判断规则
					{
						// BdHpIndicationDTO
						// BdHpIndicationDTO=bdHpIndicationDTO;
						Map<String, Object> variable = new HashMap<String, Object>();
						variable.put("BdHpIndicationDTO", bdHpIndicationDTO);
						Boolean result = false;
						// 判断id_rule 如果不等于空的时候提交调用
						if (hPSrvorcaDOArr[0].getId_rule() != null && !"".equals(hPSrvorcaDOArr[0].getId_rule()))
							result = (Boolean) XapScriptAPI.compileExeSingleRule(hPSrvorcaDOArr[0].getId_rule(), variable); // 单个脚本
						// Boolean result=XapScriptAPI.Rule("BD.HP.Indication",
						// variable,""); //所有规则
						// Boolean result=testRule(bdHpIndicationDTO);
						// if (result) {
						// // throw new
						// //
						// BizException("医保校验规则判断失误，请检查！\r\n医保项目："+hPSrvorcaDOArr[0].getName()+" 规则："+hPSrvorcaDOArr[0].getId_rule());
						// } else {
						// throw new BizException("医保校验规则判断失误，请检查！\r\n医保项目：" +
						// hPSrvorcaDOArr[0].getName() + " 规则：" +
						// hPSrvorcaDOArr[0].getId_rule());
						// }
						if (result == null)
							throw new BizException("医保校验规则判断失误，请检查！\r\n医保项目：" + hPSrvorcaDOArr[0].getName() + " 规则：" + hPSrvorcaDOArr[0].getId_rule());

						if (result) // 符合规则
						{
							// 医保目录等级 = 甲级或乙级
							// 适应症判断方式 = 11 系统判断及确认
							// 系统判断结果 = Y
							// 适应症描述信息 = 任意
							// bdHpIndicationDTO.setFg_indic(null);
							// if(hPSrvorcaDOArr[0].getEu_hpsrvctrtp().equals(HpIndicationRuleEnum.SYS_CONFIRM))
							// {
							bdHpIndicationDTO.setFg_indic(FBoolean.TRUE);
							// }
						} else {
							// 医保目录等级 = 甲级或乙级
							// 适应症判断方式 = 11 系统判断及确认
							// 系统判断结果 = N
							// 适应症描述信息 = 任意
							// bdHpIndicationDTO.setFg_indic(null);
							// if(hPSrvorcaDOArr[0].getEu_hpsrvctrtp().equals(HpIndicationRuleEnum.SYS_CONFIRM))
							// {
							bdHpIndicationDTO.setFg_indic(FBoolean.FALSE);
							// }
						}
						bdHpIndicationDTO.setDes_hplimit(hPSrvorcaDOArr[0].getDes()); // 医保限制条件
						bdHpIndicationDTO.setSd_hpsrvtp(hPSrvorcaDOArr[0].getSd_hpsrvtp());
						bdHpIndicationDTO.setId_hpsrvtp(hPSrvorcaDOArr[0].getId_hpsrvtp());
						bdHpIndicationDTO.setCode_hpindicjudged(hPSrvorcaDOArr[0].getEu_hpsrvctrtp());// 判断方式
					}

				}
			}
		}
		return bdHpIndicationDTOArr;
	}
}
