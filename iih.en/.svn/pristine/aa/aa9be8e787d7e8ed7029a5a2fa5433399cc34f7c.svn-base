package iih.en.pv.s.bp;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.s.bp.op.ws.ep.WsEp;

/**
 * 给第三方提供的接口设置就诊状态
 * @author Sarah
 *
 */
public class GetVisitFlagBP {
	
	/**
	 * 获取就诊状态
	 * 
	 * @param sd_status
	 * @param sd_status_acpt
	 * @param id_que_site
	 * @return
	 */
	public String getVisitStatus(String sd_status, String sd_status_acpt, String id_que_site, Integer sortno_called) {
		if(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER.equals(sd_status)){//01
			return WsEp.STATUS_APT;
		}else if(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER.equals(sd_status)) {//02
			if(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(sd_status_acpt)) {//-1
				return WsEp.STATUS_REGIST;
			}else if(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT.equals(sd_status_acpt)) {//0
				if(EnValidator.isEmpty(id_que_site)){
					return WsEp.STATUS_ARRIVE;
				}else {
					if(sortno_called!=null && sortno_called > 0)
						return WsEp.STATUS_TRIAGEANDSCREENED;
					else
						return WsEp.STATUS_TRIAGE;
				}
			}else if(IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(sd_status_acpt)) {//1
				return WsEp.STATUS_NOTIFY;
			}else if(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME.equals(sd_status_acpt)) {//2
				return WsEp.STATUS_PASSED;
			}
		}else if(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER.equals(sd_status)) {//05
			return WsEp.STATUS_ACPT;
		}else if(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(sd_status)) {//08
			return WsEp.STATUS_FINISH;
		}
		return null;
	}
	
	
	/**
	 * 获取就诊状态
	 * 
	 * @param sd_status
	 * @param sd_status_acpt
	 * @param id_que_site
	 * @return
	 */
	public String getVisitStatusNew(String sd_status, String sd_status_acpt, String id_que_site, Integer sortno_called) {
		//01
		if(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER.equals(sd_status)){
			return WsEp.STATUS_APT;
		}
		//02		 -1    null   未到诊
		if(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER.equals(sd_status) 
				&& IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(sd_status_acpt)
				&& EnValidator.isEmpty(id_que_site)) 
		{
			return WsEp.STATUS_REGIST;
	    }
		//05          3                                       就诊中
		if(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER.equals(sd_status)
				&& IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(sd_status_acpt)) {
			return WsEp.STATUS_ACPT;
		}
		// 08         3                                         诊毕
		if(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(sd_status)
				&& IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(sd_status_acpt)) {
			return WsEp.STATUS_FINISH;
		}
		// 02/05/08    
		if(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER.equals(sd_status)|| 
				IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER.equals(sd_status)||
				IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(sd_status))         //已分诊未上屏
		{
			// 0 到诊    null  =0
			if(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT.equals(sd_status_acpt)  )
			{
				if(EnValidator.isEmpty(id_que_site)){
					return WsEp.STATUS_ARRIVE;  //到诊
				}else{
					if( sortno_called==0 || sortno_called == null ){
						return WsEp.STATUS_TRIAGE; //分诊
					}else if(sortno_called!=0){
						return WsEp.STATUS_TRIAGEANDSCREENED; //已分诊未上屏
					}
				}
				
			}else if(IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(sd_status_acpt) && !EnValidator.isEmpty(id_que_site))
			{
				return WsEp.STATUS_NOTIFY; //叫号
			}else if(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME.equals(sd_status_acpt) && !EnValidator.isEmpty(id_que_site)){
				return WsEp.STATUS_PASSED; //过号
			}
			
		}
		return null;
	}
}
