package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.i.IEndepCudService;
import iih.en.pv.enres.i.IEndepRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 就诊科室EP
 * 
 * @author yankan
 *
 */
public class EntDeptEP {
	/**
	 * 获取转科科室
	 * 
	 * @param entId
	 *            就诊id
	 * @return
	 * @throws BizException
	 */
	public EnDepDO getTransDept(String entId) throws BizException {
		// 转科科室
		String whereStr = String
				.format("id_ent ='%s' and sd_entdeprole = '%s' and fg_admit='N' and fg_discharge ='N' and sd_status='%s'",
						entId, IEnDictCodeConst.SD_ENTDEPROLE_DEP,
						IEnDictCodeConst.SD_ENTDEP_STATUS_SUC);

		EnDepDO[] endepDOList = getRServ().find(whereStr, null, FBoolean.FALSE);
		if (endepDOList != null && endepDOList.length > 0) {
			return endepDOList[0];
		}
		return null;
	}

	/**
	 * 更新科室或病区
	 * 
	 * @param entDepDO
	 *            科室或病区DO
	 * @throws BizException
	 */
	public void changeDep(EnDepDO entDepDO, TransDepPatDTO patDTO, FBoolean fg_discharge,
			FDateTime curTime) throws BizException {
		// 结束当前前使用科室
		if (IEnDictCodeConst.SD_ENTDEPROLE_DEP.equals(entDepDO.getSd_entdeprole())) {
			this.endDept(entDepDO.getId_ent(), entDepDO.getSd_entdeprole(), patDTO.getId_dep_phy(),
					fg_discharge, curTime);
		}
		if (IEnDictCodeConst.SD_ENTDEPROLE_IA.equals(entDepDO.getSd_entdeprole())) {
			this.endDept(entDepDO.getId_ent(), entDepDO.getSd_entdeprole(), patDTO.getId_dep_nur(),
					fg_discharge, curTime);
		}
		// 新增科室记录
		getCudServ().insert(new EnDepDO[] { entDepDO });
	}

	/**
	 * 停止使用当前科室
	 * 
	 * @param entId
	 *            就诊id
	 * @param deptRole
	 *            科室类型
	 * @param toDeptId
	 *            转到科室id
	 * @throws BizException
	 */
	public void endDept(String entId, String deptRole, String toDeptId, FBoolean fg_discharge,
			FDateTime curTime) throws BizException {
		String whereStr = String.format(" id_ent= '%s' AND dt_e is null  ", entId);
		if (!EnValidator.isEmpty(deptRole)) {
			whereStr += String.format(" AND sd_entdeprole = '%s' ", deptRole);
		}

		EnDepDO[] enDepDOs = getRServ().find(whereStr, "", FBoolean.FALSE);
		if (!EnValidator.isEmpty(enDepDOs)) {
			for (EnDepDO enDepDO : enDepDOs) {
				enDepDO.setDt_e(curTime);
				enDepDO.setId_dep_to(toDeptId);
				enDepDO.setStatus(DOStatus.UPDATED);
				enDepDO.setFg_discharge(fg_discharge);
			}
			getCudServ().save(enDepDOs);
		}
	}

	/**
	 * 插入en_ent_dep
	 * 
	 * @param enDepDTO
	 * @param Dt_b
	 * @param true1
	 * @throws BizException
	 */
	public void insertEntDep(String depId, String entId, String sdStatus, String idStatus,
			FDateTime Dt_b) throws BizException {
		EnDepDO enDepDO = new EnDepDO();
		enDepDO.setId_dep(depId);// 对应的科室或病区id
		enDepDO.setSd_entdeprole(sdStatus);// 科室或病区
		enDepDO.setId_entdeprole(idStatus);// 科室或病区
		enDepDO.setId_ent(entId);
		enDepDO.setId_dep_from(null);
		enDepDO.setId_dep_to(null);
		enDepDO.setDt_b(Dt_b);
		enDepDO.setDt_e(null);
		enDepDO.setFg_admit(FBoolean.TRUE);
		enDepDO.setFg_discharge(FBoolean.FALSE);
		enDepDO.setSd_status(IEnDictCodeConst.SD_ENTDEP_STATUS_SUC);
		enDepDO.setDt_dcg_bill(Dt_b);
		getCudServ().insert(new EnDepDO[] { enDepDO });
	}

	/**
	 * 查询病区的科室集合 业务线暂时没有，临时放在这里，后续迁移
	 * 
	 * @param nurId
	 *            病区id
	 * @return
	 * @throws BizException
	 */
	public DeptDO[] getDepList(String nurId) throws BizException {

		StringBuilder sb = new StringBuilder();

		sb.append("  select depl_dep2.id_dep");
		sb.append("  from bd_depl_dep depl_dep");
		sb.append("  inner join bd_depl depl ");
		sb.append("  on depl_dep.id_depl = depl.id_depl");
		sb.append("  and depl.sd_deptltp=?");// '0106'

		sb.append("  inner join bd_depl_dep depl_dep2");
		sb.append("  on depl_dep2.id_depl = depl_dep.id_depl");
		sb.append("  and depl_dep2.sd_deplrole=?");// '0100'
		sb.append("  where depl_dep.id_dep =?");// '0001AA1000000003QO11'

		SqlParam param = new SqlParam();
		param.addParam("0106");
		param.addParam("0100");
		param.addParam(nurId);
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(), param,
				new ColumnListHandler());

		IDeptRService ideptService = ServiceFinder.find(IDeptRService.class);

		DeptDO[] deptDOs = ideptService.findByIds(list.toArray(new String[0]), FBoolean.FALSE);
		if (EnValidator.isEmpty(list)) {
			return null;
		}

		return deptDOs;
	}

	/**
	 * 恢复科室
	 * 
	 * @param entId
	 * @param dt_e
	 * @throws BizException
	 * @author renying
	 */
	public void recDept(String entId, FDateTime dt_e) throws BizException {
		// 原来的床位，则更新结束时间
		String whereSql = String.format("id_ent='%s' AND dt_e='%s'", entId, dt_e);
		EnDepDO[] depDOs = getRServ().find(whereSql, null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(depDOs)) {
			for (EnDepDO depDo : depDOs) {
				depDo.setFg_discharge(FBoolean.FALSE);// 出院置为false
				depDo.setDt_e(null);// 结束时间置空
				depDo.setStatus(DOStatus.UPDATED);
			}
			getCudServ().save(depDOs);
		}
	}

	/**
	 * 根据主键批量查询就诊科室
	 * 
	 * @author zhengcm
	 * @param deptIds
	 *            就诊科室主键数组
	 * @return 就诊科室数组
	 * @throws BizException
	 */
	public EnDepDO[] getEnDeptByIds(String[] deptIds) throws BizException {
		if (EnValidator.isEmpty(deptIds)) {
			return null;
		}
		// 就诊科室病区查询服务
		return getRServ().findByBIds(deptIds, FBoolean.FALSE);
	}
	
	/**
	 * 更新部门DO数据
	 * @param enpsns
	 * @throws DAException
	 */
	public void updateDepWithDaFaced(EnDepDO[] enpdeps) throws DAException{
		new DAFacade().updateDOs(enpdeps);
	}
	/**
	 * 删除en_ent_dep
	 * 
	 * @param entId
	 * @throws BizException
	 */
	public void deleteEntDepByEntIds(String[] entIds) throws BizException {
		EnDepDO[] deps = getRServ().findByAttrValStrings(EnDepDO.ID_ENT, entIds);
		if(EnValidator.isEmpty(deps))
			return;
		getCudServ().delete(deps);
	}
	/**
	 * 根据就诊id获取EnDepDO集合
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnDepDO[] getByEntId(String entId) throws BizException {
		return getRServ().findByAttrValString(EnDepDO.ID_ENT, entId);
	}
	/**
	 * 保存
	 * 
	 * @param deps
	 * @return
	 * @throws BizException
	 */
	public EnDepDO[] save(EnDepDO[] deps)throws BizException {
		return getCudServ().save(deps);
	}
	
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IEndepRService getRServ(){
		return ServiceFinder.find(IEndepRService.class);
	}
	/**
	 * 获取操作服务
	 * 
	 * @return
	 */
	public IEndepCudService getCudServ(){
		return ServiceFinder.find(IEndepCudService.class);
	}
}
