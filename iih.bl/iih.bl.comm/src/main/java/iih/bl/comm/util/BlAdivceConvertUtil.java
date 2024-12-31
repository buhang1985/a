package iih.bl.comm.util;

import java.math.BigDecimal;

import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.orgfw.org.d.OrgDO;

/**
 * 费用通知工具类
 * 
 * @author zhangxin
 * @date 2019年11月7日
 */
public class BlAdivceConvertUtil {
	/**
	 * 获取门诊收付款实际金额
	 * 
	 * @param blpayItmPatOepDos
	 * @return
	 */
	public static FDouble getOepPayRealyAmt(BlPayItmPatOepDO[] blpayItmPatOepDos, int eu_direct) {
		FDouble amt = FDouble.ZERO_DBL;
		for (BlPayItmPatOepDO blpayItmPatOepDo : blpayItmPatOepDos) {
			if (FBoolean.TRUE.equals(blpayItmPatOepDo.getFg_realpay())
					&& blpayItmPatOepDo.getEu_direct().equals(eu_direct)) {
				amt = amt.add(blpayItmPatOepDo.getAmt()).setScale(-2, BigDecimal.ROUND_HALF_UP);
				;
			}
		}
		return amt;
	}

	/**
	 * 获取门诊预交金记账总金额
	 * 
	 * @param blcgoepAggDOs
	 * @return
	 */
	public static FDouble getOepCgAccAmt(BlcgoepAggDO[] blcgoepAggDOs) {
		FDouble amtsum = FDouble.ZERO_DBL;
		for (BlcgoepAggDO blcgoepAggDO : blcgoepAggDOs) {
			for (BlCgItmOepDO blCgItmOepDO : blcgoepAggDO.getBlCgItmOepDO()) {
				if (blCgItmOepDO.getFg_acc().booleanValue()) {
					amtsum = amtsum.add(blCgItmOepDO.getAmt().multiply(blcgoepAggDO.getParentDO().getEu_direct()))
							.setScale(-2, BigDecimal.ROUND_HALF_UP);
				}
			}
		}
		return amtsum;
	}

	/**
	 * 判断是否真实记账
	 * 
	 * @param cgList
	 * @return
	 * @throws Exception
	 */
	public static boolean isTrueAccount(FArrayList cgList) throws Exception {
		boolean flag = false;
		BlcgoepAggDO blcgAggDo = (BlcgoepAggDO) cgList.get(0);
		BlCgItmOepDO blCgItmOepDO = blcgAggDo.getBlCgItmOepDO()[0];
		String id_cgitmoep = blCgItmOepDO.getId_cgitmoep();
		Thread.sleep(1000);
		IBlCgItmOepDORService cgOepItmRservice = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO cgItmOepDO = cgOepItmRservice.findById(id_cgitmoep);
		if (cgItmOepDO != null) {
			Thread.sleep(1000);
			BlCgItmOepDO cgItmOepDO2 = cgOepItmRservice.findById(id_cgitmoep);
			if (cgItmOepDO2 != null) {
				flag = true;// 发出短信通知
			}
		}
		return flag;
	}
	/**
	 * 获取患者数据
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	public static PatDO getPatData(String patId) throws BizException{
		DAFacade daf = new DAFacade();
		String[] PI_PAT_FIELD = new String[] { PatDO.ID_PAT, PatDO.CODE, PatDO.NAME,PatDO.MOB };
		PatDO rlt = (PatDO) daf.findByPK(PatDO.class, patId, PI_PAT_FIELD);
		return rlt;
	}
	/**
	 * 获取组织名称
	 * 
	 * @throws BizException
	 */
	public static String getOrgName(String id_org) throws BizException {
		DAFacade daf = new DAFacade();
		String[] ORG_FIELD = new String[] { OrgDO.NAME };
		OrgDO org = (OrgDO) daf.findByPK(OrgDO.class, id_org, ORG_FIELD);
		return org.getName();
	}
	/**
	 * 获取就诊类型do
	 * 
	 * @param id_entp
	 * @return
	 * @throws BizException
	 */
	public static EnTypeDO getEntpDo(String id_entp) throws BizException {
		DAFacade daf = new DAFacade();
		String[] ENTHPE_FIELD = new String[] { EnTypeDO.CODE,EnTypeDO.NAME };
		EnTypeDO entypeDo = (EnTypeDO) daf.findByPK(EnTypeDO.class, id_entp, ENTHPE_FIELD);
		return entypeDo;
	}
	
	/**
	 * 获取收退费名称
	 * 
	 * @param eu_direct
	 * @return
	 */
	public static String getFeeEudirect(Integer eu_direct) {
		if (eu_direct.equals(BookRtnDirectEnum.CHARGE)) {
			return "支付";
		} else if (eu_direct.equals(BookRtnDirectEnum.RETURNS)) {
			return "退款";
		}
		return null;
	}
    /**
     * 获取支付方式名称
     * @param id_pm
     * @return
     * @throws BizException
     */
	public  static String getPmName(String id_pm) throws BizException {
		if (id_pm != null) {
			DAFacade daf = new DAFacade();
			String[] PM_FIELD = new String[] { PriPmDO.NAME };
			PriPmDO priPmDO = (PriPmDO) daf.findByPK(PriPmDO.class, id_pm, PM_FIELD);
			return priPmDO.getName();
		}
		return "";

	}
}
