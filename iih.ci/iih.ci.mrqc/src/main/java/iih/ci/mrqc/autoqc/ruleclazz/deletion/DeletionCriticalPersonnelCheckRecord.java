package iih.ci.mrqc.autoqc.ruleclazz.deletion;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.autoitmconfig.d.AutoItmConfigDO;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonInterface;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonRuleUtil;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.en.pv.dto.d.EnEmrDTO;

/**
 * 日常病程记录未按规定记录病程记录
 * @author Founder
 *
 */
public class DeletionCriticalPersonnelCheckRecord implements CommonInterface {
	
	private double limitTime;
//	private int limitTime = 24;
	private EnEmrDTO enEmrDTO;//患者信息
	//private String strSqlIsHaveMR;//是否存在记录的sql
	private String strSqlIsHavedButOverTiem;//查询记录Do的sql where 条件
	private String id_qc_type;
	private String mrtaskstr;
	private MrTaskDO [] mrtasklist;
	private AutoItmConfigDO autoItmConfigDO;
	@Override
	public void setEnEmrDTOAndAutoItm(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type) throws BizException {
		this.enEmrDTO = enEmrDTO;
		//this.strSqlIsHaveMR = CommonRuleUtil.getStrSqlIsHaveMR(enEmrDTO, autoItmConfigDO);
		this.strSqlIsHavedButOverTiem =CommonRuleUtil.getStrSqlIsHavedButOverTiem(enEmrDTO, autoItmConfigDO);
		this.id_qc_type=id_qc_type;
		this.autoItmConfigDO= autoItmConfigDO;
	}

	@Override
	public ArrayList isOk() throws Exception {
		/*
		 * 1  判断是危、重、稳定那种模式
		 * 2 switch判断：稳定直接返回true
		 * 3  危：判断时间是否超过24小时，没有超过直接return true，否则、判断是否有记录且未超过24小时
		 * 4 重：判断时间是否超过3*24小时，没有直接return true，否则、判断是否有记录且时间未超过3*24；
		 * 5 稳定：直接return true
		 */
		String Id_level_dise = enEmrDTO.getId_level_dise();
		boolean b = false;
		if("".equals(Id_level_dise) || Id_level_dise == null){
			return null;
		}else{
			switch (Id_level_dise) {
				case ICiDictCodeConst.ID_LEVEL_DISE01:
					if(!IsOverTime(limitTime)){
						b = true;
					}else if(!IsExistDocumentRecordInTime()){
						b = true;
					}else{
						b = false;
					}
					break;
				case ICiDictCodeConst.ID_LEVEL_DISE02:
					limitTime *= 3;
					if(!IsOverTime(limitTime)){
						b = true;
					}else if(!IsExistDocumentRecordInTime()){
						b = true;
					}else{
						b = false;
					}
					break;
				case ICiDictCodeConst.ID_LEVEL_DISE03:
					b = true;
					break;
				default:
					break;
			}
		}
		if(b=true){
			return null;
		}else{
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
	 * @param limitTime
	 * @return
	 */
	public boolean IsOverTime(double limitTime){
		String acptDate = enEmrDTO.getDt_acpt().toString();
		boolean b = CommonRuleUtil.IsOverTimeCur(acptDate, limitTime);
		return b;
	}
	
	/**
	 * 判断
	 * 是否缺副主任医师以上人员查房记录
	 * @return
	 * @throws Exception
	 */
	private boolean IsExistDocumentRecordInTime() throws Exception {
		String acptDeath= enEmrDTO.getDt_acpt().toString();
		ICiemrRService iCiemrRService = ServiceFinder.find(ICiemrRService.class);
		CiMrDO[] ciMrDOArr = iCiemrRService.find(strSqlIsHavedButOverTiem, "", new FBoolean(false));
		String  date2 ="";
		if(ciMrDOArr.length > 0){
			date2 = ciMrDOArr[0].getDate_submit().toString();
			if(CommonRuleUtil.CalcIsOverTime(acptDeath,date2,limitTime)){
				return true;
			}else{
				return false;
			}
		}
		return true;
	}

}
