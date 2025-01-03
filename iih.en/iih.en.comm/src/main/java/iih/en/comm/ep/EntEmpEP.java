package iih.en.comm.ep;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.enres.i.IEnpsnRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医护人员EP
 * 
 * @author yankan
 *
 */
public class EntEmpEP {
	/**
	 * 创建人员
	 * 
	 * @param entId
	 *            就诊id
	 * @param roleId
	 *            角色id
	 * @param roleCode
	 *            角色编码
	 * @param beginTime
	 *            开始时间
	 * @throws BizException
	 * @author yankan, modify by renying
	 */
	public EnPsnDO createEmp(String entId, String empId, String roleId, String roleCode,
			FDateTime beginTime) throws BizException {
		EnPsnDO enPsnDO = new EnPsnDO();
		enPsnDO.setId_ent(entId); // 就诊id
		enPsnDO.setId_emprole(roleId);// 角色编码
		enPsnDO.setSd_emprole(roleCode);// 角色编码
		enPsnDO.setDt_b(beginTime); // 开始时间
		enPsnDO.setId_emp(empId);
		enPsnDO.setStatus(DOStatus.NEW);
		return enPsnDO;
	}

	/**
	 * 添加人员
	 * 
	 * @param entId
	 *            就诊id
	 * @param roleId
	 *            角色id
	 * @param roleCode
	 *            角色编码
	 * @param beginTime
	 *            开始时间
	 * @throws BizException
	 * @author yankan, modified by renying
	 */
	public void addEmp(String entId, String empId, String roleId, String roleCode,
			FDateTime beginTime) throws BizException {
		EnPsnDO enPsnDO = this.createEmp(entId, empId, roleId, roleCode, beginTime);
		this.saveEmps(new EnPsnDO[] { enPsnDO });
	}

	/**
	 * 新增人员
	 * 
	 * @param empArray
	 *            人员对象集合
	 * @throws BizException
	 */
	public void saveEmps(EnPsnDO[] empArray) throws BizException {
		if (empArray != null) {
			getCudServ().save(empArray);
		}
	}

	/**
	 * 结束人员使用
	 * 
	 * @param entId
	 *            就诊id
	 * @param empRole
	 *            人员角色，为空，则为全部角色
	 * @param datetime
	 *            结束时间
	 * @throws BizException
	 */
	public void endOldEmp(String entId, String empRole, FDateTime datetime) throws BizException {
		// 结束旧人员
		String whereStr = String.format("id_ent= '%s' AND dt_e is null ", entId);
		// 如果角色不为空，则过滤角色
		if (empRole != null && empRole.trim().length() > 0) {
			whereStr = String.format(" AND sd_emprole = '%s' ", empRole);
		}
		if (datetime == null) {
			datetime = EnAppUtils.getServerDateTime();
		}
		EnPsnDO[] oriDOs = getRServ().find(whereStr, null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(oriDOs)) {
			for (EnPsnDO psnDO : oriDOs) {
				psnDO.setDt_e(datetime);// 结束日期为入科时间
				psnDO.setStatus(DOStatus.UPDATED);
			}
			getCudServ().save(oriDOs);
		}
	}
	/**
	 * 
	 * @param entIdList
	 * @param empRole
	 * @param datetime
	 * @throws BizException
	 */
	public void endOldEmp(List<String> entIdList, String empRole, FDateTime datetime) throws BizException {
		// 结束旧人员
		String whereStr = String.format(" %s AND dt_e is null ", EnSqlUtils.getInSqlByIds("id_ent", entIdList));
		// 如果角色不为空，则过滤角色
		if (empRole != null && empRole.trim().length() > 0) {
			whereStr += String.format(" AND sd_emprole = '%s' ", empRole);
		}
		if (datetime == null) {
			datetime = EnAppUtils.getServerDateTime();
		}
		EnPsnDO[] oriDOs = getRServ().find(whereStr, null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(oriDOs)) {
			for (EnPsnDO psnDO : oriDOs) {
				psnDO.setDt_e(datetime);// 结束日期为入科时间
				psnDO.setStatus(DOStatus.UPDATED);
			}
			getCudServ().save(oriDOs);
		}
	}

	/**
	 * 更新人员
	 * 
	 * @param psnDO
	 *            人员
	 * @param roleCode
	 *            角色编码
	 * @throws BizException
	 */
	public void changeEmp(EnPsnDO psnDO, String roleCode) throws BizException {
		// 更新旧人员
		IEnpsnCudService cudService = getCudServ();
		String whereStr = String.format("id_ent= '%s' AND dt_e is null AND sd_emprole = '%s' ",
				psnDO.getId_ent(), roleCode);
		EnPsnDO[] oriDOs = getRServ().find(whereStr, "", FBoolean.FALSE);
		if (!EnValidator.isEmpty(oriDOs)) {
			EnPsnDO oriDO = oriDOs[0];
			// 如果未更改人员，则直接返回
			if (oriDO.getId_emp() == psnDO.getId_emp()) {
				return;
			}
			FDateTime curTime = EnAppUtils.getServerDateTime();
			oriDO.setDt_e(curTime);// 结束日期为入科时间
			cudService.update(new EnPsnDO[] { (oriDO) });
		}

		// 新增记录
		cudService.insert(new EnPsnDO[] { psnDO });
	}

	/**
	 * 恢复人员
	 * 
	 * @param entId
	 * @param dt_e
	 * @throws BizException
	 * @author renying
	 */
	public void recEmp(String entId, FDateTime dt_e) throws BizException {
		// 原来的床位，则更新结束时间
		String whereSql = String.format("id_ent='%s' AND dt_e='%s'", entId, dt_e);
		EnPsnDO[] psnDOs = getRServ().find(whereSql, null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(psnDOs)) {
			for (EnPsnDO psnDO : psnDOs) {
				psnDO.setDt_e(null);
				psnDO.setStatus(DOStatus.UPDATED);
			}
			getCudServ().save(psnDOs);
		}
	}

	/**
	 * 获取医护人员信息
	 * 
	 * @param entId
	 * @param empRole
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	public EnPsnDO getEnEmpByRole(String entId, String empRole) throws BizException {
		String whereStr = String.format("id_ent='%s' and sd_emprole='%s'", entId, empRole);
		String orderStr = "dt_e desc";
		EnPsnDO[] psnDOArray = getRServ().find(whereStr, orderStr, FBoolean.FALSE);
		if (EnValidator.isEmpty(psnDOArray)) {
			return null;
		}
		return psnDOArray[0];

	}
	
	/**
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnPsnDO[] getEnEmps(String entId,String empRole) throws BizException {
		String whereStr = String.format("id_ent='%s' and sd_emprole='%s'", entId, empRole);
		String orderStr = "dt_e Asc";
		EnPsnDO[] psnDOArray = getRServ().find(whereStr, orderStr, FBoolean.FALSE);
		if (EnValidator.isEmpty(psnDOArray)) {
			return null;
		}
		return psnDOArray;
	}

	/**
	 * 根据就诊ID删除就诊人员
	 * 
	 * @author zhengcm
	 * @param entId
	 *            就诊ID
	 * @throws BizException
	 */
	public void deleteEnEmpByEntId(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		EnPsnDO[] psnDOs = getRServ().findByAttrValString(EnPsnDO.ID_ENT, entId);
		if (EnValidator.isEmpty(psnDOs)) {
			return;
		}
		getCudServ().delete(psnDOs);
	}
	/**
	 * 更新人员DO数据
	 * @param enpsns
	 * @throws DAException
	 */
	public void updatePsnWithDaFaced(EnPsnDO[] enpsns) throws DAException{
		new DAFacade().updateDOs(enpsns);
	}
	/**
	 * 根据就诊id获取EnPsnDO集合
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnPsnDO[] getByEntId(String entId) throws BizException {
		return getRServ().findByAttrValString(EnPsnDO.ID_ENT, entId);
	}
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IEnpsnRService getRServ(){
		return ServiceFinder.find(IEnpsnRService.class);
	}
	/**
	 * 获取操作服务
	 * 
	 * @return
	 */
	public IEnpsnCudService getCudServ(){
		return ServiceFinder.find(IEnpsnCudService.class);
	}
}
