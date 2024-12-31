package iih.ci.mrqc.autoqc.ruleclazz.record;

import java.util.ArrayList;

import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.autoitmconfig.d.AutoItmConfigDO;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonInterface;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonRuleUtil;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.en.pv.dto.d.EnEmrDTO;

/**
 * ------危重病例缺副主任医师以上人员查房记录
 * @author yangjianbing
 *
 */
public class PhysicianCheckingRecord implements CommonInterface {
	
	private double limitTime;
	private EnEmrDTO enEmrDTO;//患者信息
	private String strSqlIsHaveMR;//是否存在记录的sql
	private String strSqlIsHavedButOverTiem;//查询记录Do的sql where 条件
	private String id_qc_type;
	private AutoItmConfigDO autoItmConfigDO;

	@Override
	public void setEnEmrDTOAndAutoItm(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type){
		this.enEmrDTO = enEmrDTO;
		this.strSqlIsHaveMR = CommonRuleUtil.getStrSqlIsHaveMR(enEmrDTO, autoItmConfigDO);
		this.strSqlIsHavedButOverTiem = CommonRuleUtil.getStrSqlIsHavedButOverTiem(enEmrDTO, autoItmConfigDO);
		this.autoItmConfigDO=autoItmConfigDO;
		this.id_qc_type=id_qc_type;
	}

	@Override
	public ArrayList isOk() throws Exception {
		/*
		 * 1 判断是否超时，没有直接返回true，
		 * 2 超时，则判断该患者信息是否存在，不存在直接返回false，
		 * 3 存在，则继续判断是否有文书记录信息且在48小时之内，满足返回true，不满足返回false
		 */
		if(!IsOverTime()){
			 return null;
		 }else if(!CommonRuleUtil.IsHaveAR(strSqlIsHaveMR)){
			 return newDivideArr(enEmrDTO);
		 }else if(IsExistDocumentRecord()){
			 return newDivideArr(enEmrDTO);
		 } else{
			 return null;
		 }
	}
	public ArrayList newDivideArr(EnEmrDTO enEmrDTO)  throws Exception{

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
	/**
	 * 入院时间是否已经超过48小时
	 * @return
	 */
	public boolean IsOverTime(){
		 String date1= enEmrDTO.getDt_acpt().toString();//入院时间
		 if(CommonRuleUtil.IsOverTimeCur(date1,limitTime)){
			 return true;
		 }else{
			 return false;
		 }	 
	}

	public boolean IsExistDocumentRecord() throws Exception{
		String date1= enEmrDTO.getDt_acpt().toString();//入科时间
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