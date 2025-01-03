package iih.en.pv.s.bp.ippre;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntWgEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.enres.s.EnbedCrudServiceImpl;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.inpatient.i.IEnippreCudService;
import iih.en.pv.inpatient.i.IEnippreRService;
import iih.en.pv.inpatient.s.InpatientCrudServiceImpl;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.s.PativisitCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 取消预住院转住院
 */
public class CancelIppreSuspendHosBP {
	
	public void exec(EnIppreInfoDTO ippreTransHos) throws BizException{
		//1.校验状态是否已经变化
		EnIppreDO enIppreDO = this.validateStatus(ippreTransHos);
		PativisitCrudServiceImpl pvService = new PativisitCrudServiceImpl();
		PatiVisitDO pvDO = pvService.findById(ippreTransHos.getId_ent());
		//2.修改预住院表
		this.updateppreDO(enIppreDO);
		//3.还原就诊信息
		this.updatePvDO(pvDO,pvService);
		//4.床位占用
		this.useBed(ippreTransHos);
		//5.还原住院表
		this.updateIpDO(ippreTransHos);
		//6.更新就诊资源--床位
		this.updateEntBed(ippreTransHos);
		//7.恢复医疗组
		EntWgEP entWgEp = new EntWgEP();
		entWgEp.recWg(ippreTransHos.getId_ent(), ippreTransHos.getExit_times());
		//8、恢复医护人员
		EntEmpEP entEmpEP = new EntEmpEP();
		entEmpEP.recEmp(ippreTransHos.getId_ent(), ippreTransHos.getExit_times());
		//9.记录事件
        new EnEvtHandle().insertIppreCancelSuspendHosEvt(ippreTransHos);
	}
	
	//还是得有原床位
	private void updateEntBed(EnIppreInfoDTO ippreTransHos) throws BizException {
		String whereSql = "";
		EnbedCrudServiceImpl enbedService = new EnbedCrudServiceImpl();
		if (ippreTransHos.getId_bed_new().equals(ippreTransHos.getId_bed())) {
			// 原来的床位，则更新结束时间
			whereSql = String.format("Id_ent = '%s' and Id_usetype='%s' AND dt_e='%s'", ippreTransHos.getId_ent(), IEnDictCodeConst.ID_USETYPE_MAIN, ippreTransHos.getExit_times());
			EnBedDO[] enbedDOs = enbedService.find(whereSql, "dt_b desc", FBoolean.FALSE);
			if (enbedDOs != null && enbedDOs.length > 0) {
				EnBedDO enbedDO = enbedDOs[0];
				if(enbedDO.getId_bed().equals(ippreTransHos.getId_bed_new())){
					enbedDO.setStatus(DOStatus.UPDATED);
					enbedDO.setDt_e(null);
					enbedDO.setId_usetype(IEnDictCodeConst.ID_USETYPE_MAIN);// 主床
					enbedService.save(new EnBedDO[] { enbedDO });
				}else{//如果新床和查出的床不一样，新增记录
					EntBedEP entBedBP = new EntBedEP();
					entBedBP.useBed(ippreTransHos.getId_ent(), ippreTransHos.getId_bed_new(), ippreTransHos.getName_bed_new(), ippreTransHos.getId_dep_nur(), ippreTransHos.getExit_times());
				}
			}
		} else {
			EntBedEP entBedBP = new EntBedEP();
			entBedBP.useBed(ippreTransHos.getId_ent(), ippreTransHos.getId_bed_new(), ippreTransHos.getName_bed_new(), ippreTransHos.getId_dep_nur(), ippreTransHos.getExit_times());
		}
	}
	
	/**
	 * 占用床位
	 * @param enIppreDO
	 * @throws BizException
	 */
	private void useBed(EnIppreInfoDTO enIppreDO) throws BizException {
		BedEP bedBP = new BedEP();
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(enIppreDO.getCur_id_dep_nur()))) {
			bedBP.occupyBedWithSex(enIppreDO.getId_bed_new(), null, enIppreDO.getSd_sex().toString(), FBoolean.TRUE, 
					IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT, IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);
		}else {
			bedBP.useBed(enIppreDO.getId_bed_new());
		}
	}
	
	/**
	 * 更新住院表
	 * @param ippreTransHos
	 * @throws BizException
	 */
	private void updateIpDO(EnIppreInfoDTO ippreTransHos) throws BizException {
		// 3、还原住院信息，并更新床位
		InpatientCrudServiceImpl ipService = new InpatientCrudServiceImpl();
		InpatientDO[] ipDOs = ipService.find(String.format("id_ent='%s'", ippreTransHos.getId_ent()), null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(ipDOs)) {
			InpatientDO ipDO = ipDOs[0];
			ipDO.setId_dep_phydisc(null);// 出院科室置空
			ipDO.setId_dep_nurdisc(null);// 出院病区置空
			ipDO.setDt_disc(null);//出院时间置空
			ipDO.setId_bed(ippreTransHos.getId_bed_new());// 保存新床位
			ipDO.setName_bed(ippreTransHos.getName_bed_new());// 保存新床号
			ipDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN);// 状态改为入科
			//ipDO.setFg_blrecall(ippreTransHos.getFg_blrecall());
			ipDO.setStatus(DOStatus.UPDATED);
			ipService.save(new InpatientDO[] { ipDO });
		}
		
	}
	/**
	 * 更新就诊表
	 * @param pvDO
	 * @param pvService
	 * @throws BizException
	 */
	private void updatePvDO(PatiVisitDO pvDO, PativisitCrudServiceImpl pvService) throws BizException {
		pvDO.setFg_ip(FBoolean.TRUE);
		pvDO.setDt_end(null);
		pvDO.setStatus(DOStatus.UPDATED);
		pvService.save(new PatiVisitDO[] { pvDO });
		
	}

	/**
	 * 修改预住院表
	 * @param enIppreDO
	 * @throws BizException 
	 */
	private void updateppreDO(EnIppreDO enIppreDO) throws BizException {
		IEnippreCudService icudService = ServiceFinder.find(IEnippreCudService.class);
		enIppreDO.setSd_status(IEnDictCodeConst.SD_STATUS_IPPRE_HOS_ENTER_PRE);
		enIppreDO.setStatus(DOStatus.UPDATED);
		enIppreDO.setDt_end_ippre(null);
		icudService.save(new EnIppreDO[]{enIppreDO});
	}
	/**
	 * 校验患者状态
	 * @param transDTO
	 * @return
	 * @throws BizException
	 */
	private EnIppreDO validateStatus(EnIppreInfoDTO transDTO) throws BizException {
		if(transDTO==null){
			throw new BizException("传入的选中信息为空!");
		}
		IEnippreRService iRService = ServiceFinder.find(IEnippreRService.class);
		EnIppreDO[] ippredos = iRService.find(" id_ent = '" + transDTO.getId_ent() + "' and sd_status = '"+IEnDictCodeConst.SD_STATUS_IPPRE_HOS_STOP+"'", "", FBoolean.FALSE);
		if(EnValidator.isEmpty(ippredos)){
			throw new BizException("申请患者的状况已经改变,请刷新页面!");
		}
  	    return ippredos[0];
	}
}
