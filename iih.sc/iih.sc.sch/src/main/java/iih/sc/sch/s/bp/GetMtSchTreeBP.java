package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.s.bp.GetDeptWithDeptParamBP;
import iih.sc.sch.dto.d.MtSchTreeDTO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 获取医技排班树
 * 
 * @author renying
 * 
 */
public class GetMtSchTreeBP {
	/**
	 * 获取医技排班树
	 * 
	 * @return SchMtPlDTO arrays
	 * @throws BizException
	 */
	public MtSchTreeDTO[] exec(String beanType) throws BizException {

		String sctp;
		boolean isCanAppAll;
		String  dep_fg = null;
		if (beanType != null && (beanType.equals(IScDictCodeConst.SD_SCTP_OP))) {
			sctp = IScDictCodeConst.SD_SCTP_OP;
			isCanAppAll = ScParamUtils.getOPSchHosAuth();
			dep_fg = "and bd_dep.fg_op = 'Y'  ";
		} else if (beanType != null && beanType.equals(IScDictCodeConst.SD_SCTP_JZ)) {
			sctp = IScDictCodeConst.SD_SCTP_JZ;
			isCanAppAll = ScParamUtils.getJZSchHosAuth();
			dep_fg = "and bd_dep.fg_er = 'Y'";
		} else if (beanType != null && beanType.equals(IScDictCodeConst.SD_SCTP_MT)) {
			sctp = IScDictCodeConst.SD_SCTP_MT;
			isCanAppAll = ScParamUtils.getMtSchHosAuth();
		} else if (beanType != null && beanType.equals(IScDictCodeConst.SD_SCTP_OT)) {
			sctp = IScDictCodeConst.SD_SCTP_OT;
			String condition = "and( bd_dep.sd_depttp='%s' or  bd_dep.sd_depttp='%s' or  bd_dep.sd_depttp='%s')";
			dep_fg = String.format(condition, ISysDictCodeConst.SD_DEPTTP_MT, ISysDictCodeConst.SD_DEPTTP_CLINIC,
					ISysDictCodeConst.SD_DEPTTP_NURSE);
			isCanAppAll = ScParamUtils.getOtSchHosAuth();
		} else {
			throw new BizException("未获取到排班类型");

		}

		String depId = null;
		if (!isCanAppAll) {
			depId = ScContextUtils.getDeptId();
		}
		GetDeptWithDeptParamBP b = new GetDeptWithDeptParamBP();
		DeptDO[] dept = b.exec(sctp, depId);
		SqlParam param = new SqlParam();
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" select a.* from");
		sqlBuffer.append(" (select sc_pl.id_dep Id_main,");
		sqlBuffer.append(" bd_dep.name name_tree,");
		sqlBuffer.append(" sc_pl.id_dep id_dep,");
		sqlBuffer.append(" '' id_parent,");
		sqlBuffer.append(" '' name_parent,");
		sqlBuffer.append("  'dept' tp_tree,");
		sqlBuffer.append("  sc_pl.id_dep id_tree,");
		sqlBuffer.append("   '' as Id_scpl,");
		sqlBuffer.append(" '' fg_active,");
		sqlBuffer.append(" bd_dep.code code, ");
		sqlBuffer.append(" '' id_queben, ");
		sqlBuffer.append(" ben.name as name_queben,");
		sqlBuffer.append(" srv.id_scca,");
		sqlBuffer.append("  ''   name_pl");
		sqlBuffer.append(" from bd_dep");
		sqlBuffer.append("  inner join sc_pl");
		sqlBuffer.append(" on bd_dep.id_dep = sc_pl.id_dep");
		sqlBuffer.append(" and sc_pl.sd_sctp = '");
		sqlBuffer.append(sctp);
		sqlBuffer.append("'");
		sqlBuffer.append(" and  sc_pl.fg_active ='Y'");
		sqlBuffer.append(" and sc_pl.fg_stopsch ='N'");
		if (!StringUtil.isEmpty(depId)) {
			sqlBuffer.append(" and  sc_pl.id_dep =?");
			param.addParam(depId);
		}
		sqlBuffer.append(" and (sc_pl.eu_edit_tp is null or sc_pl.eu_edit_tp='0')");
		if (dep_fg != null) {
			sqlBuffer.append(dep_fg);
		}

		String orgSql = ScGroupControlUtils.getGroupControlFitler(new ScPlanDO(), "sc_pl");
		sqlBuffer.append(" and " + orgSql);

		sqlBuffer.append(" inner join bd_que_ben ben on ben.id_queben = sc_pl.id_queben ");
		sqlBuffer.append(" inner join sc_srv srv on srv.id_scsrv = sc_pl.id_scsrv ");
		sqlBuffer.append(" group by sc_pl.id_dep, bd_dep.name,bd_dep.code ,sc_pl.fg_active,fg_stopsch, srv.id_scca,ben.name");
		sqlBuffer.append(" union");
		sqlBuffer.append(" select sc_srv.id_scsrv Id_main,");
		sqlBuffer.append(" sc_srv.name name_tree,");
		//sqlBuffer.append(" sc_srv.id_scca ,");
		sqlBuffer.append(" sc_pl.id_dep id_dep,");
		sqlBuffer.append(" sc_pl.id_dep id_parent,");

		sqlBuffer.append(" dep.name name_parent,");
		sqlBuffer.append(" 'scsrv' tp_tree,");
		sqlBuffer.append(" CONCAT(sc_pl.id_dep, sc_srv.id_scsrv) id_tree,");
		sqlBuffer.append(" '' as Id_scpl,");
		sqlBuffer.append(" '' fg_active,");
		sqlBuffer.append(" ''  code,");
		sqlBuffer.append(" '' id_queben, ");
		sqlBuffer.append(" ben.name as name_queben,");
		sqlBuffer.append(" sc_srv.id_scca,");
		sqlBuffer.append(" ''  name_pl");
		sqlBuffer.append(" from sc_srv");
		sqlBuffer.append(" inner join sc_pl");
		sqlBuffer.append(" on sc_srv.id_scsrv = sc_pl.id_scsrv");
		sqlBuffer.append(" and sc_pl.sd_sctp = '");
		sqlBuffer.append(sctp);
		sqlBuffer.append("'");
		sqlBuffer.append(" and sc_pl.fg_active = 'Y'");
		sqlBuffer.append(" and sc_pl.fg_stopsch = 'N'");
		if (!StringUtil.isEmpty(depId)) {
			sqlBuffer.append(" and  sc_pl.id_dep =?");
			param.addParam(depId);
		}
		sqlBuffer.append(" and (sc_pl.eu_edit_tp is null or sc_pl.eu_edit_tp='0')");

		sqlBuffer.append(" and " + orgSql);
		sqlBuffer.append(" inner join bd_dep dep");
		sqlBuffer.append(" on dep.id_dep = sc_pl.id_dep");
		sqlBuffer.append(" inner join bd_que_ben ben on ben.id_queben = sc_pl.id_queben ");
		sqlBuffer.append(" group by sc_srv.id_scsrv,");
		sqlBuffer.append(" sc_srv.name,");
		sqlBuffer.append(" sc_pl.id_dep,");
		sqlBuffer.append(" dep.name,");
		sqlBuffer.append(" CONCAT(sc_pl.id_dep, sc_srv.id_scsrv),   ");
		sqlBuffer.append(" sc_pl.fg_active,fg_stopsch,sc_srv.id_scca,ben.name");
		sqlBuffer.append(" union");
		sqlBuffer.append(" select sc_res.id_scres Id_main,");
		sqlBuffer.append(" sc_res.name name_tree,");
		sqlBuffer.append(" sc_pl.id_dep id_dep,");
		sqlBuffer.append(" CONCAT(sc_pl.id_dep, sc_pl.id_scsrv) id_parent,");
		sqlBuffer.append(" srv.name name_parent,");
		sqlBuffer.append(" 'scres' tp_tree,");
		sqlBuffer.append(" (sc_pl.id_scsrv|| sc_res.id_scres||sc_pl.id_dep)  id_tree,");
		sqlBuffer.append(" sc_pl.id_scpl as Id_scpl,");
		sqlBuffer.append(" sc_pl.fg_active,");
		sqlBuffer.append("  ''  code,");
		sqlBuffer.append(" sc_pl.id_queben, ");
		sqlBuffer.append(" ben.name as name_queben,");
		sqlBuffer.append(" srv.id_scca,");
		sqlBuffer.append(" sc_pl.name name_pl");
		sqlBuffer.append(" from sc_res");
		sqlBuffer.append("  inner join sc_pl");
		sqlBuffer.append("  on sc_res.id_scres = sc_pl.id_scres");
		sqlBuffer.append(" and sc_pl.sd_sctp = '");
		sqlBuffer.append(sctp);
		sqlBuffer.append("'");
		sqlBuffer.append(" and  sc_pl.fg_active ='Y'");
		sqlBuffer.append(" and sc_pl.fg_stopsch ='N'");
		if (!StringUtil.isEmpty(depId)) {
			sqlBuffer.append(" and  sc_pl.id_dep =?");
			param.addParam(depId);
		}
		sqlBuffer.append(" and (sc_pl.eu_edit_tp is null or sc_pl.eu_edit_tp='0')");
		sqlBuffer.append(" and  sc_pl.fg_active ='Y'");
		sqlBuffer.append(" and " + orgSql);
		sqlBuffer.append(" inner join sc_srv srv");
		sqlBuffer.append(" on srv.id_scsrv = sc_pl.id_scsrv");
		sqlBuffer.append(" inner join bd_que_ben ben on ben.id_queben = sc_pl.id_queben ");
		sqlBuffer.append(" group by sc_res.id_scres,");
		sqlBuffer.append(" sc_res.name,");
		sqlBuffer.append(" CONCAT(sc_pl.id_dep, sc_pl.id_scsrv),");
		sqlBuffer.append(" srv.name,");
		sqlBuffer.append(" sc_pl.id_dep,");
		sqlBuffer.append("   (sc_pl.id_scsrv|| sc_res.id_scres||sc_pl.id_dep) ,");
		sqlBuffer.append(" sc_pl.id_scpl,     ");
		sqlBuffer.append(" sc_pl.fg_active,fg_stopsch,sc_pl.name, sc_pl.id_queben,srv.id_scca,ben.name) a order by  a.code");

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<MtSchTreeDTO> mtPlDTOs = (List<MtSchTreeDTO>) new DAFacade().execQuery(sqlBuffer.toString(), param,
				new BeanListHandler(MtSchTreeDTO.class));
		mtPlDTOs = this.duplicateMtSchTree(mtPlDTOs);
		List<MtSchTreeDTO> mtPlDTOs1 = new ArrayList<MtSchTreeDTO>();
		if (!ArrayUtil.isEmpty(dept)) {
			for (DeptDO deptdo : dept) {
				for (MtSchTreeDTO mtSchTreeDTO : mtPlDTOs) {
					if (deptdo.getId_dep().equals(mtSchTreeDTO.getId_dep())) {
					mtPlDTOs1.add(mtSchTreeDTO);
				}
			}
		}
		}
		if(ScParamUtils.getScSchMaxDates()){
			// 设置最大排班日期
			this.getMaxSchDate(mtPlDTOs1, beanType, depId);
		}
		return mtPlDTOs1.toArray(new MtSchTreeDTO[mtPlDTOs1.size()]);
	}

	/**
	 * 根据idTree去重
	 * 
	 * @param mtPlDTOs
	 * @return
	 */
	private List<MtSchTreeDTO> duplicateMtSchTree(List<MtSchTreeDTO> mtPlDTOs) {
		Map<String, MtSchTreeDTO> dataMap = new HashMap<String, MtSchTreeDTO>();
		for (MtSchTreeDTO mtSchTreeDTO : mtPlDTOs) {
			if (!dataMap.containsKey(mtSchTreeDTO.getId_tree())) {
				dataMap.put(mtSchTreeDTO.getId_tree(), mtSchTreeDTO);
			}
		}
		List<MtSchTreeDTO> result = new ArrayList<MtSchTreeDTO>();
		for (Map.Entry<String, MtSchTreeDTO> entry : dataMap.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}

	/**
	 * 获取树中最大排班日期
	 * 
	 * @author YHL
	 * @param dept
	 *            部门
	 * @throws DAException
	 */
	private void getMaxSchDate(List<MtSchTreeDTO> mtPlDTOs1, String beanType, String depId) throws DAException {
		Map<String, String> depMap = new HashMap<String, String>();// 部门级别
		Map<String, String> srvMap = new HashMap<String, String>();// 服务级别
		Map<String, String> resMap = new HashMap<String, String>();// 资源级别

		SqlParam param = new SqlParam();
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select a.*");
		sqlBuffer.append("  from (select max(sch.d_sch) d_maxsch,");
		sqlBuffer.append("   'dept' tp_tree,");
		sqlBuffer.append("   sc_pl.id_dep id_tree");
		sqlBuffer.append("  from sc_sch sch");
		sqlBuffer.append("  inner join sc_pl sc_pl");
		sqlBuffer.append("  on sch.id_scpl = sc_pl.id_scpl");

		sqlBuffer.append("  and sc_pl.sd_sctp = '");
		sqlBuffer.append(beanType);
		sqlBuffer.append("'");
		sqlBuffer.append("  and sc_pl.fg_active = 'Y'");
		sqlBuffer.append("  and sc_pl.eu_edit_tp = '0'");
		if (!StringUtil.isEmpty(depId)) {
			sqlBuffer.append(" and  sc_pl.id_dep =?");
			param.addParam(depId);
		}
		sqlBuffer.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScPlanDO(), "sc_pl"));
		sqlBuffer.append(" group by sc_pl.id_dep");

		sqlBuffer.append("  union");
		sqlBuffer.append("  select max(sch.d_sch) d_maxsch,");
		sqlBuffer.append("  'srv' tp_tree,");
		sqlBuffer.append("  CONCAT(sc_pl.id_dep, sc_srv.id_scsrv) id_tree");
		sqlBuffer.append("  from sc_sch sch");
		sqlBuffer.append("  inner join sc_pl sc_pl");
		sqlBuffer.append("  on sch.id_scpl = sc_pl.id_scpl");
		sqlBuffer.append("  and sc_pl.sd_sctp = '");
		sqlBuffer.append(beanType);
		sqlBuffer.append("'");
		sqlBuffer.append("  and sc_pl.fg_active = 'Y'");
		sqlBuffer.append("  and sc_pl.eu_edit_tp = '0'");
		if (!StringUtil.isEmpty(depId)) {
			sqlBuffer.append(" and  sc_pl.id_dep =?");
			param.addParam(depId);
		}
		;
		sqlBuffer.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScPlanDO(), "sc_pl"));
		sqlBuffer.append("  inner join sc_srv");
		sqlBuffer.append("  on sc_srv.id_scsrv = sc_pl.id_scsrv");
		sqlBuffer.append("  group by CONCAT(sc_pl.id_dep, sc_srv.id_scsrv)");

		sqlBuffer.append("  union");
		sqlBuffer.append("  select max(sch.d_sch) d_maxsch,");
		sqlBuffer.append("  'res' tp_tree,");
		sqlBuffer.append("  (sc_pl.id_scsrv || sc_res.id_scres || sc_pl.id_dep) id_tree");
		sqlBuffer.append("  from sc_sch sch");
		sqlBuffer.append("  inner join sc_pl sc_pl");
		sqlBuffer.append("  on sch.id_scpl = sc_pl.id_scpl");
		sqlBuffer.append("  and sc_pl.sd_sctp = '");
		sqlBuffer.append(beanType);
		sqlBuffer.append("'");
		sqlBuffer.append("  and sc_pl.fg_active = 'Y'");
		sqlBuffer.append("  and sc_pl.eu_edit_tp = '0'");
		if (!StringUtil.isEmpty(depId)) {
			sqlBuffer.append(" and  sc_pl.id_dep =?");
			param.addParam(depId);
		}
		sqlBuffer.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScPlanDO(), "sc_pl"));
		sqlBuffer.append("  inner join sc_srv");
		sqlBuffer.append("  on sc_srv.id_scsrv = sc_pl.id_scsrv");
		sqlBuffer.append("  inner join sc_res");
		sqlBuffer.append("  on sc_res.id_scres = sc_pl.id_scres");
		sqlBuffer.append("  group by (sc_pl.id_scsrv || sc_res.id_scres || sc_pl.id_dep)");
		sqlBuffer.append("  ) a");
		List<MtSchTreeDTO> mtPlDTOs = (List<MtSchTreeDTO>) new DAFacade().execQuery(sqlBuffer.toString(), param,
				new BeanListHandler(MtSchTreeDTO.class));
		// 分类获取最大日期
		if (!ListUtil.isEmpty(mtPlDTOs)) {
			for (MtSchTreeDTO mtSchTreeDTO : mtPlDTOs) {
				switch (mtSchTreeDTO.getTp_tree()) {
				case "dept":
					depMap.put(mtSchTreeDTO.getId_tree(), mtSchTreeDTO.getD_maxsch().toString());
					break;
				case "srv":
					srvMap.put(mtSchTreeDTO.getId_tree(), mtSchTreeDTO.getD_maxsch().toString());
					break;
				case "res":
					resMap.put(mtSchTreeDTO.getId_tree(), mtSchTreeDTO.getD_maxsch().toString());
					break;
				}
			}
		}
		// 给树赋值最大日期
		for (MtSchTreeDTO mtSchTreeDTO : mtPlDTOs1) {
			if (depMap.containsKey(mtSchTreeDTO.getId_tree())) {
				String name_tree = mtSchTreeDTO.getName_tree();
				mtSchTreeDTO
						.setName_tree(name_tree + "(" + depMap.get(mtSchTreeDTO.getId_tree()).substring(5, 10) + ")");
			}
			if (srvMap.containsKey(mtSchTreeDTO.getId_tree())) {
				String name_tree = mtSchTreeDTO.getName_tree();
				String aaa = depMap.get(mtSchTreeDTO.getId_tree());
				mtSchTreeDTO
						.setName_tree(name_tree + "(" + srvMap.get(mtSchTreeDTO.getId_tree()).substring(5, 10) + ")");
			}
			if (resMap.containsKey(mtSchTreeDTO.getId_tree())) {
				String name_tree = mtSchTreeDTO.getName_tree();
				mtSchTreeDTO
						.setName_tree(name_tree + "(" + resMap.get(mtSchTreeDTO.getId_tree()).substring(5, 10) + ")");
			}
		}
	}
}
