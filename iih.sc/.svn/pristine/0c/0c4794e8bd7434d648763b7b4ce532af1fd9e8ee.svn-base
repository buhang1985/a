package iih.sc.apt.s.bp.ip;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.i.IRuleExecService;
import iih.sc.apt.aptip.d.AptIpAttrDO;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.d.AptIpMatchDO;
import iih.sc.apt.aptip.d.AptipAggDO;
import iih.sc.apt.aptip.d.desc.AptIpDODesc;
import iih.sc.apt.aptip.d.desc.AptIpMatchDODesc;
import iih.sc.apt.aptip.i.IAptipRService;
import iih.sc.apt.aptip.i.IAptipmatchCudService;
import iih.sc.apt.aptip.i.IAptipmatchRService;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.AptIpQrySchmDTO;
import iih.sc.apt.dto.d.EuStatus;
import iih.sc.apt.dto.d.EuTimeTp;
import iih.sc.apt.i.IScAptQryService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 自动匹配床位
 * 
 * @author ccj
 *
 */
public class AutoMatchBedBP {

	// 床位属性KEY间隔符
	private final static String SYMBOL_BED_ATTR_KEY = "-";
	// 床位属性值组合符
	private final static String SYMBOL_BED_ATTR_VAL_LEFT = "[";
	private final static String SYMBOL_BED_ATTR_VAL_RIGHT = "]";

	// 床位性别限制值组合符
	private final static String SYMBOL_BED_SEXLIMIT = "#";
	// 床位性别限制为空占位符
	private final static String SYMBOL_BED_SEXLIMIT_EMPTY = "#N#";

	/**
	 * 自动匹配床位
	 * 
	 * @param depId 科室id，如果为null则是全院
	 * @return
	 * @throws BizException
	 */
	public AptIpDTO[] exec(String depId) throws BizException {
		// 删除自动匹配表临时表
		this.deleteAptIpMatch();

		// 获取根据优先级排序后的未预约申请单
		List<AptipAggDO> aptList = this.getShotAptIpAggList(depId);
		if (ListUtil.isEmpty(aptList)) {
			throw new BizException(IScMsgConst.SC_APT_IP_NO_UNAPT_APP);
		}

		// 获取所有符合条件的床位
		Map<String, String> allBedsMap = this.getAllBed(aptList, depId);

		// 自动匹配床位：申请单与床位匹配过程 保存临时表 返回匹配list
		List<AptIpDTO> list = this.autoMatchBeds(aptList, allBedsMap);

		return list.toArray(new AptIpDTO[list.size()]);
	}

	/**
	 * 删除临时匹配表数据 根据客户端pcid
	 * 
	 * @throws DAException
	 */
	private void deleteAptIpMatch() throws DAException {
		SqlParam deleteParam = new SqlParam();
		String deleteSql = "DELETE FROM sc_apt_ip_match m where m.code_session = ? ";
		deleteParam.addParam(ScContextUtils.getPcId());
		new DAFacade().execUpdate(deleteSql, deleteParam);
	}

	/**
	 * 获取所有申请科室PK列表
	 *
	 * @param aptList
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> getDepPhyIpList(List<AptipAggDO> aptList) throws BizException {
		if (ListUtil.isEmpty(aptList)) {
			return null;
		}
		List<String> deptList = new ArrayList<String>();
		for (AptipAggDO aggDO : aptList) {
			String id_dep_phy_ip = aggDO.getParentDO().getId_dep_phy_ip(); // 申请科室
			if (!deptList.contains(id_dep_phy_ip)) {
				deptList.add(id_dep_phy_ip);
			}
		}
		return deptList;
	}

	/**
	 * 获取所有申请病区列表
	 *
	 * @param aptList
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> getNurDepList(List<AptipAggDO> aptList) throws BizException {
		if (ListUtil.isEmpty(aptList)) {
			return null;
		}
		List<String> deptList = new ArrayList<String>();
		for (AptipAggDO aggDO : aptList) {
			String id_dep_nur_ip = aggDO.getParentDO().getId_dep_nur_ip(); // 申请病区
			if (!StringUtil.isEmpty(id_dep_nur_ip) && !deptList.contains(id_dep_nur_ip)) {
				deptList.add(id_dep_nur_ip);
			}
		}
		return deptList;
	}

	/**
	 * 获取根据优先级排序后的未预约申请单
	 * 
	 * @param id_dep 页面选择的科室
	 * @return
	 * @throws BizException
	 */
	private List<AptipAggDO> getShotAptIpAggList(String id_dep) throws BizException {
		// 查询出未预约的所有住院申请
		IAptipRService aptipRService = ServiceFinder.find(IAptipRService.class);
		// 未预约 dos
		AptipAggDO[] aptIpDOs = null;
		if (StringUtils.isNotEmpty(id_dep)) {
			aptIpDOs = aptipRService.find(AptIpDODesc.TABLE_ALIAS_NAME + ".fg_canc = 'N' and "
					+ AptIpDODesc.TABLE_ALIAS_NAME + ".sd_status = '" + EuStatus.APPY + "' and "
					+ AptIpDODesc.TABLE_ALIAS_NAME + ".id_dep_phy_ip = '" + id_dep + "'", "", FBoolean.FALSE);
		} else {
			aptIpDOs = aptipRService.find(AptIpDODesc.TABLE_ALIAS_NAME + ".fg_canc = 'N' and "
					+ AptIpDODesc.TABLE_ALIAS_NAME + ".sd_status = '" + EuStatus.APPY + "'", "", FBoolean.FALSE);
		}
		if (ArrayUtils.isEmpty(aptIpDOs)) {
			throw new BizException(IScMsgConst.SC_APT_IP_NO_EXIST_APTIP);
		}
		// 这里要找出所有未预约并没有优先级的dos
		Map<String, AptipAggDO> aptIpMap = new HashMap<String, AptipAggDO>(); // 找出所有未预约且没有优先级的
																				// 住院申请
		List<PriorityDTO> priDTOs = new ArrayList<PriorityDTO>(); // 优先级dto list
		for (AptipAggDO aptIpDO : aptIpDOs) {
			aptIpMap.put(aptIpDO.getParentDO().getId_aptip(), aptIpDO);
			PriorityDTO dto = new PriorityDTO();
			dto.setId_pat(aptIpDO.getParentDO().getId_pat()); // 患者id
			dto.setId_aptip(aptIpDO.getParentDO().getId_aptip()); // 住院申请单id
			dto.setId_patca(aptIpDO.getParentDO().getId_patca()); // 患者分类id
			dto.setCode_level_dise(aptIpDO.getParentDO().getSd_level_dise()); // 病情等级编码
			dto.setFg_planip(aptIpDO.getParentDO().getFg_plan()); // 计划入院标识
			priDTOs.add(dto);
		}
		List<AptipAggDO> aptList = new ArrayList<AptipAggDO>(); // 接收赋值优先级后的预约
		// 调用en 接口求优先级
		IRuleExecService execService = ServiceFinder.find(IRuleExecService.class);
		PriorityDTO[] priorityDTOs = execService.batchCalcIpAptPri(priDTOs.toArray(new PriorityDTO[priDTOs.size()]));
		for (PriorityDTO priorityDTO : priorityDTOs) {
			AptipAggDO aptIpDO = aptIpMap.get(priorityDTO.getId_aptip());
			aptIpDO.getParentDO().setLevel_pri(priorityDTO.getLevel_pri());
			aptList.add(aptIpDO);
		}
		sortList(aptList, "DESC");
		return aptList;
	}

	/**
	 * 获取所有符合条件的床位
	 * 
	 * @param id_dep_phy_ips 本次申请单的申请科室
	 * @return
	 * @changed by zhengcm 2017-02-22 修改方法参数，替换所有申请科室条件in条件获取逻辑
	 * @throws BizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map<String, String> getAllBed(List<AptipAggDO> aptList, String deptId) throws BizException {
		if (ListUtil.isEmpty(aptList)) {
			return null;
		}

		// 获取所有申请科室PK列表
		List<String> deptList = this.getDepPhyIpList(aptList);

		IAptipmatchRService aptipmatchRService = ServiceFinder.find(IAptipmatchRService.class);
		AptIpMatchDO[] aptIpMatchDOs = aptipmatchRService.find(AptIpMatchDODesc.TABLE_ALIAS_NAME + ".code_session = '"
				+ ScContextUtils.getPcId() + "'", "", FBoolean.TRUE);
		StringBuffer id_depsBuffer = new StringBuffer(); // 临时匹配里所有床位id
		if (!ArrayUtil.isEmpty(aptIpMatchDOs)) {// 非空控制 zhengcm 2017-02-22
			for (AptIpMatchDO aptIpMatchDO : aptIpMatchDOs) {
				id_depsBuffer.append("'");
				id_depsBuffer.append(aptIpMatchDO.getId_bed());
				id_depsBuffer.append("',");
			}
		}

		// 获取当前科室是否含有业务线病区
		DeptDO[] deptDOs = this.GetDepOrNur(deptId, IBdResDictCodeConst.SD_DEPROLE_DEP);
		boolean hasDeptLine = false;
		if (!ArrayUtil.isEmpty(deptDOs)) {
			hasDeptLine = true;
		}

		// 查询床位
		StringBuffer sb = new StringBuffer();
		if (!hasDeptLine) {// 查询申请单对应病区的床位（无业务线）
			// 获取申请单所有病区
			List<String> nurList = this.getNurDepList(aptList);
			sb.append("select distinct bed.id_bed,bed.name,bed.id_dep_belong,arrr.sd_bedattr_tp,arrr.val,bed.code,dep.code as code_dep,bed.sd_bedsexlimit ");
			sb.append("from bd_bed bed ");
			sb.append("left join BD_BED_ATTR arrr on arrr.id_bed = bed.id_bed ");
			if (StringUtils.isNotEmpty(id_depsBuffer.toString())) {
				sb.append("and bed.id_bed not in (" + id_depsBuffer.substring(0, id_depsBuffer.length() - 1) + ") ");
			}
			sb.append("inner join bd_dep dep on dep.id_dep = bed.id_dep_belong ");
			sb.append("where bed.sd_bedsu  in ('" + IBdResDictCodeConst.SD_BEDSU_EMPTY + "','"
					+ IBdResDictCodeConst.SD_BEDSU_CLEAN + "') and bed.fg_act = 'Y' ");
			sb.append("and bed.fg_appt = 'N' ");
			if (!ListUtil.isEmpty(nurList)) {
				sb.append("and " + ScSqlUtils.getInSqlByIds("bed.id_dep_belong", nurList) + " ");
			}
			sb.append("order by dep.code,bed.code ");
		} else {// 查询当前科室对应病区的床位（有业务线）
			sb.append("select distinct bed.id_bed,bed.name,bed.id_dep_belong,arrr.sd_bedattr_tp,arrr.val,phy.id_dep as dep_phy,nur.sortno,bed.code,bed.sd_bedsexlimit ");
			sb.append("from bd_bed bed ");
			sb.append("inner join bd_depl_dep nur on bed.id_dep_belong = nur.id_dep and nur.sd_deplrole like '"
					+ IBdResDictCodeConst.SD_DEPROlE_NUR + "%' ");
			sb.append("inner join bd_depl_dep phy on nur.id_depl = phy.id_depl and phy.sd_deplrole like '"
					+ IBdResDictCodeConst.SD_DEPROLE_DEP + "%' ");
			sb.append("and " + ScSqlUtils.getInSqlByIds("phy.id_dep", deptList) + " ");
			sb.append("and bed.sd_bedsu  in ('" + IBdResDictCodeConst.SD_BEDSU_EMPTY + "','"
					+ IBdResDictCodeConst.SD_BEDSU_CLEAN + "') and bed.fg_act = 'Y' ");
			sb.append("and bed.fg_appt = 'N' ");
			sb.append("left join BD_BED_ATTR arrr on arrr.id_bed = bed.id_bed ");
			if (StringUtils.isNotEmpty(id_depsBuffer.toString())) {
				sb.append("and bed.id_bed not in (" + id_depsBuffer.substring(0, id_depsBuffer.length() - 1) + ") ");
			}
			sb.append("order by nur.sortno,bed.code ");
		}

		ArrayList list = (ArrayList) new DAFacade().execQuery(sb.toString(), new MapListHandler());
		if (CollectionUtils.isEmpty(list)) {
			throw new BizException(IScMsgConst.SC_APT_IP_NO_EXIST_BED);
		}
		Map<String, String> allBedsMap = new HashMap<String, String>();
		for (Object object : list) {
			Map<String, Object> map = (Map<String, Object>) object;
			String id_dep_phy = deptId;
			if (hasDeptLine) {
				id_dep_phy = (String) map.get("dep_phy");
			}
			String key = (String) map.get("id_bed") + SYMBOL_BED_ATTR_KEY + (String) map.get("name")
					+ SYMBOL_BED_ATTR_KEY + (String) map.get("id_dep_belong") + SYMBOL_BED_ATTR_KEY + id_dep_phy;
			if (allBedsMap.containsKey(key)) {
				if (map.get("sd_bedattr_tp") != null) {
					String val = allBedsMap.get(key) == null ? "" : allBedsMap.get(key);
					val = val + this.getAttrInfo(map);
					allBedsMap.remove(key);
					allBedsMap.put(key, val);
				}
			} else {
				// 床位性别限制
				String sd_bedsexlimit = null;
				if (null != map.get("sd_bedsexlimit")) {
					sd_bedsexlimit = SYMBOL_BED_SEXLIMIT + map.get("sd_bedsexlimit").toString() + SYMBOL_BED_SEXLIMIT;
				} else {
					sd_bedsexlimit = SYMBOL_BED_SEXLIMIT_EMPTY;
				}
				String val = null;
				if (null != sd_bedsexlimit) {
					val = sd_bedsexlimit;
				}
				if (map.get("sd_bedattr_tp") != null) {
					val = val + this.getAttrInfo(map);
				}
				allBedsMap.put(key, val);
			}
		}
		return allBedsMap;
	}

	/**
	 * 申请单与床位匹配过程 保存临时表 返回匹配AptDto list
	 * 
	 * @param aptList 申请单list
	 * @param allBedsMap 床位map
	 * @return
	 * @throws BizException
	 */
	private List<AptIpDTO> autoMatchBeds(List<AptipAggDO> aptList, Map<String, String> allBedsMap) throws BizException {

		// 已匹配的数据
		List<AptIpDTO> list = new ArrayList<AptIpDTO>();
		// 匹配中间表
		List<AptIpMatchDO> aptIpMatchDOs = new ArrayList<AptIpMatchDO>();
		// 遍历匹配数据
		for (AptipAggDO aptIpDO : aptList) {
			// 遍历匹配床位
			String matchKey = null;
			List<AptIpAttrDO> mustAttrList = new ArrayList<AptIpAttrDO>(); // 必要床位属性集合
			List<AptIpAttrDO> optiAttrList = new ArrayList<AptIpAttrDO>(); // 可选床位属性集合
			// 申请单是否有对应的床位特征值要求
			AptIpAttrDO[] aptIpAttrDOs = aptIpDO.getAptIpAttrDO();
			if (ArrayUtils.isNotEmpty(aptIpAttrDOs)) {
				mustAttrList.clear();
				optiAttrList.clear();
				for (AptIpAttrDO aptIpAttrDO : aptIpAttrDOs) {
					if (aptIpAttrDO.getFg_option().booleanValue()) {
						optiAttrList.add(aptIpAttrDO);// 可选
					} else {
						mustAttrList.add(aptIpAttrDO);// 必选
					}
				}
			}
			if (!ListUtil.isEmpty(mustAttrList)) {// 必选属性匹配
				matchKey = this.matchMustAttr(aptIpDO, allBedsMap, mustAttrList);
			} else {// 可选属性和无属性匹配
				matchKey = this.matchOptiAttr(aptIpDO, allBedsMap, optiAttrList);
			}
			if (null != matchKey) {// 匹配到数据
				allBedsMap.remove(matchKey);// 从Map中移除已匹配的数据
				this.processMatchData(matchKey, aptIpDO, list, aptIpMatchDOs);
			}
		}
		if (aptIpMatchDOs.size() > 0) {
			IAptipmatchCudService aptipmatchCudService = ServiceFinder.find(IAptipmatchCudService.class);
			aptipmatchCudService.save(aptIpMatchDOs.toArray(new AptIpMatchDO[aptIpMatchDOs.size()]));
		}
		return list;
	}

	/**
	 * 匹配必选属性床位
	 *
	 * @param aptIpDO
	 * @param allBedsMap
	 * @param mustAttrList
	 * @param bedSexParam
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private String matchMustAttr(AptipAggDO aptIpDO, Map<String, String> allBedsMap, List<AptIpAttrDO> mustAttrList) throws BizException {
		if (ListUtil.isEmpty(mustAttrList)) {
			return null;
		}
		for (Map.Entry<String, String> entry : allBedsMap.entrySet()) {
			boolean isMatch = true;
			String[] keyArr = entry.getKey().split(SYMBOL_BED_ATTR_KEY);
			Object val = entry.getValue();
			for (AptIpAttrDO attrDO : mustAttrList) {
				if (!keyArr[3].equals(aptIpDO.getParentDO().getId_dep_phy_ip())) {// 科室匹配
					isMatch = false;
					break;
				}
				String matchAttr = this.getAttrInfo(attrDO);
				if (val == null || !val.toString().contains(matchAttr)) {
					isMatch = false;
					break;
				}
				// 是否匹配床位性别
				int bedSexParam = ScParamUtils.getDepBedSexParam(keyArr[3]);
				// 匹配床位性别
				if (bedSexParam == 1) {
					if (!this.matchBedSex(val.toString(), aptIpDO.getParentDO().getSd_sex_pat())) {
						isMatch = false;
						break;
					}
				}
			}
			if (isMatch) {
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * 匹配可选属性床位
	 *
	 * @param aptIpDO
	 * @param allBedsMap
	 * @param optiAttrList
	 * @param bedSexParam
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private String matchOptiAttr(AptipAggDO aptIpDO, Map<String, String> allBedsMap, List<AptIpAttrDO> optiAttrList) throws BizException {
		int degree = 0;// 匹配度
		String matchKey = null;// 匹配的Key
		for (Map.Entry<String, String> entry : allBedsMap.entrySet()) {
			String key = entry.getKey();
			String[] keyArr = key.split(SYMBOL_BED_ATTR_KEY);
			Object val = entry.getValue();
			int currDegree = 0;
			if (keyArr[3].equals(aptIpDO.getParentDO().getId_dep_phy_ip())) {// 科室匹配
				if (null == matchKey) {// 最小匹配
					matchKey = key;
				}
				// 是否匹配床位性别
				int bedSexParam = ScParamUtils.getDepBedSexParam(keyArr[3]);
				// 匹配床位性别
				if (bedSexParam == 1) {
					if (!this.matchBedSex(val.toString(), aptIpDO.getParentDO().getSd_sex_pat())) {
						matchKey = null;
						continue;
					} else {
						matchKey = key;
					}
				} else {
					matchKey = key;
				}
				if (!ListUtil.isEmpty(optiAttrList)) {// 有可选属性按最大匹配度匹配
					for (AptIpAttrDO attrDO : optiAttrList) {
						String matchAttr = this.getAttrInfo(attrDO);
						if (val != null && val.toString().contains(matchAttr)) {
							currDegree = currDegree + 1;
						}
					}
					if (currDegree > degree) {// 匹配度更高
						matchKey = key;
						degree = currDegree;
					}
				} else {// 无可选属性直接最小匹配
					break;
				}
			}
		}
		return matchKey;
	}

	/**
	 * 匹配床位性别
	 * 
	 * @author zhengcm
	 *
	 * @param val
	 * @param sex_pat
	 * @return
	 * @throws BizException
	 */
	private boolean matchBedSex(String val, String sex_pat) throws BizException {
		// 床位性别与患者性别一致或不限制或空则匹配成功
		if (val.toString().contains(SYMBOL_BED_SEXLIMIT + sex_pat + SYMBOL_BED_SEXLIMIT)
				|| val.toString().contains(
						SYMBOL_BED_SEXLIMIT + IBdResDictCodeConst.SD_BEDSEXLIMIT_UNLIMIT + SYMBOL_BED_SEXLIMIT)
				|| val.toString().contains(SYMBOL_BED_SEXLIMIT_EMPTY)) {
			return true;
		}
		return false;
	}

	/**
	 * 获取床位属性信息
	 *
	 * @param attrDO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private String getAttrInfo(AptIpAttrDO attrDO) throws BizException {
		return attrDO.getSd_bedattr_tp() + SYMBOL_BED_ATTR_VAL_LEFT + attrDO.getVal() + SYMBOL_BED_ATTR_VAL_RIGHT;
	}

	/**
	 * 获取床位属性信息
	 *
	 * @param map
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private String getAttrInfo(Map<String, Object> map) throws BizException {
		return map.get("sd_bedattr_tp").toString() + SYMBOL_BED_ATTR_VAL_LEFT + map.get("val").toString()
				+ SYMBOL_BED_ATTR_VAL_RIGHT;
	}

	/**
	 * 处理匹配从数据：主要是把 匹配相关信息拿到list里面
	 *
	 * @param mapKey
	 * @param aptIpDO
	 * @param list
	 * @param aptIpMatchDOs
	 * @throws BizException
	 * @author zhengcm
	 */
	public void processMatchData(String mapKey, AptipAggDO aptIpDO, List<AptIpDTO> list,
			List<AptIpMatchDO> aptIpMatchDOs) throws BizException {
		String[] key = mapKey.toString().split(SYMBOL_BED_ATTR_KEY);
		aptIpDO.getParentDO().setId_bed(key[0]);
		AptIpMatchDO aptIpMatchDO = new AptIpMatchDO();
		aptIpMatchDO.setStatus(DOStatus.NEW);
		aptIpMatchDO.setId_scaptip(aptIpDO.getParentDO().getId_aptip()); // 匹配申请单
		aptIpMatchDO.setId_bed(key[0]);
		aptIpMatchDO.setCode_session(ScContextUtils.getPcId());
		aptIpMatchDOs.add(aptIpMatchDO);
		list.add(aptIpConverDto(aptIpDO.getParentDO(), key[1], key[2]));
	}

	/**
	 * 住院预约do 转化成dto
	 * 
	 * @param aptIpDO 住院预约do
	 * @param name_bed 床名
	 * @param id_dep_belong 床位所属病区
	 * @return
	 * @throws BizException
	 */
	private AptIpDTO aptIpConverDto(AptIpDO aptIpDO, String name_bed, String id_dep_belong) throws BizException {
		AptIpQrySchmDTO qrySchmDTO = new AptIpQrySchmDTO();
		qrySchmDTO.setFg_rehos(aptIpDO.getFg_plan()); // 计划再入院
		qrySchmDTO.setId_patca(aptIpDO.getId_patca()); // 患者分类id
		qrySchmDTO.setEu_status(aptIpDO.getSd_status()); // 申请单状态
		qrySchmDTO.setSd_level_dise(aptIpDO.getSd_level_dise()); // 病区等级
		qrySchmDTO.setId_dep(aptIpDO.getId_dep_phy_ip()); // 入院科室
		qrySchmDTO.setId_pat(aptIpDO.getId_pat()); // 患者id
		// 这里传递的申请日期用来过滤出对应申请单
		qrySchmDTO.setD_b(aptIpDO.getDt_insert().getBeginDate()); // 开始日期
		qrySchmDTO.setD_e(aptIpDO.getDt_insert().getBeginDate()); // 结束日期
		qrySchmDTO.setTimetp(EuTimeTp.APPLY); // 时间类型为申请时间
		IScAptQryService aptQryService = ServiceFinder.find(IScAptQryService.class);
		AptIpDTO[] aptIpDTOs = aptQryService.getIpAptListBySchmNoPag(qrySchmDTO);
		aptIpDTOs[0].setName_bed(name_bed);// 床位名称
		aptIpDTOs[0].setId_bed(aptIpDO.getId_bed()); // 床位id
		aptIpDTOs[0].setId_dep_belong(id_dep_belong); // 床位所属病区
		aptIpDTOs[0].setDt_appt(aptIpDO.getDt_appt());
		return aptIpDTOs[0];
	}

	/**
	 * list 排序 按优先级和申请时间
	 * 
	 * @param list
	 * @param 排序方式：ASC，DESC 任选其一
	 */
	private void sortList(List<AptipAggDO> list, final String sortMode) {
		Collections.sort(list, new Comparator<AptipAggDO>() {
			@Override
			public int compare(AptipAggDO o1, AptipAggDO o2) {
				boolean ASC_order = (sortMode == null || "ASC".equalsIgnoreCase(sortMode));
				Integer level = o1.getParentDO().getLevel_pri(); // 优先级
				Integer level2 = o2.getParentDO().getLevel_pri();
				if (level.compareTo(level2) == 0) {
					// 再次比较申请时间
					FDateTime dateTime = o1.getParentDO().getDt_insert();
					FDateTime dateTime2 = o2.getParentDO().getDt_insert();
					return !ASC_order ? dateTime.compareTo(dateTime2) : dateTime2.compareTo(dateTime);
				} else {
					return ASC_order ? level.compareTo(level2) : level2.compareTo(level);
				}
			}
		});
	}

	/**
	 * 根据科室查询业务线
	 *
	 * @param id_dep
	 * @param sd_deptrole
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private DeptDO[] GetDepOrNur(String id_dep, String sd_deptrole) throws BizException {
		if ((StringUtils.isEmpty(id_dep)) || (StringUtils.isEmpty(sd_deptrole))) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct depl_dep2.id_dep ");
		sb.append("from bd_depl_dep depl_dep ");
		sb.append("inner join bd_depl depl on depl_dep.id_depl = depl.id_depl and depl.sd_deptltp = ? ");
		sb.append("inner join bd_depl_dep depl_dep2 on depl_dep2.id_depl = depl.id_depl and depl_dep2.sd_deplrole = ? ");
		sb.append("where depl_dep.sd_deplrole = ? ");
		sb.append("and depl_dep.id_dep = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IBdResDictCodeConst.SD_DEPLTP_DEPNUR);
		if (sd_deptrole.equals(IBdResDictCodeConst.SD_DEPROlE_NUR)) {
			param.addParam(IBdResDictCodeConst.SD_DEPROLE_DEP);
			param.addParam(IBdResDictCodeConst.SD_DEPROlE_NUR);
		} else if (sd_deptrole.equals(IBdResDictCodeConst.SD_DEPROLE_DEP)) {
			param.addParam(IBdResDictCodeConst.SD_DEPROlE_NUR);
			param.addParam(IBdResDictCodeConst.SD_DEPROLE_DEP);
		}
		param.addParam(id_dep);
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(), param, new ColumnListHandler());
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		IDeptRService ideptService = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptDOs = ideptService.findByIds(list.toArray(new String[0]), FBoolean.FALSE);
		return deptDOs;
	}
}
