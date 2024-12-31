package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.RentBed4EsDTO;
import iih.en.pv.s.event.IpRentBedEvent;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 包床BP
 * @author renying
 *
 */
public class RentBedBP {
	/**
	 * 包床
	 * @param entId 就诊id
	 * @param mainBedId 主床位id
	 * @param bedId 床位id
	 * @throws BizException
	 */
	public void exec(String entId,String mainBedId,String bedId) throws BizException{
		this.validate(entId);
		//1、修改床位状态
		BedEP bedBP = new BedEP();
		Bdbed bedDO = bedBP.rentBed(entId, mainBedId, bedId);
		//2、就诊包床
		EntBedEP entBedEP = new EntBedEP();
		entBedEP.rentBed(entId,bedDO.getId_bed(),bedDO.getName(),bedDO.getId_dep_belong(),EnAppUtils.getServerDateTime());		
		//3、记录包床就诊事件
		new EnEvtHandle().insertRentBedEvt(entId, bedDO);
		//3、触发事件
		this.invokeEvent(entId, mainBedId,bedDO);
	}
	/**
	 * 校验
	 * 
	 * @throws BizException
	 */
	private void validate(String entId) throws BizException{
		IpEP ipep = new IpEP();
		InpatientDO[] inpados = ipep.getIpDOsInHos(entId);
		if(EnValidator.isEmpty(inpados)){
			throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
		}
		if (!inpados[0].getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
		}
		if(FBoolean.TRUE.equals(inpados[0].getFg_blrecall())){
	    	throw new BizException("该患者是费用召回患者，不允许包床！");
	    }
	}
	
	/**
	 * 触发事件
	 * @param entId 原床位
	 * @param mainBedId 主床ID
	 * @param bedDTO 目标床位
	 * @throws BizException
	 */
	private void invokeEvent(String entId,String mainBedId,Bdbed bedDTO) throws BizException{
		//1、构造事件源
		RentBed4EsDTO rentBed4EsDTO = new RentBed4EsDTO();
		
		//2、触发事件
		IpRentBedEvent rentBedEvent = new IpRentBedEvent();
		rentBedEvent.invoke(rentBed4EsDTO);;
	}
}
