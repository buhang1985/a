package iih.bd.fc.orwf.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.orwf.d.EnumAttr;
import iih.bd.fc.orwf.d.EnumWfCtrl;
import iih.bd.fc.orwf.d.OrWfCfgDO;
import iih.bd.fc.orwf.d.OrwfAggDO;
import iih.bd.fc.orwf.d.WfCfgAttrDO;
import iih.bd.fc.orwf.i.IOrwfCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @Description:医嘱流向配置保存
 * @author: xu_xing@founder.com.cn
 * @version：2019年4月20日 上午9:35:49 创建
 * @version: 2019年5月13日10:52:42，xuxing，不限制时，子项清空全部数据
 * @version： xuxing_2019年5月14日18:06:26，修正校验逻辑错误
 */
public class OrWfCfgSaveBp {

	/**
	 * 主入口
	 * @param params
	 * @throws BizException
	 */
	public OrwfAggDO[] exec(OrwfAggDO[] params) throws BizException {

		//1、基础校验
		if (params == null || params.length < 1)
			return null;

		//2、合法性校验
		String error = validation(params);
		if (!StringUtil.isEmptyWithTrim(error))
			throw new BizException("医嘱流向配置保存:\r\n" + error);

		//3、清洗数据
		clearData(params);

		//4、赋初始值
		initVal(params);

		//5、保存
		OrwfAggDO[] rtns = save(params);

		return rtns;

	}

	/**
	 * 基础校验
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private String validation(OrwfAggDO[] params) throws BizException {
		StringBuffer rtnError = new StringBuffer();
		for (OrwfAggDO param : params) {
			if (DOStatus.DELETED == param.getParentDO().getStatus())
				continue;
			if (param.getParentDO() == null)
				throw new BizException("医嘱流向配置保存，配置空异常！");
			OrWfCfgDO parent = param.getParentDO();
			if (StringUtil.isEmptyWithTrim(parent.getId_wf()))
				throw new BizException("医嘱流向配置保存，请指定配置所属流向！");
			if (FBoolean.TRUE.equals(parent.getFg_macro())) {
				parent.setId_dep_mp(null);
				if (parent.getEu_macro() == null)
					throw new BizException("医嘱流向配置保存，请指定宏！");
			} else {
				parent.setEu_macro(null);
				if (StringUtil.isEmptyWithTrim(parent.getId_dep_mp()))
					throw new BizException("医嘱流向配置保存，非宏请指定具体的执行科室！");
			}
			List<WfCfgAttrDO> listSaveAttr = new ArrayList<WfCfgAttrDO>();
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_SRVCA, EnumAttr.SRVCA, WfCfgAttrDO.ID_SRVCA, "服务分类"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_SRV, EnumAttr.SRV, WfCfgAttrDO.ID_SRV, "医疗服务"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_DOSAGE, EnumAttr.DOSAGE, WfCfgAttrDO.ID_DOSAGE, "药品剂型"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_POIS, EnumAttr.POSI, WfCfgAttrDO.ID_POIS, "毒麻分类"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_MM, EnumAttr.MM, WfCfgAttrDO.ID_MM, "物品"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_HERBPERP, EnumAttr.HERBPERP, WfCfgAttrDO.ID_HERBPERP, "草药制剂"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_DEP_OR, EnumAttr.DEPOR, WfCfgAttrDO.ID_DEP, "开单科室"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_DEP_PHY, EnumAttr.DEPPHY, WfCfgAttrDO.ID_DEP, "就诊科室"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_DEP_NUR, EnumAttr.DEPNUR, WfCfgAttrDO.ID_DEP, "护理单元"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_ROUTE, EnumAttr.ROUTE, WfCfgAttrDO.ID_ROUTE, "用法"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_WEEK, EnumAttr.WEEK, WfCfgAttrDO.ID_WEEK, "星期"));
			rtnError.append(valCfgAttr(param, listSaveAttr, OrWfCfgDO.EU_AGE, EnumAttr.AGELEVEL, WfCfgAttrDO.ID_AGE_LEVEL, "年龄等级"));
		}
		return rtnError.toString();
	}

	/**
	 * 业务合法性校验
	 * @param eu_val
	 * @param eu_attr
	 * @param listAttr
	 * @throws BizException 
	 */
	private String valCfgAttr(OrwfAggDO param, List<WfCfgAttrDO> listSaveAttr, String attrParent, Integer eu_attr, String attrChild, String nameAttr) throws BizException {
		if (param == null)
			return "";
		if (param.getParentDO().getAttrVal(attrParent) == null)
			return "【" + nameAttr + "】必须指定限制类型【限制，不限制，排除】！";
		Integer eu_val = (Integer) param.getParentDO().getAttrVal(attrParent);
		if (EnumWfCtrl.NONE.equals(eu_val)) {
			//不限制的清空子数据
			if (param.getWfCfgAttrDO() != null && param.getWfCfgAttrDO().length > 0) {
				for (WfCfgAttrDO attr : param.getWfCfgAttrDO()) {
					if (!eu_attr.equals(attr.getEu_attr()))
						continue;
					if (DOStatus.DELETED == attr.getStatus())
						continue;
					if (DOStatus.NEW == attr.getStatus())
						attr.setStatus(DOStatus.UNCHANGED);
					if (DOStatus.UNCHANGED == attr.getStatus() || DOStatus.UPDATED == attr.getStatus())
						attr.setStatus(DOStatus.DELETED);
				}
			}
			return "";
		}
		List<WfCfgAttrDO> listChk = new ArrayList<WfCfgAttrDO>();
		//限制或者排除的，校验子数据
		if (param.getWfCfgAttrDO() != null && param.getWfCfgAttrDO().length > 0) {
			for (WfCfgAttrDO attr : param.getWfCfgAttrDO()) {
				if (!eu_attr.equals(attr.getEu_attr()))
					continue;
				if (DOStatus.DELETED == attr.getStatus())
					continue;
				Object val = attr.getAttrVal(attrChild);
				if (val == null)
					continue;
				listChk.add(attr);
			}
		}
		if (listChk == null || listChk.size() < 1) {
			String nameCtrl = "限制";
			if (EnumWfCtrl.EXCLUDE.equals(eu_val))
				nameCtrl = "排除";
			return "【" + nameAttr + "】必须指定【" + nameCtrl + "】项！";
		}
		return "";
	}

	/**
	 * 清洗数据
	 * @param params
	 */
	private void clearData(OrwfAggDO[] params) {
		for (OrwfAggDO agg : params) {
			if (agg.getWfCfgAttrDO() != null && agg.getWfCfgAttrDO().length > 0) {
				List<WfCfgAttrDO> listAttr = new ArrayList<WfCfgAttrDO>();
				for (WfCfgAttrDO attr : agg.getWfCfgAttrDO()) {
					if (attr.getEu_attr() == null)
						continue;
					boolean fg_srvca = StringUtil.isEmptyWithTrim(attr.getId_srvca());
					boolean fg_srv = StringUtil.isEmptyWithTrim(attr.getId_srv());
					boolean fg_dosage = StringUtil.isEmptyWithTrim(attr.getId_dosage());
					boolean fg_pois = StringUtil.isEmptyWithTrim(attr.getId_pois());
					boolean fg_mm = StringUtil.isEmptyWithTrim(attr.getId_mm());
					boolean fg_herbperp = StringUtil.isEmptyWithTrim(attr.getId_herbperp());
					boolean fg_dep = StringUtil.isEmptyWithTrim(attr.getId_dep());
					boolean fg_route = StringUtil.isEmptyWithTrim(attr.getId_route());
					boolean fg_week = StringUtil.isEmptyWithTrim(attr.getId_week());
					boolean fg_age = StringUtil.isEmptyWithTrim(attr.getId_age_level());
					if (fg_srvca && fg_srv && fg_dosage && fg_dosage && fg_pois && fg_mm && fg_herbperp && fg_dep && fg_route && fg_week && fg_age)
						continue;
					listAttr.add(attr);
				}
				agg.setWfCfgAttrDO(listAttr.toArray(new WfCfgAttrDO[0]));
			}
		}
	}

	/**
	 * 初始值
	 * @param params
	 */
	private void initVal(OrwfAggDO[] params) {
		for (OrwfAggDO agg : params) {
			if (DOStatus.NEW == agg.getParentDO().getStatus()) {
				agg.getParentDO().setPkVal(null);
				if (agg.getWfCfgAttrDO() != null && agg.getWfCfgAttrDO().length > 0) {
					for (WfCfgAttrDO attr : agg.getWfCfgAttrDO()) {
						attr.setPkVal(null);
					}
				}
			} else if (DOStatus.UNCHANGED == agg.getParentDO().getStatus()) {
				agg.getParentDO().setStatus(DOStatus.UPDATED);
			}
		}
	}

	/**
	 * 保存
	 * @param params
	 * @throws BizException
	 */
	private OrwfAggDO[] save(OrwfAggDO[] params) throws BizException {
		return ServiceFinder.find(IOrwfCudService.class).save(params);
	}
}
