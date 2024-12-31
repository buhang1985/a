package iih.bl.itf.std.bp.opinc;

import java.util.List;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.inc.WsParamGetPatInc;
import iih.bl.itf.std.bean.input.inc.sub.WsParamGetPatIncInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.inc.WsResultGetPatInc;
import iih.bl.itf.std.bean.output.inc.sub.WsResultGetPatIncInfo;
import iih.bl.itf.std.bean.output.inc.sub.WsResultGetPatStInfo;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamPatIncInfoValidator;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊自助发票查询
 * 
 * @author shaokx 2019/2/25
 *
 */
public class GetPatIncInfoBP extends BlItfBaseBP<WsParamGetPatInc,WsResultGetPatInc> {

	@Override
	protected String getBusiness() {

		return "门诊自助发票查询";
	}

	@Override
	protected void checkParam(WsParamGetPatInc param) throws BizException {
		WsParamPatIncInfoValidator validator = new WsParamPatIncInfoValidator();
		validator.validate(param);

		WsParamGetPatIncInfo prepayInfo = param.getPrepay();
		PsnDocDO psndocDO = super.getPsnInfo(prepayInfo.getOperaCode());
		if (psndocDO == null) {
			throw new BizException("门诊自助发票查询:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());
	}

	@Override
	protected WsResultGetPatInc doWork(WsParamGetPatInc param) throws BizException {
		WsParamGetPatIncInfo prepayInfo = param.getPrepay();
		// 患者主键
		String patId = this.findPat(prepayInfo);

		// 获得患者未打印的结算id
		WsResultGetPatIncInfo rltInfo = GetPatUnprintSt(patId, prepayInfo);

		WsResultGetPatInc rlt = new WsResultGetPatInc();
		WsResultMsg rltMsg = new WsResultMsg();// 0成功，1失败

		rlt.setRltInfo(rltInfo);
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		rltMsg.setMessage("成功");
		rlt.setRltMsg(rltMsg);
		return rlt;
	}

	/**
	 * 获得患者未打印的结算id
	 * 
	 * @param patId
	 * @throws BizException
	 */
	private WsResultGetPatIncInfo GetPatUnprintSt(String patId, WsParamGetPatIncInfo prepayInfo) throws BizException {
		WsResultGetPatIncInfo rltInfo = new WsResultGetPatIncInfo();

		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" distinct stoep.id_stoep stNO, ");
		sql.append(" pat.name patName, ");
		sql.append(" pat.sd_sex patSex, ");
		sql.append(" stoep.dt_st stTime, ");
		sql.append(" stoep.amt*stoep.eu_direct entAmout, ");//总费用 单位元 下面得改为分
		sql.append(" stoep.dt_st stTime, ");
		sql.append(" decode(stoep.eu_sttp,'31','01','30','02') blType ");
		sql.append(" from bl_st_oep stoep ");
		sql.append(" left join bl_inc_oep incoep ");
		sql.append(" on stoep.id_stoep = incoep.id_stoep ");
		sql.append(" left join pi_pat pat ");
		sql.append(" on stoep.id_pat = pat.id_pat ");
		sql.append(" where 1=1 ");
		sql.append(" and stoep.eu_direct = 1 ");
		sql.append(" and stoep.fg_canc = 'N' ");
		sql.append(" and stoep.id_paypatoep <> '~' ");
		sql.append(" and incoep.fg_canc = 'N' ");
		sql.append(" and incoep.fg_print = 'N' ");
		sql.append(" and stoep.id_pat = ? ");
		if (!StringUtil.isEmpty(prepayInfo.getStartDate())) {
			sql.append(" and stoep.dt_st >= ? ");
		}
		if (!StringUtil.isEmpty(prepayInfo.getEndDate())) {
			sql.append(" and stoep.dt_st <= ? ");
		}

		SqlParam param = new SqlParam();
		param.addParam(patId);
		if (!StringUtil.isEmpty(prepayInfo.getStartDate())) {
			param.addParam(prepayInfo.getStartDate());
		}
		if (!StringUtil.isEmpty(prepayInfo.getEndDate())) {
			param.addParam(prepayInfo.getEndDate());
		}

		@SuppressWarnings("unchecked")
		List<WsResultGetPatStInfo> stList = (List<WsResultGetPatStInfo>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(WsResultGetPatStInfo.class));

		if (ListUtil.isEmpty(stList)) {
			throw new BizException("未查询到该患者的未打印结算数据");
		}

		//把本次结算总费用由元改为分
		for (WsResultGetPatStInfo itm : stList) {
			itm.setEntAmout(BlAmtConverUtil.toXmlString(new FDouble(itm.getEntAmout())));
		}
		
		rltInfo.setStinfo(stList);
		return rltInfo;
	}

	/**
	 * 查询患者id_pat
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(WsParamGetPatIncInfo paramInfo) throws BizException {
		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(paramInfo.getPatCode());
		condDto.setId_code(paramInfo.getSdCode());
		condDto.setCard_code(paramInfo.getCardCode());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("门诊自助发票查询:未查询到患者信息");
		}

		return patiAggs[0].getParentDO().getId_pat();
	}

}
