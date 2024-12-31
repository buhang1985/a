package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.bizgrp.d.BizGrpEmpsDO;
import iih.bd.res.bizgrp.d.BizgrpAggDO;
import iih.bd.res.bizgrp.i.IBizgrpRService;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 修改患者的责任医生为当前医生
 * 
 * @author fanlq
 *
 */
public class UpdateDutyEmpBP {
	/***
	 * 修改为患者的责任医生为当前医生
	 * 
	 * @param entId
	 * @param empId
	 * @throws BizException 
	 */
	public FBoolean exec(String entId, String empId) throws BizException{
		//1.获取患者就诊信息
		PatiVisitDO patiVisitDO = this.getEnEnt(entId);
		//2.校验是否满足修改条件
		FBoolean canUpdate = isCanUpdateDutyEmp(entId,empId,patiVisitDO);
		//3.修改责任医生
		if(FBoolean.TRUE.equals(canUpdate)){
			//3.1修改就诊表
			this.updateDuty(patiVisitDO, empId);
			//3.2修改就诊人员表
			this.updateDutyEmp(entId, empId);
			//3.3修改婴儿就诊表、就诊人员表
			this.updateNbInfo(entId, empId);
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
	
	/***
	 * 获取患者就诊信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getEnEnt(String entId) throws BizException{
		PvEP ep = new PvEP();
		return ep.getPvById(entId);
	}
	/***
	 * 修改就诊表责任医生
	 * @param patiVisitDO
	 * @param empId
	 * @throws BizException
	 */
	private void updateDuty(PatiVisitDO patiVisitDO,String empId) throws BizException{
		if(patiVisitDO != null){
			patiVisitDO.setId_emp_phy(empId);
			patiVisitDO.setStatus(DOStatus.UPDATED);
			PvEP ep = new PvEP();
			ep.savePv(patiVisitDO);
		}
	}
	/***
	 * 修改就诊人员表责任医生
	 * @param patiVisitDO
	 * @param empId
	 * @throws BizException
	 */
	private void updateDutyEmp(String id_ent,String empId) throws BizException{
		EntEmpEP ep = new EntEmpEP();
		EnPsnDO psndo = ep.getEnEmpByRole(id_ent,IEnDictCodeConst.SD_EMPROLE_DOCTOR);
		if(psndo != null){
			psndo.setId_emp(empId);
			psndo.setStatus(DOStatus.UPDATED);
			IEnpsnCudService cudService = ServiceFinder.find(IEnpsnCudService.class);
			cudService.save(new EnPsnDO[]{psndo});
		}else{
			psndo = new EnPsnDO();
			psndo.setId_emp(empId);
			ep.changeEmp(psndo,IEnDictCodeConst.SD_EMPROLE_DOCTOR);
		}
	}
	/***
	 * 是否可以修改当前责任医生
	 * @param entId
	 * @param empId
	 * @return
	 * @throws BizException 
	 */
	public FBoolean isCanUpdateDutyEmp(String entId, String empId,PatiVisitDO patiVisitDO) throws BizException{
		//1.就诊不存在，不允许修改
		if(EnValidator.isEmpty(entId) || patiVisitDO == null){
			throw new BizException("患者就诊不存在！");
		}
		//2.当前医疗组为空允许修改
		if(EnValidator.isEmpty(patiVisitDO.getId_wg_phy())){
			return FBoolean.TRUE;
		}
		//3.当前医生是否属于该业务组
		return isBelongBizGroup(patiVisitDO.getId_wg_phy(),empId);
	}
	
	/***
	 * 获取当前医生是否属于该业务组
	 * 
	 * @return
	 * @throws BizException 
	 */
	private FBoolean isBelongBizGroup(String id_wg,String empId) throws BizException{
		IBizgrpRService rservice = ServiceFinder.find(IBizgrpRService.class);
		BizgrpAggDO aggdo = rservice.findById(id_wg);
		if(aggdo != null){
			BizGrpEmpsDO[] empsdos = aggdo.getBizGrpEmpsDO();
			if(empsdos != null && empsdos.length > 0){
				FBoolean isBelong = FBoolean.FALSE;
				for(BizGrpEmpsDO empsdo : empsdos){
					if(!EnValidator.isEmpty(empsdo.getId_emp()) && empsdo.getId_emp().equals(empId)){
						isBelong = FBoolean.TRUE;
						return FBoolean.TRUE;
					}
				}
				if(FBoolean.FALSE.equals(isBelong)){
					throw new BizException("当前医生不属于患者就诊所在业务组，不允许修改！");
				}
			}
		}
		return FBoolean.FALSE;
	}
	/***
	 * 修改婴儿医护人员信息
	 * 
	 * @param entId
	 * @param empId
	 * @throws BizException 
	 */
	private void updateNbInfo(String entId, String empId) throws BizException{
		NbEP ep = new NbEP();
		NewbornDO[] nbdos = ep.getNbListByMomEnt(entId);
		if(nbdos == null || nbdos.length <= 0)
			return;
		for(NewbornDO nb : nbdos){
			if(!EnValidator.isEmpty(nb.getId_ent_bb())){
				//1.获取患者就诊信息
				PatiVisitDO patiVisitDO = this.getEnEnt(nb.getId_ent_bb());
				if(patiVisitDO != null){
					//2.修改就诊表
					this.updateDuty(patiVisitDO, empId);
					//3.修改就诊人员表
					this.updateDutyEmp(entId, empId);
				}
			}
		}
	} 
}
