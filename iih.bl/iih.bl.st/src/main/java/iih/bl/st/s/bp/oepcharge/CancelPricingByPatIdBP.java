package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.s.bp.oepcharge.base.BlOepCancelPricingBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * 门诊取消划价
 * 按人员
 * @author wq.li
 *
 */
public class CancelPricingByPatIdBP extends BlOepCancelPricingBaseBP {


	private static final String LOCK_KEY = "pricing_lock_";
	/**
	 * 门诊取消划价
	 * 按人员
	 * @param patId
	 * @throws BizException 
	 */
	public void exec(String patId) throws BizException
	{
		if(StringUtil.isEmpty(patId)){
			throw new BizException("门诊取消划价:入参患者id为空");
		}
		
		String lockKey = LOCK_KEY + patId;
		boolean lock = PKLock.getInstance().addDynamicLock(lockKey, 3);
		if(!lock){
			throw new BizException("当前患者正在取消划价，请刷新重试");
		}
		
		//查询记账信息
		BlCgItmOepDO[] cgItmDos = this.findCgItmInfo(patId);
		
		if(ArrayUtil.isEmpty(cgItmDos))
		{
			return;
		}
		
		Set<String> stIdSet=new HashSet<>();
		
		for (BlCgItmOepDO itm : cgItmDos) {
			if(!StringUtil.isEmpty(itm.getId_stoep()))
			{
				stIdSet.add(itm.getId_stoep());
			}
		}
		
		
		//查询结算校验信息
		BlStOepDO[] stDOArr = this.findAndCheckStInfo(stIdSet.toArray(new String[0]));
		
		List<BlCgItmOepDO> cgList = new ArrayList<BlCgItmOepDO>();
		List<BlCgItmOepDO> unCgList = new ArrayList<BlCgItmOepDO>();
		for (BlCgItmOepDO cgItmDO : cgItmDos) {
			if(FBoolean.TRUE.equals(cgItmDO.getFg_acc()) || 
					FBoolean.TRUE.equals(cgItmDO.getFg_hpcg())){
				cgList.add(cgItmDO);
			}else{
				unCgList.add(cgItmDO);
			}
		}
		
		//删除挂起数据
		this.deleteSuspData(unCgList);
		
		//还原挂起记账数据
		this.restoreSuspData(cgList);
		
		//删除结算数据
		if(!ArrayUtil.isEmpty(stDOArr))
		{
			this.deleteStData(stDOArr);
		}
	}
	
	/**
	 * 查询记账明细数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlCgItmOepDO[] findCgItmInfo(String patId) throws BizException{
		
		DAFacade daf = new DAFacade();
		
		SqlParam param =new SqlParam();
		param.addParam(patId);
		
		List<BlCgItmOepDO> cgList = (List<BlCgItmOepDO>)daf.findByCond(BlCgItmOepDO.class, "Fg_pricinginsertcg='Y' and fg_susp='Y' and id_pat=?", param);
		
		if(ListUtil.isEmpty(cgList)){
			return null;
		}
		
		return cgList.toArray(new BlCgItmOepDO[0]);
	}

	
	/**
	 * 查询校验结算信息
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private BlStOepDO[] findAndCheckStInfo(String[] stIdArr) throws BizException{
		
		if(ArrayUtil.isEmpty(stIdArr))
		{
			return null;
		}
		
		DAFacade daf = new DAFacade();
		List<BlStOepDO> list = (List<BlStOepDO>)daf.findByPKs(BlStOepDO.class, stIdArr);
		if(ListUtil.isEmpty(list)){
			return null;
		}
		
		for (BlStOepDO blStOepDO : list) {
			if(!StringUtil.isEmpty(blStOepDO.getId_paypatoep())){
				throw new BizException("门诊取消划价:已收付款，无法取消划价");
			}
		}
		
		
		return list.toArray(new BlStOepDO[0]);
	}
	
}
