package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.BrokenAptDTO;
import iih.en.pv.s.bp.GetPatIdForAp;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取爽约记录
 * 
 * @author WJY
 *
 */
public class GetBrokenAptListBP {
	/**
	 * 获取患者爽约记录
	 * 
	 * @param patCode 患者编码
	 * @return
	 * @throws BizException
	 */
	public BrokenAptDTO[] exec(String patCode) throws BizException {
		// 记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetBrokenAptListBP参数为:patCode:" + patCode);
		// 1.同步患者信息
		GetPatIdForAp patap = new GetPatIdForAp();
		String patId = patap.exec(patCode);
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("select * from (");
		// 预约爽约
		sb.append("SELECT APT.ID_APT AS ID_APT,");
		sb.append("'' id_ent,");
		sb.append("PAT.CODE AS PATIENT_ID,");
		sb.append("PAT.NAME AS NAME_PAT,");
		sb.append("PAT.CODE AS PATCODE,");
		sb.append("PAT.NAME AS PATNAME,");
		sb.append("bbr.dt_act dt_entry,");
		sb.append("SEX.NAME AS SEX,");
		sb.append("SRV.CODE AS SCSRV_CODE,");
		sb.append("SRV.NAME AS SCSRV_NAME,");
		sb.append("bbr.sd_bbrtp,");// 不良行为类型 add by zhengcm 2018-04-17
		sb.append("NVL(PAT.MOB, PAT.TEL) AS MOBILE ");
		sb.append("FROM PI_PAT_BBR BBR ");
		sb.append("INNER JOIN PI_PAT PAT ON BBR.ID_PAT = PAT.ID_PAT ");
		sb.append("INNER JOIN SC_APT APT ON BBR.ID_KEY = APT.ID_APT ");
		sb.append("LEFT JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV ");
		sb.append("LEFT JOIN BD_UDIDOC SEX ON PAT.ID_SEX = SEX.ID_UDIDOC ");
		sb.append("WHERE PAT.ID_PAT  = ? ");
		sb.append("AND BBR.FG_ACTIVE = ? ");
		sb.append("AND BBR.SD_BBRTP = ? ");

		sb.append("union ");

		// 就诊爽约,by zhengcm 2018-04-17
		sb.append("select ");
		sb.append("'' ID_APT,");
		sb.append("ent.id_ent,");
		sb.append("PAT.CODE PATIENT_ID,");
		sb.append("PAT.NAME NAME_PAT,");
		sb.append("PAT.CODE PATCODE,");
		sb.append("PAT.NAME PATNAME,");
		sb.append("bbr.dt_act dt_entry,");
		sb.append("SEX.NAME SEX,");
		sb.append("SRV.CODE SCSRV_CODE,");
		sb.append("SRV.NAME SCSRV_NAME,");
		sb.append("bbr.sd_bbrtp,");
		sb.append("NVL(PAT.MOB, PAT.TEL) MOBILE ");
		sb.append("from ");
		sb.append("PI_PAT_BBR BBR ");
		sb.append("INNER JOIN en_ent ent ON BBR.ID_KEY = ent.id_ent ");
		sb.append("INNER JOIN PI_PAT PAT ON BBR.ID_PAT = PAT.ID_PAT ");
		sb.append("inner join en_ent_op op on op.id_ent = ent.id_ent ");
		sb.append("LEFT outer JOIN SC_SRV SRV ON op.ID_SCSRV = SRV.ID_SCSRV ");
		sb.append("LEFT outer JOIN BD_UDIDOC SEX ON PAT.ID_SEX = SEX.ID_UDIDOC ");
		sb.append("where ");
		sb.append("PAT.ID_PAT = ? ");
		sb.append("AND BBR.FG_ACTIVE = ? ");
		sb.append("AND BBR.SD_BBRTP = ? ");
		sb.append(") order by dt_entry ");
		param.addParam(patId);
		param.addParam(FBoolean.TRUE);
		param.addParam(IPiDictCodeConst.SD_BBRTP_OPORDERBREAK);
		param.addParam(patId);
		param.addParam(FBoolean.TRUE);
		param.addParam(IPiDictCodeConst.SD_BBRTP_NOTREGISTEAFTERREGISTRATION);
		@SuppressWarnings("unchecked")
		List<BrokenAptDTO> brokenList = (List<BrokenAptDTO>) new DAFacade().execQuery(sb.toString(), param,
				new BeanListHandler(BrokenAptDTO.class));
		if (EnValidator.isEmpty(brokenList)) {
			return null;
		}
		return brokenList.toArray(new BrokenAptDTO[0]);
	}
}
