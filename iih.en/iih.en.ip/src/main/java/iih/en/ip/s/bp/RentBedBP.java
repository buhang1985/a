package iih.en.ip.s.bp;

import iih.bd.res.bed.d.Bdbed;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.ip.dto.d.RentBed4EsDTO;
import iih.en.ip.s.event.RentBedEvent;
import xap.mw.core.data.BizException;

/**
 * 包床BP
 * @author zhangpp
 *
 */
public class RentBedBP {
	
	public void exec(String entId,String mainBedId,String bedId) throws BizException{
		IpEP ipep = new IpEP();
	    ipep.validateInpatientDOByEntId(entId);
		//1、修改床位状态
		BedEP bedBP = new BedEP();
		Bdbed bedDO = bedBP.rentBed(entId, mainBedId, bedId);
		//2、就诊包床
		EntBedEP entBedEP = new EntBedEP();
		entBedEP.rentBed(entId,bedDO.getId_bed(),bedDO.getName(),bedDO.getId_dep_belong(),EnAppUtils.getServerDateTime());		
		//3、触发事件
		this.invokeEvent(entId, mainBedId,bedDO);
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
		RentBedEvent rentBedEvent = new RentBedEvent();
		rentBedEvent.invoke(rentBed4EsDTO);
	}

}
