package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.patopent.d.PatOpEntListDTO;
import iih.ei.std.d.v1.en.patopent.d.PatOpEntListParamDTO;
import iih.ei.std.d.v1.en.patopent.d.PatOpEntListResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.PatEP;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取患者挂号列表BP   
 * 
 * @author li.wm
 */
public class GetPatOpEntListBP extends IIHServiceBaseBP<PatOpEntListParamDTO, PatOpEntListResultDTO>{
	
	/**
	 * 入参检查
	 * */		
	@Override
	protected void checkParam(PatOpEntListParamDTO param) throws BizException {
		if (param.getDt_begin() == null) {
			throw new BizException("开始日期不能为空！");
		}
		if (param.getDt_end() == null) {
			throw new BizException("结束日期不能为空！");
		}
		if (param.getPageinfo() == null) {
			throw new BizException("未传入分页信息！");
		}
	}

	/***
	 * 核心处理
	 */
	@Override
	protected PatOpEntListResultDTO process(PatOpEntListParamDTO param) throws BizException {
		PatOpEntListResultDTO resultDTO = new PatOpEntListResultDTO();
		//1.校验患者是否存在
		PatDO patDO = null;
		if(StringUtils.isNotEmpty(param.getCode_pat())){
			patDO = new PatEP().getPatByCode(param.getCode_pat());
			if(patDO == null){
				throw new BizException("在IIH中未查到该编码对应的患者！患者编码为："+param.getCode_pat());
			}
		}
		
		//获取SQL
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam,patDO!=null?patDO.getId_pat():null);
		
		//获取list返回值
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo();
		List<PatOpEntListDTO> list = this.findPagingData(pageInfoDto,sql, sqlParam, PatOpEntListDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		//返回值设置分页信息
		resultDTO.setPageinfo(pageInfoDto);
		resultDTO.setPatopent(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	/***
	 * @Description:获取患者预约信息sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private String getSql(PatOpEntListParamDTO param,SqlParam sqlParam,String patId) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT APT.ID_APT,  ");
		sb.append("ENT.ID_ENT, ");
		sb.append("ENT.CODE AS CODE_ENT, ");
		sb.append("PAT.CODE AS CODE_PAT, ");
		sb.append("PAT.NAME AS NAME_PAT, ");
		sb.append("EXCHL.CODE_APT AS CODE_EXAPT, ");
		sb.append("APT.CODE AS CODE_APT, ");
		sb.append("ENTP.CODE AS CODE_ENTP, ");
		sb.append("ENTP.NAME AS NAME_ENTP, ");
		sb.append("CA.CODE AS CODE_PATCA, ");
		sb.append("CA.NAME AS NAME_PATCA, ");
		sb.append("DEP.CODE AS CODE_DEP, ");
		sb.append("DEP.NAME AS NAME_DEP, ");
		sb.append("SRV.CODE AS CODE_SCSRV, ");
		sb.append("SRV.NAME AS NAME_SCSRV, ");
		sb.append("RES.CODE AS CODE_RES,  ");
		sb.append("RES.NAME AS NAME_RES, ");
		sb.append("SRVTP.CODE AS CODE_SRVTP,");
		sb.append("SRVTP.NAME AS NAME_SRVTP,");
		sb.append("LOT.SD_DAYSLOTTP AS CODE_DAYSLOTTP,");
		sb.append("LOT.NAME AS NAME_DAYSLOTTP,");
		sb.append("SUBSTR(ENT.DT_ENTRY, 0, 10) AS DT_ENTRY,");
		sb.append("ENT.DT_INSERT AS DT_ENT, ");
		sb.append("OP.TICKETNO AS CODE_TICKET, ");
		sb.append("PAYOEP.PAYMODENODE AS PAYMODE_NO, ");
		sb.append("PAYOEP.BANKNO AS BANK_NO, ");
		sb.append("PM.CODE AS CODE_PM, ");
		sb.append("PM.NAME AS NAME_PM, ");
		sb.append("OP.TIMES_OP AS TIMES_OP, ");
		sb.append("CASE WHEN ENT.FG_ST ='Y' THEN '1' ELSE '0' END AS FEE_STATUS, ");
		sb.append("APT.SD_STATUS AS CODE_APTSTATUS, ");
		sb.append("OP.SD_STATUS AS CODE_ENTSTATUS, ");
		sb.append("ENT.ADDR_PAT AS ADDRESS_ENT,  ");
		sb.append("ST.AMT_PAT AS AMT_PAT , ");
		sb.append("ST.AMT_TOTAL AS AMT_TOTAL , ");
		sb.append("NVL(PAT.MOB, PAT.TEL) AS MOBILE, ");
		sb.append("CHL.CODE AS CODE_CHLTP , ");
		sb.append("CHL.NAME AS NAME_CHLTP, ");
		sb.append("TICK.T_B AS T_B_TICKET, ");
		sb.append("TICK.T_E AS T_E_TICKET, ");
		sb.append("ENT.FG_CANC ");
		sb.append("FROM EN_ENT ENT  ");
		sb.append("INNER JOIN EN_ENT_OP OP     ON OP.ID_ENT = ENT.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PAT       ON PAT.ID_PAT = ENT.ID_PAT  ");
		sb.append("LEFT JOIN SC_APT_OP APTOP ON APTOP.ID_EN = ENT.ID_ENT ");
		sb.append("LEFT JOIN SC_APT APT ON APT.ID_APT = APTOP.ID_APT ");
		sb.append("LEFT JOIN PI_PAT_CA CA      ON CA.ID_PATCA = ENT.ID_PATCA ");
		sb.append("LEFT JOIN SC_SCH SCH  ON SCH.ID_SCH = OP.ID_SCH ");
		sb.append("LEFT JOIN SC_PL PL   ON SCH.ID_SCPL = PL.ID_SCPL  ");
		sb.append("LEFT JOIN BD_DEP DEP  ON DEP.ID_DEP = OP.ID_DEP_REG ");
		sb.append("LEFT JOIN SC_SRV SRV  ON SRV.ID_SCSRV = OP.ID_SCSRV ");
		sb.append("LEFT JOIN BD_DEP DEP  ON DEP.ID_DEP = OP.ID_DEP_REG ");
		sb.append("LEFT JOIN SC_SRV SRV  ON SRV.ID_SCSRV = OP.ID_SCSRV ");
		sb.append("LEFT JOIN SC_RES RES  ON RES.ID_SCRES = OP.ID_SCRES   ");
		sb.append("LEFT JOIN SC_CHL CHL  ON CHL.ID_SCCHL = APT.ID_SCCHL  ");
		sb.append("LEFT JOIN BD_DAYSLOT LOT  ON LOT.ID_DAYSLOT = OP.ID_DATESLOT ");
		sb.append("LEFT JOIN SC_APT_EXCHL EXCHL  ON EXCHL.ID_APT = APT.ID_APT ");
		sb.append("LEFT JOIN SC_TICK TICK        ON OP.ID_TICK = TICK.ID_TICK  ");
		sb.append("LEFT JOIN  ( SELECT STOEP.ID_ENT,STOEP.ID_PAYPATOEP,SUM(STOEP.AMT*STOEP.EU_DIRECT) AS AMT_TOTAL,SUM(STOEP.AMT_PAT*STOEP.EU_DIRECT) AS AMT_PAT FROM BL_ST_OEP STOEP    ");
		sb.append(" WHERE STOEP.EU_STTP = '31' AND STOEP.FG_CANC = 'N'  GROUP BY STOEP.ID_ENT,STOEP.ID_PAYPATOEP ) ST ON ST.ID_ENT = ENT.ID_ENT ");
		sb.append("LEFT JOIN BL_PAY_ITM_PAT_OEP PAYOEP ON PAYOEP.ID_PAYPATOEP =  ST.ID_PAYPATOEP   ");
		sb.append("LEFT JOIN BD_PRI_PM PM        ON PM.ID_PM = PAYOEP.ID_PM   ");
		sb.append("LEFT  JOIN BD_ENTP ENTP     ON ENTP.ID_ENTP = ENT.ID_ENTP  ");
		sb.append("LEFT JOIN BD_UDIDOC SRVTP ON SRVTP.ID_UDIDOC = SRV.ID_SRVTP ");
		sb.append("LEFT JOIN BD_DAYSLOT LOT  ON LOT.ID_DAYSLOT = OP.ID_DATESLOT  ");
		sb.append("where 1=1 AND SRV.SD_SCTP IN (?,?) ");
		sb.append(" AND ENT.FG_CANC = 'N' ");
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_OP);
		sqlParam.addParam(IScDictCodeConst.SD_SCTP_JZ);
		if(!StringUtil.isEmpty(patId)){
			sb.append("and pat.ID_PAT = ? ");
			sqlParam.addParam(patId);
		}
		sb.append("and ent.dt_insert >= ? ");
		sb.append("and ent.dt_insert <= ? ");
		sqlParam.addParam(param.getDt_begin().length()>10?param.getDt_begin():param.getDt_begin()+" 00:00:00");
		sqlParam.addParam(param.getDt_end().length()>10?param.getDt_end():param.getDt_end()+" 23:59:59");
		return sb.toString();
	}
}
