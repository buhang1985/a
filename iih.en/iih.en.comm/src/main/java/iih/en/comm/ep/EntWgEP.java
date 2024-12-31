package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bd.res.bizgrp.i.IBizgrpMDOCudService;
import iih.bd.res.bizgrp.i.IBizgrpMDORService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnMedGrpDO;
import iih.en.pv.enres.i.IEnmedgrpCudService;
import iih.en.pv.enres.i.IEnmedgrpRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊医疗组EP
 * 
 * @author yankan
 *
 */
public class EntWgEP {
	/**
	 * 结束当前医疗组
	 * 
	 * @param entId
	 *            就诊id
	 * @param wgRole
	 *            医疗组类型
	 * @throws BizException
	 */
	public void endWg(String entId, String wgRole) throws BizException {
		IEnmedgrpRService retrieveService = ServiceFinder.find(IEnmedgrpRService.class);

		String whereStr = String.format("id_ent= '%s' AND dt_e is null  ", entId, wgRole);
		if (!EnValidator.isEmpty(wgRole)) {// 判定 by renying
			whereStr += String.format(" AND sd_enwgrole = '%s'", wgRole);
		}
		EnMedGrpDO[] oriMedGrpDOs = retrieveService.find(whereStr, "", FBoolean.FALSE);
		if (!EnValidator.isEmpty(oriMedGrpDOs)) {
			EnMedGrpDO oriGrpDO = oriMedGrpDOs[0];
			FDateTime curTime = EnAppUtils.getServerDateTime();
			oriGrpDO.setDt_e(curTime);// 结束日期为入科时间
			IEnmedgrpCudService cudService = ServiceFinder.find(IEnmedgrpCudService.class);
			cudService.update(new EnMedGrpDO[] { (oriGrpDO) });
		}
	}
	/**
	 * 批量结束当前医疗组
	 * 
	 * @param entId
	 *            就诊id
	 * @param wgRole
	 *            医疗组类型
	 * @throws BizException
	 */
	public void endWg(List<String> entIdList, String wgRole,FDateTime curTime) throws BizException {
		IEnmedgrpRService retrieveService = ServiceFinder.find(IEnmedgrpRService.class);
		String whereStr = String.format("%s AND dt_e is null  ", EnSqlUtils.getInSqlByIds("id_ent", entIdList));
		if (!EnValidator.isEmpty(wgRole)) {// 判定 by renying
			whereStr += String.format(" AND sd_enwgrole = '%s'", wgRole);
		}
		EnMedGrpDO[] oriMedGrpDOs = retrieveService.find(whereStr, "", FBoolean.FALSE);
		if (!EnValidator.isEmpty(oriMedGrpDOs)) {
			for(EnMedGrpDO enMedGrp : oriMedGrpDOs){
				enMedGrp.setDt_e(curTime);// 结束日期为入科时间			
			}
			IEnmedgrpCudService cudService = ServiceFinder.find(IEnmedgrpCudService.class);	
			cudService.update(oriMedGrpDOs);
		}
	}


	/**
	 * 更新医疗组
	 * 
	 * @param medGrpDO
	 *            医疗组
	 * @throws BizException
	 */
	public void changeMedGrp(EnMedGrpDO medGrpDO) throws BizException {
		// 结束旧医疗组
		this.endWg(medGrpDO.getId_ent(), medGrpDO.getSd_enwgrole());

		// 新增医疗组记录
		IEnmedgrpCudService cudService = ServiceFinder.find(IEnmedgrpCudService.class);
		cudService.insert(new EnMedGrpDO[] { medGrpDO });
	}
	/**
	 * 批量更新医疗组
	 * @param medGrpDO
	 * @throws BizException
	 */
	public void changeMedGrp(EnMedGrpDO[] medGrpDOs,FDateTime curTime) throws BizException {
		// 结束旧医疗组
		if(EnValidator.isEmpty(medGrpDOs))
			return;
		List<String> entIdList = new ArrayList<String>();
		for(EnMedGrpDO enMedDO : medGrpDOs){
			entIdList.add(enMedDO.getId_ent());
		}
		//this.endWg(medGrpDO.getId_ent(), medGrpDO.getSd_enwgrole());
		this.endWg(entIdList, null,curTime);
		// 新增医疗组记录
		IEnmedgrpCudService cudService = ServiceFinder.find(IEnmedgrpCudService.class);
		cudService.insert( medGrpDOs);
	}

	/**
	 * 插入医疗组
	 * 
	 * @param enDepDTO
	 * @param Dt_b
	 * @throws BizException
	 * @author renying
	 */
	public void insertEntWg(String entId, String wgId, FBoolean fg_pri, FDateTime Dt_b)
			throws BizException {
		IEnmedgrpCudService service = ServiceFinder.find(IEnmedgrpCudService.class);
		EnMedGrpDO enMedGrpDO = new EnMedGrpDO();
		enMedGrpDO.setId_ent(entId);
		enMedGrpDO.setId_wg(wgId);// 医疗组
		enMedGrpDO.setSd_enwgrole(IEnDictCodeConst.SD_ENWGROLE_PHY);
		enMedGrpDO.setId_enwgrole(IEnDictCodeConst.ID_ENWGROLE_PHY);
		enMedGrpDO.setDt_b(Dt_b);
		enMedGrpDO.setDt_e(null);
		if (fg_pri != null && fg_pri.booleanValue()) {
			enMedGrpDO.setFg_psn(FBoolean.TRUE);
		}
		service.insert(new EnMedGrpDO[] { enMedGrpDO });
	}

	/**
	 * 专用医疗组更新bd_wg 设置id_ent_used的值
	 * 
	 * @param idWg
	 * @param idEnt
	 * @throws BizException
	 */
	public void setBdWgEntId(String idWg, String idEnt) throws BizException {
		IBizgrpMDORService bizRServie = ServiceFinder.find(IBizgrpMDORService.class);
		IBizgrpMDOCudService bizCServie = ServiceFinder.find(IBizgrpMDOCudService.class);

		BizGroupDO bizdo = bizRServie.findById(idWg);
		bizdo.setStatus(DOStatus.UPDATED);
		bizdo.setId_ent_used(idEnt);

		bizCServie.save(new BizGroupDO[] { bizdo });

	}

	/**
	 * 恢复医疗组
	 * 
	 * @param entId
	 * @param dt_end
	 * @throws BizException
	 * @author renying
	 */
	public void recWg(String entId, FDateTime dt_end) throws BizException {
		IEnmedgrpRService grpService = ServiceFinder.find(IEnmedgrpRService.class);
		IEnmedgrpCudService grpCudService = ServiceFinder.find(IEnmedgrpCudService.class);
		// 原来的床位，则更新结束时间
		String whereSql = String.format("id_ent='%s' AND dt_e ='%s'", entId, dt_end);
		EnMedGrpDO[] grpDOs = grpService.find(whereSql, null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(grpDOs)) {
			EnMedGrpDO grpDO = grpDOs[0];
			grpDO.setDt_e(null);
			grpDO.setStatus(DOStatus.UPDATED);
			grpCudService.save(new EnMedGrpDO[] { grpDO });
		}
	}

	/**
	 * 根据就诊ID删除就诊医疗组信息
	 * 
	 * @author zhengcm
	 * @param entId
	 *            就诊ID
	 * @throws BizException
	 */
	public void deleteEntWgByEntId(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		IEnmedgrpRService grpService = ServiceFinder.find(IEnmedgrpRService.class);
		IEnmedgrpCudService grpCudService = ServiceFinder.find(IEnmedgrpCudService.class);
		EnMedGrpDO[] WgDOs = grpService.findByAttrValString(EnMedGrpDO.ID_ENT, entId);
		if (EnValidator.isEmpty(WgDOs)) {
			return;
		}
		grpCudService.delete(WgDOs);
	}

	public EnMedGrpDO[] CreatNewWGs(List<String> entIdList,String phyId,FDateTime curTime,FBoolean fg_pri){
		ArrayList<EnMedGrpDO> grpDOList = new ArrayList<EnMedGrpDO>();
		for (String entId : entIdList) {
			EnMedGrpDO enMedGrpDO = new EnMedGrpDO();
			enMedGrpDO.setId_ent(entId); // 就诊id
			enMedGrpDO.setId_wg(phyId); // 医疗组id
			enMedGrpDO.setSd_enwgrole(IEnDictCodeConst.SD_ENWGROLE_PHY);// 角色编码
			enMedGrpDO.setId_enwgrole(IEnDictCodeConst.ID_ENWGROLE_PHY);
			enMedGrpDO.setDt_b(curTime); // 开始时间
			if (fg_pri != null && fg_pri.booleanValue()) {
				enMedGrpDO.setFg_psn(FBoolean.TRUE);
			} else {
				enMedGrpDO.setFg_psn(FBoolean.FALSE);
			}
			enMedGrpDO.setStatus(DOStatus.NEW);
			grpDOList.add(enMedGrpDO);
		}
		return grpDOList.toArray(new EnMedGrpDO[]{});
	}
}
