package iih.ci.ord.s.bp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.EmsFeesDTO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 就诊费用统计
 * 
 * @author zwq
 *
 */
public class GetPatEntFeesCensusBP {
	private static final String[] szEmsTypeGroup = { IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG,
			IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG, IBdSrvDictCodeConst.SD_SRVTP_RIS, IBdSrvDictCodeConst.SD_SRVTP_LIS,
			IBdSrvDictCodeConst.SD_SRVTP_OP, IBdSrvDictCodeConst.SD_SRVTP_TREAT,
			IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_A ,IBdSrvDictCodeConst.SD_SRVTP_SANI};

	public FMap2 exec(String id_ent, String code_entp, FBoolean fg_pres_outp) throws BizException {

		List<Map<String, Object>> sqlRst = CiOrdUtils.getRsMapList(getQrySql(id_ent, code_entp, fg_pres_outp));
		// 分类汇总
		Map<String, EmsFeesDTO> collectInfoMap = new HashMap<String, EmsFeesDTO>();

		FDouble all = new FDouble(0,8);
		FDouble haspay = new FDouble(0,8);
		for (Map<String, Object> map : sqlRst) {

			String fg_mm = (String) map.get("fg_mm");
			String sd_su_bl = (String) map.get("sd_su_bl");
			// li_cheng 已退费的不计算金额
			if (CiOrdUtils.isEmpty(sd_su_bl) || sd_su_bl.equals(ICiDictCodeConst.SD_SU_BL_REFOUND))
				continue;

			if ("Y".equals(fg_mm)) {
				if(map.get("quan_cur")==null||map.get("price_pgku_cur")==null)
					continue;
				FDouble quan_cur = new FDouble(map.get("quan_cur").toString(),8);
				FDouble price_pgku_cur = new FDouble(map.get("price_pgku_cur").toString(),8);
				FDouble pri = map.containsKey("pri")? new FDouble(CiOrdUtils.isEmpty(map.get("pri").toString())?"0.0":map.get("pri").toString(),8):FDouble.ZERO_DBL;
//				all = all.add(quan_cur.multiply(price_pgku_cur));
			//-------------------------------------------
			//	0145920: 【工单】公司内验证版本，门急诊医生站，开立草药医嘱，金额合计与费用清单金额不一致
			//	all = all.add(quan_cur.multiply(pri));
		    //
				FDouble cur=new FDouble((pri==null?new FDouble(0,8):pri).multiply((quan_cur==null?new FDouble(0,8):quan_cur),8).doubleValue(),8);
//				all = all.add(new FDouble((pri==null?new FDouble(0,8):pri).multiply((quan_cur==null?new FDouble(0,8):quan_cur),8).doubleValue(),8),8);
				//0173902: 【门急诊医生站】未缴费金额与总额不一致   
				//每次计算费用都进行四舍五入
				all=all.add(new FDouble(new BigDecimal(cur.toString()).setScale(2, BigDecimal.ROUND_HALF_UP)));
			//-------------------------------------------	
				if (!CiOrdUtils.isEmpty(sd_su_bl) && sd_su_bl.equals(ICiDictCodeConst.SD_SU_BL_ACCOUNT)) {
					FDouble paycur=new FDouble((price_pgku_cur==null?new FDouble(0,8):price_pgku_cur).multiply((quan_cur==null?new FDouble(0,8):quan_cur),8).doubleValue(),8);
					haspay = haspay.add(new FDouble(new BigDecimal(paycur.toString()).setScale(2, BigDecimal.ROUND_HALF_UP)));
				}

			} else {
				FDouble quan_total_medu = new FDouble(
						map.get("quan_total_medu") == null ? "0" : map.get("quan_total_medu").toString(),8);
				FDouble pri = new FDouble(map.get("pri") == null ? "0" : map.get("pri").toString(),8);
				if (quan_total_medu != null && pri != null) {
					FDouble cur=quan_total_medu.multiply(pri,8);
//					all = all.add(quan_total_medu.multiply(pri,8),8);
					//0173902: 【门急诊医生站】未缴费金额与总额不一致   
					//每次计算费用都进行四舍五入
					all = all.add(new FDouble(new BigDecimal(cur.toString()).setScale(2, BigDecimal.ROUND_HALF_UP)));
					if (!CiOrdUtils.isEmpty(sd_su_bl) && sd_su_bl.equals(ICiDictCodeConst.SD_SU_BL_ACCOUNT)) {
//						haspay = haspay.add(quan_total_medu.multiply(pri,8),8);
						haspay = haspay.add(new FDouble(new BigDecimal(cur.toString()).setScale(2, BigDecimal.ROUND_HALF_UP)));
					}
				}
			}

			String sd_srvtp = (String) map.get("sd_srvtp");
			for (String o : szEmsTypeGroup) {
				if (sd_srvtp.startsWith(o)) {
					handleCollectInfo(map, o, collectInfoMap);
					break;
				}
			}

		}
		FMap2 map2 = new FMap2();
		// 金额显示四舍五入
		// li_cheng 取整模式与费用域同步
		map2.put("NoPay", String.valueOf(new FDouble((new BigDecimal(all.toString()).setScale(2,BigDecimal.ROUND_HALF_UP).subtract(new BigDecimal(haspay.toString()).setScale(2,BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP)))));// 未付金额
		map2.put("AllFees", String.valueOf(new FDouble(new BigDecimal(all.toString()).setScale(2, BigDecimal.ROUND_HALF_UP))));// 全部金额
		map2.put("HasPay", String.valueOf(new FDouble(new BigDecimal(haspay.toString()).setScale(2, BigDecimal.ROUND_HALF_UP))));// 已付金额
		
		// 处理分类汇总
		FArrayList datasource = new FArrayList();
		for (String o : szEmsTypeGroup) {
			if (collectInfoMap.containsKey(o)) {
				EmsFeesDTO fee = collectInfoMap.get(o);
				fee.setNopay(new FDouble(new BigDecimal(fee.getAllfees().toString()).setScale(2,BigDecimal.ROUND_HALF_UP).subtract(new BigDecimal(fee.getHaspay().toString()).setScale(2,BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_DOWN)));
				fee.setAllfees(fee.getAllfees().setScale(-2, BigDecimal.ROUND_HALF_UP));
				fee.setHaspay(fee.getHaspay().setScale(-2, BigDecimal.ROUND_HALF_UP));
				datasource.add(fee);
			}
		}
		map2.put("group", datasource);// 分组统计
		return map2;
	}

	private void handleCollectInfo(Map<String, Object> map, String sd_srvtp, Map<String, EmsFeesDTO> collectInfoMap) {
		EmsFeesDTO fee = null;
		String fg_mm = (String) map.get("fg_mm");
		if (!collectInfoMap.containsKey(sd_srvtp)) {
			fee = new EmsFeesDTO();
			fee.setAllfees(FDouble.ZERO_DBL);
			fee.setHaspay(FDouble.ZERO_DBL);
			fee.setNopay(FDouble.ZERO_DBL);
			collectInfoMap.put(sd_srvtp, fee);
		} else {
			fee = (EmsFeesDTO) collectInfoMap.get(sd_srvtp);
		}
		// 处理物品汇总信息
		if ("Y".equals(fg_mm)) {
			fee.setAllfees(fee.getAllfees().add(this.getMMCollectFee(map)));
			fee.setHaspay(fee.getHaspay().add(this.getMMHasPayFee(map)));
		} else {
			fee.setAllfees(fee.getAllfees().add(this.getSrvCollectFee(map)));
			fee.setHaspay(fee.getHaspay().add(this.getSrvHasPayFee(map)));
		}
		fee.setName((String) map.get("sd_srvtp_name"));
	}

	protected String getQrySql(String id_ent, String code_entp, FBoolean fg_pres_outp) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"select ord.sd_srvtp,  srv.fg_mm,srv.sd_su_bl,srv.quan_total_medu,srv.pri,mm.quan_cur,mm.price_pgku_cur,");
		sb.append(
				" decode(substr(ord.sd_srvtp,1,2),'01',substr(ord.sd_srvtp,1,4),'14',substr(ord.sd_srvtp,1,4),substr(ord.sd_srvtp,1,2)) as sd_srvtp_udidoc "); // 获取服务的显示名称01,14取4位，其余取两位
		sb.append(" from ci_order ord left join ci_or_srv srv on ord.id_or=srv.id_or left join ci_or_srv_mm mm");
		sb.append(" on srv.id_orsrv = mm.id_orsrv");
		sb.append(String.format(" where ord.fg_canc='N' and ord.eu_orsrcmdtp not in ('" + OrSourceFromEnum.IIHMEDTECHORDERS
				+ "') and ord.id_en='%s' and srv.fg_bl='Y' and ord.code_entp='%s'", id_ent, code_entp));
		if (CiOrdUtils.isEmpty(fg_pres_outp) || !fg_pres_outp.booleanValue()) {
			sb.append(" and srv.fg_pres_outp='N'");
		} else {
			sb.append(" and srv.fg_pres_outp='Y'");
		}

		// 调整价格分类名称通过服务类型的扩展字段ctrl2展现
		String sql = "select ord.*,doc.ctrl2 as sd_srvtp_name from (" + sb.toString()
				+ ") ord left join bd_udidoc doc on doc.id_udidoclist = '" + IBdFcDictCodeConst.ID_CODE_SRVTP
				+ "' and doc.code = ord.sd_srvtp_udidoc";
		return sql;// sb.toString();
	}

	/**
	 * 物品合计
	 * 
	 * @param map
	 * @return
	 */
	private FDouble getMMCollectFee(Map<String, Object> map) {
		FDouble quan_cur = new FDouble(map.get("quan_cur").toString(),8);
//		FDouble price_pgku_cur = new FDouble(map.get("price_pgku_cur").toString());
		FDouble pri = map.containsKey("pri")? new FDouble(CiOrdUtils.isEmpty(map.get("pri").toString())?"0.0":map.get("pri").toString(),8):FDouble.ZERO_DBL;
		if (quan_cur != null && pri != null) {
			FDouble cur= quan_cur.multiply(pri,4);
			return new FDouble(new BigDecimal(cur.toString()).setScale(2, BigDecimal.ROUND_HALF_UP));
//			return (quan_cur.multiply(pri,4));
			
		}
		return FDouble.ZERO_DBL;
	}

	/**
	 * 物品已付费
	 * 
	 * @param map
	 * @return
	 */
	private FDouble getMMHasPayFee(Map<String, Object> map) {
		if(map.get("sd_su_bl")==null||map.get("quan_cur")==null||map.get("price_pgku_cur")==null)
			return FDouble.ZERO_DBL;
		String sd_su_bl = (String) map.get("sd_su_bl");
		FDouble quan_cur = new FDouble(map.get("quan_cur").toString(),8);
//		FDouble price_pgku_cur = new FDouble(map.get("price_pgku_cur").toString());
		FDouble pri = map.containsKey("pri")? new FDouble(CiOrdUtils.isEmpty(map.get("pri").toString())?"0.0":map.get("pri").toString(),8):FDouble.ZERO_DBL;
		if (quan_cur != null && pri != null) {
			if (ICiDictCodeConst.SD_SU_BL_ACCOUNT.equals(sd_su_bl)) {
				FDouble cur= quan_cur.multiply(pri,8);
				return new FDouble(new BigDecimal(cur.toString()).setScale(2, BigDecimal.ROUND_HALF_UP));
//				return (quan_cur.multiply(pri,8));
			}
		}
		return FDouble.ZERO_DBL;
	}

	/**
	 * 计算合计金额
	 * 
	 * @param map
	 * @return
	 */
	private FDouble getSrvCollectFee(Map<String, Object> map) {
		if(map.get("quan_total_medu")==null)
			return FDouble.ZERO_DBL;
		FDouble quan_total_medu = new FDouble(map.get("quan_total_medu").toString(),8);
		FDouble pri = new FDouble(map.get("pri") == null ? "0" : map.get("pri").toString(),8);
		if (quan_total_medu != null && pri != null) {
			FDouble cur= quan_total_medu.multiply(pri,8);
			return new FDouble(new BigDecimal(cur.toString()).setScale(2, BigDecimal.ROUND_HALF_UP));
//			return (quan_total_medu.multiply(pri,8));
		}
		return FDouble.ZERO_DBL;
	}

	/**
	 * 计算已付费金额
	 * 
	 * @param map
	 * @return
	 */
	private FDouble getSrvHasPayFee(Map<String, Object> map) {
		if(map.get("quan_total_medu")==null)
			return FDouble.ZERO_DBL;
		FDouble quan_total_medu = new FDouble(map.get("quan_total_medu").toString(),8);
		FDouble pri = new FDouble(map.get("pri") == null ? "0" : map.get("pri").toString(),8);
		String sd_su_bl = (String) map.get("sd_su_bl");
		if (quan_total_medu != null && pri != null) {

			if (ICiDictCodeConst.SD_SU_BL_ACCOUNT.equals(sd_su_bl)) {
				FDouble cur= quan_total_medu.multiply(pri,8);
				return new FDouble(new BigDecimal(cur.toString()).setScale(2, BigDecimal.ROUND_HALF_UP));
//				return (quan_total_medu.multiply(pri,8));
			}
		}
		return FDouble.ZERO_DBL;

	}

}
