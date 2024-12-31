package iih.bl.st.s.bp.op;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.st.blstaroep.bp.BlStarOepBp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 查询未结算的预交金记账数据
 * @author ly 2018/05/18
 *
 */
public class OpCgGetNotStPrepayCgBP {

	/**
	 * 查询未结算的预交金记账数据
	 * @param patId
	 * @param dtBegin
	 * @param dtend 
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public List<BlOrderAppendBillParamDTO> exec(String patId,FDateTime dtBegin, FDateTime dtend) throws BizException{
		
		if(StringUtil.isEmpty(patId) || dtBegin == null){
			return null;
		}
		
		SqlParam param = new SqlParam();
		param.addParam(patId);
		param.addParam(dtBegin);
		param.addParam(dtend);
		List<BlCgItmOepDO> rlt = (List<BlCgItmOepDO>)new DAFacade().execQuery(
				this.getSql(), param, new BeanListHandler(BlCgItmOepDO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
	
		BlStarOepBp oepBp = new BlStarOepBp();
		List<BlOrderAppendBillParamDTO> billparamList = new ArrayList<BlOrderAppendBillParamDTO>();
		oepBp.setBlCgItemOepShow(rlt,billparamList,new HashMap<String,MeasDocDO>());
		
		for (BlOrderAppendBillParamDTO dto : billparamList) {
			if (dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) // 物品不用预留
			{
				dto.setFg_reserveMaterials(FBoolean.FALSE);
			}
		}
		return billparamList;
//		return billparamList.toArray(new BlOrderAppendBillParamDTO[0]);
	}
	
	/**
	 * 检索sql
	 * @return
	 */
	private String getSql(){
		
		StringBuilder sqlSb = new StringBuilder();
//		sqlSb.append("select cgitm.*,cgoep.dt_cg,'N' fg_extdispense,'N' fg_specill ");
		sqlSb.append("select ");
		sqlSb.append("cgitm.id_cgitmoep,");
		sqlSb.append("cgitm.id_grp,");
		sqlSb.append("cgitm.id_org,");
		sqlSb.append("cgitm.id_pat,");
		sqlSb.append("cgitm.id_cgoep,");
		sqlSb.append("cgitm.id_ent,");
		sqlSb.append("cgitm.id_enttp,");
		sqlSb.append("cgitm.code_enttp,");
		sqlSb.append("cgitm.id_pres,");
		sqlSb.append("cgitm.id_or,");
		sqlSb.append("cgitm.id_orsrv,");
		sqlSb.append("cgitm.id_srvtp,");
		sqlSb.append("cgitm.sd_srvtp,");
		sqlSb.append("cgitm.id_srvca,");
		sqlSb.append("cgitm.id_srv,");
		sqlSb.append("cgitm.code_srv,");
		sqlSb.append("cgitm.name_srv,");
		sqlSb.append("cgitm.srvu,");
		sqlSb.append("cgitm.code_inccaitm,");
		sqlSb.append("cgitm.name_inccaitm,");
		sqlSb.append("cgitm.code_account,");
		sqlSb.append("cgitm.name_account,");
		sqlSb.append("cgitm.price,");
		sqlSb.append("cgitm.price_ratio,");
		sqlSb.append("cgitm.quan,");
		sqlSb.append("cgitm.amt,");
		sqlSb.append("cgitm.ratio_pripat,");
		sqlSb.append("cgitm.amt_std,");
		sqlSb.append("cgitm.id_pripat,");
		sqlSb.append("cgitm.amt_pat,");
		sqlSb.append("cgitm.id_hpsrvtp,");
		sqlSb.append("cgitm.sd_hpsrvtp,");
		sqlSb.append("cgitm.id_hp,");
		sqlSb.append("cgitm.ratio_hp,");
		sqlSb.append("cgitm.amt_hp,");
		sqlSb.append("cgitm.fg_acc,");
		sqlSb.append("cgitm.amt_acc,");
		sqlSb.append("cgitm.amt_ratio,");
		sqlSb.append("cgitm.dt_or,");
		sqlSb.append("cgitm.id_org_or,");
		sqlSb.append("cgitm.id_dep_or,");
		sqlSb.append("cgitm.id_emp_or,");
		sqlSb.append("cgitm.id_org_mp,");
		sqlSb.append("cgitm.id_dep_mp,");
		sqlSb.append("cgitm.id_dep_phy,");
		sqlSb.append("cgitm.id_emp_phy,");
		sqlSb.append("cgitm.id_dep_wh,");
		sqlSb.append("cgitm.fg_mm,");
		sqlSb.append("cgitm.id_mm,");
		sqlSb.append("cgitm.id_mmtp,");
		sqlSb.append("cgitm.sd_mmtp,");
		sqlSb.append("cgitm.code_mm,");
		sqlSb.append("cgitm.onlycode,");
		sqlSb.append("cgitm.name_mm,");
		sqlSb.append("cgitm.spec,");
		sqlSb.append("cgitm.cd_batch,");
		sqlSb.append("cgitm.pgku_base,");
		sqlSb.append("cgitm.pgku_cur,");
		sqlSb.append("cgitm.factor,");
		sqlSb.append("cgitm.quan_base,");
		sqlSb.append("cgitm.pri_ss,");
		sqlSb.append("cgitm.fg_st,");
		sqlSb.append("cgitm.id_stoep,");
		sqlSb.append("cgitm.dt_st,");
		sqlSb.append("cgitm.fg_hp,");
		sqlSb.append("cgitm.fg_susp,");
		sqlSb.append("cgitm.eu_direct,");
//		sqlSb.append("cgitm.dt_cg,");
		sqlSb.append("cgitm.id_par,");
		sqlSb.append("cgitm.eu_srctp,");
		sqlSb.append("cgitm.note,");
		sqlSb.append("cgitm.fg_refund,");
		sqlSb.append("cgitm.id_recg_oep,");
		sqlSb.append("cgitm.fg_recg,");
		sqlSb.append("cgitm.fg_additm,");
		sqlSb.append("cgitm.fg_free,");
		sqlSb.append("cgitm.code_apply,");
		sqlSb.append("cgitm.apprno,");
		sqlSb.append("cgitm.dt_srv,");
		sqlSb.append("cgitm.srcfunc_des,");
		sqlSb.append("cgitm.sd_abrd,");
		sqlSb.append("cgitm.fg_hpcg,");
		sqlSb.append("cgitm.fg_pricinginsertcg,");
		sqlSb.append("cgitm.code_applytp,");
		sqlSb.append("cgitm.id_hpsrvmpayratio,");
		sqlSb.append("cgitm.fg_zeroreg,");
		sqlSb.append("cgitm.pecode,");
//		sqlSb.append("cgitm.fg_selfpay,");
//		sqlSb.append("cgitm.id_or_pr,");
//		sqlSb.append("cgitm.id_or_pr_srv,");
//		sqlSb.append("cgitm.amt_ratio4,");
//		sqlSb.append("cgitm.id_dep_nur,");
//		sqlSb.append("cgitm.hp_st_code,");
//		sqlSb.append("cgitm.surgery_room,");
//		sqlSb.append("cgitm.surgery_name,");
//		sqlSb.append("cgitm.id_emp_surgeon,");
//		sqlSb.append("cgitm.id_entbed,");
//		sqlSb.append("cgitm.id_entdcg,");
//		sqlSb.append("cgitm.id_root,");
//		sqlSb.append("cgitm.fg_pddisc,");
		sqlSb.append("cgitm.DS,");
		sqlSb.append("cgitm.SV,");
		sqlSb.append("cgoep.dt_cg,'N' fg_extdispense,'N' fg_specill ");
		sqlSb.append("from bl_cg_itm_oep cgitm ");
		sqlSb.append("inner join bl_cg_oep cgoep ");
		sqlSb.append("on cgoep.id_cgoep = cgitm.id_cgoep ");

		sqlSb.append("where ");
		sqlSb.append("cgitm.id_pat = ? ");
		sqlSb.append("and cgoep.dt_cg >= ? ");
		sqlSb.append("and cgoep.eu_direct = 1 ");
		sqlSb.append("and cgitm.fg_refund = 'N'  ");
		sqlSb.append("and nvl(cgitm.id_stoep,'~') = '~' ");
		sqlSb.append(" and cgoep.dt_cg <= ? ");
		return sqlSb.toString();
	}
}
