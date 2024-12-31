package iih.ci.mrqc.autoqc.ruleclazz.deathcase;

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
 * 缺死亡病例讨论记录或未在规定时间内完成 死亡病历在死亡7日内缺死亡讨论记录
 * @author Founder
 *
 */
public class DeletionDeathMrDiscussionRecord  implements CommonInterface{
	
		private double limitTime;
		private EnEmrDTO enEmrDTO;//患者信息
		private String strSqlIsHaveMRByTask;//是否存在记录的sql
		private String strSqlIsHavedButOverTiemByTask;//查询记录Do的sql where 条件
		private String isDead;
		private String id_qc_type;
		private String mrtaskstr;
		private MrTaskDO [] mrtasklist;
		private AutoItmConfigDO autoItmConfigDO;
		/**
		 * 将患者信息、自动质控项目DO传入
		 * 组合sql语句
		 */
		@Override
		public void setEnEmrDTOAndAutoItm(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type) throws BizException{
			
			this.limitTime=autoItmConfigDO.getDead_hours().toDouble();
			this.isDead=enEmrDTO.getSd_outcomes();
			this.id_qc_type=id_qc_type;
			this.autoItmConfigDO= autoItmConfigDO;
			this.enEmrDTO=enEmrDTO;
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
			if(mrtasklist.length==0){
				return null;
			}
			if(isDead == null || "".equals(isDead) || "~".equals(isDead) )	//去空格大于零大于零 	
				return null;
			/**
			 * 验证代码
			 */
			if(!isDead.equals("03")){   //这人没死 没死不能插入  返回true
				return null;
			}
			else if(!IsOverTime()){//没有超时  返回true  不插入主句
				 return null;
			 }else if(!CommonRuleUtil.IsHaveAR(strSqlIsHaveMRByTask)){//没有死亡记录
				 return newDivideArr(enEmrDTO,autoItmConfigDO);
			 }else if(IsHavedButOverTiem()){//有 超时了没在规定时间 就  得插入 IsHavedButOverTiem()为true才可插入
				 return newDivideArr(enEmrDTO,autoItmConfigDO);
			 } else{
				 return null;
			 }
		}
		public ArrayList newDivideArr(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO)  throws Exception{

			ArrayList list = new ArrayList();
			for(int i=0;i<mrtasklist.length;i++){
				DivideDO divideDO = new DivideDO();
				divideDO.setId_ent(enEmrDTO.getId_ent());
				divideDO.setId_qa_ty(id_qc_type);
				divideDO.setId_qa_itm(autoItmConfigDO.getId_qa_itm());
				divideDO.setDeduct_scr_times(1);
				divideDO.setId_sbmt_user("");//系统
				divideDO.setSbmt_time(new FDateTime());
				divideDO.setStatus(DOStatus.NEW);
				list.add(divideDO);
			}

			return list;
			
		}
		/**
		 * 是否超过24*7=168小时
		 * @return
		 */
		public boolean IsOverTime(){
			 String date1= enEmrDTO.getDt_acpt().toString();//此处需要获取死亡时间   暂用入科时间替代
			 if(CommonRuleUtil.IsOverTimeCur(date1,limitTime)){
				 return true;
			 }else{
				 return false;
			 }	 
		}
		/**
		 * 判断有死亡病例讨论记录后是否超时 24*7=168
		 * @return
		 * @throws Exception
		 */
		public boolean IsHavedButOverTiem() throws Exception{
			String date1= enEmrDTO.getDt_acpt().toString();//此处需要获取死亡时间   暂用入科时间替代
			ICiemrRService iCiemrRService = ServiceFinder.find(ICiemrRService.class);
			CiMrDO[] ciMrDOArr = iCiemrRService.find(strSqlIsHavedButOverTiemByTask, "", new FBoolean(false));
			if(ciMrDOArr.length > 0){
				String date2 = ciMrDOArr[0].getDate_submit().toString();
				if(CommonRuleUtil.CalcIsOverTime(date1,date2,limitTime)){
					return true;//超时 需要插入扣分项
				}else{
					return false;
				}
			}
			return true;
		}
		

}
