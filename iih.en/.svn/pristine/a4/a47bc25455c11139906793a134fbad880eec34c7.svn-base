package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnEvtDO;
import iih.en.pv.enres.i.IEnevtCudService;
import iih.en.pv.enres.i.IEnevtRService;
import iih.en.pv.out.d.EnEvtDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊事件EP
 * 
 * @author liubin
 *
 */
public class EnEvtEP {
	/**
	 * 新增就诊事件
	 * 
	 * @param enEvtDTOs
	 * @return
	 * @throws BizException
	 */
	public EnEvtDO[] insertEvt(EnEvtDTO[] enEvtDTOs) throws BizException{
		if(EnValidator.isEmpty(enEvtDTOs))
			return null;
		List<EnEvtDO> enEvtDOs = new ArrayList<>(enEvtDTOs.length);
		for(EnEvtDTO enEvtDTO : enEvtDTOs){
			EnEvtDO enEvt = new EnEvtDO();
			enEvt.setStatus(DOStatus.NEW);
			enEvt.setId_ent(enEvtDTO.getId_ent());
			enEvt.setId_erpre(enEvtDTO.getId_erpre());
			enEvt.setSd_entevt(enEvtDTO.getSd_entevt());
			enEvt.setShort_des(enEvtDTO.getShort_des());
			enEvt.setDes(enEvtDTO.getDes());
			enEvt.setDt_evt(enEvtDTO.getDt_evt());
			enEvt.setId_emp_rec(enEvtDTO.getId_emp_rec());
			enEvt.setDt_insert(enEvtDTO.getDt_insert());
			enEvt.setVal_old(enEvtDTO.getVal_old());
			enEvt.setVal_new(enEvtDTO.getVal_new());
			enEvtDOs.add(enEvt);
		}
		return getCudServ().save(enEvtDOs.toArray(new EnEvtDO[enEvtDOs.size()]));
	}
	
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IEnevtRService getRServ(){
		return ServiceFinder.find(IEnevtRService.class);
	}
	/**
	 * 获取增删改服务
	 * 
	 * @return
	 */
	public IEnevtCudService getCudServ(){
		return ServiceFinder.find(IEnevtCudService.class);
	}
}
