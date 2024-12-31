package iih.bd.fc.s.bp.orwfcfg.match;

import iih.bd.bc.udi.pub.IBdFcDictCodeTypeConst;
import iih.bd.fc.dto.orwf.d.CfgFlowBas;
import iih.bd.fc.dto.orwf.d.WfAgeLevelDTO;
import iih.bd.fc.orwf.d.EnumBool;
import iih.bd.fc.orwf.d.EnumLong;
import iih.bd.fc.orwf.d.EnumWfCtrl;
import iih.bd.fc.orwf.d.EuOrwfDepSrcEnum;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.pub.BdFcAppUtils;
import iih.bd.fc.s.bp.common.LogUtils;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.srv.srvcate.d.SrvCateDO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 流向匹配
 * 
 * @author xuxing_2019年4月27日21:59:03
 * @version HJH 增加患者年龄限制 2019年12月26日16:19:27
 */
public class FlowFilterBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @param mapSrvca
	 * @return
	 * @throws BizException
	 */
	public HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>> exec(CfgFlowBas[] flowBas, OrWfExDeptParamDTO[] params, HashMap<OrWfExDeptParamDTO, List<String>> mapRel) throws BizException {

		// 1、基础校验
		if (flowBas == null || flowBas.length < 1)
			return null;

		// 2、计算患者年龄
		calAgeUdi(params);

		// 3、本次涉及到的全部服务分类
		initSrvcas(params);

		// 4、流向计算
		HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>> rtn = filter(flowBas, params, mapRel);

		// 5、错误配置信息写日志
		if (!StringUtil.isEmptyWithTrim(errorMsg))
			new LogUtils().logMsg("医嘱2.0流向，配置信息错误【" + errorMsg + "】");

		return rtn;
	}

	private String errorMsg = "";
	HashMap<String, SrvCateDO> mapSrvca;

	/**
	 * 初始化服务分类信息
	 * 
	 * @param deptWfs
	 * @param params
	 * @throws BizException
	 */
	@SuppressWarnings("rawtypes")
	private void initSrvcas(OrWfExDeptParamDTO[] params) throws BizException {
		mapSrvca = new HashMap<String, SrvCateDO>();
		String[] id_srvcas = WfUtils.getAttrVal(params, "Id_srvca");
		if (id_srvcas == null || id_srvcas.length < 1)
			return;
		Collection rtns = new DAFacade().findByAttrVals(SrvCateDO.class, SrvCateDO.ID_SRVCA, id_srvcas, new String[] { SrvCateDO.ID_SRVCA, SrvCateDO.NAME, SrvCateDO.INNERCODE });
		if (rtns == null || rtns.size() < 1)
			return;
		for (Object obj : rtns) {
			SrvCateDO srvca = (SrvCateDO) obj;
			mapSrvca.put(srvca.getId_srvca(), srvca);
		}
	}

	/**
	 * 逐一匹配
	 * 
	 * @param flowBas
	 * @param params
	 * @param mapRel
	 * @return
	 * @throws BizException
	 */
	private HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>> filter(CfgFlowBas[] flowBas, OrWfExDeptParamDTO[] params, HashMap<OrWfExDeptParamDTO, List<String>> mapRel) throws BizException {
		HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>> reMap = new HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>>();
		for (OrWfExDeptParamDTO param : params) {
			List<String> listWf = mapRel.get(param);
			if (listWf == null || listWf.size() < 1) {
				reMap.put(param, null);
				continue;
			}
			List<CfgFlowBas> listMatch = new ArrayList<CfgFlowBas>();
			for (CfgFlowBas flow : flowBas) {
				if (!listWf.contains(flow.getId_wf()))
					continue;
				if (isMatchSuccess(flow, param)) {
					CfgFlowBas matchItm = new CfgFlowBas();
					BeanUtils.copyProperties(flow, matchItm);
					listMatch.add(matchItm);
				}
			}
			reMap.put(param, listMatch);
		}
		return reMap;
	}

	/**
	 * 根据所传出生日期计算年龄等级 档案 年龄等级档案ID存入 入参 保留字段1
	 * 
	 * @param params
	 * @throws BizException
	 */
	private void calAgeUdi(OrWfExDeptParamDTO[] params) throws BizException {
		LogUtils log = new LogUtils();
		UdidocDO[] result = ServiceFinder.find(IUdidocServiceExt.class).findByUdidoclistCode(IBdFcDictCodeTypeConst.SD_AGE_LEVEL);
		boolean fg_success = true;
		List<WfAgeLevelDTO> listAgeLevel = new ArrayList<WfAgeLevelDTO>();
		for (UdidocDO doc : result) {
			try {
				Integer min = Integer.parseInt(doc.getCtrl1());
				Integer max = Integer.parseInt(doc.getCtrl2());
				WfAgeLevelDTO ageLevel = new WfAgeLevelDTO();
				ageLevel.setId_age_level(doc.getId_udidoc());
				ageLevel.setMin_age(min);
				ageLevel.setMax_age(max);
				listAgeLevel.add(ageLevel);
			} catch (Exception e) {
				fg_success = false;
				log.log("档案【" + IBdFcDictCodeTypeConst.SD_AGE_LEVEL + "】项【" + doc.getName() + "】上下限区间不合法！");
				break;
			}
		}
		if (!fg_success)
			return;
		FDate dt_now = new FDate();
		for (OrWfExDeptParamDTO param : params) {
			if (param.getDt_birth() == null)
				continue;
			// 年龄相减加1
			Integer age = (dt_now.getYear() - param.getDt_birth().getYear()) + 1;
			for (WfAgeLevelDTO level : listAgeLevel) {
				if (age < level.getMin_age())
					continue;
				if (age > level.getMax_age())
					continue;
				param.setId_age_level(level.getId_age_level());
				break;
			}
		}
	}

	/**
	 * 匹配
	 * 
	 * @param flow
	 * @param param
	 * @return
	 */
	private boolean isMatchSuccess(CfgFlowBas flow, OrWfExDeptParamDTO param) {
		// TODO 增加业务态和定义态区分
		// 服务分类
		if (!matchSrvca(flow, param.getId_srvca()))
			return false;
		// 服务
		if (!isMatch(flow.getId_wf_cfg(), flow.getEu_srv(), flow.getListSrv(), param.getId_srv()))
			return false;
		// 剂型
		if (!isMatch(flow.getId_wf_cfg(), flow.getEu_dosage(), flow.getListDosage(), param.getId_dosage()))
			return false;
		// 毒麻
		if (!isMatch(flow.getId_wf_cfg(), flow.getEu_pois(), flow.getListPosi(), param.getSd_pois()))
			return false;
		// 物品
		if (!isMatch(flow.getId_wf_cfg(), flow.getEu_mm(), flow.getListMm(), param.getId_mm()))
			return false;
		// 草药制剂
		if (!isMatch(flow.getId_wf_cfg(), flow.getEu_herbperp(), flow.getListHerbperp(), param.getSd_herbpreparationtp()))
			return false;
		// 开单科室
		if (!isMatch(flow.getId_wf_cfg(), flow.getEu_dep_or(), flow.getListDepor(), param.getId_dept_or()))
			return false;
		// 就诊科室
		if (!isMatch(flow.getId_wf_cfg(), flow.getEu_dep_phy(), flow.getListDepphy(), param.getId_dept_en()))
			return false;
		// 录入科室
		if (!StringUtil.isEmptyWithTrim(param.getEu_orwfexsrcmdtp()) && EuOrwfDepSrcEnum.OTSRC.equals(param.getEu_orwfexsrcmdtp()) && !isMatch(flow.getId_wf_cfg(), flow.getEu_dep_record(), flow.getListDepRecord(), param.getId_dep_record()))
			return false;
		// 护理单元
		if (!isMatch(flow.getId_wf_cfg(), flow.getEu_dep_nur(), flow.getListDepnur(), param.getId_dept_ns()))
			return false;
		// 出院带药
		if (!isEuBoolMatch(flow.getEu_pres_out(), param.getFg_pres_outp()))
			return false;
		// 是否校验医嘱内容，调用方无值时默认校验医嘱内容
		if (param.getFg_chk_or() == null || FBoolean.TRUE.equals(param.getFg_chk_or())) {
			// 长临
			if (!isEuLongMatch(flow.getEu_long(), param.getRecurstr()))
				return false;
			// 用法
			if (!isMatch(flow.getId_wf_cfg(), flow.getEu_route(), flow.getListRoute(), param.getId_usage()))
				return false;
			// 星期
			if (!isMatch(flow.getId_wf_cfg(), flow.getEu_week(), flow.getListWeek(), param.getWeekno()))
				return false;
			// 时间
			if (!isTimeBetween(flow.getTime_begin(), flow.getTime_end(), param.getTimestr()))
				return false;
		}
		// 校验年龄等级
		if (!isMatch(flow.getId_wf_cfg(), flow.getEu_age(), flow.getListAgeLevel(), param.getId_age_level())) {
			return false;
		}
		return true;
	}

	/**
	 * 服务分类匹配
	 * 
	 * @param flow
	 * @param id_srvca
	 * @return
	 */
	private boolean matchSrvca(CfgFlowBas flow, String id_srvca) {
		// 未指定是否限制的
		if (flow.getEu_srvca() == null)
			return true;
		// 指定不限制
		if (EnumWfCtrl.NONE == flow.getEu_srvca())
			return true;
		SrvCateDO srvca = mapSrvca.get(id_srvca);
		if (srvca == null)
			return false;
		// 服务分类无内码
		if (StringUtil.isEmptyWithTrim(srvca.getInnercode()))
			return false;
		List<String> listSrvcas = flow.getListSrvcaInnercode();
		if (listSrvcas == null || listSrvcas.size() < 1)
			return false;
		// 限制
		if (EnumWfCtrl.CTRL == flow.getEu_srvca()) {
			for (String innercode : listSrvcas) {
				// 服务分类向下匹配
				if (srvca.getInnercode().indexOf(innercode) == 0)
					return true;
			}
			return false;
		}
		// 排除
		if (EnumWfCtrl.EXCLUDE == flow.getEu_srvca()) {
			for (String innercode : listSrvcas) {
				// 服务分类向下匹配
				if (srvca.getInnercode().indexOf(innercode) == 0)
					return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 控制属性
	 * 
	 * @param id_wf_cfg
	 * @param eu_ctrl
	 * @param listKey
	 * @param val
	 * @return
	 */
	private boolean isMatch(String id_wf_cfg, Integer eu_ctrl, List<String> listKey, String val) {
		// 未指定是否限制的
		if (eu_ctrl == null)
			return true;
		// 指定不限制
		if (EnumWfCtrl.NONE == eu_ctrl)
			return true;
		// 限制集合为空，基础数据维护不正确，当限制失败处理
		if (listKey == null || listKey.size() < 1) {
			// 记录日志
			errorMsg += "【" + id_wf_cfg + "】";
			return false;
		}
		// 业务值为空
		if (StringUtil.isEmptyWithTrim(val))
			return false;
		// 控制
		if (EnumWfCtrl.CTRL == eu_ctrl)
			return listKey.contains(val);
		// 排除
		if (EnumWfCtrl.EXCLUDE == eu_ctrl)
			return !listKey.contains(val);
		return false;
	}

	/**
	 * bool类属性控制
	 * 
	 * @param eu_bool
	 * @param fg_bool
	 * @return
	 */
	private boolean isEuBoolMatch(Integer eu_bool, FBoolean fg_bool) {
		// 未指定是否限制的bool
		if (eu_bool == null)
			return true;
		if (EnumBool.NULL == eu_bool)
			return true;
		if (fg_bool == null)
			return false;
		if (EnumBool.TRUE == eu_bool)
			return FBoolean.TRUE.equals(fg_bool);
		if (EnumBool.FALSE == eu_bool)
			return FBoolean.FALSE.equals(fg_bool);
		return false;
	}

	/**
	 * 医嘱周期类型控制
	 * 
	 * @param eu_long
	 * @param fg_long
	 * @return
	 */
	private boolean isEuLongMatch(Integer eu_long, String longStr) {
		// 未指定是否限制的bool
		if (eu_long == null)
			return true;
		if (EnumLong.NULL == eu_long)
			return true;
		if (StringUtil.isEmptyWithTrim(longStr))
			return false;
		if (EnumLong.LONG == eu_long)
			return longStr.equals(EnumLong.LONG + "");
		if (EnumLong.TEMP == eu_long)
			return longStr.equals(EnumLong.TEMP + "");
		return false;
	}

	/**
	 * 时间区间校验
	 * 
	 * @param bg
	 * @param ed
	 * @param time
	 * @return
	 */
	public boolean isTimeBetween(FTime bg, FTime ed, FTime time) {
		if (bg != null && ed != null) {
			FTime inputTime = time;
			if (time == null)
				inputTime = BdFcAppUtils.getServerDateTime().getUFTime();
			if (inputTime.before(bg) || inputTime.after(ed))
				return false;
		}
		return true;
	}
}
