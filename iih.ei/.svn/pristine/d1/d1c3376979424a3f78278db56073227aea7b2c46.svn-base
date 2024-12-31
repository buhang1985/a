package iih.ei.std.s.v1.bp.en;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import xap.mw.core.utils.StringUtil;

public class GetEntStatusBP {

	/**
	 * 状态
	 */
	public static final String STATUS_APT = "0";//0.预约未取号
	public static final String STATUS_REGIST = "1";//1.正常挂号
	public static final String STATUS_TRIAGE = "2";//2.已分诊未上屏
	public static final String STATUS_ACPT = "3";//3.就诊
	public static final String STATUS_FINISH = "4";//4.诊毕
	public static final String STATUS_NOTIFY = "5";//5.叫号
	public static final String STATUS_ARRIVE = "6";//6.分诊台到诊
	public static final String STATUS_TRIAGEANDSCREENED = "7";//7.已分诊已上屏
	public static final String STATUS_PASSED = "8";//7 过号
	
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
			return STATUS_APT;
		}else if(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER.equals(sd_status)) {//02
			if(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(sd_status_acpt)) {//-1
				return STATUS_REGIST;
			}else if(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT.equals(sd_status_acpt)) {//0
				if(StringUtil.isEmpty(id_que_site)){
					return STATUS_ARRIVE;
				}else {
					if(sortno_called!=null && sortno_called > 0)
						return STATUS_TRIAGEANDSCREENED;
					else
						return STATUS_TRIAGE;
				}
			}else if(IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(sd_status_acpt)) {//1
				return STATUS_NOTIFY;
			}else if(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME.equals(sd_status_acpt)) {//2
				return STATUS_PASSED;
			}
		}else if(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER.equals(sd_status)) {//05
			return STATUS_ACPT;
		}else if(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(sd_status)) {//08
			return STATUS_FINISH;
		}
		return null;
	}
	
	
	/**
	 * 获取就诊状态
	 * 不能判定出未缴费状态的预约
	 * @param sd_status
	 * @param sd_status_acpt
	 * @param id_que_site
	 * @return
	 */
	public String getVisitStatusNew(String sd_status, String sd_status_acpt, String id_que_site, Integer sortno_called) {
				
		//01
		if(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER.equals(sd_status) && IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(sd_status_acpt)) {
			return STATUS_APT;
		}

		//02		 -1                                 未到诊
		if(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER.equals(sd_status) 
				&& IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(sd_status_acpt)) 
		{
			return STATUS_REGIST;
	    }
		//05          3                                       就诊中
		if(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER.equals(sd_status)
				&& IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(sd_status_acpt)) {
			return STATUS_ACPT;
		}
		// 08         3                                         诊毕
		if(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(sd_status)
				&& IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(sd_status_acpt)) {
			return STATUS_FINISH;
		}
		// 0 到诊    null  =0
		if(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT.equals(sd_status_acpt)  )
		{
			if(StringUtil.isEmpty(id_que_site)){
				return STATUS_ARRIVE;  //到诊
			}else{
				if( sortno_called==0 || sortno_called == null ){
					return STATUS_TRIAGE; //分诊
				}else {
					return STATUS_TRIAGEANDSCREENED; //已分诊已上屏
				}
			}
			
		}else if(IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(sd_status_acpt) )
		{
			return STATUS_NOTIFY; //叫号
		}else if(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME.equals(sd_status_acpt) ){
			return STATUS_PASSED; //过号
		}else {
			return STATUS_ACPT;
		}		
	}
}
