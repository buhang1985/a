package iih.bl.cg.s.bp.op;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfRService;
import iih.bl.cg.dto.d.NoTfCostItmDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询门诊已转入费用明细（门诊费用转住院费用）
 * 
 * @author shaokx 2019.03.13
 *
 */
public class GetAlreadyTfCostBP {

	/**
	 * 查询门诊已转入费用明细（门诊费用转住院费用）
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public NoTfCostItmDTO[] exec(String patId) throws BizException {

		if(StringUtil.isEmpty(patId)){
			throw new BizException("入参为空");
		}
		
		//修复隐藏bug：banner查出来的id_ent不是最新的住院的id_ent
		//所以需要根据门诊明细中id_pat查询住院id_ent
		IPativisitRService patisRService = ServiceFinder.find(IPativisitRService.class);
		String sql = String.format(" id_pat='%s' and code_entp='10' and fg_st='N' ", patId);
		PatiVisitDO[] enDOs = patisRService.find(sql, " sv desc ", FBoolean.FALSE);
		
		if (enDOs==null||enDOs.length==0) {
			return null;
		}
		
		// 查询出门诊记账转移记录表中的门诊记账id
		IBlcgoeptfRService tfRService = ServiceFinder.find(IBlcgoeptfRService.class);
		BlCgItmOepTfRcdDO[] tfRdos = tfRService.find(" fg_active = 'Y' and ID_ENT_TF='"+enDOs[0].getId_ent()+"' ", " dt_tf desc ", FBoolean.FALSE);

		if (ArrayUtil.isEmpty(tfRdos)) {
			return null;
		}

		List<String> cgItmIds = new ArrayList<String>();

		for (BlCgItmOepTfRcdDO itm : tfRdos) {
			cgItmIds.add(itm.getId_cgitmoep());
		}

		String inCont = SqlUtils.getInSqlByIds("cgitmoep.id_cgitmoep", cgItmIds);

		// 通过门诊记账id来查出所需数据信息
		NoTfCostItmDTO[] alreadyTf = this.getAlreadyTfCostInfo(enDOs[0].getId_ent(), inCont);

		return alreadyTf;
	}

	/**
	 * 通过门诊记账id来查出所需数据信息
	 * 
	 * @return
	 * @throws BizException
	 */
	private NoTfCostItmDTO[] getAlreadyTfCostInfo(String entId, String inCont) throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append(" select cgitmoep.id_cgitmoep, ");
		sb.append(" cgitmoep.id_pat, ");
		sb.append(" cgitmoep.id_ent, ");
		sb.append(" entop.times_op ent_times, ");
		sb.append(" cgoep.code_cg, ");
		sb.append(" cgitmoep.id_or, ");
		sb.append(" cior.name_or, ");
		sb.append(" cgitmoep.id_srv, ");
		sb.append(" cgitmoep.name_srv, ");
		sb.append(" cgitmoep.id_mm, ");
		sb.append(" cgitmoep.name_mm, ");
		sb.append(" cgitmoep.price_ratio price_ratio, ");
		sb.append(" cgitmoep.quan, ");
		sb.append(" cgitmoep.amt_ratio, ");
		sb.append(" cgitmoep.srvu, ");
		sb.append(" meas.name srvu_name, ");
		sb.append(" cgitmoep.id_dep_or, ");
		sb.append(" ordep.name name_dep_or, ");
		sb.append(" cgitmoep.id_dep_mp, ");
		sb.append(" mpdep.name name_dep_mp, ");
		sb.append(" cgitmoep.id_pripat, ");
		
		sb.append(" cgitmoep.dt_or, ");
		sb.append(" stoep.code_st, ");
		sb.append(" stoep.dt_st, ");
		sb.append(" inc.incno, ");
		
		sb.append(" pripat.name name_pripat, ");
		sb.append(" patca.name id_paticate_name ");
		sb.append(" from bl_cg_oep cgoep ");
		sb.append(" inner join bl_cg_itm_oep cgitmoep on cgoep.id_cgoep = cgitmoep.id_cgoep ");
		
		sb.append(" join  bl_inc_cg_itm_oep incitm on incitm.id_cgitmoep = cgitmoep.id_cgitmoep ");
		sb.append(" join  bl_inc_oep inc on inc.id_incoep = incitm.id_incoep ");
		sb.append(" join bl_st_oep stoep on stoep.id_stoep  = cgitmoep.id_stoep ");
		
		sb.append(" inner join en_ent_op entop on entop.id_ent = cgitmoep.id_ent ");
		sb.append(" inner join ci_order cior on cior.id_or = cgitmoep.id_or ");
		sb.append(" inner join pi_pat pat on pat.id_pat = cgitmoep.id_pat ");
		sb.append(" left join pi_pat_ca patca on patca.id_patca = pat.id_paticate ");
		sb.append(" left join bd_measdoc meas on meas.id_measdoc = cgitmoep.srvu ");
		sb.append(" left join bd_dep ordep on ordep.id_dep = cgitmoep.id_dep_or ");
		sb.append(" left join bd_dep mpdep on mpdep.id_dep = cgitmoep.id_dep_mp ");
		sb.append(" left join bd_pri_pat pripat on pripat.id_pripat = cgitmoep.id_pripat ");
		sb.append("  where 1 = 1 ");
		//sb.append(" and cgitmoep.id_ent = ? ");
		sb.append(" and "+inCont+" ");
		
		sb.append(" order by stoep.code_st,inc.incno,cior.name_or ");
//		SqlParam sp = new SqlParam();
//		sp.addParam(entId);

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<NoTfCostItmDTO> list = (List<NoTfCostItmDTO>) new DAFacade().execQuery(sb.toString(), null,
				new BeanListHandler(NoTfCostItmDTO.class));

		return list.toArray(new NoTfCostItmDTO[] {});
	}
}
