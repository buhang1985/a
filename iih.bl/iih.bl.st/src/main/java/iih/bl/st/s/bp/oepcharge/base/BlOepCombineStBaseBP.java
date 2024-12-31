package iih.bl.st.s.bp.oepcharge.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.comm.util.BlDataUtil;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.s.bp.oepcharge.util.BlOepChargeDataUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 门诊结算合并取消合并基础类
 * @author ly 2019/12/11 
 *
 */
public class BlOepCombineStBaseBP {

	/**
	 * 准备记账数据
	 * @param stIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected BlcgoepAggDO[] prepareCgDatas(String[] stIds) throws BizException {
		
		DAFacade daf = new DAFacade();
		
		List<BlCgItmOepDO> cgItmList = (List<BlCgItmOepDO>)daf.findByAttrValStrings(
				BlCgItmOepDO.class, BlCgItmOepDO.ID_STOEP, stIds, null);
		
		return BlDataUtil.getOepCgAggDataByItm(cgItmList.toArray(new BlCgItmOepDO[0]));
	}
	
	/**
	 * 准备支付数据
	 * @param payoepIds
	 * @return
	 * @throws BizException
	 */
	protected BlpaypatoepAggDO[] preparePayDatas(String[] payoepIds) throws BizException {
		
		IBlpaypatoepRService payRService = ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO[] payAggDos = payRService.findByIds(payoepIds, FBoolean.FALSE);
		return payAggDos;
	}
	
	/**
	 * 红冲数据
	 * @param oldStDos
	 * @param oldCgAggDos
	 * @param oldIncAggDos
	 * @param payAggDos
	 * @throws BizException
	 */
	protected void redData(BlStOepDO[] oldStDos, BlcgoepAggDO[] oldCgAggDos, BlpaypatoepAggDO[] payAggDos) throws BizException {

		Map<String, String> payStIdMap = new HashMap<String, String>();//原支付id->原结算id关系
		Map<String, String> stNewPayMap = new HashMap<String, String>();//原结算id->新支付id关系
		Map<String, String> stNewStMap = new HashMap<String, String>();//原结算id->新结算id关系
		Map<String, String> newStOldStMap = new HashMap<String, String>();//新结算id->原结算id关系
		
		String[] newPayIds = new DBUtil().getOIDs(oldStDos.length);
		String[] newStIds = new DBUtil().getOIDs(oldStDos.length);

		for (int i = 0; i < oldStDos.length; i++) {
			BlStOepDO oldStDO = oldStDos[i];
			payStIdMap.put(oldStDO.getId_paypatoep(), oldStDO.getId_stoep());
			stNewPayMap.put(oldStDO.getId_stoep(), newPayIds[i]);
			stNewStMap.put(oldStDO.getId_stoep(), newStIds[i]);
			newStOldStMap.put(newStIds[i], oldStDO.getId_stoep());
		}

		// 红冲结算数据
		List<BlStOepDO> redStList = new ArrayList<BlStOepDO>();
		for (BlStOepDO oldStDO : oldStDos) {

			BlStOepDO redStDO = BlOepChargeDataUtil.buildRedStData(oldStDO, stNewStMap.get(oldStDO.getId_stoep()),
					stNewPayMap.get(oldStDO.getId_stoep()));
			redStList.add(redStDO);
		}
		IBlstoepCudService stCudService = ServiceFinder.find(IBlstoepCudService.class);
		stCudService.insert(redStList.toArray(new BlStOepDO[0]));

		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String[] codes = iBillcodeManage.getBatchBillCodes_RequiresNew(
				BlCgOepDO.class.getName(), new BlCgOepDO(), oldCgAggDos.length);

		// 红冲记账数据
		List<BlcgoepAggDO> redCgList = new ArrayList<BlcgoepAggDO>();
		for (int i = 0; i < oldCgAggDos.length; i++) {
			BlcgoepAggDO oldCgAggDO = oldCgAggDos[i];
			BlcgoepAggDO redCgAggDO = BlOepChargeDataUtil.buildRedCgData(oldCgAggDO,
					stNewStMap.get(oldCgAggDO.getBlCgItmOepDO()[0].getId_stoep()));
			redCgAggDO.getParentDO().setCode_cg(codes[i]);
			redCgList.add(redCgAggDO);
		}

		IBlcgoepCudService cgCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] redCgAggDos = cgCudService.insert(redCgList.toArray(new BlcgoepAggDO[0]));

		// 红冲票据数据
		Map<String, List<BlcgoepAggDO>> redCgMap = new HashMap<String, List<BlcgoepAggDO>>();
		for (BlcgoepAggDO redCgAggDO : redCgAggDos) {

			String redStId = redCgAggDO.getBlCgItmOepDO()[0].getId_stoep();
			String key = newStOldStMap.get(redStId);

			List<BlcgoepAggDO> cgList = null;
			if (redCgMap.containsKey(key)) {
				cgList = redCgMap.get(key);
			} else {
				cgList = new ArrayList<BlcgoepAggDO>();
				redCgMap.put(key, cgList);
			}
			cgList.add(redCgAggDO);
		}

		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		for (String oldStId : redCgMap.keySet()) {
			incService.saveRedOpInvoice(oldStId, redCgMap.get(oldStId).toArray(new BlcgoepAggDO[0]), FBoolean.FALSE);
		}

		// 红冲收付款数据
		List<BlpaypatoepAggDO> redPayList = new ArrayList<BlpaypatoepAggDO>();
		for (BlpaypatoepAggDO oldPayAggDO : payAggDos) {
			String oldStId = payStIdMap.get(oldPayAggDO.getParentDO().getId_paypatoep());
			BlpaypatoepAggDO redPayAggDO = BlOepChargeDataUtil.buildAllRefundRedPayData(oldPayAggDO,
					IBlDictCodeConst.SD_PTTP_WINDOW, stNewPayMap.get(oldStId));
			redPayList.add(redPayAggDO);
		}

		IBlpaypatoepCudService payService = ServiceFinder.find(IBlpaypatoepCudService.class);
		payService.insert(redPayList.toArray(new BlpaypatoepAggDO[0]));
	}
	
	/**
	 * 更新原数据
	 * @param oldStDos
	 * @param oldCgAggDos
	 * @throws BizException
	 */
	protected void updateOldData(BlStOepDO[] oldStDos, BlcgoepAggDO[] oldCgAggDos) throws BizException{
		
		for (BlStOepDO oldStDO : oldStDos) {
			oldStDO.setFg_canc(FBoolean.TRUE);
			oldStDO.setId_emp_canc(Context.get().getStuffId());
			oldStDO.setDt_canc(BlFlowContextUtil.getNowTime());
		}
		
		List<BlCgItmOepDO> oldCgItmList = new ArrayList<BlCgItmOepDO>();
		for (BlcgoepAggDO cgAggDO : oldCgAggDos) {
			for (BlCgItmOepDO oldCgItm : cgAggDO.getBlCgItmOepDO()) {
				oldCgItm.setFg_refund(FBoolean.TRUE);
				oldCgItmList.add(oldCgItm);
			}
		}
		
		DAFacade daf = new DAFacade();
		daf.updateDOArray(oldStDos, new String[] { BlStOepDO.FG_CANC, BlStOepDO.ID_EMP_CANC, BlStOepDO.DT_CANC });
		daf.updateDOArray(oldCgItmList.toArray(new BlCgItmOepDO[0]), new String[]{BlCgItmOepDO.FG_REFUND});
	}
}
