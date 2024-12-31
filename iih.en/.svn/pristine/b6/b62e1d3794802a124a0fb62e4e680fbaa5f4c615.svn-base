package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.ApptQryModDTO;
import iih.en.pv.outpatient.dto.d.OpApptDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊预约查询
 * @author yankan
 *
 */
public class OpApptQryBP {
	public OpApptQryBP(){}
	/**
	 * 查询门诊预约集合
	 * @param qryMod 查询模板
	 * @return
	 * @throws BizException
	 */
	public OpApptDTO[] getOpApptList(ApptQryModDTO qryMod) throws BizException {
		EnValidator.validateParam("查询模板DTO", qryMod);
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT APT.ID_APT,APT.ID_EMP_APPT,EMP.NAME AS NAME_EMP_APPT,SRV.ID_SCSRV,SRV.NAME NAME_SCSRV,");
		sqlBuilder.append("APT.ID_SCRES,RES.NAME AS NAME_SCRES,");
		sqlBuilder.append("APT.ID_DATESLOT,DAYSLOT.NAME NAME_DAYSLOT,APT.DT_APPT,APT.DT_B,");
		sqlBuilder.append("APT.ID_PAT,PAT.NAME NAME_PAT,PAT.MOB MOB_PAT,PAT.TEL TEL_PAT, ");
		sqlBuilder.append("APT.SD_STATUS");
		sqlBuilder.append(" FROM SC_APT APT ");
		sqlBuilder.append(" LEFT JOIN PI_PAT PAT ON APT.ID_PAT = PAT.ID_PAT ");
		sqlBuilder.append(" LEFT JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV ");
		sqlBuilder.append(" LEFT JOIN SC_RES RES ON APT.ID_SCRES = RES.ID_SCRES ");
		sqlBuilder.append(" LEFT JOIN BD_DAYSLOT DAYSLOT ON APT.ID_DATESLOT = DAYSLOT.ID_DAYSLOT ");
		sqlBuilder.append(" LEFT JOIN BD_PSNDOC EMP ON APT.ID_EMP_APPT=EMP.ID_PSNDOC");
		sqlBuilder.append(" WHERE 1=1 ");
		sqlBuilder.append(" AND APT.SD_SCTP='").append(IScDictCodeConst.SD_SCTP_OP).append("'");//排班类型为门诊
		sqlBuilder.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "APT") + " ");
		SqlParam param = new SqlParam();
		if(qryMod.getDt_ent()!=null){
			sqlBuilder.append(" AND SUBSTR(APT.DT_B,0,10) >= ?");//就诊开始时间，DT_APPT是预约操作时间
			param.addParam(qryMod.getDt_ent());
		}
		//就诊结束时间，fanlq-add-2018.04.23
		if(qryMod.getDt_ent_e()!=null){
			sqlBuilder.append(" AND SUBSTR(APT.DT_B,0,10) <=? ");//就诊结束时间，DT_APPT是预约操作时间
			param.addParam(qryMod.getDt_ent_e());
		}
		//患者姓名
		if(!EnValidator.isEmpty(qryMod.getName_pat())){
			sqlBuilder.append(" AND pat.name = ? ");
			param.addParam(qryMod.getName_pat());
		}
		if(!EnValidator.isEmpty(qryMod.getId_emp())){
			sqlBuilder.append(" AND RES.Id_Emp = ? ");
			param.addParam(qryMod.getId_emp());
		}		
		if(!EnValidator.isEmpty(qryMod.getId_scsrv())){
			sqlBuilder.append(" AND APT.ID_SCSRV=? ");
			param.addParam(qryMod.getId_scsrv());
		}
		// 诊间预约查询当前科室
		if("1".equals(EnParamUtils.getDeptAuthClicDoc(qryMod.getId_psndoc()))){
			sqlBuilder.append(" AND RES.ID_DEP=? ");
			param.addParam(qryMod.getId_dep());
		}
		
		sqlBuilder.append(" ORDER BY APT.DT_APPT DESC");//按预约操作时间倒序排序
		List<OpApptDTO> apptList = (List<OpApptDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(OpApptDTO.class));
		if (EnValidator.isEmpty(apptList)) {
			return null;
		}
		this.procApptDTO(apptList);
		return apptList.toArray(new OpApptDTO[0]);
	}
	/**
	 * 加工处理
	 * @param apptList
	 * @throws BizException
	 */
	private void procApptDTO(List<OpApptDTO> apptList) throws BizException{
		if(EnValidator.isEmpty(apptList)){
			return;
		}
		for(OpApptDTO apptDTO : apptList){
			switch(apptDTO.getSd_status()){
				case IScDictCodeConst.SD_APTSTATUS_ORDER:
					apptDTO.setName_status("预约");
				break;
				case IScDictCodeConst.SD_APTSTATUS_PAY:
					apptDTO.setName_status("支付");
				break;
				case IScDictCodeConst.SD_APTSTATUS_FINISH:
					apptDTO.setName_status("完成");
				break;
				case IScDictCodeConst.SD_APTSTATUS_CANCEL:
					apptDTO.setName_status("取消");
				break;
				default:
					apptDTO.setName_status("预约");
					break;
			}
		}
	}
}
