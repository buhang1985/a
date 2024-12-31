package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.pp.samppri.d.BdSampPriItmDO;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.ciappdiriveorreldo.d.CiAppDiriveOrRelDO;
import iih.ci.ord.ciappdiriveorreldo.i.ICiappdiriveorreldoCudService;
import iih.ci.ord.ciappdiriveorreldo.i.ICiappdiriveorreldoRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.i.op.order.ICiOpOrderMainService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.mp.nr.splitplan.i.IResponseOrderHandelService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 删除检验打印数据
 * 
 * @author YANG
 *
 */
public class CiprnDeleteAppLisDataBP {

	public OrderRstDTO exec(String[] idors) throws BizException {
		if (idors == null || idors.length <= 0)
			return null;
		CiAppLisSheetOrDO[] lisSheetOrDOs = CiprnUtils.GetCiAppLisSheetOrDOByIdor(idors);
		if (lisSheetOrDOs == null || lisSheetOrDOs.length <= 0)
			return null;
		List<String> lstIdapplissheet = new ArrayList<String>();
		for (CiAppLisSheetOrDO lisSheetOrDO : lisSheetOrDOs) {
			if (!lstIdapplissheet.contains(lisSheetOrDO.getId_ciapplissheet()))
				lstIdapplissheet.add(lisSheetOrDO.getId_ciapplissheet());
		}
		// 删除打印明细
		CiprnUtils.DeleteCiAppLisSheetOrDO(lisSheetOrDOs);
		// 如果单据内明细已空，则删除单据
		CiapplissheetAggDO[] aggDOs = CiprnUtils
				.GetCiapplissheetAggDOs(lstIdapplissheet.toArray(new String[lstIdapplissheet.size()]));
		List<CiapplissheetAggDO> lstAggDOs_del = new ArrayList<CiapplissheetAggDO>();
		List<CiapplissheetAggDO> lstAggDOs_upt = new ArrayList<CiapplissheetAggDO>();
		if (aggDOs != null && aggDOs.length > 0) {
			for (CiapplissheetAggDO aggDO : aggDOs) {
				if (aggDO.getCiAppLisSheetOrDO().length <= 0) {
					lstAggDOs_del.add(aggDO);
				} else {
					lstAggDOs_upt.add(aggDO);
				}
			}
		}
		if (lstAggDOs_del != null || lstAggDOs_del.size() > 0) {
			CiprnUtils.DeleteCiapplissheetAggDO(lstAggDOs_del.toArray(new CiapplissheetAggDO[lstAggDOs_del.size()]));
		}
		if (lstAggDOs_upt != null || lstAggDOs_upt.size() > 0) {
			this.updateLisSheetDOInfo(lstAggDOs_upt);
		}
		return null;
	}

	public OrderRstDTO exec(String[] idors, OrderOperateDTO arg) throws BizException {
		if (idors == null || idors.length <= 0)
			return null;
		CiAppLisSheetOrDO[] lisSheetOrDOs = CiprnUtils.GetCiAppLisSheetOrDOByIdor(idors);
		if (lisSheetOrDOs == null || lisSheetOrDOs.length <= 0) {
			if (arg != null && arg.getExtension() != null && arg.getExtension().containsKey("SampColPri")) {
				FArrayList sampOrders = (FArrayList) arg.getExtension().get("SampColPri");
				// 医生决定删除采集费
				if (arg.getExtension().containsKey("DoctorOpt")
						&& "0".equals((String) arg.getExtension().get("DoctorOpt"))) {
					List<String> idOrs = new ArrayList<String>();
					for (Object obj : sampOrders) {
						CiOrderDO order = (CiOrderDO) obj;
						idOrs.add(order.getId_or());
					}
					this.deleteOrders(idOrs);
				}
			}
			return null;
		}
		List<String> lstIdapplissheet = new ArrayList<String>();
		// 打印单据和医嘱的关系
		Map<String, List<String>> idappormaps = new HashMap<String, List<String>>();
		for (CiAppLisSheetOrDO lisSheetOrDO : lisSheetOrDOs) {
			String id_appsheet = lisSheetOrDO.getId_ciapplissheet();
			if (!lstIdapplissheet.contains(id_appsheet)) {
				lstIdapplissheet.add(id_appsheet);
			}
			String id_or = lisSheetOrDO.getId_or();
			List<String> idappors = new ArrayList<String>();
			if (idappormaps.containsKey(id_appsheet)) {
				idappors = idappormaps.get(id_appsheet);
			} else {
				idappormaps.put(id_appsheet, idappors);
			}
			idappors.add(id_or);
		}
		// 删除打印明细
		CiprnUtils.DeleteCiAppLisSheetOrDO(lisSheetOrDOs);
		// 如果单据内明细已空，则删除单据
		CiapplissheetAggDO[] aggDOs = CiprnUtils
				.GetCiapplissheetAggDOs(lstIdapplissheet.toArray(new String[lstIdapplissheet.size()]));
		List<CiapplissheetAggDO> lstAggDOs_del = new ArrayList<CiapplissheetAggDO>();
		List<CiapplissheetAggDO> lstAggDOs_upt = new ArrayList<CiapplissheetAggDO>();
		if (aggDOs != null && aggDOs.length > 0) {
			for (CiapplissheetAggDO aggDO : aggDOs) {
				if (aggDO.getCiAppLisSheetOrDO().length <= 0) {
					lstAggDOs_del.add(aggDO);
				} else {
					lstAggDOs_upt.add(aggDO);
				}
			}
			// 撤回的检验医嘱集合
			List<String> ors = new ArrayList<String>();
			if (lstAggDOs_del != null && lstAggDOs_del.size() > 0) {
				CiprnUtils
						.DeleteCiapplissheetAggDO(lstAggDOs_del.toArray(new CiapplissheetAggDO[lstAggDOs_del.size()]));
				//
				List<String> idappsheeets = new ArrayList<String>();
				for (CiapplissheetAggDO aggDO : lstAggDOs_del) {
					CiAppLisSheetDO sheet = aggDO.getParentDO();
					ors.addAll(idappormaps.get(sheet.getId_ciapplissheet()));
					idappsheeets.add(sheet.getId_ciapplissheet());
				}
				// 删除单据对应的容器费和采集费（采集费对应的检验医嘱不存在时）
				deleteContp(idappsheeets);
			}
			if (lstAggDOs_upt != null || lstAggDOs_upt.size() > 0) {
				this.updateLisSheetDOInfo(lstAggDOs_upt);
			}
			// if (lstAggDOs_del != null && lstAggDOs_del.size() > 0) {
			// 删除单据对应采集费（采集费对应的检验医嘱不存在时）
			FArrayList sampOrders = getSampOrders(idors, aggDOs[0].getParentDO().getId_en());
			if (sampOrders != null && sampOrders.size() > 0) {
				FMap2 fmp2 = new FMap2();
				fmp2.put("SampColPri", sampOrders);
				OrderRstDTO rst = new OrderRstDTO();
				rst.setExtension(fmp2);
				return rst;
			}
			// }
		}
		return null;
	}

	/**
	 * 更新总金额
	 * 
	 * @param lstAggDOs
	 * @throws BizException
	 */
	private void updateLisSheetDOInfo(List<CiapplissheetAggDO> lstAggDOs) throws BizException {
		List<CiAppLisSheetDO> lstSheetDOs = new ArrayList<CiAppLisSheetDO>();
		for (CiapplissheetAggDO aggDO : lstAggDOs) {
			CiAppLisSheetDO sheetDO = aggDO.getParentDO();
			CiAppLisSheetOrDO[] sheetOrDOs = aggDO.getCiAppLisSheetOrDO();
			String idors = new String();
			for (CiAppLisSheetOrDO sheetOrDO : sheetOrDOs) {
				idors += "," + sheetOrDO.getId_or();
			}
			sheetDO.setAmt_app_total(CiprnUtils.GetAmt_app(idors.substring(1)));
			lstSheetDOs.add(sheetDO);
		}

		String[] arrayFieldNames = new String[] { CiAppLisSheetDO.AMT_APP_TOTAL };
		new DAFacade().updateDOArray(lstSheetDOs.toArray(new CiAppLisSheetDO[0]), arrayFieldNames);
	}

	/**
	 * 删除容器费
	 * 
	 * @param id_appsheets
	 * @throws BizException
	 */
	private void deleteContp(List<String> id_appsheets) throws BizException {
		if (id_appsheets == null || id_appsheets.size() == 0) {
			return;
		}
		String sql = " select id_or from CI_APP_DIRIVE_OR_REL rel "
				+ "inner join ci_order ci on rel.id_relor = ci.id_or where rel.id_app in ('"
				+ CiOrdUtils.ConcatInSqlMark(id_appsheets) + "') and ci.sd_su_bl<>'1' ";
		SqlParam param = new SqlParam();
		List<String> orders = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		// 删除关联单据
		deleteDirive(id_appsheets);
		if (orders != null && orders.size() > 0) {
			this.deleteOrders(orders);
		}
	}

	/**
	 * 删除采集费,不存在的采集费,删除采集费时要到前台询问医生，因此这个逻辑仅仅是获取到可以删除的采集费
	 * 
	 * @param id_appsheets
	 * @throws BizException
	 */
	private FArrayList getSampOrders(String[] id_ors, String id_en) throws BizException {
		if (id_ors == null || id_ors.length == 0) {
			return null;
		}
		String inOrStrs = CiOrdUtils.ConcatInSqlMark(id_ors);
		String sql = " select distinct c2.id_or,c2.name_or "
				+ "from ci_order c1 "
				+ "  inner join bd_samp_pri pri1 "
				+ "      on c1.id_srv = pri1.id_srv "
				+ "    and c1.id_or in ('"
				+ inOrStrs
				+ "') "
				+ "inner join bd_samp_pri_itm itm1 "
				+ "  on itm1.id_samp_pri = pri1.id_samp_pri "
				+ " inner join ci_order c2 "
				+ "on c2.id_srv=itm1.id_srv "
				+ "and  c2.id_en = ?  and c1.sd_srvtp like '03%' and c1.id_en=c2.id_en "
				+ "where c2.eu_orsrcmdtp=('"+iih.ci.ord.ciorder.d.OrSourceFromEnum.IIHORRELSAMPPRI //医嘱来源方式为采集费的
				+ "') and itm1.eu_pritp = 1 and c2.fg_canc='N' and c2.sd_su_bl <> '1' and itm1.id_srv not in "
				+ "     (select itm.id_srv "
				+ "       from ci_order ci "
				+ "     inner join bd_samp_pri pri "
				+ "    on ci.id_srv = pri.id_srv "
				+ "   inner join bd_samp_pri_itm itm "
				+ "  on itm.id_samp_pri=pri.id_samp_pri "
				+ "  where ci.fg_canc = 'N' and ci.fg_sign='Y' "
				+ "and itm.eu_pritp=1 "
				+ "and ci.id_en = ? "
				+ "and ci.id_or not in ('"
				+ inOrStrs
				+ "') and ci.sd_srvtp like '03%') ";
		SqlParam param = new SqlParam();
		param.addParam(id_en);
		param.addParam(id_en);
		List<CiOrderDO> orders = (List<CiOrderDO>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(CiOrderDO.class));
		if (orders != null && orders.size() > 0) {
			FArrayList sampColIdOrs = new FArrayList();
			sampColIdOrs.addAll(orders);
			return sampColIdOrs;
		}
		return null;
	}

	/**
	 * 删除医嘱的操作
	 * 
	 * @param id_ors
	 * @throws BizException
	 */
	private void deleteOrders(List<String> id_ors) throws BizException {
		ICiOpOrderMainService service = ServiceFinder.find(ICiOpOrderMainService.class);
		OrderOperateDTO arg = new OrderOperateDTO();
		FArrayList list = new FArrayList();
		list.addAll(id_ors);
		arg.setDocument(list);
		service.delete(new CiEnContextDTO(), arg);
	}

	/**
	 * 删除关联单据
	 * 
	 * @param idappsheeets
	 * @throws BizException
	 */
	private void deleteDirive(List<String> idappsheeets) throws BizException {
		if (idappsheeets == null || idappsheeets.size() == 0) {
			return;
		}
		ICiappdiriveorreldoCudService service = ServiceFinder.find(ICiappdiriveorreldoCudService.class);
		ICiappdiriveorreldoRService rService = ServiceFinder.find(ICiappdiriveorreldoRService.class);
		CiAppDiriveOrRelDO[] rels = rService.findByAttrValStrings(CiAppDiriveOrRelDO.ID_APP,
				idappsheeets.toArray(new String[0]));
		service.delete(rels);
	}
}
