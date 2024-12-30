package iih.sc.apt.s.listener.bp;

import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.apt.dto.d.OpApt4SmsDTO;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 得到OpApt4SmsDTO
 * 
 * @author liubin
 *
 */
public class WrapObj2SmsDTOBP {
	/**
	 * 把门诊预约事件源组装为门诊预约短信通知DTO
	 * 
	 * @param es 门诊预约事件源
	 * @return
	 * @throws BizException
	 */
	public OpApt4SmsDTO getSmsByEs(OpApt4EsDTO es) throws BizException {
		if (es == null || ScValidator.isEmptyIgnoreBlank(es.getId_apt()))
			return null;
		OpApt4SmsDTO sms = this.setAptInfo(es.getId_apt());
		if (sms == null)
			return null;
		sms.setType_msg(es.getType_msg());
		this.setQueBenInfo(sms, es.getId_apt());
		this.setPayInfo(sms, es.getId_apt());
		return sms;
	}

	/**
	 * 设置预约信息
	 * 
	 * @param aptId
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OpApt4SmsDTO setAptInfo(String aptId) throws BizException {

		// 获取预约成功是否需要短信通知渠道，fanlq-2017-09-11
		String noAptChs = null;
		String chltp = ScParamUtils.getNoteExclChlTp(ScContextUtils.getOrgId());
		if (!ScValidator.isEmptyIgnoreBlank(chltp)) {
			String[] noAptChId = chltp.split(",");
			noAptChs = ScSqlUtils.arrayToStr(noAptChId);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT SC_APT.ID_APT AS ID_APT,");
		sb.append("SC_APT.CODE AS CODE_APT,");
		sb.append("SC_APT.ID_PAT AS ID_APT,");
		sb.append("SC_PL.NAME AS NAME_PL,");
		sb.append("PI_PAT.CODE AS CODE_PAT,");
		sb.append("PI_PAT.NAME AS NAME_PAT,");
		sb.append("PI_PAT.MOB AS MOBILE,");
		sb.append("PI_PAT.ID_CODE AS ID_CODE,");
		sb.append("SC_SCH.D_SCH AS D_APT,");
		sb.append("BD_DEP.NAME AS NAME_DEP,");
		sb.append("SC_RES.NAME AS NAME_DOC,");
		sb.append("SC_SRV.NAME AS NAME_SRV,");
		sb.append("SUBSTR(TRIM(SC_APT.DT_B), 12, 5)||'-'||SUBSTR(TRIM(SC_APT.DT_E), 12, 5) AS DT_EXPECT ");
		sb.append("FROM SC_APT SC_APT ");
		sb.append("INNER JOIN SC_SCH SC_SCH ON SC_APT.ID_SCH = SC_SCH.ID_SCH ");
		sb.append("INNER JOIN PI_PAT PI_PAT ON SC_APT.ID_PAT = PI_PAT.ID_PAT ");
		sb.append("INNER JOIN SC_PL SC_PL ON SC_SCH.ID_SCPL = SC_PL.ID_SCPL ");
		sb.append("LEFT JOIN BD_DEP BD_DEP ON SC_PL.ID_DEP = BD_DEP.ID_DEP ");
		sb.append("LEFT JOIN SC_RES SC_RES ON SC_APT.ID_SCRES = SC_RES.ID_SCRES ");
		sb.append("LEFT JOIN SC_SRV SC_SRV ON SC_APT.ID_SCSRV = SC_SRV.ID_SCSRV ");
		sb.append("LEFT JOIN SC_CHL CHL ON SC_APT.ID_SCCHL = CHL.ID_SCCHL ");
		sb.append("WHERE SC_APT.ID_APT = ? ");
		if (ScValidator.isNotEmptyIgnoreBlank(noAptChs)) {
			sb.append("and CHL.ID_SCCHLTP not in (" + noAptChs + ") ");
		}
		SqlParam param = new SqlParam();
		param.addParam(aptId);
		List<OpApt4SmsDTO> list = (List<OpApt4SmsDTO>) new DAFacade().execQuery(sb.toString(), param,
				new BeanListHandler(OpApt4SmsDTO.class));
		if (!ListUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 设置分诊台信息
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setQueBenInfo(OpApt4SmsDTO sms, String aptId) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT BD_QUE_BEN.DES ");
		sb.append("FROM SC_APT SC_APT ");
		sb.append("INNER JOIN SC_SCH SC_SCH ON SC_APT.ID_SCH = SC_SCH.ID_SCH ");
		sb.append("INNER JOIN SC_PL SC_PL ON SC_SCH.ID_SCPL = SC_PL.ID_SCPL ");
		//sb.append("INNER JOIN BD_QUE BD_QUE ON SC_PL.ID_DEP = BD_QUE.ID_DEP AND SC_PL.ID_SCRES = BD_QUE.ID_SCRES ");
		sb.append("INNER JOIN BD_QUE_BEN BD_QUE_BEN ON SC_PL.ID_QUEBEN = BD_QUE_BEN.ID_QUEBEN ");
		sb.append("WHERE SC_APT.ID_APT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(aptId);
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(), param, new ColumnListHandler());
		if (!ListUtil.isEmpty(list)) {
			sms.setAddress_triage(list.get(0));
		}
	}

	/**
	 * 设置支付价格信息
	 * 
	 * @param aptId
	 * @throws BizException
	 */
	private void setPayInfo(OpApt4SmsDTO sms, String aptId) throws BizException {
		AptEP ep = new AptEP();
		ScAptDO apt = ep.getById(aptId);
		if (apt == null || ScValidator.isEmptyIgnoreBlank(apt.getId_scsrv()))
			return;
		RegResDTO res = new RegResDTO();
		res.setId_scsrv(apt.getId_scsrv());
		IScSchOutQryService serv = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO[] ress = serv.loadResPri(new RegResDTO[] { res });
		if (!ScValidator.isNullOrEmpty(ress))
			sms.setAmt(ress[0].getAmt());
	}
}
