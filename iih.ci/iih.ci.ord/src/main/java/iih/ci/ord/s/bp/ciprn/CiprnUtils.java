package iih.ci.ord.s.bp.ciprn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.app.d.CiAppBuSheetDO;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import iih.ci.ord.app.d.CiAppTreatExecOrDO;
import iih.ci.ord.app.d.CiappbtsheetAggDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.app.d.CiapppathgysheetAggDO;
import iih.ci.ord.app.d.CiapprissheetAggDO;
import iih.ci.ord.app.d.CiapptreatexecAggDO;
import iih.ci.ord.app.i.ICiAppLisSheetOrDOCudService;
import iih.ci.ord.app.i.ICiAppLisSheetOrDORService;
import iih.ci.ord.app.i.ICiAppTreatExecOrDOCudService;
import iih.ci.ord.app.i.ICiAppTreatExecOrDORService;
import iih.ci.ord.app.i.ICiappbtsheetCudService;
import iih.ci.ord.app.i.ICiappbtsheetRService;
import iih.ci.ord.app.i.ICiappbusheetCudService;
import iih.ci.ord.app.i.ICiappbusheetRService;
import iih.ci.ord.app.i.ICiapplissheetCudService;
import iih.ci.ord.app.i.ICiapplissheetMDOCudService;
import iih.ci.ord.app.i.ICiapplissheetMDORService;
import iih.ci.ord.app.i.ICiapplissheetRService;
import iih.ci.ord.app.i.ICiapppathgysheetCudService;
import iih.ci.ord.app.i.ICiapppathgysheetMDOCudService;
import iih.ci.ord.app.i.ICiapppathgysheetMDORService;
import iih.ci.ord.app.i.ICiapppathgysheetRService;
import iih.ci.ord.app.i.ICiapprissheetCudService;
import iih.ci.ord.app.i.ICiapprissheetMDOCudService;
import iih.ci.ord.app.i.ICiapprissheetMDORService;
import iih.ci.ord.app.i.ICiapptreatexecCudService;
import iih.ci.ord.app.i.ICiapptreatexecMDOCudService;
import iih.ci.ord.app.i.ICiapptreatexecMDORService;
import iih.ci.ord.app.i.ICiapptreatexecRService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.cior.i.ICiorappbuRService;
import iih.ci.ord.cior.i.ICiorapppathgyRService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.d.CiPrnItmDO;
import iih.ci.ord.ciprn.d.CiprintAggDO;
import iih.ci.ord.ciprn.i.ICiPrnItmDOCudService;
import iih.ci.ord.ciprn.i.ICiPrnItmDORService;
import iih.ci.ord.ciprn.i.ICiprintCudService;
import iih.ci.ord.ciprn.i.ICiprintMDOCudService;
import iih.ci.ord.ciprn.i.ICiprintMDORService;
import iih.ci.ord.ciprn.i.ICiprintRService;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.i.IPresCudService;
import iih.ci.ord.pres.i.IPresRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ciprn.qry.GetCiOrderDOQry;
import iih.ci.ord.s.bp.ciprn.qry.GetCiPresDOQry;
import iih.ci.ord.s.bp.ciprn.qry.GetCiPrnItmDOQry;
import iih.ci.ord.s.bp.ciprn.qry.GetOrdSrvDOQry;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 打印静态方法类
 * @author Young
 *
 */
public class CiprnUtils {

	//医嘱费用清单数据范围设置参数CiOrChargeListDataRangeSe
	//01 申请单模式下的临床项目费用	
	private static final String STRWHERE_APP_CI = " (ci_order.Fg_quickwflow='N' and ci_or_srv.Eu_sourcemd in (0,8,2)) ";
	//02 申请单模式下的治疗操作费用
	private static final String STRWHERE_APP_EX = " (ci_order.Fg_quickwflow='N' and (ci_or_srv.Eu_sourcemd not in (0,8,2) or ci_or_srv.Eu_sourcemd is null)) ";
	//03 治疗费用模式下的临床项目费用
	private static final String STRWHERE_TREATE_CI = " (ci_order.Fg_quickwflow='Y' and ci_or_srv.Eu_sourcemd in (0,8,2)) ";
	//04 治疗费用模式下的治疗操作费用
	private static final String STRWHERE_TREATE_EX = " (ci_order.Fg_quickwflow='Y' and (ci_or_srv.Eu_sourcemd not in (0,8,2) or ci_or_srv.Eu_sourcemd is null)) ";
	private static HashMap<String, String> mapDataRange = new HashMap<String, String>() {
		{
			put("01", STRWHERE_APP_CI);
			put("02", STRWHERE_APP_EX);
			put("03", STRWHERE_TREATE_CI);
			put("04", STRWHERE_TREATE_EX);
		}
	};

	/**
	 * 由ID查询医嘱DO
	 * 
	 * @param idor
	 * @return
	 * @throws BizException
	 */
	public static CiOrderDO GetCiOrderDOById(String idor) throws BizException {
		ICiorderMDORService ciorderMDORService = ServiceFinder.find(ICiorderMDORService.class);
		return ciorderMDORService.findById(idor);
	}

	/**
	 * 由ID查询医嘱DO集合
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static CiOrderDO[] GetCiOrderDOByIds(String[] idors) throws BizException {
		ICiorderMDORService ciorderMDORService = ServiceFinder.find(ICiorderMDORService.class);
		return ciorderMDORService.findByIds(idors, FBoolean.FALSE);
	}
	
	/**
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static CiOrderDO[] GetCiOrderDOByIds(List<String> idors) throws BizException {
		String strIdors = "";
		for (String idor : idors) {
			if (!strIdors.contains(idor))
				strIdors += ",'" + idor + "'";
		}
		
		ITransQry qry = new GetCiOrderDOQry(strIdors.substring(1));
		return (CiOrderDO[])AppFwUtil.getDORstWithDao(qry, CiOrderDO.class);
	}
	
	/**
	 * 由ID查询医嘱服务信息
	 * 
	 * @param orsrvids
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvDO[] GetOrdSrvDOById(String[] idorsrvs) throws BizException {
		IOrdSrvDORService orsrvrservice = ServiceFinder.find(IOrdSrvDORService.class);
		return orsrvrservice.findByIds(idorsrvs, FBoolean.FALSE);
	}

	/**
	 * 由医嘱ID查询医嘱服务信息
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvDO[] GetOrdSrvDOByIdor(String[] idors) throws BizException {
		String strIdors = "";
		for (String idor : idors) {
			if (!strIdors.contains(idor))
				strIdors += ",'" + idor + "'";
		}

		IOrdSrvDORService orsrvrservice = ServiceFinder.find(IOrdSrvDORService.class);
		return orsrvrservice.find(" id_or in (" + strIdors.substring(1) + ")", "",
				FBoolean.FALSE);
	}
	
	/**
	 * 由医嘱ID查询医嘱服务信息
	 * 
	 * @param strIdors
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvDO[] GetOrdSrvDOByIdor(String strIdors) throws BizException {
		IOrdSrvDORService orsrvrservice = ServiceFinder.find(IOrdSrvDORService.class);
		return orsrvrservice.find(" id_or in (" + strIdors + ")", "",
				FBoolean.FALSE);
	}

	/**
	 * 诊疗收费清单服务数据查询
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvDO[] GetOrdSrvDOByIdorFee(String[] idors) throws BizException {
		String strIdors = "";
		for (String idor : idors) {
			if (!strIdors.contains(idor))
				strIdors += ",'" + idor + "'";
		}

		ITransQry qry = new GetOrdSrvDOQry(strIdors.substring(1));
		OrdSrvDO[] srvDOs = (OrdSrvDO[]) AppFwUtil.getDORstWithDao(qry, OrdSrvDO.class);

		return srvDOs;
	}
	
	/**
	 * 获取处方信息
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static CiPresDO[] GetCiPresDOs(String sql) throws BizException{
		IPresRService rService = ServiceFinder.find(IPresRService.class);
		CiPresDO[] presDOs = rService.find(sql, "", FBoolean.FALSE);
		return presDOs;
	}
	/**
	 * 获取处方信息
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static CiPresDO[] GetCiPresDOs(String[] ids) throws BizException{
		IPresRService rService = ServiceFinder.find(IPresRService.class);
		CiPresDO[] presDOs = rService.findByIds(ids, FBoolean.FALSE);
		return presDOs;
	}
	/**
	 * 
	 * @param ids_pres
	 * @return
	 * @throws BizException
	 */
	public static CiPresDO[] GetCiPresDOs(List<String> ids_pres) throws BizException{
		String strIdpres = "";
		for (String id : ids_pres) {
			if (!strIdpres.contains(id))
				strIdpres += ",'" + id + "'";
		}
		
		ITransQry qry = new GetCiPresDOQry(strIdpres.substring(1));
		return (CiPresDO[]) AppFwUtil.getDORstWithDao(qry, CiPresDO.class);
	}
	/**
	 * 更新处方信息
	 * @param presDOs
	 * @return
	 * @throws BizException
	 */
	public static CiPresDO[] UpdateCiPresDOs(CiPresDO[] presDOs) throws BizException{
		IPresCudService sService = ServiceFinder.find(IPresCudService.class);
		return sService.update(presDOs);
	}
	
	/**
	 * 由医嘱服务ID查询诊疗收费清单打印明细信息（Printed or Not Printed）
	 * 
	 * @param idorsrvs
	 * @param isPrn 是否打印过
	 * @return
	 * @throws BizException
	 */
	public static CiPrnItmDO[] GetCiPrnItmDOByIdorsrv(List<String> idorsrvs, boolean isPrn) throws BizException {
		String stridsrvs = "";
		for (String idorsrv : idorsrvs) {
			stridsrvs += "'" + idorsrv + "',";
		}
		ITransQry qry = new GetCiPrnItmDOQry(stridsrvs.substring(0, stridsrvs.length() - 1), isPrn);
		CiPrnItmDO[] ciPrnItmDOs = (CiPrnItmDO[]) AppFwUtil.getDORstWithDao(qry, CiPrnItmDO.class);

		return ciPrnItmDOs;
	}
	/**
	 * 由医嘱服务ID查询诊疗收费清单打印明细信息（ALL）
	 * 
	 * @param idorsrvs
	 * @return
	 * @throws BizException
	 */
	public static CiPrnItmDO[] GetCiPrnItmDOByIdorsrv(List<String> idorsrvs) throws BizException {
		String stridsrvs = "";
		for (String idorsrv : idorsrvs) {
			stridsrvs += "'" + idorsrv + "',";
		}
		ICiPrnItmDORService ciprnitmrservice = ServiceFinder.find(ICiPrnItmDORService.class);
		CiPrnItmDO[] ciPrnItmDOs = ciprnitmrservice.find(
				" a1.id_biz in (" + stridsrvs.substring(0, stridsrvs.length() - 1) + ")", null, FBoolean.FALSE);

		return ciPrnItmDOs;
	}
	/**
	 * 由打印单据ID查询诊疗收费清单打印明细信息（ALL）
	 * 
	 * @param stridciprns
	 * @return
	 * @throws BizException
	 */
	public static CiPrnItmDO[] GetCiPrnItmDOByIdprn(String stridciprns) throws BizException {
		ICiPrnItmDORService ciprnitmrservice = ServiceFinder.find(ICiPrnItmDORService.class);
		CiPrnItmDO[] ciPrnItmDOs = ciprnitmrservice.find(
				" a1.id_ciprn in (" + stridciprns.substring(0, stridciprns.length() - 1) + ")", null, FBoolean.FALSE);

		return ciPrnItmDOs;
	}
	/**
	 * 删除诊疗收费清单打印明细信息DO集合
	 * 
	 * @param itmDOS
	 * @throws BizException
	 */
	public static void DeleteCiPrnItmDO(CiPrnItmDO[] itmDOS) throws BizException {
		ICiPrnItmDOCudService service = ServiceFinder.find(ICiPrnItmDOCudService.class);
		service.delete(itmDOS);
	}
	/**
	 * 由ID查询诊疗收费清单打印信息AggDO
	 * 
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	public static CiprintAggDO[] GetCiprintAggDOs(String[] ids) throws BizException {
		ICiprintRService service = ServiceFinder.find(ICiprintRService.class);
		return service.findByIds(ids, FBoolean.FALSE);
	}
	/**
	 * 删除诊疗收费清单打印信息AggDO集合
	 * 
	 * @param aggdos
	 * @throws BizException
	 */
	public static void DeleteCiprintAggDO(CiprintAggDO[] aggdos) throws BizException {
		ICiprintCudService printCudservice = ServiceFinder.find(ICiprintCudService.class);
		printCudservice.delete(aggdos);
	}

	/**
	 * 保存诊疗收费清单打印信息AggDO集合
	 * 
	 * @param aggDOs
	 * @return
	 * @throws BizException
	 */
	public static CiprintAggDO[] SaveCiprintAggDO(CiprintAggDO[] aggDOs) throws BizException {
		ICiprintCudService printCudservice = ServiceFinder.find(ICiprintCudService.class);
		return printCudservice.save(aggDOs);
	}
	/**
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static CiPrnDO[] GetCiPrnDOs(String sql) throws BizException{
		ICiprintMDORService rService = ServiceFinder.find(ICiprintMDORService.class);
		CiPrnDO[] prnDOs = rService.find(sql, "", FBoolean.FALSE);
		return prnDOs;
	}
	/**
	 * 
	 * @param prnDOs
	 * @return
	 * @throws BizException
	 */
	public static CiPrnDO[] UpdateCiPrnDOs(CiPrnDO[] prnDOs) throws BizException{
		ICiprintMDOCudService sService = ServiceFinder.find(ICiprintMDOCudService.class);
		return sService.update(prnDOs);
	}

	/**
	 * 由医嘱ID查询诊疗执行单（注射治疗单）打印明细信息
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static CiAppTreatExecOrDO[] GetTreatExecOrDOByIdor(String[] idors) throws BizException {
		String stridors = "";
		for (String idor : idors) {
			stridors += ",'" + idor + "'";
		}

		ICiAppTreatExecOrDORService service = ServiceFinder.find(ICiAppTreatExecOrDORService.class);
		CiAppTreatExecOrDO[] treatExecOrDODOs = service.find(
				" a1.id_or in (" + stridors.substring(1) + ")", null, FBoolean.FALSE);

		return treatExecOrDODOs;
	}
	/**
	 * 由ID查询诊疗执行单（注射治疗单）打印信息AggDO
	 * 
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	public static CiapptreatexecAggDO[] GetCiapptreatexecAggDOs(String[] ids) throws BizException {
		ICiapptreatexecRService service = ServiceFinder.find(ICiapptreatexecRService.class);
		return service.findByIds(ids, FBoolean.FALSE);
	}
	/**
	 * 保存诊疗执行单（注射治疗单）打印信息AggDO集合
	 * 
	 * @param aggDOs
	 * @return
	 * @throws BizException
	 */
	public static CiapptreatexecAggDO[] SaveCiapptreatexecAggDO(CiapptreatexecAggDO[] aggDOs) throws BizException {
		ICiapptreatexecCudService service = ServiceFinder.find(ICiapptreatexecCudService.class);
		return service.save(aggDOs);
	}
	/**
	 * 删除诊疗执行单（注射治疗单）打印信息AggDO集合
	 * 
	 * @param aggdos
	 * @throws BizException
	 */
	public static void DeleteCiapptreatexecAggDO(CiapptreatexecAggDO[] aggdos) throws BizException {
		ICiapptreatexecCudService service = ServiceFinder.find(ICiapptreatexecCudService.class);
		service.delete(aggdos);
	}
	/**
	 * 删除诊疗执行单（注射治疗单）打印明细信息DO集合
	 * 
	 * @param itmDOS
	 * @throws BizException
	 */
	public static void DeleteCiAppTreatExecOrDO(CiAppTreatExecOrDO[] itmDOS) throws BizException {
		ICiAppTreatExecOrDOCudService service = ServiceFinder.find(ICiAppTreatExecOrDOCudService.class);
		service.delete(itmDOS);
	}
	/**
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static CiAppTreatExecDO[] GetCiAppTreatExecDOs(String sql) throws BizException{
		ICiapptreatexecMDORService rService = ServiceFinder.find(ICiapptreatexecMDORService.class);
		CiAppTreatExecDO[] treateDOs = rService.find(sql, "", FBoolean.FALSE);
		return treateDOs;
	}
	/**
	 * 
	 * @param treateDOs
	 * @return
	 * @throws BizException
	 */
	public static CiAppTreatExecDO[] UpdateCiAppTreatExecDOs(CiAppTreatExecDO[] treateDOs) throws BizException{
		ICiapptreatexecMDOCudService sService = ServiceFinder.find(ICiapptreatexecMDOCudService.class);
		return sService.update(treateDOs);
	}

	/**
	 * 由ID查询检验合单打印信息AggDO
	 * 
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	public static CiapplissheetAggDO[] GetCiapplissheetAggDOs(String[] ids) throws BizException {
		ICiapplissheetRService service = ServiceFinder.find(ICiapplissheetRService.class);
		return service.findByIds(ids, FBoolean.FALSE);
	}
	/**
	 * 删除检验合单打印信息AggDO集合
	 * 
	 * @param aggdos
	 * @throws BizException
	 */
	public static void DeleteCiapplissheetAggDO(CiapplissheetAggDO[] aggdos) throws BizException {
		ICiapplissheetCudService service = ServiceFinder.find(ICiapplissheetCudService.class);
		service.delete(aggdos);
	}
	/**
	 * 由医嘱ID查询检验合单打印明细信息
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static CiAppLisSheetOrDO[] GetCiAppLisSheetOrDOByIdor(String[] idors) throws BizException {
		String stridors = "";
		for (String idor : idors) {
			stridors += "'" + idor + "',";
		}

		ICiAppLisSheetOrDORService service = ServiceFinder.find(ICiAppLisSheetOrDORService.class);
		CiAppLisSheetOrDO[] lisSheetOrDOs = service.find(
				" a1.id_or in (" + stridors.substring(0, stridors.length() - 1) + ")", null, FBoolean.FALSE);

		return lisSheetOrDOs;
	}
	/**
	 * 删除检验合单打印明细信息DO集合
	 * 
	 * @param itmDOS
	 * @throws BizException
	 */
	public static void DeleteCiAppLisSheetOrDO(CiAppLisSheetOrDO[] itmDOS) throws BizException {
		ICiAppLisSheetOrDOCudService service = ServiceFinder.find(ICiAppLisSheetOrDOCudService.class);
		service.delete(itmDOS);
	}
	/**
	 * 查询检查打印信息AggDO集合
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static CiAppLisSheetDO[] GetCiAppLisSheetDOs(String sql) throws BizException{
		ICiapplissheetMDORService rService = ServiceFinder.find(ICiapplissheetMDORService.class);
		CiAppLisSheetDO[] lisDOs = rService.find(sql, "", FBoolean.FALSE);
		return lisDOs;
	}
	/**
	 * 更新检查打印信息AggDO集合
	 * @param lisDOs
	 * @return
	 * @throws BizException
	 */
	public static CiAppLisSheetDO[] UpdateCiAppLisSheetDOs(CiAppLisSheetDO[] lisDOs) throws BizException{
		ICiapplissheetMDOCudService sService = ServiceFinder.find(ICiapplissheetMDOCudService.class);
		return sService.update(lisDOs);
	}

	/**
	 * 查询检查申请单DO集合
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static OrdApObsDO[] GetOrdApObsDOs(String id_ors) throws BizException {
		ICiorapprisRService service = ServiceFinder.find(ICiorapprisRService.class);
		String inWhereStr = CiOrdUtils.getSqlInStrsWithOutIn(id_ors);
		return service.find(" id_or in "+inWhereStr, "", FBoolean.FALSE);
	}
	/**
	 * 由医嘱ID查询检查打印信息
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static CiAppRisSheetDO[] GetCiAppRisSheetDOsByIdor(String[] idors) throws BizException{
		String stridors="";
		for (String idor : idors) {
			stridors += ",'" + idor + "'";
		}
		ICiapprissheetMDORService risrservice = ServiceFinder.find(ICiapprissheetMDORService.class);
		CiAppRisSheetDO[] rissheets = risrservice.find(" id_or in (" + stridors.substring(1)+ ")", "", FBoolean.FALSE);
		
		return rissheets;
	}
	/**
	 * 由医嘱ID查询检查打印信息
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static CiAppRisSheetDO[] GetCiAppRisSheetDOs(String sql) throws BizException{
		ICiapprissheetMDORService rService = ServiceFinder.find(ICiapprissheetMDORService.class);
		CiAppRisSheetDO[] risDOs = rService.find(sql, "", FBoolean.FALSE);
		return risDOs;
	}
	/**
	 * 保存检查打印信息
	 * @param ciAppRisSheetDOs
	 * @throws BizException
	 */
	public static CiapprissheetAggDO[] SaveCiAppRisSheetDOs(CiapprissheetAggDO[] aggdos) throws BizException{
		ICiapprissheetCudService service = ServiceFinder.find(ICiapprissheetCudService.class);
		return service.save(aggdos);
	}
	/**
	 * 更新检查打印信息
	 * @param ciAppRisSheetDOs
	 * @throws BizException
	 */
	public static CiAppRisSheetDO[] UpdateCiAppRisSheetDOs(CiAppRisSheetDO[] ciAppRisSheetDOs) throws BizException{
		ICiapprissheetMDOCudService rissheetCudService = ServiceFinder.find(ICiapprissheetMDOCudService.class);
		return rissheetCudService.update(ciAppRisSheetDOs);
	}
	/**
	 * 删除检查打印信息
	 * @param ciAppRisSheetDOs
	 * @throws BizException
	 */
	public static void DeleteCiAppRisSheetDOs(CiAppRisSheetDO[] ciAppRisSheetDOs) throws BizException{
		ICiapprissheetCudService riscudservice = ServiceFinder.find(ICiapprissheetCudService.class);
		riscudservice.deleteByParentDO(ciAppRisSheetDOs);
	}
	
	/**
	 * 查询病理申请单AggDO集合
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static CiorapppathgyAggDO[] GetCiorapppathgyAggDOs(String sql) throws BizException{
		ICiorapppathgyRService rService = ServiceFinder.find(ICiorapppathgyRService.class);
		return rService.find(" id_or in (" + sql + ")", "", FBoolean.FALSE);
	}
	/**
	 * 由医嘱ID查询病理打印信息AggDO集合
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static CiapppathgysheetAggDO[] GetCiapppathgysheetAggDOsByIdor(String[] idors) throws BizException{
		String stridors="";
		for (String idor : idors) {
			stridors += "'" + idor + "',";
		}
		ICiapppathgysheetRService rService = ServiceFinder.find(ICiapppathgysheetRService.class);
		CiapppathgysheetAggDO[] aggDOs=rService.find(" id_or in (" + stridors.substring(0, stridors.length() - 1)
				+ ")", "", FBoolean.FALSE);
		
		return aggDOs;
	}
	/**
	 * 保存病理打印信息AggDO集合
	 * @param ciorapppathgyAggDOs
	 * @throws BizException
	 */
	public static void SaveCiorapppathgyAggDOs(CiapppathgysheetAggDO[] ciapppathgysheetAggDOs) throws BizException{
		ICiapppathgysheetCudService sService = ServiceFinder.find(ICiapppathgysheetCudService.class);
		sService.save(ciapppathgysheetAggDOs);
	}
	/**
	 * 删除病理打印信息AggDO集合
	 * @param ciapppathgysheetAggDOs
	 * @throws BizException
	 */
	public static void DeleteCiapppathgysheetAggDOs(CiapppathgysheetAggDO[] ciapppathgysheetAggDOs) throws BizException{
		ICiapppathgysheetCudService sService = ServiceFinder.find(ICiapppathgysheetCudService.class);
		sService.delete(ciapppathgysheetAggDOs);
	}
	/**
	 * 查询病理打印信息AggDO集合
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static CiAppPathgySheetDO[] GetCiAppPathgySheetDOs(String sql) throws BizException{
		ICiapppathgysheetMDORService rService = ServiceFinder.find(ICiapppathgysheetMDORService.class);
		CiAppPathgySheetDO[] pathgyDOs = rService.find(sql, "", FBoolean.FALSE);
		return pathgyDOs;
	}
	/**
	 * 更新病理打印信息AggDO集合
	 * @param pathgyDOs
	 * @return
	 * @throws BizException
	 */
	public static CiAppPathgySheetDO[] UpdateCiAppPathgySheetDOs(CiAppPathgySheetDO[] pathgyDOs) throws BizException{
		ICiapppathgysheetMDOCudService sService = ServiceFinder.find(ICiapppathgysheetMDOCudService.class);
		return sService.update(pathgyDOs);
	}
	
	/**
	 * 查询备血申请单AggDO集合
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static CiorappbtAggDO[] GetCiorappbtAggDOs(String sql)
			throws BizException {
		ICiorappbtRService service = ServiceFinder.find(ICiorappbtRService.class);
		return service.find(" id_or in (" + sql + ")", "", FBoolean.FALSE);
	}
	/**
	 * 查询备血申请单DO集合
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static OrdApBtDO[] GetOrdApBtDOs(String sql) 
			throws BizException {
		ICiorappbtMDORService service = ServiceFinder.find(ICiorappbtMDORService.class);
		return service.find(" id_or in (" + sql + ")", "", FBoolean.FALSE);
	}
	/**
	 * 保存备血申请单打印数据
	 * @param ciorappbtAggDOs
	 * @throws BizException
	 */
	public static void SaveCiappbtsheetAggDOs(CiappbtsheetAggDO[] ciappbtsheetAggDOs) 
			throws BizException{
		ICiappbtsheetCudService service = ServiceFinder.find(ICiappbtsheetCudService.class);
		service.save(ciappbtsheetAggDOs);
	}
	/**
	 * 查询取血申请单打印AggDO集合
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static CiAppBuSheetDO[] GetCiAppBuSheetDOsByIdor(String[] idors) 
			throws BizException{
		String stridors = "";
		for (String idor : idors) {
			stridors += ",'" + idor + "'";
		}
		ICiappbusheetRService service = ServiceFinder.find(ICiappbusheetRService.class);
		CiAppBuSheetDO[] busheetAggDOs = service.find(" id_or in (" + stridors.substring(1) + ")", 
				null, FBoolean.FALSE);

		return busheetAggDOs;
	}
	/**
	 * 删除取血申请单打印
	 * @param buDOs
	 * @throws BizException
	 */
	public static void DeleteCiAppBuSheetDOs(CiAppBuSheetDO[] buDOs)
			throws BizException{
		ICiappbusheetCudService service = ServiceFinder.find(ICiappbusheetCudService.class);
		service.delete(buDOs);
	}
	
	/**
	 * 查询用血申请单DO集合
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static OrdAppBtUseDO[] GetOrdAppBtUseDOs(String sql) 
			throws BizException {
		ICiorappbuRService service = ServiceFinder.find(ICiorappbuRService.class);
		return service.find(" id_or in (" + sql + ")", "", FBoolean.FALSE);
	}
	/**
	 * 保存用血申请单DO集合
	 * @param ciAppBuSheetDOs
	 * @throws BizException
	 */
	public static void SaveCiAppBuSheetDOs(CiAppBuSheetDO[] ciAppBuSheetDOs)
			throws BizException{
		ICiappbusheetCudService service = ServiceFinder.find(ICiappbusheetCudService.class);
		service.save(ciAppBuSheetDOs);
	}
	/**
	 * 查询备血申请单打印AggDO集合
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static CiappbtsheetAggDO[] GetCiappbtsheetAggDOsByIdor(String[] idors) 
			throws BizException{
		String stridors = "";
		for (String idor : idors) {
			stridors += ",'" + idor + "'";
		}
		ICiappbtsheetRService service = ServiceFinder.find(ICiappbtsheetRService.class);
		CiappbtsheetAggDO[] btsheetAggDOs = service.find(" id_or in (" + stridors.substring(1) + ")", 
				null, FBoolean.FALSE);

		return btsheetAggDOs;
	}
	/**
	 * 删除备血申请单打印
	 * @param aggDOs
	 * @throws BizException
	 */
	public static void DeleteCiappbtsheetAggDOs(CiappbtsheetAggDO[] aggDOs)
			throws BizException{
		ICiappbtsheetCudService service = ServiceFinder.find(ICiappbtsheetCudService.class);
		service.delete(aggDOs);
	}
	
	/**
	 * 有医嘱ID查询医嘱费用
	 * @param id_orsStr 医嘱id字符串，多个id，逗号分隔
	 * @return
	 * @throws BizException
	 */
	public static FDouble GetAmt_app(String id_ors) throws BizException{
		if (StringUtils.isNullOrEmpty(id_ors))
			return null;

		String inWhereStr = CiOrdUtils.getSqlInStrsWithOutIn(id_ors);
		String sql = "select sum((case when A1.fg_bl = 'Y' and A1.Fg_Mm = 'N' then nvl(A1.Pri * A1.Quan_total_Medu, 0.0) "
				+ "when A1.Fg_Mm = 'Y' then nvl(B1.Price_Pgku_Cur * B1.Quan_Cur, 0.0) else 0.0 end)) as amt_app "
				+ "from ci_or_srv A1 left outer join ci_or_srv_mm B1 ON A1.Id_Orsrv = B1.Id_Orsrv where A1.Id_Or in "+inWhereStr;
		List<Map<String, Object>> sqlRst = CiOrdUtils.getRsMapList(sql);

		if (sqlRst == null || sqlRst.size() <= 0)
			return null;
		FDouble amt_app = new FDouble("0.00");
		if(null != sqlRst.get(0) && sqlRst.get(0).containsKey("amt_app") && sqlRst.get(0).get("amt_app") != null) {
			return new FDouble(Double.valueOf(sqlRst.get(0).get("amt_app").toString()),2);
		}
		return null;
	}
	
	/**
	 * 获取医嘱临床项目费用集合
	 * @param id_orsStr 医嘱id字符串，逗号分隔
	 * @return Map key：id_or, value : 医嘱的临床项目价格
	 * @throws BizException 
	 */
	public static Map<String,FDouble> getOrdPriceMap(String id_ors) throws BizException{
		
		Map<String,FDouble> ordPriceMap = new HashMap<String,FDouble>();
		if (StringUtils.isNullOrEmpty(id_ors))
			return null;

		// 临床项目费用
		// 【ci_or_srv.医嘱项目来源方式eu_sourcemd】  in （0医生开立\2付款策略派生价格代理（套）\8付款策略派生价格代理（组合））
		// 【ci_or_srv.费用标识fg_bl】 = Y
		String inWhereStr = CiOrdUtils.getSqlInStrsWithOutIn(id_ors);
		String sql = "select A1.id_or,sum((case when A1.fg_bl = 'Y' and A1.Fg_Mm = 'N'  then round(nvl(A1.Pri * A1.Quan_total_Medu, 0.0),2) "
				+ "when A1.Fg_Mm = 'Y' and nvl(A1.fg_self,'~')<>'Y' and nvl(A1.fg_extdispense,'~')<>'Y' then round(nvl(B1.Price_Pgku_Cur * B1.Quan_Cur, 0.0),2) else 0.0 end)) as or_total_pri "
				+ "from ci_or_srv A1 left outer join ci_or_srv_mm B1 ON A1.Id_Orsrv = B1.Id_Orsrv where A1.eu_sourcemd in ('0','2','7','8') and  A1.Id_Or in "+inWhereStr +"  group by A1.id_or";
		List<Map<String, Object>> rstList = CiOrdUtils.getRsMapList(sql);

		if (rstList == null || rstList.size() <= 0)
			return null;
		
		for(Map<String, Object> rst : rstList){
			FDouble or_total_pri = new FDouble(Double.valueOf(rst.get("or_total_pri").toString()),2);
			String id_or = rst.get("id_or").toString();
			ordPriceMap.put(id_or, or_total_pri);
		}
		
		return ordPriceMap;
	}
	
	/**
	 * 获取特需门诊标识
	 * @param id_ent 就诊ID
	 * @return
	 * @throws BizException
	 */
	public static FBoolean GetFg_opspecial(String id_ent) throws BizException {
		IOutpatientRService service = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] dos = service.find(" id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		if (dos == null || dos.length <= 0)
			return FBoolean.FALSE;
		if (!StringUtils.isNullOrEmpty(dos[0].getSd_svrtp()) && dos[0].getSd_svrtp().equals("090104"))
			return FBoolean.TRUE;
		return FBoolean.FALSE;
	}
	
	/**
	 * 查询服务名称
	 * @param id_srv 服务ID
	 * @return
	 * @throws BizException
	 */
	public static String GetName_app(String id_srv) throws BizException{
		if (StringUtils.isNullOrEmpty(id_srv))
			return null;
		String sql = "select SRV.name from "
				+ " bd_srv SRV where SRV.id_srv = '" + id_srv + "'";

		List<Map<String, Object>> sqlRst = CiOrdUtils.getRsMapList(sql);

		if (sqlRst == null || sqlRst.size() <= 0)
			return null;
		String name = (String) sqlRst.get(0).get("name");

		return name;
	}
	
	/**
	 * 获取当前就诊诊断
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public static String GetStr_name_di(String id_en) throws BizException {
		if (StringUtils.isNullOrEmpty(id_en))
			return null;
		String sql = "select DI.* from "
				+ "(select id_ent,max(to_char(Str_name_di)) as Str_name_di from (select K.id_ent, "
//				+ "wmsys.wm_concat(K.name_didef_dis) over (partition by K.id_ent order by K.Sortno)"
                + "listagg(K.name_didef_dis,',') within group(order by K.Sortno) over (partition by K.id_ent) "
				+ " as Str_name_di "
				+ "from en_ent_di K) group by id_ent) DI where DI.id_ent = '" + id_en + "'";

		List<Map<String, Object>> sqlRst = CiOrdUtils.getRsMapList(sql);

		if (sqlRst == null || sqlRst.size() <= 0)
			return null;
		String str_name_di = (String) sqlRst.get(0).get("str_name_di");

		return str_name_di;
	}

	/**
	 * 获取医嘱费用清单数据范围条件sql
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String GetCostListDataRangeSql() throws BizException {
		String sql = "";
		String id_dep = CiOrdAppUtils.getEnvContext().getDeptId();
		String datarange = ParamsetQryUtil.getParaString(id_dep, 
				ICiOrdNSysParamConst.SYS_PARAM_CiOrChargeListDataRangeSet);
		if (StringUtils.isNullOrEmpty(datarange)) {
			sql += " 0=1 ";
		}else{
			String[] ranges = datarange.split(",");
			String strrange = "";
			if (ranges.length > 0) {
				for (String range : ranges) {
					if (strrange.length() > 0)
						strrange += " or ";
					strrange += mapDataRange.get(range);
				}
			}
			if (strrange.length() > 0)
				sql += " (" + strrange + ")";
		}
		return sql;
	}
}
