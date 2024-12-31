package iih.ci.mb.bp;

import java.util.List;

import iih.bd.base.validator.ParamValidator;
import iih.bd.utils.BdEnvContextUtil;
import iih.ci.mb.i.ArrayOfDCPatientHospitalRecord;
import iih.ci.mb.i.DCPatientHospitalRecord;
import iih.ci.mb.i.GetPatientHistoryHRByIDResponse;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者历史住院记录
 * @author yankan
 * @since 2018-03-13
 *
 */
public class GetPatIpHistoryBP {
	/**
	 * 获取患者历史住院记录
	 * @param patId 患者ID
	 * @return 住院记录集合
	 * @throws BizException
	 */
	public GetPatientHistoryHRByIDResponse exec(String patId) throws BizException{
		//参数校验
		ParamValidator.validateNotNull("患者ID", patId);
		//1、获取住院记录
		DCPatientHospitalRecord[] records = this.getPatIpHistory(patId);
		
		//2、处理数据
		handleData(records);
		//2、组装返回结果
		ArrayOfDCPatientHospitalRecord recordArray = new ArrayOfDCPatientHospitalRecord();
		recordArray.setDCPatientHospitalRecord(records);;
		GetPatientHistoryHRByIDResponse response = new GetPatientHistoryHRByIDResponse();
		response.setGetPatientHistoryHRByIDResult(recordArray);
		return response;
	}
	
	/**
	 * 处理相关信息
	 */
	private void handleData(DCPatientHospitalRecord[] records) {
		if (records != null && records.length > 0) {
			for (DCPatientHospitalRecord param : records) {
				// 年龄计算
				if (!StringUtil.isEmptyWithTrim(param.getBirthDay())) {
					FDate dt_birth = new FDate(param.getBirthDay());
					param.setAge(AgeCalcUtil.getAge(dt_birth));
				}
				// 在院时间计算
				if (param.getEnterDate() != null) {
					FDateTime dt_entry = new FDateTime(param.getEnterDate());
					FDateTime dt_end = null;
					if (!StringUtil.isEmptyWithTrim(param.getExitDate()))
						dt_end = new FDateTime(param.getExitDate());
					else
						dt_end = new FDateTime();
					param.setInHosDay(dt_end.getDaysAfter(dt_entry)+1);
				}
			}
		}
	}
	/**
	 * 获取患者住院记录
	 * @param patId 患者ID
	 * @return 住院记录集合
	 * @throws BizException
	 */
	private DCPatientHospitalRecord[] getPatIpHistory(String patId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ENT.id_ent AS ID,");
		sqlBuilder.append("ENT.NAME_PAT AS NAME,");
		sqlBuilder.append("ENT.CODE AS HID,");
		sqlBuilder.append("IP.CODE_AMR_IP AS CASEID,");
		sqlBuilder.append(" ENT.id_ent clinicid,");
		sqlBuilder.append("IP.times_ip AS SUBID,");
		sqlBuilder.append("ENT.ID_HP AS MEDICALINSURANCEID,");
		sqlBuilder.append("patca.name AS PAYMENT,");
		sqlBuilder.append("PAT.DT_BIRTH AS BIRTHDAY,");    
		sqlBuilder.append("'' AS AGE,");
		sqlBuilder.append("udisex.name AS SEX,");
		sqlBuilder.append("ENT.ADDR_PAT AS ADDRESS,");
		sqlBuilder.append("ENT.TELNO_PAT AS PHONE,");
		
		sqlBuilder.append("PAT.ID_CODE  AS  IDENTITYNUMBER,");
		sqlBuilder.append("COUNTRY.NAME AS NATION,");
		sqlBuilder.append("CONT.NAME AS LINKMANNAME,");
		sqlBuilder.append("CONT.CONTTEL AS LINKMANPHONE,");
		sqlBuilder.append("CONTTP.NAME AS LINKMANRELATION,");
		sqlBuilder.append("ENT.DT_ENTRY AS ENTERDATE,");
		sqlBuilder.append("ENT.DT_END AS EXITDATE,");
		sqlBuilder.append("IP.NAME_BED AS BEDNO,");
		sqlBuilder.append("DEPT.CODE AS DEPTCODE,");
		sqlBuilder.append("DEPT.NAME AS DEPTNAME,");
		sqlBuilder.append("TO_DATE(SUBSTR(ENT.DT_END,0,10),'YYYY-MM-DD') - TO_DATE(SUBSTR(ENT.DT_ENTRY,0,10),'YYYY-MM-DD') AS INHOSDAY,");
		sqlBuilder.append("ACC.AMT_UNCG AS TOTALCOST,");
		sqlBuilder.append("ACC.AMT_UNCG AS TOTALPAYMENTS,");
		sqlBuilder.append("ACC.AMT_PREPAY AS PREPAYMENTS,");
		sqlBuilder.append("ACC.amt_prepay - ACC.amt_uncg as OverFee,"); 
		sqlBuilder.append(" nvl(enentdi.name_didef_dis,didef.name ) as diagnosis,");    
		sqlBuilder.append("(case state.val when '00' then '特级' when '01' then '一级' when '02' then '二级' when '03' then '三级' else '其他' end)  AS CARELEVEL,");
		sqlBuilder.append("(case IP.sd_level_dise when '00' then '危' when '01' then '重' else '普' end ) AS CURRENTSTATE,");
		sqlBuilder.append(" psn.name as DOCTORINCHARGE,");
		sqlBuilder.append(" psn_nur.name as  NURSEINCHARGE");
		sqlBuilder.append(" FROM EN_ENT ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT=ENT.ID_ENT");
		sqlBuilder.append(" LEFT JOIN EN_ENT_ACC ACC ON ACC.ID_ENT=ENT.ID_ENT");
		sqlBuilder.append(" LEFT JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
		sqlBuilder.append(" LEFT JOIN BD_DEP DEPT ON DEPT.ID_DEP = ENT.ID_DEP_PHY");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC COUNTRY ON COUNTRY.ID_UDIDOC=PAT.ID_COUNTRY");
		sqlBuilder.append(" LEFT JOIN EN_ENT_CONT CONT ON CONT.ID_ENT=ENT.ID_ENT AND CONT.EU_ENTCONTTP=?");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC CONTTP ON CONTTP.ID_UDIDOC=CONT.ID_CONTTP");
		sqlBuilder.append(" LEFT JOIN pi_pat_ca patca on ENT.id_patca = patca.id_patca");
		sqlBuilder.append(" LEFT JOIN en_ent_di enentdi on enentdi.id_ent=ENT.id_ent and enentdi.fg_maj =?"); 
		sqlBuilder.append(" LEFT JOIN bd_udidoc udisex on ENT.id_sex_pat = udisex.id_udidoc and udisex.id_udidoclist=?"); // 性别
		sqlBuilder.append(" LEFT JOIN bd_psndoc psn on psn.id_psndoc = ENT.id_emp_phy ");
		sqlBuilder.append(" LEFT JOIN bd_psndoc psn_nur on psn_nur.id_psndoc = ENT.id_emp_nur");
		sqlBuilder.append(" LEFT JOIN bd_di_def didef  on didef.id_didef = IP.id_diag_op");
		sqlBuilder.append(" left join en_ent_state entsta on entsta.id_ent = ent.id_ent and entsta.id_enstatetp =?                    ");// 护理级别取流水
		sqlBuilder.append(" left join bd_en_state state on entsta.id_entstatedef = state.id_enstate");
		sqlBuilder.append(" WHERE ENT.FG_CANC=? AND ENT.CODE_ENTP=? ");
		sqlBuilder.append(" AND "+BdEnvContextUtil.processEnvContext(new PatiVisitDO(), "ENT"));// 增加多组织)
		sqlBuilder.append(" AND IP.CODE_AMR_IP =?");
		
		SqlParam param = new SqlParam();
		param.addParam("1");
		param.addParam("Y");
		param.addParam("@@@@ZZ20000000000035");
		param.addParam("@@@@AA1000000008FO40");
		param.addParam("N");
		param.addParam("10");
		param.addParam(patId);
		
		List<DCPatientHospitalRecord> ipRecordList = (List<DCPatientHospitalRecord>)new DAFacade().execQuery(sqlBuilder.toString(), param,new BeanListHandler(DCPatientHospitalRecord.class));
		if(!ListUtil.isEmpty(ipRecordList)){
			return ipRecordList.toArray(new DCPatientHospitalRecord[0]);
		}else{
			return null;
		}		
	}
}
