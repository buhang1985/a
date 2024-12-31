package iih.ci.mrqc.autoqc.ruleclazz.deletion;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
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
import iih.ci.mrqc.mrtask.i.IMrtaskRService;
import iih.en.pv.dto.d.EnEmrDTO;
/**
 * 无转入记录或未按时完成转入记录
 * @author zouhaiqinag
 *
 */
public class DeletionIntoDeptRecord  implements CommonInterface{
	private double limitTime;
//	private static final int limitTime = 48;
	private EnEmrDTO enEmrDTO;//患者信息
	private String strSqlIsHaveMRByTask;//是否存在记录的sql
	private String strSqlIsHavedButOverTiemByTask;//查询记录Do的sql where 条件
	private String id_qc_type;
	private String mrtaskstr;
	private MrTaskDO [] mrtasklist;
	private AutoItmConfigDO autoItmConfigDO;
	/**
	 * 将患者信息、自动质控项目DO传入
	 * 组合sql语句
	 */
	@Override
	public void setEnEmrDTOAndAutoItm(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type) throws BizException {
		this.enEmrDTO= enEmrDTO; //患者
		this.limitTime=autoItmConfigDO.getDead_hours().toDouble();
		this.id_qc_type=id_qc_type;
		this.autoItmConfigDO= autoItmConfigDO;
		this.getMrtaskList();
	}
	public MrTaskDO [] getMrtaskList() throws BizException{
		
		this.mrtaskstr=CommonRuleUtil.getStrSqlHowManyMrTask(enEmrDTO,autoItmConfigDO);
		IMrtaskRService mrtaskService =ServiceFinder.find(IMrtaskRService.class);
		this.mrtasklist=mrtaskService.find(mrtaskstr, "", FBoolean.TRUE);
		if(mrtasklist.length>0){
			this.strSqlIsHaveMRByTask = CommonRuleUtil.getStrSqlIsHaveMRByTask(mrtasklist, autoItmConfigDO);	
			this.strSqlIsHavedButOverTiemByTask = CommonRuleUtil.getStrSqlIsHavedButOverTiemByTask(mrtasklist, autoItmConfigDO);
		}

		return mrtasklist;

	}
	@Override
	public ArrayList isOk() throws Exception {
		/*
		 * 1 判断是否有转入，没有转入直接返回true
		 * 2 判断是否超过规定时间，没有则返回true
		 * 3 判断是否存在患者转入记录信息
		 * 4 有转入记录且超过规定时间，判断是否有上级医师查房记录，有返回true，没有返回false
		 */

		// else if(!){//判断是否超过24小时
		// 无法获取到转入时间，不知道转入时间在哪个表，哪个字段
		// }
		if(mrtasklist.length==0){
			return null;
		}
		if (!CommonRuleUtil.IsHaveAR(strSqlIsHaveMRByTask)) {
			return newDivideArr(enEmrDTO,autoItmConfigDO);
		} else if (CommonRuleUtil.IsExistDocumentRecord(strSqlIsHavedButOverTiemByTask)) {
			return null;
		}else if(IsHavedButOverTiem()){
				 return newDivideArr(enEmrDTO,autoItmConfigDO);
		} else {
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
	
	/**
	 * 判断是否超时
	 * @return
	 * @throws Exception
	 */
	public boolean IsHavedButOverTiem() throws Exception{
		String date1= enEmrDTO.getDt_acpt().toString();//入科时间
		ICiemrRService iCiemrRService = ServiceFinder.find(ICiemrRService.class);
		CiMrDO[] ciMrDOArr = iCiemrRService.find(strSqlIsHavedButOverTiemByTask, "", new FBoolean(false));
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
