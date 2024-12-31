package iih.ei.std.s.v1.bp.bl;

import java.util.List;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.output.inc.sub.WsResultGetPatIncInfo;
import iih.ei.std.d.v1.bl.oppatincinfodto.d.IncInfo;
import iih.ei.std.d.v1.bl.oppatincinfodto.d.OpPatIncInfoParamDTO;
import iih.ei.std.d.v1.bl.oppatincinfodto.d.OpPatIncInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 门诊自助发票查询（查询一个患者的发票信息）
 * 
 * @author shaokx
 * @date: 2019.09.30
 */
public class GetOpPatIncInfoBP extends IIHServiceBaseBP<OpPatIncInfoParamDTO, OpPatIncInfoResultDTO>{

	@Override
	protected void checkParam(OpPatIncInfoParamDTO param) throws BizException {
		if(param == null){
			throw new BizException("入参为空");
		}
		
		if (StringUtil.isEmpty(param.getCode_hospital())) {
			throw new BizException("入参医院编码为空");
		}

		if (StringUtil.isEmpty(param.getCode_enttp())) {
			throw new BizException("入参就诊类型为空");
		}
		
		if(!IBlWsConst.ENTP_OP.equals(param.getCode_enttp())){
			throw new BizException("就诊类型值不正确");
		}

		if (StringUtil.isEmpty(param.getCode_pat()) && StringUtil.isEmpty(param.getCode_card())
				&& StringUtil.isEmpty(param.getCode_idnum())) {
			throw new BizException("入参关键信息全为空:患者编码,就诊卡号,身份证号");
		}
		
		if(StringUtil.isEmpty(param.getDt_start())){
			throw new BizException("入参开始时间为空");
		}
		
		if(StringUtil.isEmpty(param.getDt_end())){
			throw new BizException("入参结束时间为空");
		}
		
	}

	@Override
	protected OpPatIncInfoResultDTO process(OpPatIncInfoParamDTO param) throws BizException {

		// 患者主键
		String patId = this.findPat(param);

		// 获得患者未打印的结算id
		List<IncInfo> rltInfo = GetPatUnprintSt(patId, param);
		
		OpPatIncInfoResultDTO rlt1 = new OpPatIncInfoResultDTO();
		FArrayList arr = new FArrayList();
		arr.addAll(rltInfo);
		rlt1.setIncinfo(arr);

		return rlt1;
	}
	
	/**
	 * 获得患者未打印的结算id
	 * 
	 * @param patId
	 * @throws BizException
	 */
	private List<IncInfo> GetPatUnprintSt(String patId, OpPatIncInfoParamDTO paramInfo) throws BizException {
		WsResultGetPatIncInfo rltInfo = new WsResultGetPatIncInfo();

		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" distinct stoep.id_stoep code_stoep, ");
		sql.append(" pat.name name_pat, ");
		sql.append(" pat.sd_sex sex_pat, ");
		sql.append(" stoep.dt_st, ");
		sql.append(" stoep.amt*stoep.eu_direct amt_stoep, ");//总费用 单位元 下面得改为分
		sql.append(" decode(stoep.eu_sttp,'31','01','30','02') eu_sttp ");
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
		if (!StringUtil.isEmpty(paramInfo.getDt_start())) {
			sql.append(" and stoep.dt_st >= ? ");
		}
		if (!StringUtil.isEmpty(paramInfo.getDt_end())) {
			sql.append(" and stoep.dt_st <= ? ");
		}

		SqlParam param = new SqlParam();
		param.addParam(patId);
		if (!StringUtil.isEmpty(paramInfo.getDt_start())) {
			param.addParam(paramInfo.getDt_start());
		}
		if (!StringUtil.isEmpty(paramInfo.getDt_end())) {
			param.addParam(paramInfo.getDt_end());
		}

		@SuppressWarnings("unchecked")
		List<IncInfo> stList = (List<IncInfo>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(IncInfo.class));

		if (ListUtil.isEmpty(stList)) {
			throw new BizException("未查询到该患者的未打印结算数据");
		}

		//把本次结算总费用由元改为分
		for (IncInfo itm : stList) {
			itm.setAmt_stoep(BlAmtConverUtil.toXmlString(new FDouble(itm.getAmt_stoep())));
		}
		
		return stList;
	}

	/**
	 * 查询患者id_pat
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(OpPatIncInfoParamDTO param) throws BizException {
		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(param.getCode_pat());
		condDto.setId_code(param.getCode_idnum());
		condDto.setCard_code(param.getCode_card());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("门诊自助发票查询:未查询到患者信息");
		}

		return patiAggs[0].getParentDO().getId_pat();
	}


}
