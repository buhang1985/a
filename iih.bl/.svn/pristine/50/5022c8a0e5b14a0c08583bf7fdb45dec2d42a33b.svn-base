package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.comm.thirdpayapi.BlThirdPayValidateUtil;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.itf.dto.thirdpayvalidate.d.BlThirdPayValidateRltDTO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blstmgoep.d.BlStMgOepDO;
import iih.bl.st.blstmgoep.i.IBlstmgoepCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.s.bp.oepcharge.base.BlOepCombineStBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.lock.PKLock;

/**
 * 门诊合并结算
 * @author ly 2019/12/10
 *
 */
public class BlOepCombineStBP extends BlOepCombineStBaseBP{

	private static final String LOCK_KEY = "combine_lock_";

	/**
	 * 门诊合并结算
	 * @param stIds
	 * @return
	 * @throws BizException
	 */
	public String exec(String[] stIds) throws BizException {
		
		// 准备原始数据
		BlStOepDO[] oldStDos = this.prepareStDatas(stIds);
		BlcgoepAggDO[] oldCgAggDos = super.prepareCgDatas(stIds);
		List<String> payIdList = new ArrayList<String>();
		for (BlStOepDO stDO : oldStDos) {
			payIdList.add(stDO.getId_paypatoep());
		}
		BlpaypatoepAggDO[] payAggDos = super.preparePayDatas(payIdList.toArray(new String[0]));
		this.checkPayData(payAggDos);
		
		// 加锁
		boolean lock = PKLock.getInstance().addDynamicLock(LOCK_KEY + oldStDos[0].getId_pat(), 0);
		if(!lock){
			throw new BizException("当前患者正在进行门诊合并结算操作，请稍后重试");
		}
		
		// 红冲原数据
		super.redData(oldStDos, oldCgAggDos, payAggDos);
		
		// 合并结算数据
		BlStOepDO comStDO = this.combineSt(oldStDos, oldCgAggDos, payAggDos);
		
		// 修改原数据
		super.updateOldData(oldStDos, oldCgAggDos);
		
		// 组装关系数据
		this.saveStRelation(comStDO, oldStDos);
		
		return comStDO.getId_stoep();
	}
	
	/**
	 * 准备结算数据
	 * @param stIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlStOepDO[] prepareStDatas(String[] stIds) throws BizException {
		
		if(ArrayUtil.isEmpty(stIds)){
			throw new BizException("门诊合并结算:入参结算id为空");
		}
		
		DAFacade daf = new DAFacade();
		List<BlStOepDO> stDos = (List<BlStOepDO>)daf.findByPKs(BlStOepDO.class, stIds);
		if(ListUtil.isEmpty(stDos)){
			throw new BizException("门诊合并结算:未查询到结算数据");
		}
		
		String patId = null;
		String code_entp = null;
		for (BlStOepDO stDO : stDos) {
		
			if(patId == null){
				patId = stDO.getId_pat();
			}
			
			if(code_entp == null){
				code_entp = stDO.getCode_enttp();
			}
			
			if(!patId.equals(stDO.getId_pat())){
				throw new BizException("门诊合并结算:传入结算数据非同一患者，请核对传入结算数据");
			}
			
			if (code_entp != null && !code_entp.equals(stDO.getCode_enttp())) {
				throw new BizException("门诊合并结算:传入结算就诊类型不一致，请核对传入结算数据");
			}
			
			if(stDO.getEu_direct() == BookRtnDirectEnum.RETURNS){
				throw new BizException("门诊合并结算:结算数据方向为负向无法参与合并。结算编码" + stDO.getCode_st());
			}
			
			if(!StringUtil.isEmpty(stDO.getId_hp())){
				throw new BizException("门诊合并结算:医保结算无法参与合并。结算编码" + stDO.getCode_st());
			}
			
			if(FBoolean.TRUE.equals(stDO.getFg_canc())){
				throw new BizException("门诊合并结算:已取消结算无法参与合并。结算编码" + stDO.getCode_st());
			}
			
			if(StringUtil.isEmpty(stDO.getId_paypatoep())){
				throw new BizException("门诊合并结算:未支付结算无法参与合并。结算编码" + stDO.getCode_st());
			}
		}
		
		return stDos.toArray(new BlStOepDO[0]);
	}

	/**
	 * 校验收付款数据
	 * @param payAggDos
	 * @throws BizException
	 */
	private void checkPayData(BlpaypatoepAggDO[] payAggDos) throws BizException {
		
		String pttp = null;
		
		boolean hasThirdPay = false;
		for (BlpaypatoepAggDO payAggDO : payAggDos) {
			
			if(pttp == null){
				pttp = payAggDO.getParentDO().getSd_pttp();
			}
			
			if(!pttp.equals(payAggDO.getParentDO().getSd_pttp())){
				throw new BizException("门诊合并结算:付款终端不一致结算无法进行合并，请核对传入结算数据");
			}
			
			Set<String> pmIdSet = new HashSet<String>();
			for (BlPayItmPatOepDO payItmDO : payAggDO.getBlPayItmPatOepDO()) {
				pmIdSet.add(payItmDO.getId_pm());
			}

	    	BlThirdPayValidateRltDTO dto=BlThirdPayValidateUtil.validate(pmIdSet.toArray(new String[]{}), IBlDictCodeConst.SD_BIZSCENE_OEP_CHARGE);

	    	if(FBoolean.TRUE.equals(dto.getFg_success()) && !StringUtils.isEmpty(dto.getId_pm())){
	    		if(hasThirdPay){
	    			throw new BizException("门诊合并结算:多笔结算中含有第三方支付支付方式，不支持合并");
	    		}else{
	    			hasThirdPay = true;
	    		}
	    	}
		}
	}
	
	/**
	 * 合并结算数据
	 * @param oldStDos
	 * @param oldCgAggDos
	 * @param oldPayAggDos
	 * @throws BizException
	 */
	private BlStOepDO combineSt(BlStOepDO[] oldStDos, BlcgoepAggDO[] oldCgAggDos, BlpaypatoepAggDO[] oldPayAggDos) throws BizException {
		
		BlStOepDO oldStDO = this.getThirdPayOldSt(oldStDos, oldPayAggDos);
		
		String[] ids = new DBUtil().getOIDs(2);
		String newStId = ids[0];
		String newPayId = ids[1];
		
		// 合并结算
		BlStOepDO newStDO = new BlStOepDO();
		newStDO.setId_stoep(newStId);
		newStDO.setId_grp(Context.get().getGroupId());
		newStDO.setId_org(Context.get().getOrgId());
		newStDO.setId_pat(oldStDos[0].getId_pat());
		newStDO.setId_enttp(oldStDos[0].getId_enttp());
		newStDO.setCode_enttp(oldStDos[0].getCode_enttp());
		newStDO.setId_patca(oldStDos[0].getId_patca());
		newStDO.setCode_st(BlCodeUtils.generateOepStCode());
		newStDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		newStDO.setEu_sttp(oldStDos[0].getEu_sttp());
		newStDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		newStDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		newStDO.setAmt(FDouble.ZERO_DBL);
		newStDO.setAmt_std(FDouble.ZERO_DBL);
		newStDO.setAmt_ratio(FDouble.ZERO_DBL);
		newStDO.setAmt_pat(FDouble.ZERO_DBL);
		newStDO.setAmt_hp(FDouble.ZERO_DBL);
		newStDO.setDt_st(BlFlowContextUtil.getNowTime());
		newStDO.setId_dep_st(Context.get().getDeptId());
		newStDO.setId_emp_st(Context.get().getStuffId());
		newStDO.setFg_cc(FBoolean.FALSE);
		newStDO.setFg_canc(FBoolean.FALSE);
		newStDO.setFg_arclear(FBoolean.TRUE);
		newStDO.setId_paypatoep(newPayId);
		newStDO.setStatus(DOStatus.NEW);
		
		if(oldStDO != null){
			newStDO.setId_rootst(StringUtil.isEmpty(oldStDO.getId_rootst()) ? oldStDO.getId_stoep() : oldStDO.getId_rootst());
		}
		
		for (BlStOepDO stDO : oldStDos) {
			newStDO.setAmt(newStDO.getAmt().add(stDO.getAmt()));
			newStDO.setAmt_std(newStDO.getAmt_std().add(stDO.getAmt_std()));
			newStDO.setAmt_ratio(newStDO.getAmt_ratio().add(stDO.getAmt_ratio()));
			newStDO.setAmt_pat(newStDO.getAmt_pat().add(stDO.getAmt_pat()));
			newStDO.setAmt_hp(newStDO.getAmt_hp().add(stDO.getAmt_hp()));
		}
		
		IBlstoepCudService stCudService = ServiceFinder.find(IBlstoepCudService.class);
		newStDO = stCudService.insert(new BlStOepDO[] { newStDO })[0];
		
		// 记账数据
		List<BlcgoepAggDO> newCgAggList = new ArrayList<BlcgoepAggDO>();
		for (BlcgoepAggDO oldCgAggDO : oldCgAggDos) {
			
			BlcgoepAggDO newCgAggDO = new BlcgoepAggDO();
			BlCgOepDO newCgHeadDO = (BlCgOepDO)oldCgAggDO.getParentDO().clone();
			newCgHeadDO.setId_cgoep(null);
			newCgHeadDO.setStatus(DOStatus.NEW);
			newCgAggDO.setParent(newCgHeadDO);
			
			List<BlCgItmOepDO> newCgItmList = new ArrayList<BlCgItmOepDO>();
			for (BlCgItmOepDO oldCgItmDO : oldCgAggDO.getBlCgItmOepDO()) {
				
				BlCgItmOepDO newCgItmDO = (BlCgItmOepDO)oldCgItmDO.clone();
				newCgItmDO.setId_cgoep(null);
				newCgItmDO.setId_cgitmoep(null);
				newCgItmDO.setId_par(oldCgItmDO.getId_cgitmoep());
//				newCgItmDO.setId_root(StringUtil.isEmpty(oldCgItmDO.getId_root()) ? 
//						oldCgItmDO.getId_cgitmoep() : oldCgItmDO.getId_root());
				newCgItmDO.setId_stoep(newStId);
				newCgItmList.add(newCgItmDO);
			}
			
			newCgAggDO.setBlCgItmOepDO(newCgItmList.toArray(new BlCgItmOepDO[0]));
			newCgAggList.add(newCgAggDO);
		}
		
		IBlcgoepCudService cgCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] newCgAggDos = cgCudService.insert(newCgAggList.toArray(new BlcgoepAggDO[0]));
		
		// 生成票据
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		incService.saveOpInvoice(newCgAggDos);

		// 合并收付款
		BlpaypatoepAggDO payAggDO = new BlpaypatoepAggDO();
		BlPayPatOepDO  payHdDO = new BlPayPatOepDO();
		payHdDO.setId_paypatoep(newPayId);
		payHdDO.setId_grp(Context.get().getGroupId());
		payHdDO.setId_org(Context.get().getOrgId());
		payHdDO.setId_enttp(newStDO.getId_enttp());
		payHdDO.setCode_enttp(newStDO.getCode_enttp());
		payHdDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);
		payHdDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);
		payHdDO.setId_pat(newStDO.getId_pat());
		payHdDO.setEu_direct(newStDO.getEu_direct());
		payHdDO.setAmt(FDouble.ZERO_DBL);
		payHdDO.setDt_pay(BlFlowContextUtil.getNowTime());
		payHdDO.setId_org_pay(Context.get().getOrgId());
		payHdDO.setId_dep_pay(Context.get().getDeptId());
		payHdDO.setId_emp_pay(Context.get().getStuffId());
		payHdDO.setFg_cc(FBoolean.FALSE);
		payHdDO.setId_pttp(oldPayAggDos[0].getParentDO().getId_pttp());
		payHdDO.setSd_pttp(oldPayAggDos[0].getParentDO().getSd_pttp());
		//payHdDO.setId_pttp(IBlDictCodeConst.ID_PTTP_WINDOW);
		//payHdDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		payHdDO.setStatus(DOStatus.NEW);
		payAggDO.setParentDO(payHdDO);
		
		List<BlPayItmPatOepDO> payItmList = new ArrayList<BlPayItmPatOepDO>();
		for (BlpaypatoepAggDO oldPayAggDO : oldPayAggDos) {
			payHdDO.setAmt(payHdDO.getAmt().add(oldPayAggDO.getParentDO().getAmt()));
			
			for (BlPayItmPatOepDO oldPayItmDO : oldPayAggDO.getBlPayItmPatOepDO()) {
				BlPayItmPatOepDO payItmDO = (BlPayItmPatOepDO)oldPayItmDO.clone();
				payItmDO.setId_payitmpatoep(null);
				payItmDO.setId_paypatoep(newPayId);
				payItmDO.setFg_realpay(FBoolean.FALSE);
				payItmDO.setStatus(DOStatus.NEW);
				payItmList.add(payItmDO);
			}
		}
		payAggDO.setBlPayItmPatOepDO(payItmList.toArray(new BlPayItmPatOepDO[0]));
		
		IBlpaypatoepCudService payService = ServiceFinder.find(IBlpaypatoepCudService.class);
		payService.insert(new BlpaypatoepAggDO[] { payAggDO });
		
		return newStDO;
	}
	
	/**
	 * 获取含第三方支付的结算
	 * @param oldStDos
	 * @param oldPayAggDos
	 * @return
	 * @throws BizException
	 */
	private BlStOepDO getThirdPayOldSt(BlStOepDO[] oldStDos, BlpaypatoepAggDO[] oldPayAggDos) throws BizException {
		
		for (BlpaypatoepAggDO payAggDO : oldPayAggDos) {
			
			Set<String> pmIdSet = new HashSet<String>();
			for (BlPayItmPatOepDO payItmDO : payAggDO.getBlPayItmPatOepDO()) {
				pmIdSet.add(payItmDO.getId_pm());
			}

	    	BlThirdPayValidateRltDTO dto=BlThirdPayValidateUtil.validate(pmIdSet.toArray(new String[]{}), IBlDictCodeConst.SD_BIZSCENE_OEP_CHARGE);
	    	if(FBoolean.TRUE.equals(dto.getFg_success()) && !StringUtils.isEmpty(dto.getId_pm())){
	    		
	    		for (BlStOepDO stDO : oldStDos) {
					if(payAggDO.getParentDO().getId_paypatoep().equals(stDO.getId_paypatoep())){
						return stDO;
					}
				}	    		
	    	}
		}
		
		return null;
	}
	
	/**
	 * 保存合并结算关系
	 * @param comStDO
	 * @param oldStDos
	 * @throws BizException
	 */
	private void saveStRelation(BlStOepDO comStDO, BlStOepDO[] oldStDos) throws BizException{
		
		IBlstmgoepCudService stmgService = ServiceFinder.find(IBlstmgoepCudService.class);
		
		List<BlStMgOepDO> stMgList = new ArrayList<BlStMgOepDO>();
		for (BlStOepDO oldStDO : oldStDos) {
			
			BlStMgOepDO stMgDO = new BlStMgOepDO();
			stMgDO.setId_grp(Context.get().getGroupId());
			stMgDO.setId_org(Context.get().getOrgId());
			stMgDO.setId_pat(comStDO.getId_pat());
			stMgDO.setId_mgst(comStDO.getId_stoep());
			stMgDO.setId_st(oldStDO.getId_stoep());
			stMgDO.setFg_canc(FBoolean.FALSE);
			stMgDO.setNote(null);
			
			stMgList.add(stMgDO);
		}
		stmgService.insert(stMgList.toArray(new BlStMgOepDO[0]));
	}
}
