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
 * 无会诊意见或未在规定时间内完成记录
 * @author zouhaiqinag
 *
 */
public class DeletionGroupConsultationRecord  implements CommonInterface{

	private EnEmrDTO enEmrDTO;
	private String strSqlIsHaveMRByTask;//是否存在记录的sql
	private String strSqlIsHavedButOverTiemByTask;//查询记录Do的sql where 条件
	private double limitTime;
	private String id_qc_type;
	private String mrtaskstr;
	private MrTaskDO [] mrtaskdos;
	private CiMrDO[]  cimrdos;
	private AutoItmConfigDO autoItmConfigDO;
	
	@Override
	public void setEnEmrDTOAndAutoItm(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type) throws BizException  {

		this.enEmrDTO = enEmrDTO;
		this.limitTime=autoItmConfigDO.getDead_hours().toDouble();
		this.id_qc_type=id_qc_type;
		this.autoItmConfigDO= autoItmConfigDO;
		this.getmrtaskdos();
	}
	
	public void getmrtaskdos() throws BizException{

		this.mrtaskstr=CommonRuleUtil.getStrSqlHowManyMrTask(enEmrDTO,autoItmConfigDO);
		IMrtaskRService mrtaskService =ServiceFinder.find(IMrtaskRService.class);
		this.mrtaskdos=mrtaskService.find(mrtaskstr, "", FBoolean.TRUE);
		if(mrtaskdos.length>0){
			this.strSqlIsHaveMRByTask = CommonRuleUtil.getStrSqlIsHaveMRByTask(mrtaskdos, autoItmConfigDO);	
			this.strSqlIsHavedButOverTiemByTask = CommonRuleUtil.getStrSqlIsHavedButOverTiemByTask(mrtaskdos, autoItmConfigDO);
		}

	}
	@Override
	public ArrayList isOk()  throws Exception {
		//ArrayList list = new ArrayList();
		ArrayList<DivideDO> list = new ArrayList();
		if(mrtaskdos.length > 0 && cimrdos.length > 0){
			this.getCiMrArr();
			//this.getmrtaskdos();
		
			for(int i=0;i<mrtaskdos.length;i++){
				//mrtaskdos[i]
				for(int j=0;j<cimrdos.length;j++){
					if(mrtaskdos[i].getId_source().equals(cimrdos[j].getTask_id())&&
					mrtaskdos[i].getId_mrtp().equals(cimrdos[j].getId_mrtp())){
						if(!CommonRuleUtil.IsOverTimeCur(mrtaskdos[i].getDt_begin().toString(),limitTime)){
							//return null;
						}else if(!CommonRuleUtil.IsHaveAR(strSqlIsHaveMRByTask)){
							list.add(newDivideArr(mrtaskdos[i]));
						}else if(CommonRuleUtil.IsExistDocumentRecord(strSqlIsHavedButOverTiemByTask)){
							//return null;
						}else{
							list.add(newDivideArr(mrtaskdos[i]));
						}
					}
				}
			}
			
		}
		if(mrtaskdos.length > 0 && cimrdos.length == 0){
			//code
			this.getCiMrArr();
			//this.getmrtaskdos();
			for(int i=0;i<mrtaskdos.length;i++){
				if(!CommonRuleUtil.IsOverTimeCur(mrtaskdos[i].getDt_begin().toString(),limitTime)){
					//return null;
				}else if(!CommonRuleUtil.IsHaveAR(strSqlIsHaveMRByTask)){
					list.add(newDivideArr(mrtaskdos[i]));
				}else if(CommonRuleUtil.IsExistDocumentRecord(strSqlIsHavedButOverTiemByTask)){
					//return null;
				}else{
					list.add(newDivideArr(mrtaskdos[i]));
				}
			}
		}
		return list;
	}
	public void getCiMrArr() throws BizException{
		ICiemrRService iCiemrRService = ServiceFinder.find(ICiemrRService.class);
		CiMrDO[] ciMrDOArr = iCiemrRService.find(mrtaskstr, "", new FBoolean(false));
		if(ciMrDOArr.length > 0){
			this.cimrdos=ciMrDOArr;
		}
	}

	public DivideDO newDivideArr(MrTaskDO mrTaskDO)  throws Exception{


			DivideDO divideDO = new DivideDO();
			divideDO.setId_ent(mrTaskDO.getId_ent());
			divideDO.setId_qa_ty(id_qc_type);
			divideDO.setId_qa_itm(this.autoItmConfigDO.getId_qa_itm());
			divideDO.setDeduct_scr_times(1);
			divideDO.setId_sbmt_user("");//系统
			divideDO.setSbmt_time(new FDateTime());
			divideDO.setDrp_des(mrTaskDO.getSource_name());
			divideDO.setStatus(DOStatus.NEW);

		return divideDO;
		
	}
	public boolean IsOverTime() throws Exception{
		 String date1= enEmrDTO.getDt_acpt().toString();//入科时间
		 if(CommonRuleUtil.IsOverTimeCur(date1,limitTime)){
			 return true;
		 }else{
			 return false;//没超时
		 }	 
	}
}
