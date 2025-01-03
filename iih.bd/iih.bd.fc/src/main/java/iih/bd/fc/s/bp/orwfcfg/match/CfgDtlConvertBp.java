package iih.bd.fc.s.bp.orwfcfg.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.fc.dto.orwf.d.CfgFlowBas;
import iih.bd.fc.dto.orwf.d.WfCfgDTO;
import xap.mw.core.utils.StringUtil;

/**
 * @Description:流向2.0配置数据转换
 * @author: xu_xing@founder.com.cn
 * @version：2019年4月29日 下午3:19:02 创建
 * @version: 2019年12月26日15:21:19 hjh  增加年龄等级的匹配算法
 * @version: zhongcl 2020年6月22日13:51:40 增加录入科室限制
 */
public class CfgDtlConvertBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @return
	 */
	public CfgFlowBas[] exec(WfCfgDTO[] params) {

		//1、基础校验
		if (params == null || params.length < 1)
			return null;

		//2、数据转换
		CfgFlowBas[] rtns = convert(params);

		return rtns;
	}

	private CfgFlowBas[] convert(WfCfgDTO[] params) {
		List<CfgFlowBas> reList = new ArrayList<CfgFlowBas>();
		HashMap<String, CfgFlowBas> mapCfg = new HashMap<String, CfgFlowBas>();
		for (WfCfgDTO param : params) {
			if (!mapCfg.containsKey(param.getId_wf_cfg())) {
				CfgFlowBas flowBas = initCfgFlow(param);
				mapCfg.put(param.getId_wf_cfg(), flowBas);
				reList.add(flowBas);
			}
			CfgFlowBas flowBas = mapCfg.get(param.getId_wf_cfg());
			addToList(flowBas.getListSrvca(), param.getId_srvca());
			addToList(flowBas.getListSrvcaInnercode(), param.getInnercode());
			addToList(flowBas.getListSrv(), param.getId_srv());
			//剂型使用的是ID
			addToList(flowBas.getListDosage(), param.getId_dosage());
			//年龄等级
			addToList(flowBas.getListAgeLevel(), param.getId_age_level());
			addToList(flowBas.getListPosi(), param.getSd_pois());
			addToList(flowBas.getListMm(), param.getId_mm());
			addToList(flowBas.getListHerbperp(), param.getSd_herbperp());
			addToList(flowBas.getListDepor(), param.getId_dep_or());
			addToList(flowBas.getListDepphy(), param.getId_dep_phy());
			addToList(flowBas.getListDepRecord(), param.getId_dep_record());
			addToList(flowBas.getListDepnur(), param.getId_dep_nur());
			addToList(flowBas.getListRoute(), param.getId_route());
			addToList(flowBas.getListWeek(), param.getSd_week());
		}
		return reList.toArray(new CfgFlowBas[0]);
	}

	/**
	 * 数据转换
	 * 
	 * @param param
	 * @return
	 */
	private CfgFlowBas initCfgFlow(WfCfgDTO param) {
		CfgFlowBas rtn = new CfgFlowBas();
		rtn.setId_wf_cfg(param.getId_wf_cfg());
		rtn.setId_wf(param.getId_wf());
		rtn.setEu_wftp(param.getEu_wftp());
		rtn.setSortno(param.getSortno());
		rtn.setFg_macro(param.getFg_macro());
		rtn.setEu_macro(param.getEu_macro());
		rtn.setId_dep_mp(param.getId_dep_mp());
		rtn.setEu_srvca(param.getEu_srvca());
		rtn.setEu_srv(param.getEu_srv());
		rtn.setEu_dosage(param.getEu_dosage());
		rtn.setEu_pois(param.getEu_pois());
		rtn.setEu_mm(param.getEu_mm());
		rtn.setEu_dep_or(param.getEu_dep_or());
		rtn.setEu_dep_phy(param.getEu_dep_phy());
		rtn.setEu_dep_record(param.getEu_dep_record());
		rtn.setEu_dep_nur(param.getEu_dep_nur());
		rtn.setEu_route(param.getEu_route());
		rtn.setEu_week(param.getEu_week());
		rtn.setEu_long(param.getEu_long());
		rtn.setEu_pres_out(param.getEu_pres_out());
		rtn.setEu_herbperp(param.getEu_herbperp());
		rtn.setFg_mmwh(param.getFg_mmwh());
		rtn.setEu_age(param.getEu_age());
		rtn.setFg_stock(param.getFg_stock());
		rtn.setTime_begin(param.getTime_begin());
		rtn.setTime_end(param.getTime_end());
		rtn.setListSrvca(new ArrayList<String>());
		rtn.setListSrvcaInnercode(new ArrayList<String>());
		rtn.setListSrv(new ArrayList<String>());
		rtn.setListDosage(new ArrayList<String>());
		rtn.setListPosi(new ArrayList<String>());
		rtn.setListMm(new ArrayList<String>());
		rtn.setListHerbperp(new ArrayList<String>());
		rtn.setListDepor(new ArrayList<String>());
		rtn.setListDepphy(new ArrayList<String>());
		rtn.setListDepRecord(new ArrayList<String>());
		rtn.setListDepnur(new ArrayList<String>());
		rtn.setListRoute(new ArrayList<String>());
		rtn.setListWeek(new ArrayList<String>());
		rtn.setListAgeLevel(new ArrayList<String>());
		return rtn;
	}

	/**
	 * 添加到集合
	 * 
	 * @param list
	 * @param val
	 */
	private void addToList(List<String> list, String val) {
		if (StringUtil.isEmptyWithTrim(val))
			return;
		if (list.contains(val))
			return;
		list.add(val);
	}
}
