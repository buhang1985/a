package iih.bl.cg.s.bp.op;

import java.util.List;

import iih.bl.cg.dto.d.NoTfCostItmDTO;
import iih.bl.params.BlParams;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询门诊待转入费用明细（门诊费用转住院报销）
 * 
 * @author shaokx 2019.03.12
 *
 */
public class GetNoTfCostBP {

	/**
	 * 查询门诊待转入费用明细（门诊费用转住院报销）
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public NoTfCostItmDTO[] exec(String patId) throws BizException {

		if(StringUtil.isEmpty(patId)){
			throw new BizException("入参为空");
		}
		
		Integer blStOEP0041 = BlParams.BLSTOEP0041();// 可以转入不超过多少小时的门诊费用到住院费用
		if(blStOEP0041 == null){
			throw new BizException("请维护参数BLSTOEP0041的值");
		}
		
//		FBoolean blStOEP0042 = BlParams.BLSTOEP0042();// 转入时，是否需要门诊退费
//		if(blStOEP0042 == null){
//			throw new BizException("请维护参数BLSTOEP0042的值");
//		}
		
		// 查询待转入费用明细
		NoTfCostItmDTO[] noTfCostItmDtos = this.getNoTfCostItm(blStOEP0041,patId);

		return noTfCostItmDtos;
	}

	/**
	 * 查询待转入费用明细
	 * 
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	private NoTfCostItmDTO[] getNoTfCostItm(Integer blStOEP0041,String patId) throws BizException {
		//FDateTime curTime = AppUtils.getServerDateTime();//获取当前服务器时间
		
		FDateTime curTime = this.getInhoseDate(patId);//获取该患者最新的入院时间
		if(curTime==null){
			return null;
		}
		FDateTime befCurTime = curTime.subSeconds(blStOEP0041*3600);//获取当前时间之前n小时的时间
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" cgitmoep.id_cgitmoep, ");
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
		
		sb.append(" inner join en_ent_op entop on entop.id_ent = cgitmoep.id_ent ");
		sb.append(" inner join bl_st_oep stoep on stoep.id_stoep  = cgitmoep.id_stoep ");
		sb.append(" inner join bl_pay_pat_oep payoep on payoep.id_paypatoep = stoep.id_paypatoep ");
		sb.append(" inner join ci_order cior on cior.id_or = cgitmoep.id_or ");
		sb.append(" inner join pi_pat pat on pat.id_pat = cgitmoep.id_pat ");
		sb.append(" left join pi_pat_ca patca on patca.id_patca = pat.id_paticate ");
		sb.append(" left join bd_measdoc meas on meas.id_measdoc = cgitmoep.srvu ");
		sb.append(" left join bd_dep ordep on ordep.id_dep = cgitmoep.id_dep_or ");
		sb.append(" left join bd_dep mpdep on mpdep.id_dep = cgitmoep.id_dep_mp ");
		sb.append(" left join bd_pri_pat pripat on pripat.id_pripat = cgitmoep.id_pripat ");
		sb.append(" where 1=1 ");
		sb.append(" and cgitmoep.id_pat = ? ");
		sb.append(" and stoep.eu_direct = 1 ");
		sb.append(" and stoep.fg_canc = 'N' ");
		sb.append(" and cgoep.dt_cg between ? and ? ");
		sb.append(" and cgitmoep.id_cgitmoep not in (select distinct tf.id_cgitmoep from bl_cg_itm_oep_tfrcd tf where tf.fg_active = 'Y') ");
		
		sb.append(" order by stoep.code_st,inc.incno,cior.name_or ");
		SqlParam sp = new SqlParam();
		sp.addParam(patId);
		sp.addParam(befCurTime);
		sp.addParam(curTime);

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<NoTfCostItmDTO> list = (List<NoTfCostItmDTO>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(NoTfCostItmDTO.class));

		return list.toArray(new NoTfCostItmDTO[]{});
	}

	/**
	 * 获取最新入院时间
	 * @param patId
	 * @return
	 */
	private FDateTime getInhoseDate(String patId) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from en_ent where id_pat = ? and code_entp='10' order by dt_entry desc ");
		SqlParam sp = new SqlParam();
		sp.addParam(patId);
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sql.toString(), sp,new BeanListHandler(PatiVisitDO.class));	
		if(list.size()>0){
			return list.get(0).getDt_entry();
		}
		return null;
	}
}
