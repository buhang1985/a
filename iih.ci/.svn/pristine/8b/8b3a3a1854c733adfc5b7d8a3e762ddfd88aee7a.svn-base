package iih.ci.mrqc.autoqc.ruleclazz.deletion;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import iih.ci.mrqc.autoitmconfig.d.AutoItmConfigDO;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonInterface;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonRuleUtil;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.en.pv.dto.d.EnEmrDTO;

/**
 * 缺术后3天内上级医师查房记录
 * 无法获取到手术时间、、暂时不编写
 * @author Founder
 */
public class DeletionAfterOperationRoundsRecord implements CommonInterface {
	private double limitTime;
//	private static final int limitTime = 3*24;
	private EnEmrDTO enEmrDTO;//患者信息
	private String strSqlIsHaveMR;//是否存在记录的sql
	private String strSqlIsHavedButOverTiem;//查询记录Do的sql where 条件
	private String id_qc_type;
	private String mrtaskstr;
	private MrTaskDO [] mrtasklist;
	private AutoItmConfigDO autoItmConfigDO;
	@Override
	public void setEnEmrDTOAndAutoItm(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type) throws BizException{
		this.enEmrDTO = enEmrDTO;
		this.strSqlIsHaveMR = CommonRuleUtil.getStrSqlIsHaveMR(enEmrDTO, autoItmConfigDO);
		this.strSqlIsHavedButOverTiem =CommonRuleUtil.getStrSqlIsHavedButOverTiem(enEmrDTO, autoItmConfigDO);
		this.limitTime=autoItmConfigDO.getDead_hours().toDouble();
	}

	@Override
	public ArrayList isOk() throws Exception {
		/*
		 * 1 判断是否有手术，没有手术直接返回true
		 * 2 判断是否超过三天，没有则返回true
		 * 3 判断是否存在患者信息
		 * 4 有手术且超过三天，判断是否有上级医师查房记录，有返回true，没有返回false
		 */
//		if (!CommonRuleUtil.IsOperation(enEmrDTO)) {
//			return null;
//		}
//		// else if(!){//判断是否超过三天
//		// 无法获取到手术时间，不知道手术时间在那个表，那个字段
//		// }
//		else 
			if (!CommonRuleUtil.IsHaveAR(strSqlIsHaveMR)) {
			return newDivideArr(enEmrDTO,autoItmConfigDO);
		} else if (CommonRuleUtil.IsExistDocumentRecord(strSqlIsHavedButOverTiem)) {
			return null;
		} else {
			return newDivideArr(enEmrDTO,autoItmConfigDO);
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
	 * 判断是否超过三天
	 * @return
	 * @throws Exception
	 */
	public boolean IsOverTime() throws Exception{
		 String date1= enEmrDTO.getDt_acpt().toString();//入科时间
		 if(CommonRuleUtil.IsOverTimeCur(date1,limitTime)){
			 return true;
		 }else{
			 return false;
		 }	 
	}

	
}
