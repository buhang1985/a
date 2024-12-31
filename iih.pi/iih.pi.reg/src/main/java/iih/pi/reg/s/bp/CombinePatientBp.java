package iih.pi.reg.s.bp;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.s.bp.PiPatInsertHistoryBP;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者合并逻辑类
 * @author ly
 *
 */
public class CombinePatientBp {
	
	/**
	 * 患者合并
	 * @param mainDo
	 * @param oldDo
	 * @return
	 * @throws BizException
	 */
	public void exec(PatDO mainDo, PatDO oldDo) throws BizException {		
		//1.插入一条患者关键信息变动记录
		PiPatInsertHistoryBP hisBp = new PiPatInsertHistoryBP();
		hisBp.exec(oldDo, mainDo, true);
		
		//2.停用患者数据合并到保留患者数据中
		this.CombineCardInfo(mainDo, oldDo);
		
	}
	
	
	/**
	 * 合并患者卡信息
	 * @param mainDo
	 * @param oldDo
	 * @throws BizException
	 */
	private void CombineCardInfo(PatDO mainDo, PatDO oldDo) throws BizException {
		
		//查询停用患者相关数据
		IPatiMDORService  patirservice = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patDOs = patirservice.findByAttrValString(PatDO.ID_PERSON, oldDo.getCode());
		
		for(PatDO patDO:patDOs){
			patDO.setFg_active(FBoolean.FALSE);
			patDO.setId_person(mainDo.getId_person());
			patDO.setStatus(DOStatus.UPDATED);
		}
		
		IPatiMDOCudService patcudService = ServiceFinder.find(IPatiMDOCudService.class);
		patcudService.update(patDOs);
	}
}
