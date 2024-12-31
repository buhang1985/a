package iih.ci.mrqc.autoqc.ruleclazz.deletion;

import java.util.ArrayList;

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
 *---- 缺手术清点记录
 * @author yangjianbing
 *
 */
public class DeletionInventoryRecord implements CommonInterface {

	private EnEmrDTO enEmrDTO;//患者
	private String strSqlIsHaveMR;//是否存在记录的sql
	private String strSqlIsHavedButOverTiem;//查询记录Do的sql where 条件
	private String id_qc_type;
	private String mrtaskstr;
	private MrTaskDO [] mrtasklist;
	private AutoItmConfigDO autoItmConfigDO;
	@Override
	public void setEnEmrDTOAndAutoItm(EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type) throws BizException {
		this.enEmrDTO = enEmrDTO;
		this.strSqlIsHaveMR = CommonRuleUtil.getStrSqlIsHaveMR(enEmrDTO, autoItmConfigDO);
		this.strSqlIsHavedButOverTiem = CommonRuleUtil.getStrSqlIsHavedButOverTiem(enEmrDTO, autoItmConfigDO);
		this.id_qc_type=id_qc_type;
		this.autoItmConfigDO= autoItmConfigDO;
	}

	@Override
	public ArrayList isOk() throws Exception {
		/*
		 * 1 判断有无手术，无则返回true
		 * 2 有手术，则继续判断是否有手术清点记录，有返回true，没有返回false
		 */
		if(!CommonRuleUtil.IsOperation(enEmrDTO)){
			return null;
		}else if(!CommonRuleUtil.IsHaveAR(strSqlIsHaveMR)){
			 return newDivideArr(enEmrDTO,autoItmConfigDO);
		 }else if(CommonRuleUtil.IsExistDocumentRecord(strSqlIsHavedButOverTiem)){
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

}
