package iih.ci.mrqc.autoqc.ruleclazz.record;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.autoitmconfig.d.AutoItmConfigDO;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonInterface;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonRuleUtil;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.en.pv.dto.d.EnEmrDTO;

/**
 * 缺首次病程记录或未在患者入院8小时内完成
 * @author Founder
 *
 */
public class FirstCourseRecordRule  implements CommonInterface{
	
	private EnEmrDTO enEmrDTO;
	private String strSqlIsHaveMR;//是否存在记录的sql
	private String strSqlIsHavedButOverTiem;//查询记录Do的sql where 条件
	private double limitTime;
	private String id_qc_type;
	private AutoItmConfigDO autoItmConfigDO;
	
	public void setEnEmrDTOAndAutoItm(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type) {
		this.enEmrDTO= enEmrDTO; //患者
		this.autoItmConfigDO= autoItmConfigDO;//自动质控项目
		this.strSqlIsHaveMR = CommonRuleUtil.getStrSqlIsHaveMR(enEmrDTO, autoItmConfigDO);
		this.strSqlIsHavedButOverTiem = CommonRuleUtil.getStrSqlIsHavedButOverTiem(enEmrDTO, autoItmConfigDO);
		this.limitTime=autoItmConfigDO.getDead_hours().toDouble();
		this.id_qc_type=id_qc_type;
	}
	
	public ArrayList isOk() throws Exception {
		 if(!IsOverTime()){
			 return null;
			 
		 }else if(!IsHaveAR()){
			 
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
	
	public boolean IsOverTime() throws Exception{
		 String date1= enEmrDTO.getDt_acpt().toString();//入科时间
		 if(CommonRuleUtil.IsOverTimeCur(date1,limitTime)){
			 return true;
		 }else{
			 return false;
		 }	 
	}

	public boolean IsHaveAR() throws BizException{
		DAFacade daf=new DAFacade();
		int mrCount=(int) daf.execQuery(strSqlIsHaveMR, new ColumnHandler());
		if(mrCount>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean IsHavedButOverTiem() throws Exception{
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
	
//	public void InitSql(){
//		//拼strSqlIsHaveAR
//		String strMrTps = autoItmConfigDO.getId_mr_types();
//		if(strMrTps!=null&&strMrTps!=""&&strMrTps.length()>0){
//			strMrTps=strMrTps.replaceAll(",","','");
//			strMrTps="('"+strMrTps+"')";
//		}
//		strSqlIsHaveMR = " select count(id_mr) from CI_MR  where id_ent='"+enEmrDTO.getId_ent()+"' and sd_su_mr !='00' and id_mrtp in "+strMrTps;
//		
//		//拼strSqlIsHavedButOverTiem
//		strSqlIsHavedButOverTiem = " id_ent = '"+enEmrDTO.getId_ent()+"' and sd_su_mr!='00' and id_mrtp in " +strMrTps;
//	}
}
