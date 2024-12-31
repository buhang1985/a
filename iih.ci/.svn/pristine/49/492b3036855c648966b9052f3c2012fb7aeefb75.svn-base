package iih.ci.mr.s.bp.task.bp.MrCheckUnFilnishedTaskBP;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.core.AppUtils;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.i.ICiMrParamService;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class GetpatListbp {

	public void Getpatlist(String id_org) throws BizException, ParseException{
		IMrtaskRService mrtaskRservice = ServiceFinder.find(IMrtaskRService.class);
		ICiMrParamService paraService = ServiceFinder.find(ICiMrParamService.class);// 参数
		IUserRService userRservice = ServiceFinder.find(IUserRService.class);
		
		//获取自动完成书写时间（单位天）
		int days = CiMrParamUtils.GetSysParamMrmHoCompleteInterval(id_org);
		int comhour = days*24;
		//获取预警时间（单位小时）
		int hours = paraService.GetSysParamMrEarlyWarning(id_org);
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		FDateTime dateTime = AppUtils.getServerDateTime();
		
		long nowtime = simpleFormat.parse(dateTime.toString()).getTime();
		GetSqlbp sqlbp = new GetSqlbp();
		CiMrmQryListDTO[] dto = sqlbp.GetSQL(id_org,dateTime,hours,comhour);
		
		for (CiMrmQryListDTO ciMrmQryListDTO : dto) {
			
			//查询是否有待书写文书
			MrTaskDO[]mrtask = mrtaskRservice.find("id_ent = '"+ciMrmQryListDTO.getId_ent()+"' and sd_mrtask_sta = '"+ICiMrDictCodeConst.SD_MRTASKSTA_TODO+"' and ds = '0'", "", FBoolean.FALSE);
			//查询是否有驳回、新建、取回、未审签完成文书
			CiMrDO [] mrdo = GetSqlReviewTpbp.getReviewTp(ciMrmQryListDTO.getId_ent());
			//查询病历完成书写规则
			String iscomplete = IsCompleteRulebp.isCompleteRule(ciMrmQryListDTO.getId_ent());

			FBoolean TS = FBoolean.FALSE;
			StringBuilder str = new StringBuilder();
			str.append(" 病案自动提交预警\n ");
			str.append("根据医院管理要求，以下患者即将自动提交归档，系统检测到有不符合归档条件的病历，请及时处理。\n");
			str.append("患者："+ciMrmQryListDTO.getName_pat()+"   住院号："+ciMrmQryListDTO.getCode_amr_ip()+" \n");
			if(mrtask != null && mrtask.length >0){
				TS = FBoolean.TRUE;
				for (MrTaskDO mrTaskDO : mrtask) {
					str.append("未创建文书： \n");
					str.append("   "+mrTaskDO.getMrtask_name()+"\n");
				}
				if(iscomplete != null){
					str.append(iscomplete);
				}
				
			}else{
				
				if(iscomplete != null){
					TS = FBoolean.TRUE;
					str.append("未创建文书： \n");
					str.append(iscomplete);
				}
			}
			
			FBoolean reject = FBoolean.FALSE;
			FBoolean news = FBoolean.FALSE;
			FBoolean retrieve = FBoolean.FALSE;
			FBoolean uncomplete = FBoolean.FALSE;
			if(mrdo != null && mrdo.length>0){
				for (CiMrDO ciMrDO : mrdo) {
					
					
					if(ciMrDO.getSd_su_mr()==ICiMrDictCodeConst.SD_SU_MR_REJECT){
						TS = FBoolean.TRUE;
						if(reject.equals(FBoolean.FALSE)){
							reject = FBoolean.TRUE;
							str.append("驳回文书：\n");
							str.append("   "+ciMrDO.getName()+"\n");
						}else{
							str.append("   "+ciMrDO.getName()+"\n");
						}
						
					}if(ciMrDO.getSd_su_mr() ==ICiMrDictCodeConst.SD_SU_MR_NEW){
						TS = FBoolean.TRUE;
						if(news.equals(FBoolean.FALSE)){
							news = FBoolean.TRUE;
							str.append("新建文书：\n");
							str.append("   "+ciMrDO.getName()+"\n");
						}else{
							str.append("   "+ciMrDO.getName()+"\n");
						}
						
					}if(ciMrDO.getSd_su_mr() == ICiMrDictCodeConst.SD_SU_MR_RETRIEVE){
						TS = FBoolean.TRUE;
						if(retrieve.equals(FBoolean.FALSE)){
							retrieve = FBoolean.TRUE;
							str.append("取回文书：\n");
							str.append("   "+ciMrDO.getName()+"\n");
						}else{
							str.append("   "+ciMrDO.getName()+"\n");
						}
						
					}if(ciMrDO.getSd_su_mr() == ICiMrDictCodeConst.SD_SU_MR_SIGNING){
						TS = FBoolean.TRUE;
						if(uncomplete.equals(FBoolean.FALSE)){
							uncomplete = FBoolean.TRUE;
							str.append("未审签完成文书：\n");
							str.append("   "+ciMrDO.getName()+"\n");
						}else{
							str.append("   "+ciMrDO.getName()+"\n");
						}
					}
				}
			}
			CiMrmQryListDTO cimrm = new CiMrmQryListDTO();
			cimrm.setBakeoffreason(str.toString());
			UserDO [] user = userRservice.find("Id_psn = '"+ciMrmQryListDTO.getId_emp_phy()+"'", "", FBoolean.FALSE);
			if(user != null && user.length > 0 && TS.equals(FBoolean.TRUE)){
				cimrm.setId_emp_phy(user[0].getId_user());
				SendUnFinisherMsgbp msgbp = new SendUnFinisherMsgbp();
				msgbp.SendUnFinisherMsg(cimrm);
			}
	
		}
			
			}
		
	
}
