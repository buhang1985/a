package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.event.OPDiagNoseContinueEvent;
import iih.en.pv.s.event.OpDiagEndEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;

/**
 * 诊毕
 * @param entId 就诊id
 * @param gowhereId 去向id
 * @param gowhereSd 去向编码
 * @throws BizException
 * @author renying
 */
public class DiagEndBP {

	public void exec(String entId, String gowhereId, String gowhereSd,FBoolean Fg_needrtn) throws BizException {		
		PvEP pvEp = new PvEP();
		PatiVisitDO patiVisitDO = pvEp.getPvByPK(entId);
		if(patiVisitDO != null && IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(patiVisitDO.getCode_entp()))
			return;
		OpEP opEp = new OpEP();
		OutpatientDO outpatientDO = opEp.getOpByEntIdWithOutRef(entId);
		if(outpatientDO != null && IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(outpatientDO.getSd_status()))
			return;
		if(patiVisitDO != null){
			patiVisitDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH); // 诊毕  不要注掉我的代码
			patiVisitDO.setStatus(DOStatus.UPDATED);
			patiVisitDO.setDt_end(EnAppUtils.getServerDateTime());
			pvEp.savePv(patiVisitDO);
		}else{
			throw new BizException("就诊数据不存在");
		}
		if(outpatientDO != null){
			outpatientDO.setId_gowhere(gowhereId);
			outpatientDO.setSd_gowhere(gowhereSd);
			outpatientDO.setFg_needrtn(Fg_needrtn);
			outpatientDO.setStatus(DOStatus.UPDATED);
			outpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH); // 诊毕
			opEp.save(outpatientDO);
		}else{
			throw new BizException("门诊数据不存在");
		}
		EntEmpEP entEmpEp = new EntEmpEP();
	    entEmpEp.endOldEmp(entId, null, null);
		
	    if(!FBoolean.TRUE.equals(Fg_needrtn)){
	    	//发送诊毕事件
	    	this.fireEvent(entId);
	    }
	    if(FBoolean.TRUE.equals(Fg_needrtn)){
	    	//发送待回诊事件
	    	this.noseContinueEvent(entId);
	    }
	}
	/**
	 * 发送诊毕事件
	 * 
	 * @param entId
	 */
	private void fireEvent(String entId){
		try {
			OpDiagEndEvent event = new OpDiagEndEvent(entId);
			event.invoke();
		} catch (Exception e) {
			Logger.error("发送诊毕事件失败！", e);
		}
	}
	
	/**
	 * 发送待回诊事件
	 * fanlq 2017-09-01
	 * @param entId
	 */
	private void noseContinueEvent(String entId){
		try {
			OPDiagNoseContinueEvent event = new OPDiagNoseContinueEvent(entId);
			event.invoke();
		} catch (Exception e) {
			Logger.error("发送待回诊事件失败！", e);
		}
	}
	
}
