package iih.bl.cg.ipfeebill;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class DayIpFeeBillService {
	
	public List<DayIpFeeBillDTO> assemIpFeeBillInfo(String id_ent,String name_pat,String code_amr_ip,String dt_b,String dt_e,String flag, String isMerge,String orgId) throws Exception{
		
		List<BlCgIpSrvDTO> cgList = this.getBlCgIpInfo(id_ent, dt_b, dt_e,flag,isMerge);
		if(ListUtil.isEmpty(cgList)){
			return null;
		}
		List<BdInccaInfoDTO> caList = this.getBdInccaInfo(orgId);
		List<BlPrePayInfoDTO> payList = this.getBlPrePayInfo(id_ent);
		if(ListUtil.isEmpty(caList)){
			return null;
		}
		
		//获取患者本次就诊的当前就诊科室，床号，患者分类,已结算金额，未结算金额
		DayIpFeeBillDTO entInfo = this.getEntInfo(id_ent);
		
		List<DayIpFeeBillDTO> billList = new ArrayList<DayIpFeeBillDTO>();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		//账单项费用应与明细费用的日期保持一致
		List<String>  dateList = new ArrayList<String>();
		for(BlCgIpSrvDTO cgSrvDTO : cgList) {
			if(!dateList.contains(cgSrvDTO.getDt_cg())) {
				dateList.add(cgSrvDTO.getDt_cg());
			}
		}
		for(String strDate : dateList){
			FDouble amt_std = new FDouble("0.00");
			FDouble amt_pay = new FDouble("0.00");
			String dt_n = strDate;
			DayIpFeeBillDTO billDto = new DayIpFeeBillDTO();
			if(entInfo != null){
				billDto.setName_dep_nur(entInfo.getName_dep_nur());
				billDto.setName_bed(entInfo.getName_bed());
				billDto.setName_patca(entInfo.getName_patca());
				billDto.setAmt_st(entInfo.getAmt_st());
				billDto.setAmt_nost(entInfo.getAmt_nost());
			}
			billDto.date = dt_n;
			billDto.setName_pat(name_pat);
			billDto.setCode_amr_ip(code_amr_ip);
			FDouble amt_day = new FDouble("0.00");
			//费用合计
			for(BlCgIpSrvDTO cgDto : cgList){
					if(cgDto.getDt_cg().equals(dt_n)){
						amt_day = amt_day.add(cgDto.getAmt_ratio());
					}
			}
			billDto.setAmt_day(amt_day.setScale(2, BigDecimal.ROUND_HALF_UP));
			//当日费用合计
			for(BlCgIpSrvDTO cgDto : cgList){
				if(cgDto.getDt_cg().equals(dt_n) || dt.parse(cgDto.getDt_cg()).before(dt.parse(dt_n))){
					amt_std = amt_std.add(cgDto.getAmt_ratio());
				}
			}
			billDto.setAmt_std(amt_std.setScale(2, BigDecimal.ROUND_HALF_UP));
			//预交金（押金）
			for(BlPrePayInfoDTO payDto : payList){
				if(payDto.getDt_pay().equals(dt_n) || dt.parse(payDto.getDt_pay()).before(dt.parse(dt_n))){
					amt_pay = amt_pay.add(payDto.getAmt());
				}
			}
			billDto.setAmt_pay(amt_pay.setScale(2, BigDecimal.ROUND_HALF_UP));
			List<DayIpBillCgInfoDTO> caIpList = null;
			for(BdInccaInfoDTO caDto : caList){
				if(caIpList == null){
					caIpList = new ArrayList<DayIpBillCgInfoDTO>();
				}
				DayIpBillCgInfoDTO caIpDto = new DayIpBillCgInfoDTO();
				caIpDto.setCode(caDto.getCode());
				caIpDto.setName(caDto.getName());
				FDouble amt = new FDouble("0.00");
				for(BlCgIpSrvDTO cgDto : cgList){
					if(!StringUtil.isEmpty(cgDto.getId_inccaitm())){ 
						if(cgDto.getId_inccaitm().equals(caDto.getId_inccaitm()) && cgDto.getDt_cg().equals(dt_n)){
							amt = amt.add(cgDto.getAmt_ratio());
						}
					}
				}
				caIpDto.setAmt(amt.setScale(2, BigDecimal.ROUND_HALF_UP));
				caIpList.add(caIpDto);
			}
			billDto.setCaList(caIpList);
			billList.add(billDto);
		}
		return billList;
	}
	
	/**
	 * 获取患者本次就诊的当前就诊科室，床号，患者分类,已结算金额，未结算金额
	 * @return
	 * @throws BizException 
	 */
	private DayIpFeeBillDTO getEntInfo(String id_ent) throws BizException{
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from  ");
		sql.append(" (select nvl(sum(amt_ratio*eu_direct),0.00) amt_st from bl_cg_ip where id_ent = ? and fg_st = 'Y' and fg_real = 'Y'), ");
		sql.append(" (select nvl(sum(amt_ratio*eu_direct),0.00) amt_nost from bl_cg_ip where id_ent = ? and fg_st = 'N' and fg_real = 'Y'), ");
		sql.append(" (select dep.name name_dep_nur,entip.name_bed,patca.name name_patca ");
		sql.append(" from en_ent ent ");
		sql.append(" inner join en_ent_ip entip on ent.id_ent = entip.id_ent ");
		sql.append(" left join pi_pat_ca patca on ent.id_patca = patca.id_patca ");
		sql.append(" left join bd_dep dep on dep.id_dep = ent.id_dep_nur ");
		sql.append(" where ent.id_ent = ?) ");

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_ent);
		sqlParam.addParam(id_ent);
		sqlParam.addParam(id_ent);

		List<DayIpFeeBillDTO> list = (List<DayIpFeeBillDTO>) new DAFacade().execQuery(sql.toString(), sqlParam,
				new BeanListHandler(DayIpFeeBillDTO.class));
		
		if(ListUtil.isEmpty(list)){
			return null;
		}
		
		return list.get(0);
	}
	
	/**
	 * 记账信息
	 * */
	@SuppressWarnings({ "unchecked" })
	public List<BlCgIpSrvDTO> getBlCgIpInfo(String id_ent,String dt_b,String dt_e,String flag,String isMerge) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT A1.ID_INCCAITM,SUBSTR(C1.DT_CG, 1, 10) DT_CG,(C1.EU_DIRECT * C1.AMT_RATIO) AMT_RATIO ")
			 .append("FROM BL_CG_IP C1,BD_INCCA_ITM_REL A1,BD_INCCA A2 ")
			 .append("WHERE c1.fg_real = 'Y' and A1.ID_SRV = C1.ID_SRV ")
			 .append("AND A2.ID_INCCA = A1.ID_INCCA ")
			 .append("AND A2.CODE = '12' ")
			 .append("AND C1.ID_ENT = '").append(id_ent).append("' ");
		
		if(dt_b.trim().length() == 10){
			sql.append("AND C1.DT_CG >= '").append(dt_b.trim()).append(" 00:00:00' ");
		}else{
			sql.append("AND C1.DT_CG >= '").append(dt_b.trim()).append("'");
		}
		
		if(dt_e.trim().length() == 10){
			sql.append("AND C1.DT_CG <= '").append(dt_e.trim()).append(" 23:59:59' ");
		}else{
			sql.append("AND C1.DT_CG <= '").append(dt_e.trim()).append("'");
		}
		

		if("TRUE".equals(flag) || "true".equals(flag)){
			sql.append("AND C1.FG_ST = 'Y' ");
		}else if("FALSE".equals(flag) || "false".equals(flag)){
			sql.append("AND C1.FG_ST = 'N' ");
		}
		if("TRUE".equals(isMerge) || "true".equals(isMerge)) {
			sql.append(" and (C1.id_ent = '").append(id_ent).append("' or C1.ID_ENT_mom = '").append(id_ent).append("') ");
			
		} else {
			sql.append(" and (C1.id_ent = '").append(id_ent).append("') ");
		}
		sql.append("ORDER BY DT_CG");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		BeanListHandler beanlist_handler = new BeanListHandler(BlCgIpSrvDTO.class);
		List<BlCgIpSrvDTO> result = (List<BlCgIpSrvDTO>)beanlist_handler.processRs(cached_rs);
		return result;
	}

	/**
	 * 发票类型
	 * */
	@SuppressWarnings("unchecked")
	public List<BdInccaInfoDTO> getBdInccaInfo(String orgId) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT B.CODE, B.NAME, B.ID_INCCAITM ")
			 .append("FROM BD_INCCA A ")
			 .append("JOIN BD_INCCA_ITM B ON A.ID_INCCA = B.ID_INCCA ")
			 .append("WHERE A.CODE = '12' ");
		
		sql.append("AND B.ID_ORG = '" + orgId + "'");
		
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		BeanListHandler beanlist_handler = new BeanListHandler(BdInccaInfoDTO.class);
		List<BdInccaInfoDTO> result = (List<BdInccaInfoDTO>)beanlist_handler.processRs(cached_rs);
		return result;
	}
	
	/**
	 * 预交金
	 * */
	@SuppressWarnings("unchecked")
	public List<BlPrePayInfoDTO> getBlPrePayInfo(String id_ent) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SUBSTR(DT_PAY, 1, 10) DT_PAY,(EU_DIRECT * AMT) AMT ")
			 .append("FROM BL_PREPAY_PAT ")
			 .append("WHERE ID_ENT = '").append(id_ent).append("' ")
			 .append("ORDER BY DT_PAY");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		BeanListHandler beanlist_handler = new BeanListHandler(BlPrePayInfoDTO.class);
		List<BlPrePayInfoDTO> result = (List<BlPrePayInfoDTO>)beanlist_handler.processRs(cached_rs);
		return result;
	}
}
