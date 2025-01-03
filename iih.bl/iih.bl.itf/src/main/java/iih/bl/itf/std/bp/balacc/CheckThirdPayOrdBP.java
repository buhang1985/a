package iih.bl.itf.std.bp.balacc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bl.itf.dto.blthirdnowindcheckdto.d.BlThirdNOWindCheckDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
	
/**
 * 检验第三方支付非窗口支付的数据
 * 
 * @author zhangxin06
 * @date 2019年4月23日
 */
public class CheckThirdPayOrdBP {
	public BlThirdNOWindCheckDTO[] exec(String start_time, String end_time, List<String> pttpandPm)
			throws BizException {
		// 校验入参参数
		if (StringUtil.isEmpty(start_time) || StringUtil.isEmpty(end_time)) {
			throw new BizException("检验第三方支付非窗口支付的数据:开始时间结束时间不能为空");
		}
		// 终端类型集合
		String stppt = null;
		// 解析终端类型与支付方式集合
		if (pttpandPm != null) {
			stppt = StringUtils.join(pttpandPm, ",");
		}
		String sdpmList = getSdpmList();
		//获取非窗口收付款数据
		List<BlThirdNOWindCheckDTO> windowsList = getWindowsList(start_time,end_time,stppt,sdpmList);
		// 获取 在第三方设备支付的在  iih窗口进行退款的 数据
		List<BlThirdNOWindCheckDTO> thirdRefundList = getThirdRefundList(start_time,end_time,stppt,sdpmList);
		//添加 iih成功 第三方退费失败的数据
		List<BlThirdNOWindCheckDTO> thirdFailList = getThirdFailList(start_time,end_time,stppt,sdpmList);
		windowsList.addAll(thirdRefundList);
		windowsList.addAll(thirdFailList);
		// 查询终端类型
		Map<String, String> mapSdPttp = this.getSdPttName();
		// 查询第三方交易场景
		Map<String, String> mapSdBizscene = this.getSdBizsceneName();

		for (BlThirdNOWindCheckDTO blThirdNOWindCheckDTO : windowsList) {
			blThirdNOWindCheckDTO.setName_bizscene(mapSdBizscene.get(blThirdNOWindCheckDTO.getSd_bizscene()));
			blThirdNOWindCheckDTO.setName_pttp(mapSdPttp.get(blThirdNOWindCheckDTO.getSd_pttp()));

		}

		return ListUtil.isEmpty(windowsList) ? null : windowsList.toArray(new BlThirdNOWindCheckDTO[] {});

	}
    /**
     * 查询 iih退费成功 第三方交易失败的数据
     * @param start_time
     * @param end_time
     * @param stppt
     * @param sdpmList
     * @return
     * @throws BizException 
     */
	private List<BlThirdNOWindCheckDTO> getThirdFailList(String start_time, String end_time, String stppt,
			String sdpmList) throws BizException {
		StringBuilder sqlSb = new StringBuilder();

		sqlSb.append("   select (rcd.amt *rcd.eu_direct) amt ,rcd.id_pat,pat.name name_pat,pm.code Code_pm,01 sd_pttp,rcd.order_no,rcd.voucher_no,rcd.createdtime,rcd.sd_bizscene ");
		sqlSb.append(" from  bl_trd_trans_rcd rcd ");
		sqlSb.append(" inner join bl_trd_trans_rcd rcdor on rcdor.id_transrcd =rcd.id_par ");
		sqlSb.append(" inner join bd_pri_pm pm on rcd.id_pm = pm.id_pm ");
		sqlSb.append(" inner join pi_pat pat on rcd.id_pat = pat.id_pat ");
		sqlSb.append(" where   rcd.order_no  is not null and  rcd.eu_direct=-1 and rcd.eu_status=3  and (rcd.createdtime between  ? and ? ) ");
		sqlSb.append(" and "+SqlUtils.getInSqlByIdsSplit("pm.code", sdpmList));
		SqlParam sp = new SqlParam();

		sp.addParam(start_time + " 00:00:00");
		sp.addParam(end_time + " 23:59:59");
		@SuppressWarnings("unchecked")
		List<BlThirdNOWindCheckDTO> list = (List<BlThirdNOWindCheckDTO>) new DAFacade().execQuery(sqlSb.toString(), sp,
				new BeanListHandler(BlThirdNOWindCheckDTO.class));
		return list;
	}

	/**
	 * 
	 * 查询 终端类型 集合 为啥不用id 关联 应为id 存的不对，或者有些根本没存
	 * 
	 * @return
	 * @throws DAException
	 */
	private Map<String, String> getSdPttName() throws DAException {
		Map<String, String> mapSdPttp = new HashMap<String, String>();
		// 查询合计
		StringBuffer sqlSdPttp = new StringBuffer();
		sqlSdPttp.append(
				"    select udi.code Sd_pttp,udi.name  Name_pttp  from bd_udidoc udi where udi.id_udidoclist ='@@@@ZZ200000000000JC' ");
		@SuppressWarnings("unchecked")
		List<BlThirdNOWindCheckDTO> listSdPttp = (List<BlThirdNOWindCheckDTO>) new DAFacade()
				.execQuery(sqlSdPttp.toString(), null, new BeanListHandler(BlThirdNOWindCheckDTO.class));

		for (BlThirdNOWindCheckDTO blThirdNOWindCheckDTO : listSdPttp) {
			mapSdPttp.put(blThirdNOWindCheckDTO.getSd_pttp(), blThirdNOWindCheckDTO.getName_pttp());
		}
		return mapSdPttp;
	}

	/**
	 * 查询 支付场景名称
	 * 
	 * @return
	 * @throws DAException
	 */
	private Map<String, String> getSdBizsceneName() throws DAException {
		Map<String, String> mapSdBizscene = new HashMap<String, String>();
		// 查询合计
		StringBuffer sqlSdBizscene = new StringBuffer();
		sqlSdBizscene.append(
				"    select udi.code Sd_bizscene,udi.name  Name_bizscene  from bd_udidoc udi where udi.id_udidoclist ='@@@@BZ400000000001UY' ");
		@SuppressWarnings("unchecked")
		List<BlThirdNOWindCheckDTO> listSdPttp = (List<BlThirdNOWindCheckDTO>) new DAFacade()
				.execQuery(sqlSdBizscene.toString(), null, new BeanListHandler(BlThirdNOWindCheckDTO.class));

		for (BlThirdNOWindCheckDTO blThirdNOWindCheckDTO : listSdPttp) {
			mapSdBizscene.put(blThirdNOWindCheckDTO.getSd_bizscene(), blThirdNOWindCheckDTO.getName_bizscene());
		}
		return mapSdBizscene;
	}
	/**
	 * 查询支付方式集合
	 * @return
	 * @throws BizException
	 */
	private String getSdpmList() throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append(	"     select Listagg(pm.code, ',') Within Group(Order by pm.code) code_pm  ");
		sql.append("   from bl_trd_trans_reg reg ");
		sql.append("   inner join bd_pri_pm pm on reg.id_pm = pm.id_pm ");
		@SuppressWarnings("unchecked")
		List<BlThirdNOWindCheckDTO> listsdpm = (List<BlThirdNOWindCheckDTO>) new DAFacade()
				.execQuery(sql.toString(), null, new BeanListHandler(BlThirdNOWindCheckDTO.class));
		if(listsdpm==null||listsdpm.size()<=0){
			throw new BizException("第三方交易接口注册数据未维护");
		}
		return listsdpm.get(0).getCode_pm();
	}
	/**
	 * 获取非窗口收付款数据
	 * @param start_time
	 * @param end_time
	 * @param stppt
	 * @param sdpmList 
	 * @return
	 * @throws BizException
	 */
	private List<BlThirdNOWindCheckDTO> getWindowsList(String start_time,String end_time,String  stppt, String sdpmList) throws BizException{
		
		StringBuffer sqlStr = new StringBuffer();
		
		sqlStr.append(
				"   select (payitm.amt * payitm.eu_direct) amt,pat.id_pat,                                                                                   ");
		sqlStr.append(
				"          pat.name name_pat,                                                                                                                         ");
		sqlStr.append(
				"          payitm.sd_pm Code_pm,                                                                                                                     ");
		sqlStr.append(
				"         oep.sd_pttp,                                                                                                              ");

		sqlStr.append(
				"          payitm.paymodenode ord_no,                                                                                                               ");
		sqlStr.append(
				"          payitm.bankno,                                                                                                                    ");
		sqlStr.append("          oep.dt_pay pay_time ,");
		sqlStr.append("   case when stoep.pecode is not null then '08' ");
		sqlStr.append("   when stoep.pecode is not null and stoep.eu_direct = -1 then  '09'  ");
		sqlStr.append(
				"    else     decode( stoep.eu_sttp,'31','06','43','07','30','02','41','03','03') end sd_bizscene                                                            ");
		sqlStr.append(
				"     from pi_pat pat                                                                                                                        ");
		sqlStr.append(
				"    inner join bl_pay_pat_oep oep  on pat.id_pat = oep.id_pat                                                                               ");
		sqlStr.append(
				"    inner join bl_pay_itm_pat_oep payitm   on payitm.id_paypatoep = oep.id_paypatoep                                                        ");
		sqlStr.append(
				"    inner join bl_st_oep stoep on stoep.id_paypatoep = oep.id_paypatoep                                                                     ");
	
		sqlStr.append(
				"                                                                                                                                            ");
		sqlStr.append(
				"  where payitm.sd_pm  in ("+sdpmList+")    and  (oep.dt_pay  between ? and ? )                                                             ");
		if (!StringUtil.isEmpty(stppt)) {
			sqlStr.append("  and oep.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(stppt));
		}
	
		sqlStr.append(
				"  union all                                                                                                                                 ");
		
		sqlStr.append(
				"   select (payip.amt * payip.eu_direct) amt,                                                                                                ");
		sqlStr.append(
				"         pat.id_pat,                                                                                                                        ");
		sqlStr.append(
				"         pat.name name_pat,                                                                                                                          ");
		sqlStr.append(
				"          payip.sd_pm,                                                                                                                      ");
		sqlStr.append(
				"          ip.sd_pttp,                                                                                                                       ");

		sqlStr.append(
				"          payip.paymodenode,                                                                                                                ");
		sqlStr.append(
				"          payip.bankno,                                                                                                                     ");
		sqlStr.append("          ip.dt_pay pay_time ,");
		sqlStr.append(
				"         '05' sdbiz                                                                                                                         ");
		sqlStr.append(
				"     from pi_pat pat                                                                                                                        ");
		sqlStr.append(
				"    inner join bl_pay_pat_ip ip  on pat.id_pat = ip.id_pat                                                                                  ");
		sqlStr.append(
				"    inner join bl_pay_itm_pat_ip payip    on payip.id_paypatip =ip.id_paypatip                                                              ");
		sqlStr.append(
				"    inner join bl_st_ip stip on stip.id_stip = ip.id_stip                                                                                   ");
	
		sqlStr.append(
				"                                                                                                                                            ");
		sqlStr.append(
				" where payip.sd_pm  in ("+sdpmList+")    and (ip.dt_pay  between ? and ? )                                                                 ");
		if (!StringUtil.isEmpty(stppt)) {
			sqlStr.append("  and ip.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(stppt));
		}
	
		sqlStr.append(
				" union all                                                                                                                                  ");
	
		sqlStr.append(
				"   select (prepay.amt * prepay.eu_direct) amt,                                                                                              ");
		sqlStr.append(
				"         pat.id_pat,                                                                                                                        ");
		sqlStr.append(
				"         pat.name name_pat,                                                                                                                          ");
		sqlStr.append(
				"          prepay.sd_pm,                                                                                                                     ");
		sqlStr.append(
				"          prepay.sd_pttp,                                                                                                                   ");
                                                                              
		sqlStr.append(
				"          prepay.paymodenode,                                                                                                               ");
		sqlStr.append(
				"          prepay.bankno,                                                                                                                    ");
		sqlStr.append("          prepay.dt_pay pay_time ,");
		sqlStr.append(
				"         decode(prepay.code_enttp,'00','01','10','04','') sdbiz                                                                             ");
		sqlStr.append(
				"     from pi_pat pat                                                                                                                        ");
		sqlStr.append(
				"    inner join bl_prepay_pat prepay  on pat.id_pat = prepay.id_pat                                                                          ");
		
		sqlStr.append(
				"                                                                                                                                            ");
		sqlStr.append(
				" where prepay.sd_pm  in ("+sdpmList+")    and (prepay.sd_paytp ='11' or prepay.sd_paytp ='12')  and (prepay.dt_pay  between ? and  ?)     ");
		if (!StringUtil.isEmpty(stppt)) {
			sqlStr.append(" and prepay.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(stppt));
		}
		SqlParam sp = new SqlParam();

		sp.addParam(start_time + " 00:00:00");
		sp.addParam(end_time + " 23:59:59");
		sp.addParam(start_time + " 00:00:00");
		sp.addParam(end_time + " 23:59:59");
		sp.addParam(start_time + " 00:00:00");
		sp.addParam(end_time + " 23:59:59");
		@SuppressWarnings("unchecked")
		List<BlThirdNOWindCheckDTO> list = (List<BlThirdNOWindCheckDTO>) new DAFacade().execQuery(sqlStr.toString(), sp,
				new BeanListHandler(BlThirdNOWindCheckDTO.class));
		return list;
		
		
	}

	/**
	 * 获取 在第三方设备支付的在 iih窗口进行退款的 数据
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<BlThirdNOWindCheckDTO> getThirdRefundList(String start_time, String end_time, String stppt,
			String sdpmList) throws BizException {
		// 添加 非窗口支付的 窗口退費的数据
		StringBuffer sqlStr2 = new StringBuffer();

		sqlStr2.append(
				"   select (payitm.amt * payitm.eu_direct) amt,pat.id_pat,                                                                                   ");
		sqlStr2.append(
				"          pat.name name_pat,                                                                                                                         ");
		sqlStr2.append(
				"          payitm.sd_pm Code_pm,                                                                                                                     ");
		sqlStr2.append(
				"         oep.sd_pttp,                                                                                                              ");

		sqlStr2.append(
				"          payitm.paymodenode ord_no,                                                                                                               ");
		sqlStr2.append(
				"          payitm.bankno,                                                                                                                    ");
		sqlStr2.append("          oep.dt_pay pay_time ,");
		sqlStr2.append(
				"         decode( stoep.eu_sttp,'31','06','43','07','30','02','41','03','03') sd_bizscene                                                            ");
		sqlStr2.append(
				"     from pi_pat pat                                                                                                                        ");
		sqlStr2.append(
				"    inner join bl_pay_pat_oep oep  on pat.id_pat = oep.id_pat                                                                               ");
		sqlStr2.append(
				"    inner join bl_pay_itm_pat_oep payitm   on payitm.id_paypatoep = oep.id_paypatoep                                                        ");
		sqlStr2.append(
				"    inner join bl_st_oep stoep on stoep.id_paypatoep = oep.id_paypatoep                                                                     ");

		sqlStr2.append(
				"       inner join bl_st_oep rntstoep on rntstoep.id_stoep =stoep.id_par                                                                       ");
		sqlStr2.append(
				"     inner join bl_pay_pat_oep rntoep  on rntstoep.id_paypatoep =  rntoep.id_paypatoep                                                       ");
		sqlStr2.append(
				"      inner join bl_pay_itm_pat_oep rntpayitm   on rntpayitm.id_paypatoep = rntoep.id_paypatoep                                              ");

		sqlStr2.append("  where payitm.sd_pm  in (" + sdpmList
				+ ")  and  oep.eu_direct =-1    and payitm.fg_realpay='Y' and  rntpayitm.sd_pm  in (" + sdpmList
				+ ")   " + "   and rntoep.eu_direct=1  " + "  and oep.sd_pttp ='01' "
				+ " and  (oep.dt_pay  between ? and ? )                                                             ");
		if (!StringUtil.isEmpty(stppt)) {
			sqlStr2.append("  and rntoep.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(stppt));
		}

		// 添加半退的查询
		sqlStr2.append(
				"  union all                                                                                                                                 ");
		sqlStr2.append(
				"   select (payitm.amt * payitm.eu_direct) amt,pat.id_pat,                                                                                   ");
		sqlStr2.append(
				"          pat.name name_pat,                                                                                                                         ");
		sqlStr2.append(
				"          payitm.sd_pm Code_pm,                                                                                                                     ");
		sqlStr2.append(
				"         oep.sd_pttp,                                                                                                              ");

		sqlStr2.append(
				"          payitm.paymodenode ord_no,                                                                                                               ");
		sqlStr2.append(
				"          payitm.bankno,                                                                                                                    ");
		sqlStr2.append("          oep.dt_pay pay_time ,");
		sqlStr2.append(
				"         decode( stoep.eu_sttp,'31','06','43','07','30','02','41','03','03') sd_bizscene                                                            ");
		sqlStr2.append(
				"     from pi_pat pat                                                                                                                        ");
		sqlStr2.append(
				"    inner join bl_pay_pat_oep oep  on pat.id_pat = oep.id_pat                                                                               ");
		sqlStr2.append(
				"    inner join bl_pay_itm_pat_oep payitm   on payitm.id_paypatoep = oep.id_paypatoep                                                        ");
		sqlStr2.append(
				"    inner join bl_st_oep stoep on stoep.id_paypatoep = oep.id_paypatoep                                                                     ");

		sqlStr2.append(
				"       inner join bl_st_oep rntstoep on rntstoep.id_stoep =stoep.id_par                                                                       ");
		sqlStr2.append(
				"     inner join bl_pay_pat_oep rntoep  on rntstoep.id_paypatoep =  rntoep.id_paypatoep                                                       ");
		sqlStr2.append(
				"      inner join bl_pay_itm_pat_oep rntpayitm   on rntpayitm.id_paypatoep = rntoep.id_paypatoep                                              ");

		sqlStr2.append("  where payitm.sd_pm  in (" + sdpmList
				+ ")  and  oep.eu_direct =1    and payitm.fg_realpay='Y' and  rntpayitm.sd_pm  in (" + sdpmList + ")   "
				+ "   and rntoep.eu_direct=1  " + "  and oep.sd_pttp ='01' "
				+ " and  (oep.dt_pay  between ? and ? )                                                             ");
		if (!StringUtil.isEmpty(stppt)) {
			sqlStr2.append("  and rntoep.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(stppt));
		}
		//住院的
		sqlStr2.append(
				"  union all                                                                                                                                 ");

		sqlStr2.append(
				"   select (payip.amt * payip.eu_direct) amt,                                                                                                ");
		sqlStr2.append(
				"         pat.id_pat,                                                                                                                        ");
		sqlStr2.append(
				"         pat.name name_pat,                                                                                                                          ");
		sqlStr2.append(
				"          payip.sd_pm,                                                                                                                      ");
		sqlStr2.append(
				"          ip.sd_pttp,                                                                                                                       ");

		sqlStr2.append(
				"          payip.paymodenode,                                                                                                                ");
		sqlStr2.append(
				"          payip.bankno,                                                                                                                     ");
		sqlStr2.append("          ip.dt_pay pay_time ,");
		sqlStr2.append(
				"         '05' sdbiz                                                                                                                         ");
		sqlStr2.append(
				"     from pi_pat pat                                                                                                                        ");
		sqlStr2.append(
				"    inner join bl_pay_pat_ip ip  on pat.id_pat = ip.id_pat                                                                                  ");
		sqlStr2.append(
				"    inner join bl_pay_itm_pat_ip payip    on payip.id_paypatip =ip.id_paypatip                                                              ");
		sqlStr2.append(
				"    inner join bl_st_ip stip on stip.id_stip = ip.id_stip                                                                                   ");
		sqlStr2.append(
				"       inner join bl_st_ip rntstip on rntstip.id_stip =stip.id_par                                                                       ");
		sqlStr2.append(
				"     inner join bl_pay_pat_ip rntip  on rntip.id_stip =  rntstip.id_stip                                                       ");
		sqlStr2.append(
				"      inner join bl_pay_itm_pat_ip rntpayitm   on rntpayitm.id_paypatip = rntip.id_paypatip                                              ");

		sqlStr2.append(
				"                                                                                                                                            ");
		sqlStr2.append("  where payip.sd_pm  in (" + sdpmList + ")  and  ip.eu_direct =-1 and payip.fg_realpay='Y'  and  rntpayitm.sd_pm  in ("
				+ sdpmList + ")   " + "   and rntstip.eu_direct=1  " + "  and ip.sd_pttp ='01' "
				+ " and  (ip.dt_pay  between ? and ? )                                                             ");

		if (!StringUtil.isEmpty(stppt)) {
			sqlStr2.append("  and rntip.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(stppt));
		}
		
		sqlStr2.append(
				" union all                                                                                                                                  ");

		sqlStr2.append(
				"   select (prepay.amt * prepay.eu_direct) amt,                                                                                              ");
		sqlStr2.append(
				"         pat.id_pat,                                                                                                                        ");
		sqlStr2.append(
				"         pat.name name_pat,                                                                                                                          ");
		sqlStr2.append(
				"          prepay.sd_pm,                                                                                                                     ");
		sqlStr2.append(
				"          prepay.sd_pttp,                                                                                                                   ");

		sqlStr2.append(
				"          prepay.paymodenode,                                                                                                               ");
		sqlStr2.append(
				"          prepay.bankno,                                                                                                                    ");
		sqlStr2.append("          prepay.dt_pay pay_time ,");
		sqlStr2.append(
				"         decode(prepay.code_enttp,'00','01','10','04','01') sdbiz                                                                             ");
		sqlStr2.append(
				"     from pi_pat pat                                                                                                                        ");
		sqlStr2.append(
				"    inner join bl_prepay_pat prepay  on pat.id_pat = prepay.id_pat                                                                          ");

		sqlStr2.append(
				"      inner join bl_prepay_pat rtn  on prepay.id_par = rtn.id_paypat                                                                                                                                         ");
		sqlStr2.append(" where prepay.sd_pm  in (" + sdpmList
				+ ")    and (prepay.sd_paytp ='11' or prepay.sd_paytp ='12')   and prepay.eu_direct=-1 and rtn.eu_direct=1 and prepay.sd_pttp='01'  "
				+ "and (prepay.dt_pay  between ? and  ? )     ");
		if (!StringUtil.isEmpty(stppt)) {
			sqlStr2.append(" and rtn.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(stppt));
		}

		SqlParam sp2 = new SqlParam();

		sp2.addParam(start_time + " 00:00:00");
		sp2.addParam(end_time + " 23:59:59");
		sp2.addParam(start_time + " 00:00:00");
		sp2.addParam(end_time + " 23:59:59");
		sp2.addParam(start_time + " 00:00:00");
		sp2.addParam(end_time + " 23:59:59");
		sp2.addParam(start_time + " 00:00:00");
		sp2.addParam(end_time + " 23:59:59");
		@SuppressWarnings("unchecked")
		List<BlThirdNOWindCheckDTO> list2 = (List<BlThirdNOWindCheckDTO>) new DAFacade().execQuery(sqlStr2.toString(),
				sp2, new BeanListHandler(BlThirdNOWindCheckDTO.class));
		return list2;
	}
}
