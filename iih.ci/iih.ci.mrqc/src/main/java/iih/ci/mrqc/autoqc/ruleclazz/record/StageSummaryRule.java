package iih.ci.mrqc.autoqc.ruleclazz.record;

import java.util.ArrayList;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.autoitmconfig.d.AutoItmConfigDO;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonInterface;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonRuleUtil;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.en.pv.dto.d.EnEmrDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 判断
 * 无阶段小结或未按时完成阶段小结 住院超过30天无阶段小结
 * @author Founder
 */
public class StageSummaryRule implements CommonInterface{
	/*
	 * 1 判断是否时间超过30天，若未超过，返回true
	 * 2 若超过了，判断是否出院
	 * 3 若出院，判断出院日期与住院日期差，未超过30返回true
	 * 4 出院了，且超过了30天，判断有无小结，有返回true，没有返回false
	 * 5 若未出院，直接判断有无阶段小结，有true，没有false
	 */
	private double limitTime;
	private EnEmrDTO enEmrDTO;//患者
	private String strSqlIsHaveMR;//是否存在该患者记录 sql
	private String strSqlIsHavedButOverTiem;//查询记录do的sql where条件
	private AutoItmConfigDO autoItmConfigDO;
	private String id_qc_type;
	
	@Override
	public void setEnEmrDTOAndAutoItm(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type) {
		this.enEmrDTO = enEmrDTO;
		this.strSqlIsHaveMR = CommonRuleUtil.getStrSqlIsHaveMR(enEmrDTO, autoItmConfigDO);
		this.strSqlIsHavedButOverTiem = CommonRuleUtil.getStrSqlIsHavedButOverTiem(enEmrDTO, autoItmConfigDO);
		this.limitTime=autoItmConfigDO.getDead_hours().toDouble();
		this.autoItmConfigDO=autoItmConfigDO;
		this.id_qc_type=id_qc_type;
	}
	@Override
	public ArrayList isOk() throws Exception {
		if(!IsOverTime()){
			return null;
		}else if(!CommonRuleUtil.IsHaveAR(strSqlIsHaveMR)){
			return newDivideArr(enEmrDTO,autoItmConfigDO);
		}else if(IsLeaveHospital()){
			if(!IsOverTime30()){
				return null; 
			}else{
				//判断是否有小结
				return newDivideArr(enEmrDTO,autoItmConfigDO);
			}
		}else{
			//判断是否有小结
			return newDivideArr(enEmrDTO,autoItmConfigDO);
		}
	}
	public ArrayList newDivideArr(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO)  throws Exception{

		ArrayList list = new ArrayList();
		
		DivideDO divideDO = new DivideDO();
		divideDO.setId_ent(enEmrDTO.getId_ent());
		divideDO.setId_qa_ty(id_qc_type);
		divideDO.setId_qa_itm(autoItmConfigDO.getId_qa_itm());
		divideDO.setDeduct_scr_times(1);
		divideDO.setId_sbmt_user("");//系统
		divideDO.setSbmt_time(new FDateTime());
		divideDO.setStatus(DOStatus.NEW);
		list.add(divideDO);
		return list;
		
	}
	public boolean IsOverTime() {
		String date1= enEmrDTO.getDt_acpt().toString();//入院时间
		 if(CommonRuleUtil.IsOverTimeCur(date1,limitTime)){
			 return true;
		 }else{
			 return false;
		 }
	}
	
	/**
	 * 判断入院时间与出院时间差是否超过30天
	 * @throws Exception 
	 */
	public boolean IsOverTime30(){
		boolean b = false;
		String date1 = enEmrDTO.getDt_acpt().toString();
		String date2 = enEmrDTO.getDt_end().toString();
		try {
			if(CommonRuleUtil.CalcIsOverTime(date1,date2,limitTime)){
				 b = true;
			 }else{
				 b = false;
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * true  出院
	 * false 未出院
	 * @return
	 */
	public boolean IsLeaveHospital(){
		String date = enEmrDTO.getDt_end().toString();
		if("".equals(date) || date == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 判断是否有小结
	 */
	public boolean IsHavedButOverTiem() throws Exception {
		String date1= enEmrDTO.getDt_acpt().toString();//入院时间
		ICiemrRService iCiemrRService = ServiceFinder.find(ICiemrRService.class);
		CiMrDO[] ciMrDOArr = iCiemrRService.find(strSqlIsHavedButOverTiem, "", new FBoolean(false));
		if(ciMrDOArr.length > 0){
			String date2 = ciMrDOArr[0].getDate_submit().toString();//书写记录时间
			if(CommonRuleUtil.CalcIsOverTime(date1,date2,limitTime)){
				return true;
			}else{
				return false;
			}
		}
		return true;
	}
	

}
