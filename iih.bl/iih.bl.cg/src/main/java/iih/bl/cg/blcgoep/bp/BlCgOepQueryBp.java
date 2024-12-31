package iih.bl.cg.blcgoep.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ctc.wstx.util.StringUtil;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;
import iih.bl.cg.bp.GetInvoiceType;
import iih.bl.cg.dto.d.BlCgAmtDTO;
import iih.bl.cg.dto.d.BlCgPriceAndAmtDTO;
import iih.bl.cg.service.d.BlCgIpAmtAndUncgRationDTO;
import iih.bl.cg.service.s.bp.BLCiOrderToBlCgServiceImplBp;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.params.BlParams;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class BlCgOepQueryBp {
	/**
	 * 更加患者ID和就诊ID，获得余额，消费额度，服务项目分类占全体费用比例
	 * 
	 * @param id_pat
	 *            病人ID
	 * @param id_ent
	 *            就诊ID
	 * @param Sd_srvtp
	 *            服务项目分类，如果查药占比，则传“01”
	 * @return 数组，依次为：余额，消费额度，服务项目分类占全体费用比例
	 * @throws BizException
	 */
	public BlCgIpAmtAndUncgRationDTO GetBlcgIpAmtVSsrvcaRation(String id_pat, String id_ent, String Sd_srvtp) throws BizException {
		String ration = "";
		BlCgIpAmtAndUncgRationDTO blCgIpAmtAndUncgRationDTO = new BlCgIpAmtAndUncgRationDTO();
		GetInvoiceType getInvoiceType = new GetInvoiceType();

		FDouble sumAmt = new FDouble(0);
		FDouble drugAmt = new FDouble(0);
		SqlParam sqlp = new SqlParam();	
		sqlp.addParam(id_ent);
		sqlp.addParam(id_pat);
		List<BlCgIpDO> blCgIpDOlist = (List<BlCgIpDO>) new DAFacade().execQuery(getInvoiceType.GetInvocieTypeFromBlCgIpByIdentSql(), sqlp, new BeanListHandler(BlCgIpDO.class));
		if (blCgIpDOlist == null || blCgIpDOlist.size() == 0) {		
			blCgIpAmtAndUncgRationDTO.setAmt_uncg(new FDouble(0));
			blCgIpAmtAndUncgRationDTO.setRation("0");		
		}
		for (BlCgIpDO blCgIpDO : blCgIpDOlist) {
			if(FBoolean.TRUE.equals(blCgIpDO.getFg_refund())){
				continue;//过滤退费
			}
			sumAmt = sumAmt.add(blCgIpDO.getAmt());
			// 药品
			if (blCgIpDO.getSd_srvtp() != null && blCgIpDO.getSd_srvtp().indexOf(Sd_srvtp) == 0) {
				drugAmt = drugAmt.add(blCgIpDO.getAmt());
			}
		}
		
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);		
		BalanceDTO balanceDTO = null;	
		// 获取组织参数BLSTIP0005，判断是否查询母婴就诊关系  By  liwq 2017年9月22日13:48:53	
		FBoolean isMerge = BlParams.BLSTIP0026();
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO entNewBorn = enService.getNewbornDO(id_ent);
		if (FBoolean.TRUE.equals(isMerge) && entNewBorn != null) {
			balanceDTO = inpPatAccImpls.getBalanceDTO(entNewBorn.getId_ent_mom());			
		} else {
			balanceDTO = inpPatAccImpls.getBalanceDTO(id_ent);
		}
		
		FDouble xx = new FDouble(0);
		if (balanceDTO != null) {
			
			blCgIpAmtAndUncgRationDTO.setAvailable(balanceDTO.getAvailable().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blCgIpAmtAndUncgRationDTO.setAmt_bal(balanceDTO.getAmt_bal().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blCgIpAmtAndUncgRationDTO.setAmt_uncg(sumAmt.setScale(-2, BigDecimal.ROUND_HALF_UP));
		}
		if (sumAmt.compareTo(new FDouble(0)) > 0) {
			ration = String.valueOf((drugAmt.div(sumAmt)).multiply(new FDouble(100)).setScale(-2, BigDecimal.ROUND_HALF_UP)) + " %";
		} else {
			ration = "0";
		}
		blCgIpAmtAndUncgRationDTO.setRation(ration);
		return blCgIpAmtAndUncgRationDTO;
	}

	/**
	 * 获得该处方下所有明细的费用信息
	 * 
	 * @param id_pat
	 *            患者费用
	 * @param id_presArr处方数组
	 * @return
	 * @throws BizException
	 */
	public BlCgPriceAndAmtDTO[] getBlCgPriceAndAmtDTOFromIdPres(String id_pat, String[] id_presArr) throws BizException {
		StringBuffer sqlb = new StringBuffer();
		BlCgPriceAndAmtDTO blCgPriceAndAmtDTO = new BlCgPriceAndAmtDTO();
		List<BlCgPriceAndAmtDTO> blCgPriceAndAmtDTOLst = null;
		String id_press = "";
		for (String id_pres : id_presArr) {
			id_press = id_press + ",'" + id_pres + "'";
		}
		if (id_press.length() > 0) {
			id_press = id_press.substring(1);
		} else {
			return null;
		}

		sqlb.append("select a.id_orsrv,a.id_pres,a.quan,a.price,a.amt,a.amt_std,a.amt_hp,a.amt_pat,a.amt_ratio,c.incno,");
		sqlb.append(" b.id_emp_st id_emp_cg,p.code code_emp_cg,p.name name_emp_cg ");
		sqlb.append(" from bl_cg_itm_oep a left join bl_inc_oep c on a.id_stoep=c.id_stoep ");
		sqlb.append(" left join bl_st_oep b on a.id_stoep = b.id_stoep ");
		sqlb.append(" left join bd_psndoc p on b.id_emp_st = p.id_psndoc ");

		sqlb.append(" where a.id_pat='" + id_pat + "' and a.id_pres in (" + id_press + ")");
		blCgPriceAndAmtDTOLst = (List<BlCgPriceAndAmtDTO>) new DAFacade().execQuery(sqlb.toString(), new BeanListHandler(BlCgPriceAndAmtDTO.class));

		if (blCgPriceAndAmtDTOLst == null || blCgPriceAndAmtDTOLst.size() == 0) {
			// throw new BizException("没有找到该医嘱下的费用明细。\r\n查询医嘱号："+id_or);
			return null;
		}

		return blCgPriceAndAmtDTOLst.toArray(new BlCgPriceAndAmtDTO[0]);
	}

	/**
	 * 根据就诊和就诊类型，查询该就诊下发生的费用
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @param code_entp
	 *            就诊类型
	 * @return
	 * @throws BizException
	 */
	public BlCgAmtDTO GetBlCgAmtByIdEnt(String id_ent, String code_entp) throws BizException {
		StringBuffer sqlb = new StringBuffer();
		BlCgAmtDTO blCgAmtDTO = new BlCgAmtDTO();
		List<BlCgAmtDTO> blCgAmtDTOList = null;
		if ((IBdFcDictCodeConst.SD_CODE_ENTP_OP).equals(code_entp) || (IBdFcDictCodeConst.SD_CODE_ENTP_PE).equals(code_entp))// 门诊，体检
		{
			sqlb.append(" select sum(amt_ratio) Amtsum,sum(amt_std) Amt_stdsum from bl_cg_itm_oep where id_ent=? and code_enttp=? ");
			SqlParam sqlp = new SqlParam();
			sqlp.addParam(id_ent);
			sqlp.addParam(code_entp);
			blCgAmtDTOList = (List<BlCgAmtDTO>) new DAFacade().execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlCgAmtDTO.class));

		} else if ((IBdFcDictCodeConst.SD_CODE_ENTP_ET).equals(code_entp)) // 急诊
		{
			sqlb.append(" select sum(amt_ratio) Amtsum,sum(amt_std) Amt_stdsum from  ");
			sqlb.append(" ( ");
			sqlb.append(" select sum(amt_ratio) amt,sum(amt_std) amt_std from bl_cg_itm_oep where id_ent=? and code_enttp=? ");
			sqlb.append(" union all ");
			sqlb.append(" select sum(amt_ratio) amt,sum(amt_std) amt_std from bl_cg_itm_oep where id_ent=? and code_enttp=? ");
			sqlb.append(" ) ");
			SqlParam sqlp = new SqlParam();
			sqlp.addParam(id_ent);
			sqlp.addParam(code_entp);
			sqlp.addParam(id_ent);
			sqlp.addParam(code_entp);
			blCgAmtDTOList = (List<BlCgAmtDTO>) new DAFacade().execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlCgAmtDTO.class));

		} else if ((IBdFcDictCodeConst.SD_CODE_ENTP_IP).equals(code_entp))// 住院
		{
			sqlb.append(" select sum(amt_ratio) Amtsum,sum(amt_std) Amt_stdsum from bl_cg_ip where id_ent=? and code_enttp=? ");
			SqlParam sqlp = new SqlParam();
			sqlp.addParam(id_ent);
			sqlp.addParam(code_entp);
			blCgAmtDTOList = (List<BlCgAmtDTO>) new DAFacade().execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlCgAmtDTO.class));
		}

		if (blCgAmtDTOList == null || blCgAmtDTOList.size() == 0) {
			// throw new BizException("没有找到该医嘱下的费用明细。\r\n查询医嘱号："+id_or);
			return null;
		}

		return blCgAmtDTOList.toArray(new BlCgAmtDTO[0])[0];
	}

	/**
	 * 根据医嘱号查询该医嘱下的门诊费用明细(没有汇总）
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public BlCgItmOepDO[] findBlCgOepInfoByIdor(String id_or) throws BizException {
		StringBuffer sqlb = new StringBuffer();
		sqlb.append(" select distinct a.*,b.eu_direct ");
		sqlb.append("   from bl_cg_itm_oep a ");
		sqlb.append("  inner join bl_cg_oep b ");
		sqlb.append("     on a.id_cgoep = b.id_cgoep ");
		sqlb.append("    and a.id_or = ? ");
		sqlb.append(" order by a.dt_st ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_or);
		List<BlCgItmOepDO> blCgItmOepDOList = (List<BlCgItmOepDO>) new DAFacade().execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlCgItmOepDO.class));
		if (blCgItmOepDOList == null || blCgItmOepDOList.size() == 0) {
			// throw new BizException("没有找到该医嘱下的费用明细。\r\n查询医嘱号："+id_or);
			return null;
		}
		return blCgItmOepDOList.toArray(new BlCgItmOepDO[0]);
	}

	/**
	 * 根据医嘱号查询该医嘱下的门诊费用明细(按汇总显示）
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public BlCgItmOepDO[] findBlCgOepInfoByIdor_aggregate(String id_or) throws BizException {
		StringBuffer sqlb = new StringBuffer();
		sqlb.append(" select a.id_srv,");
		sqlb.append("        a.name_srv,");
		sqlb.append("        a.price,");
		sqlb.append("         sum(a.quan * b.eu_direct) quan,");
		sqlb.append("         sum(a.amt_ratio * b.eu_direct) amt_ratio,");
		sqlb.append("        sum(a.amt_std * b.eu_direct) amt_std,");
		sqlb.append("        a.fg_st,");
		sqlb.append("        a.ratio_pripat");
		sqlb.append("   from bl_cg_itm_oep a");
		sqlb.append("   inner join bl_cg_oep b");
		sqlb.append("      on a.id_cgoep = b.id_cgoep");
		sqlb.append("     and a.id_or = ?");
		sqlb.append("   group by a.id_srv, a.name_srv, a.price, a.fg_st, a.ratio_pripat");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_or);
		List<BlCgItmOepDO> blCgItmOepDOList = (List<BlCgItmOepDO>) new DAFacade().execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlCgItmOepDO.class));
		if (blCgItmOepDOList == null || blCgItmOepDOList.size() == 0) {
			// throw new BizException("没有找到该医嘱下的费用明细。\r\n查询医嘱号："+id_or);
			return null;
		}
		return blCgItmOepDOList.toArray(new BlCgItmOepDO[0]);
	}

	/**
	 * 根据就诊号查询该就诊下的门诊费用明细
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public BlCgItmOepDO[] findBlCgOepInfoByIdent(String id_ent) throws BizException {
		StringBuffer sqlb = new StringBuffer();
		sqlb.append(" select distinct a.*,b.eu_direct ");
		sqlb.append("   from bl_cg_itm_oep a ");
		sqlb.append("  inner join bl_cg_oep b ");
		sqlb.append("     on a.id_cgoep = b.id_cgoep ");
		sqlb.append("    and a.id_ent = ? ");
		sqlb.append(" order by a.dt_st ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_ent);
		List<BlCgItmOepDO> blCgItmOepDOList = (List<BlCgItmOepDO>) new DAFacade().execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlCgItmOepDO.class));
		if (blCgItmOepDOList == null || blCgItmOepDOList.size() == 0) {
			// throw new BizException("没有找到该就诊下的费用明细。\r\n查询就诊ID："+id_ent);
			return null;
		}
		return blCgItmOepDOList.toArray(new BlCgItmOepDO[0]);
	}

	/**
	 * 挂号：根据记账主键显示对应的发票号
	 * 
	 * @param id_cgoep
	 *            记账主键
	 * @return 记账对应的发票号
	 * @throws BizException
	 */
	public String GetInvoicenoById_CgOep(String id_cgoep) throws BizException {

		ColumnHandler handler = new ColumnHandler();
		StringBuffer sqlb = new StringBuffer();
		sqlb.append(" select distinct d.incno ");
		sqlb.append("   from bl_cg_oep a, bl_cg_itm_oep b, bl_st_oep c, bl_inc_oep d ");
		sqlb.append("  where a.id_cgoep = b.id_cgoep ");
		sqlb.append("    and b.id_stoep = c.id_stoep ");
		sqlb.append("    and c.id_stoep = d.id_stoep ");
		sqlb.append("    and a.id_cgoep = ? ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_cgoep);

		DAFacade cade = new DAFacade();
		Object incno = cade.execQuery(sqlb.toString(), sqlp, handler);

		if (incno == null) {
			return null;
		}
		return (String) incno;

	}

	/**
	 * 根据患者id_pat查询门诊未结算Fg_st='N'就诊信息
	 * 
	 * @param id_pat
	 *            病人ID
	 * @return
	 * @throws BizException
	 * */
	public BlRecgOepDTO[] findBlCgOepInfoByIdpat(String id_pat, String patCode, String id_grp, String id_org) throws BizException {
		StringBuffer sqlb = new StringBuffer();
		sqlb.append(" select  distinct a.id_ent ");
		sqlb.append(" from bl_cg_itm_oep a ");
		sqlb.append(" where (a.fg_st = 'N' or a.fg_st is null ) ");
		sqlb.append("    and a.id_pat = ? ");

		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_pat);
		List<BlCgItmOepDO> blCgItmOepDOList = (List<BlCgItmOepDO>) new DAFacade().execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlCgItmOepDO.class));
		if (blCgItmOepDOList == null || blCgItmOepDOList.size() == 0) {
			// throw new BizException("没有找到该患者的未划价的就诊信息");
			// 如果cg表中没有就诊费用，则查询ci_or_srv中就诊id
			StringBuffer sql_ci = new StringBuffer();
			sql_ci.append(" select  distinct a.id_en as id_ent ");
			sql_ci.append(" from ci_or_srv a ");
			sql_ci.append(" where a.sd_su_bl = '0' and a.code_entp in ('00','01') ");
			sql_ci.append("    and a.id_pat = ? ");
			SqlParam paramCi = new SqlParam();
			paramCi.addParam(id_pat);
			blCgItmOepDOList = (List<BlCgItmOepDO>) new DAFacade().execQuery(sql_ci.toString(), paramCi, new BeanListHandler(BlCgItmOepDO.class));
			if (blCgItmOepDOList == null || blCgItmOepDOList.size() == 0) {
				// 如果cg表中没有就诊费用，ci域中也没有费用数据时 即挂号后做重划价
				StringBuffer sql_en = new StringBuffer();
				sql_en.append(" select  id_ent from en_ent where code_entp in ('00','01') and fg_canc = 'N' and id_pat = ? ");
				sql_en.append(" minus ");
				sql_en.append(" select distinct a.id_ent ");
				sql_en.append(" from  ci_or_srv b inner join en_ent a  on a.id_ent = b.id_en ");
				sql_en.append(" where b.sd_su_bl = '0' and b.code_entp in ('00','01')  ");
				sql_en.append(" and a.id_pat = ?  ");
				SqlParam paramEn = new SqlParam();
				paramEn.addParam(id_pat);
				paramEn.addParam(id_pat);
				blCgItmOepDOList = (List<BlCgItmOepDO>) new DAFacade().execQuery(sql_en.toString(), paramEn, new BeanListHandler(BlCgItmOepDO.class));
				if (blCgItmOepDOList == null || blCgItmOepDOList.size() == 0) {
					return null;
				}
			}
		}

		//
		List<String> id_entArr = new ArrayList<String>();
		for (BlCgItmOepDO blcgitm : blCgItmOepDOList) {
			String s = blcgitm.getId_ent();
			if (s == null || s.length() <= 2)
				continue;

			if ((s != null && s.length() > 2) && (!id_entArr.contains(s))) {
				id_entArr.add(blcgitm.getId_ent());
			}
		}

		String entCode = "";
		String[] entCodeArr = id_entArr.toArray(new String[id_entArr.size()]);
		for (int i = 0; i < entCodeArr.length; i++) {
			entCode += entCodeArr[i].trim();
			if (entCodeArr.length - 1 != i)
				entCode += "','";
		}
		entCode = "'" + entCode + "'";
		StringBuffer sqlb2 = new StringBuffer();
		sqlb2.append(" SELECT PI_PAT.code     Pat_code, ");
		sqlb2.append("        PI_PAT.Name     Pat_name, ");
		sqlb2.append("        bd_pri_pat.name Pat_pripat_name, ");
		sqlb2.append("        bd_dep.name     Id_dep_reg, ");
		sqlb2.append("   CASE WHEN ( en_ent.dt_acpt is null)  THEN en_ent.dt_entry ELSE en_ent.dt_acpt end  Pat_dt_acpt, ");
		sqlb2.append("        bd_pri_pat.id_pripat Pat_id_pripat, ");
		sqlb2.append("        en_ent.id_ent     Pat_id_ent, ");
		sqlb2.append("        PI_PAT.id_pat     Id_pat ");
		sqlb2.append("   FROM PI_PAT ");
		sqlb2.append("   JOIN EN_ENT ");
		sqlb2.append("     ON PI_PAT.ID_PAT = EN_ENT.ID_PAT ");
		sqlb2.append("   join bd_pri_pat ");
		sqlb2.append("     on en_ent.id_pripat = bd_pri_pat.id_pripat ");
		sqlb2.append("   join en_ent_op ");
		sqlb2.append("     on EN_ENT.ID_ENT = en_ent_op.id_ent ");
		sqlb2.append("   join bd_dep ");
		sqlb2.append("     on en_ent_op.id_dep_reg=bd_dep.id_dep ");
		sqlb2.append("  where (en_ent.code_entp = '00' or en_ent.code_entp = '01') ");
		sqlb2.append("    and PI_PAT.id_pat = ? ");
		sqlb2.append("    and en_ent.id_ent in ( " + entCode + " ) ");
		sqlb2.append("    and pi_pat.id_grp=? ");
		sqlb2.append("    and pi_pat.id_org=?  order by en_ent.dt_acpt desc");
		SqlParam parameter = new SqlParam();

		parameter.addParam(id_pat);
		// parameter.addParam(entCode);
		parameter.addParam(id_grp);
		parameter.addParam(id_org);

		@SuppressWarnings("unchecked")
		List<BlRecgOepDTO> list = (List<BlRecgOepDTO>) new DAFacade().execQuery(sqlb2.toString(), parameter, new BeanListHandler(BlRecgOepDTO.class));
		// 用取出的结果集给对应属性赋.
		if (list.isEmpty()) {
			// System.out.println("查询数据为空");
			// throw new BizException("没有找到该患者的就诊信息");
			return null;
		} else
			return list.toArray(new BlRecgOepDTO[list.size()]);
	}

	public BlIncItmVsTypeDTO[] getIncOepInfoDtoByIncId(String strIdInc) throws BizException {
		if (StringUtil.isAllWhitespace(strIdInc))
			throw new BizException("要查询的发票主键ID为空");
		IBlincoepRService incRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO incOepAggDo = incRService.findById(strIdInc);
		// 获取结算信息
		IBlstoepRService stRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stOepDo = stRService.findById(incOepAggDo.getParentDO().getId_stoep());
		if (stOepDo==null)
			throw new BizException("该发票号没有对应的结算信息");
		BLCiOrderToBlCgServiceImplBp handlerbp = new BLCiOrderToBlCgServiceImplBp();
		// 组装发票数据
		BlIncItmVsTypeDTO[] incOepDtoLst = handlerbp.assemblyIncInfoDtos(stOepDo, new BlincoepAggDO[] { incOepAggDo });
		return incOepDtoLst;
	}
}
