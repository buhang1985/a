package iih.bd.fc.s.bp.orwfcfg.upgrade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ymer.core.xml.StringUtils;

import iih.bd.fc.orwf.d.EnumAttr;
import iih.bd.fc.orwf.d.EnumBool;
import iih.bd.fc.orwf.d.EnumLong;
import iih.bd.fc.orwf.d.EnumWfCtrl;
import iih.bd.fc.orwf.d.OrWfCfgDO;
import iih.bd.fc.orwf.d.OrwfAggDO;
import iih.bd.fc.orwf.d.WfCfgAttrDO;
import iih.bd.fc.orwf.i.IOrwfCudService;
import iih.bd.fc.orwf.i.IOrwfRService;
import iih.bd.fc.orwf.i.IWfCfgAttrDOCudService;
import iih.bd.fc.s.bp.orwfcfg.qry.QueryUpGradeCodeSql;
import iih.bd.fc.wf.d.WfDepDO;
import iih.bd.fc.wf.i.IWfDepDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 
 * @Description: 医嘱流向数据转存
 * @author : dukx
 * @version 2019年3月26日上午10:14:15
 * @version xuxing_2019年4月26日08:50:44，迭代
 */
public class OrWfUpGradeBp {
	/**
	 * 主入口
	 * 
	 * @param id_wf
	 * @throws BizException
	 */
	public void exec() throws BizException {

		// 1.对要删除的数据进行优先处理。
		delData();

		// 2、 获取执行科室列表
		WfDepDO[] deps = queryWfDeps();

		// 3、生成主键集合
		String[] id_wf_cfgs = getKeys(deps);

		// 4、升级数据
		OrwfAggDO[] newCfgs = updateGradeData(deps, id_wf_cfgs);

		// 5、保存数据
		save(newCfgs);

		// 6、升级编码
		upGradeCode();
	}

	/**
	 * 查询2.0流向配置信息
	 * 
	 * @return
	 * @throws BizException
	 */
	private OrWfCfgDO[] queryOrWfCfg() throws BizException {
		OrwfAggDO[] rtns = ServiceFinder.find(IOrwfRService.class).find(" 1=1 ", "", FBoolean.FALSE);
		if (rtns == null || rtns.length < 1)
			return null;
		List<OrWfCfgDO> cfgDOs = new ArrayList<OrWfCfgDO>();
		for (OrwfAggDO rtn : rtns) {
			OrWfCfgDO cfgDO = rtn.getParentDO();
			cfgDO.setStatus(DOStatus.DELETED);
			cfgDOs.add(cfgDO);
		}
		return cfgDOs.toArray(new OrWfCfgDO[0]);
	}

	/**
	 * 线程,对要删除的数据进行优先处理。
	 * 
	 * @param latch
	 * @param aggDOs
	 */
	private void delData() throws BizException {
		DAFacade facade = new DAFacade();
		facade.execUpdate("delete from bd_wf_cfg");
		facade.execUpdate("delete from bd_wf_cfg_attr ");
	}

	/**
	 * 获取执行科室列表
	 * 
	 * @param id_wf
	 * @throws BizException
	 */
	private WfDepDO[] queryWfDeps() throws BizException {
		return ServiceFinder.find(IWfDepDORService.class).find(" 1=1 ", "", FBoolean.FALSE);
	}

	/**
	 * 生成主键集合
	 * 
	 * @param deps
	 * @return
	 */
	private String[] getKeys(WfDepDO[] deps) {
		if (deps == null || deps.length < 1)
			return null;
		return new DBUtil().getOIDs(deps.length);
	}

	/**
	 * 数据升级优化
	 * 
	 * @param deps
	 * @param id_wf_cfgs
	 * @return
	 */
	private OrwfAggDO[] updateGradeData(WfDepDO[] deps, String[] id_wf_cfgs) {
		if (deps == null || deps.length < 1)
			return null;
		List<OrwfAggDO> rtn = new ArrayList<OrwfAggDO>();
		Map<String, OrwfAggDO> map = new HashMap<String, OrwfAggDO>();
		int index = 0;
		for (WfDepDO depDO : deps) {
			String key = getMapKey(depDO);
			if (!map.containsKey(key)) {
				OrwfAggDO aggDO = getOrwfAggDO(depDO, id_wf_cfgs[index++]);
				rtn.add(aggDO);
				map.put(key, aggDO);
				continue;
			}
			// 如果流向配置已经存在，则只设置其相应属性信息
			OrwfAggDO aggDO = map.get(key);
			setWfCfgAttrDO(aggDO, depDO);
		}
		return rtn.toArray(new OrwfAggDO[0]);
	}

	/**
	 * 获取Map中的key
	 * 
	 * @param depDO
	 * @return
	 */
	private String getMapKey(WfDepDO dep) {

		StringBuilder sb = new StringBuilder();
		this.builderData(sb, dep.getId_wf(), "~");
		this.builderData(sb, dep.getId_org_mp(), "~");
		this.builderData(sb, dep.getId_dep_mp(), "~");
		this.builderData(sb, dep.getEu_presoutpctr(), EnumBool.NULL);
		this.builderData(sb, dep.getOrdrecurtp(), EnumLong.NULL);
		this.builderData(sb, dep.getTime_b(), "~");
		this.builderData(sb, dep.getTime_e(), "~");
		this.builderData(sb, dep.getFg_mmwh(), FBoolean.FALSE);
		this.builderData(sb, dep.getFg_mmwh(), FBoolean.FALSE);
		this.builderData(sb, this.geTranValue(dep.getSd_srvcas(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE), EnumWfCtrl.NONE);
		this.builderData(sb, this.geTranValue(dep.getId_srvs(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE), EnumWfCtrl.NONE);
		this.builderData(sb, this.geTranValue(dep.getId_dosages(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE), EnumWfCtrl.NONE);
		this.builderData(sb, this.geTranValue(dep.getId_pois(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE), EnumWfCtrl.NONE);
		this.builderData(sb, this.geTranValue(dep.getId_mms(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE), EnumWfCtrl.NONE);
		this.builderData(sb, this.geTranValue(dep.getId_herbpreparationtp(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE),
				EnumWfCtrl.NONE);
		this.builderData(sb, this.geTranValue(dep.getId_dep_ors(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE), EnumWfCtrl.NONE);
		this.builderData(sb, this.geTranValue(dep.getId_dep_clinics(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE),
				EnumWfCtrl.NONE);
		this.builderData(sb, this.geTranValue(dep.getId_dep_nurs(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE), EnumWfCtrl.NONE);
		this.builderData(sb, this.geTranValue(dep.getId_usgs(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE), EnumWfCtrl.NONE);
		this.builderData(sb, this.geTranValue(dep.getId_weeks(), EnumWfCtrl.CTRL, EnumWfCtrl.NONE), EnumWfCtrl.NONE);
		this.builderData(sb, dep.getFg_macro(), FBoolean.FALSE);
		this.builderData(sb, dep.getEu_macrodepmp(), "~");
		return sb.toString();
	}

	/**
	 * 设置对应的Key值
	 * 
	 * @param sb
	 * @param value
	 * @return
	 */
	private StringBuilder builderData(StringBuilder sb, Object value, Object defalutValue) {

		if (value == null || StringUtils.isEmptyWithTrim(value.toString())) {
			sb.append(defalutValue);
			return sb;
		}
		sb.append(value);
		return sb;

	}

	/**
	 * 获取装换值
	 * 
	 * @param value
	 * @param tranValue
	 * @return
	 */
	private String geTranValue(Object value, Object tranValue, Object defaultValue) {
		if (value == null || StringUtils.isEmptyWithTrim(value.toString()))
			return defaultValue.toString();
		return tranValue.toString();

	}

	/**
	 * 新建流向配置
	 * 
	 * @return
	 */
	private OrwfAggDO getOrwfAggDO(WfDepDO dep, String id_wf_cfgs) {
		OrwfAggDO agg = new OrwfAggDO();
		OrWfCfgDO cfg = initCfgVal();
		agg.setParentDO(cfg);
		cfg.setPkVal(id_wf_cfgs);
		cfg.setId_wf(dep.getId_wf());
		cfg.setSortno(dep.getSortno());
		cfg.setFg_macro(dep.getFg_macro());// 宏标记
		cfg.setEu_macro(dep.getEu_macrodepmp());// 宏
		cfg.setId_org_mp(dep.getId_org_mp());// 执行机构
		cfg.setId_dep_mp(dep.getId_dep_mp());// 执行科室
		cfg.setEu_pres_out(EnumBool.NULL);// 出院带药
		if (dep.getEu_presoutpctr() != null)
			cfg.setEu_pres_out(dep.getEu_presoutpctr());// 出院带药
		cfg.setEu_long(EnumLong.NULL);// 长临
		if (dep.getOrdrecurtp() != null)
			cfg.setEu_long(dep.getOrdrecurtp());// 长临
		cfg.setTime_begin(dep.getTime_b());// 开始时间
		cfg.setTime_end(dep.getTime_e());// 截止时间
		cfg.setFg_mmwh(FBoolean.FALSE);// 仓库限制
		cfg.setFg_stock(FBoolean.FALSE);// 库存限制
		if (FBoolean.TRUE.equals(dep.getFg_mmwh())) {
			cfg.setFg_mmwh(FBoolean.TRUE);
			cfg.setFg_stock(FBoolean.TRUE);
		}
		setWfCfgAttrDO(agg, dep);// 生成子表数据
		return agg;

	}

	/**
	 * 设置流向配置属性
	 * 
	 * @param agg
	 * @param dep
	 */
	private void setWfCfgAttrDO(OrwfAggDO agg, WfDepDO dep) {

		List<WfCfgAttrDO> listAttr = new ArrayList<WfCfgAttrDO>();
		OrWfCfgDO cfg = agg.getParentDO();
		if (agg.getWfCfgAttrDO() != null && agg.getWfCfgAttrDO().length > 0) {
			listAttr = new ArrayList<WfCfgAttrDO>(Arrays.asList(agg.getWfCfgAttrDO()));
		}
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_SRVCA, dep.getId_srvcas(), WfCfgAttrDO.ID_SRVCA, EnumAttr.SRVCA);// 服务分类
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_SRV, dep.getId_srvs(), WfCfgAttrDO.ID_SRV, EnumAttr.SRV);// 服务
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_DOSAGE, dep.getId_dosages(), WfCfgAttrDO.ID_DOSAGE, EnumAttr.DOSAGE);// 剂型
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_POIS, dep.getId_pois(), WfCfgAttrDO.ID_POIS, EnumAttr.POSI);// 毒麻
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_MM, dep.getId_mms(), WfCfgAttrDO.ID_MM, EnumAttr.MM);// 物品
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_HERBPERP, dep.getId_herbpreparationtp(), WfCfgAttrDO.ID_HERBPERP,
				EnumAttr.HERBPERP);// 草药制剂
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_DEP_OR, dep.getId_dep_ors(), WfCfgAttrDO.ID_DEP, EnumAttr.DEPOR);// 开单科室
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_DEP_PHY, dep.getId_dep_clinics(), WfCfgAttrDO.ID_DEP, EnumAttr.DEPPHY);// 就诊科室
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_DEP_NUR, dep.getId_dep_nurs(), WfCfgAttrDO.ID_DEP, EnumAttr.DEPNUR);// 护理单元
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_ROUTE, dep.getId_usgs(), WfCfgAttrDO.ID_ROUTE, EnumAttr.ROUTE);// 用法
		initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_WEEK, dep.getId_weeks(), WfCfgAttrDO.ID_WEEK, EnumAttr.WEEK);// 星期
		agg.setWfCfgAttrDO(listAttr.toArray(new WfCfgAttrDO[0]));
	}

	/**
	 * 升级数据
	 * 
	 * @param deps
	 * @param id_wf_cfgs
	 */
	private OrwfAggDO[] upGradeData(WfDepDO[] deps, String[] id_wf_cfgs) {
		if (deps == null || deps.length < 1)
			return null;
		List<OrwfAggDO> rtn = new ArrayList<OrwfAggDO>();
		int index = 0;
		for (WfDepDO dep : deps) {
			OrwfAggDO agg = new OrwfAggDO();
			rtn.add(agg);
			OrWfCfgDO cfg = initCfgVal();
			agg.setParentDO(cfg);
			cfg.setPkVal(id_wf_cfgs[index]);
			cfg.setId_wf(dep.getId_wf());
			cfg.setSortno(dep.getSortno());
			cfg.setFg_macro(dep.getFg_macro());// 宏标记
			cfg.setEu_macro(dep.getEu_macrodepmp());// 宏
			cfg.setId_org_mp(dep.getId_org_mp());// 执行机构
			cfg.setId_dep_mp(dep.getId_dep_mp());// 执行科室
			List<WfCfgAttrDO> listAttr = new ArrayList<WfCfgAttrDO>();
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_SRVCA, dep.getId_srvcas(), WfCfgAttrDO.ID_SRVCA, EnumAttr.SRVCA);// 服务分类
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_SRV, dep.getId_srvs(), WfCfgAttrDO.ID_SRV, EnumAttr.SRV);// 服务
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_DOSAGE, dep.getId_dosages(), WfCfgAttrDO.ID_DOSAGE,
					EnumAttr.DOSAGE);// 剂型
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_POIS, dep.getId_pois(), WfCfgAttrDO.ID_POIS, EnumAttr.POSI);// 毒麻
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_MM, dep.getId_mms(), WfCfgAttrDO.ID_MM, EnumAttr.MM);// 物品
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_HERBPERP, dep.getId_herbpreparationtp(), WfCfgAttrDO.ID_HERBPERP,
					EnumAttr.HERBPERP);// 草药制剂
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_DEP_OR, dep.getId_dep_ors(), WfCfgAttrDO.ID_DEP, EnumAttr.DEPOR);// 开单科室
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_DEP_PHY, dep.getId_dep_clinics(), WfCfgAttrDO.ID_DEP,
					EnumAttr.DEPPHY);// 就诊科室
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_DEP_NUR, dep.getId_dep_nurs(), WfCfgAttrDO.ID_DEP, EnumAttr.DEPNUR);// 护理单元
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_ROUTE, dep.getId_usgs(), WfCfgAttrDO.ID_ROUTE, EnumAttr.ROUTE);// 用法
			initWfAttrs(listAttr, cfg, OrWfCfgDO.EU_WEEK, dep.getId_weeks(), WfCfgAttrDO.ID_WEEK, EnumAttr.WEEK);// 星期
			cfg.setEu_pres_out(EnumBool.NULL);// 出院带药
			if (dep.getEu_presoutpctr() != null)
				cfg.setEu_pres_out(dep.getEu_presoutpctr());// 出院带药
			cfg.setEu_long(EnumLong.NULL);// 长临
			if (dep.getOrdrecurtp() != null)
				cfg.setEu_long(dep.getOrdrecurtp());// 长临
			cfg.setTime_begin(dep.getTime_b());// 开始时间
			cfg.setTime_end(dep.getTime_e());// 截止时间
			cfg.setFg_mmwh(FBoolean.FALSE);// 仓库限制
			cfg.setFg_stock(FBoolean.FALSE);// 库存限制
			if (FBoolean.TRUE.equals(dep.getFg_mmwh())) {
				cfg.setFg_mmwh(FBoolean.TRUE);
				cfg.setFg_stock(FBoolean.TRUE);
			}
			agg.setWfCfgAttrDO(listAttr.toArray(new WfCfgAttrDO[0]));
			index++;
		}
		return rtn.toArray(new OrwfAggDO[0]);
	}

	/**
	 * 初始化流向配置信息
	 * 
	 * @param cfg
	 */
	private OrWfCfgDO initCfgVal() {
		OrWfCfgDO cfg = new OrWfCfgDO();
		cfg.setStatus(DOStatus.NEW);
		cfg.setEu_srvca(EnumWfCtrl.NONE);
		cfg.setEu_srv(EnumWfCtrl.NONE);
		cfg.setEu_dosage(EnumWfCtrl.NONE);
		cfg.setEu_pois(EnumWfCtrl.NONE);
		cfg.setEu_mm(EnumWfCtrl.NONE);
		cfg.setEu_herbperp(EnumWfCtrl.NONE);
		cfg.setEu_dep_or(EnumWfCtrl.NONE);
		cfg.setEu_dep_phy(EnumWfCtrl.NONE);
		cfg.setEu_dep_nur(EnumWfCtrl.NONE);
		cfg.setEu_pres_out(EnumWfCtrl.NONE);
		cfg.setFg_mmwh(FBoolean.FALSE);
		cfg.setFg_stock(FBoolean.FALSE);
		cfg.setEu_route(EnumWfCtrl.NONE);
		cfg.setEu_week(EnumWfCtrl.NONE);
		cfg.setEu_long(EnumLong.NULL);
		return cfg;
	}

	/**
	 * 获取属性集合
	 * 
	 * @param id_wf_cfg
	 * @param id_keys
	 * @param attrName
	 * @param eu_attr
	 * @return
	 */
	private void initWfAttrs(List<WfCfgAttrDO> listAttr, OrWfCfgDO cfgDO, String nameEuAttr, String id_keys,
			String attrName, Integer eu_attr) {
		if (StringUtil.isEmptyWithTrim(id_keys))
			return;
		cfgDO.setAttrVal(nameEuAttr, EnumWfCtrl.CTRL);
		List<String> attrKeys = getAttrKeys(listAttr, attrName);
		for (String key : id_keys.split("\\,")) {
			if (attrKeys.contains(key))
				continue;
			WfCfgAttrDO attr = new WfCfgAttrDO();
			attr.setId_wf_cfg(cfgDO.getId_wf_cfg());
			attr.setEu_attr(eu_attr);
			attr.setStatus(DOStatus.NEW);
			attr.setAttrVal(attrName, key);
			listAttr.add(attr);
			attrKeys.add(key);
		}
	}

	/**
	 * 获取属性值列表用于去重
	 * 
	 * @param listAttr
	 * @param attrName
	 * @return
	 */
	private List<String> getAttrKeys(List<WfCfgAttrDO> listAttr, String attrName) {

		List<String> keys = new ArrayList<String>();
		if (listAttr == null || listAttr.size() < 1)
			return keys;
		for (WfCfgAttrDO attrDO : listAttr) {
			Object attr = attrDO.getAttrVal(attrName);
			if (attr != null && !StringUtil.isEmptyWithTrim(attr.toString())) {
				keys.add(attr.toString());
			}
		}
		return keys;
	}

	/**
	 * 保存数据
	 * 
	 * @param aggDOs
	 * 			@throws BizException @throws
	 */
	private void save(OrwfAggDO[] newCfgs) throws BizException {
		if (newCfgs == null || newCfgs.length < 0)
			return;
		ServiceFinder.find(IOrwfCudService.class).insert(newCfgs);
	}

	/**
	 * 升级编码
	 * 
	 * @throws BizException
	 */
	private void upGradeCode() throws BizException {
		QueryUpGradeCodeSql sql = new QueryUpGradeCodeSql();
		WfCfgAttrDO[] attrs = (WfCfgAttrDO[]) AppFwUtil.getDORstWithDao(sql, WfCfgAttrDO.class);
		if (attrs == null || attrs.length < 1)
			return;
		for (WfCfgAttrDO attr : attrs) {
			attr.setStatus(DOStatus.UPDATED);
		}
		ServiceFinder.find(IWfCfgAttrDOCudService.class).save(attrs);
	}
}
