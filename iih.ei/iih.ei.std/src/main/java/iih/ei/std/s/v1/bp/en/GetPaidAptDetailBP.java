package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.ei.std.d.v1.en.paidaptdetail.d.PaidAptDetailDTO;
import iih.ei.std.d.v1.en.paidaptdetail.d.PaidAptDetailParamDTO;
import iih.ei.std.d.v1.en.paidaptdetail.d.PaidAptDetailResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.sch.sctick.d.EuUseState;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.util.AgeCalcUtil;
/***
 * 获取患者预约详细信息  BP
 * 
 * @author li.wm
 */
public class GetPaidAptDetailBP extends IIHServiceBaseBP<PaidAptDetailParamDTO, PaidAptDetailResultDTO>{	
	
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(PaidAptDetailParamDTO param) throws BizException {
		if (param.getId_apt() == null) {
			throw new BizException("预约ID不能为空！");
		}
		
	}

	@Override
	protected PaidAptDetailResultDTO process(PaidAptDetailParamDTO param) throws BizException {
		PaidAptDetailResultDTO resultDTO = new PaidAptDetailResultDTO();

		//获取预约数据
		SqlParam sqlParam = new SqlParam();
		
		//获取挂号数据
		String sql = getSql(param,sqlParam);
		
		//获取list返回值
		List<PaidAptDetailDTO> list = this.findDataList(sql, sqlParam, PaidAptDetailDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		//设置年龄
		this.setAge(list);
		resultDTO.setPaidaptdetail(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	/***
	 * @Description:获取患者预约信息sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private String getSql(PaidAptDetailParamDTO param,SqlParam sqlParam) throws BizException {
		StringBuilder builder =new StringBuilder();
		builder.append("SELECT DISTINCT APT.ID_APT AS ID_APT, ");
		builder.append("ENT.ID_ENT AS ID_ENT, ");	
		builder.append("ENTP.CODE AS CODE_ENTP ,  ");
		builder.append("ENTP.NAME AS NAME_ENTP ,  ");
		builder.append("CA.CODE  AS CODE_PATCA, ");
		builder.append("CA.NAME  AS NAME_PATCA, ");
		builder.append("PAT.CODE AS CODE_PAT, ");
		builder.append("PAT.NAME AS NAME_PAT, ");
		builder.append("OP.TIMES_OP AS TIMES_OP , ");
		builder.append("SEX.NAME AS SEX, ");
		builder.append("PAT.DT_BIRTH AS BIRTHDAY,");
		//年龄
		builder.append("SRVTP.CODE AS CODE_SRVTP, ");
		builder.append("SRVTP.NAME AS NAME_SRVTP, ");
		builder.append("RES.CODE AS CODE_RES, ");
		builder.append("RES.NAME AS NAME_RES, ");
		builder.append("APT.QUENO AS TICKE_NO, ");
		builder.append("DEP.CODE AS CODE_DEPT, ");
		builder.append("DEP.NAME AS NAME_DEPT, ");
		builder.append("ORG.CODE AS CODE_HOSPITAL, ");
		builder.append("ORG.NAME AS NAME_HOSPITAL, ");
		builder.append("APT.DT_B AS DT_B, ");
		builder.append("APT.DT_E AS DT_E, ");
		builder.append("WEEK.SUGEST_EXMINT AS SUGEST_TIME, ");
		builder.append("HP.CODE AS CODE_HP, ");
		builder.append("HP.NAME AS NAME_HP, ");
		builder.append("QUEBEN.DES AS  ADDRESS_ENT ,");
		builder.append("PAYOEP.AMT AS AMT_TOTAL  ,");
		builder.append("STOEP.AMT_PAT AS AMT_PAT  ,");
		builder.append("ACC.AMT_PREPAY AS BALANCE  ,");
		builder.append("PSNDOC.CODE AS CODE_APTOPERA  ,");
		builder.append("PSNDOC.NAME AS NAME_APTOPERA  ,");
		builder.append("CASE WHEN  TICK.EU_ADD  = ? THEN ? ELSE ? END AS FG_ADD,");
		builder.append("CHL.NAME AS APT_CHL,");
		builder.append("DLT.SD_DAYSLOTTP CODE_DAYSLOTTP ,");
		builder.append("DLT.NAME NAME_DAYSLOTTP ");
		
		builder.append("FROM SC_APT APT ");
		builder.append("INNER JOIN PI_PAT PAT ON APT.ID_PAT = PAT.ID_PAT ");
		builder.append("LEFT JOIN SC_APT_OP APTOP ON APTOP.ID_APT = APT.ID_APT ");
		builder.append("LEFT JOIN EN_ENT ENT ON ENT.ID_ENT = APTOP.ID_EN ");
		builder.append("LEFT JOIN BD_ENTP ENTP ON ENTP.ID_ENTP = ENT.ID_ENTP ");
		builder.append("INNER JOIN PI_PAT_CA CA ON CA.ID_PATCA = PAT.ID_PATICATE ");
		builder.append("INNER JOIN BD_DAYSLOT DLT ON APT.ID_DATESLOT = DLT.ID_DAYSLOT ");
		builder.append("INNER JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append(" LEFT JOIN BD_UDIDOC  SRVTP ON SRVTP.ID_UDIDOC = SRV.ID_SRVTP ");
		builder.append("INNER JOIN SC_RES RES ON APT.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON RES.ID_DEP = DEP.ID_DEP ");
		builder.append("INNER JOIN SC_CHL CHL ON APT.ID_SCCHL = CHL.ID_SCCHL ");
		builder.append("INNER JOIN SC_SCH SCSCH ON APT.ID_SCH = SCSCH.ID_SCH ");
		builder.append("INNER JOIN SC_PL SCPL ON SCPL.ID_SCPL = SCSCH.ID_SCPL ");
		builder.append("INNER JOIN BD_QUE_BEN QUEBEN ON QUEBEN.ID_QUEBEN = SCPL.ID_QUEBEN ");
		builder.append("LEFT JOIN EN_ENT_OP  OP ON OP.ID_ENT = ENT.ID_ENT ");
		builder.append("LEFT  JOIN SC_APT_EXCHL EXCHL ON EXCHL.ID_APT = APT.ID_APT ");
		builder.append("LEFT JOIN BL_ST_OEP STOEP ON STOEP.ID_ENT = ENT.ID_ENT AND STOEP.EU_STTP = ? ");
		builder.append("LEFT JOIN BL_PAY_ITM_PAT_OEP PAYOEP ON PAYOEP.ID_PAYPATOEP =  STOEP.ID_PAYPATOEP ");
		builder.append("LEFT JOIN BD_PRI_PM PM ON PM.ID_PM = PAYOEP.ID_PM ");
		builder.append("LEFT JOIN BD_PSNDOC PSNDOC ON PSNDOC.ID_PSNDOC = APT.ID_EMP_APPT ");
		builder.append("LEFT JOIN BD_HP HP ON ENT.ID_HP = HP.ID_HP ");
		builder.append("LEFT JOIN SC_TICK TICK  ON TICK.ID_SCH = APT.ID_TICK ");
		builder.append("LEFT JOIN EN_ENT_ACC ACC  ON ACC.ID_ENT = ENT.ID_ENT ");
		builder.append("LEFT JOIN SC_PL_WEEK  WEEK  ON WEEK.ID_SCPL = SCPL.ID_SCPL ");
		builder.append("LEFT JOIN BD_ORG  ORG  ON ORG.ID_ORG = APT.ID_ORG ");
		builder.append("LEFT JOIN BD_UDIDOC   SEX  ON SEX.ID_UDIDOC  = PAT.ID_SEX ");
		builder.append("WHERE   APT.ID_APT  = ?   ");
		sqlParam.addParam(EuUseState.SY);
		sqlParam.addParam(FBoolean.TRUE);
		sqlParam.addParam(FBoolean.FALSE);
		sqlParam.addParam(StTypeEnum.ST_OEP_REG);
		sqlParam.addParam(param.getId_apt());
		

		return builder.toString();
	}
	
	/**
	 * 设置 年龄 li.wm
	 * 
	 * @param patOpAptListDTOs
	 */
	private void setAge(List<PaidAptDetailDTO> patOpAptListDTOs) {
		for (PaidAptDetailDTO paidAptDetailDTO : patOpAptListDTOs) {
			paidAptDetailDTO.setAge(AgeCalcUtil.getAge(new FDate(paidAptDetailDTO.getBirthday())));
		}
	}
}
