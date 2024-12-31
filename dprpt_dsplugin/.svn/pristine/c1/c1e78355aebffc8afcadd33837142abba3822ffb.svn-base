package iih.bl.cg.ipfeebill;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class DayIpFeeBillTogetherService {
	public List<DayIpFeeBillDTO> assemIpFeeBillInfo(String id_ents, String dt_b, String dt_e, String flag,
			String isMerge, String orgId) throws Exception {

		if (StringUtil.isEmpty(id_ents)) {
			return null;
		}

		// 把多个id_ent转为数组类型
		String[] id_entArr = null;
		if (id_ents.contains(",")) {
			id_entArr = id_ents.split(",");
		} else {
			id_entArr = new String[] { id_ents };
		}

		List<BlCgIpSrvDTO> cgList = this.getBlCgIpInfo(id_entArr, dt_b, dt_e, flag, isMerge);
		List<BlCgIpSrvDTO> cgListBegin = this.getBlCgIpInfoBegin(id_entArr, dt_b, dt_e, flag, isMerge);
		
		if (ListUtil.isEmpty(cgList)) {
			return null;
		}

		List<BdInccaInfoDTO> caList = this.getBdInccaInfo(orgId);// 发票类型
		if (ListUtil.isEmpty(caList)) {
			return null;
		}
		

		Map<String, BlCgIpSrvDTO> cgMap=new HashMap<>();
		for (BlCgIpSrvDTO srvCg : cgListBegin) {
			if(!cgMap.containsKey(srvCg.getId_ent())){
				cgMap.put(srvCg.getId_ent(), srvCg);
			}
		}
		
		List<BlPrePayInfoDTO> payList = this.getBlPrePayInfo(id_entArr);// 预交金

		//获取患者多次就诊的当前就诊科室，床号，患者分类,已结算金额，未结算金额
		List<DayIpFeeBillDTO> entInfos = this.getEntInfos(id_entArr);
		
		List<DayIpFeeBillDTO> billList = new ArrayList<DayIpFeeBillDTO>();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		

		// 通过dt_cg和id_ent进行分组获得多个患者的账单项信息
		//Map<String, String> map = new HashMap<String, String>();// key为id_ent,value为dt_cg
		List<String> list = new ArrayList<String>();
		for (BlCgIpSrvDTO cgSrvDTO : cgList) {
			if (!list.contains(cgSrvDTO.getDt_cg() + "," + cgSrvDTO.getId_ent())) {
				list.add(cgSrvDTO.getDt_cg() + "," + cgSrvDTO.getId_ent());
			}
		}

		// 各个账单项进行对其他信息赋值
		for (String entIdAndDt : list) {
			String[] entIdAndTime = entIdAndDt.split(",");
			//时间
			String time = entIdAndTime[0];
			//就诊id
			String entId = entIdAndTime[1];
			
			FDouble amt_std = new FDouble("0.00");
			BlCgIpSrvDTO srvDto = cgMap.get(entId);
			if(srvDto!=null){
				amt_std = srvDto.getAmt_ratio();
			}
			FDouble amt_pay = new FDouble("0.00");
			String dt_n = time;// 时间

			String[] nameAndAmr = this.findNameInfo(entId);

			DayIpFeeBillDTO billDto = new DayIpFeeBillDTO();
			if(!ListUtil.isEmpty(entInfos)){
				for (DayIpFeeBillDTO itm : entInfos) {
					if(entId.equals(itm.getId_ent())){
						billDto.setName_dep_nur(itm.getName_dep_nur());
						billDto.setName_bed(itm.getName_bed());
						billDto.setName_patca(itm.getName_patca());
						billDto.setAmt_st(itm.getAmt_st());
						billDto.setAmt_nost(itm.getAmt_nost());
						break;
					}
				}
			}
			billDto.date = dt_n;
			billDto.setName_pat(nameAndAmr[0]);// 姓名
			billDto.setCode_amr_ip(nameAndAmr[1]);// 住院号
			billDto.setName_bed(nameAndAmr[2]);//床号

			FDouble amt_day = new FDouble("0.00");

			// 费用合计
			for (BlCgIpSrvDTO cgDto : cgList) {
				if (cgDto.getDt_cg().equals(dt_n) && cgDto.getId_ent().equals(entId)) {
					amt_day = amt_day.add(cgDto.getAmt_ratio());
				}
			}
			billDto.setAmt_day(amt_day.setScale(2, BigDecimal.ROUND_HALF_UP));

			// 当日费用合计
			for (BlCgIpSrvDTO cgDto : cgList) {
				if ((cgDto.getDt_cg().equals(dt_n) || dt.parse(cgDto.getDt_cg()).before(dt.parse(dt_n)))
						&& cgDto.getId_ent().equals(entId)) {
					amt_std = amt_std.add(cgDto.getAmt_ratio());
				}
			}
			billDto.setAmt_std(amt_std.setScale(2, BigDecimal.ROUND_HALF_UP));

			// 预交金（押金）
			for (BlPrePayInfoDTO payDto : payList) {
				if ((payDto.getDt_pay().equals(dt_n) || dt.parse(payDto.getDt_pay()).before(dt.parse(dt_n)))
						&& payDto.getId_ent().equals(entId)) {
					amt_pay = amt_pay.add(payDto.getAmt());
				}
			}
			billDto.setAmt_pay(amt_pay.setScale(2, BigDecimal.ROUND_HALF_UP));
			List<DayIpBillCgInfoDTO> caIpList = null;
			for (BdInccaInfoDTO caDto : caList) {
				if (caIpList == null) {
					caIpList = new ArrayList<DayIpBillCgInfoDTO>();
				}
				DayIpBillCgInfoDTO caIpDto = new DayIpBillCgInfoDTO();
				caIpDto.setCode(caDto.getCode());
				caIpDto.setName(caDto.getName());
				FDouble amt = new FDouble("0.00");
				for (BlCgIpSrvDTO cgDto : cgList) {
					if (!StringUtil.isEmpty(cgDto.getId_inccaitm())) {
						if (cgDto.getId_inccaitm().equals(caDto.getId_inccaitm()) && cgDto.getDt_cg().equals(dt_n)
								&& cgDto.getId_ent().equals(entId)) {
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
	 * 获取患者多次就诊的当前就诊科室，床号，患者分类,已结算金额，未结算金额
	 * @param id_entArr
	 * @return
	 * @throws BizException 
	 */
	private List<DayIpFeeBillDTO> getEntInfos(String[] id_entArr) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append(" select nvl(a.amt_nost,0.00) amt_nost,nvl(b.amt_st,0.00) amt_st,nvl(a.id_ent,b.id_ent) id_ent,nvl(a.name_dep_nur,b.name_dep_nur) name_dep_nur,nvl(a.name_bed,b.name_bed) name_bed,nvl(a.name_patca,b.name_patca) name_patca ");
		sql.append(" from (select nvl(sum(cgip.amt_ratio * cgip.eu_direct), 0.00) amt_nost, cgip.id_ent,dep.name name_dep_nur,entip.name_bed,patca.name name_patca ");
		sql.append(" from bl_cg_ip cgip ");
		sql.append(" inner join en_ent ent on cgip.id_ent = ent.id_ent ");
		sql.append(" left join en_ent_ip entip on ent.id_ent = entip.id_ent ");
		sql.append(" left join pi_pat_ca patca on ent.id_patca = patca.id_patca ");
		sql.append(" left join bd_dep dep on dep.id_dep = ent.id_dep_nur ");
		sql.append(" where ");
		sql.append(this.getInSqlByIds("cgip.id_ent", id_entArr));
		sql.append(" and cgip.fg_st = 'N' ");
		sql.append(" and cgip.fg_real = 'Y' ");
		sql.append(" group by cgip.id_ent,dep.name,entip.name_bed,patca.name ) a ");
		sql.append(" full join (select nvl(sum(cgip.amt_ratio * cgip.eu_direct), 0.00) amt_st, cgip.id_ent,dep.name name_dep_nur,entip.name_bed,patca.name name_patca ");
		sql.append(" from bl_cg_ip  cgip ");
		sql.append(" inner join en_ent ent on cgip.id_ent = ent.id_ent ");
		sql.append(" left join en_ent_ip entip on ent.id_ent = entip.id_ent ");
		sql.append(" left join pi_pat_ca patca on ent.id_patca = patca.id_patca ");
		sql.append(" left join bd_dep dep on dep.id_dep = ent.id_dep_nur ");
		sql.append(" where ");
		sql.append(this.getInSqlByIds("cgip.id_ent", id_entArr));
		sql.append(" and cgip.fg_st = 'Y' ");
		sql.append(" and cgip.fg_real = 'Y' ");
		sql.append(" group by cgip.id_ent,dep.name,entip.name_bed,patca.name ) b ");
		sql.append(" on a.id_ent = b.id_ent ");

		List<DayIpFeeBillDTO> list = (List<DayIpFeeBillDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(DayIpFeeBillDTO.class));
		
		return list;
	}
	
	/**
	 * 根据就诊号查询患者姓名和患者住院号
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private String[] findNameInfo(String entId) throws BizException {
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append(" select pat.name name_pat, entip.code_amr_ip,entip.name_bed ");
		sqlStr.append(" from en_ent ent ");
		sqlStr.append(" left join en_ent_ip entip ");
		sqlStr.append(" on ent.id_ent = entip.id_ent ");
		sqlStr.append(" left join pi_pat pat ");
		sqlStr.append(" on pat.id_pat = ent.id_pat ");
		sqlStr.append(" where 1=1 ");
		sqlStr.append(" and ent.id_ent = ? ");

		SqlParam param = new SqlParam();
		param.addParam(entId);

		@SuppressWarnings("unchecked")
		List<DayIpFeeBillDTO> list = (List<DayIpFeeBillDTO>) new DAFacade().execQuery(sqlStr.toString(), param,
				new BeanListHandler(DayIpFeeBillDTO.class));

		if (ListUtil.isEmpty(list)) {
			throw new BizException("未查询到患者就诊信息");
		}

		String[] nameAndAmr = new String[3];
		nameAndAmr[0] = list.get(0).getName_pat();
		nameAndAmr[1] = list.get(0).getCode_amr_ip();
		nameAndAmr[2] = list.get(0).getName_bed();
		return nameAndAmr;
	}

	/**
	 * 记账信息
	 */
	@SuppressWarnings({ "unchecked" })
	public List<BlCgIpSrvDTO> getBlCgIpInfo(String[] id_ents, String dt_b, String dt_e, String flag, String isMerge)
			throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT A1.ID_INCCAITM,SUBSTR(C1.DT_CG, 1, 10) DT_CG,(C1.EU_DIRECT * C1.AMT_RATIO) AMT_RATIO,c1.id_ent ")
				.append("FROM BL_CG_IP C1,BD_INCCA_ITM_REL A1,BD_INCCA A2,en_ent_ip entip ")
				.append("WHERE c1.fg_real = 'Y' and c1.id_ent = entip.id_ent  and A1.ID_SRV = C1.ID_SRV ").append("AND A2.ID_INCCA = A1.ID_INCCA ")//c1.fg_real = 'Y' and
				.append("AND A2.CODE = '12' ");
		sql.append(" AND ").append(this.getInSqlByIds("C1.Id_ent", id_ents));

		if (dt_b.trim().length() == 10) {
			sql.append("AND C1.DT_CG >= '").append(dt_b.trim()).append(" 00:00:00' ");
		} else {
			sql.append("AND C1.DT_CG >= '").append(dt_b.trim()).append("'");
		}

		if (dt_e.trim().length() == 10) {
			sql.append("AND C1.DT_CG <= '").append(dt_e.trim()).append(" 23:59:59' ");
		} else {
			sql.append("AND C1.DT_CG <= '").append(dt_e.trim()).append("'");
		}

		if ("TRUE".equals(flag) || "true".equals(flag)) {
			sql.append("AND C1.FG_ST = 'Y' ");
		} else if ("FALSE".equals(flag) || "false".equals(flag)) {
			sql.append("AND C1.FG_ST = 'N' ");
		}
		if ("TRUE".equals(isMerge) || "true".equals(isMerge)) {
			// sql.append(" and (C1.id_ent = '").append(id_ent).append("' or
			// C1.ID_ENT_mom = '").append(id_ent).append("') ");
			sql.append(" and ( ").append(this.getInSqlByIds("C1.Id_ent", id_ents)).append(" or ")
					.append(this.getInSqlByIds("C1.ID_ENT_mom", id_ents)).append(" ) ");
		} else {
			// sql.append(" and (C1.id_ent = '").append(id_ent).append("') ");
			sql.append(" and ( ").append(this.getInSqlByIds("C1.Id_ent", id_ents)).append(" ) ");
		}
		sql.append("ORDER BY entip.name_bed,C1.ID_ENT,DT_CG");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		BeanListHandler beanlist_handler = new BeanListHandler(BlCgIpSrvDTO.class);
		List<BlCgIpSrvDTO> result = (List<BlCgIpSrvDTO>) beanlist_handler.processRs(cached_rs);
		return result;
	}
	
	/**
	 * 记账信息
	 */
	@SuppressWarnings({ "unchecked" })
	public List<BlCgIpSrvDTO> getBlCgIpInfoBegin(String[] id_ents, String dt_b, String dt_e, String flag, String isMerge)
			throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT sum(C1.EU_DIRECT * C1.AMT_RATIO) AMT_RATIO,C1.id_ent ")
				.append("FROM BL_CG_IP C1,BD_INCCA_ITM_REL A1,BD_INCCA A2,en_ent_ip entip ")
				.append("WHERE c1.fg_real = 'Y' and c1.id_ent = entip.id_ent  and A1.ID_SRV = C1.ID_SRV ").append("AND A2.ID_INCCA = A1.ID_INCCA ")//c1.fg_real = 'Y' and
				.append("AND A2.CODE = '12' ");
		sql.append(" AND ").append(this.getInSqlByIds("C1.Id_ent", id_ents));

		if (dt_b.trim().length() == 10) {
			sql.append("AND C1.DT_CG < '").append(dt_b.trim()).append(" 00:00:00' ");
		} else {
			sql.append("AND C1.DT_CG < '").append(dt_b.trim()).append("'");
		}

		/*if (dt_e.trim().length() == 10) {
			sql.append("AND C1.DT_CG <= '").append(dt_e.trim()).append(" 23:59:59' ");
		} else {
			sql.append("AND C1.DT_CG <= '").append(dt_e.trim()).append("'");
		}*/

		if ("TRUE".equals(flag) || "true".equals(flag)) {
			sql.append("AND C1.FG_ST = 'Y' ");
		} else if ("FALSE".equals(flag) || "false".equals(flag)) {
			sql.append("AND C1.FG_ST = 'N' ");
		}
		if ("TRUE".equals(isMerge) || "true".equals(isMerge)) {
			// sql.append(" and (C1.id_ent = '").append(id_ent).append("' or
			// C1.ID_ENT_mom = '").append(id_ent).append("') ");
			sql.append(" and ( ").append(this.getInSqlByIds("C1.Id_ent", id_ents)).append(" or ")
					.append(this.getInSqlByIds("C1.ID_ENT_mom", id_ents)).append(" ) ");
		} else {
			// sql.append(" and (C1.id_ent = '").append(id_ent).append("') ");
			sql.append(" and ( ").append(this.getInSqlByIds("C1.Id_ent", id_ents)).append(" ) ");
		}
		sql.append(" group by C1.id_ent ");
		//sql.append("ORDER BY entip.name_bed,C1.ID_ENT,DT_CG");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		BeanListHandler beanlist_handler = new BeanListHandler(BlCgIpSrvDTO.class);
		List<BlCgIpSrvDTO> result = (List<BlCgIpSrvDTO>) beanlist_handler.processRs(cached_rs);
		return result;
	}

	/**
	 * 发票类型
	 */
	@SuppressWarnings("unchecked")
	public List<BdInccaInfoDTO> getBdInccaInfo(String orgId) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT B.CODE, B.NAME, B.ID_INCCAITM ").append("FROM BD_INCCA A ")
				.append("JOIN BD_INCCA_ITM B ON A.ID_INCCA = B.ID_INCCA ").append("WHERE A.CODE = '12' ");

		sql.append("AND B.ID_ORG = '" + orgId + "'");

		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		BeanListHandler beanlist_handler = new BeanListHandler(BdInccaInfoDTO.class);
		List<BdInccaInfoDTO> result = (List<BdInccaInfoDTO>) beanlist_handler.processRs(cached_rs);
		return result;
	}

	/**
	 * 预交金
	 */
	@SuppressWarnings("unchecked")
	public List<BlPrePayInfoDTO> getBlPrePayInfo(String[] id_ents) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SUBSTR(DT_PAY, 1, 10) DT_PAY,(EU_DIRECT * AMT) AMT,id_ent ").append("FROM BL_PREPAY_PAT ")
				.append("WHERE ").append(this.getInSqlByIds("Id_ent", id_ents)).append(" ORDER BY DT_PAY");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		BeanListHandler beanlist_handler = new BeanListHandler(BlPrePayInfoDTO.class);
		List<BlPrePayInfoDTO> result = (List<BlPrePayInfoDTO>) beanlist_handler.processRs(cached_rs);
		return result;
	}

	/**
	 * 根据ids和查询字段生成in条件语句
	 * 
	 * @param fieldName
	 *            查询字段名
	 * @param ids
	 *            id字符串集合
	 * @return in查询语句
	 */
	public String getInSqlByIds(String fieldName, String[] ids) {
		if (ids.length > 1000) {
			return this.getInSqlByBigIds(fieldName, ids);
		}
		if (ArrayUtil.isEmpty(ids) || StringUtil.isEmptyWithTrim(fieldName)) {
			return null;
		}
		return fieldName + " in (" + this.arrayToStr(ids) + ") ";
	}

	/**
	 * 根据ids和查询字段生成in条件语句
	 * 
	 * @param fieldName
	 *            查询字段名
	 * @param ids
	 *            id字符串集合
	 * @return in查询语句
	 */
	public String getInSqlByBigIds(String fieldName, String[] ids) {
		StringBuilder wherePartBuilder = new StringBuilder();

		int length = ids.length;
		int left = 0;
		int groupSize = 1000;
		ArrayList<String> tempList = new ArrayList<String>(1000);

		while (left < length) {
			tempList.add(ids[left]);
			left++;
			if (tempList.size() >= groupSize || left >= length) {
				String inSql = getInSqlByIds(fieldName, tempList.toArray(new String[0]));
				tempList.clear();
				if (left > groupSize) {
					wherePartBuilder.append(String.format(" or ", inSql));
				}
				wherePartBuilder.append(String.format(" (%s) ", inSql));
			}
		}

		return String.format("(%s)", wherePartBuilder.toString());
	}

	/**
	 * 数组变为值字符串
	 * 
	 * @param items
	 *            某项多个值
	 * @return
	 */
	public String arrayToStr(String[] items) {
		if (ArrayUtil.isEmpty(items)) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String item : items) {
			if (StringUtil.isEmpty(item)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", item));
		}

		return builder.toString();
	}
}
