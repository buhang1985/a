package iih.en.ip.s.bp;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.ip.dto.d.EnHosRegInfoDTO;
import iih.en.ip.s.bp.events.IpDisHosEvent;
import iih.en.ip.s.bp.ip.ValidateCanRegInfoBP2;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.DisHos4EsDTO;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 取消登记
 * 
 * @author Tang.ht
 *
 */
public class CancelRegisterBP2 {
	/**
	 * 取消登记
	 * 
	 * @param enhosRegDTO
	 * @throws BizException
	 */
	public void exec(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
	
		//1、 查找就诊数据
		InpatientDO inpatientDO = this.getInpatient(enHosRegInfoDTO.getId_ent());
		//2.校验数据
		ValidateCanRegInfoBP2 vb = new ValidateCanRegInfoBP2();
		vb.exec(enHosRegInfoDTO, inpatientDO);
		//3、更新住院信息
		this.updateInpatientDO(inpatientDO, enHosRegInfoDTO);
	}
	
	/**
	 * 获取住院数据
	 * 
	 * @param entID
	 * @return
	 * @throws BizException
	 */
	public InpatientDO getInpatient(String entId) throws BizException {
		IpEP ep = new IpEP();
		InpatientDO inpatientDO= ep.getIpByEntId(entId);
		
		if (inpatientDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENT);
		}
		
		return inpatientDO;
	}
		
	
	/**
	 * 更新住院信息
	 * 
	 * @param inpatientDO
	 * @param enhosRegDTO
	 * @throws BizException
	 */
	private void updateInpatientDO(InpatientDO inpatientDO, EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
		PiPatEP piPatEP = new PiPatEP();
		IPatiMDOCudService iPatiCudService = piPatEP.getMCudServ();
		IPatiMDORService iPatiRService = piPatEP.getMRServ();
		IInpatientCudService inpatientCrudService = ServiceFinder.find(IInpatientCudService.class);		
		
		FDateTime curTime = EnAppUtils.getServerDateTime();

		// 释放占用床位
		BedEP bedbp = new BedEP();
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(inpatientDO.getId_dep_nuradm()))) {
			bedbp.releaseBedWithSex(inpatientDO.getId_ent(), inpatientDO.getId_bed(), FBoolean.FALSE);
		}else {
			bedbp.releaseBed(inpatientDO.getId_ent(), inpatientDO.getId_bed());
		}
		// 住院表
		inpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT);// 修改状态
		int timesIp = inpatientDO.getTimes_ip();
		inpatientDO.setTimes_ip(this.setIpTimes(enHosRegInfoDTO.getId_pat()));
		// 退院
		inpatientCrudService.update(new InpatientDO[] { inpatientDO });
		//更新住院表后，同步患者表住院次数
		PatDO patdo = iPatiRService.findById(enHosRegInfoDTO.getId_pat());
		if(patdo != null){
			patdo.setLast_times_ip(inpatientDO.getTimes_ip());
			iPatiCudService.update(new PatDO[]{patdo});
		}
		// 就诊表
		PvEP ep = new PvEP();
		PatiVisitDO patiVisitDO = ep.getPvById(enHosRegInfoDTO.getId_ent());
		patiVisitDO.setStatus(DOStatus.UPDATED);
		patiVisitDO.setFg_canc(FBoolean.TRUE); // 退诊标志
		patiVisitDO.setId_emp_canc(EnContextUtils.getPsnId()); // 退诊人员
		patiVisitDO.setDt_canc(curTime); // 取消时间
		ep.savePv(patiVisitDO);
		try {
			this.invokeCancelRegistEvent(patiVisitDO, inpatientDO, timesIp);
		} catch (Exception e) {
			Logger.error("取消入院登记消息发送失败：",e);
		}
	}
	
	/**
	 * 设置出院次数
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private int setIpTimes(String patId) throws BizException {
		IpEP ipEP = new IpEP();
		return ipEP.setCanCelTimes(patId);
	}
	
	/**
	 * 取消登记事件
	 * 
	 * @param patiVisitDO
	 * @throws BizException 
	 */
	private void invokeCancelRegistEvent(PatiVisitDO patiVisitDO, InpatientDO inpatientDO, Integer timesIp) throws BizException {
		DisHos4EsDTO esDTO = new DisHos4EsDTO();
		esDTO.setId_ent(patiVisitDO.getId_ent());
		esDTO.setId_pat(patiVisitDO.getId_pat());
		esDTO.setId_dep_nur(patiVisitDO.getId_dep_nur());
		esDTO.setId_dep_phy(patiVisitDO.getId_dep_phy());
		esDTO.setBed_code(inpatientDO.getName_bed());
		esDTO.setDt_lv(EnAppUtils.getServerDateTime());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		esDTO.setCode_pat(patiVisitDO.getCode_pat());
		esDTO.setTimes_ip(timesIp);
		
		IpDisHosEvent disEvent = new IpDisHosEvent();
		disEvent.invoke(esDTO);
	}
}
