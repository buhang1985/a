package iih.ei.bl.ecinc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import druid.util.StringUtils;
import iih.bd.base.utils.MapUtils;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipRService;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ei.bl.param.EiBlParamConst;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.devcfg.paramset.i.IParamsetRServiceExt;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 电子发票相关数据组装工具
 * @author ly 2019/12/09
 *
 */
public class EcIncDataUtil {
	
	/**
	 * 获取电子发票调用相关参数
	 * @return
	 * @throws BizException
	 */
	public static String[] getEnIncCallParams() throws BizException{
	
		String[] params = new String[] { EiBlParamConst.EIBL0001, EiBlParamConst.EIBL0002, EiBlParamConst.EIBL0003 };
		IParamsetRServiceExt paramService = ServiceFinder.find(IParamsetRServiceExt.class);
		Map<String, String> valueMap = paramService.queryBatchParaValues(Context.get().getOrgId(), params);
		
		String[] values = new String[3];
		for (int i = 0; i < params.length; i++) {
			values[i] = valueMap.get(params[i]);
		}
		return values;
	}

	/**
	 * 生成UUID
	 * @return
	 */
	public static String getUuid(){
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
	
	/**
	 * 获取业务时间-->yyyyMMddHHmmssSSS
	 * @return
	 */
	public static String getBusiTime(){
		return convertDateTime(new FDateTime()) + "000";
	}
	
	/**
	 * 获取人员信息
	 * @return
	 * @throws BizException
	 */
	public static PsnDocDO getPsnData(String psnId) throws BizException{
		DAFacade daf = new DAFacade();
		PsnDocDO psndocDO = (PsnDocDO) daf.findByPK(PsnDocDO.class, psnId,
				new String[] { PsnDocDO.ID_PSNDOC, PsnDocDO.CODE, PsnDocDO.NAME });
		return psndocDO;
	}
	
	/**
	 * 查询门诊结算数据
	 * @param stId
	 * @return
	 */
	public static BlStOepDO getOepStData(String stId) throws BizException{
		DAFacade daf = new DAFacade();
		BlStOepDO stDO = (BlStOepDO)daf.findByPK(BlStOepDO.class, stId);
		return stDO;
	}
	
	/**
	 * 查询门诊记账数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlcgoepAggDO[] getOepCgData(String stId) throws BizException{
		DAFacade daf = new DAFacade();
		String sql = "select distinct id_cgoep from bl_cg_itm_oep where id_stoep = ? ";
		SqlParam param = new SqlParam();
		param.addParam(stId);
		List<Object> cgIdList = (List<Object>)daf.execQuery(sql, param, new ColumnListHandler());
		
		IBlcgoepRService service = ServiceFinder.find(IBlcgoepRService.class);
		BlcgoepAggDO[] cgAggDos = service.findByIds(cgIdList.toArray(new String[0]), FBoolean.FALSE);
		return cgAggDos;
	}
	
	/**
	 * 查询门诊发票数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public static BlincoepAggDO getOepIncData(String stId) throws BizException{
		IBlincoepRService service = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] incAggDos = service.findByAttrValString(BlIncOepDO.ID_STOEP, stId);
		return incAggDos[0];
	}
	
	/**
	 * 查询门诊收费数据
	 * @param payId
	 * @return
	 * @throws BizException
	 */
	public static BlpaypatoepAggDO getOepPayData(String payId) throws BizException{
		IBlpaypatoepRService service = ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO payAggDO = service.findById(payId);
		return payAggDO;
	}
	
	/**
	 * 查询住院结算数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public static BlStIpDO getIpStData(String stId) throws BizException{
		DAFacade daf = new DAFacade();
		BlStIpDO stDO = (BlStIpDO)daf.findByPK(BlStIpDO.class, stId);
		return stDO;
	}
	
	/**
	 * 查询住院发票数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public static BlincipAggDO getIpIncData(String stId) throws BizException{
		IBlincipRService service = ServiceFinder.find(IBlincipRService.class);
		BlincipAggDO[] incAggDos = service.findByAttrValString(BlIncIpDO.ID_STIP, stId);
		return incAggDos[0];
	}
	
	/**
	 * 查询住院收费数据
	 * @param payId
	 * @return
	 * @throws BizException
	 */
	public static BlpaypatipAggDO getIpPayData(String payId) throws BizException{
		IBlpaypatipRService service = ServiceFinder.find(IBlpaypatipRService.class);
		BlpaypatipAggDO payAggDO = service.findById(payId);
		return payAggDO;
	}
	 
	/**
	 * 查询预交金数据
	 * @param prepayIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlPrePayPatDO[] getPrepayData(String[] prepayIds) throws BizException{
		DAFacade daf = new DAFacade();
		List<BlPrePayPatDO> prepayList = (List<BlPrePayPatDO>)daf.findByPKs(BlPrePayPatDO.class, prepayIds);
		return prepayList.toArray(new BlPrePayPatDO[0]);
	}
	
	/**
	 * 查询患者信息
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public static PatDO getPatData(String patId) throws BizException{
		DAFacade daf = new DAFacade();
		PatDO patDO = (PatDO)daf.findByPK(PatDO.class, patId);
		return patDO;
	}
	
	/**
	 * 查询就诊数据
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public static PatiVisitDO getEntData(String entId) throws BizException{
		DAFacade daf = new DAFacade();
		PatiVisitDO entDO = (PatiVisitDO)daf.findByPK(PatiVisitDO.class, entId);
		return entDO;
	}
	
	/**
	 * 查询就诊数据
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static InpatientDO getEntIpData(String entId) throws BizException{
		DAFacade daf = new DAFacade();
		List<InpatientDO> entIpList = (List<InpatientDO>)daf.findByAttrValString(InpatientDO.class, InpatientDO.ID_ENT, entId, null);
		return entIpList.get(0);
	}
	
	/**
	 * 查询科室数据
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	public static DeptDO getDepData(String depId) throws BizException{
		if(StringUtils.isEmpty(depId))
			return new DeptDO();
		DAFacade daf = new DAFacade();
		DeptDO depDO = (DeptDO) daf.findByPK(DeptDO.class, depId,
				new String[] { DeptDO.ID_DEP, DeptDO.CODE, DeptDO.NAME });
		return depDO;
	}
	
	/**
	 * 格式化时间
	 * @param dt
	 * @return
	 */
	public static String convertDateTime(FDateTime dt){
		if(dt == null )
			return null;
		String time = dt.toString();
		time = time.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");
		return time;
	}
	
	/**
	 * 准备计量单位数据
	 * @param measIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, MeasDocDO> prepareMeasDocData(String[] measdocIds) throws BizException{
		DAFacade daf = new DAFacade();
		List<MeasDocDO> measdocList = (List<MeasDocDO>)daf.findByPKs(MeasDocDO.class, measdocIds,
				new String[] { MeasDocDO.ID_MEASDOC, MeasDocDO.CODE, MeasDocDO.NAME });
		
		if(ListUtil.isEmpty(measdocList))
			return new HashMap<String, MeasDocDO>();
		
		return MapUtils.convertListToMap(measdocList, MeasDocDO.ID_MEASDOC);
	} 
	
	/**
	 * 非自己支付的付款方式
	 * @return
	 */
	public static List<String> getNotSelfList(){
		List<String> notSelfPmCodeList = new ArrayList<String>();
		notSelfPmCodeList.add(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT);
		notSelfPmCodeList.add(IBdPripmCodeConst.CODE_PRI_PM_INSUR);
		notSelfPmCodeList.add(IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION);
		notSelfPmCodeList.add(IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION);
		notSelfPmCodeList.add(IBdPripmCodeConst.CODE_PRI_PM_BUSINESS);
		notSelfPmCodeList.add(IBdPripmCodeConst.CODE_PRI_PM_INSUR_DIFF);
		notSelfPmCodeList.add(IBdPripmCodeConst.CODE_PRI_PM_HPPROFITLOSS);
		notSelfPmCodeList.add(IBdPripmCodeConst.CODE_PRI_PM_HPPROFITLOSS);
		//notSelfPmCodeList.add(IBdPripmCodeConst.CODE_HP_SELF_FREE);
		return notSelfPmCodeList;
	}
}
