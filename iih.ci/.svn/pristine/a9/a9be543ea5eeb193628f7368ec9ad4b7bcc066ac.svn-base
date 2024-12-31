package iih.ci.ord.pub;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.bd.fc.i.IBdFcQryService;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.mm.mmrelskinsrv.d.MmRelSkinTestSrvDO;
import iih.bd.mm.mmrelskinsrv.d.desc.MmRelSkinTestSrvDODesc;
import iih.bd.pp.bdpriboil.d.BdPriBoilDO;
import iih.bd.pp.bdpriboil.d.desc.BdPriBoilDODesc;
import iih.bd.pp.bdprisamp.d.BdPriSampDO;
import iih.bd.pp.bdprisamp.d.desc.BdPriSampDODesc;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.priusg.d.PriUsgDO;
import iih.bd.pp.priusg.d.ScopeEnum;
import iih.bd.pp.priusg.d.desc.PriUsgDODesc;
import iih.bd.pp.service.i.IPpQueService;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.bd.srv.ems.d.EmsMatchRstDTO;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.emsqry.d.EmsFunclassKVDTO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.bd.srv.freqdef.d.desc.FreqDefDODesc;
import iih.bd.srv.freqdef.d.desc.FreqTimeDODesc;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.RelSrvTacticDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDrugDODesc;
import iih.bd.srv.medsrv.d.desc.MedSrvRelMmDODesc;
import iih.bd.srv.medsrv.d.desc.MedSrvSetItemDODesc;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.bd.srv.oth.d.BdRelSrvParamDTO;
import iih.bd.utils.ParamUtils;
import iih.bl.cg.ip.i.IUsageWithBillService;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.desc.CiAppLisSheetDODesc;
import iih.ci.ord.app.d.desc.CiAppRisSheetDODesc;
import iih.ci.ord.app.d.desc.CiAppTreatExecDODesc;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApOpAgainDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.cior.d.desc.OrdApDietDODesc;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.d.desc.OrdApOutDODesc;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.d.desc.OrdApTransDODesc;
import iih.ci.ord.cior.d.desc.OrdAppBtUseDODesc;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import iih.ci.ord.cior.i.IOrdApOpAgainDOCudService;
import iih.ci.ord.cior.i.IOrdApOpAgainDORService;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciordems.d.QuantumParamDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.d.desc.CiPrnDODesc;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.OrSrvSyncInfoDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.ICiOrdLogService;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.custom.diseasedes.BaseDiseaseDesListener;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRuleArrangePlugin;
import iih.ci.ord.idvproperty.d.IdVProperty;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.d.desc.CiPresDODesc;
import iih.ci.ord.pub.d.NDaysTimeCalValidMode;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.GetSingleFldValuesBP;
import iih.ci.ord.s.bp.base.relsrv.GetLisSrvVesselRelFeeSrvBP;
import iih.ci.ord.s.bp.base.relsrv.GetRelSrvTacticDOsBP;
import iih.ci.ord.s.bp.common.GetExeDepts8DepcalparamBP;
import iih.ci.ord.s.bp.common.GetExeDepts8EmsSrvBP;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import iih.ci.ord.s.bp.ems.CiOrSrvExecuteDeptGetBP;
import iih.ci.ord.s.bp.exception.BirthDateMoreThanSysDateException;
import iih.ci.ord.s.bp.exception.CiOrUsgRelFeeSrvQuanNullException;
import iih.ci.ord.s.bp.exception.CiOrUsgRelFeeSrvRelTypeNullException;
import iih.ci.ord.s.bp.exception.CiOrUsgRelFeeSrvUnitNullException;
import iih.ci.ord.s.bp.exception.StrFactorDefException;
import iih.ci.ord.s.bp.exception.StrFactorDenoNullException;
import iih.ci.ord.s.bp.exception.StrFactorNullException;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitRuleArrangeDefaultPlugin;
import iih.ci.ord.s.ems.define.OrdPicStatusIndex;
import iih.ci.ord.s.utils.GetDrugTotalQuan4DoseBP;
import iih.ci.ord.s.utils.GetDrugTotalQuan4HerbsBP;
import iih.ci.ord.s.utils.GetDrugTotalQuanBP;
import iih.ci.ord.s.utils.GetSrvTotalQuanBP;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStatus;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.dataaccess.IDExQueryBuilder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.group.d.GroupDO;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiOrdUtils {
	


	public static final String FULLCLASS_NAME_CIORDERDO = "iih.ci.ord.ciorder.d.CiOrderDO";
	public static final FDateTime MAX_SYS_DATETIME = new FDateTime("2099-01-01 00:00:00");
	public static final String MAX_AGEMONTH_NULL = "9999999";
	public static final String COMMA_STR = ",";
	public static final String SEMICOLON_STR = ";";
	public static final String TILDE_STR = "~";
	public static final String FULLSTOP_STR = ".";
	public static final String AND_STR = " AND ";
	public static final String GREATTHAN_STR = ">";
	public static final String LESSTHAN_STR = "<";
	public static final String GREATTHAN_EQUAL_STR = ">=";
	public static final String LESSTHAN_EQUAL_STR = "<=";
	public static final String SQUOTE_MARK_STR = "'";
	public static final String LBRACE_STR = "(";
	public static final String RBRACE_STR = ")";
	public static final String LBRACKET_STR = "[";
	public static final String RBRACKET_STR = "]";
	public static final String PUNCTUATION_STR = "、";
	public static final String CHINESE_AND_STR = "与";
	public static final String IN_STR_WITHBLANK = " in ";
	public static final String EQUAL_STR = "=";
	public static final String SELECT_STR = " SELECT ";
	public static final String FROM_STR = " FROM ";
	public static final String WHERE_STR = " WHERE ";
	public static final String ID_OR = "id_or";
	public static final String ATTRNAME_SORTNO = "Sortno";
	public static final String ORAPP_SHEET_KEY = "orappsheet";
	public static final String REPLACE_STR1 = "$$";
	public static final String CRLF = "\r\n";// char(10)+char(13);
	public static final String SLASH_STR = "/";
	public static final String MACRO_STR = "$";
	public static final Integer SECONDS_PER_HOUR = 3600;
	public static final Integer HOURS_PER_DAY = 24;
	public static final Integer HOURS_PER_WEEK = 168;
	public static final Integer HOURS_PER_MONTH = 744;
	public static final String OR_MAINSRV_FLAG = "Y";

	// 国际医院工程
	public static final String PROJECT_GJ = "GJ";
	// 铜陵医院工程
	public static final String PROJECT_TL = "TL";

	public static Logger logger;
	// 医嘱医保保存时，提示信息，返回后在保存，存储未保存的医嘱信息 TODO ，新的保存完成此方法作废
	public static Map orderAggMap;
	public static Map TypeMap;// 医疗单类型

	/**
	 * 医嘱状态修改的状态值有效性校验 MM
	 * 
	 * @param sd_su_or
	 * @return
	 */
	public static boolean orStatusValidateCheck4Mod(String sd_su_or) {
		// 状态校验
		if (!(ICiDictCodeConst.SD_SU_SIGN.equals(sd_su_or) || ICiDictCodeConst.SD_SU_OPEN.equals(sd_su_or)
				|| ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(sd_su_or)
				|| ICiDictCodeConst.SD_SU_CANCEL.equals(sd_su_or) || ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(sd_su_or)
				|| ICiDictCodeConst.SD_SU_DOCTORSTOP.equals(sd_su_or)
				|| ICiDictCodeConst.SD_SU_CHECKSTOP.equals(sd_su_or))) {
			return false;
		}
		return true;
	}

	/**
	 * 获得主键值对象相关信息
	 * 
	 * @param idvprops
	 * @return
	 */
	public static Object[] getIdVPropInfo(IdVProperty[] idvprops) {
		if (idvprops == null || idvprops.length == 0)
			return null;
		String[] rtns = new String[idvprops.length];
		Hashtable ht = new Hashtable();
		for (int i = 0; i < idvprops.length; i++) {
			rtns[i] = idvprops[i].getId();
			ht.put(rtns[i], idvprops[i].getVer());
		}
		return new Object[] { rtns, ht };
	}

	/**
	 * 字母匹配判断
	 */
	public static boolean isInStr(String input, String matchstr) {
		if (OrSrvSplitUtil.isEmpty(matchstr) || OrSrvSplitUtil.isEmpty(input))
			return false;
		if (matchstr.indexOf(input) >= 0)
			return true;
		return false;
	}

	/**
	 * 首字母匹配判断
	 */
	public static boolean isCapitalInStr(String input, String matchstr) {
		if (OrSrvSplitUtil.isEmpty(matchstr) || OrSrvSplitUtil.isEmpty(input))
			return false;
		if (input.indexOf(matchstr) == 0)
			return true;
		return false;
	}

	/**
	 * 药品服务判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isPharmacy(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DRUG);
	}

	/**
	 * 检查服务判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isRisSrv(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS);
	}

	/**
	 * 病理服务判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isRisSrvBingli(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI);
	}

	/**
	 * 检验服务判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isLisSrv(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_LIS);
	}

	/**
	 * 手术服务判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isOpSrv(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_OP);
	}

	/**
	 * 会诊服务判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isConsultSrv(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS);
	}

	/**
	 * 备血服务判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isBtSrv(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE);
	}

	/**
	 * 用血服务判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isBtUseSrv(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE);
	}

	/**
	 * 出院判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isOutHospSrv(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS);
	}

	/**
	 * 护理判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isNurseSrv(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_NURSE);
	}

	/**
	 * 治疗判断
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isTreatSrv(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT);
	}

	/**
	 * 转科判断 转科、跨科、转病区
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isTranDepsSrv(String sd_srvtp) {
		return isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT)
				|| isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CROSSDEPT)
				|| isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSWARD);
	}

	/**
	 * 获得集成平台事件类型常量串
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static String getIeEventTypeStr(String sd_srvtp) {
		if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {// 药品
			if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_DRUG_HERB;
			} else {
				return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_DRUG_WC;
			}
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS)) {// 检查
			return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_RIS;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_LIS)) {// 检验
			return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_LIS;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_OP)) {// 手术
			return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OP;

		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)) {// 会诊与跨科
			return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_CON;// 会诊医嘱开立

		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)) {// 备血
			return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_PBT;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)) {// 用血
			return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_UBT;
			/*
			 * } else if (isCapitalInStr(sd_srvtp,
			 * IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS)) {// 出院 return
			 * ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OUT;
			 */
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_NURSE)) {// 护理
			return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_NS;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {// 治疗
			return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_TREAT;
		} /*
			 * else if (isCapitalInStr(sd_srvtp,
			 * IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT)//转科 ||
			 * isCapitalInStr(sd_srvtp,
			 * IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CROSSDEPT)//跨科 ||
			 * isCapitalInStr(sd_srvtp,
			 * IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSWARD)) {//转病区 return
			 * ICiIEEventConst.EVENT_IE_CIOR_NSCHK_TRANDEP;//转科医嘱开立 }
			 */

		return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OTH;// 其它医嘱开立
	}

	/**
	 * 获得集成平台事件类型常量串 （门诊）
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static String getIeOpEventTypeStr(String sd_srvtp) {
		if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
			if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				return ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG_HERB;
			} else {
				return ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG_WC;
			}
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_RIS;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_LIS;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_OP)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_OP;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_CON;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_PBT;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_UBT;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_TREAT;
		}

		return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OTH; 
	}

	/**
	 * 是否为1245四类毒麻类药品服务
	 * 
	 * @param sd_pois
	 * @return
	 */
	public static boolean isPoisonHempPharmacy1245(String sd_pois) {
		// 空判断逻辑
		if (isEmpty(sd_pois))
			return false;

		// 不含SD_POIS_JINGSHEN_2 = "3";//二类精神药品
		if (IBdMmDictCodeConst.SD_POIS_MAZUI.equals(sd_pois) || IBdMmDictCodeConst.SD_POIS_JINGSHEN_1.equals(sd_pois)
				|| IBdMmDictCodeConst.SD_POIS_POISON.equals(sd_pois)
				|| IBdMmDictCodeConst.SD_POIS_RADIO.equals(sd_pois))
			return true;

		return false;
	}

	/**
	 * 是否毒麻药品服务代办人信息核对登录处理判断
	 * 
	 * @param srvdto
	 * @return
	 */
	public static boolean isSrvPoisonHandle(CiEmsSrvDTO srvdto) {
		// 空判断
		if (isEmpty(srvdto))
			return false;

		// 空判断
		if (isEmpty(srvdto.getEmsagentinfo()))
			return false;

		// 毒麻判断
		if (isPoisonHempPharmacy1245(srvdto.getSd_pois()))
			return true;

		return false;

	}

	/**
	 * 二值逻辑的空处理逻辑
	 * 
	 * @param input
	 * @return
	 */
	public static FBoolean nullHandle(FBoolean input) {
		if (input == null)
			return new FBoolean(false);
		return input;
	}

	/**
	 * 二值逻辑的空处理逻辑
	 * 
	 * @param input
	 * @return
	 */
	public static String nullHandle(Object input) {
		if (input == null)
			return null;
		return input.toString();
	}

	/**
	 * 在院标志 ,改为使用参数带CiEnContextDTO的方法
	 * 
	 * @return
	 */
	@Deprecated
	public static FBoolean JudgeFgMpIn(CiEmsDTO ems) {
		if (ems != null) {
			if (!CiOrdUtils.isEmpty(ems.getFg_mp_in()))
				return ems.getFg_mp_in();
			// bug:0185288 LIYUELONG 急诊抢救医生站，执行确认节点，不能查出相关待执行数据
			if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ems.getCode_entp())||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ems.getCode_entp())||IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(ems.getCode_entp())){
				return FBoolean.TRUE;
			}
			if (IEnDictCodeConst.SD_DIAGTYPE_HOSPITAL_IN.equals(ems.getCode_entp())) {
				// 住院
				return FBoolean.TRUE;
			} else if (IEnDictCodeConst.SD_DIAGTYPE_OUTPATIENT.equals(ems.getCode_entp())) {
				// 门诊
				if (ems.getFg_mp_in() != null) {
					return ems.getFg_mp_in();
				}
				if (ems.getSd_srvtp() != null) {
					// 草药
					if (ems.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
						return FBoolean.FALSE;
					}
					// 西成药 注射
					if (ems.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX)) {
						return FBoolean.TRUE;
					}
					// 非注射
					if (ems.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)) {
						return FBoolean.FALSE;
					}
					// 非药品
					if (!ems.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
						return FBoolean.TRUE;
					}
				}
			}
		}

		return FBoolean.FALSE;
	}
	/**
	 * 判断在院执行标识
	 * @param code_entp
	 * @param sd_srvtp
	 * @return
	 */
	public static FBoolean JudgeFgMpIn(String code_entp, String sd_srvtp) {
		if (IEnDictCodeConst.SD_DIAGTYPE_HOSPITAL_IN.equals(code_entp)) {
			// 住院
			return FBoolean.TRUE;
		} else if (IEnDictCodeConst.SD_DIAGTYPE_OUTPATIENT.equals(code_entp)) {
			if (sd_srvtp != null) {
				// 草药
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					return FBoolean.FALSE;
				}
				// 西成药 注射
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX)) {
					return FBoolean.TRUE;
				}
				// 非注射
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)) {
					return FBoolean.FALSE;
				}
				// 非药品
				if (!sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
					return FBoolean.TRUE;
				}
			}
		}
		return FBoolean.FALSE;
	}

	/**
	 * 在院执行次数
	 * 
	 * @param ems
	 * @return
	 */
	public static int JudgeTiemMpIn(CiEmsDTO ems) throws BizException {
		// todo
		if (ems != null) {
			if (ems.getSd_srvtp().startsWith("01")) {
				// 药品计算 在院执行次数
				String whereStr = FreqTimeDO.ID_FREQ + " = '" + ems.getId_freq() + "';";
				FreqTimeDO[] fretimes = CiOrdAppUtils.getFreqTimeDORService().find(whereStr, FreqTimeDO.ID_FREQ,
						FBoolean.FALSE);
				if (ems.getDays_or() != null && fretimes != null && fretimes.length > 0) {
					return fretimes.length * ems.getDays_or();
				}
			} else {
				// 非药品默认为 1；
				return 1;
			}

		} else {
			// 异常处理
		}
		return 1;
	}

	/**
	 * 获得单据编码
	 * 
	 * @param fullclazname
	 * @return
	 * @throws BizException
	 */
	public static String getBillCode(String fullclazname) throws BizException {
		IBillcodeManage codemanager = CiOrdAppUtils.getIBillcodeManager();
		return codemanager.getPreBillCode_RequiresNew(fullclazname);

	}

	/**
	 * 是否门急诊
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isOpUrgentWf(String sd_entp) {
		if (OrSrvSplitUtil.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(sd_entp) 
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(sd_entp)
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(sd_entp))
			return true;
		return false;

	}

	/**
	 * 是否门诊
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isOpWf(String sd_entp) {
		if (OrSrvSplitUtil.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(sd_entp))
			return true;
		return false;

	}

	/**
	 * 是否急诊
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isUrgentWf(String sd_entp) {
		if (OrSrvSplitUtil.isEmpty(sd_entp))
			return false;
		if (sd_entp.startsWith(IBdFcDictCodeConst.SD_CODE_ENTP_ET))
			return true;
		return false;

	}

	/**
	 * 是否住院
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isIpWf(String sd_entp) {
		if (OrSrvSplitUtil.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(sd_entp) 
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(sd_entp)||IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(sd_entp))
			return true;
		return false;
	}

	/**
	 * 获得用户对应的人员id
	 * 
	 * @param sd_entp
	 * @return
	 * @throws BizException
	 */
	public static String getPsnDocID(String id_user) throws BizException {
		if (OrSrvSplitUtil.isEmpty(id_user))
			return "";
		UserDO udo = CiOrdAppUtils.getUserQryService().findById(id_user);
		if (udo == null)
			return "";
		return udo.getId_psn();
	}

	/**
	 * 获得有效的医嘱结束时间
	 * 
	 * @param dt_end
	 * @return
	 */
	public static FDateTime getCiOrDt_end(FDateTime dt_end) {
		if (dt_end == null)
			return MAX_SYS_DATETIME;
		return dt_end;
	}

	/**
	 * 获得组织id
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public static String getOrgOfDept(String id_dep) throws BizException {
		DeptDO do1 = CiOrdAppUtils.getDeptQryService().findById(id_dep);
		if (do1 == null)
			return "";
		return do1.getId_org();
	}

	/**
	 * 获得需皮试的物品
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public static MeterialDO[] getEmsNeedSkinTestMm(CiEmsDTO ems) throws BizException {
		String id_mms = getEmsSrvMmIDs(ems);
		if (isEmpty(id_mms))
			return null;
		return getSkinTestMms(id_mms);
	}

	/**
	 * 是否含需皮试的物品判断
	 * 
	 * @param id_mms
	 * @return
	 * @throws BizException
	 */
	public static boolean isSkinTestMm(String id_mms) throws BizException {
		if (isEmpty(id_mms))
			return false;
		MeterialDO[] do1 = getSkinTestMms(id_mms);
		if (do1 == null || do1.length == 0)
			return false;
		return true;
	}

	/**
	 * 含需皮试的物品集合
	 * 
	 * @param id_mms
	 * @return
	 * @throws BizException
	 */
	public static MeterialDO[] getSkinTestMms(String id_mms) throws BizException {
		if (isEmpty(id_mms))
			return null;
		String whereStr = MeterialDODesc.TABLE_ALIAS_NAME + ".id_mm in " + LBRACE_STR + id_mms + RBRACE_STR + " and "
				+ MeterialDODesc.TABLE_ALIAS_NAME + ".fg_skin='Y'";
		MeterialDO[] do1 = CiOrdAppUtils.getMaterialQryService().find(whereStr, "", FBoolean.FALSE);
		if (do1 == null || do1.length == 0)
			return null;
		return do1;
	}

	/**
	 * 获得物品对应的皮试服务id
	 * 
	 * @param id_mm
	 * @return
	 * @throws BizException
	 */
	public static String getMmRelSkinSrv(String id_mm) throws BizException {
		if (isEmpty(id_mm))
			return null;
		String whereStr = MeterialDODesc.TABLE_ALIAS_NAME + ".id_mm=" + LBRACE_STR + SQUOTE_MARK_STR + id_mm
				+ SQUOTE_MARK_STR + RBRACE_STR + " and " + MeterialDODesc.TABLE_ALIAS_NAME + ".fg_skin='Y'";
		MeterialDO[] do1 = CiOrdAppUtils.getMaterialQryService().find(whereStr, "", FBoolean.FALSE);
		if (do1 == null || do1.length == 0)
			return null;

		return do1[0].getId_srvskin();
	}

	/**
	 * 获得皮试物品对应的服务数据
	 * 
	 * @param id_mm
	 * @return
	 * @throws BizException
	 */
	public static String getMmRelSkinTestSrv(String id_mm) throws BizException {
		MmRelSkinTestSrvDO[] do1 = CiOrdAppUtils.getMmRelSkinQryService()
				.find(MmRelSkinTestSrvDODesc.TABLE_ALIAS_NAME + ".id_mm='" + id_mm + "'", "", FBoolean.FALSE);
		if (do1 == null || do1.length == 0)
			return null;
		return do1[0].getId_srv();
	}

	/**
	 * 获得皮试物品关联的服务数据
	 * 
	 * @param id_mm
	 * @return
	 * @throws BizException
	 */
	public static MmRelSkinTestSrvDO getMmRelSkinTestDO(String id_mm) throws BizException {
		MmRelSkinTestSrvDO[] do1 = CiOrdAppUtils.getMmRelSkinQryService()
				.find(MmRelSkinTestSrvDODesc.TABLE_ALIAS_NAME + ".id_mm='" + id_mm + "'", "", FBoolean.FALSE);
		if (do1 == null || do1.length == 0)
			return null;
		return do1[0];
	}

	/**
	 * 获得患者就诊基本信息
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public static PatiVisitDO getPatiVisitDO(String id_en) throws BizException {
		return CiOrdAppUtils.getEnOutQryService().getEnInfo(id_en);
	}

	/**
	 * 获得关联服务数据信息集合 关联因子匹配算法
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public static RelSrvTacticDO[] getRelSrvTacticDOs(BdRelSrvParamDTO param) throws BizException {
		GetRelSrvTacticDOsBP bp = new GetRelSrvTacticDOsBP();
		return bp.exec(param);
	}

	/**
	 * 获得检验项目标本容器对应的费用集合
	 * 
	 * @param sd_specimenvesseltp
	 * @param id_org
	 * @param id_scope_dept
	 * @param code_entp
	 * @param reltype
	 * @return
	 * @throws BizException
	 */
	public static UsageRelFeeSrvDO getLisSrvVesselTpRelFeeSrvInfo(String sd_specimenvesseltp, String id_org,
			String id_scope_dept, String code_entp, Integer reltype) throws BizException {
		GetLisSrvVesselRelFeeSrvBP bp = new GetLisSrvVesselRelFeeSrvBP();
		UsageRelFeeSrvDO relfeedo = bp.exec(id_org, id_scope_dept, code_entp, sd_specimenvesseltp, reltype);
		if (isEmpty(relfeedo))
			return null;
		return relfeedo;
	}

	/**
	 * 获得检验项目标本与容器对应的费用集合 标本关联 、容器关联
	 * 
	 * @param sd_specimentp
	 * @param id_scope_rel
	 * @param isscopedept是否科室范围
	 * @return
	 * @throws BizException
	 */
	public static UsageRelFeeSrvDO[] getLisSrvSpecimenVesselTpRelFeeSrvInfos(String sd_specimentp,
			String sd_specimenvesseltp, String id_org, String id_scope_dept, String code_entp, Integer reltype)
			throws BizException {
		// 标本关联的 原有的
		BdPriSampDO[] bdprisampdos = getSpecimenTpRelFeeSrvInfo0(sd_specimentp, id_org, id_scope_dept);
		// 新增的容器关联的
		UsageRelFeeSrvDO vesselrel = getLisSrvVesselTpRelFeeSrvInfo(sd_specimenvesseltp, id_org, id_scope_dept,
				code_entp, reltype);

		// 有效性判断
		if (isEmpty(bdprisampdos)) {
			if (isEmpty(vesselrel)) {
				return null;
			} else {
				return new UsageRelFeeSrvDO[] { vesselrel };
			}
		}

		// 进行合并返回处理
		int iN = bdprisampdos.length;
		if (!isEmpty(vesselrel))
			iN = iN + 1;
		UsageRelFeeSrvDO[] rtn = new UsageRelFeeSrvDO[iN];
		for (int i = 0; i < bdprisampdos.length; i++) {
			rtn[i] = getSepecimenRelFeeSrv(bdprisampdos[i]);
		}
		if (!isEmpty(vesselrel))
			rtn[iN - 1] = vesselrel;
		return rtn;
	}

	/**
	 * 获得标本类型对应的费用集合
	 * 
	 * @param sd_specimentp
	 * @param id_scope_rel
	 * @param isscopedept是否科室范围
	 * @return
	 * @throws BizException
	 */
	public static BdPriSampDO[] getSpecimenTpRelFeeSrvInfo0(String sd_specimentp, String id_scope_org,
			String id_scope_dept) throws BizException {
		String tbaliasname = BdPriSampDODesc.TABLE_ALIAS_NAME;
		if (sd_specimentp == null || sd_specimentp == "")
			return null;
		String condstr = getSpecimenCondStr(tbaliasname, id_scope_org, id_scope_dept);
		BdPriSampDO[] do1 = CiOrdAppUtils.getBdprisampRService()
				.find(tbaliasname + ".sd_samptp='" + sd_specimentp + "'" + condstr, "sd_samptp,sortno", FBoolean.FALSE);
		return do1;
	}

	/**
	 * 获得标本类型对应的费用集合
	 * 
	 * @param sd_specimentp
	 * @param id_scope_rel
	 * @param isscopedept是否科室范围
	 * @return
	 * @throws BizException
	 */
	public static UsageRelFeeSrvDO[] getSpecimenTpRelFeeSrvInfo(String sd_specimentp, String id_scope_org,
			String id_scope_dept) throws BizException {
		// String tbaliasname=BdPriSampDODesc.TABLE_ALIAS_NAME;
		// if(sd_specimentp == null || sd_specimentp== "") return null;
		// String
		// condstr=getSpecimenCondStr(tbaliasname,id_scope_org,id_scope_dept);
		BdPriSampDO[] do1 = getSpecimenTpRelFeeSrvInfo0(sd_specimentp, id_scope_org, id_scope_dept);// CiOrdAppUtils.getBdprisampRService().find(tbaliasname+".sd_samptp='"+sd_specimentp+"'"+condstr,
																									// "sd_samptp,sortno",
																									// FBoolean.FALSE);
		if (do1 == null || do1.length == 0) {
			return null;
		}
		UsageRelFeeSrvDO[] rtn = new UsageRelFeeSrvDO[do1.length];
		for (int i = 0; i < do1.length; i++) {
			rtn[i] = getSepecimenRelFeeSrv(do1[i]);
		}
		return rtn;
	}

	private static String getSpecimenCondStr(String tbaliasname, String id_scope_org, String id_scope_dept) {
		String deptid = "";
		String orgid = tbaliasname + ".id_org='" + id_scope_org + "'";
		return " and " + orgid;
	}

	private static UsageRelFeeSrvDO getSepecimenRelFeeSrv(BdPriSampDO specido) {
		UsageRelFeeSrvDO rtn = new UsageRelFeeSrvDO();
		rtn.setId_srv(specido.getId_srv());
		rtn.setId_unit(specido.getId_unit());
		rtn.setQuan_medu(specido.getQuan_medu());
		rtn.setReltype(OrSrvSourceFromEnum.SPECIMENRELFEE);
		return rtn;
	}

	/**
	 * 获得用法对应的费用集合
	 * 
	 * @param id_route
	 * @param id_scope_rel
	 * @param isscopedept是否科室范围
	 * @return
	 * @throws BizException
	 */
	public static UsageRelFeeSrvDO[] getPriUsgRelFeeSrvInfo(String id_route, String id_scope_org, String id_scope_dept)
			throws BizException {
		String tbaliasname = PriUsgDODesc.TABLE_ALIAS_NAME;
		if (id_route == null || id_route == "")
			return null;
		String condstr = getCondStr(tbaliasname, id_scope_org, id_scope_dept);
		IUsageWithBillService usgrservice = CiOrdAppUtils.getUsageWithBillService();
		PriUsgDO[] do1 = usgrservice.judgeUsageWithBillitm(id_route, id_scope_org, id_scope_dept);
		// PriUsgDO[] do1 = CiOrdAppUtils.getPriusgRService().find(tbaliasname +
		// ".id_route='" + id_route + "'" + condstr,
		// "eu_scope,sortno", FBoolean.FALSE);
		if (do1 == null || do1.length == 0) {
			// Logger.info("用法【"+id_route+"】未关联费用项目。");
			return null;
		}

		ArrayList<UsageRelFeeSrvDO> list = new ArrayList<UsageRelFeeSrvDO>();
		int iN = do1.length, imatch = 0;
		if (ScopeEnum.INPATIENTAREA.equals(do1[iN - 1].getEu_scope())) {
			imatch = 1;
		}
		for (int i = 0; i < iN; i++) {
			if (imatch == do1[i].getEu_scope()) {
				list.add(getUsageRelFeeSrv(do1[i]));
			}
		}
		return (UsageRelFeeSrvDO[]) list.toArray((UsageRelFeeSrvDO[]) Array.newInstance(UsageRelFeeSrvDO.class, 0));
	}

	private static UsageRelFeeSrvDO getUsageRelFeeSrv(PriUsgDO usgdo) {
		UsageRelFeeSrvDO rtn = new UsageRelFeeSrvDO();
		rtn.setId_srv(usgdo.getId_srv());
		rtn.setId_unit(usgdo.getId_unit());
		rtn.setQuan_medu(usgdo.getQuan_medu());
		rtn.setReltype(OrSrvSourceFromEnum.USAGERELFEE);
		if(!CiOrdUtils.isEmpty(usgdo.getSd_mpdepcalmd_usg())){
			rtn.setSd_mpdepcalmd_usg(usgdo.getSd_mpdepcalmd_usg());
		}
		return rtn;
	}

	/**
	 * 获得代煎对应的费用集合 （已经废弃不用了）
	 * 
	 * @return
	 * @throws BizException
	 */
	public static UsageRelFeeSrvDO[] getPriBoilRelFeeSrvInfo(String id_org, Integer quan_boil) throws BizException {
		return null;
		// String id_srv=ParamsetQryUtil.getParaString(id_org,
		// ICiOrdSysParamConst.SYS_PARAM_OrBoilRelFeeSrv);
		//
		// UsageRelFeeSrvDO rtn=createUsageRelFeeSrvDO(id_srv,null,new
		// FDouble(quan_boil));
		// return new UsageRelFeeSrvDO[]{rtn};
	}

	/**
	 * 获得代煎对应的费用集合
	 * 
	 * @param id_org
	 * @param id_boil
	 * @param quan_boil
	 * @return
	 * @throws BizException
	 */
	public static UsageRelFeeSrvDO[] getPriBoilRelFeeSrvInfo(String id_org, String id_boil, Integer quan_boil)
			throws BizException {
		String tblaliasname = BdPriBoilDODesc.TABLE_ALIAS_NAME;
		String whereStr = tblaliasname + "." + BdPriBoilDO.ID_BOIL + "='" + id_boil + "' and " + tblaliasname + "."
				+ BdPriBoilDO.ID_ORG + "='" + id_org + "' ";
		BdPriBoilDO[] boilpris = CiOrdAppUtils.getIBdpriboilRService().find(whereStr, "", FBoolean.FALSE);
		if (isEmpty(boilpris)) {
			return null;
		}
		UsageRelFeeSrvDO[] rtn = new UsageRelFeeSrvDO[boilpris.length];
		int i = 0;
		for (BdPriBoilDO bdpriboliDO : boilpris) {
			MedSrvDO srvdo = CiOrdAppUtils.getMedsrvMDORService().findById(boilpris[i].getId_srv());
			UsageRelFeeSrvDO feesrv = createUsageRelFeeSrvDO(boilpris[i].getId_srv(), boilpris[i].getId_unit_med(),
					srvdo.getQuan_med(), boilpris[i].getQuan_medu());
			rtn[i] = feesrv;
			i++;
		}
		return rtn;
		// 为什么取第一个？ 修成上面的方法 （草药）
		/*
		 * MedSrvDO srvdo = CiOrdAppUtils.getMedsrvMDORService().findById(
		 * boilpris[0].getId_srv()); // 2016-11-14 注释掉该代码 待煎付数不应该在关联费用服务中体现
		 * 只能在总量中体现出来 // UsageRelFeeSrvDO //
		 * rtn=createUsageRelFeeSrvDO(boilpris[0].getId_srv(),boilpris[0].
		 * getId_unit_med(), // (new FDouble(quan_boil)).multiply(new //
		 * FDouble(boilpris[0].getQuan_medu()))); // 2017-1-4
		 * 代煎费的剂量=原服务的剂量*煎法服务关联配置的数量 UsageRelFeeSrvDO rtn =
		 * createUsageRelFeeSrvDO(boilpris[0].getId_srv(),
		 * boilpris[0].getId_unit_med(), srvdo.getQuan_med(),
		 * boilpris[0].getQuan_medu()); return new UsageRelFeeSrvDO[] { rtn };
		 */
	}

	/**
	 * 创建用法关联费用服务数据
	 * 
	 * @param id_srv
	 * @param id_unit
	 * @param quan
	 * @return
	 */
	private static UsageRelFeeSrvDO createUsageRelFeeSrvDO(String id_srv, String id_unit, FDouble srvquan,
			FDouble quan) {
		UsageRelFeeSrvDO rtn = new UsageRelFeeSrvDO();
		rtn.setId_srv(id_srv);
		rtn.setId_unit(id_unit);
		rtn.setQuan_medu(quan.multiply(srvquan));
		rtn.setReltype(OrSrvSourceFromEnum.BOILRELFEE);
		return rtn;
	}

	/**
	 * 获得用法对应的费用条件串
	 * 
	 * @param tbaliasname
	 * @param id_scope_org
	 * @param id_scope_dept
	 * @return
	 */
	private static String getCondStr(String tbaliasname, String id_scope_org, String id_scope_dept) {
		String deptid = "";
		String orgid = tbaliasname + ".eu_scope=" + IBdSrvDictCodeConst.SD_OWTP_HOSPIAL + " and " + tbaliasname
				+ ".id_org_scope='" + id_scope_org + "'";
		if (!OrSrvSplitUtil.isEmpty(id_scope_dept)) {
			deptid = "(" + orgid + " and " + tbaliasname + ".id_dep_nur='" + id_scope_dept + "')";
			return " and (" + orgid + " or " + deptid + ") ";
		} else {
			return " and " + orgid;
		}
	}

	/**
	 * 获得医疗单项目关联的物品主键串
	 * 
	 * @param ems
	 * @return
	 */
	public static String getEmsSrvMmIDs(CiEmsDTO ems) {
		FArrayList list = ems.getEmssrvs();
		if (list == null || list.size() == 0)
			return null;
		CiEmsSrvDTO srv = null;
		String rtn = "";
		for (int i = 0; i < list.size(); i++) {
			srv = (CiEmsSrvDTO) list.get(0);
			if (srv != null && !isEmpty(srv.getId_mm())
					&& CiOrdUtils.isCapitalInStr(srv.getSd_srvtp(), IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				rtn += COMMA_STR + SQUOTE_MARK_STR + srv.getId_mm() + SQUOTE_MARK_STR;
			}
		}
		if (rtn.equals(""))
			return "";
		return rtn.substring(1);
	}

	/**
	 * 获得需要皮试药品对应的服务 一般1个，也就不做其他算法了
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public static MmRelSkinTestSrvDO[] getCiOrSkinTestSrvs(MeterialDO[] skintestmmdos) throws BizException {
		if (skintestmmdos == null || skintestmmdos.length == 0)
			return null;
		ArrayList<MmRelSkinTestSrvDO> list = new ArrayList<MmRelSkinTestSrvDO>();
		MmRelSkinTestSrvDO tm = null;
		for (int i = 0; i < skintestmmdos.length; i++) {
			tm = CiOrdUtils.getMmRelSkinTestDO(skintestmmdos[i].getId_mm());
			if (tm != null) {
				list.add(tm);
			}
		}

		return (MmRelSkinTestSrvDO[]) CiOrdUtils.list2Array(list, MmRelSkinTestSrvDO.class);
	}

	/**
	 * 获得需要皮试药品对应的服务（新） 一般1个，也就不做其他算法了
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public static MeterialDO[] getCiOrSkinTestSrvsN(MeterialDO[] skintestmmdos) throws BizException {
		if (skintestmmdos == null || skintestmmdos.length == 0)
			return null;
		ArrayList<MeterialDO> list = new ArrayList<MeterialDO>();
		MeterialDO tm = null;
		for (int i = 0; i < skintestmmdos.length; i++) {
			if (!CiOrdUtils.isEmpty(skintestmmdos[i].getId_srvskin())) {
				list.add(skintestmmdos[i]);
			}
		}

		return (MeterialDO[]) CiOrdUtils.list2Array(list, MeterialDO.class);
	}

	/**
	 * 是否含需皮试药品
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public static boolean isSkinTestMm(CiEmsDTO ems) throws BizException {
		String id_mms = getEmsSrvMmIDs(ems);
		Boolean blnSkin = isSkinTestMm(id_mms);
		if (blnSkin && OrSrvSplitUtil.isEmpty(ems.getSd_skintest_skip_reaso())) {
			return true;
		}
		return false;
	}

	/**
	 * 是否含需皮试药品
	 * 
	 * @param ems
	 * @param mmdos
	 * @return
	 * @throws BizException
	 */
	public static boolean isSkinTestMm(CiEmsDTO ems, MeterialDO[] mmdos) throws BizException {
		if (mmdos == null || mmdos.length == 0)
			return false;
		if (OrSrvSplitUtil.isEmpty(ems.getSd_skintest_skip_reaso())) {
			return true;
		}
		return false;
	}

	/**
	 * ems医嘱项目是否为套相关的费用项目判断
	 * 
	 * @param setitmsrv
	 *            ems医嘱项目
	 * @param bdsrvinset
	 *            套内费用项目集合
	 * @return
	 */
	public static boolean isFeeItm4Set(CiEmsSrvDTO setitmsrv, MedSrvSetItemDO[] bdsrvinset, FArrayList srvdtos,
			Integer[] srvsetitemindexs) {
		if (isEmpty(srvdtos) || isEmpty(srvsetitemindexs))
			return false;
		CiEmsSrvDTO setsrv = (CiEmsSrvDTO) srvdtos.get(srvsetitemindexs[0]);
		if (CiOrdUtils.isSrvsetMemberSumPrimd(setsrv.getId_primd())) {
			// 已经在套合计时 生成该医嘱项目项
		} else {
			if (CiOrdUtils.isIdSrvInSetItms(setitmsrv.getId_srv(), bdsrvinset))
				return true; // 套内费用项目返回true
			if (setitmsrv.getEu_sourcemd() == OrSrvSourceFromEnum.AGENTFROMPRIMD)
				return true; // 套个数计价、加收等派生的费用返回true
		}
		return false;
	}

	/**
	 * 获得皮试药品
	 * 
	 * @param ems
	 * @param mmdos
	 * @return
	 * @throws BizException
	 */
	public static Object getSkinTestMm(CiEmsDTO ems, MeterialDO[] mmdos) throws BizException {
		// 有效性
		if (mmdos == null || mmdos.length == 0)
			return null;

		// 遍历
		for (int i = 0; i < mmdos.length; i++) {
			if (OrSrvSplitUtil.isEmpty(ems.getSd_skintest_skip_reaso())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 同质对象数组合并 liyong
	 * 
	 * @param olddos
	 *            合并后数组前不半部分
	 * @param dos
	 *            合并后数组的后半部分
	 * @return 先olddos后dos顺序构成的数组
	 */
	public static Object[] mergeObjAry(Object[] olddos, Object[] dos) {
		if ((olddos == null||olddos.length==0) && (dos == null||dos.length==0))
			return null;
		if (olddos == null||olddos.length==0)
			return dos;
		if (dos == null||dos.length==0)
			return olddos;
		int iN = olddos.length + dos.length;
		List list = new ArrayList();

		for (Object obj : olddos) {
			list.add(obj);
		}

		for (Object obj : dos) {
			list.add(obj);
		}
		Object objs = Array.newInstance(olddos[0].getClass(), iN);
		System.arraycopy(list.toArray(), 0, objs, 0, Math.min(Array.getLength(list.toArray()), iN));
		Object[] retobjes = (Object[]) objs;
		return retobjes;
	}

	/*
	 * public static CiorderAggDO[] merge(CiorderAggDO[] aggdos1,CiorderAggDO[]
	 * aggdos2){ return (CiorderAggDO[])mergeAggDOAry(aggdos1,aggdos2); }
	 */
	/**
	 * 获得服务套内项目集合信息
	 * 
	 * @param srvdtos
	 * @param srvsetitemindexs
	 * @param isClinical
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] getBdSrvSetItems(FArrayList srvdtos, Integer[] srvsetitemindexs,
			FBoolean isClinical) throws BizException {
		if (isEmpty(srvdtos) || isEmpty(srvsetitemindexs))
			return null;
		CiEmsSrvDTO setsrv = (CiEmsSrvDTO) srvdtos.get(srvsetitemindexs[0]);
		return getBdSrvSetItems(setsrv.getId_srv(), isClinical);
	}

	/**
	 * 获得服务套内项目集合信息
	 * 
	 * @param id_srv_set套id
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] getBdSrvSetItems(String id_srv_set, FBoolean isClinical) throws BizException {
		if (isEmpty(id_srv_set))
			return null;
		String tbaliasname = MedSrvSetItemDODesc.TABLE_ALIAS_NAME;
		String clinicalStr = "";
		String acvtivestr = " and " + tbaliasname + ".fg_active='Y' ";
		if (isClinical != null) {
			if (isClinical.booleanValue()) {
				clinicalStr = " and " + tbaliasname + ".fg_clinical='Y' ";
			} else {
				clinicalStr = " and " + tbaliasname + ".fg_clinical='N' ";
			}
		}
		MedSrvSetItemDO[] do1 = CiOrdAppUtils.getMedSrvSetItemRService().find(
				tbaliasname + ".id_srv= '" + id_srv_set + "' " + clinicalStr + acvtivestr, "sortno", FBoolean.FALSE);
		if (do1 == null || do1.length == 0)
			return null;
		return do1;
	}

	/**
	 * 查询套内已经启用的临床和非临床项目的集合
	 * 
	 * @param id_srv_set
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] getBdSrvSetItems(String id_srv_set) throws BizException {
		if (isEmpty(id_srv_set))
			return null;
		String tbaliasname = MedSrvSetItemDODesc.TABLE_ALIAS_NAME;
		String clinicalStr = "";
		String acvtivestr = " and " + tbaliasname + ".fg_active='Y' ";
		MedSrvSetItemDO[] do1 = CiOrdAppUtils.getMedSrvSetItemRService().find(
				tbaliasname + ".id_srv= '" + id_srv_set + "' " + clinicalStr + acvtivestr, "sortno", FBoolean.FALSE);
		if (do1 == null || do1.length == 0)
			return null;
		return do1;
	}

	/**
	 * 分拣出套内已经启用的非临床项目的集合
	 * 
	 * @param id_srv_set
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] getBdSrvSetItemsNotClinical(MedSrvSetItemDO[] setItems) throws BizException {
		if (isEmpty(setItems))
			return null;
		List<MedSrvSetItemDO> setItemList = new ArrayList<MedSrvSetItemDO>();
		for (MedSrvSetItemDO setItem : setItems) {
			if (!setItem.getFg_clinical().booleanValue()) {
				setItemList.add(setItem);
			}
		}
		return setItemList.toArray(new MedSrvSetItemDO[0]);
	}

	/**
	 * 分拣出套内已经启用的临床项目的集合
	 * 
	 * @param id_srv_set
	 * @return
	 * @throws BizException
	 */
	public static Map<String, MedSrvSetItemDO> getBdSrvSetItemsClinicalMap(MedSrvSetItemDO[] setItems)
			throws BizException {
		if (isEmpty(setItems))
			return null;
		Map<String, MedSrvSetItemDO> map = new HashMap<String, MedSrvSetItemDO>();
		for (MedSrvSetItemDO setItem : setItems) {
			if (setItem.getFg_clinical().booleanValue()) {
				map.put(setItem.getId_srv_itm(), setItem);
			}
		}
		return map;
	}

	/**
	 * 获得服务套内项目集合信息
	 * 
	 * @param id_srv_set套id
	 * @param id_srv
	 * @param isClinical
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO getBdSrvSetItem(String id_srv_set, String id_srv, FBoolean isClinical)
			throws BizException {
		String tbaliasname = MedSrvSetItemDODesc.TABLE_ALIAS_NAME;
		String clinicalStr = "";
		String acvtivestr = " and " + tbaliasname + ".fg_active='Y' ";
		id_srv = " and " + tbaliasname + ".id_srv_itm='" + id_srv + "' ";
		if (isClinical != null) {
			if (isClinical.booleanValue()) {
				clinicalStr = " and " + tbaliasname + ".fg_clinical='Y' ";
			} else {
				clinicalStr = " and " + tbaliasname + ".fg_clinical='N' ";
			}
		}
		MedSrvSetItemDO[] do1 = CiOrdAppUtils.getMedSrvSetItemRService().find(
				tbaliasname + ".id_srv='" + id_srv_set + "'" + id_srv + clinicalStr + acvtivestr, "", FBoolean.FALSE);
		if (do1 == null || do1.length == 0)
			return null;
		return do1[0];
	}

	/**
	 * 按段获得查询条件sql串
	 * 
	 * @param ids
	 * @return
	 */
	public static ArrayList<String> getSqlInStrs(String[] ids) {
		if (ids == null || ids.length == 0)
			return null;
		ArrayList<String> list = new ArrayList<String>();
		int maxincnt = IDExQueryBuilder.getMaxInCount();
		String instr = "";
		int iN = 0;
		for (int i = 0; i < ids.length; i++) {
			iN += 1;
			if (iN == maxincnt) {
				instr += COMMA_STR + SQUOTE_MARK_STR + ids[i] + SQUOTE_MARK_STR;
				list.add(IN_STR_WITHBLANK + LBRACE_STR + instr.substring(1) + RBRACE_STR);
				instr = "";
				iN = 0;
			} else {
				instr += COMMA_STR + SQUOTE_MARK_STR + ids[i] + SQUOTE_MARK_STR;
			}
		}
		if (iN > 1)
			list.add(IN_STR_WITHBLANK + LBRACE_STR + instr.substring(1) + RBRACE_STR);
		if (iN == 1)
			list.add(EQUAL_STR + LBRACE_STR + instr.substring(1) + RBRACE_STR);

		return list;
	}

	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getMapConveretstr(FMap2 map) throws BizException {
		StringBuffer sb = new StringBuffer();
		if (map == null && map.size() == 0)
			return null;
		for (Object key : map.values()) {
			sb.append(",'");
			sb.append(key.toString());
			sb.append("'");
		}
		return sb.toString().substring(1);
	}

	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getFMapKeyConveretstr(FMap map) throws BizException {
		StringBuffer sb = new StringBuffer();
		if (map == null && map.size() == 0)
			return null;
		for (Object key : map.keySet()) {
			sb.append(",'");
			sb.append(key.toString());
			sb.append("'");
		}
		return sb.toString().substring(1);
	}

	/**
	 * Map中key值转换为逗号分隔字符串
	 * 
	 * @param map
	 *            待转换的map集合
	 * @return map中key值拼接的字符串
	 * @throws BizException
	 */
	public static String getFMapValuesConveretstr(FMap map) throws BizException {
		StringBuffer sb = new StringBuffer();
		if (map == null && map.size() == 0)
			return null;
		for (Object key : map.values()) {
			sb.append(",'");
			sb.append(key.toString());
			sb.append("'");
		}
		return sb.toString().substring(1);
	}

	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getFMapValuesConveretstrNoQuotes(FMap map) throws BizException {
		StringBuffer sb = new StringBuffer();
		if (map == null && map.size() == 0)
			return null;
		for (Object key : map.values()) {
			sb.append(",");
			sb.append(key.toString());
			sb.append("");
		}
		return sb.toString().substring(1);
	}

	/**
	 * Map 转换成 String
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getMapConveretstr2(Map map) throws BizException {
		StringBuffer sb = new StringBuffer();
		if (map == null && map.size() == 0)
			return null;
		for (Object key : map.values()) {
			if (key == null)
				continue;
			sb.append(",'");
			sb.append(key.toString());
			sb.append("'");
		}
		if (sb.indexOf(",") > -1) {
			return sb.toString().substring(1);
		}
		return null;
	}

	/**
	 * Map 转换成 String
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String[] getMapConveretArr(Map map) throws BizException {

		if (map == null && map.size() == 0)
			return null;
		List list = new ArrayList();
		for (Object key : map.values()) {
			list.add(key);
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	/**
	 * 获得查询条件sql串（不含in、(、)）
	 * 
	 * @param ids
	 * @return
	 */
	public static String getSqlInStrsWithOutIn(String[] ids) {
		// 有效性判断
		if (isEmpty(ids))
			return null;
		String instr = "";

		// 遍历
		for (int i = 0; i < ids.length; i++) {
			instr += COMMA_STR + SQUOTE_MARK_STR + ids[i] + SQUOTE_MARK_STR;
		}
		// 返回置处理
		return instr.substring(1);
	}

	/**
	 * 获得查询条件sql串（不含in、(、)）
	 * 
	 * @param idsStr
	 * @return
	 */
	public static String getSqlInStrsWithOutIn(String idsStr) {
		// 有效性判断
		if (isEmpty(idsStr))
			return null;

		String instr = idsStr.replaceAll(COMMA_STR, SQUOTE_MARK_STR + COMMA_STR + SQUOTE_MARK_STR);

		// 返回置处理
		return LBRACE_STR + SQUOTE_MARK_STR + instr + SQUOTE_MARK_STR + RBRACE_STR;
	}

	/**
	 * 获得查询条件sql串（'',''）
	 * 
	 * @param idsStr
	 * @return
	 */
	public static String getSqlInStrsWithOutIn2(String idsStr) {
		// 有效性判断
		if (isEmpty(idsStr))
			return null;

		String instr = idsStr.replaceAll(COMMA_STR, SQUOTE_MARK_STR + COMMA_STR + SQUOTE_MARK_STR);

		// 返回置处理
		return SQUOTE_MARK_STR + instr + SQUOTE_MARK_STR;
	}

	/**
	 * 获得查询条件sql串 含in 或 =
	 * 
	 * @param idsStr
	 * @return
	 */
	public static String getSqlInOrEqualStrs(String idsStr) {
		// 有效性判断
		if (isEmpty(idsStr))
			return null;

		if (idsStr.indexOf(",") == -1)
			return CiOrdUtils.EQUAL_STR + CiOrdUtils.getSqlCondStr(idsStr);
		return CiOrdUtils.IN_STR_WITHBLANK + CiOrdUtils.getSqlInStrsWithOutIn(idsStr);
	}

	/**
	 * 按段获得查询条件sql串
	 * 
	 * @param ids
	 * @return
	 */
	public static ArrayList<String> getSqlInStrs(ArrayList<String> ids) {
		if (ids == null || ids.size() == 0)
			return null;
		return getSqlInStrs((String[]) ids.toArray((String[]) Array.newInstance(String.class, 0)));
	}

	/**
	 * 从map转换为FMap数据
	 * 
	 * @param info
	 * @return
	 */
	public static FMap map2FMap(Map<String, Object> info) {
		FMap rtn = new FMap();
		String key = "";
		Iterator it = info.keySet().iterator();
		while (it.hasNext()) {
			key = it.next().toString();
			rtn.put(key, info.get(key));
		}
		return rtn;
	}

	/**
	 * 数组转换为FArrayList2
	 * 
	 * @param os
	 * @return
	 */
	public static FArrayList2 array2FArrayList2(Object[] os) {
		if (isEmpty(os))
			return null;
		FArrayList2 list = new FArrayList2();
		for (Object o : os) {
			list.add(o);
		}
		return list;
	}

	/**
	 * 数组转换为FArrayList2
	 * 
	 * @param os
	 * @return
	 */
	public static void merge2FArrayList2(FArrayList2 list, Object[] os) {
		if (isEmpty(os))
			return;
		for (Object o : os) {
			list.add(o);
		}
	}

	/**
	 * 数组转换为FArrayList
	 * 
	 * @param os
	 * @return
	 */
	public static FArrayList mergeFArrayList(FArrayList list1, FArrayList list2) {
		if (isEmpty(list2) && isEmpty(list1))
			return null;
		if (isEmpty(list2))
			return list1;
		if (isEmpty(list1))
			return list2;
		list1.addAll(list2);
		return list1;
	}

	/**
	 * 数组转换为FArrayList
	 * 
	 * @param os
	 * @return
	 */
	public static FArrayList merge2FArrayList(BaseDO do1, FArrayList list) {
		if (isEmpty(do1) && isEmpty(list))
			return null;
		if (isEmpty(do1))
			return list;
		if (isEmpty(list)) {
			FArrayList rtn = new FArrayList();
			rtn.add(do1);
			return rtn;
		}
		list.add(0, do1);
		return list;
	}

	/**
	 * 获得Map查询结果集
	 * 
	 * @param sql
	 * @param ids
	 * @throws DAException
	 */
	public static ArrayList<Map<String, Object>> getQryResultByIDs(String sql, ArrayList<String> ids)
			throws DAException {
		if (ids == null || ids.size() == 0)
			return null;
		DAFacade dao = new DAFacade();
		ArrayList<String> idsdtr = getSqlInStrs(ids);
		String condtr = "";
		FMap rtn = new FMap();
		ArrayList<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < idsdtr.size(); i++) {
			condtr = idsdtr.get(i);
			rs.addAll((ArrayList<Map<String, Object>>) dao.execQuery(sql + condtr, new MapListHandler()));
		}
		return rs;
	}

	/**
	 * 本服务定价模式 按编码
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvSelfPrimd(String id_primd) {
		return IBdPrimdCodeConst.CODE_PRI_SRV.equals(id_primd);
	}

	/**
	 * 本服务定价模式 按ID
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvSelfPrimd8Id(String id_primd) {
		return IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd);
	}

	/**
	 * 对应物品价格模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvMMPri8Id(String id_primd) {
		return IBdPrimdCodeConst.ID_PRI_RES.equals(id_primd);
	}

	/**
	 * 服务不付费模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvFreePrimd(String id_primd) {
		return IBdPrimdCodeConst.CODE_PRI_FREE.equals(id_primd);
	}

	/**
	 * 服务组合定价模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvCompPrimd(String id_primd) {
		return IBdPrimdCodeConst.CODE_PRI_SRV_COMP.equals(id_primd);
	}

	/**
	 * 套成员合计计价模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemberSumPrimd(String id_primd) {
		return IBdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT.equals(id_primd);
	}

	/**
	 * 套成员个数加收计价模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemCntAdditionalPrimd(String id_primd) {
		return IBdPrimdCodeConst.ID_PRI_SRVSET_MU.equals(id_primd);
	}

	/**
	 * 套成员个数定价计价模式
	 * 
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemberCntPrimd(String id_primd) {
		return IBdPrimdCodeConst.ID_PRI_SRVSET_FIX.equals(id_primd);
	}

	/**
	 * 数组对象转换为字符串
	 * 
	 * @param inputs
	 * @return
	 */
	public static String aryToString(Object[] inputs) {
		if (inputs == null || inputs.length == 0)
			return "";
		String rtn = "";
		for (int i = 0; i < inputs.length; i++) {
			rtn += COMMA_STR + inputs[i].toString();
		}
		return rtn.substring(1);
	}

	/**
	 * 数组对象转换为字符串
	 * 
	 * @param inputs
	 * @return
	 */
	public static String aryToString(BaseDO[] inputs, String fldname) {
		if (inputs == null || inputs.length == 0)
			return "";
		String rtn = "";
		for (int i = 0; i < inputs.length; i++) {
			rtn += COMMA_STR + inputs[i].getAttrVal(fldname);
		}
		return rtn.substring(1);
	}

	/**
	 * list对象转换为字符串
	 * 
	 * @param inputs
	 * @return
	 */
	public static String aryToString(ArrayList inputs) {
		if (inputs == null || inputs.size() == 0)
			return "";
		String rtn = "";
		for (int i = 0; i < inputs.size(); i++) {
			rtn += COMMA_STR + inputs.get(i).toString();
		}
		return rtn.substring(1);
	}

	/**
	 * 获得对应的套id
	 * 
	 * @param ems
	 * @param srvsetitemindexs
	 * @return
	 */
	public static String getIdSrvSet4Ems(CiEmsDTO ems, Integer[] srvsetitemindexs) {
		// 有效性校验
		if (ems == null || ems.getEmssrvs() == null || ems.getEmssrvs().size() == 0)
			return "";

		if (!(srvsetitemindexs == null || srvsetitemindexs.length == 0)) {
			FArrayList emssrvs = null;
			CiEmsSrvDTO emssrvdto = null;
			emssrvs = ems.getEmssrvs();
			emssrvdto = (CiEmsSrvDTO) emssrvs.get(srvsetitemindexs[0]);
			return emssrvdto.getId_srv();
		}
		return "";
	}

	/**
	 * 获得Once的频次数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FreqDefDO getOnceFreqDefDO() throws BizException {
		FreqDefDO[] defdos = CiOrdAppUtils.getFreqdefMDORService().find(
				FreqDefDODesc.TABLE_ALIAS_NAME + ".id_frequnitct='" + IBdSrvDictCodeConst.ID_FREQNUNITCT_ONCE + "'", "",
				FBoolean.FALSE);
		if (defdos == null || defdos.length == 0)
			return null;
		return defdos[0];
	}

	/**
	 * 获得频次时间集合数据信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FreqTimeDO[] getFreqTimeDOs(String id_freq) throws BizException {
		FreqTimeDO[] dos = CiOrdAppUtils.getFreqTimeDORService().find(
				FreqTimeDODesc.TABLE_ALIAS_NAME + "." + FreqTimeDO.ID_FREQ + "='" + id_freq + "'", FreqTimeDO.SORTNO,
				FBoolean.FALSE);
		// if(dos==null || dos.length==0)return null;
		return dos;
	}

	/**
	 * 获得频次聚集数据信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public static FreqdefAggDO getFreqAggDO(String id_freq) throws BizException {
		FreqdefAggDO dos = CiOrdAppUtils.getFreqdefRService().findById(id_freq);
		// if(dos==null || dos.length==0)return null;
		return dos;
	}

	/**
	 * 获得服务关联的默认物品相关信息
	 * 
	 * @param srvrelmmdos
	 * @param id_dep
	 * @throws BizException
	 */
	public static MedSrvRelMmDTO getSrvRelDefaultMmDTO(String id_srv, String id_dep) throws BizException {
		MedSrvRelMmDTO[] srvrelmmdos = CiOrdAppUtils.getBdSrvQryQryService().getMedSrvRelMmDept(id_srv, id_dep);
		if (CiOrdUtils.isEmpty(srvrelmmdos))
			return null;
		return srvrelmmdos[0];
	}

	/**
	 * 获得服务关联的默认物品相关信息
	 * 
	 * @param srvrelmmdos
	 * @param id_dep
	 * @throws BizException
	 */
	public static MedSrvRelMmDTO getSrvRelDefaultMmDTO(String id_srv, String id_org, String id_dep)
			throws BizException {
		MedSrvRelMmDTO[] srvrelmmdos = CiOrdAppUtils.getBdSrvQryQryService().getMedSrvRelMmDept(id_srv, id_dep);
		if (CiOrdUtils.isEmpty(srvrelmmdos))
			return null;
		return srvrelmmdos[0];
	}

	/**
	 * 获得服务关联的默认物品相关信息 （废弃不用了）
	 * 
	 * @param srvrelmmdos
	 * @param id_dep
	 * @throws BizException
	 */
	public static MedSrvRelMmDO getSrvRelDefaultMmDO(String id_srv, String id_dep) throws BizException {
		MedSrvRelMmDO[] srvrelmmdos = CiOrdAppUtils.getMedsrvRelMmQryService().find(
				MedSrvRelMmDODesc.TABLE_ALIAS_NAME + ".id_srv='" + id_srv + "'", "id_org,id_dep,sortno",
				FBoolean.FALSE);
		return getSrvRelDefaultMmDO(srvrelmmdos, id_dep);
	}

	/**
	 * 获得服务关联的默认物品相关信息 （废弃不用了）
	 * 
	 * @param srvrelmmdos
	 * @param id_dep
	 * @throws BizException
	 */
	public static MedSrvRelMmDO getSrvRelDefaultMmDO(MedSrvRelMmDO[] srvrelmmdos, String id_dep) throws BizException {
		if (srvrelmmdos == null || srvrelmmdos.length == 0 || id_dep == null)
			return null;
		return srvrelmmdos[0];
		/*
		 * if(!OrSrvSplitUtil.isEmpty(id_dep)){ for(int
		 * i=0;i<srvrelmmdos.length;i++){
		 * if(id_dep.equals(srvrelmmdos[i].getId_dep())){ return srvrelmmdos[i];
		 * //按道理讲应该有个默认标识 暂时先拿到首个吧 } } }else{ //String
		 * id_org=CiOrdUtils.getOrgOfDept(id_dep); for(int
		 * i=0;i<srvrelmmdos.length;i++){
		 * if(id_dep.equals(srvrelmmdos[i].getId_dep())){ return srvrelmmdos[i];
		 * //按道理讲应该有个默认标识 暂时先拿到首个吧 } } } return null;
		 */
	}

	/**
	 * 获得服务关联的默认物品相关信息 （废弃不用了）
	 * 
	 * @param srvrelmmdos
	 * @param id_org
	 * @param id_dep
	 * @throws BizException
	 */
	public static MedSrvRelMmDO getSrvRelDefaultMmDO(String id_srv, String id_org, String id_dep) throws BizException {
		CiOrdAppUtils.getBdSrvQryQryService().getMedSrvRelMmOrg(id_srv);
		MedSrvRelMmDO[] srvrelmmdos = CiOrdAppUtils.getMedsrvRelMmQryService().find(
				MedSrvRelMmDODesc.TABLE_ALIAS_NAME + ".id_srv='" + id_srv + "'", "id_org,id_dep,sortno",
				FBoolean.FALSE);
		return getSrvRelDefaultMmDO(srvrelmmdos, id_org, id_dep);
	}

	/**
	 * 获得服务关联的默认物品相关信息 （废弃不用了）
	 * 
	 * @param srvrelmmdos
	 * @param id_org
	 * @param id_dep
	 * @throws BizException
	 */
	public static MedSrvRelMmDO getSrvRelDefaultMmDO(MedSrvRelMmDO[] srvrelmmdos, String id_org, String id_dep)
			throws BizException {
		if (srvrelmmdos == null || srvrelmmdos.length == 0)
			return null;
		MedSrvRelMmDO rtn = null;

		// 部门匹配
		if (!OrSrvSplitUtil.isEmpty(id_dep)) {
			rtn = getDeptRelMmDO(srvrelmmdos, id_dep);
			if (rtn != null)
				return rtn;
		}

		// 组织匹配
		if (!OrSrvSplitUtil.isEmpty(id_org)) {
			rtn = getOrgRelMmDO(srvrelmmdos, id_org);
			if (rtn != null)
				return rtn;
		}

		rtn = getRelMmDO(srvrelmmdos);

		return rtn;
	}

	private static MedSrvRelMmDO getDeptRelMmDO(MedSrvRelMmDO[] srvrelmmdos, String id_dep) {
		for (int i = 0; i < srvrelmmdos.length; i++) {
			if (id_dep.equals(srvrelmmdos[i].getId_dep())) {
				return srvrelmmdos[i]; // 按道理讲应该有个默认标识 暂时先拿到首个吧
			}
		}
		return null;
	}

	private static MedSrvRelMmDO getOrgRelMmDO(MedSrvRelMmDO[] srvrelmmdos, String id_org) {
		for (int i = 0; i < srvrelmmdos.length; i++) {
			if (id_org.equals(srvrelmmdos[i].getId_org())) {
				return srvrelmmdos[i]; // 按道理讲应该有个默认标识 暂时先拿到首个吧
			}
		}
		return null;
	}

	private static MedSrvRelMmDO getRelMmDO(MedSrvRelMmDO[] srvrelmmdos) {
		for (int i = 0; i < srvrelmmdos.length; i++) {
			if (OrSrvSplitUtil.isEmpty(srvrelmmdos[i].getId_org())
					|| OrSrvSplitUtil.isEmpty(srvrelmmdos[i].getId_dep())) {
				return srvrelmmdos[i]; // 按道理讲应该有个默认标识 暂时先拿到首个吧
			}
		}
		return null;
	}

	/**
	 * 数组转换为FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	public static FArrayList array2FArrayList(BaseDO[] dos) {
		if (dos == null || dos.length == 0)
			return null;
		FArrayList rtnlist = new FArrayList();
		for (int i = 0; i < dos.length; i++) {
			rtnlist.add(dos[i]);
		}
		return rtnlist;
	}
	
	/**
	 * list集合转换为FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	public static FArrayList list2FArrayList(List<CiOrderDO> dos) {
		if (dos == null || dos.size() == 0)
			return null;
		FArrayList rtnlist = new FArrayList();
		for (CiOrderDO order : dos) {
			rtnlist.add(order);
		}
		return rtnlist;
	}

	/**
	 * 数组转换为FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	public static FArrayList array2FArrayList(Object[] dos) {
		if (dos == null || dos.length == 0)
			return null;
		FArrayList rtnlist = new FArrayList();
		for (int i = 0; i < dos.length; i++) {
			rtnlist.add(dos[i]);
		}
		return rtnlist;
	}

	/**
	 * FArrayList 转换成数组
	 * 
	 * @param list
	 * @return
	 */
	public static CiorderAggDO[] FArrayLiatToBaseDOArray(FArrayList list) {
		if (list == null || list.size() == 0)
			return null;
		CiorderAggDO[] obj = new CiorderAggDO[list.size()];
		for (int i = 0; i < list.size(); i++) {
			obj[i] = (CiorderAggDO) list.get(i);
		}
		return obj;
	}

	/**
	 * 数组转换为FMap
	 * 
	 * @param dos
	 * @return
	 */
	public static FMap array2FMap(BaseDO[] dos) {
		if (dos == null || dos.length == 0)
			return null;
		FMap rtnmap = new FMap();
		for (int i = 0; i < dos.length; i++) {
			rtnmap.put(dos[i].getPkVal(), dos[i]);
		}
		return rtnmap;
	}

	/**
	 * 数组对象为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Hashtable obj) {
		if (obj == null || obj.size() <= 0)
			return true;
		return false;
	}

	/**
	 * 数组对象为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		return false;
	}

	/**
	 * 数组对象为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Object[] objs) {
		if (objs == null || objs.length == 0)
			return true;
		return false;
	}

	/**
	 * Map列表为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(FMap map) {
		if (map == null || map.size() == 0)
			return true;
		return false;
	}

	/**
	 * HashMap为空
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(HashMap<?, ?> map) {
		if (map == null || map.size() == 0)
			return true;
		return false;
	}

	/**
	 * 数组列表为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(FArrayList list) {
		if (list == null || list.size() == 0)
			return true;
		return false;
	}

	/**
	 * 数组列表为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(ArrayList list) {
		if (list == null || list.size() == 0)
			return true;
		return false;
	}

	/**
	 * 数组列表为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(List list) {
		if (list == null || list.size() == 0)
			return true;
		return false;
	}

	/**
	 * 是否为空串判断
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input) {

		return StringUtils.isBlank(input);
	}

	/**
	 * 获得匹配的DO数据（主键id）
	 * 
	 * @param dos
	 * @param id
	 * @return
	 */
	public static <T extends BaseDO> T getMatchDatum(T[] dos, String id) {
		if (dos == null || dos.length == 0 || isEmpty(id))
			return null;
		for (int i = 0; i < dos.length; i++) {
			if (id.equals(dos[i].getPkVal()))
				return dos[i];
		}
		return null;
	}

	/**
	 * 获得id_srv_src关联的医嘱项目
	 * 
	 * @param orsrvdos
	 * @param id_srv_src
	 *            组合或套
	 * @param id_srv
	 *            组合或套内 的项目
	 * @return
	 */
	public static OrdSrvDO getMatchDatum(OrdSrvDO[] orsrvdos, String id_srv_src, String id_srv) {
		// 有效性校验
		if (isEmpty(orsrvdos) || isEmpty(id_srv_src) || isEmpty(id_srv))
			return null;
		// 遍历
		for (int i = 0; i < orsrvdos.length; i++) {
			if (id_srv_src.equals(orsrvdos[i].getId_srv_src()) && id_srv.equals(orsrvdos[i].getId_srv())) {
				return orsrvdos[i];
			}
		}

		return null;
	}

	/**
	 * 获得id_srv_src关联的医疗单项目数据是否全部未删除判断 漏洞比较大 暂时先按这个来处理
	 * 
	 * @param orsrvdos
	 * @param id_srv_src
	 *            组合或套
	 * @return
	 */
	public static boolean isEmsRelSrvAllDeleted(FArrayList emssrvs, String id_srv_src) {
		// 有效性校验
		if (isEmpty(emssrvs) || isEmpty(id_srv_src))
			return false;
		CiEmsSrvDTO emssrvdto = null;

		// 遍历
		for (int i = 0; i < emssrvs.size(); i++) {
			emssrvdto = (CiEmsSrvDTO) emssrvs.get(i);
			if (id_srv_src.equals(emssrvdto.getId_srv_src())) {
				if (emssrvdto.getStatus() != DOStatus.DELETED) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 获得id_srv_src关联的医疗单项目数据信息
	 * 
	 * @param orsrvdos
	 * @param id_srv_src
	 *            组合或套
	 * @param id_srv
	 *            组合或套内 的项目
	 * @return
	 */
	public static CiEmsSrvDTO getMatchDatum(FArrayList emssrvs, String id_srv_src, String id_srv) {
		// 有效性校验
		if (isEmpty(emssrvs) || isEmpty(id_srv_src) || isEmpty(id_srv))
			return null;
		CiEmsSrvDTO emssrvdto = null;

		// 遍历
		for (int i = 0; i < emssrvs.size(); i++) {
			emssrvdto = (CiEmsSrvDTO) emssrvs.get(i);
			if (id_srv_src.equals(emssrvdto.getId_srv_src()) && id_srv.equals(emssrvdto.getId_srv())) {
				return emssrvdto;
			}
		}

		return null;
	}

	/**
	 * 获得id_srv_src关联的医嘱项目并设置其状态未Deleted
	 * 
	 * @param rtnlist
	 * @param orsrvdos
	 * @param id_srv_src
	 */
	public static void setRelOrSrvDelStatus(ArrayList<OrdSrvDO> rtnlist, OrdSrvDO[] orsrvdos, String id_srv_src) {
		// 有效性校验
		if (isEmpty(orsrvdos) || isEmpty(id_srv_src))
			return;

		// 遍历
		for (int i = 0; i < orsrvdos.length; i++) {
			if (id_srv_src.equals(orsrvdos[i].getId_srv_src())) {
				orsrvdos[i].setStatus(DOStatus.DELETED);
				rtnlist.add(orsrvdos[i]);
			}
		}
	}

	/**
	 * 合并泛型列表
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static <T extends BaseDO> ArrayList<T> mergeArrayList(ArrayList<T> list1, ArrayList<T> list2) {
		if (list1 == null && list2 == null)
			return null;
		ArrayList<T> rtn = new ArrayList<T>();
		if (list1 != null && list1.size() != 0)
			rtn.addAll(list1);
		if (list2 != null && list2.size() != 0)
			rtn.addAll(list2);

		return rtn;

	}

	/**
	 * 获得匹配的DO数据
	 * 
	 * @param dos
	 * @param v
	 * @param vfieldname
	 * @return
	 */
	public static <T extends BaseDO> T getMatchDatum(T[] dos, String v, String vfieldname) {
		if (dos == null || dos.length == 0 || isEmpty(v) || isEmpty(vfieldname))
			return null;

		for (int i = 0; i < dos.length; i++) {
			if (v.equals(dos[i].getAttrVal(vfieldname)))
				return dos[i];
		}
		return null;
	}

	/**
	 * 获得匹配的DO数据索引项（仅皮试医嘱使用）
	 * 
	 * @param dos
	 * @param id_srv
	 * @return
	 */
	public static Integer getMatchedAggDOIndex4SkinTest(CiorderAggDO[] dos, String id_srv) {
		if (dos == null || dos.length == 0 || isEmpty(id_srv))
			return null;
		OrdSrvDO[] orsrvdos = null;

		for (int i = 0; i < dos.length; i++) {
			orsrvdos = dos[i].getOrdSrvDO();
			if (orsrvdos == null || orsrvdos.length == 0)
				continue;
			if (id_srv.equals(orsrvdos[0].getId_srv()))
				return i;
		}
		return null;
	}

	/**
	 * 设置删除标识
	 * 
	 * @param dos
	 */
	public static void setDelStatus(BaseDO[] dos) {
		if (isEmpty(dos))
			return;

		// 遍历
		for (int i = 0; i < dos.length; i++) {
			dos[i].setStatus(DOStatus.DELETED);
		}

	}

	/**
	 * list转换为数组
	 * 
	 * @param list
	 * @param c
	 * @return
	 */
	public static <T extends BaseDO> BaseDO[] list2Array(ArrayList list, Class<T> c) {
		return (T[]) list.toArray((T[]) Array.newInstance(c, 0));
	}

	/**
	 * list转换为数组
	 * 
	 * @param list
	 * @param c
	 * @return
	 */
	public static <T extends BaseDO> BaseDO[] list2Array(FArrayList list, Class<T> c) {
		return (T[]) list.toArray((T[]) Array.newInstance(c, 0));
	}

	/**
	 * DO数据是否为新增判断
	 * 
	 * @param do1
	 * @return
	 */
	public static boolean isDONew(BaseDO do1) {
		if (do1 == null || do1.getStatus() == DOStatus.NEW)
			return true;
		return false;
	}

	/**
	 * DO数据是否为删除判断
	 * 
	 * @param do1
	 * @return
	 */
	public static boolean isDODel(BaseDO do1) {
		if (do1 != null && do1.getStatus() == DOStatus.DELETED)
			return true;
		return false;
	}

	/**
	 * DO数据是否为修改判断
	 * 
	 * @param do1
	 * @return
	 */
	public static boolean isDOMod(BaseDO do1) {
		if (do1 != null && do1.getStatus() == DOStatus.UPDATED)
			return true;
		return false;
	}

	/**
	 * 医嘱明细Sortno排序  (与order相同的id_srv排第一)
	 * @return
	 */
	public static OrdSrvDO[]  rankSortno(String id_srv,OrdSrvDO[] srvs) {
		//入参校验
		if(CiOrdUtils.isEmpty(id_srv) ) {
			if(srvs==null || srvs.length<=0) {
				return null;
			}else{
				return srvs;
			}
		}
		// 将srvs里等于id_srv的sortno 置为1，其它顺排。
		int sort=2;
		for (OrdSrvDO ordSrvDO : srvs) {
			if(id_srv.equals(ordSrvDO.getId_srv())) {
				ordSrvDO.setSortno(1);
			}else {
				ordSrvDO.setSortno(sort);
				sort++;
			}
		}
		return srvs;
	}
	
	/**
	 * DO数据是否为未变化判断
	 * 
	 * @param do1
	 * @return
	 */
	public static boolean isDOUnChange(BaseDO do1) {
		if (do1 != null && do1.getStatus() == DOStatus.UNCHANGED)
			return true;
		return false;
	}

	/**
	 * 序号设置处理逻辑
	 * 
	 * @param orsrvdos
	 */
	public static void doSortNoHandle(BaseDO[] basedos, String attrname) {
		// 有效性校验
		if (basedos == null || basedos.length == 0)
			return;

		// 参数设置
		int iL = 1;
		if (isEmpty(attrname))
			attrname = ATTRNAME_SORTNO;

		// 遍历
		for (int i = 0; i < basedos.length; i++) {
			if (DOStatus.DELETED == basedos[i].getStatus())
				continue;
			basedos[i].setAttrVal(attrname, iL);
			iL += 1;
		}
	}

	/**
	 * 获得套内选择项目数量信息（临床费用项目个数）
	 * 
	 * @param ems
	 * @param srvsetitemindexs
	 * @return
	 * @throws BizException
	 */
	public static int getSrvsetMemberValidCnt(CiEmsDTO ems, Integer[] srvsetitemindexs) throws BizException {
		FArrayList list = ems.getEmssrvs();
		// 获取启用状态状态的套内项目（临床价格计算标识=Y）
		MedSrvSetItemDO[] bdsrvinset = getBdSrvSetItems4ClinicalBl(
				((CiEmsSrvDTO) list.get(srvsetitemindexs[0])).getId_srv());
		int rtn = 0;
		CiEmsSrvDTO emssrv = null;
		for (int i = 1; i < srvsetitemindexs.length; i++) {
			emssrv = (CiEmsSrvDTO) list.get(srvsetitemindexs[i]);
			if (DOStatus.DELETED == emssrv.getStatus())
				continue;
			if (!isClinicalBl(emssrv.getId_srv(), bdsrvinset))
				continue;
			rtn += 1;
		}

		return rtn;
	}

	/**
	 * 判断id_srv 对应的套内项目是否为临床费用项目
	 * 
	 * @param id_srv
	 *            服务id
	 * @param bdsrvinset
	 *            套内项目集合
	 * @return
	 */
	private static boolean isClinicalBl(String id_srv, MedSrvSetItemDO[] bdsrvinset) {
		if (isEmpty(bdsrvinset))
			return false;// 套内不包含非临床项目时返回false
		for (MedSrvSetItemDO itmdo : bdsrvinset) {
			if (id_srv.equals(itmdo.getId_srv_itm()) && isTrue(itmdo.getFg_clinical_bl()))
				return true;
		}
		return false;
	}

	/**
	 * 是否为套内项目判断
	 * 
	 * @param id_srv
	 * @param bdsrvinset
	 * @return
	 */
	public static boolean isIdSrvInSetItms(String id_srv, MedSrvSetItemDO[] bdsrvinset) {
		if (isEmpty(bdsrvinset))
			return false;// 套内非临床项目为空时返回false
		for (MedSrvSetItemDO itmdo : bdsrvinset) {
			if (id_srv.equals(itmdo.getId_srv_itm()))
				return true;
		}
		return false;
	}

	/**
	 * 获得服务套内项目集合信息 FG_Clinical_Bl='Y'
	 * 
	 * @param id_srv_set套id
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] getBdSrvSetItems4ClinicalBl(String id_srv_set) throws BizException {
		String tbaliasname = MedSrvSetItemDODesc.TABLE_ALIAS_NAME;
		String clinicalStr = "";
		String acvtivestr = " and " + tbaliasname + ".fg_active='Y' ";
		clinicalStr = " and " + tbaliasname + ".fg_clinical_bl='Y' ";
		MedSrvSetItemDO[] do1 = CiOrdAppUtils.getMedSrvSetItemRService().find(
				tbaliasname + ".id_srv= '" + id_srv_set + "' " + clinicalStr + acvtivestr, "sortno", FBoolean.FALSE);
		if (do1 == null || do1.length == 0)
			return null;
		return do1;
	}

	/**
	 * Integer转换为字符串
	 * 
	 * @param input
	 * @return
	 */
	public static String Integer2String(Integer input) {
		if (input == null)
			return "";
		return input.toString();
	}

	/**
	 * 申请单相关数据处理
	 * 
	 * @param id_or
	 * @param iemstp
	 */
	public static String getOrAppClizname(Integer iemstp) {
		if (EmsType.LIS.equals(iemstp)) {
			return OrdApLabDODesc.CLASS_FULLNAME;
		} else if (EmsType.RIS.equals(iemstp)) {
			return OrdApObsDODesc.CLASS_FULLNAME;
		} else if (EmsType.OPER.equals(iemstp)) {
			return OrdApOpDODesc.CLASS_FULLNAME;
		} else if (EmsType.PATHGY.equals(iemstp)) {
			return OrdApPathgyDODesc.CLASS_FULLNAME;
		} else if (EmsType.BT.equals(iemstp)) {
			return OrdApBtDODesc.CLASS_FULLNAME;
		} else if (EmsType.CONS.equals(iemstp)) {
			return OrdApConsDODesc.CLASS_FULLNAME;
		} else if (EmsType.BTUSE.equals(iemstp)) {
			return OrdAppBtUseDODesc.CLASS_FULLNAME;
		} else if (EmsType.TRANSDEPT.equals(iemstp)) {
			return OrdApTransDODesc.CLASS_FULLNAME;
		} else if (EmsType.OUTHOSP.equals(iemstp)) {
			return OrdApOutDODesc.CLASS_FULLNAME;
		} else if (EmsType.DIET.equals(iemstp)) {
			return OrdApDietDODesc.CLASS_FULLNAME;
		}
		return "";
	}

	/**
	 * 设置Ems数据中申请单相关数据信息
	 * 
	 * @param datum
	 * @param emsdto
	 * @param iemstp
	 */
	public static void setEmsAppDatum(Object[] datum, CiEmsDTO emsdto, int iemstp) {
		if (CiOrdUtils.isEmpty(datum))
			return;
		FMap map = new FMap();
		map.put(iemstp + "", datum[0]);
		emsdto.setOrapplysheet(map);
	}

	/**
	 * 获得长临标识对应的字符串值0临时 1长期
	 * 
	 * @param fg_long
	 * @return
	 */
	public static String getFg_longStr(FBoolean fg_long) {
		if (isEmpty(fg_long))
			return "";
		if (fg_long.booleanValue())
			return "1";
		return "0";
	}

	public static String getSrvReactIdStrs(SrvReactDTO[] srvreacts) {
		// 有效性校验
		if (srvreacts == null || srvreacts.length == 0)
			return null;
		String rtn = "", id_srvreact = "";

		// 遍历
		for (int i = 0; i < srvreacts.length; i++) {
			id_srvreact = srvreacts[i].getId_srvreact();
			if (CiOrdUtils.isInStr(CiOrdUtils.COMMA_STR + id_srvreact, rtn))
				continue;
			rtn += CiOrdUtils.COMMA_STR + id_srvreact;
		}

		// 返回
		return rtn.substring(1);
	}

	/**
	 * 服务互斥数据进行分组处理
	 * 
	 * @param srvreacts
	 * @return
	 */
	public static Hashtable<String, ArrayList<SrvReactDTO>> getSrvReactHt(SrvReactDTO[] srvreacts) {
		if (srvreacts == null || srvreacts.length == 0)
			return null;
		Hashtable<String, ArrayList<SrvReactDTO>> rtnHt = new Hashtable<String, ArrayList<SrvReactDTO>>();
		ArrayList<SrvReactDTO> list = null;
		String key = "";
		for (int i = 0; i < srvreacts.length; i++) {
			// 全排斥情况处理
			if (IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL.equals(srvreacts[i].getSd_reacttp())) {// 全排斥
				key = IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL;
				if (rtnHt.containsKey(key)) {
					list = rtnHt.get(key);
					list.add(srvreacts[i]);
				} else {
					list = new ArrayList<SrvReactDTO>();
					list.add(srvreacts[i]);
					rtnHt.put(key, list);
				}
			} else if (IBdSrvDictCodeConst.SD_REACTTP_GRPINEXCLUDE.equals(srvreacts[i].getSd_reacttp())) {// 非全排
				key = srvreacts[i].getId_srvreact();
				if (rtnHt.containsKey(key)) {
					list = rtnHt.get(key);
					list.add(srvreacts[i]);
				} else {
					list = new ArrayList<SrvReactDTO>();
					list.add(srvreacts[i]);
					rtnHt.put(key, list);
				}
			} else {// 其它

			}
		}
		return rtnHt;
	}

	/**
	 * 根据医嘱聚集数据获得医嘱项目医疗服务字符串 ,01010,01001,010910,
	 * 
	 * @param aggdo
	 * @return
	 */
	public static String getSrvStr8OrAggDO(CiorderAggDO aggdo) {
		if (aggdo == null)
			return null;
		OrdSrvDO[] orsrvdos = aggdo.getOrdSrvDO();
		if (orsrvdos == null || orsrvdos.length == 0)
			return null;
		String rtnstr = "";
		for (int i = 0; i < orsrvdos.length; i++) {
			rtnstr += COMMA_STR + orsrvdos[i].getId_srv();
		}
		return rtnstr + COMMA_STR;
	}

	/**
	 * 前后增加英文逗号
	 * 
	 * @param input
	 * @return
	 */
	public static String AddDblComma(String input) {
		if (isEmpty(input))
			return input;
		return COMMA_STR + input + COMMA_STR;
	}

	/**
	 * 中文名称的与连接串 名1、名2、名3与名4
	 * 
	 * @param names
	 * @return
	 */
	public static String getChineseNamesStr(String[] names) {
		if (names == null || names.length == 0)
			return "";
		String rtn = "";
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				rtn = names[i];
			} else if (i == names.length - 1) {
				rtn += CiOrdUtils.PUNCTUATION_STR + names[i];
			} else {
				rtn += CiOrdUtils.CHINESE_AND_STR + names[i];
			}
		}
		return rtn;
	}

	/**
	 * 中文名称的与连接串 [名1、名2、名3与名4]
	 * 
	 * @param names
	 * @return
	 */
	public static String getChineseNamesStrWithBracket(String[] names) {
		if (names == null || names.length == 0)
			return "";
		return CiOrdUtils.LBRACKET_STR + getChineseNamesStr(names) + CiOrdUtils.RBRACKET_STR;
	}

	/**
	 * 获得单字段sql值数组集合（字符串类型）
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static String[] getSingleFldValues(String sql) throws BizException {
		GetSingleFldValuesBP bp = new GetSingleFldValuesBP();
		return bp.exec(sql);
	}

	/**
	 * 获得服务对应的执行科室 （最新的）
	 * 
	 * @return
	 * @throws BizException
	 */
	public static ExeWhDeptDTO getMpDeptID(ExeDeptCalParamDTO exedeptcalparam) throws BizException {
		GetExeDepts8DepcalparamBP bp = new GetExeDepts8DepcalparamBP();
		OrWfExDeptDTO[] deptdtos = bp.exec(exedeptcalparam);
		if (CiOrdUtils.isEmpty(deptdtos))
			return new ExeWhDeptDTO();
		return getExeWhDeptInfo(deptdtos);
	}

	/**
	 * 获得服务对应的执行科室 （最新的）
	 * 
	 * @return
	 * @throws BizException
	 */
	public static ExeWhDeptDTO getMpDeptID(CiEmsDTO ems, int index, FDateTime dt_effe) throws BizException {
		GetExeDepts8EmsSrvBP bp = new GetExeDepts8EmsSrvBP();
		OrWfExDeptDTO[] deptdtos = bp.exec(ems, index, dt_effe);
		if (CiOrdUtils.isEmpty(deptdtos))
			return new ExeWhDeptDTO();
		return getExeWhDeptInfo(deptdtos);
	}

	private static ExeWhDeptDTO getExeWhDeptInfo(OrWfExDeptDTO[] deptdtos) {
		ExeWhDeptDTO rtndto = new ExeWhDeptDTO();
		boolean isExe = false, isWh = false;
		for (int i = 0; i < deptdtos.length; i++) {
			if (deptdtos[i].getEu_wftp() == EnumFlow.EXECUTEFLOW && !isExe) {
				setExeWhDeptDTO(rtndto, deptdtos[i], true);
				isExe = true;
			} else if (deptdtos[i].getEu_wftp() == EnumFlow.SUPPLIESFLOW && !isWh) {
				setExeWhDeptDTO(rtndto, deptdtos[i], false);
				isWh = true;
			}
		}
		return rtndto;
	}

	/**
	 * 设置执行科室或物资流向科室
	 * 
	 * @param rtndto
	 * @param depdto
	 * @param isExeDep
	 *            true 设置执行科室， false 设置物资流向科室
	 */
	private static void setExeWhDeptDTO(ExeWhDeptDTO rtndto, OrWfExDeptDTO depdto, boolean isExeDep) {
		if (isExeDep) {
			rtndto.setId_org_mp(depdto.getId_org());
			rtndto.setCode_org_mp(depdto.getCode_org());
			rtndto.setName_org_mp(depdto.getName_org());
			rtndto.setId_dep_mp(depdto.getId_dept());
			rtndto.setCode_dep_mp(depdto.getCode_dept());
			rtndto.setName_dep_mp(depdto.getName_dept());
		} else {
			rtndto.setId_org_wh(depdto.getId_org());
			rtndto.setCode_org_wh(depdto.getCode_org());
			rtndto.setName_org_wh(depdto.getName_org());
			rtndto.setId_dep_wh(depdto.getId_dept());
			rtndto.setCode_dep_wh(depdto.getCode_dept());
			rtndto.setName_dep_wh(depdto.getName_dept());
		}
	}

	/**
	 * 获得医嘱流向科室数据信息
	 * 
	 * @param deptdtos
	 * @return
	 */
	public static OrWfDeptInfoDTO getOrWfDeptInfo(OrWfExDeptDTO[] deptdtos) {
		OrWfDeptInfoDTO rtndto = new OrWfDeptInfoDTO();
		String Id_mp_depts = "";
		String Id_phy_depts = "";
		FArrayList exedepts = new FArrayList();
		FArrayList whdepts = new FArrayList();
		boolean sourceFlag = false;
		for (int i = 0; i < deptdtos.length; i++) {
			if ("1".equals(deptdtos[i].getMp_source())) {
				sourceFlag = true;
			}
			if (deptdtos[i].getEu_wftp() == EnumFlow.EXECUTEFLOW) {// 执行流向
				exedepts.add(deptdtos[i]);
				Id_mp_depts += ",'" + deptdtos[i].getId_dept() + "'";
			} else if (deptdtos[i].getEu_wftp() == EnumFlow.SUPPLIESFLOW) { // 物资流向
				whdepts.add(deptdtos[i]);
				Id_phy_depts += ",'" + deptdtos[i].getId_dept() + "'";
			} else {// 暂时都放 ????
				Id_mp_depts += ",'" + deptdtos[i].getId_dept() + "'";
				exedepts.add(deptdtos[i]);
				whdepts.add(deptdtos[i]);
			}
		}
		if (sourceFlag) {
			rtndto.setMp_source("1");
		}
		if (Id_mp_depts != "") {
			rtndto.setId_mp_depts(Id_mp_depts.substring(1));
		}
		if (Id_phy_depts != "") {
			rtndto.setId_dept_whs(Id_phy_depts.substring(1));
		}
		orWfDeptInfoHandle(rtndto, exedepts, whdepts);
		rtndto.setOrwfexedepts(exedepts);
		rtndto.setPharmwfwhdepts(whdepts);
		return rtndto;
	}

	private static void orWfDeptInfoHandle(OrWfDeptInfoDTO rtndto, FArrayList exedepts, FArrayList whdepts) {
		if (!isEmpty(exedepts)) {
			rtndto.setFirstid_mp_dept(((OrWfExDeptDTO) exedepts.get(0)).getId_dept());
			rtndto.setFirstname_mp_dept(((OrWfExDeptDTO) exedepts.get(0)).getName_dept());
		}

		if (!isEmpty(whdepts)) {
			rtndto.setId_dept_wh(((OrWfExDeptDTO) whdepts.get(0)).getId_dept());
			rtndto.setName_dept_wh(((OrWfExDeptDTO) whdepts.get(0)).getName_dept());
		}
	}

	/**
	 * 获得服务对应的执行科室 （将废弃不用了）
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getMpDeptID(CiEmsDTO ems, OrdSrvDO srvdo) throws BizException {
		OrWfExDeptParamDTO param = getOrWfExDeptParam(ems, srvdo);
		CiOrSrvExecuteDeptGetBP bp = new CiOrSrvExecuteDeptGetBP();
		OrWfExDeptDTO[] do1 = bp.exec(param);
		if (do1 == null || do1.length == 0)
			return null;
		return do1[0].getId_dept();
	}

	/**
	 * 新方法返回数组 （将废弃不用了）
	 * 
	 * @param ems
	 * @param srvdo
	 * @return
	 * @throws BizException
	 */
	public static OrWfExDeptDTO getMpDeptID_new(CiEmsDTO ems, OrdSrvDO srvdo) throws BizException {
		OrWfExDeptParamDTO param = getOrWfExDeptParam(ems, srvdo);
		CiOrSrvExecuteDeptGetBP bp = new CiOrSrvExecuteDeptGetBP();
		OrWfExDeptDTO[] do1 = bp.exec(param);
		if (do1 == null || do1.length == 0)
			return null;
		return do1[0];
	}

	private static OrWfExDeptParamDTO getOrWfExDeptParam(CiEmsDTO ems, OrdSrvDO srvdo) {
		OrWfExDeptParamDTO param = new OrWfExDeptParamDTO();
		param.setCode_entp(ems.getCode_entp());
		param.setSd_srvtp(srvdo.getSd_srvtp());
		param.setId_srvca(srvdo.getId_srvca());
		param.setId_usage(srvdo.getId_route());
		param.setRecurstr(CiOrdUtils.getFg_longStr(ems.getFg_long()));
		// param.setWeekno();
		// param.setTimestr();
		param.setId_srv(srvdo.getId_srv());
		// param.setId_mm();
		param.setId_dept_en(ems.getId_dept_en());
		param.setId_dept_ns(ems.getId_dept_ns());
		param.setId_dept_or(ems.getId_dep_phy());
		// param.setId_dept_ex();
		// param.setReserv1(""); //所属套
		// param.setReserv2();
		// param.setReserv3();

		return param;
	}

	/**
	 * 是否为医嘱签署
	 * 
	 * @param or
	 * @return
	 */
	public static boolean isOrSign(CiOrderDO or) {
		if (or == null)
			return false;
		if (OrSrvSplitUtil.isTrue(or.getFg_sign()) && !OrSrvSplitUtil.isTrue(or.getFg_chk())
				&& ICiDictCodeConst.SD_SU_BL_NONE.equals(or.getSd_su_bl())
				&& ICiDictCodeConst.SD_SU_MP_NONE.equals(or.getSd_su_mp()))
			return true;
		return false;
	}

	/**
	 * 是否为诊断签署
	 * 
	 * @param or
	 * @return
	 */
	public static boolean isDiagSign(CiDiagDO diagdo) {
		if (diagdo == null)
			return false;
		if (OrSrvSplitUtil.isTrue(diagdo.getFg_sign()))
			return true;
		return false;
	}

	/**
	 * 获得sql条件串片段 ids为逗号分隔的串
	 * 
	 * @param _ids
	 * @return
	 */
	public static String getCondStrWithEqualOrIn(String _ids) {
		if (_ids.indexOf(COMMA_STR) > 0) {
			return IN_STR_WITHBLANK + LBRACE_STR + _ids + RBRACE_STR;
		}

		return EQUAL_STR + _ids;
	}

	/**
	 * 获得sql条件串片段
	 * 
	 * @param id
	 * @return
	 */
	public static String getSqlCondStr(String id) {
		return SQUOTE_MARK_STR + id + SQUOTE_MARK_STR;
	}

	/**
	 * 获得sql条件串片段
	 * 
	 * @param id
	 * @return
	 */
	public static String getSqlCondStrWithComma(String id) {
		return COMMA_STR + SQUOTE_MARK_STR + id + SQUOTE_MARK_STR;
	}

	/**
	 * 获得日期对应年月日数据信息
	 * 
	 * @param dt
	 * @return
	 */
	public static int[] getDateYMD(FDate dt) {
		if (dt == null)
			return null;
		int year = dt.getYear();
		int month = dt.getMonth();
		int day = dt.getDay();
		return new int[] { year, month, day };
	}

	/**
	 * 获得日期对应年月日数据信息
	 * 
	 * @param dt
	 * @return
	 */
	public static int[] getDateYMD(FDateTime dt) {
		if (dt == null)
			return null;
		int year = dt.getYear();
		int month = dt.getMonth();
		int day = dt.getDay();
		return new int[] { year, month, day };
	}

	/**
	 * 
	 * @param dt_birth
	 * @param CutoutMode
	 *            天进位方式： 0 截去天数据 1 天数不空按月计 2 四舍五入
	 * @return
	 * @throws BizException
	 */
	public static int getAgeMonth(FDate dt_birth, int iDayCutoutMode) throws BizException {
		int[] ymd = getAgeYMDInfo(dt_birth);
		int month = 12 * ymd[0] + ymd[1];

		if (ymd[2] == 0)
			return month;
		if (iDayCutoutMode == 0)
			return month;
		if (iDayCutoutMode == 1 && ymd[2] > 0)
			return month + 1;
		double d = (ymd[2] * 1.0) / 30.0;
		return month + (int) (Math.round(d));
	}

	/**
	 * 获得年月日年龄数据信息 年、月、日数组信息
	 * 
	 * @param dt_birth
	 * @return
	 * @throws BizException
	 */
	public static int[] getAgeYMDInfo(FDate dt_birth) throws BizException {
		if (dt_birth == null)
			return null;
		FDateTime sysDate = CiOrdAppUtils.getServerDateTime();
		int[] sysYMD = CiOrdUtils.getDateYMD(sysDate);
		int[] birthYMD = CiOrdUtils.getDateYMD(dt_birth);
		int[] ymd = substractYMD(sysYMD, birthYMD);
		return ageAbsHandle(ymd);
	}

	/**
	 * 数组减法运算 年月日
	 * 
	 * @param sysYMD
	 * @param birthYMD
	 * @return
	 */
	private static int[] substractYMD(int[] sysYMD, int[] birthYMD) {
		int[] rtn = new int[3];
		rtn[0] = sysYMD[0] - birthYMD[0];
		rtn[1] = sysYMD[1] - birthYMD[1];
		rtn[2] = sysYMD[2] - birthYMD[2];
		return rtn;
	}

	/**
	 * 获得进制后的岁月日数组数据
	 * 
	 * @param ymd
	 * @return
	 * @throws BizException
	 */
	private static int[] ageAbsHandle(int[] ymd) throws BizException {
		int[] rtn = new int[3];
		int years = ymd[0];
		int months = ymd[1];
		int days = ymd[2];
		if (days < 0) {
			rtn[2] = 30 + days;
			months = months - 1;
		} else {
			rtn[2] = days;
		}

		if (months < 0) {
			rtn[1] = 12 + months;
			years = years - 1;
		} else {
			rtn[1] = months;
		}

		rtn[0] = years;
		if (years < 0) {
			throw new BirthDateMoreThanSysDateException();
		}

		return rtn;
	}

	/**
	 * 按模式获得时间区间,前后days，因为有可能护士提前执行了
	 * 
	 * @param dt
	 * @param days
	 * @param iNDaysTimeCalValidMode
	 * @return
	 */
	public static FDateTime[] getTimeSection(FDateTime dt, int days, Integer iNDaysTimeCalValidMode) {
		FDateTime[] rtns = new FDateTime[] { dt, dt };
		if (NDaysTimeCalValidMode.VALIDWITHIN24HOURMODE.equals(iNDaysTimeCalValidMode)) {
			rtns[0] = dt.getDateTimeBefore(days);
		} else if (NDaysTimeCalValidMode.VALIDFROMDATESTARTMODE.equals(iNDaysTimeCalValidMode)) {
			rtns[0] = new FDateTime((dt.getDateTimeBefore(days)).getBeginDate(), new FTime("00:00:00"));
		} else {
			rtns[0] = new FDateTime((dt.getDateTimeBefore(days)).getBeginDate(), new FTime("00:00:00"));
		}
		rtns[1] = dt.getDateTimeAfter(days);
		return rtns;
	}

	/***
	 * 是否为TRUE
	 * 
	 * @param isA
	 * @return
	 */
	public static boolean isTrue(FBoolean isA) {
		if (isA == null)
			return false;
		return isA.booleanValue();
	}

	/**
	 * 根据id_srv获得医疗服务药品属性信息
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvDrugDO getBdSrvDrugDO(String id_srv) throws BizException {
		String whereStr = MedSrvDrugDODesc.TABLE_ALIAS_NAME + "." + MedSrvDrugDO.ID_SRV + "='" + id_srv + "'";
		MedSrvDrugDO[] dos = CiOrdAppUtils.getIMedSrvDrugDORService().find(whereStr, "", FBoolean.FALSE);
		if (isEmpty(dos))
			return null;
		return dos[0];
	}

	/**
	 * 根据id_srvs获得医疗服务药品属性信息
	 * 
	 * @param id_srvs
	 * @return
	 * @throws BizException
	 */
	public static MedSrvDrugDO[] getBdSrvDrugsDO(String id_srv) throws BizException {
		String whereStr = MedSrvDrugDODesc.TABLE_ALIAS_NAME + "." + MedSrvDrugDO.ID_SRV + "='" + id_srv + "'";
		MedSrvDrugDO[] dos = CiOrdAppUtils.getIMedSrvDrugDORService().find(whereStr, "", FBoolean.FALSE);
		if (isEmpty(dos))
			return null;
		return dos;
	}

	/**
	 * 获得就诊科室及相关就诊病区
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public static String[] getPatEnDepInfo(String id_en) throws BizException {
		PatiVisitDO pvdo = CiOrdAppUtils.getPativisitQryService().findById(id_en);
		if (isEmpty(pvdo))
			return new String[] { "", "" };
		return new String[] { pvdo.getId_dep_phy(), pvdo.getId_dep_nur() };
	}

	/**
	 * 医疗单项目是否为组合定价模式的逻辑判断 （非套 非套内项目的情形） 套的已经在套逻辑中处理了
	 * 
	 * @param emssrvdto
	 * @return
	 * @throws BizException
	 */
	public static boolean isSrvCompPriMd(CiEmsSrvDTO emssrvdto) throws BizException {
		if (CiOrdUtils.isEmpty(emssrvdto))
			return false;
		if (isSrvSetRel(emssrvdto))
			return false;
		if (!CiOrdUtils.isTrue(emssrvdto.getFg_or()))
			return false;
		if (isSrvCompPriMd(emssrvdto.getId_srv()))
			return true; // 现求 不太优化

		return false;
	}

	/**
	 * 是否套及相关项目
	 * 
	 * @param emssrvdto
	 * @return
	 */
	private static boolean isSrvSetRel(CiEmsSrvDTO emssrvdto) {
		// 套本身
		if (CiOrdUtils.isTrue(emssrvdto.getFg_set()))
			return true;
		// 套内项目
		// if(!CiOrdUtils.isEmpty(emssrvdto.getId_srv_set()))return true; //
		// 2016-12-19 套内项目不支持组合计价时
		return false;
	}

	/**
	 * 服务是否为组合定价
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private static boolean isSrvCompPriMd(String id_srv) throws BizException {
		MedSrvDO srvdo = CiOrdAppUtils.getMedsrvMDORService().findById(id_srv);
		if (isEmpty(srvdo))
			return false;
		if (IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(srvdo.getId_primd()))
			return true;
		return false;
	}

	/**
	 * 药品是否需皮试判断逻辑
	 * 
	 * @param srvdo
	 * @return
	 */
	public static boolean isNeedSkinTest(CiEmsSrvDTO srvdto) {
		if (CiOrdUtils.isEmpty(srvdto))
			return false;
		if (!CiOrdUtils.isTrue(srvdto.getFg_skintest()))
			return false;
		// if(!CiOrdUtils.isEmpty(srvdto.getSd_skintest_skip_reason()))return
		// false;
		if (!CiOrdUtils.isEmpty(srvdto.getId_reltp()) && !CiOrdUtils.isEmpty(srvdto.getSd_reltp())
				&& ICiDictCodeConst.SD_RELTYPE_SKINTEST.equals(srvdto.getSd_reltp())
				&& !CiOrdUtils.isEmpty(srvdto.getId_or_rel())) {
			return false;
		}
		if (!CiOrdUtils.isTrue(srvdto.getFg_mm()))
			return false;
		if (CiOrdUtils.isEmpty(srvdto.getId_mm()))
			return false;
		return true;
	}

	/**
	 * 药品是否需皮试判断逻辑
	 * 
	 * @param srvdo
	 * @return
	 */
	public static boolean isNeedSkinTest(EmsOrDrug srvdto) {
		if (CiOrdUtils.isEmpty(srvdto))
			return false;
		if (!CiOrdUtils.isTrue(srvdto.getFg_skintest()))
			return false;
		// if(!CiOrdUtils.isEmpty(srvdto.getSd_skintest_skip_reason()))return
		// false;
		if (!CiOrdUtils.isEmpty(srvdto.getId_reltp()) && !CiOrdUtils.isEmpty(srvdto.getSd_reltp())
				&& ICiDictCodeConst.SD_RELTYPE_SKINTEST.equals(srvdto.getSd_reltp())
				&& !CiOrdUtils.isEmpty(srvdto.getId_or_rel())) {
			return false;
		}
		if (!CiOrdUtils.isTrue(srvdto.getFg_mm()))
			return false;
		if (CiOrdUtils.isEmpty(srvdto.getId_mm()))
			return false;
		return true;
	}

	/**
	 * 获得医疗单项目中对应的服务与药品id字符串数据信息
	 * 
	 * @param srvdtos
	 * @param i
	 * @return
	 */
	public static String getIdSrvAndMm(FArrayList srvdtos, int i) {
		CiEmsSrvDTO emsdto = (CiEmsSrvDTO) srvdtos.get(i);
		return emsdto.getId_srv() + CiOrdUtils.COMMA_STR + emsdto.getId_mm();
	}

	/**
	 * 获取医嘱项目中对应id_or值得处理逻辑
	 * 
	 * @param ordo
	 * @param id_orinsrvdto
	 * @return
	 */
	public static String getCiOrderId(CiOrderDO ordo, String id_orinsrvdto) {
		if (!isEmpty(id_orinsrvdto))
			return id_orinsrvdto;
		if (isEmpty(ordo))
			return null;
		if (!isEmpty(ordo.getId_or()))
			return ordo.getId_or();
		return null;
	}

	/**
	 * 是否医嘱频次与医嘱项目频次相同
	 * 
	 * @param ordo
	 * @param orsrvdo
	 * @return
	 */
	public static boolean isOrAndOrSrvFreqSame(CiOrderDO ordo, OrdSrvDO orsrvdo) {
		if (isEmpty(ordo) || isEmpty(orsrvdo))
			return false;
		if (isEmpty(ordo.getId_freq()) || isEmpty(orsrvdo.getId_freq()))
			return false;
		if (ordo.getId_freq().equals(orsrvdo.getId_freq()))
			return true;
		return false;
	}

	/**
	 * 获得用法关联费用时费用服务的频次ID
	 * 
	 * @param ordo
	 * @return
	 */
	public static String getUsageRelFeeIdFreq(CiOrderDO ordo) {
		if (isEmpty(ordo))
			return null;
		if (!isHerbOrder(ordo.getSd_srvtp())) {// 非草药
			return ordo.getId_freq();
		}

		// 草药且有待煎,一条医嘱的代煎费的频次为1次
		if (isHerbBoil(ordo)) {
			return IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE;
		}

		return null;
	}

	/**
	 * 是否是草药医嘱
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isHerbOrder(String sd_srvtp) {
		if (CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG))
			return true;
		return false;
	}

	/**
	 * 是否是药品医嘱
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isPharmOrder(String sd_srvtp) {
		if (CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DRUG))
			return true;
		return false;
	}

	/**
	 * 是否西成药在院执行给药途径医嘱类型
	 * 
	 * @param id_route
	 *            医嘱用法
	 * @param grpableusgstr
	 *            可成组用法串
	 * @return
	 */
	public static boolean isWesternMedicineIVOr(String id_route, String grpableusgstr) {
		if (CiOrdUtils.isEmpty(grpableusgstr))
			return false;
		if (CiOrdUtils.isEmpty(id_route))
			return false;

		if (grpableusgstr.indexOf(id_route) >= 0)
			return true;

		return false;
	}

	/**
	 * 是否西成药成组医嘱类型
	 * 
	 * @param id_route
	 * @return
	 * @throws BizException
	 */
	public static boolean isWesternMedicineIVOr(String id_route) throws BizException {
		String grpableusgstr = ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(),
				ICiOrdNSysParamConst.SYS_PARAM_CiPharmGrpableUsageScope);
		return isWesternMedicineIVOr(id_route, grpableusgstr);
	}

	/**
	 * 获得组织级参数值
	 * 
	 * @param parmacode
	 * @return
	 */
	public static String getOrgParamStr(String parmacode) {
		try {
			return ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(), parmacode);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 是否草药待煎
	 * 
	 * @param ordo
	 * @return
	 */
	public static boolean isHerbBoil(CiOrderDO ordo) {
		if (!isHerbOrder(ordo.getSd_srvtp()))
			return false;
		if (hasHerbBoil(ordo)) {
			return true;
		}
		return false;
	}

	/**
	 * 是否有待煎
	 * 
	 * @param ordo
	 * @return
	 */
	public static boolean hasHerbBoil(CiOrderDO ordo) {
		if (CiOrdUtils.isTrue(ordo.getFg_boil()) && !isEmpty(ordo.getOrders_boil()) && ordo.getOrders_boil() > 0) {
			return true;
		}
		return false;
	}

	public static void copyObject(Object from, Object to) {
		Class fclass = from.getClass();
		Class tclass = to.getClass();
		Field[] cFields = tclass.getDeclaredFields();
		try {
			for (Field field : cFields) {
				field.setAccessible(true);
				Object cvalue = field.get(fclass);
				String ckey = cvalue.toString();
				Method fMethod;
				Method tMethod;
				Object fValue;
				try {
					fMethod = fclass.getMethod("get" + ckey);
					fValue = fMethod.invoke(from);
					tMethod = tclass.getMethod("set" + ckey, fValue.getClass());
					tMethod.invoke(to, fValue);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * 通过类的方法进行赋值
	 * 
	 * @param from
	 * @param to
	 */
	public static void copyObjectByMethod(Object from, Object to) {
		Class fclass = from.getClass();
		Class tclass = to.getClass();
		Field[] cFields = tclass.getDeclaredFields();
		Method[] fmethods = fclass.getDeclaredMethods();
		try {
			for (Method fmd : fmethods) {
				String fname = fmd.getName();
				if (fname.startsWith("get")) {
					Object fvalue = fmd.invoke(from);
					Method tmethod = tclass.getMethod("set" + fname.substring(3), fvalue.getClass());
					if (tmethod == null)
						continue;
					tmethod.invoke(to, fvalue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据前台传入的医疗单项目获得对应的医嘱项目
	 * 
	 * @param aggdo
	 * @param ems
	 * @param i
	 * @return
	 */
	public static OrdSrvDO getOrSrvDO(CiorderAggDO aggdo, CiEmsDTO ems, int i) {
		if (CiOrdUtils.isEmpty(aggdo))
			return null;
		CiEmsSrvDTO srvdto = (CiEmsSrvDTO) ems.getEmssrvs().get(i);
		String id_orsrv = srvdto.getId_orsrv();
		if (CiOrdUtils.isEmpty(id_orsrv))
			return null;
		OrdSrvDO[] orsrvdos = aggdo.getOrdSrvDO();
		for (int j = 0; j < orsrvdos.length; j++) {
			if (id_orsrv.equals(orsrvdos[j].getId_orsrv()))
				return orsrvdos[j];
		}
		return null;
	}

	/**
	 * 获得医嘱中在院执行次数 含待煎付数返回逻辑
	 * 
	 * @param ordo
	 * @return
	 */
	public static Integer getOrTimesMpInHosp(CiOrderDO ordo, UsageRelFeeSrvDO usgrelfeesrvdo) {
		// 2016-11-14 新增待煎付数 相关返回逻辑
		if (usgrelfeesrvdo.getReltype() == OrSrvSourceFromEnum.BOILRELFEE) {
			return ordo.getOrders_boil();
		}
		if (!isEmpty(ordo) && isTrue(ordo.getFg_mp_in()) && !isEmpty(ordo.getTimes_mp_in()))
			return ordo.getTimes_mp_in();
		return null;
	}

	/**
	 * 获得用法关联费用项目对应的费用项目数量
	 * 
	 * @param usgrelfeesrvdo
	 * @return
	 * @throws CiOrUsgRelFeeSrvQuanNullException
	 */
	public static FDouble getQuan_Med4UsgRelFeeSrv(UsageRelFeeSrvDO usgrelfeesrvdo)
			throws CiOrUsgRelFeeSrvQuanNullException {
		FDouble quan_fee = usgrelfeesrvdo.getQuan_medu();
		if (CiOrdUtils.isEmpty(quan_fee))
			throw new CiOrUsgRelFeeSrvQuanNullException();
		return quan_fee;
	}

	public static Integer getRelType_Med4UsgRelFeeSrv(UsageRelFeeSrvDO usgrelfeesrvdo)
			throws CiOrUsgRelFeeSrvRelTypeNullException {
		Integer reltype = usgrelfeesrvdo.getReltype();
		if (CiOrdUtils.isEmpty(reltype))
			throw new CiOrUsgRelFeeSrvRelTypeNullException();
		return reltype;
	}

	/**
	 * 获得用法关联费用项目对应的费用项目包装单位
	 * 
	 * @param usgrelfeesrvdo
	 * @return
	 * @throws CiOrUsgRelFeeSrvQuanNullException
	 * @throws CiOrUsgRelFeeSrvUnitNullException
	 */
	public static String getUnit4UsgRelFeeSrv(UsageRelFeeSrvDO usgrelfeesrvdo)
			throws CiOrUsgRelFeeSrvQuanNullException, CiOrUsgRelFeeSrvUnitNullException {
		String medu = usgrelfeesrvdo.getId_unit();
		if (CiOrdUtils.isEmpty(medu))
			throw new CiOrUsgRelFeeSrvUnitNullException();
		return medu;
	}

	/**
	 * 获得用法关联费用项目的医学单位数量数值 总量（已考虑了在院执行次数）
	 * 
	 * @param ordo
	 * @param usgrelfeesrvdo
	 * @return
	 * @throws CiOrUsgRelFeeSrvQuanNullException
	 */
	public static FDouble getQuan4UsgRelFeeSrv(CiOrderDO ordo, UsageRelFeeSrvDO usgrelfeesrvdo)
			throws CiOrUsgRelFeeSrvQuanNullException {
		// 2016-11-14 增加总量定值模式时的计算逻辑 ：费用总量不再与医嘱次数相关
		if (CiOrdUtils.isTrue(usgrelfeesrvdo.getIsTotalQuanMd()))
			return getQuan_Med4UsgRelFeeSrv(usgrelfeesrvdo);

		// 获得医嘱在院执行次数 2016-11-14 内部增加了待煎付数返回值逻辑
		Integer timesmpin = CiOrdUtils.getOrTimesMpInHosp(ordo, usgrelfeesrvdo);

		// lizheng 添加判断
		// 2016-11-14 添加该注释内容 目前的算法是对单次的比例法是正确的 固定法(我们目前的固定法时总量固定法)时不应乘次数
		// 住院时总次数和在院执行次数是相等的，但住院并未计算总次数值（为null）
		if (timesmpin != null) {
			FDouble quan_fee = getQuan_Med4UsgRelFeeSrv(usgrelfeesrvdo);
			return quan_fee.multiply(new FDouble(timesmpin));
		} else {
			return null;// return new FDouble(0); //2016-11-14注释掉该代码 次数为空则总量为空
		}

	}

	/**
	 * 套成员计价派生医嘱项目状态修改
	 * 
	 * @param aggdo
	 */
	public static ArrayList<OrdSrvDO> agentOrSrvStatusMod4SetMemCntHandle(CiorderAggDO aggdo) {
		// 校验逻辑
		if (isEmpty(aggdo) || isEmpty(aggdo.getParentDO()) || !isDOMod(aggdo.getParentDO()))
			return null;
		if (isEmpty(aggdo.getOrdSrvDO()))
			return null;

		// 参数
		OrdSrvDO[] orsrvdos = aggdo.getOrdSrvDO();
		ArrayList<OrdSrvDO> rtn = new ArrayList<OrdSrvDO>();

		for (int i = 0; i < orsrvdos.length; i++) {// 医嘱修改时对套派生的未变化项予以删除
			if (OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(orsrvdos[i].getEu_sourcemd())
					&& DOStatus.UNCHANGED == orsrvdos[i].getStatus()) {
				orsrvdos[i].setStatus(DOStatus.DELETED);
				rtn.add(orsrvdos[i]);
			}
		}

		return rtn;
	}

	/**
	 * 医嘱的服务套
	 * 
	 * @return
	 */
	public static IOrdsrvsetRService getIOrdsrvsetRService() {
		return ServiceFinder.find(IOrdsrvsetRService.class);
	}

	/**
	 * 根据医疗单项目DTO数据获得医嘱项目同步属性数据信息
	 * 
	 * @param emssrvdto
	 * @return
	 */
	public static OrSrvSyncInfoDTO getOrSrvSyncInfo(CiEmsSrvDTO emssrvdto) {
		if (isEmpty(emssrvdto))
			return null;
		OrSrvSyncInfoDTO rtndto = new OrSrvSyncInfoDTO();
		if(StringUtils.isNotEmpty(emssrvdto.getId_freq())) {
			rtndto.setId_freq(emssrvdto.getId_freq());
		}
		rtndto.setFg_or(emssrvdto.getFg_or());
		return rtndto;
	}

	/**
	 * 获得医嘱项目同步属性数据信息
	 * 
	 * @param emssrvdto
	 * @return
	 */
	public static OrSrvSyncInfoDTO getOrSrvSyncInfo(String id_freq, FBoolean fg_or) {
		OrSrvSyncInfoDTO rtndto = new OrSrvSyncInfoDTO();
		rtndto.setId_freq(id_freq);
		rtndto.setFg_or(fg_or);
		return rtndto;
	}

	/**
	 * 获得医疗单中对应条目的服务项目ID
	 * 
	 * @param ems
	 * @param ipos
	 * @return
	 */
	public static String getEmsItemIdSrv(CiEmsDTO ems, Integer ipos) {
		return ((CiEmsSrvDTO) (ems.getEmssrvs().get(ipos))).getId_srv();
	}

	/**
	 * 获得医疗单中对应条目的服务总量
	 * 
	 * @param ems
	 * @param ipos
	 * @return
	 */
	public static FDouble getEmsItemQuanTotalMed(CiEmsDTO ems, Integer ipos) {
		return ((CiEmsSrvDTO) (ems.getEmssrvs().get(ipos))).getQuan_total_medu();
	}

	/**
	 * 获得医疗单对应的主医保信息
	 * 
	 * @param ems
	 * @return
	 */
	public static String getId_Hp(CiEmsDTO ems) {
		if (CiOrdUtils.isEmpty(ems))
			return null;
		if (CiOrdUtils.isEmpty(ems.getEmssrvs()))
			return null;
		return ((CiEmsSrvDTO) (ems.getEmssrvs().get(0))).getId_hp();
	}

	/**
	 * 根据用药医疗单信息获得皮试医嘱生效时间
	 * 
	 * @param pharmemsdto
	 * @return
	 * @throws BizException
	 */
	public static FDateTime getSkinTestOrBeginDt(CiEmsDTO pharmemsdto) throws BizException {
		// 住院皮试时间是否跟随 轻量级"TL_CIOR0062"配置
		String ifFollow = ParamsetQryUtil.getParaString(Context.get().getOrgId(), "TL_CIOR0062");
		if ("true".equals(ifFollow)) {
			return pharmemsdto.getDt_begin();
		} else {

			// 门诊、急诊的皮试开始时间使用皮试用药的医嘱时间
			if (CiOrdUtils.isEmpty(pharmemsdto.getCode_entp())
					|| pharmemsdto.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)
					|| pharmemsdto.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW)
					|| pharmemsdto.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID)) {
				return pharmemsdto.getDt_begin();
			}

			if (CiOrdUtils.isTrue(pharmemsdto.getFg_long())) {
				// 获得频次信息
				FreqdefAggDO aggdo = CiOrdUtils.getFreqAggDO(pharmemsdto.getId_freq());

				// 有效性判断
				if (isEmpty(aggdo) || isEmpty(aggdo.getParentDO()))
					return pharmemsdto.getDt_begin();
				FreqTimeDO[] fretimedos = aggdo.getFreqTimeDO();

				// 周期类型为日的 且首日次数为0的情形的处理
				if (IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY.equals(aggdo.getParentDO().getSd_frequnitct())
						&& (CiOrdUtils.isEmpty(pharmemsdto.getTimes_firday_mp())
								|| pharmemsdto.getTimes_firday_mp().equals(0))) {
					// 频次时间数据空判断
					if (isEmpty(aggdo.getFreqTimeDO()))
						return pharmemsdto.getDt_begin().getDateTimeAfter(1);

					// 返回值处理
					return getNewFDateTime(pharmemsdto.getDt_begin(), 1, (aggdo.getFreqTimeDO())[0].getTime_mp());

					// 周期类型为周的情形
				} else if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(aggdo.getParentDO().getSd_frequnitct())) {
					return getSkinTestOrBeginDt4Week(pharmemsdto, fretimedos);
				} else {
				}
			}

			return pharmemsdto.getDt_begin();

		}
	}

	/**
	 * 获得下一个周次的索引值
	 * 
	 * @param fretimedos
	 * @param iL
	 * @param icur
	 * @return
	 */
	private static int getNextWeek(int iL, int icur) {
		if (icur < iL - 1)
			return icur + 1;
		if (icur == iL - 1)
			return 0;
		return -1;
	}

	/**
	 * 获得新的日期时间值
	 * 
	 * @param dt_date
	 *            所在日期
	 * @param adddays
	 *            相加天数
	 * @param dt_time
	 *            所在时间
	 * @return
	 */
	public static FDateTime getNewFDateTime(FDateTime dt_date, int adddays, FTime dt_time) {
		return new FDateTime((dt_date.getDateTimeAfter(adddays)).getBeginDate(), dt_time);
	}

	/**
	 * 获得下一周次与本周词日期间隔数
	 * 
	 * @param iwdno
	 * @param inextwdno
	 * @return
	 */
	public static int getNextWeekDayDiff(int iwdno, int inextwdno) {
		int daydiff = inextwdno - iwdno;
		if (daydiff < 0)
			daydiff = 7 + daydiff;
		return daydiff;
	}

	/**
	 * 获得下一周次对应的日期时间
	 * 
	 * @param dt_cur
	 * @param fretimedos
	 * @param icur
	 * @return
	 */
	private static FDateTime getNextWdFDateTime(FDateTime dt_cur, FreqTimeDO[] fretimedos, int icur) {
		int iwdno_cur = fretimedos[icur].getWdno();
		int inext = getNextWeek(fretimedos.length, icur);
		int inextwdno = fretimedos[inext].getWdno();
		int daydiff = getNextWeekDayDiff(iwdno_cur, inextwdno);
		return getNewFDateTime(dt_cur, daydiff, fretimedos[inext].getTime_mp());

	}

	/**
	 * 获得下一周次对应的日期时间
	 * 
	 * @param dt_cur
	 * @param fretimedos
	 * @param icur
	 * @return
	 */
	private static FDateTime getNextWdFDateTime(FDateTime dt_cur, FreqTimeDO fretimedo, int iwdno_cur, int inextwdno) {
		int daydiff = getNextWeekDayDiff(iwdno_cur, inextwdno);
		return getNewFDateTime(dt_cur, daydiff, fretimedo.getTime_mp());

	}

	/**
	 * 获得下一周次数
	 * 
	 * @param fretimedos
	 * @param icur
	 * @return
	 */
	private static int[] getnextWdNo(FreqTimeDO[] fretimedos, int icur) {
		int inext = getNextWeek(fretimedos.length, icur);
		int inextwdno = fretimedos[inext].getWdno();
		return new int[] { inextwdno, inext };
	}

	/**
	 * 根据用药医疗单信息获得皮试医嘱生效时间 周类型情形处理
	 * 
	 * @param pharmemsdto
	 * @param fretimedos
	 * @return
	 */
	private static FDateTime getSkinTestOrBeginDt4Week(CiEmsDTO pharmemsdto, FreqTimeDO[] fretimedos) {
		// 频次时间数据空判断
		if (isEmpty(fretimedos))
			return pharmemsdto.getDt_begin();

		// 获得所在星期数
		int iweek = pharmemsdto.getDt_begin().getWeek();

		// 参数设置
		int iwdno = 0;
		int[] inextwdno = null;
		FTime time = null;
		FTime dt_open = pharmemsdto.getDt_begin().getUFTime();

		// 遍历
		for (int i = 0; i < fretimedos.length; i++) {
			iwdno = fretimedos[i].getWdno();
			time = fretimedos[i].getTime_mp();
			if (iweek == iwdno) {
				// 在频次时间之前时的处理逻辑
				if (dt_open.before(time))
					return pharmemsdto.getDt_begin();

				// 返回下一周次对应的日期时间
				return getNextWdFDateTime(pharmemsdto.getDt_begin(), fretimedos, i);
			} else {
				inextwdno = getnextWdNo(fretimedos, i);
				if (iweek > iwdno || iweek < inextwdno[0]) {
					return getNextWdFDateTime(pharmemsdto.getDt_begin(), fretimedos[inextwdno[1]], iweek, inextwdno[0]);
				}
			}
		}
		// 返回
		return pharmemsdto.getDt_begin();
	}

	/**
	 * 获得字符串数据类型sql片段
	 * 
	 * @param aliasTblname
	 * @param fldname
	 * @param v
	 * @return
	 */
	public static String getSqlPart4StringV(String aliasTblname, String fldname, String v) {
		return " " + aliasTblname + "." + fldname + "='" + v + "' ";
	}

	/**
	 * 触发事件
	 * 
	 * @param sourceid
	 * @param eventType
	 * @param userObjs
	 * @throws BizException
	 */
	public static void fireEvent(String sourceid, String eventType, Object[] userObjs) throws BizException {
		// 触发事件

		for (Object object : userObjs) {

			BusinessEvent event = new BusinessEvent(sourceid, eventType, object);
			EventDispatcher.fireEvent(event);
		}

	}

	/**
	 * 触发事件
	 * 
	 * @param sourceid
	 * @param eventType
	 * @param userObjs
	 * @throws BizException
	 */
	public static void fireBDEvent(String sourceid, String eventType, Object[] userObjs) throws BizException {
		// 触发事件
		BDCommonEvent event = new BDCommonEvent(sourceid, eventType, userObjs);
		EventDispatcher.fireEvent(event);
	}

	/**
	 * 字符串真等判断
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static boolean isStrRealEquals(String v1, String v2) {
		if (v1 == null || v2 == null)
			return false;
		if (v1.equals(v2))
			return true;
		return false;
	}

	/**
	 * 获得就诊类型对应的字段名
	 * 
	 * @param entp
	 * @return
	 */
	public static String getEntpFldNameStr(String entp) {
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(entp))
			return "op";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(entp))
			return "ip";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(entp))
			return "pip";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(entp))
			return "er2";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(entp))
			return "pe";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(entp))
			return "fm";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(entp))// 急诊流水
			return "er";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(entp))// 急诊抢救
			return "er1";
		return "";
	}

	/**
	 * 转换为FDouble进位方式
	 * 
	 * @param roundtp
	 * @return
	 */
	public static int convertFDoubleRoundMode(String roundtp) {
		if (IBdSrvDictCodeConst.SD_ROUNDMD_TRUNC.equals(roundtp)) {
			return FDouble.ROUND_FLOOR;
		} else if (IBdSrvDictCodeConst.SD_ROUNDMD_CARRY.equals(roundtp)) {
			return FDouble.ROUND_CEILING;
		} else if (IBdSrvDictCodeConst.SD_ROUNDMD_ROUND.equals(roundtp)) {
			return FDouble.ROUND_HALF_UP;
		}

		return FDouble.ROUND_HALF_UP;
	}

	/**
	 * 获得系数Factor对应的分子分母
	 * 
	 * @param factor
	 * @param appscene
	 * @return
	 * @throws StrFactorDefException
	 */
	public static FDouble[] getFactorNumDenom(String factor, String appscene) throws StrFactorDefException {
		FDouble[] rtn = new FDouble[2];
		try {
			if (CiOrdUtils.isInStr(CiOrdUtils.SLASH_STR, factor)) {
				String[] sTs = factor.split(CiOrdUtils.SLASH_STR);
				if (sTs.length != 2)
					throw new StrFactorDefException(appscene);
				rtn[0] = new FDouble(sTs[0]);
				rtn[1] = new FDouble(sTs[1]);

				// 分母空与零校验
				if (CiOrdUtils.isEmpty(rtn[1]) || rtn[1].equals(0))
					throw new StrFactorDenoNullException(appscene);
			} else {
				rtn[0] = new FDouble(factor);
				rtn[1] = new FDouble(1);
			}
			return rtn;
		} catch (Exception e) {
			throw new StrFactorDefException(appscene);
		}
	}

	/**
	 * 获得比例数量 考虑系数、精度、舍位
	 * 
	 * @param relsrvdo
	 * @param param
	 * @return
	 * @throws StrFactorNullException
	 * @throws StrFactorDefException
	 * @throws StrFactorDenoNullException
	 */
	public static FDouble getQuan8Factor(FDouble quan_src, String factor, Integer precise, String sd_roundmd,
			String appscene) throws StrFactorNullException, StrFactorDefException, StrFactorDenoNullException {
		// Factor空有效性校验
		if (CiOrdUtils.isEmpty(factor))
			throw new StrFactorNullException(appscene);

		// 获得系数对应的分子分母
		FDouble[] numdeno = getFactorNumDenom(factor, appscene);

		// 按比例、精度及舍位方式计算
		return calByBenDen8Scale(quan_src, numdeno, precise, sd_roundmd);
	}

	/**
	 * 按分子分母系数及精度体系参数计算返回值
	 * 
	 * @param quan_src
	 * @param numdeno
	 * @param precise
	 * @param sd_roundmd
	 * @return
	 */
	public static FDouble calByBenDen8Scale(FDouble quan_src, FDouble[] numdeno, Integer precise, String sd_roundmd) {
		FDouble v = (quan_src.multiply(numdeno[0])).div(numdeno[1]);
		return v.setScale(precise, convertFDoubleRoundMode(sd_roundmd));
	}

	/**
	 * 是否是最后一顿的判断
	 * 
	 * @param begin
	 * @param end
	 * @param hours
	 * @return
	 */
	public static boolean isLastMp(FDateTime begin, FDateTime end, Integer hours) {
		if (begin.after(end))
			return true; // 应该已经执行完毕
		if (begin.addSeconds(hours * SECONDS_PER_HOUR).after(end))
			return true;
		return false;
	}

	/**
	 * FDouble业务数据是否是有效的 null或者<=0时无效的场景使用该方法
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isValidateTransData(FDouble input) {
		if (isEmpty(input))
			return false;
		if (input.toDouble() <= 0)
			return false;
		return true;
	}

	/**
	 * 获得医嘱项目对应的价格 门诊、非物品、本服务定价
	 * 
	 * @param code_entp
	 * @param id_srv
	 * @param pri
	 * @param id_primd
	 * @return
	 * @throws BizException
	 */
	public static FDouble getOrSrvPrice(String code_entp, String id_srv, FDouble pri, String id_primd)
			throws BizException {
		if (!isEmpty(pri))
			return pri; // 不空则返回
		// if (!CiOrdUtils.isOpWf(code_entp) &&
		// !CiOrdUtils.isUrgentWf(code_entp))
		// return pri; // 不是门急诊则返回
		// return CiOrdAppUtils.getPriCalService().CalSingleSrvStdPrice(id_srv);
		if (!CiOrdUtils.isSrvSelfPrimd8Id(id_primd))
			return pri; // 不是本服务定价则返回
		return CiOrdAppUtils.getPriCalService().CalSingleSrvStdPrice(id_srv);
	}

	/**
	 * 获得物品对应总量单位下的单价
	 * 
	 * @param id_mm
	 * @param Id_pgku_cur
	 * @return
	 */
	public static FDouble getOrSrvMMPrice(String id_mm, String Id_pgku_cur) {
		if (CiOrdUtils.isEmpty(id_mm) || CiOrdUtils.isEmpty(Id_pgku_cur))
			return null;
		GetStockReqDTO reqDto = new GetStockReqDTO();
		reqDto.setId_mm(id_mm);
		reqDto.setReq_unit_id(Id_pgku_cur);
		GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
		reqDtoArr[0] = reqDto;
		MaterialStockDTO[] materials = null;
		try {
			materials = CiOrdAppUtils.getMaterialStockQryService().getMaterialStocks(reqDtoArr);
		} catch (BizException e) {
			e.printStackTrace();
		}
		if (materials != null && materials.length > 0) {
			return materials[0].getPrice_act();
		} else {
			return null;
		}
	}

	/**
	 * 获得医嘱项目对应的价格 门诊、非物品、本服务定价
	 * 
	 * @param ordo
	 * @param srvdto
	 * @return
	 * @throws BizException
	 */
	public static FDouble getOrSrvPrice(CiOrderDO ordo, CiEmsSrvDTO srvdto) throws BizException {
		FDouble price = getOrSrvPrice(ordo.getCode_entp(), srvdto.getId_srv(), srvdto.getPrice(), srvdto.getId_primd());
		if (CiOrdUtils.isSrvMMPri8Id(srvdto.getId_primd())) {// 对应物品价格
			return getOrSrvMMPrice(srvdto.getId_mm(), srvdto.getId_unit_sale());
		} else {
			return price;
		}
		// if(!isEmpty(srvdto.getPrice()))return srvdto.getPrice(); //不空则返回
		// if(!CiOrdUtils.isOpWf(ordo.getCode_entp()))return srvdto.getPrice();
		// //不是门诊则返回
		// if(!CiOrdUtils.isSrvSelfPrimd8Id(srvdto.getId_primd()))return
		// srvdto.getPrice(); //不是本服务定价则返回
		// //CiOrBdSrvPriceCalBP
		// return
		// CiOrdAppUtils.getPriCalService().CalSingleSrvStdPrice(srvdto.getId_srv());
	}

	/**
	 * 是否是最后一顿的判断 持续Always的判断
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean isLastMp(FDateTime begin, FDateTime end) {
		if (begin.after(end))
			return true; // 应该已经执行完毕
		return false;
	}

	/**
	 * 通过服务类型判断是否为皮试医嘱
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean isSkinOrType(String sd_srvtp) {
		if (IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST.equals(sd_srvtp))
			return true;
		return false;
	}

	/**
	 * 获得匹配的服务项目对应执行科室 组合定价项目用
	 * 
	 * @param orsrvdos
	 * @param id_srv
	 * @return
	 */
	public static String getIdDepMpInfo(OrdSrvDO[] orsrvdos, String id_srv) {
		if (isEmpty(orsrvdos) || isEmpty(id_srv))
			return null;
		for (int i = 0; i < orsrvdos.length; i++) {
			if (id_srv.equals(orsrvdos[i].getId_srv()))
				return orsrvdos[i].getId_dep_mp();
		}
		return null;
	}

	/**
	 * 根据频次获得医嘱默认长临值
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static FBoolean getFglong8IdFreq(String id_freq) throws BizException {
		FreqDefDO freqdefdo = CiOrdAppUtils.getFreqdefMDORService().findById(id_freq);
		return freqdefdo.getFg_long();
	}

	/**
	 * 获得sql串对应的Map
	 * 
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	public static Map<String, Object> getRsMap(String sqlStr) throws BizException {
		try {
			return (Map<String, Object>) (new DAFacade().execQuery(sqlStr, new MapHandler()));
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
	}

	/**
	 * 获得sql串对应的MapList
	 * 
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	public static List<Map<String, Object>> getRsMapList(String sqlStr) throws BizException {
		try {
			return (List<Map<String, Object>>) (new DAFacade().execQuery(sqlStr, new MapListHandler()));
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
	}

	/**
	 * IdsConveretCharacterString String[] convert 字符串
	 * String["123","124","125","126"] convert '123','124','125','126'
	 * 
	 * @param String
	 * @return
	 */
	public static String IdsConveretCharacterString(String[] ids) {
		String id = "";
		if (ids != null && ids.length > 0) {
			for (String idpat : ids) {
				id += ",'" + idpat + "'";
			}
		}
		if (id != "" && id.length() > 0) {
			return id.substring(1);
		}
		return null;
	}

	public static String ListConveretCharacterString(List<String> ids) {
		String id = "";
		if (ids != null && ids.size() > 0) {
			for (String idpat : ids) {
				id += ",'" + idpat + "'";
			}
		}
		if (id != "" && id.length() > 0) {
			return id.substring(1);
		}
		return null;
	}

	/**
	 * 
	 * 本次就诊的诊断信息
	 * 
	 * @param id_ent
	 * @return String[] diag; diag[0] = 急性阑尾炎&发热 诊断名称的拼接 diag[1]
	 *         =K35.902&R50.901 诊断编码的 拼接 diag[2] = 001A0000003&011A0000004
	 *         子项目id的拼接 diag[3] = 001A0000003 主诊断 id diag[4] = 主诊断 名称 diag[5] =
	 *         Bd中诊断定义id 遗留问题，后续业务确定使用定义诊断，还是使用业务中诊断 diag[6] = K35.902
	 *         慢性病标识，有慢性病是存的是慢性病的 编码，无慢性病时 是 null diag[7] = 001A0000003 主诊断的主项目
	 *         id
	 */
	public static String[] getDiag(String id_ent) throws BizException {
		ICidiagQryService service = ServiceFinder.find(ICidiagQryService.class);
		CidiagAggDO[] agg = service.getLastCiDiags(id_ent);
		String[] str = new String[8];
		if (agg != null && agg.length > 0) {
			String code = "";
			String name = "";
			String id_items = "";
			String id_didef = "";
			String id_item = ""; // 主诊断
			String name_item = ""; // 主诊断名称
			String name_syn_item = ""; // 主诊断症候
			String fg_chronic = null;// 慢性病标识
			String id_di = "";// 主项目ids
			for (CidiagAggDO aggdo : agg) {
				if (aggdo.getCiDiagItemDO() != null && aggdo.getCiDiagItemDO().length > 0) {

					for (CiDiagItemDO itemDO : aggdo.getCiDiagItemDO()) {
						if (itemDO.getFg_majdi().booleanValue()) {
							id_didef = itemDO.getId_didef();
							id_item = itemDO.getId_diitm();
							name_item = itemDO.getId_didef_name();
							//0180675: 【验证版】门急诊医生站，统一录超量开单的中医诊断，医疗单里的诊断，没有带入症候名称
//							name_syn_item = StringUtils.isEmpty(itemDO.getId_didef_syn_name()) ? ""
//									: "(" + itemDO.getId_didef_syn_name() + ")";
							id_di = itemDO.getId_di();
						}
						// 慢性病
						if (itemDO.getFg_chronic() != null && itemDO.getFg_chronic().booleanValue()) {
							fg_chronic += "&" + itemDO.getDidef_code();
						}

						id_items += "&" + itemDO.getId_diitm();
						// // 自定义诊断
						// if (itemDO.getFg_self() != null &&
						// itemDO.getFg_self().booleanValue()) {
						// code += "&" + itemDO.getId_didef_code();// 定义 0000
						// name += "&" + itemDO.getId_didef_name(); // 诊断说明是否拼接
						// }
						//
						// // 中西医诊断
						if (itemDO.getId_didef_name() != null) {
							code += "&" + itemDO.getId_didef_code();
							name += "&" + itemDO.getId_didef_name();

						}
						// 中医诊断证候
						if (itemDO.getId_didef_syn_code() != null) {
							code += "&" + itemDO.getId_didef_syn_code();
							name += "&" + itemDO.getId_didef_syn_name();
						}
						if (FBoolean.TRUE.equals(itemDO.getFg_suspdi())) {
							name += "?"; // 诊断说明是否拼接
						}
					}

				}
			}

			if (name != "" && name.length() > 1) {
				str[0] = name.substring(1);
			}
			if (code != "" && code.length() > 1) {
				str[1] = code.substring(1);
			}
			if (id_items != null && id_items.length() > 0) {
				str[2] = id_items.substring(1);
			}

			str[3] = id_item;
			str[4] = name_item + name_syn_item;
			str[5] = id_didef;

			if (fg_chronic != null) {
				str[6] = fg_chronic.substring(1);
			} else {
				str[6] = null;
			}
			str[7] = id_di;
		}
		return str;
	}

	/**
	 * 获取就诊诊断（EntDiDO），检查申请前台参照使用这个
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public static String[] getDiag2(String id_ent) throws BizException {

		String[] cidiArr = new String[2];
		ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
		EntDiDO[] entDis = service.getEntDiDOList(id_ent);
		if (entDis == null || entDis.length == 0) {
			cidiArr[0] = "";
			cidiArr[1] = "";
		}
		for (EntDiDO entDiDO : entDis) {
			if (FBoolean.TRUE.equals(entDiDO.getFg_maj())) {
				cidiArr[0] = entDiDO.getId_entdi();
				cidiArr[1] = entDiDO.getName_didef_dis();
				break;
			}
		}
		return cidiArr;
	}

	/**
	 * 医疗单的匹配
	 * 
	 * @return
	 */
	// TODO 确定哪个需要保留
	public static EmsMatchRstDTO getFuncClassStr(CiEnContextDTO envinfo, MedSrvDO medSrvDO) throws BizException {
		SrvMatchEmsParamDTO paramDto = new SrvMatchEmsParamDTO();
		paramDto.setId_srv(medSrvDO.getId_srv());
		paramDto.setId_dept(envinfo.getId_dep_or());
		paramDto.setId_emp(envinfo.getId_emp_or());
		paramDto.setId_grp(envinfo.getId_grp());
		paramDto.setId_org(envinfo.getId_org());
		paramDto.setSd_srvtp(medSrvDO.getSd_srvtp());
		paramDto.setCode_entp(envinfo.getCode_entp());
		paramDto.setEmsappmode(envinfo.getEmsappmode());// 智慧版
		paramDto.setDt_or(CiOrdAppUtils.getServerDateTime());// 系统时间
		EmsMatchRstDTO emsMatchRstDto = CiOrdAppUtils.getBdSrvQryQryService().medSrvMatchEms(paramDto);
		return emsMatchRstDto;
	}

	/**
	 * 医疗单的匹配
	 * 
	 * @return
	 */
	// TODO 确定哪个需要保留
	public static SrvMatchEmsRstDTO getFuncClassStr_GJ(CiEnContextDTO envinfo, MedSrvDO medSrv) throws BizException {

		return getFuncClassStr(envinfo, medSrv.getId_srv(), medSrv.getSd_srvtp());
	}

	/**
	 * 医疗单的匹配
	 * 
	 * @return
	 */
	public static SrvMatchEmsRstDTO getFuncClassStr(CiEnContextDTO envinfo, String id_srv, String sd_srvtp)
			throws BizException {

		SrvMatchEmsParamDTO paramDto = new SrvMatchEmsParamDTO();
		paramDto.setId_org(envinfo.getId_org());
		paramDto.setId_grp(envinfo.getId_grp());
		paramDto.setId_dept(envinfo.getId_dep_or());
		paramDto.setId_emp(envinfo.getId_emp_or());
		paramDto.setCode_entp(envinfo.getCode_entp());
		paramDto.setSd_srvtp(sd_srvtp);
		paramDto.setId_srv(id_srv);
		paramDto.setDt_or(CiOrdAppUtils.getServerDateTime());// 系统时间
		paramDto.setEmsappmode(envinfo.getEmsappmode());// 智慧版

		FMap map = CiOrdAppUtils.getIEmsManagementService().medSrvMatchEms(new SrvMatchEmsParamDTO[] { paramDto });
		return (SrvMatchEmsRstDTO) map.get(id_srv);
	}

	/**
	 * 解析医疗单匹配路径字段
	 * 
	 * @param funcStr
	 * @return
	 * @throws BizException
	 */
	public static EmsFunclassKVDTO getEmsFunclassKVDTO(String funcStr) throws BizException {
		return CiOrdAppUtils.getIEmsManagementService().getEmsFunclassKVDTO(funcStr);
	}

	/**
	 * 申请单号
	 * 
	 * @param CiEmsDTO
	 *            ciEms
	 * @return
	 * @throws BizException
	 */
	public static String getApplyNoCiEms(CiEmsDTO ciEms) throws BizException {

		// 医疗单类路径
		String classFullName = null;
		BaseDO vo=null;

		if (ciEms.getSd_srvtp().startsWith("02")) {// 检查

			if (ciEms.getSd_srvtp().startsWith("0207")) {// 病理
				ciEms.setEmstype(EmsType.PATHGY);
				classFullName = OrdApPathgyDODesc.CLASS_FULLNAME;
			} else {
				ciEms.setEmstype(EmsType.RIS);
				classFullName = OrdApObsDODesc.CLASS_FULLNAME;
			}

		} else if (ciEms.getSd_srvtp().startsWith("03")) {// 检验
			ciEms.setEmstype(EmsType.LIS);
			classFullName = OrdApLabDODesc.CLASS_FULLNAME;
			OrdApLabDO lab=new OrdApLabDO();
			lab.setId_dep_app(Context.get().getDeptId());
			vo=lab;

		} else if (ciEms.getSd_srvtp().startsWith("04")) {// 手术
			ciEms.setEmstype(EmsType.OPER);
			FDate df = new FDate(new Date());
			return df.toStdString();
		} else if (ciEms.getSd_srvtp().startsWith("140101")) {// 备血
			ciEms.setEmstype(EmsType.BT);
			classFullName = OrdApBtDODesc.CLASS_FULLNAME;

		} else if (ciEms.getSd_srvtp().startsWith("140102")) {// 用血
			ciEms.setEmstype(EmsType.BTUSE);
			classFullName = OrdAppBtUseDODesc.CLASS_FULLNAME;
		} else if(ciEms.getSd_srvtp().startsWith("1202")){//出院
			ciEms.setEmstype(EmsType.OUTHOSP);
		} else if(ciEms.getSd_srvtp().startsWith("0902")){
			ciEms.setEmstype(EmsType.CONS);
		}else if(ciEms.getSd_srvtp().startsWith("0505")){//膳食
			ciEms.setEmstype(EmsType.DIET);
			//classFullName =OrdApDietDODesc.CLASS_FULLNAME;
		}

		if (StringUtils.isNotBlank(classFullName)) {
//			return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(classFullName);
			if(vo!=null) {
				return CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(classFullName,vo);
			}else {
				return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(classFullName);
			}
		}

		return "";
	}

	/**
	 * 申请单号
	 * 
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	public static String getApplyNo(String sd_srvtp) throws BizException {
		if (CiOrdUtils.isEmpty(sd_srvtp))
			return "";
		// 医疗单类路径
		String classFullName = null;
		BaseDO vo=null;
		if (sd_srvtp.startsWith("02")) {// 检查

			if (sd_srvtp.startsWith("0207")) {// 病理
				classFullName = OrdApPathgyDODesc.CLASS_FULLNAME;
			} else {
				classFullName = OrdApObsDODesc.CLASS_FULLNAME;
			}

		} else if (sd_srvtp.startsWith("03")) {// 检验
			classFullName = OrdApLabDODesc.CLASS_FULLNAME;
			OrdApLabDO lab=new OrdApLabDO();
			lab.setId_dep_app(Context.get().getDeptId());
			vo=lab;

		} else if (sd_srvtp.startsWith("04")) {// 手术
			classFullName = OrdApOpDODesc.CLASS_FULLNAME;
		} else if (sd_srvtp.startsWith("140101")) {// 备血
			classFullName = OrdApBtDODesc.CLASS_FULLNAME;

		} else if (sd_srvtp.startsWith("140102")) {// 用血
			classFullName = OrdAppBtUseDODesc.CLASS_FULLNAME;
		}else if (sd_srvtp.startsWith("0902")) {//会诊
			classFullName = OrdApConsDODesc.CLASS_FULLNAME;
		}

		if (StringUtils.isNotBlank(classFullName)) {
			if(vo!=null) {
				return CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(classFullName,vo);
			}else {
				return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(classFullName);
			}
			
		}
		return "";
	}

	/**
	 * 生成毒麻处方号
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String generatePoisPresNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager()
				.getPreBillCode_RequiresNew("iih.ci.ord.dto.recipedto.d.RecipeDTO");
		return presNo;
	}

	/**
	 * 生成处方号
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static String generatePresNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiPresDODesc.CLASS_FULLNAME);
		if (presNo.contains("-")) {
			presNo = presNo.replace(presNo.substring(1, 10), "");
		}
		return presNo;
	}

	/**
	 * 根据就诊id_en 流水号清零，并生成新的处方号
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public static String generatePresNo(String id_en) throws BizException {
		CiPresDO ciPresDO = new CiPresDO();
		ciPresDO.setId_en(id_en);
		String presNo = CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(CiPresDO.class.getName(), ciPresDO);

		presNo = presNo.replace(presNo.substring(1, 21), "");
		return presNo;
	}

	/**
	 * 生成检查打印单号
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static String generateRisPrintNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager()
				.getPreBillCode_RequiresNew(CiAppRisSheetDODesc.CLASS_FULLNAME);
		{
			presNo = presNo.replace(presNo.substring(1, 9), "");
		}
		return presNo;
	}

	public static String generateRisPrintNo(String id_en) throws BizException {
		CiAppRisSheetDO ciAppRisSheetDO = new CiAppRisSheetDO();
		ciAppRisSheetDO.setId_en(id_en);
		String presNo = CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(CiAppRisSheetDO.class.getName(),
				ciAppRisSheetDO);

		presNo = presNo.replace(presNo.substring(1, 21), "");

		return presNo;
	}

	/**
	 * 生成检验打印单号
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static String generateLisPrintNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager()
				.getPreBillCode_RequiresNew(CiAppLisSheetDODesc.CLASS_FULLNAME);
		if (presNo.contains("-")) {
			presNo = presNo.replace(presNo.substring(1, 10), "");
		}
		return presNo;
	}

	public static String generateLisPrintNo(String id_en) throws BizException {
		CiAppLisSheetDO ciAppLisSheetDO = new CiAppLisSheetDO();
		ciAppLisSheetDO.setId_en(id_en);
		String presNo = CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(CiAppLisSheetDO.class.getName(),
				ciAppLisSheetDO);

		presNo = presNo.replace(presNo.substring(1, 21), "");

		return presNo;
	}

	public static String[] generateLisPrintNo(String id_en, int num) throws BizException {
		CiAppLisSheetDO ciAppLisSheetDO = new CiAppLisSheetDO();
		ciAppLisSheetDO.setId_en(id_en);
		String[] presNo = CiOrdAppUtils.getIBillcodeManager()
				.getBatchBillCodes_RequiresNew(CiAppLisSheetDO.class.getName(), ciAppLisSheetDO, num);

		List<String> slist = new ArrayList<>();
		for (String o : presNo) {
			o = o.replace(o.substring(1, 21), "");
			slist.add(o);
		}

		return slist.toArray(new String[0]);
	}

	/**
	 * 
	 * @param cnt
	 *            生成个数
	 * @param dos
	 *            对象
	 * @param start
	 *            开始位置
	 * @param end
	 *            截止位置
	 * @return
	 * @author li_cheng
	 * @throws BizException
	 */
	public static String[] generateNormNOs(int cnt, BaseDO baseDO, Integer start, Integer end) throws BizException {

		String[] codes = CiOrdAppUtils.getIBillcodeManager().getBatchBillCodes_RequiresNew(baseDO.getClass().getName(),
				baseDO, cnt);
		if (start == null || end == null)
			return codes;

		List<String> lstCodes = new ArrayList<>();
		for (String code : codes) {
			code = code.replace(code.substring(start, end), "");
			lstCodes.add(code);
		}

		return lstCodes.toArray(new String[0]);
	}

	/**
	 * 
	 * @param cnt
	 * @param baseDO
	 * @return
	 * @throws BizException
	 */
	public static String[] generateNormNOs(int cnt, BaseDO baseDO) throws BizException {

		String[] codes = CiOrdAppUtils.getIBillcodeManager().getBatchBillCodes_RequiresNew(baseDO.getClass().getName(),
				baseDO, cnt);

		return codes;
	}

	/**
	 * 诊疗收费清单打印单号
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static String generateFeePrintNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiPrnDODesc.CLASS_FULLNAME);
		if (presNo.contains("-")) {
			presNo = presNo.replace(presNo.substring(1, 10), "");
		}
		return presNo;
	}

	public static String generateFeePrintNo(String id_en) throws BizException {
		CiPrnDO ciPrnDO = new CiPrnDO();
		ciPrnDO.setId_en(id_en);
		String presNo = CiOrdAppUtils.getIBillcodeManager().getBillCode_RequiresNew(CiPrnDO.class.getName(), ciPrnDO);

		presNo = presNo.replace(presNo.substring(1, 21), "");

		return presNo;
	}

	/**
	 * 诊疗执行单打印单号
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String generateTreatPrintNo() throws BizException {
		String presNo = CiOrdAppUtils.getIBillcodeManager()
				.getPreBillCode_RequiresNew(CiAppTreatExecDODesc.CLASS_FULLNAME);
		if (presNo.contains("-")) {
			presNo = presNo.replace(presNo.substring(1, 10), "");
		}
		return presNo;
	}

	/**
	 * IsRemind4FgIndicFalseConfirmed 确认为非适应症时是否提醒医生
	 * 
	 * @return 默认 是 false 不提醒， true 提醒
	 * @throws BizException
	 */
	public static FBoolean getIsRemind4FgIndicFalseConfirmed() throws BizException {
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		String temp = ParamsetQryUtil.getParaString(id_org,
				ICiOrdNSysParamConst.SYS_PARAM_IsRemind4FgIndicFalseConfirmed);
		if (temp != null && temp.equalsIgnoreCase("false")) {
			return FBoolean.FALSE;
		} else {
			return FBoolean.TRUE;
		}
	}

	public static Logger getlogger() {
		return logger;
	}

	public static void LogerOutInfo(String msg) {
		if (logger != null)
			logger.info(msg);
		;
	}

	public static void setLogger(Logger log) {
		logger = log;
	}

	/**
	 * 根据医疗服务标准价格信息DTO数组获得对应的医疗服务信息DO数组 2016-11-11性能调优增加的批量查询的方法
	 * 
	 * @param prisrvs
	 * @return
	 * @throws BizException
	 */
	public static MedSrvDO[] getMedSrvInfoDOs(PriStdSrvDTO[] prisrvs) throws BizException {
		Object[] oid_srvs = getIdSrvs(prisrvs);
		String[] id_srvs = (String[]) oid_srvs[0];
		if (CiOrdUtils.isEmpty(id_srvs))
			return null;
		MedSrvDO[] medsrvdos = CiOrdAppUtils.getMedsrvMDORService().findByIds(id_srvs, FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(medsrvdos))
			return null;
		return InOutSeqSyncHandle(prisrvs, medsrvdos, (HashMap<String, Integer>) oid_srvs[1]);
	}

	/**
	 * 获得医疗服务主键数组信息
	 * 
	 * @param prisrvs
	 * @return
	 */
	private static Object[] getIdSrvs(PriStdSrvDTO[] prisrvs) {
		// 非空检验
		if (CiOrdUtils.isEmpty(prisrvs))
			return null;

		// 参数设置
		String id_srv = "";
		String[] rtns = new String[prisrvs.length];
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		// 遍历
		for (int i = 0; i < prisrvs.length; i++) {
			id_srv = prisrvs[i].getId_srv();
			rtns[i] = id_srv;
			hm.put(id_srv, i);
		}

		// 返回值
		return new Object[] { rtns, hm };
	}

	/**
	 * 顺序一致处理逻辑
	 * 
	 * @param prisrvs
	 * @param medsrvdos
	 * @param hm
	 * @return
	 */
	private static MedSrvDO[] InOutSeqSyncHandle(PriStdSrvDTO[] prisrvs, MedSrvDO[] medsrvdos,
			HashMap<String, Integer> hm) {
		// 底层应该已经考虑顺序问题
		if (prisrvs.length == medsrvdos.length)
			return medsrvdos;

		// 参数
		MedSrvDO[] rtns = new MedSrvDO[prisrvs.length];

		// 遍历
		for (int i = 0; i < medsrvdos.length; i++) {
			rtns[(Integer) hm.get(medsrvdos[i].getId_srv())] = medsrvdos[i];
		}

		// 返回值
		return rtns;
	}

	/**
	 * 获得服务类型code
	 */
	public static String GetSrvtpByID(String id_or) throws BizException {
		CiOrderDO ciOrderDO = CiOrdAppUtils.getCiorderMDORService().findById(id_or);
		if(ciOrderDO != null) {
			return ciOrderDO.getSd_srvtp();
		}
		return null;
	}

	/**
	 * 获得执行科室中的执行科室与物流科室数组
	 * 
	 * @param exdepts
	 * @return
	 */
	public static Object[] getExDeptsAndLogisticDepts(FArrayList exdepts) {
		// 有效性校验
		if (isEmpty(exdepts))
			return new Object[] { null, null };

		// 参数定义
		FArrayList exdeptlist = new FArrayList();
		FArrayList logisticdeptlist = new FArrayList();
		OrWfExDeptParamDTO param = null;

		// 遍历 OrWfExDeptParamDTO
		for (int i = 0; i < exdepts.size(); i++) {
			param = (OrWfExDeptParamDTO) (exdepts.get(i));
			if (param.getEu_wftp() == EnumFlow.EXECUTEFLOW) {
				exdeptlist.add(param);
			} else if (param.getEu_wftp() == EnumFlow.SUPPLIESFLOW) {
				logisticdeptlist.add(param);
			}
		}

		return new Object[] { exdeptlist, logisticdeptlist };
	}

	/**
	 * 诊断信息
	 * 
	 * @param id_ent
	 * @return
	 */
	@Deprecated
	public static FArrayList2 getDiagList(String id_ent) throws BizException {
		FArrayList2 list = new FArrayList2();
		String[] diag = CiOrdUtils.getDiag(id_ent);
		for (String item : diag) {
			list.append(item);
		}
		return list;
	}

	/**
	 * 国际医院使用
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public static FArrayList2 getDiagItemList(String id_ent) throws BizException {
		ICidiagQryService service = ServiceFinder.find(ICidiagQryService.class);
		FArrayList2 list = new FArrayList2();
		CidiagAggDO[] agg = service.getLastCiDiags(id_ent);
		if(agg == null || agg.length ==0){
			return list;
		}
		for (CidiagAggDO aggDO : agg) {
			for (CiDiagItemDO item : aggDO.getCiDiagItemDO()) {
				list.add(item);
			}
		}
		return list;
	}

	/**
	 * 根据医疗服务标准价格信息DTO数组获得对应的医疗服务信息DO数组 2016-11-11性能调优增加的批量查询的方法
	 * 
	 * @param prisrvs
	 * @return
	 * @throws BizException
	 */
	public static OrWfExDeptParamDTO[] getExeWhDeptDOs(CiOrderDO ordo, CiEmsDTO ems, Integer setindex,
			MedSrvDO[] prisrvdo, MedSrvRelMmDTO srvrelmmdo) throws BizException {
		Object oid_srvs = getorwfIdSrvs(prisrvdo);

		OrWfExDeptParamDTO[] params = getExeDeptCalParamDTODOs(ordo, ems, setindex, prisrvdo, null);
		OrWfExDeptParamDTO[] result = ServiceFinder.find(IBdFcQryService.class).getOrExDeptBatchBP(params);
		return InOutSeqSyncHandle4orwf(result, prisrvdo, (HashMap<String, Integer>) oid_srvs);
	}

	private static Object getorwfIdSrvs(MedSrvDO[] prisrvs) {
		// 非空检验
		if (CiOrdUtils.isEmpty(prisrvs))
			return null;

		// 参数设置
		String id_srv = "";

		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		// 遍历
		for (int i = 0; i < prisrvs.length; i++) {
			id_srv = prisrvs[i].getId_srv();
			hm.put(id_srv, i);
		}

		// 返回值
		return hm;
	}

	/**
	 * 顺序一致处理逻辑
	 * 
	 * @param prisrvs
	 * @param medsrvdos
	 * @param hm
	 * @return
	 */
	private static OrWfExDeptParamDTO[] InOutSeqSyncHandle4orwf(OrWfExDeptParamDTO[] prisrvs, MedSrvDO[] medsrvdos,
			HashMap<String, Integer> hm) {

		// 参数
		OrWfExDeptParamDTO[] rtns = new OrWfExDeptParamDTO[medsrvdos.length];

		// 遍历
		for (int i = 0; i < prisrvs.length; i++) {
			rtns[(Integer) hm.get(medsrvdos[i].getId_srv())] = prisrvs[i];
		}

		// 返回值
		return rtns;
	}

	public static OrWfExDeptParamDTO[] getExeDeptCalParamDTODOs(CiOrderDO ordo, CiEmsDTO ems, Integer setindex,
			MedSrvDO[] prisrvdo, MedSrvRelMmDTO srvrelmmdo) throws BizException {

		List<OrWfExDeptParamDTO> paramlist = new ArrayList<OrWfExDeptParamDTO>();
		CiEmsSrvDTO setsrv = (CiEmsSrvDTO) ems.getEmssrvs().get(setindex);
		for (MedSrvDO medSrvDO : prisrvdo) {
			OrWfExDeptParamDTO paramdto = new OrWfExDeptParamDTO();
			paramdto.setCode_entp(ems.getCode_entp());
			paramdto.setId_dept_en(ems.getId_dept_en());
			paramdto.setId_dept_or(ems.getId_dep_phy());
			paramdto.setId_dept_ns(ems.getId_dept_ns());
			paramdto.setId_dept_ex(ordo.getId_dep_mp());
			paramdto.setRecurstr(CiOrdUtils.getFg_longStr(ems.getFg_long()));
			paramdto.setId_srv(medSrvDO.getId_srv());
			if (!CiOrdUtils.isEmpty(srvrelmmdo)) {
				paramdto.setId_mm(srvrelmmdo.getId_mm());
			}
			paramdto.setSd_srvtp(medSrvDO.getSd_srvtp());
			paramdto.setId_srvca(medSrvDO.getId_srvca());
			paramdto.setInnercode_srvca(medSrvDO.getSrvca_innercode());
			paramdto.setId_usage(medSrvDO.getId_route());
			paramdto.setWeekno(DateUtils.getWeekNoStr4Dt(ordo.getDt_effe()));
			paramdto.setTimestr(DateUtils.getFTime8Dt(ordo.getDt_effe()));
			// paramdto.setDef1();
			// paramdto.setDef2();
			// paramdto.setReserv3(IBdSrvDictCodeConst.SD_ORTMPLTP_WITHSRVSET+CiOrdUtils.COMMA_STR+""+CiOrdUtils.COMMA_STR+ordo.getId_dep_mp());
			// paramdto.setDef4();
			// paramdto.setDef5();
			if (!CiOrdUtils.isTrue(medSrvDO.getFg_mm())) {
				paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW); // 只求执行科室
			} else {
				paramdto.setEu_wftp(EnumFlow.NULL); // 求物资流向科室
			}
			paramlist.add(paramdto);
		}

		if (paramlist.isEmpty())
			return null;
		return paramlist.toArray(new OrWfExDeptParamDTO[0]);
	}

	/**
	 * 从CiEmsDTO中，取第一个非套的服务项目的检验属性 DO数据
	 * 
	 * @param emsdto
	 * @return
	 */
	public static MedSrvLisDO getMedSrvLisDOByEmsSrv(CiEmsDTO emsdto) {
		if (CiOrdUtils.isEmpty(emsdto) || CiOrdUtils.isEmpty(emsdto.getEmssrvs()))
			return null;
		FArrayList emssrvs = emsdto.getEmssrvs();
		for (int i = 0; i < emssrvs.size(); i++) {
			CiEmsSrvDTO emssrv = (CiEmsSrvDTO) emssrvs.get(i);
			if (emssrv.getFg_set() == null || !emssrv.getFg_set().booleanValue()) {
				try {
					MedSrvLisDO[] medsrvs = CiOrdAppUtils.getIMedSrvLisDORService()
							.find(String.format("id_srv='%s'", emssrv.getId_srv()), "", FBoolean.FALSE);
					if (!CiOrdUtils.isEmpty(medsrvs)) {
						return medsrvs[0];
					} else {
						return null;
					}
				} catch (Exception e) {

				}

			}
		}
		return null;
	}

	/**
	 * 是否启用医保标志
	 * 
	 * @return
	 */
	public static FBoolean IsMedicalInsuranceEnable() throws BizException {
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		String temp = ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_IsMedicalInsuranceEnable);
		if (temp != null) {
			if (temp.equalsIgnoreCase("true"))
				return FBoolean.TRUE;
		} else {
			return FBoolean.FALSE;
		}
		return FBoolean.FALSE;
	}

	/**
	 * 是否启用医保校验规则
	 * 
	 * @return
	 */
	public static FBoolean IsMedInsuranceCheckUse() throws BizException {
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		FBoolean temp = ParamsetQryUtil.getParaBoolean(id_org, ICiOrdNSysParamConst.SYS_PARAM_IsMedInsuranceCheckUse);
		if (temp != null) {
			if (temp.equals(FBoolean.TRUE))
				return FBoolean.TRUE;
		} else {
			return FBoolean.FALSE;
		}
		return FBoolean.FALSE;
	}

	// 门诊医保审核处理模式 0 实时交互模式 1 集中交互模式 2 医保部门审核模式 默认值
	public static String OpMedInsuranceAuditHandleMode() throws BizException {
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		return ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_OpMedInsuranceAuditHandleMode);
	}

	// 门诊医保审核处理模式 0 实时交互模式 1 集中交互模式 2 医保部门审核模式 默认值
	public static String IpMedInsuranceAuditHandleMode() throws BizException {
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		return ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_IpMedInsuranceAuditHandleMode);
	}

	// public static String

	/**
	 * 通过服务的主键：id_srv,获得服务的检验属性 DO数据
	 * 
	 * @param id_srv
	 * @return
	 */
	public static MedSrvLisDO getMedSrvLisByIdSrv(String id_srv) {
		if (CiOrdUtils.isEmpty(id_srv)) {
			return null;
		}
		try {
			MedSrvLisDO[] medsrvs = CiOrdAppUtils.getIMedSrvLisDORService().find(String.format("id_srv='%s'", id_srv),
					"", FBoolean.FALSE);
			if (!CiOrdUtils.isEmpty(medsrvs)) {
				return medsrvs[0];
			} else {
				return null;
			}
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 通过组织的主键：id_group，获得组织的do对象
	 * 
	 * @param id_group
	 * @return
	 */
	public static GroupDO getGroupDO(String id_group) {
		if (CiOrdUtils.isEmpty(id_group))
			return null;
		try {
			return CiOrdAppUtils.getIGroupRService().findById(id_group);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过组织的主键：id_group，获得组织的do对象
	 * 
	 * @param id_group
	 * @return
	 */
	public static OrgDO getOrgDO(String id_org) {
		if (CiOrdUtils.isEmpty(id_org))
			return null;
		try {
			IOrgRService service=ServiceFinder.find(IOrgRService.class);
			return service.findById(id_org);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得医嘱流向执行科室
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public static OrWfExDeptDTO getOrWfExDept(String id_dep, Integer eu_wftp) throws BizException {
		OrWfExDeptDTO deptdto = CiOrdAppUtils.getBdFcQryQryService().getExDeptInfo8DepId(id_dep);
		deptdto.setEu_wftp(eu_wftp);
		return deptdto;
	}

	/**
	 * 总量 （逻辑待优化）
	 * 
	 * @param ems
	 * @param ipos
	 * @param srvdo
	 * @return
	 */
	public static FDouble getOrSrvQuanMed(CiEmsDTO ems, Integer ipos, OrdSrvDO srvdo) {
		if (CiOrdUtils.isEmpty(ems.getTimes_cur())) {
			FDouble quan_cur = ((CiEmsSrvDTO) ems.getEmssrvs().get(0)).getQuan_cur();
			if (quan_cur != null) {
				return quan_cur.multiply(srvdo.getQuan_medu());
			} else {
				Integer freqct = ((CiEmsSrvDTO) ems.getEmssrvs().get(ipos)).getFreqct();
				freqct = freqct == null ? 1 : freqct;
				Integer days = (ems.getDays_or() == null || ems.getDays_or() == 0) ? 1 : ems.getDays_or();
				return new FDouble(freqct.doubleValue() * days.doubleValue()).multiply(srvdo.getQuan_medu());
			}

		} else {
			return srvdo.getQuan_medu().multiply(ems.getTimes_cur());
		}
	}

	/**
	 * 
	 * 
	 * 
	 * 医嘱状态（临时方案 不要使用） isOpOrder 门诊 false 住院 是 true
	 * 
	 * @param list
	 *            <CiOrderDO>
	 * @param isOpOrder
	 */
	@Deprecated
	public static void getOrderStatus(List<CiOrderDO> list, Boolean isOpOrder) {
		for (CiOrderDO ci : list) {

			if (ci.getSd_su_or() == "0") {
				ci.setSu_or_name("开立");
				// ci.Ord_colligate = ((int)OrdPicStatusIndex.OPEN).ToString();
			} else if (ci.getSd_su_or() == "10") {
				ci.setSu_or_name("签署");
				// ci.Ord_colligate = ((int)OrdPicStatusIndex.SIGN).ToString();
			} else if (ci.getSd_su_or() == "20") {
				if (ci.getSd_su_bl() != "0" && isOpOrder) {
					ci.setSu_or_name("收费");
					// ci.Ord_colligate =
					// ((int)OrdPicStatusIndex.BL).ToString();

				} else if (ci.getFg_long().booleanValue()) {
					if (ci.getSd_su_mp() == "0") {
						ci.setSu_or_name("确认");
						// ci.Ord_colligate =
						// ((int)OrdPicStatusIndex.CONFIRM).ToString();
					} else {
						if (ci.getDt_end() == null || ci.getDt_end().after(MAX_SYS_DATETIME)) {
							ci.setSu_or_name("执行中");
							// ci.Ord_colligate =
							// ((int)OrdPicStatusIndex.EXEC).ToString();
						} else {
							ci.setSu_or_name("预停");
							// ci.Ord_colligate =
							// ((int)OrdPicStatusIndex.PRESTOP).ToString();
						}
					}
				} else {
					if (ci.getSd_su_mp() == "0") {
						ci.setSu_or_name("确认");
						// ci.Ord_colligate =
						// ((int)OrdPicStatusIndex.CONFIRM).ToString();
					} else if (ci.getSd_su_mp() == "1") {
						ci.setSu_or_name("已执行");
						// ci.Ord_colligate =
						// ((int)OrdPicStatusIndex.EXECUTED).ToString();
					} else if (ci.getSd_su_mp() == "2") {
						ci.setSu_or_name("拒执行");
						// ci.Ord_colligate =
						// ((int)OrdPicStatusIndex.REJECTEXEC).ToString();
					} else {
						ci.setSu_or_name("完成");
						// ci.Ord_colligate =
						// ((int)OrdPicStatusIndex.UNKNOW).ToString();
					}
				}

			} else if (ci.getSd_su_or() == "70") {
				ci.setSu_or_name("作废");
				// ci.Ord_colligate =
				// ((int)OrdPicStatusIndex.CANCEL).ToString();
			} else if (ci.getSd_su_or() == "80") {
				ci.setSu_or_name("作废核对");
				// ci.Ord_colligate =
				// ((int)OrdPicStatusIndex.CANCELLED).ToString();
			} else if (ci.getSd_su_or() == "50") {
				ci.setSu_or_name("停止");
				// ci.Ord_colligate = ((int)OrdPicStatusIndex.STOP).ToString();
			} else if (ci.getSd_su_mp() != "0" && !ci.getDt_end().after(MAX_SYS_DATETIME)
					&& (ci.getFg_long() != null && ci.getFg_long().booleanValue())) {
				ci.setSu_or_name("预停");
				// ci.Ord_colligate =
				// ((int)OrdPicStatusIndex.PRESTOP).ToString();
			} else {
				ci.setSu_or_name("完成");
				// ci.Ord_colligate =
				// ((int)OrdPicStatusIndex.UNKNOW).ToString();
			}

		}
	}

	public static FDouble getTotalMedu(CiEmsSrvDTO srvdto, Integer useDays, Integer orders) {
		useDays = useDays == null ? 1 : useDays;
		orders = orders == null ? 1 : orders;

		// 如果是物品，重新获取物品对象 TODO 计算总量
		if (FBoolean.TRUE.equals(srvdto.getFg_mm())) {
			// 计算药品总量
			if (FBoolean.TRUE.equals(srvdto.getFg_dose_anoma())) { // 变动用药计算总量
				GetDrugTotalQuan4DoseBP bp = new GetDrugTotalQuan4DoseBP();
				return new FDouble(bp.exec(srvdto, useDays));
			} else {
				if (srvdto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) { // 草药计算总量
					GetDrugTotalQuan4HerbsBP bp = new GetDrugTotalQuan4HerbsBP();
					try {
						return bp.exec(srvdto, orders);
					} catch (BizException e) {
						e.printStackTrace();
					}
				} else {
					GetDrugTotalQuanBP bp = new GetDrugTotalQuanBP();
					try {
						return new FDouble(bp.exec(srvdto, useDays));
					} catch (BizException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			// 计算非药品服务总量
			GetSrvTotalQuanBP bp = new GetSrvTotalQuanBP();
			try {
				return new FDouble(bp.exec(srvdto, useDays));
			} catch (BizException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 获得皮试医嘱
	 * 
	 * @param id_or_skin
	 * @return
	 */
	public static CiSkinTestRstDO getCiSkinTestRstDO(String id_or_skin) {
		CiSkinTestRstDO[] rstDos = null;
		try {
			rstDos = CiOrdAppUtils.getCiskintestrstQryService().find(String.format("id_or='%s'", id_or_skin), "",
					FBoolean.FALSE);
		} catch (BizException e) {
			e.printStackTrace();
		}
		if (rstDos != null && rstDos.length > 0) {
			return rstDos[0];
		} else {
			return null;
		}
	}

	/**
	 * 获得为作废的皮试医嘱
	 * 
	 * @param id_or_skin
	 * @return
	 */
	public static CiSkinTestRstDO getCiSkinTestRstDOUnCanc(String id_or_skin) {
		CiSkinTestRstDO[] rstDos = null;
		try {
			String sqlstr = "select skin.* from ci_skin_test skin inner join ci_order ci on ci.id_or = skin.id_or where skin.id_or=? and ci.fg_canc='N'";
			SqlParam param = new SqlParam();
			param.addParam(id_or_skin);
			List<CiSkinTestRstDO> rstDoArray = (List<CiSkinTestRstDO>) new DAFacade().execQuery(sqlstr, param,
					new BeanListHandler(CiSkinTestRstDO.class));
			if (rstDoArray != null && rstDoArray.size() > 0) {
				rstDos = rstDoArray.toArray(new CiSkinTestRstDO[0]);
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		if (rstDos != null && rstDos.length > 0) {
			return rstDos[0];
		} else {
			return null;
		}
	}

	/***
	 * 判断药品是否需要核对患者信息 只有麻醉、精一的药品需要提示 ; 0非毒麻,1麻醉药品,2一类精神药品,3二类精神药品,4毒性药品,5放射性药品
	 * 
	 * @param sd_pois
	 * @return
	 * @throws BizException 
	 */
	public static FBoolean isNeedCheckPatInfo(String sd_pois) throws BizException {
		if (isEmpty(sd_pois)) {
			return FBoolean.FALSE;
		}
		//根据CIOR0817【需进行患者信息核对的毒麻分类】的参数进行查询
		String skinTestDosage = ParamsetQryUtil.getParaString(Context.get().getOrgId(),ICiOrdNSysParamConst.SYS_PARAM_IsNeedCheckPatInfo);
		if (skinTestDosage.contains(sd_pois)) {
			return FBoolean.TRUE;
		}
		/*if (sd_pois.equals(IBdMmDictCodeConst.SD_POIS_MAZUI) || sd_pois.equals(IBdMmDictCodeConst.SD_POIS_JINGSHEN_1)) {
			return FBoolean.TRUE;
		}*/
		return FBoolean.FALSE;
	}

	/**
	 * 删除患者核对信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public static FBoolean delOrSrvAgentInfoDO(String[] id_ors) throws BizException {
		// 执行患者核对信息的删除
		OrSrvAgentInfoDO[] agentInfos = CiOrdAppUtils.getCiorsrvagentRService().findByAttrValStrings("Id_or", id_ors);
		if (agentInfos != null) {
			CiOrdAppUtils.getOrsrvagentService().delete(agentInfos);
		}
		return FBoolean.TRUE;
	}

	/**
	 * 费用项目根据SortNo升序排序
	 * 
	 * @param orsrvdos
	 * @return
	 */
	public static void orderBySortNoAscSrvItems(OrdSrvDO[] orsrvdos) {
		if (orsrvdos == null)
			return;
		try {
			for (int i = 0; i < orsrvdos.length; i++) {
				for (int j = i + 1; j < orsrvdos.length; j++) {
					if (orsrvdos[i].getSortno() > orsrvdos[j].getSortno()) {
						OrdSrvDO srvA = orsrvdos[i];
						orsrvdos[i] = orsrvdos[j];
						orsrvdos[j] = srvA;
					}
				}
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 费用项目根据SortNo升序排序
	 * 
	 * @param orsrvdos
	 * @return
	 */
	public static void SortFreqTimeDO(FreqTimeDO[] orsrvdos, String sort) {
		if (orsrvdos == null)
			return;
		try {
			for (int i = 0; i < orsrvdos.length; i++) {
				for (int j = i + 1; j < orsrvdos.length; j++) {
					if ((Integer) orsrvdos[i].getAttrVal(sort) > (Integer) orsrvdos[j].getAttrVal(sort)) {
						FreqTimeDO srvA = orsrvdos[i];
						orsrvdos[i] = orsrvdos[j];
						orsrvdos[j] = srvA;
					}
				}
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 前台是否已经计算过费用项目
	 * 
	 * @param ems
	 * @return
	 */
	public static FBoolean isHasPriSrvHandled(CiEmsDTO ems) {
		if (FBoolean.TRUE.equals(ems.getFg_prisrvhandled())
				&& !ems.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP) 
				&& !ems.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS))
			return FBoolean.TRUE;// 非住院前台已经算过费用项目
		return FBoolean.FALSE;
	}

	/**
	 * 根据医保服务类型SD获得ID
	 * 
	 * @param sd_hpsrvtp
	 * @return
	 */
	public static String idHpSrvtpFromSdHpSrvtp(String sd_hpsrvtp) {
		if (CiOrdUtils.isEmpty(sd_hpsrvtp))
			return null;
		if (IBdPpCodeTypeConst.SD_HP_BJ_ONE.equals(sd_hpsrvtp)) {
			return IBdPpCodeTypeConst.ID_HP_BJ_ONE;
		} else if (IBdPpCodeTypeConst.SD_HP_BJ_TOW.equals(sd_hpsrvtp)) {
			return IBdPpCodeTypeConst.ID_HP_BJ_TOW;
		} else if (IBdPpCodeTypeConst.SD_HP_BJ_THREE.equals(sd_hpsrvtp)) {
			return IBdPpCodeTypeConst.ID_HP_BJ_THREE;
		}
		return null;
	}

	/**
	 * 根据医保服务类型SD获得ID
	 * 
	 * @param sd_hpsrvtp
	 * @return
	 */
	public static String nameHpSrvtpFromSdHpSrvtp(String sd_hpsrvtp) {
		if (CiOrdUtils.isEmpty(sd_hpsrvtp))
			return null;
		if (IBdPpCodeTypeConst.SD_HP_BJ_ONE.equals(sd_hpsrvtp)) {
			return "甲类";
		} else if (IBdPpCodeTypeConst.SD_HP_BJ_TOW.equals(sd_hpsrvtp)) {
			return "已类";
		} else if (IBdPpCodeTypeConst.SD_HP_BJ_THREE.equals(sd_hpsrvtp)) {
			return "丙类";
		}
		return null;
	}

	/**
	 * 判断是门诊模式还是住院模式，门诊模式包括（就诊类型是门急诊、出院带药、草药）
	 * 
	 * @param code_entp
	 * @param fg_pres_outp
	 * @return
	 */
	public static FBoolean isOpMode(String code_entp, FBoolean fg_pres_outp, String sd_srvtp) {
		if (CiOrdUtils.isEmpty(code_entp))
			return FBoolean.FALSE;
		return new FBoolean(!(code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)
				|| code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS))
				|| (!CiOrdUtils.isEmpty(fg_pres_outp) && fg_pres_outp.booleanValue())
				|| (!CiOrdUtils.isEmpty(sd_srvtp) && sd_srvtp.startsWith("0103")));
	}

	/***
	 * 为OrdSrvDO总量赋值
	 * 
	 * @param ems
	 * @param srvdto
	 * @param srvdo
	 * @throws BizException
	 */
	public static void setQuanTotalMeduToSrvDO(CiEmsDTO ems, CiEmsSrvDTO srvdto, OrdSrvDO srvdo) throws BizException {
		if (srvdto.getQuan_total_medu() != null && srvdto.getQuan_total_medu().doubleValue() != 0) {
			srvdo.setQuan_total_medu(srvdto.getQuan_total_medu());
		} else if (srvdto.getQuan_cur() != null && srvdto.getQuan_cur().compareTo(FDouble.ZERO_DBL) > 0) {
			srvdo.setQuan_total_medu(srvdto.getQuan_cur());
		} else {
			QuantumParamDTO quantum = new QuantumParamDTO(ems, srvdto);
			CalQuantumBP bp = new CalQuantumBP();
			srvdo.setQuan_total_medu(bp.getQuantum(quantum));
		}
	}

	/**
	 * 获得临床医嘱分方规则编排插件接口
	 * 
	 * @return
	 */
	public static ICiOrPresSplitRuleArrangePlugin getCiOrPresSplitRuleArrangePlugin() {
		// 获得临床医嘱在院执行标识默认值设置插件
		String pluginStr = CiOrdUtils.getOrgParamStr(ICiOrdNSysParamConst.SYS_PARAM_CiOrSplit4PresTransPlugin);

		// 空判断
		if (CiOrdUtils.isEmpty(pluginStr))
			return new CiOrPresSplitRuleArrangeDefaultPlugin();

		try {
			Class<?> c = Class.forName(pluginStr);
			// Class<?> c =
			// Class.forName("iih.ci.ord.s.bp.splitpres.test.CiOrPresSplitRuleArrangeTestPlugin");
			return (ICiOrPresSplitRuleArrangePlugin) c.newInstance();
		} catch (Exception e) {
			return new CiOrPresSplitRuleArrangeDefaultPlugin();
		}

	}
	/**
	 * 
	 * @code 有参简单反射
	 * @param param 方法入参dto
	 * @param classname 类路径
	 * @param method 方法名
	 */
	public static Object ReflectMethodInvoke(Object param, String classname, String method) throws Exception {
		Class<?> rule = Class.forName(classname);
		Method getCodeMethod = rule.getMethod(method, param.getClass());
		Constructor ruleConstructor = rule.getConstructor();
		Object ruleObj = ruleConstructor.newInstance();
		return getCodeMethod.invoke(ruleObj, param);
	}
	/**
	 * 
	 * @code 无参简单反射
	 * @param param 方法入参dto
	 * @param classname 类路径
	 * @param method 方法名
	 */
	public static Object ReflectMethodInvoke( String classname, String method) throws Exception {
		Class<?> rule = Class.forName(classname);
		Method getCodeMethod = rule.getMethod(method);
		Constructor ruleConstructor = rule.getConstructor();
		Object ruleObj = ruleConstructor.newInstance();
		return getCodeMethod.invoke(ruleObj);
	}
	/***
	 * 为OrdSrvDO赋值折扣价、折扣系数等
	 * 
	 * @param emssrvdto
	 * @param orsrv
	 */
	public static void assignPriratToSrvDO(CiEmsSrvDTO emssrvdto, OrdSrvDO orsrv) {
		// 折扣价、折扣系数
		orsrv.setPri_std(emssrvdto.getPri_std());// 标准价
		orsrv.setPri_ratio(emssrvdto.getPri_ratio());// 价格系数
		orsrv.setId_pripat(emssrvdto.getId_pripat());// 患者价格分类
		orsrv.setPri(emssrvdto.getPrice());// 折扣价
	}

	/***
	 * 为OrdSrvDO赋值折扣价、折扣系数等
	 * 
	 * @param emssrvdto
	 * @param orsrv
	 */
	public static void assignPriratToEmsSrvDTO(OrdSrvDO orsrv, CiEmsSrvDTO emssrvdto) {
		// 折扣价、折扣系数
		emssrvdto.setPri_std(orsrv.getPri_std());// 标准价
		emssrvdto.setPri_ratio(orsrv.getPri_ratio());// 价格系数
		emssrvdto.setId_pripat(orsrv.getId_pripat());// 患者价格分类
	}

	/**
	 * 校验，频次为持续类型时，剂量单位必须是时间类型的
	 * 
	 * @param id_freq
	 * @param id_unit_med
	 * @return
	 * @throws BizException
	 */
	public static FBoolean validateFreqAndQuanMedu(String id_freq, String id_unit_med) throws BizException {
		if (CiOrdUtils.isEmpty(id_freq) || CiOrdUtils.isEmpty(id_unit_med))
			return FBoolean.TRUE;// 频次或剂量单位为空时，不做校验
		FreqdefAggDO freqdefAgg = CiOrdUtils.getFreqAggDO(id_freq);
		FreqDefDO freqParent = freqdefAgg.getParentDO();
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ALWAYS.equals(freqParent.getSd_frequnitct())) {
			MeasDocDO measDoc = CiOrdAppUtils.getCiOrdQryService().getMeasDocDOById(id_unit_med);
			if (!ISysDictCodeConst.SD_OPPDIMEN_T.equals(measDoc.getSd_oppdimen())) {
				return FBoolean.FALSE;
			}
		}
		return FBoolean.TRUE;
	}

	/**
	 * 是否启用医保校验
	 * 
	 * 门诊医保审核处理模式 0 实时交互模式 1 集中交互模式 2 医保部门审核模式 默认值
	 * 
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public static boolean isHpUsing(CiEnContextDTO ctx) throws BizException {
		String sd_hptp = ctx.getSd_hptp();// 高端商保不走医保逻辑，1开头社保，2开头商保
		boolean flag = FBoolean.TRUE.equals(CiOrdUtils.IsMedicalInsuranceEnable())
				&& CiOrdUtils.OpMedInsuranceAuditHandleMode().equalsIgnoreCase("0")
				&& !CiOrdUtils.isEmpty(ctx.getId_hp()) && FBoolean.TRUE.equals(ctx.getFg_hpfundpay())
				&& HpBeyondEnum.HPDIAG.equals(ctx.getEu_hpbeyond()) && !isEmpty(sd_hptp) && sd_hptp.startsWith("1");
		return flag;
	}

	/**
	 * 根据医保适应症细则DTO，获得医生是否已经判断过标识,0 不需要判断，1已判断，2待判断
	 * 
	 * @param hpdto
	 * @return
	 */
	public static Integer getFg_hpindicjudged(BdHpIndicationDTO hpdto) {
		if (hpdto == null) {
			return null;
		}
		String sd_hpsrvtp = hpdto.getSd_hpsrvtp();// 医保类型
		// 丙类
		if (isEmpty(sd_hpsrvtp) || sd_hpsrvtp.equals(IBdSrvDictCodeConst.SD_INFECTP_C)) {
			return (int) HpIndicJudgeEnum.NONEEDJUDGE;// 0不需要判断，1待判断，2已判断;
		}
		String code_hpindicjudged = hpdto.getCode_hpindicjudged();// 判断方式
		if (isEmpty(code_hpindicjudged)) {
			return (int) HpIndicJudgeEnum.NONEEDJUDGE;// 0不需要判断，1待判断，2已判断;
		} else if (code_hpindicjudged.equals(IBdSrvDictCodeConst.SD_HP_JUDGE_METHOD_NO_CONTROL)) { // 不控制
			return (int) HpIndicJudgeEnum.NONEEDJUDGE;// 0不需要判断，1待判断，2已判断;
		} else if (code_hpindicjudged.equals(IBdSrvDictCodeConst.SD_HP_JUDGE_METHOD_SYS_CONFIRM)) {
			return (int) HpIndicJudgeEnum.NONEEDJUDGE;// 0不需要判断，1待判断，2已判断;
		} else if (code_hpindicjudged.equals(IBdSrvDictCodeConst.SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM)) {
			return (int) HpIndicJudgeEnum.WAITINGJUDGE;// 0不需要判断，1待判断，2已判断;
		} else if (code_hpindicjudged.equals(IBdSrvDictCodeConst.SD_HP_JUDGE_METHOD_DOC_CONFIRM)) {
			return (int) HpIndicJudgeEnum.WAITINGJUDGE;// 0不需要判断，1待判断，2已判断;
		}
		return (int) HpIndicJudgeEnum.WAITINGJUDGE;// 0不需要判断，1待判断，2已判断;
	}

	/**
	 * 根据医保计划设置医保目录类型（仅设置服务中医保目录类型为空的服务项目）
	 * 
	 * @param id_hp
	 *            医保计划
	 * @param ciorAggDatumList
	 *            医嘱对象集合
	 * @throws BizException
	 */
	public static void setHpSrvtp(List<CiOrAggAndRelDatum> ciorAggDatumList) throws BizException {

		CiEnContextDTO ctx = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		String id_hp = ctx.getId_hp(); // 患者本次就诊医保计划，高端商保时不为空，自费就诊时为空
		String id_hp_default = ctx.getId_hp_default(); // 当非社保就诊时，该值不为空，并且使用默认医保计划获取医保目录类型

		// 设置获取医保目录类型的医保计划，如果非社保就诊时，使用默认医保计划获取医保目录类型
		String tempIdHp = id_hp;
		if (!CiEnContextUtil.IsHpPat(ctx)) {
			tempIdHp = id_hp_default;
		}

		// CiOrAggAndRelDatum对象中获取物品集合key值
		String key = OrdSrvMmDODesc.CLASS_FULLNAME;
		List<String> idSrvList = new ArrayList<String>();
		List<String> idMmList = new ArrayList<String>();

		// 医保目录类型为空的服务项目集合
		List<OrdSrvDO> ordSrvList = new ArrayList<OrdSrvDO>();

		for (CiOrAggAndRelDatum ciOrAggAndRel : ciorAggDatumList) {

			CiorderAggDO ciordAgg = ciOrAggAndRel.getOraggdo();
			Hashtable<?, ?> attachht = ciOrAggAndRel.getOrattachht();

			// 构造服务与物品id集合 key 服务id, value 物品id集合
			Map<String, List<String>> idSrvIdMmMap = new HashMap<String, List<String>>();
			FMap mmMap = null;

			if (attachht != null) {// 诊疗项目改对象为空为空，其他为空情况待确认
				Object objAttachht = attachht.get(key); // 获取药品的map集合
				if (objAttachht != null) {

					mmMap = (FMap) objAttachht;
					for (String idSrvIdmm : mmMap.keySet()) { // 物品的
																// Orattachht,对象保存的是map结构，key值是“服务id_物品id”格式

						String[] idArr = idSrvIdmm.split("_"); // 物品集合中key值id_srv+"_"+id_mm结构
						String tempIdSrv = idArr[0];
						List<String> tempIdmmList = null;
						if (idSrvIdMmMap.containsKey(tempIdSrv)) {
							tempIdmmList = idSrvIdMmMap.get(tempIdSrv);
						} else {
							tempIdmmList = new ArrayList<String>();
							idSrvIdMmMap.put(tempIdSrv, tempIdmmList);
						}

						tempIdmmList.add(idArr[1]);
					}
				}
			}

			// 遍历服务项目，设置医保目录类型
			for (OrdSrvDO ordSrv : ciordAgg.getOrdSrvDO()) {

				if (StringUtils.isEmpty(ordSrv.getId_hp())) { // 这种不确定什么情况会出现。原实现逻辑中有这个赋值
					ordSrv.setId_hp(id_hp);
				}

				// 如果医保目录类型已经存在，就不重新赋值
				if (StringUtils.isNotEmpty(ordSrv.getId_hpsrvtp()) && StringUtils.isNotEmpty(ordSrv.getSd_hpsrvtp())) {
					continue;
				}

				if (FBoolean.TRUE.equals(ordSrv.getFg_mm())) {
					idMmList.add(ordSrv.getId_mm());
				} else {
					idSrvList.add(ordSrv.getId_srv());
				}

				ordSrvList.add(ordSrv);
			}

			// 根据医保计划，服务，物品id获取医保目录类型
			Map<String, HPSrvorcaDO> hpSrvorcaMap = getHPSrvorcaMap(tempIdHp, idSrvList, idMmList);

			// 设置默认医保目录类型，如果不在医保计划内，设置医保目录类型为丙类
			for (OrdSrvDO ordSrv : ordSrvList) {
				String idSrvIdMm = ordSrv.getId_srv() + ordSrv.getId_mm();
				HPSrvorcaDO hpSrvorca = hpSrvorcaMap.get(idSrvIdMm);
				if (hpSrvorca == null) {
					ordSrv.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
					ordSrv.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
				} else {
					ordSrv.setId_hpsrvtp(hpSrvorca.getId_hpsrvtp());
					ordSrv.setSd_hpsrvtp(hpSrvorca.getSd_hpsrvtp());
				}
			}
		}
	}

	/**
	 * 根据急医保计划，服务id，物品id获取医保目录类型集合
	 * 
	 * @param id_hp
	 *            医保计划id
	 * @param idSrvList
	 *            服务id集合
	 * @param idMmList
	 *            物品id集合
	 * @return 医保目录类型map key值为“id_srv+id_mm”
	 * @throws BizException
	 */
	public static Map<String, HPSrvorcaDO> getHPSrvorcaMap(String id_hp, List<String> idSrvList, List<String> idMmList)
			throws BizException {

		StringBuffer whereBuffer = new StringBuffer();
		StringBuffer idSrvBuffer = new StringBuffer();
		StringBuffer idMmBuffer = new StringBuffer();

		Map<String, HPSrvorcaDO> hpSrvcaMap = new HashMap<String, HPSrvorcaDO>();
		if (idSrvList.size() == 0 && idMmList.size() == 0) {
			return hpSrvcaMap;
		}

		whereBuffer.append("id_hp = '" + id_hp + "' and (");
		
		if (idSrvList.size() > 0) {

			for (String idSrv : idSrvList) {
				idSrvBuffer.append(",'" + idSrv + "'");
			}
			whereBuffer.append(" id_srv in (").append(idSrvBuffer.substring(1)).append(")");
		}

		if (idMmList.size() > 0) {

			if (idSrvList.size() > 0) {
				whereBuffer.append(" or ");
			}

			for (String idMm : idMmList) {
				idMmBuffer.append(",'" + idMm + "'");
			}
			whereBuffer.append(" id_mm in (").append(idMmBuffer.substring(1)).append(")");
		}

		whereBuffer.append(")");

		HPSrvorcaDO[] hpSrvorcas = CiOrdAppUtils.getIHpExtService().find(whereBuffer.toString(), "", FBoolean.FALSE);

		for (HPSrvorcaDO hpSrvorca : hpSrvorcas) {

			String key = hpSrvorca.getId_srv()
					+ (StringUtils.isEmpty(hpSrvorca.getId_mm()) ? "" : hpSrvorca.getId_mm());
			hpSrvcaMap.put(key, hpSrvorca);
		}

		return hpSrvcaMap;
	}

	/**
	 * 如果存在医保id（id_hp），为每一个服务项目赋值
	 * 
	 * @param oragginfo
	 * @param skintestagginfos
	 * @param ems
	 * @throws BizException
	 */
	public static void setIdHpValue(CiOrAggAndRelDatum oragginfo, ArrayList<CiOrAggAndRelDatum> skintestagginfos)
			throws BizException {

		List<CiOrAggAndRelDatum> ciOrAggList = new ArrayList<CiOrAggAndRelDatum>();
		ciOrAggList.add(oragginfo);

		if (skintestagginfos != null && skintestagginfos.size() > 0) {
			ciOrAggList.addAll(skintestagginfos);
		}
		setHpSrvtp(ciOrAggList);
	}

	/**
	 * 如果存在医保id（id_hp），为每一个服务项目赋值
	 * 
	 * @param oragginfo
	 * @param skintestagginfos
	 * @param ems
	 * @throws BizException
	 */
	public static void setIdHpValue_tl(CiOrAggAndRelDatum oragginfo, ArrayList<CiOrAggAndRelDatum> skintestagginfos)
			throws BizException {

		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		String id_hp = context.getId_hp();
		String id_hp_default = context.getId_hp_default();
		Map<String, OrdSrvDO> srvMap = new HashMap<String, OrdSrvDO>();
		Map<String, OrdSrvDO> skinSrvMap = new HashMap<String, OrdSrvDO>();
		List<String> exHPIdSrv = new ArrayList<String>();
		List<String> exHPIdIdMm = new ArrayList<String>();
		if (!CiOrdUtils.isEmpty(oragginfo) && !CiOrdUtils.isEmpty(id_hp_default)) {
			CiorderAggDO aggDO = oragginfo.getOraggdo();
			if (aggDO != null && aggDO.getOrdSrvDO() != null) {
				if (aggDO.getOrdSrvDO().length > 0) {
					for (OrdSrvDO srvdo : aggDO.getOrdSrvDO()) {
						if (StringUtils.isEmpty(srvdo.getId_hp())) {
							srvdo.setId_hp(id_hp);
						}
						// 分拣出服务中没有医保目录的
						pickSrvIsNoIdHPSrvtp(oragginfo, srvdo, srvMap, exHPIdSrv, exHPIdIdMm);
					}
				}
			}
		}
		if (!CiOrdUtils.isEmpty(skintestagginfos) && !CiOrdUtils.isEmpty(id_hp_default)) {
			for (CiOrAggAndRelDatum relDatum : skintestagginfos) {
				CiorderAggDO aggDO = relDatum.getOraggdo();
				if (aggDO != null && aggDO.getOrdSrvDO() != null) {
					if (aggDO.getOrdSrvDO().length > 0) {
						for (OrdSrvDO srvdo : aggDO.getOrdSrvDO()) {
							if (StringUtils.isEmpty(srvdo.getId_hp())) {
								srvdo.setId_hp(id_hp);
							}
							// 分拣出服务中没有医保目录的
							pickSrvIsNoIdHPSrvtp(oragginfo, srvdo, skinSrvMap, exHPIdSrv, exHPIdIdMm);
						}
					}
				}
			}
		}
		// 如果存在没有id_hpsrvtp和sd_hpsrvtp的服务，给该服务赋值
		if (exHPIdSrv.size() > 0 || exHPIdIdMm.size() > 0) {
			String sql = getSql(exHPIdSrv, exHPIdIdMm, id_hp_default);
			HPSrvorcaDO[] hpSrvorcas = CiOrdAppUtils.getIHpExtService().find(sql, "", FBoolean.FALSE);
			for (HPSrvorcaDO srvca : hpSrvorcas) {
				String id_mm = srvca.getId_mm() == null ? "" : srvca.getId_mm();
				String id_srv = srvca.getId_srv();
				String key = id_srv + id_mm;
				if (skinSrvMap.containsKey(key)) {
					OrdSrvDO srv = skinSrvMap.get(key);
					exHPIdSrv.remove(id_srv);
					srv.setId_hpsrvtp(srvca.getId_hpsrvtp());
					srv.setSd_hpsrvtp(srvca.getSd_hpsrvtp());
				}
				if (srvMap.containsKey(key)) {
					OrdSrvDO srv = srvMap.get(key);
					exHPIdIdMm.remove(id_srv);
					srv.setId_hpsrvtp(srvca.getId_hpsrvtp());
					srv.setSd_hpsrvtp(srvca.getSd_hpsrvtp());
				}
			}
			// fg_bl为true，且医保目录中不存在，设置为丙类
			if (!CiOrdUtils.isEmpty(oragginfo) && !CiOrdUtils.isEmpty(id_hp_default)) {
				CiorderAggDO aggDO = oragginfo.getOraggdo();
				if (aggDO != null && aggDO.getOrdSrvDO() != null) {
					if (aggDO.getOrdSrvDO().length > 0) {
						for (OrdSrvDO srvdo : aggDO.getOrdSrvDO()) {
							if (StringUtils.isEmpty(srvdo.getId_hpsrvtp()) && FBoolean.TRUE.equals(srvdo.getFg_bl())) {
								srvdo.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
								srvdo.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
							}
						}
					}
				}
			}
			if (!CiOrdUtils.isEmpty(skintestagginfos) && !CiOrdUtils.isEmpty(id_hp_default)) {
				for (CiOrAggAndRelDatum relDatum : skintestagginfos) {
					CiorderAggDO aggDO = relDatum.getOraggdo();
					if (aggDO != null && aggDO.getOrdSrvDO() != null) {
						if (aggDO.getOrdSrvDO().length > 0) {
							for (OrdSrvDO srvdo : aggDO.getOrdSrvDO()) {
								if (StringUtils.isEmpty(srvdo.getId_hp()) && FBoolean.TRUE.equals(srvdo.getFg_bl())) {
									srvdo.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
									srvdo.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 设置手术不计费
	 * 
	 * @param oragginfo
	 * @param skintestagginfos
	 */
	public static void setOpBlFree(CiOrAggAndRelDatum oragginfo, ArrayList<CiOrAggAndRelDatum> skintestagginfos) {
		if (!CiOrdUtils.isEmpty(oragginfo)) {
			CiorderAggDO aggDO = oragginfo.getOraggdo();
			if (aggDO != null && aggDO.getOrdSrvDO() != null) {
				if (aggDO.getOrdSrvDO().length > 0) {
					for (OrdSrvDO srvdo : aggDO.getOrdSrvDO()) {
						if (srvdo.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_OP_TAICI)) {
							srvdo.setFg_bl(FBoolean.FALSE);
							srvdo.setId_primd(IBdPrimdCodeConst.ID_PRI_FREE);
							srvdo.setPri(FDouble.ZERO_DBL);
						}
					}
				}
			}
		}
		if (!CiOrdUtils.isEmpty(skintestagginfos)) {
			for (CiOrAggAndRelDatum relDatum : skintestagginfos) {
				CiorderAggDO aggDO = relDatum.getOraggdo();
				if (aggDO != null && aggDO.getOrdSrvDO() != null) {
					if (aggDO.getOrdSrvDO().length > 0) {
						for (OrdSrvDO srvdo : aggDO.getOrdSrvDO()) {
							if (srvdo.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_OP_TAICI)) {
								srvdo.setFg_bl(FBoolean.FALSE);
								srvdo.setId_primd(IBdPrimdCodeConst.ID_PRI_FREE);
								srvdo.setPri(FDouble.ZERO_DBL);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 服务不存在医保计划目录类型，记录下该服务的物品id和服务id，用于后续查询，并将该服务缓存在map中
	 * 
	 * @param oragginfo
	 * @param srvdo
	 * @param srvMap
	 * @param exHPIdSrv
	 * @param exHPIdMm
	 */
	public static void pickSrvIsNoIdHPSrvtp(CiOrAggAndRelDatum oragginfo, OrdSrvDO srvdo, Map<String, OrdSrvDO> srvMap,
			List<String> exHPIdSrv, List<String> exHPIdMm) {
		if (CiOrdUtils.isEmpty(srvdo.getId_hpsrvtp()) || CiOrdUtils.isEmpty(srvdo.getSd_hpsrvtp())) {
			String id_mm = "";
			if (FBoolean.TRUE.equals(srvdo.getFg_mm())) {
				String key = OrdSrvMmDODesc.CLASS_FULLNAME;
				if (oragginfo.getOrattachht() != null) {
					FMap mmMap = (FMap) oragginfo.getOrattachht().get(key);
					if (mmMap != null) {
						OrdSrvMmDO mm = (OrdSrvMmDO) mmMap.get(srvdo.getId_srv());
						if (mm != null) {
							id_mm = mm.getId_mm();
							exHPIdMm.add(id_mm);
						}
					}
				}
			} else {
				exHPIdSrv.add(srvdo.getId_srv());
			}
			srvMap.put(srvdo.getId_srv() + id_mm, srvdo);
		}
	}

	/**
	 * 查询医保目录
	 * 
	 * @param exHPIdSrv
	 *            非物品的物品id
	 * @param exHPIdIdMm
	 *            物品的id
	 * @return
	 */
	public static String getSql(List<String> exHPIdSrv, List<String> exHPIdIdMm, String id_hp) {
		StringBuffer sb = new StringBuffer(" id_hp='" + id_hp + "'");
		if (!CiOrdUtils.isEmpty(exHPIdSrv) && exHPIdSrv.size() > 0) {
			String exHPIdSrvs = exHPIdSrv.toString();
			sb.append(" and id_srv in ('"
					+ exHPIdSrvs.substring(1, exHPIdSrvs.length() - 1).replaceAll(",", "','").replaceAll(" ", "")
					+ "')");
		}
		if (!CiOrdUtils.isEmpty(exHPIdIdMm) && exHPIdIdMm.size() > 0) {
			String exHPIdIdMms = exHPIdIdMm.toString();
			sb.append(" and  id_mm in('"
					+ exHPIdIdMms.substring(1, exHPIdIdMms.length() - 1).replaceAll(",", "','").replaceAll(" ", "")
					+ "')");
		}
		return sb.toString();
	}

	/**
	 * key:id_mm+id_dep+wh+id_unit_sale,value是数组:0:物品id_mm，1：库房id_dep_wh，2：
	 * 总量单位id_unit_sale,3:开单总量
	 * 
	 * @param paramsMap
	 * @return
	 * @throws BizException
	 */
	public static String ValidateDrugCount(Map<String, String[]> paramsMap) throws BizException {
		String nocount = "";// 无库存
		String stopSale = "";// 停发
		String noDrug = "";// 无此药
		List<GetStockReqDTO> reqDtos = new ArrayList<GetStockReqDTO>();
		for (Map.Entry<String, String[]> map : paramsMap.entrySet()) {
			GetStockReqDTO reqDTO = new GetStockReqDTO();
			reqDTO.setId_mm(map.getValue()[0]);
			reqDTO.setId_dep(map.getValue()[1]);
			reqDTO.setReq_unit_id(map.getValue()[2]);
			reqDtos.add(reqDTO);
		}
		if (reqDtos.size() > 0) {
			IMaterialStockService stoctService = CiOrdAppUtils.getMaterialStockQryService();
			MaterialStockDTO[] stockdto = null;
			stockdto = stoctService.getMaterialStocks(reqDtos.toArray(new GetStockReqDTO[0]));
			if (stockdto != null) {
				String mmcounterror = "";
				for (MaterialStockDTO materialDo : stockdto) {
					String key = getKeyId(materialDo.getId_mm(), materialDo.getId_dep(), materialDo.getReq_unit_id());
					String[] param = paramsMap.get(key);
					FDouble mmcount = materialDo.getQuan_usable();
					// 药房无此药的移除
					if (materialDo.getMmstatus() == MaterialStatus.NORELATION) {
						noDrug += param[3] + ",";
					} else if (materialDo.getMmstatus() == MaterialStatus.STOP) {
						stopSale += param[3] + ",";
					} else if (mmcount != null && (mmcount.compareTo(new FDouble(0)) == 0
							|| mmcount.compareTo(new FDouble(param[4])) < 0)) {
						nocount += param[3] + ",";
					}
				}
				if (!CiOrdUtils.isEmpty(noDrug) && !mmcounterror.contains(noDrug)) {
					mmcounterror = "服务：" + noDrug.substring(0, noDrug.length() - 1) + "，药房无此药！\r\n";
				}
				if (!CiOrdUtils.isEmpty(stopSale) && !mmcounterror.contains(stopSale)) {
					mmcounterror += mmcounterror + "服务：" + stopSale.substring(0, stopSale.length() - 1) + "，已停开！\r\n";
				}
				if (!CiOrdUtils.isEmpty(nocount) && !mmcounterror.contains(nocount)) {
					mmcounterror += mmcounterror + "服务：" + nocount.substring(0, nocount.length() - 1) + "，库存不足！";
				}
				if (CiOrdUtils.isEmpty(mmcounterror))
					return null;
				return mmcounterror;
			}
		}
		return null;
	}
	/**
	 * key:id_mm+id_dep+wh+id_unit_sale,value是数组:0:物品id_mm，1：库房id_dep_wh，2：
	 * 总量单位id_unit_sale,3:开单总量
	 * 
	 * @param paramsMap
	 * @return
	 * @throws BizException
	 */
	public static Map<String,String> ValidateDrugCountRstMap(Map<String, String[]> paramsMap,Map<String,MaterialStockDTO> materialDoMap) throws BizException {
		List<GetStockReqDTO> reqDtos = new ArrayList<GetStockReqDTO>();
		for (Map.Entry<String, String[]> map : paramsMap.entrySet()) {
			GetStockReqDTO reqDTO = new GetStockReqDTO();
			reqDTO.setId_mm(map.getValue()[0]);
			reqDTO.setId_dep(map.getValue()[1]);
			reqDTO.setReq_unit_id(map.getValue()[2]);
			reqDtos.add(reqDTO);
		}
		Map<String,String> rstMap = new HashMap<String,String>();
		if (reqDtos.size() > 0) {
			IMaterialStockService stoctService = CiOrdAppUtils.getMaterialStockQryService();
			MaterialStockDTO[] stockdto = null;
			stockdto = stoctService.getMaterialStocks(reqDtos.toArray(new GetStockReqDTO[0]));
			if (stockdto != null) {
				for (MaterialStockDTO materialDo : stockdto) {
					if(!materialDoMap.containsKey(materialDo.getId_mm())){
						materialDoMap.put(materialDo.getId_mm(), materialDo);
					}
					String key = getKeyId(materialDo.getId_mm(), materialDo.getId_dep(), materialDo.getReq_unit_id());
					String[] param = paramsMap.get(key);
					FDouble mmcount = materialDo.getQuan_usable();
					
					IDeptRService deptRService = ServiceFinder.find(IDeptRService.class);
					String deptName = deptRService.findById(param[1]).getName();
					
					// 药房无此药的移除
					if (materialDo.getMmstatus() == MaterialStatus.NORELATION && !rstMap.containsValue(param[3])) {
						rstMap.put(key, "服务：" + param[3] + "，药房【" + deptName + "】无此药！\r\n");
					} else if (materialDo.getMmstatus() == MaterialStatus.STOP  && !rstMap.containsValue(param[3])) {
						rstMap.put(key, "服务：" + param[3] + "，已停开！\r\n");
					} else if (mmcount != null && (mmcount.compareTo(new FDouble(0)) == 0
							|| mmcount.compareTo(new FDouble(param[4])) < 0)  && !rstMap.containsValue(param[3])) {
						//0169169: 加顿后的库存不足提示信息，应该把药房名称带出来，要不然很容易理解成：开个长期的都能开，加顿就开不了了
						rstMap.put(key, "服务：" + param[3] + "，" + deptName + "库存不足！\r\n");
					}
				}
			}
		}
		return rstMap;
	}
	/**
	 * 拼接key关键字
	 * 
	 * @param id_mm
	 * @param id_dep_wh
	 * @param id_unit_sale
	 * @return
	 */
	public static String getKeyId(String id_mm, String id_dep_wh, String id_unit_sale) {
		return (id_mm == null ? "" : id_mm) + (id_dep_wh == null ? "" : id_dep_wh)
				+ (id_unit_sale == null ? "" : id_unit_sale);
	}

	/**
	 * 判断两个double类型的数字能不能整除
	 * 
	 * @param fd1
	 * @param fd2
	 * @return
	 */
	public static boolean Divided(FDouble fd1, FDouble fd2) {
		if (fd1 == null || fd2 == null)
			return false;
		String str1 = fd1.toString();
		String str2 = fd2.toString();
		String[] strAr1 = str1.split("\\.");
		if (strAr1.length == 1) {
			strAr1 = new String[] { strAr1[0], "1" };
		}
		strAr1[1] = numBenHandle(strAr1[1]);
		String[] strAr2 = str2.split("\\.");
		if (strAr2.length == 1) {
			strAr2 = new String[] { strAr2[0], "1" };
		}
		strAr2[1] = numBenHandle(strAr2[1]);
		int leng = strAr1[1].length() >= strAr2[1].length() ? strAr1[1].length() : strAr2[1].length();
		if ((int) (fd1.doubleValue() * Math.pow(10, leng)) % (int) (fd2.doubleValue() * Math.pow(10, leng)) == 0) {
			return true;
		}
		return false;
	}

	public static String numBenHandle(String input) {
		if (CiOrdUtils.isEmpty(input))
			return "";
		int iL = input.length();
		String rtnstr = "";
		char[] szInput = input.toCharArray();
		for (int i = iL - 1; i >= 0; i--) {
			if (szInput[i] != '0') {
				rtnstr = input.substring(0, i + 1);
				break;
			}
		}
		return rtnstr;
	}

	public static String[] FMapConvertArray(FMap map) {

		if (map == null)
			return null;
		List<String> mapKeyList = new ArrayList<String>(map.keySet());
		String[] array = new String[mapKeyList.size()];

		return array;
	}

	public static void setorderAggMap(CiEnContextDTO context, CiOrAggAndRelDatum datum) {
		if (orderAggMap == null) {
			orderAggMap = new HashMap();
			orderAggMap.put(context.getId_dep_or() + context.getId_emp_or() + context.getId_pat(), datum);
		} else {
			orderAggMap.put(context.getId_dep_or() + context.getId_emp_or() + context.getId_pat(), datum);
		}
	}

	public static CiOrAggAndRelDatum getorderAggMap(CiEnContextDTO context) {
		if (orderAggMap == null)
			return null;
		return (CiOrAggAndRelDatum) orderAggMap
				.get(context.getId_dep_or() + context.getId_emp_or() + context.getId_pat());
	}

	public static void setTypeMap(Integer EmsType) {
		if (TypeMap == null) {
			TypeMap = new HashMap();
			TypeMap.put("EmsType", EmsType);
		} else {
			TypeMap.put("EmsType", EmsType);
		}
	}

	public static int getTypeMap() {
		if (TypeMap == null)
			return -1;
		return (Integer) TypeMap.get("EmsType");

	}

	/**
	 * 查询患者默认医保计划
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public static String getIdHpDefault(String id_en) throws BizException {
		if (StringUtils.isEmpty(id_en))
			return "";
		String[] id_ens = new String[] { id_en };
		IPpQueService ippQueService = CiOrdAppUtils.getIPpQueService();
		FMap hpIdMap = ippQueService.getHpIdForHpCatalog(id_ens);
		if (hpIdMap != null && hpIdMap.get(id_en) != null)
			return (String) hpIdMap.get(id_en);
		return "";
	}

	/**
	 * 医嘱模板保存医嘱 在院标志 有重复方法。参数不带CiEnContextDTO
	 * 
	 * @return
	 */
	public static FBoolean JudgeFgMpIn(CiEnContextDTO ctx, MedSrvDO medsrv) {

		if (medsrv != null && ctx != null) {
			if (IEnDictCodeConst.SD_DIAGTYPE_HOSPITAL_IN.equals(ctx.getCode_entp())) {
				// 住院
				return FBoolean.TRUE;
			} else if (IEnDictCodeConst.SD_DIAGTYPE_OUTPATIENT.equals(ctx.getCode_entp())) {

				if (medsrv.getSd_srvtp() != null) {
					// 草药
					if (medsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
						return FBoolean.FALSE;
					}
					// 西成药 注射
					if (medsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX)) {
						return FBoolean.TRUE;
					}
					// 非注射
					if (medsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)) {
						return FBoolean.FALSE;
					}
					// 非药品
					if (!medsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
						return FBoolean.TRUE;
					}
				}
			}
		}

		return FBoolean.FALSE;
	}

	/**
	 * 记录删除的日志
	 * 
	 * @param aggdos
	 */
	public static void log(CiorderAggDO[] aggdos) {
		if (CiOrdUtils.isEmpty(aggdos))
			return;
		ICiOrdLogService logService = ServiceFinder.find(ICiOrdLogService.class);
		for (CiorderAggDO aggdo : aggdos) {
			CiOrderDO ord = aggdo.getParentDO();
			if (CiOrdUtils.isEmpty(ord))
				continue;
			StringBuilder sb = new StringBuilder();
			sb.append("医嘱删除记录日志");
			sb.append("-----删除时间:" + new FDateTime().toStdString());
			sb.append("-----操作医生：" + Context.get().getUserId());
			sb.append("-----医嘱:" + ord.getId_or() + "," + ord.getName_or());
			logService.log(sb.toString(), Level.INFO);
		}
	}

	/**
	 * 记录删除的日志
	 * 
	 * @param aggdos
	 */
	public static void log(CiOrderDO[] ords) {
		if (CiOrdUtils.isEmpty(ords))
			return;
		ICiOrdLogService logService = ServiceFinder.find(ICiOrdLogService.class);
		for (CiOrderDO ord : ords) {
			if (CiOrdUtils.isEmpty(ord))
				continue;
			StringBuilder sb = new StringBuilder();
			sb.append("医嘱删除记录日志");
			sb.append("-----删除时间:" + new FDateTime().toStdString());
			sb.append("-----操作医生：" + Context.get().getUserId());
			sb.append("-----医嘱:" + ord.getId_or() + "," + ord.getName_or());
			logService.log(sb.toString(), Level.INFO);
		}
	}

	/**
	 * 临床记录日志公共方法
	 * 
	 * @param log
	 * @param level
	 */
	public static void Log(String log, Level level) {
		ICiOrdLogService logService = ServiceFinder.find(ICiOrdLogService.class);
		logService.log(log, level);
	}

	/**
	 * 住院的台次手术（0401）为True
	 * 
	 * @param code_entp
	 * @param sd_srvtp
	 * @return
	 */
	public static boolean IsIPOperation(String code_entp, String sd_srvtp) {
		if (StringUtils.isEmpty(code_entp) || StringUtils.isEmpty(sd_srvtp)) {
			return false;
		}
		if (code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)
				&& sd_srvtp.equals(IBdSrvDictCodeConst.SD_SRVTP_OP_TAICI)) {
			return true;
		}
		return false;
	}

	/**
	 * 获得开始时间格式化参数
	 * 
	 * @return
	 */
	public static FDateTime getFormatServerDateTime() {
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		FDateTime nowDate = CiOrdAppUtils.getServerDateTime();
		int point;
		try {
			point = ParamsetQryUtil.getParaInt(id_org, ICiOrdCustomSysParamConst.TL_PARAM_TIMEINTEGRATIONFORMAT);
		} catch (BizException e) {
			point = 99;
		}
		if (point == 99) {// 不取整模式
			return nowDate;
		}
		int minute = nowDate.getMinute();
		// 如果为0（整点处理）,使用60作为处理
		if (point == 0) {
			if (minute != 0) {
				return nowDate.addSeconds((-minute) * 60).addSeconds(-nowDate.getSecond());
			} else {
				return nowDate;
			}

		} else {
			if (minute == 0) {
				return nowDate;
			} else {
				int rstMinute = (minute / point) * point;
				return nowDate.addSeconds((rstMinute - minute) * 60).addSeconds(-nowDate.getSecond());
			}
		}

	}

	public static FDateTime getCompareFormatServerDateTime(String id_ent) throws BizException {
		FDateTime nowDate = CiOrdAppUtils.getServerDateTime();
		if (id_ent == null || "".equals(id_ent)) {
			return nowDate;
		}
		FDateTime date = getFormatServerDateTime();
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		IpBasicDTO ipBasicInfo = service.getIpBasicInfo(id_ent);
		FDateTime dt_acpt = ipBasicInfo.getDt_acpt();
		if (dt_acpt.compareTo(date) >= 0) {
			return dt_acpt;
		}
		return date;
	}
	
	/**
	 * 查询主诉现病史
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public static String DiseaseDescription(String id_ent) throws BizException {
		FMap2 fmap2 = new FMap2();
		Object[] params = new Object[]{id_ent,fmap2};
		fireBDEvent(BaseDiseaseDesListener.DiseaseDesListenerSourceId, IEventType.TYPE_UPDATE_AFTER, params);
		if(fmap2.containsKey(BaseDiseaseDesListener.DiseaseDesListenerSourceId)){
			return (String)fmap2.get(BaseDiseaseDesListener.DiseaseDesListenerSourceId);
		}
		return null;
	}

	public static String IsNull(String limitInfo) {
		if (limitInfo == null)
			return "";
		return limitInfo;
	}

	/**
	 * 根据就诊类型获取当前工程标识
	 * 
	 * @param 就诊类型
	 * @return
	 */
	public static String getProjectIdentity(String code_entp) {
		if ("00".equals(code_entp)) {
			return PROJECT_GJ;
		} else {
			return PROJECT_TL;
		}
	}

	/**
	 * 获取工程标识
	 * 
	 * @return 当前工程标识
	 */
	public static String getProjectIdentity() {

		return "TL";
	}

	/**
	 * 字符串去重
	 * 
	 * @param strs
	 * @return
	 */
	public static String[] removeRepeatString(String[] strs) {
		if (CiOrdUtils.isEmpty(strs)) {
			return strs;
		}
		List<String> strList = new ArrayList<String>();
		for (String str : strs) {
			if (strList.contains(str)) {
				continue;
			}
			strList.add(str);
		}
		return strList.toArray(new String[0]);
	}

	/**
	 * 
	 * @param preStr
	 *            前缀
	 * @param code_entp
	 *            就诊类型
	 * @return 可使用标识
	 */
	public static String getFgUseType(String preStr, String code_entp) {

		String value = "";
		switch (code_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			value = "op";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
			value = "er2";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			value = "ip";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			value = "fm";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			value = "pe";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
			value = "er";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
			value = "er1";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE:
		    return "fg_use_pip";
		}

		return preStr + value;
	}

	/**
	 * 获得查询条件sql串（不含in、(、)）
	 * 
	 * @param idsStr
	 * @return
	 */
	public static String getSqlNotInStrsWithOutIn(String[] idors) {
		// 有效性判断
		if (isEmpty(idors))
			return null;
		String instr = "";
		for (String id_or : idors) {
			instr += SQUOTE_MARK_STR + id_or + SQUOTE_MARK_STR + COMMA_STR;
		}
		return instr.substring(0, instr.lastIndexOf(COMMA_STR));
	}

	/**
	 * 设置医嘱状态
	 * 
	 * @param classzArr
	 * @throws BizException
	 */
	public static <T extends BaseDTO> void GetOrdState(T[] classzArr) throws BizException {
		for (T t : classzArr) {
			String sd_su_or = "", sd_su_mp = "", code_entp = "";
			FBoolean fg_stop = FBoolean.FALSE, fg_pres_out = FBoolean.FALSE;

			Object orV = t.getAttrVal(CiOrderDO.SD_SU_OR);
			if (!CiOrdUtils.isEmpty(orV)) {
				sd_su_or = (String) orV;
			}
			Object mpV = t.getAttrVal(CiOrderDO.SD_SU_MP);
			if (!CiOrdUtils.isEmpty(mpV)) {
				sd_su_mp = (String) mpV;
			}
			Object stopV = t.getAttrVal(CiOrderDO.FG_STOP);
			if (!CiOrdUtils.isEmpty(stopV)) {
				fg_stop = (FBoolean) stopV;
			}
			Object codeEntpV = t.getAttrVal(CiOrderDO.CODE_ENTP);
			if (!CiOrdUtils.isEmpty(codeEntpV)) {
				code_entp = (String) codeEntpV;
			}
			Object presOutV = t.getAttrVal(CiOrderDO.FG_PRES_OUTP);
			if (!CiOrdUtils.isEmpty(presOutV)) {
				fg_pres_out = (FBoolean) presOutV;
			}

			if (sd_su_or == ICiDictCodeConst.SD_SU_OPEN) {
				t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.OPEN.toString());
			} else if (sd_su_or == ICiDictCodeConst.SD_SU_SIGN) {
				t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.SIGN.toString());
				if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp) 
						|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)
						|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)) {

					if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_PERFORMED) {
						if (fg_stop != null && fg_stop.booleanValue() == false) {
							t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.EXEC.toString());
						} else if (fg_stop != null && fg_stop.booleanValue() == true) {
							t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.EXEC_PRESTOP.toString());
						} else {
							t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.UNKNOW.toString());
						}
					}
				}
			} else if (sd_su_or == ICiDictCodeConst.SD_SU_CHECKTHROUGH) {
				if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_NONE) {
					if ((fg_stop != null && fg_stop.booleanValue() == false) || fg_pres_out.booleanValue() == true) {// 出院带药不需要预停操作
						t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.CONFIRM.toString());
					} else if (fg_stop != null && fg_stop.booleanValue() == true) {
						t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.CONFRIM_PRESTOP.toString());
					} else {
						t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.UNKNOW.toString());
					}

				} else if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_PERFORMED) {
					if (fg_stop != null && fg_stop.booleanValue() == false) {
						t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.EXEC.toString());
					} else if (fg_stop != null && fg_stop.booleanValue() == true) {
						t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.EXEC_PRESTOP.toString());
					} else {
						t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.UNKNOW.toString());
					}
				} else {
					t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.UNKNOW.toString());
				}

			} else if (sd_su_or == ICiDictCodeConst.SD_SU_CHECKSTOP) {
				if (fg_stop != null && fg_stop.booleanValue() == true) {
					if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_NONE) {
						t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.CONFIRM_STOP.toString());
					} else if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_PERFORMED) {
						t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.EXEC_STOP.toString());

					} else {
						t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.UNKNOW.toString());
					}
				} else {
					t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.UNKNOW.toString());
				}
			} else if (sd_su_or == ICiDictCodeConst.SD_SU_FINISH) {
				if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_EXEOK) {
					t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.OVER.toString());
				} else if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_EXECANC) {
					t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.CANCEL.toString());
				} else if (sd_su_mp == ICiDictCodeConst.SD_SU_MP_CANCEL) {
					t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.NOTEXEC.toString());
				} else {
					t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.UNKNOW.toString());
				}
			} else if (sd_su_or == ICiDictCodeConst.SD_SU_DOCTORCANCEL) {
				t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.OBSOLETE.toString());
			} else if (sd_su_or == ICiDictCodeConst.SD_SU_CHECKCANCEL) {
				t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.CANCELLED.toString());
			} else {
				t.setAttrVal(CiOrderDO.ORD_COLLIGATE, OrdPicStatusIndex.UNKNOW.toString());
			}
		}
	}

	/**
	 * 美康返回值处理
	 * 
	 * @param list
	 * @return
	 */
	public static String MKQryInfoTransToXML(List<Map<String, Object>> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("<MESSAGE>");
		sb.append("<ReturnCode>" + (list == null ? 0 : list.size()) + "</ReturnCode>");
		sb.append("<ErrorMessage></ErrorMessage>");
		sb.append("<Data>");
		sb.append("<Rows>");
		if (!isEmpty(list)) {
			for (Map<String, Object> map : list) {
				sb.append("<Row>");
				for (String key : map.keySet()) {
					
					sb.append("<" + key + ">");
					if (map.get(key) == null) {
						sb.append("");
					}else {
						String value=map.get(key).toString();
						if (value.contains("<")) {
							value=value.replace("<", "&lt;");
						}else if (value.contains(">")) {
							value=value.replace(">", "&gt;");
						}else if (value.contains("&")) {
							value=value.replace("&", "&amp;");
						}else if (value.contains("'")) {
							value=value.replace("'", "&apos;");
						}else if (value.contains("\"")) {
							value=value.replace("\"", "&quot;");
						}
						sb.append(value);
						
					}
					
					sb.append("</" + key + ">");			
				}
				sb.append("</Row>");
			}
		}
		sb.append("</Rows>");
		sb.append("</Data>");
		sb.append("</MESSAGE>");
		logger.error("合理用药临床药学返回xml："+sb.toString());
		return sb.toString();
		
	}
	
	
	
	/**
	 * 美康返回值处理(分页)
	 * 
	 * @param list,totalCount,totalPage
	 * @return
	 */                  
	public static String MKQryInfoTransToXML1(List<Map<String, Object>> list,int totalCount,int totalPage) {
		StringBuilder sb = new StringBuilder();
		sb.append("<MESSAGE>");
		sb.append("<ReturnTotalCode>" +totalCount + "</ReturnTotalCode>");
		sb.append("<ReturnTotalPage>" +totalPage +  "</ReturnTotalPage>");
		//sb.append("<ReturnCode>" + (list == null ? 0 : list.size()) + "</ReturnCode>");
		sb.append("<ErrorMessage></ErrorMessage>");
		sb.append("<Data>");
		sb.append("<Rows>");
		if (!isEmpty(list)) {
			for (Map<String, Object> map : list) {
				sb.append("<Row>");
					for (String key : map.keySet()) {
					
					sb.append("<" + key + ">");
					if (map.get(key) == null) {
						sb.append("");
					}else {
						String value=map.get(key).toString();
						if (value.contains("<")) {
							value=value.replace("<", "&lt;");
						}else if (value.contains(">")) {
							value=value.replace(">", "&gt;");
						}else if (value.contains("&")) {
							value=value.replace("&", "&amp;");
						}else if (value.contains("'")) {
							value=value.replace("'", "&apos;");
						}else if (value.contains("\"")) {
							value=value.replace("\"", "&quot;");
						}
						sb.append(value);
						
					}
					
					sb.append("</" + key + ">");			
				}
					sb.append("</Row>");
			}
		}
		sb.append("</Rows>");
		sb.append("</Data>");
		sb.append("</MESSAGE>");
		return sb.toString();
	}
	
	/**
	 * 美康返回值处理(分页)
	 * 
	 * @param list,totalCount,totalPage
	 * @return
	 */
	public static String MKQryInfoTransToXML1(String orgcode,int totalCount) {
		StringBuilder sb = new StringBuilder();
		sb.append("<MESSAGE>");
		sb.append("<ORGCODE>" +orgcode + "</ORGCODE>");
		sb.append("<ReturnTotalCode>" +totalCount + "</ReturnTotalCode>");
		sb.append("</MESSAGE>");
		return sb.toString();
	}

	/**
	 * 使用sql语句查询，返回List<Map<String,Object>>
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws DAException
	 */
	public static List<Map<String, Object>> DAFacadeQry(String sql, SqlParam param) throws DAException {
		if (param == null) {
			param = new SqlParam();
		}
		if (CiOrdUtils.isEmpty(sql)) {
			return null;
		}
		DAFacade dao = new DAFacade();
		List<Map<String, Object>> rs = (List<Map<String, Object>>) dao.execQuery(sql, param, new MapListHandler());
		return rs;
	}

	/**
	 * 获得集成平台事件类型常量串 （门诊）撤销
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static String getIeOpCancEventTypeStr(String sd_srvtp) {
		if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
			if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				return ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG_HERB;
			} else {
				return ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG_WC;
			}
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_RIS;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_LIS;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_OP)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_CANC_STOP;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_CON;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_PBT;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_UBT;
		} else if (isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {
			return ICiIEEventConst.EVENT_IE_CIOR_OP_TREAT;
		}

		return ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OTH;
	}

	/**
	 * 获得查询条件sql串（不含in、(、)）
	 * 
	 * @param idsStr
	 * @return
	 */
	public static String getSqlNotInStrsWithOutIn(String idsStr) {
		// 有效性判断
		if (isEmpty(idsStr))
			return null;

		String instr = idsStr.replaceAll(COMMA_STR, SQUOTE_MARK_STR + COMMA_STR + SQUOTE_MARK_STR);

		// 返回置处理
		return SQUOTE_MARK_STR + instr + SQUOTE_MARK_STR;
	}

	/**
	 * 获得查询条件sql串不 含in 或 =
	 * 
	 * @param idsStr
	 * @return
	 */
	public static String getSqlNotInOrEqualStrs(String idsStr) {
		// 有效性判断
		if (isEmpty(idsStr))
			return null;

		if (idsStr.indexOf(",") == -1)
			return idsStr;
		return CiOrdUtils.getSqlNotInStrsWithOutIn(idsStr);
	}

	/**
	 * 获得sql串对应的MapList
	 * 
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	public static List<Map<String, Object>> getRsMapList(String sqlStr, SqlParam param) throws BizException {
		try {
			return (List<Map<String, Object>>) (new DAFacade().execQuery(sqlStr, param, new MapListHandler()));
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
	}

	/**
	 * 设置医嘱表中的保内和保外标志（fg_orhp）,ci_or_srv中有一个是保内的，则医嘱为保内
	 * 
	 * @param aggs
	 */
	public static void SetFgOrHpOfCiOrder(CiorderAggDO[] aggs) {
		outer: for (CiorderAggDO agg : aggs) {
			for (OrdSrvDO ordSrvDO : agg.getOrdSrvDO()) {
				if (ordSrvDO.getFg_selfpay() != null && !ordSrvDO.getFg_selfpay().booleanValue()) {
					agg.getParentDO().setFg_orhp(FBoolean.TRUE);
					continue outer;
				}
			}
			agg.getParentDO().setFg_orhp(FBoolean.FALSE);
		}
	}

	/**
	 * 处理金额多余的0
	 * 
	 * @param number
	 * @return
	 */
	public static String getPrettyNumber(String number) {
		return BigDecimal.valueOf(Double.parseDouble(number)).stripTrailingZeros().toPlainString();
	}

	/**
	 * 计算后四舍五入
	 * 
	 * @param retentionNumber
	 *            保留小数
	 * @param pri
	 *            价格
	 * @return
	 */
	public static FDouble CalculationPriRounding(int retentionNumber, FDouble pri) {
		if (pri != null && retentionNumber > 0) {
			return pri.setScale(retentionNumber, BigDecimal.ROUND_HALF_UP);
		} else {
			return pri;
		}
	}

	/**
	 * 获取医嘱中特殊级抗菌药
	 * 
	 * @param idors
	 *            医嘱iDs
	 * @return ci_order.id_or,ci_order.code_or,bd_srv_drug.name
	 * @throws DAException
	 */
	public static CiOrderDO[] getBdSrvDrugByIdors(String[] idors) throws DAException {
		if (idors != null && idors.length > 0) {
			// b.sd_anti='3' 查询特殊级抗菌药
			String queryStr = "select s.id_or,c.code_or,s.name name_or from ci_order c"
					+ " left join ci_or_srv s on c.id_or=s.id_or" + " left join bd_srv_drug b on s.id_srv = b.id_srv"
					+ " where b.sd_anti='3' and c.id_or in(";
			String whereStr = "";
			for (int i = 0; i < idors.length; i++) {
				whereStr += "'" + idors[i] + "',";
			}
			queryStr += whereStr.substring(0, whereStr.length() - 1) + ")";
			DAFacade df = new DAFacade();
			List<CiOrderDO> result = (List<CiOrderDO>) df.execQuery(queryStr, new BeanListHandler(CiOrderDO.class));
			return result.toArray(new CiOrderDO[result.size()]);
		}
		return null;
	}

	/**
	 * 删除手术申请单
	 * 
	 * @param id_ors
	 * @throws BizException
	 */
	public static void clearSugAgainData(String[] id_ors) throws BizException {
		ICiorappsurgeryMDORService sugService = ServiceFinder.find(ICiorappsurgeryMDORService.class);
		OrdApOpDO[] appsugs = sugService.findByAttrValStrings(OrdApOpDO.ID_OR, id_ors);
		if (appsugs == null || appsugs.length == 0) {
			return;
		}
		List<String> id_apops = new ArrayList<String>();
		// 手术id
		for (OrdApOpDO apOp : appsugs) {
			id_apops.add(apOp.getId_apop());
		}
		IOrdApOpAgainDOCudService againService = ServiceFinder.find(IOrdApOpAgainDOCudService.class);
		IOrdApOpAgainDORService againRService = ServiceFinder.find(IOrdApOpAgainDORService.class);
		OrdApOpAgainDO[] againDOs = againRService.findByAttrValStrings(OrdApOpAgainDO.ID_APOP,
				id_apops.toArray(new String[0]));
		if (againDOs != null && againDOs.length > 0) {
			againService.delete(againDOs);
		}
	}

	/**
	 * 判断医嘱是否已记账
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public static boolean ordIsHasBl(String id_or) throws BizException {
		IOrdSrvDORService srvRService = ServiceFinder.find(IOrdSrvDORService.class);
		OrdSrvDO[] ordSrvDOs = srvRService.findByAttrValString(OrdSrvDO.ID_OR, id_or);
		boolean isHasBl = false;
		for (OrdSrvDO ordSrvDO : ordSrvDOs) {
			if ("1".equals(ordSrvDO.getSd_su_bl())) {
				isHasBl = true;
				break;
			}
		}
		return isHasBl;
	}

	public static FMap getSugDiagByIdapops(String[] id_apops) throws BizException {
		FMap sugDiagMap = new FMap();
		ICiorappsurgeryMDORService apsugService = ServiceFinder.find(ICiorappsurgeryMDORService.class);
		OrdApOpDO[] apops = apsugService.findByIds(id_apops, FBoolean.FALSE);
		if (apops != null && apops.length > 0) {
			for (OrdApOpDO apop : apops) {
				if (StringUtils.isEmpty(apop.getStr_name_di()) && !StringUtils.isEmpty(apop.getId_di())) {
					DiagDefDO diagDefDO = getDiagDefDO(apop.getId_di());
					if (diagDefDO != null && StringUtils.isNotEmpty(diagDefDO.getName())) {
						sugDiagMap.put(apop.getId_apop(), diagDefDO.getName());// 诊断名称
					}
				} else {
					if (StringUtils.isNotEmpty(apop.getStr_name_di())) {
						sugDiagMap.put(apop.getId_apop(), apop.getStr_name_di());// 诊断名称
					}
				}
			}
		}
		return sugDiagMap;
	}

	/**
	 * 查询诊断
	 * 
	 * @param id_didef
	 * @return
	 * @throws BizException
	 */
	public static DiagDefDO getDiagDefDO(String id_didef) throws BizException {
		IDiagdefMDORService diagService = ServiceFinder.find(IDiagdefMDORService.class);
		DiagDefDO diagDefDO = diagService.findById(id_didef);
		return diagDefDO;
	}

	/**
	 * 
	 * @param id_ent
	 * @param id_dep_or
	 * @param sd_orsrvfun
	 * @return
	 */
	public static String getIdDepNur(String id_ent) throws BizException {
		String sql = " select id_dep_nur from en_ent where id_ent='" + id_ent + "'";
		PatiVisitDO pativaisitDO = (PatiVisitDO) new DAFacade().execQuery(sql, new BeanHandler(PatiVisitDO.class));
		if (pativaisitDO != null) {
			return pativaisitDO.getId_dep_nur();
		}
		return null;
	}

	/**
	 * 排序
	 * 
	 * @param arrays
	 * @param field
	 * @param sort
	 * @return
	 */
	public static <T> T[] Sort(T[] arrays, final String field, final SortEnum sort) {
		List<T> list = (List<T>) Arrays.asList(arrays);
		Collections.sort(list, new Comparator<T>() {
			public int compare(T o1, T o2) {
				if (o1 == null || o2 == null) {
					return -1;
				}
				if (((BaseDO) o1).getAttrVal(field) == null || ((BaseDO) o2).getAttrVal(field) == null) {
					return -1;
				}
				if ((Integer) ((BaseDO) o1).getAttrVal(field) > (Integer) ((BaseDO) o2).getAttrVal(field)) {
					if (sort == SortEnum.ASC) {
						return 1;
					} else {
						return -1;
					}
				} else if (((BaseDO) o1).getAttrVal(field) == ((BaseDO) o2).getAttrVal(field)) {
					return 0;
				} else {
					if (sort == SortEnum.ASC) {
						return -1;
					} else {
						return 1;
					}
				}

			}
		});
		int i = 0;
		for (T t : list) {
			arrays[i] = t;
			i++;
		}
		return arrays;
	}

	/**
	 * 皮试逻辑，0是旧，1是新
	 * 
	 * @param id_org
	 * @return
	 */
	public static String GetDefaultSkinModel(String id_org) {

		try {
			String model = ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_SkinTestModel);
			if (StringUtils.isEmpty(model)) {
				return "0";
			} else {
				return model;
			}
		} catch (BizException e) {
			return "0";
		}
	}

	/**
	 * 获得当天所在的周天数编码
	 * 
	 * @param fdt
	 * @return
	 */
	public static String getDayOfWeek(FDateTime fdt) {
		if (fdt == null) {
			return null;
		}
		int week = fdt.getWeek();
		switch (week) {
		case 1:
			return IBdSrvDictCodeConst.SD_WEEK_MONDAY;
		case 2:
			return IBdSrvDictCodeConst.SD_WEEK_TUESDAY;
		case 3:
			return IBdSrvDictCodeConst.SD_WEEK_WEDNESDAY;
		case 4:
			return IBdSrvDictCodeConst.SD_WEEK_THURSDAY;
		case 5:
			return IBdSrvDictCodeConst.SD_WEEK_FRIDAY;
		case 6:
			return IBdSrvDictCodeConst.SD_WEEK_SATURDAY;
		case 7:
			return IBdSrvDictCodeConst.SD_WEEK_SUNDAY;
		default:
			return null;
		}
	}

	/**
	 * 判断字符串是否为数字
	 * 
	 * @param message
	 * @return
	 */
	public static boolean IsNumberic(String message) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(message).matches();
	}

	/**
	 * 生成医嘱编码
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String CreateCodeOr() throws BizException {
		return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
	}

	/**
	 * 当前就诊下最新的医嘱序号
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public static Integer GetNewCiOrderSortno(String id_en) throws BizException {
		String qryMaxSortno = "select max(nvl(sortno,0)) from ci_order where id_en = '" + id_en + "'";
		Integer result = (Integer) new DAFacade().execQuery(qryMaxSortno, new ColumnHandler());
		if (result == null) {
			result = 0;
		}
		return ++result;
	}

	/**
	 * 判断两个数能不能除尽
	 * 
	 * @param amount
	 * @param count
	 * @return
	 */
	public static boolean DivideUp(int amount, int count) {
		if (amount % count == 0) {
			return true;// 能被除尽
		} else {
			int m = count;
			while (m % 2 == 0) {
				m = m / 2;// 当模2不=0时，去尝试对5取模
			}
			while (m % 5 == 0) {
				m = m / 5;// 当模5不=0时，则将m让除数取模
			}
			if (amount % m != 0) {
				return false;// 不能除尽，如果取模不为0，则表示有2和5以外的因子，数学原理也是别人告诉我的：除数能被分解成N个2或N个5或者N2N5组合，则表示可以除尽
			}
		}
		return true;
	}

	/**
	 * 拼接成in查询的入参，不带前后''
	 * 
	 * @param ids
	 * @return
	 */
	public static String ConcatInSqlMark(List<String> ids) {
		if (ids == null || ids.size() == 0) {
			return "";
		}
		String tmplIdStr = new String();
		for (String id : ids) {
			tmplIdStr += CiOrdUtils.SQUOTE_MARK_STR + id + CiOrdUtils.SQUOTE_MARK_STR + CiOrdUtils.COMMA_STR;
		}
		if (tmplIdStr.length() > 0) {
			tmplIdStr = tmplIdStr.substring(1, tmplIdStr.length() - 2);
			return tmplIdStr;
		}
		return "";
	}

	/**
	 * 拼接成in查询的入参，不带前后''
	 * 
	 * @param ids
	 * @return
	 */
	public static String ConcatInSqlMark(String[] ids) {
		if (ids == null || ids.length == 0) {
			return "";
		}
		String tmplIdStr = new String();
		for (String id : ids) {
			tmplIdStr += CiOrdUtils.SQUOTE_MARK_STR + id + CiOrdUtils.SQUOTE_MARK_STR + CiOrdUtils.COMMA_STR;
		}
		if (tmplIdStr.length() > 0) {
			tmplIdStr = tmplIdStr.substring(1, tmplIdStr.length() - 2);
			return tmplIdStr;
		}
		return "";
	}

	/**
	 * 删除容器费的校验,考虑检验项目全部退费的情况
	 * 
	 * @param lstIdors
	 * @throws BizException
	 */
	public static void DiriveDataDelValide(List<String> lstIdors) throws BizException {
		if (lstIdors == null || lstIdors.size() == 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select c.sd_su_bl,c.name_or from CI_APP_DIRIVE_OR_REL rel ");
		sb.append("inner join ci_app_lis_or lisor on lisor.id_ciapplissheet=rel.id_app ");
		sb.append("inner join ci_order c on c.id_or = lisor.id_or ");
		sb.append("inner join ci_order crel on crel.id_or=rel.id_relor ");
		sb.append("where c.sd_su_bl<>'2' and crel.sd_su_bl<>'2' and c.fg_sign='Y' and c.fg_canc='N' and rel.id_relor in ('"
				+ CiOrdUtils.ConcatInSqlMark(lstIdors) + "') ");
		SqlParam param = new SqlParam();
		List<CiOrderDO> list = (List<CiOrderDO>) new DAFacade().execQuery(sb.toString(),
				new BeanListHandler(CiOrderDO.class));
		if (list != null && list.size() > 0) {
			//0173128: 门急诊医生站：开立血常规签署后带出两个诊疗项目、将三个医嘱全部勾选后处置撤回、处置删除报错。
			throw new BizException("检验医嘱不允许和关联生成的采集费、标本费医嘱同时撤回，请单独勾选检验医嘱");
//			throw new BizException("存在对应的检验医嘱，不允许撤回");
		}
	}

	/**
	 * 验证门诊住院的毒麻审核
	 * 
	 * @param id_org
	 *            所属组织
	 * @param code
	 *            00代表门诊 10 代表住院
	 * @return
	 */
	public static FBoolean Poisinfocheck(String id_org, String code) {

		if ("00".equals(code)) {// 门诊

			try {
				String isNeedToValidatePoisInfo = ParamsetQryUtil.getParaString(id_org,
						ICiOrdNSysParamConst.SYS_PARAM_SRVPOIS_CHECK);
				if (!StringUtils.isEmpty(isNeedToValidatePoisInfo)) {
					if ("1".equals(isNeedToValidatePoisInfo.substring(0, 1))) {
						return FBoolean.TRUE;
					} else {
						return FBoolean.FALSE;
					}
				}
			} catch (BizException e) {
				return FBoolean.FALSE;
			}

		} else {// 住院
			try {
				String isNeedToValidatePoisInfo = ParamsetQryUtil.getParaString(id_org,
						ICiOrdNSysParamConst.SYS_PARAM_SRVPOIS_CHECK);
				if (!StringUtils.isEmpty(isNeedToValidatePoisInfo)) {
					isNeedToValidatePoisInfo = isNeedToValidatePoisInfo.substring(isNeedToValidatePoisInfo.length() - 1,
							isNeedToValidatePoisInfo.length());
					if ("1".equals(isNeedToValidatePoisInfo)) {
						return FBoolean.TRUE;
					} else {
						return FBoolean.FALSE;
					}
				}
			} catch (BizException e) {
				return FBoolean.FALSE;
			}
		}
		return FBoolean.FALSE;

	}
	/**
	 * 查询服务
	 * @param id_srvs
	 * @return
	 * @throws BizException
	 */
	public static MedSrvDO[] getMedSrvDOs(String[] id_srvs) throws BizException {
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medSrvDOs = service.findByIds(id_srvs, FBoolean.FALSE);
		return medSrvDOs;
	}
	/**
	 * 获得匹配的申请单
	 * 
	 * @param id_srv
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	public static SrvMatchEmsRstDTO GetMedSrvMatchEms(CiEnContextDTO ctx,String id_srv, String sd_srvtp) throws BizException {
		IEmsManagementService emsManagementService = ServiceFinder.find(IEmsManagementService.class);
		
		SrvMatchEmsParamDTO srvMatchEmsParamDTO = new SrvMatchEmsParamDTO();
		srvMatchEmsParamDTO.setId_srv(id_srv);
		srvMatchEmsParamDTO.setCode_entp(ctx.getCode_entp());
		srvMatchEmsParamDTO.setId_emp(ctx.getId_emp_or());
		srvMatchEmsParamDTO.setId_dept(ctx.getId_dep_or());
		srvMatchEmsParamDTO.setId_org(ctx.getId_org());
		srvMatchEmsParamDTO.setId_grp(ctx.getId_grp());
		srvMatchEmsParamDTO.setSd_srvtp(sd_srvtp);
		srvMatchEmsParamDTO.setDt_or(CiOrdAppUtils.getServerDateTime());
		srvMatchEmsParamDTO.setEmsappmode(ctx.getEmsappmode());
		
		// 调用匹配医疗单算法服务
		FMap rstMap = emsManagementService.medSrvMatchEms(
				new SrvMatchEmsParamDTO[] { srvMatchEmsParamDTO });

		// 进行匹配结果有效性验证
		if (null != rstMap && rstMap.size() > 0) {

			// 根据服务id获取医疗单匹配信息
			SrvMatchEmsRstDTO rstMatchInfo = (SrvMatchEmsRstDTO) rstMap.get(id_srv);
			return rstMatchInfo;
		}
		return null;
	}
	/**
	 * 获取会诊申请单号
	 * @return
	 * @throws BizException
	 */
	public static String GetConsApplyNo() throws BizException {
		String codeor = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(OrdApConsDO.class.getName());
		return codeor;
	}
	/**
	 * 草药医嘱备注信息拼接
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public static String genOrdDes(BaseDO dto) throws BizException {
		String ss="共{Orders}剂，每日1剂，{Name_boil}至150-200ml，{Name_freq}，{Name_route}";
		String config=ParamsetQryUtil.getParaString(Context.get().getOrgId(),"CIOR0510");
		if(config!=null&&config.trim().length()>0) {
			ss=config;
		}
		Pattern p=Pattern.compile("(\\{[^\\}]*\\})");
		Matcher m=p.matcher(ss);
		while(m.find()) {
			String val=m.group();
			int index1=val.indexOf("{");
			int index2=val.lastIndexOf("}");
			String name=val.substring(index1+1, index2).trim();
			Object o=dto.getAttrVal(name);
			String vv="";
			if(o!=null) {
				if(o instanceof FDouble) {
				  FDouble a=(FDouble)o;
				  BigDecimal f=new BigDecimal(a.toString());
				  vv=f.stripTrailingZeros().toPlainString();
				}else {
					vv=o.toString();
				}			
			}
			ss=ss.replace(val, vv);
		}
		return ss;
	}
	/**
	 * 加急标志赋值
	 * @param id_srv
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	public static FBoolean getFgUrgent(String id_srv,String code_entp)throws BizException{
		if(StringUtils.isEmpty(id_srv)&&StringUtils.isEmpty(code_entp))return null;
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO srvDO = medsrvMDORService.findById(id_srv);
		if(null!=srvDO){
			if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)){//住院医生站
				if(null!=srvDO.getFg_urgent_ip()&&FBoolean.TRUE.equals(srvDO.getFg_urgent_ip())){//允许加急
					if(null!=srvDO.getFg_urgent_def_ip()&&FBoolean.TRUE.equals(srvDO.getFg_urgent_def_ip())){//默认加急
						return FBoolean.TRUE;
					}
				}
			}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)){//急诊留观医生站
				if(null!=srvDO.getFg_urgent_er2()&&FBoolean.TRUE.equals(srvDO.getFg_urgent_er2())){//允许加急
					if(null!=srvDO.getFg_urgent_def_er2()&&FBoolean.TRUE.equals(srvDO.getFg_urgent_def_er2())){//默认加急
						return FBoolean.TRUE;
					}
				}
			}else if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)){//门急诊医生站
				if(null!=srvDO.getFg_urgent_op()&&FBoolean.TRUE.equals(srvDO.getFg_urgent_op())){//允许加急
					if(null!=srvDO.getFg_urgent_def_op()&&FBoolean.TRUE.equals(srvDO.getFg_urgent_def_op())){//默认加急
						return FBoolean.TRUE;
					}
				}
			}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)){//急诊流水医生站
				if(null!=srvDO.getFg_urgent_er()&&FBoolean.TRUE.equals(srvDO.getFg_urgent_er())){//允许加急
					if(null!=srvDO.getFg_urgent_def_er()&&FBoolean.TRUE.equals(srvDO.getFg_urgent_def_er())){//默认加急
						return FBoolean.TRUE;
					}
				}
			}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)){
				if(null!=srvDO.getFg_urgent_er1()&&FBoolean.TRUE.equals(srvDO.getFg_urgent_er1())){//允许加急
					if(null!=srvDO.getFg_urgent_def_er1()&&FBoolean.TRUE.equals(srvDO.getFg_urgent_def_er1())){//默认加急
						return FBoolean.TRUE;
					}
				}
			}
		}
		return FBoolean.FALSE;
	}
	/**
	 * 草药的默认剂数
	 * @return
	 */
	public static Integer getDefaultOrders(){
		try {
			Integer orders = ParamUtils.GetOrgParamIntegerValue(ICiOrdCustomSysParamConst.LL_PARAM_HERB_EFAULT_ORDERS);
			if(orders == null){
				return 1;
			}else{
				return orders;
			}
		} catch (BizException e) {
			return 1;
		}
	} 
	
	/**
	 * 获取关联服务执行流向模式
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public static String getIdDepMp(UsageRelFeeSrvDO usgdo,CiEnContextDTO ctx,ExeWhDeptDTO exeWhDeptDTO,CiOrderDO ordo)throws BizException{
		// 入参校验
		if (CiOrdUtils.isEmpty(usgdo.getSd_mpdepcalmd_usg()) || ctx == null) {
			return !CiOrdUtils.isEmpty(exeWhDeptDTO.getId_dep_mp()) ? exeWhDeptDTO.getId_dep_mp() : null;
		}
		
		if (IBdFcDictCodeConst.SD_MPDEPCALMD_USG_ORDFOLLOW.equals(usgdo.getSd_mpdepcalmd_usg())) {// 01医嘱跟随
			return ordo.getId_dep_mp();
		} else if (IBdFcDictCodeConst.SD_MPDEPCALMD_USG_FLOWPATTERN.equals(usgdo.getSd_mpdepcalmd_usg())) {// 02流向模式
			return exeWhDeptDTO.getId_dep_mp();
		} else if (IBdFcDictCodeConst.SD_MPDEPCALMD_USG_DEPPHY.equals(usgdo.getSd_mpdepcalmd_usg())) {// 03就诊科室
			if (!CiOrdUtils.isEmpty(ctx.getId_dep_en())) {
				return ctx.getId_dep_en();
			}
		} else if (IBdFcDictCodeConst.SD_MPDEPCALMD_USG_DEPNUR.equals(usgdo.getSd_mpdepcalmd_usg())) {// 04就诊病区
			if (!CiOrdUtils.isEmpty(ctx.getId_dep_ns())
					&& (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(ordo.getCode_entp())
							|| IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ordo.getCode_entp()))) {
				return ctx.getId_dep_ns();
			}
		} else if (IBdFcDictCodeConst.SD_MPDEPCALMD_USG_OPENDEP.equals(usgdo.getSd_mpdepcalmd_usg())) {// 05开单科室
			if (!CiOrdUtils.isEmpty(ctx.getId_dep_or())) {
				return ctx.getId_dep_or();
			}
		}
		return !CiOrdUtils.isEmpty(exeWhDeptDTO.getId_dep_mp()) ? exeWhDeptDTO.getId_dep_mp() : null;
	}
}
