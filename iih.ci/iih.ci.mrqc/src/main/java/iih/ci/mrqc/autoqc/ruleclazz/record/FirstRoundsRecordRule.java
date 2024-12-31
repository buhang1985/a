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
 * 无上级医师首次查房记录或未在患者入院48小时内完成
 * @author Founder
 */
public class FirstRoundsRecordRule implements CommonInterface{
	
	private double limitTime;
	private EnEmrDTO enEmrDTO;//患者信息
	private String strSqlIsHaveMR;//是否存在记录的sql
	private String strSqlIsHavedButOverTiem;//查询记录Do的sql where 条件
	private String id_qc_type;
	private AutoItmConfigDO autoItmConfigDO;
	/**
	 * 将患者信息、自动质控项目DO传入
	 * 组合sql语句
	 */
	@Override
	public void setEnEmrDTOAndAutoItm(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type) {
		this.enEmrDTO= enEmrDTO; //患者
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
			 return newDivideArr(enEmrDTO);
		 }else if(IsHavedButOverTiem()){
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
	 * 判断是否超时
	 * @return
	 * @throws Exception
	 */
	public boolean IsHavedButOverTiem() throws Exception{
		String date1= enEmrDTO.getDt_acpt().toString();//入科时间
		ICiemrRService iCiemrRService = ServiceFinder.find(ICiemrRService.class);
		CiMrDO[] ciMrDOArr = iCiemrRService.find(strSqlIsHavedButOverTiem, "", new FBoolean(false));
		if(ciMrDOArr.length > 0){
			String date2 = ciMrDOArr[0].getDate_submit().toString();
			if(CommonRuleUtil.CalcIsOverTime(date1,date2,limitTime)){
				return true;
			}else{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 入院时间是否已经超过48小时
	 * @return
	 */
	public boolean IsOverTime(){
		 String date1= enEmrDTO.getDt_acpt().toString();//入科时间
		 if(CommonRuleUtil.IsOverTimeCur(date1,limitTime)){
			 return true;
		 }else{
			 return false;
		 }	 
	}
	
	
}
