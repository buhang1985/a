package iih.en.pv.s.listener.bp;

import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.i.IEnstateRService;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.s.bp.SetEntStateBP;
import iih.mp.mpbd.mpskdevent.d.NmrEventDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class UpdateIpPatStateBP {

	/**
	 * 更新就诊状况
	 * @param nmrEventDTO
	 * @param sd_state
	 * @param eventType
	 * @author lilei
	 * 20180829
	 */
	public void exec(NmrEventDTO nmrEventDTO,String eventType)throws BizException{
		//dto转换
		EntStateDTO entStateDTO = new EntStateDTO();
		entStateDTO.setId_ent(nmrEventDTO.getId_ent());//就诊id
		entStateDTO.setId_enstatetp(nmrEventDTO.getId_enstatetp());//就诊状况类型id
		entStateDTO.setSd_enstatetp(nmrEventDTO.getSd_enstatetp());//状况类型编码
		IEnstateRService rService = ServiceFinder.find(IEnstateRService.class);
		BdEnStateDO bdStateDO = rService.findById(nmrEventDTO.getId_enstate());
		if (bdStateDO != null) {
			entStateDTO.setId_entstatedef(bdStateDO.getId_enstate());//状况id
			entStateDTO.setVal(bdStateDO.getVal());//就诊状况值
		}
		entStateDTO.setFg_del(nmrEventDTO.getFg_del());
		entStateDTO.setDt_occ(nmrEventDTO.getDt_oper());//发生时间
		//设置就诊状况
		SetEntStateBP bp = new SetEntStateBP();
		bp.exec(entStateDTO);
	}
}
