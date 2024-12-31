package iih.bl.st.s.bp.oepcharge.base;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.i.IBlproparoepMDORService;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.blpropoep.i.IBlpropoepRService;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.s.event.BlOpPayEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.lock.PKLock;

/**
 * 收退费公用处理类
 * @author ly 2018/12/12
 *
 */
public abstract class BlOepPaymentBaseBP {

	/**
	 * 加锁key
	 */
	private static final String LOCK_KEY = "payment_lock_";
	
	protected DAFacade daf;
	//部分用到的服务
	protected IBlcgoepCudService cgCudService;
	protected IBlstoepCudService stCudService;
	protected IBlpaypatoepCudService payCudService;
	
	public BlOepPaymentBaseBP(){
		daf = new DAFacade();
		cgCudService = ServiceFinder.find(IBlcgoepCudService.class);
		stCudService = ServiceFinder.find(IBlstoepCudService.class);
		payCudService = ServiceFinder.find(IBlpaypatoepCudService.class);
	}
	
	/**
	 * 业务名字
	 * @return
	 */
	protected abstract String getBusinessName();
	
	/**
	 * 加锁
	 * @param stId
	 * @throws BizException
	 */
	protected void addLock(String stId) throws BizException{
		
		String lockKey = LOCK_KEY + stId;
		boolean lock = PKLock.getInstance().addDynamicLock(lockKey, 0);
		if(!lock){
			throw new BizException("当前结算正在进行收退费操作，请稍后重试");
		}
	}

	/**
	 * 查询记账数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected BlCgItmOepDO[] findCgInfo(String stId) throws BizException{
		
		List<BlCgItmOepDO> cgItmList = (List<BlCgItmOepDO>)this.daf.findByAttrValString(
				BlCgItmOepDO.class, BlCgItmOepDO.ID_STOEP, stId, null);
		
		if(ListUtil.isEmpty(cgItmList)){
			throw new BizException(String.format("%s:未查询到记账信息", getBusinessName()));
		}
	
		return cgItmList.toArray(new BlCgItmOepDO[0]);
	}
	
	/**
	 * 查询记账agg数据
	 * @param cgItmDos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected BlcgoepAggDO[] findCgAggInfo(BlCgItmOepDO[] cgItmDos) throws BizException{
		
		Set<String> cgIdSet = new HashSet<String>();
		Map<String,List<BlCgItmOepDO>> itmMap = new HashMap<String,List<BlCgItmOepDO>>();
		for (BlCgItmOepDO cgItm : cgItmDos) {
			cgIdSet.add(cgItm.getId_cgoep());
			
			List<BlCgItmOepDO> cgItmList = itmMap.get(cgItm.getId_cgoep());
			if(cgItmList == null){
				cgItmList = new ArrayList<BlCgItmOepDO>();
				itmMap.put(cgItm.getId_cgoep(), cgItmList);
			}
			
			cgItmList.add(cgItm);
		}
		
		List<BlCgOepDO> cgList = (List<BlCgOepDO>)this.daf.findByPKs(BlCgOepDO.class, cgIdSet.toArray(new String[0]));
		if(ListUtil.isEmpty(cgList) || cgList.size() != cgIdSet.size()){
			throw new BizException(String.format("%s:未查询到记账主信息", getBusinessName()));
		}
		
		BlcgoepAggDO[] aggDos = new BlcgoepAggDO[cgList.size()];
		for (int i = 0; i < cgList.size(); i++) {
			
			BlcgoepAggDO aggDO = new BlcgoepAggDO();
			BlCgOepDO headDO = cgList.get(i);
			
			aggDO.setParentDO(headDO);
			aggDO.setBlCgItmOepDO(itmMap.get(headDO.getId_cgoep()).toArray(new BlCgItmOepDO[0]));
			
			aggDos[i] = aggDO;
		}
	
		return aggDos;
	}

	/**
	 * 查询校验结算信息
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	protected BlStOepDO findStInfo(String stId) throws BizException{
		
		BlStOepDO stDO = (BlStOepDO)this.daf.findByPK(BlStOepDO.class, stId);
		if(stDO == null){
			throw new BizException(String.format("%s:结算信息不存在", getBusinessName()));
		}
		
		return stDO;
	}

	/**
	 * 查询收付款信息
	 * @param payId
	 * @return
	 * @throws BizException
	 */
	protected BlpaypatoepAggDO findPayInfo(String payId) throws BizException{
		IBlpaypatoepRService rService = ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO payAggDO = rService.findById(payId);
		if(payAggDO == null){
			throw new BizException(String.format("%s:原收付款信息不存在", getBusinessName()));
		}
		
		return payAggDO;
	}
	
	/**
	 * 查询分摊信息
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	protected BlPropOepDO findPropInfo(String stId) throws BizException{
		IBlpropoepRService service = ServiceFinder.find(IBlpropoepRService.class);
		BlPropOepDO[] propDos = service.findByAttrValString(BlPropOepDO.ID_STOEP, stId);
		if(ArrayUtil.isEmpty(propDos))
			return null;
		return propDos[0];
	}
	
	/**
	 * 查询应收信息
	 * @param propId
	 * @return
	 * @throws BizException
	 */
	protected BlPropArOepDO findPropArInfo(String propId) throws BizException{
		IBlproparoepMDORService service = ServiceFinder.find(IBlproparoepMDORService.class);
		BlPropArOepDO[] propArDos = service.findByAttrValString(BlPropArOepDO.ID_PROPOEP, propId);
		if(ArrayUtil.isEmpty(propArDos))
			return null;
		return propArDos[0];
	}
	
	/**
	 * 根据记账数据生成发票数据
	 * @param cgAggDos
	 * @param fgPrint
	 * @return
	 * @throws BizException
	 */
	protected BlincoepAggDO[] saveIncData(BlcgoepAggDO[] cgAggDos, FBoolean fgPrint) throws BizException{
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		BlincoepAggDO[] incAggDos = incService.saveAndPrintInvoice(cgAggDos, fgPrint);
		return incAggDos;
	}
	
	
	
	
	/**
	 * 根据记账数据生成发票数据
	 * @param cgAggDos
	 * @param fgPrint
	 * @return
	 * @throws BizException
	 */
	protected BlincoepAggDO[] saveReIncData(BlcgoepAggDO[] cgAggDos, BlReIncPageDTO[] cgitms) throws BizException{
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		BlincoepAggDO[] incAggDos = incService.saveReInvoice(cgAggDos, cgitms);
		return incAggDos;
	}
	/**
	 * 发送付款事件
	 * @param cgAggDos
	 * @param stDO
	 * @param payAggDO
	 * @param incAggDos
	 * @throws BizException
	 */
	protected void invokeChargeEvent(BlcgoepAggDO[] cgAggDos, BlStOepDO stDO,
			BlpaypatoepAggDO payAggDO, BlincoepAggDO[] incAggDos) throws BizException {
		BlOpPayEvent.invokePay(cgAggDos, stDO, payAggDO, incAggDos);
	}
}
