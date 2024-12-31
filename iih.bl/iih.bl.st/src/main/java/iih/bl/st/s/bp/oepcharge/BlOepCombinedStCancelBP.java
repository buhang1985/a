package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blstmgoep.d.BlStMgOepDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.s.bp.oepcharge.base.BlOepCombineStBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.lock.PKLock;

/**
 * 门诊取消合并结算
 * @author ly 2019/12/10
 *
 */
public class BlOepCombinedStCancelBP extends BlOepCombineStBaseBP{

	private static final String LOCK_KEY = "combinedcancel_lock_";
	
	/**
	 * 门诊取消合并结算
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public String[] exec(String stId) throws BizException {
		
		// 查询结算数据
		BlStOepDO stDO = this.prepareStData(stId);
		
		// 查询合并关系数据
		String[] combinedStIds = this.qryStMgOepDatas(stId);
		
		// 加锁
		boolean lock = PKLock.getInstance().addDynamicLock(LOCK_KEY + stDO.getId_pat(), 0);
		if(!lock){
			throw new BizException("当前患者正在进行门诊取消合并结算操作，请稍后重试");
		}
		
		// 红冲合并数据
		this.redCombinedData(stDO);
		
		// 还原被合并数据
		String[] stIds = this.restoreSt(combinedStIds);
		
		return stIds;
	}
	
	/**
	 * 准备结算数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private BlStOepDO prepareStData(String stId) throws BizException {
		
		if(StringUtil.isEmpty(stId)){
			throw new BizException("门诊取消合并结算:入参结算id为空");
		}

		DAFacade daf = new DAFacade();
		BlStOepDO stDO = (BlStOepDO)daf.findByPK(BlStOepDO.class, stId);
		if(stDO == null){
			throw new BizException("门诊取消合并结算:未查询到结算数据");
		}
		
		if(FBoolean.TRUE.equals(stDO.getFg_canc())){
			throw new BizException("门诊取消合并结算:该结算已作废，无法取消合并");
		}
		
		return stDO;
	}

	/**
	 * 查询合并关系数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private String[] qryStMgOepDatas(String stId) throws BizException {
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<BlStMgOepDO> stMgList = (List<BlStMgOepDO>)daf.findByAttrValString(
				BlStMgOepDO.class, BlStMgOepDO.ID_MGST, stId, null);
		
		if(ListUtil.isEmpty(stMgList)){
			throw new BizException("门诊取消合并结算:未查询到合并关联数据");
		}
		
		List<String> stIdList = new ArrayList<String>();
		for (BlStMgOepDO stMgDO : stMgList) {
			stIdList.add(stMgDO.getId_st());
		}
		
		return stIdList.toArray(new String[0]);
	}
	
	/**
	 * 红冲合并数据
	 * @param stDO
	 * @throws BizException
	 */
	private void redCombinedData(BlStOepDO stDO) throws BizException {

		// 准备数据
		BlcgoepAggDO[] oldCgAggDos = super.prepareCgDatas(new String[] { stDO.getId_stoep() });
		BlpaypatoepAggDO[] payAggDos = super.preparePayDatas(new String[] { stDO.getId_paypatoep() });

		// 红冲原数据
		super.redData(new BlStOepDO[] { stDO }, oldCgAggDos, payAggDos);

		// 修改数据
		super.updateOldData(new BlStOepDO[] { stDO }, oldCgAggDos);
	}
	
	/**
	 * 还原被合并数据
	 * @param combinedStIds
	 * @return 还原后的结算id
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private String[] restoreSt(String[] combinedStIds) throws BizException{
		
		// 准备数据
		Map<String, List<BlcgoepAggDO>> cgMap = new HashMap<String, List<BlcgoepAggDO>>();//key 结算id
		Map<String, BlpaypatoepAggDO> payMap = new HashMap<String, BlpaypatoepAggDO>();//key 收付款id
		
		DAFacade daf = new DAFacade();
		List<BlStOepDO> stList = (List<BlStOepDO>)daf.findByPKs(BlStOepDO.class, combinedStIds);
		
		BlcgoepAggDO[] oldCgAggDos = super.prepareCgDatas(combinedStIds);
		List<String> payIdList = new ArrayList<String>();
		for (BlStOepDO stDO : stList) {
			payIdList.add(stDO.getId_paypatoep());
		}
		BlpaypatoepAggDO[] payAggDos = super.preparePayDatas(payIdList.toArray(new String[0]));
		
		for (BlcgoepAggDO oldCgAggDO : oldCgAggDos) {
			
			List<BlcgoepAggDO> cgList = null;
			String key = oldCgAggDO.getBlCgItmOepDO()[0].getId_stoep();
			if(cgMap.containsKey(key)){
				cgList = cgMap.get(key);
			}else{
				cgList = new ArrayList<BlcgoepAggDO>();
				cgMap.put(key, cgList);
			}
			cgList.add(oldCgAggDO);
		}
		
		for (BlpaypatoepAggDO oldPayAggDO : payAggDos) {
			payMap.put(oldPayAggDO.getParentDO().getId_paypatoep(), oldPayAggDO);
		}
		
		String[] newStIds = new DBUtil().getOIDs(combinedStIds.length);
		String[] newPayIds = new DBUtil().getOIDs(combinedStIds.length);
		
		List<BlStOepDO> newStList = new ArrayList<BlStOepDO>();
		List<BlcgoepAggDO> newCgList = new ArrayList<BlcgoepAggDO>();
		List<BlpaypatoepAggDO> newPayList = new ArrayList<BlpaypatoepAggDO>();
		
		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		
		// 组装数据
		for (int i = 0; i < stList.size(); i++) {
			
			String newStId = newStIds[i];
			String newPayId = newPayIds[i];
			
			BlStOepDO oldStDO = (BlStOepDO)stList.get(i);
			
			BlStOepDO newStDO = (BlStOepDO)oldStDO.clone();
			newStDO.setId_stoep(newStId);
			newStDO.setCode_st(BlCodeUtils.generateOepStCode());
			newStDO.setDt_st(BlFlowContextUtil.getNowTime());
			newStDO.setId_emp_st(Context.get().getStuffId());
			newStDO.setId_dep_st(Context.get().getDeptId());
			newStDO.setFg_cc(FBoolean.FALSE);
			newStDO.setId_cc(null);
			newStDO.setFg_canc(FBoolean.FALSE);
			newStDO.setId_emp_canc(null);
			newStDO.setDt_canc(null);
			newStDO.setId_reason_canc(null);
			newStDO.setSd_reason_cand(null);
			newStDO.setDes_reason_canc(null);
			newStDO.setId_paypatoep(newPayId);
			newStDO.setId_rootst(StringUtil.isEmpty(oldStDO.getId_rootst()) ? oldStDO.getId_stoep() : oldStDO.getId_rootst());
			newStDO.setStatus(DOStatus.NEW);
			newStList.add(newStDO);
			
			List<BlcgoepAggDO> cgList = cgMap.get(oldStDO.getId_stoep());
			
			String[] codes = iBillcodeManage.getBatchBillCodes_RequiresNew(
					BlCgOepDO.class.getName(), new BlCgOepDO(), cgList.size());
			
			for (int j = 0; j < cgList.size(); j++) {
				
				BlcgoepAggDO oldCgAggDO = cgList.get(j);
				BlcgoepAggDO newCgAggDO = new BlcgoepAggDO();
				BlCgOepDO newCgHdDO = (BlCgOepDO)oldCgAggDO.getParentDO().clone();
				newCgHdDO.setId_cgoep(null);
				newCgHdDO.setCode_cg(codes[j]);
				newCgHdDO.setDt_cg(BlFlowContextUtil.getNowTime());
				newCgHdDO.setId_org_cg(Context.get().getOrgId());
				newCgHdDO.setId_dep_cg(Context.get().getDeptId());
				newCgHdDO.setId_emp_cg(Context.get().getStuffId());
				newCgHdDO.setStatus(DOStatus.NEW);
				newCgAggDO.setParentDO(newCgHdDO);
				
				List<BlCgItmOepDO> cgItmList = new ArrayList<BlCgItmOepDO>();
				for (BlCgItmOepDO oldCgItmDO : oldCgAggDO.getBlCgItmOepDO()) {
					
					BlCgItmOepDO newCgItmDO = (BlCgItmOepDO)oldCgItmDO.clone();
					newCgItmDO.setId_cgitmoep(null);
					newCgItmDO.setId_cgoep(null);
					newCgItmDO.setDt_cg(BlFlowContextUtil.getNowTime());
					newCgItmDO.setId_stoep(newStId);
					newCgItmDO.setFg_refund(FBoolean.FALSE);
					newCgItmDO.setStatus(DOStatus.NEW);
					
					cgItmList.add(newCgItmDO);
				}
				
				newCgAggDO.setBlCgItmOepDO(cgItmList.toArray(new BlCgItmOepDO[0]));
				newCgList.add(newCgAggDO);
			}
			
			BlpaypatoepAggDO oldPayAggDO = payMap.get(oldStDO.getId_paypatoep());
			BlpaypatoepAggDO newPayAggDO = new BlpaypatoepAggDO();
			BlPayPatOepDO newPayHdDO = (BlPayPatOepDO)oldPayAggDO.getParentDO().clone();
			newPayHdDO.setId_paypatoep(newPayId);
			newPayHdDO.setDt_pay(BlFlowContextUtil.getNowTime());
			newPayHdDO.setId_org_pay(Context.get().getOrgId());
			newPayHdDO.setId_dep_pay(Context.get().getDeptId());
			newPayHdDO.setId_emp_pay(Context.get().getStuffId());
			newPayHdDO.setStatus(DOStatus.NEW);
			newPayAggDO.setParentDO(newPayHdDO);
			
			List<BlPayItmPatOepDO> newPayItmList = new ArrayList<BlPayItmPatOepDO>();
			for (BlPayItmPatOepDO oldPayItmDO : oldPayAggDO.getBlPayItmPatOepDO()) {
				
				BlPayItmPatOepDO newPayItmDO = (BlPayItmPatOepDO)oldPayItmDO.clone();
				newPayItmDO.setId_payitmpatoep(null);
				newPayItmDO.setId_paypatoep(newPayId);
				newPayItmDO.setFg_realpay(FBoolean.FALSE);
				newPayItmDO.setStatus(DOStatus.NEW);
				
				newPayItmList.add(newPayItmDO);
			}
			
			newPayAggDO.setBlPayItmPatOepDO(newPayItmList.toArray(new BlPayItmPatOepDO[0]));
			newPayList.add(newPayAggDO);
		}
		
		// 保存结算
		IBlstoepCudService stService = ServiceFinder.find(IBlstoepCudService.class);
		stService.insert(newStList.toArray(new BlStOepDO[0]));
		
		// 保存记账
		IBlcgoepCudService cgService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] newCgAggDos = cgService.insert(newCgList.toArray(new BlcgoepAggDO[0]));
		
		// 保存收付款
		IBlpaypatoepCudService payService = ServiceFinder.find(IBlpaypatoepCudService.class);
		payService.insert(newPayList.toArray(new BlpaypatoepAggDO[0]));
		
		// 保存发票数据
		Map<String, List<BlcgoepAggDO>> newCgMap = new HashMap<String, List<BlcgoepAggDO>>();//key 结算id
		for (BlcgoepAggDO oldCgAggDO : newCgAggDos) {
			
			List<BlcgoepAggDO> cgList = null;
			String key = oldCgAggDO.getBlCgItmOepDO()[0].getId_stoep();
			if(newCgMap.containsKey(key)){
				cgList = newCgMap.get(key);
			}else{
				cgList = new ArrayList<BlcgoepAggDO>();
				newCgMap.put(key, cgList);
			}
			cgList.add(oldCgAggDO);
		}
		
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		for (String key : newCgMap.keySet()) {
			List<BlcgoepAggDO> cgList = newCgMap.get(key);
			incService.saveOpInvoice(cgList.toArray(new BlcgoepAggDO[0]));
		}
		
		return newStIds;
	}
}
