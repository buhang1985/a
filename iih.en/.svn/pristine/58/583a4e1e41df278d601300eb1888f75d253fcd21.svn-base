package iih.en.pv.s.bp.op;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊就诊查询BP
 * @author yank	
 *
 */
public class GetRegInfoListBP {
	public GetRegInfoListBP(){}
	/**
	 * 获取患者挂号信息
	 * 
	 * @param patId 患者id
	 * @param status 就诊状态数组
	 * @param bDate 挂号日期_开始时间
	 * @param eDate 挂号日期_结束时间
	 * @return
	 * @throws BizException 
	 */
	public RegInfoDTO[] exec(String patId, FDate bDate, FDate eDate) throws BizException{
		StringBuilder sqlBuilder = getBaseStringBuilder();
		sqlBuilder.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "ENT") + " ");
		SqlParam param = new SqlParam();
		//患者id
		if(!EnValidator.isEmpty(patId)) {
			sqlBuilder.append(" AND ENT.ID_PAT=?");
			param.addParam(patId);
		}
		if(bDate != null) {
			sqlBuilder.append(" AND SUBSTR(ENT.DT_ENTRY, 0, 10) >= ? ");
			param.addParam(bDate);
		}
		if(eDate != null) {
			sqlBuilder.append(" AND SUBSTR(ENT.DT_ENTRY, 0, 10) <= ? ");
			param.addParam(eDate);
		}
		sqlBuilder.append(" AND ISNULL(ENT.FG_CANC,'N')= 'N' ");
		sqlBuilder.append(" ORDER BY ENT.DT_ENTRY,ENT.DT_INSERT ");
		return this.queryRegInfos(sqlBuilder.toString(), param);
	}
	/**
	 * 获取患者挂号信息
	 * @param oprId 操作员id 若为null，则查询所有
	 * @param patId 患者id 
	 * @param status 就诊状态数组
	 * @param valid 是否有效
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO[] exec(String oprId,String patId,String[] status,FBoolean valid) throws BizException {		
		StringBuilder sqlBuilder = getBaseStringBuilder();
		sqlBuilder.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "ENT") + " ");
		SqlParam param = new SqlParam();
		//操作员
		if(!EnValidator.isEmpty(oprId)){
			sqlBuilder.append(" AND ENT.ID_EMP_ENTRY=?");
			param.addParam(oprId);
			//今天挂的号
			FDateTime datetime= EnAppUtils.getServerDateTime();
			sqlBuilder.append(" AND SUBSTR(ENT.DT_INSERT,0,10)=?");
			param.addParam(datetime.getDate());
		}
		//患者id
		if(!EnValidator.isEmpty(patId)){
			sqlBuilder.append(" AND ENT.ID_PAT=?");
			param.addParam(patId);
		}
		//就诊状态
		if(!EnValidator.isEmpty(status)){
			sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("OP.SD_STATUS", status));
		}
		//是否有效
		if(valid!=null){
			if(valid.booleanValue()){
				sqlBuilder.append(" AND OP.DT_VALID_E>=?");
				FDateTime datetime= EnAppUtils.getServerDateTime();			
				param.addParam(datetime);
				sqlBuilder.append(" AND ISNULL(ENT.FG_CANC,'N')= 'N' ");
			}
		}
		if(!EnValidator.isEmpty(oprId)){
			sqlBuilder.append(" ORDER BY ENT.DT_INSERT");
		}
		else{
			sqlBuilder.append(" ORDER BY ENT.DT_ENTRY,ENT.DT_INSERT ");
		}
		return this.queryRegInfos(sqlBuilder.toString(), param);
	}
	
	/**
	 * 获取患者挂号信息
	 * @param oprId 操作员id 若为null，则查询所有
	 * @param patId 患者id 
	 * @param status 就诊状态数组
	 * @param valid 是否有效
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO exec(String entId) throws BizException {		
		RegInfoDTO[] res = exec(new String[]{entId});
		if(!EnValidator.isEmpty(res)){
			return res[0];
		}
		return null;
	}
	/**
	 * 获取患者挂号信息
	 * @param oprId 操作员id 若为null，则查询所有
	 * @param patId 患者id 
	 * @param status 就诊状态数组
	 * @param valid 是否有效
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO[] exec(String[] entIds) throws BizException {		
		StringBuilder sqlBuilder = getBaseStringBuilder();
		sqlBuilder.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "ENT") + " ");
		SqlParam param = new SqlParam();
		if(!EnValidator.isEmpty(entIds)){
			sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("ENT.ID_ENT", entIds));		
		}
		sqlBuilder.append(" ORDER BY ENT.DT_ENTRY,ENT.DT_INSERT ");
		RegInfoDTO[] regInfoDTOs = this.queryRegInfos(sqlBuilder.toString(), param);
		if(EnValidator.isEmpty(regInfoDTOs)){
			return null;
		}
		return regInfoDTOs;
	}
	
	
	/**
	 * 查询数据
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private RegInfoDTO[] queryRegInfos(String sql, SqlParam param ) throws BizException{
		@SuppressWarnings("unchecked")
		List<RegInfoDTO> regInfoList = (List<RegInfoDTO>)new DAFacade().execQuery(sql,param, new BeanListHandler(RegInfoDTO.class));
		if (!EnValidator.isEmpty(regInfoList)) {
			return regInfoList.toArray(new RegInfoDTO[0]);
		}
		return null;
	}
	/**
	 * 获取基础sql
	 * 
	 * @return
	 */
	private StringBuilder getBaseStringBuilder(){
		StringBuilder sqlBuilder = new StringBuilder();		
		sqlBuilder.append("SELECT ENT.ID_ENT,ENT.CODE_ENTP,ENT.CODE ENT_CODE,ENT.ID_PAT,ENT.NAME_PAT,ENT.ID_EMP_ENTRY,OPREG.ID_HP,OPREG.ID_PRIPAT,PRIPAT.NAME AS NAME_PRIPAT,");
		sqlBuilder.append("OPREG.ID_PATCA,PATCA.NAME AS NAME_PATCA, OPREG.ID_PATCRET AS ID_PATCREDTP, PATCRET.NAME AS NAME_PATCREDTP,");
		sqlBuilder.append("SUBSTR(ENT.DT_ENTRY,0,10) REGISTED_DATE,OP.ID_DATESLOT ID_DAYSLOT,LOT.NAME DAYSLOT,");
		sqlBuilder.append("OP.ID_SCHAPT ID_APT,OP.ID_SCH,OP.ID_SCRES,RES.NAME AS NAME_SCRES,CPL.ID_SCPL,CPL.NAME AS Regres,OP.ID_SCSRV,SRV.NAME NAME_SCSRV,");
		sqlBuilder.append("OP.TICKETNO TICKNO,OP.ID_TICKS,OP.EU_REGTP,");
		sqlBuilder.append("OP.FG_CG,OP.ID_CG,OP.SD_STATUS,");
		sqlBuilder.append("HP.NAME AS NAME_HP,OPREG.NO_HP,HP.SD_HPTP,OPREG.FG_FUNDPAY AS FG_HPSETTLE,ENTHP.ID_HPKIND,ENTHP.CODE_HPKIND,OPREG.FG_HP_CARD,OP.ID_SCSRV ");
		sqlBuilder.append(" FROM EN_ENT_OP OP");
		sqlBuilder.append(" INNER JOIN EN_ENT ENT ON OP.ID_ENT=ENT.ID_ENT ");
		sqlBuilder.append(" LEFT JOIN EN_ENT_OP_REG OPREG ON OP.ID_ENT = OPREG.ID_ENT ");
		sqlBuilder.append(" LEFT JOIN SC_SCH SCH ON OP.ID_SCH= SCH.ID_SCH ");
		sqlBuilder.append(" LEFT JOIN SC_RES RES ON OP.ID_SCRES=RES.ID_SCRES ");
		sqlBuilder.append(" LEFT JOIN SC_SRV SRV ON OP.ID_SCSRV=SRV.ID_SCSRV ");
		sqlBuilder.append(" LEFT OUTER JOIN SC_PL CPL ON SCH.ID_SCPL = CPL.ID_SCPL ");
		sqlBuilder.append(" LEFT JOIN BD_DAYSLOT LOT ON OP.ID_DATESLOT =LOT.ID_DAYSLOT ");
		sqlBuilder.append(" LEFT JOIN BD_HP HP ON OPREG.ID_HP=HP.ID_HP ");
		sqlBuilder.append(" LEFT OUTER JOIN EN_ENT_HP ENTHP ON ENT.ID_ENT = ENTHP.ID_ENT AND ENTHP.FG_MAJ='Y' ");
		sqlBuilder.append(" LEFT JOIN BD_PRI_PAT PRIPAT ON OPREG.ID_PRIPAT = PRIPAT.ID_PRIPAT ");
		sqlBuilder.append(" LEFT JOIN PI_PAT_CA PATCA ON OPREG.ID_PATCA = PATCA.ID_PATCA ");
		sqlBuilder.append(" LEFT JOIN PI_PAT_CRET PATCRET ON OPREG.ID_PATCRET = PATCRET.ID_PATCRET ");
		sqlBuilder.append(" WHERE 1=1 ");
		return sqlBuilder;
	}
}
