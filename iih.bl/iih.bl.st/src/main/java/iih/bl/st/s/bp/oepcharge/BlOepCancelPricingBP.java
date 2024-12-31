package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.mm.itf.material.d.ReserveReqDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.lock.PKLock;

/**
 * 门诊取消划价
 * @author ly 2018/12/04
 *
 */
public class BlOepCancelPricingBP {

	private static final String LOCK_KEY = "payment_lock_";
	
	/**
	 * 门诊取消划价
	 * @param stId 结算id
	 * @throws BizException
	 */
	public void exec(String stId) throws BizException{
		
		if(StringUtil.isEmpty(stId)){
			throw new BizException("门诊取消划价:入参结算id为空");
		}
		
		String lockKey = LOCK_KEY + stId;
		boolean lock = PKLock.getInstance().addDynamicLock(lockKey, 0);
		if(!lock){
			throw new BizException("当前患者正在收付款或取消划价，请刷新重试");
		}
		
		//查询结算校验信息
		BlStOepDO stDO = this.findAndCheckStInfo(stId);
		
		//查询记账信息
		BlCgItmOepDO[] cgItmDos = this.findCgItmInfo(stId);
		
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
		this.deleteStData(stDO);
	}
	
	/**
	 * 查询校验结算信息
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private BlStOepDO findAndCheckStInfo(String stId) throws BizException{
		
		DAFacade daf = new DAFacade();
		BlStOepDO stDO = (BlStOepDO)daf.findByPK(BlStOepDO.class, stId);
		if(stDO == null){
			throw new BizException("门诊取消划价:结算信息不存在");
		}
		
		if(!StringUtil.isEmpty(stDO.getId_paypatoep())){
			throw new BizException("门诊取消划价:已收付款，无法取消划价");
		}
		
		return stDO;
	}

	/**
	 * 查询记账明细数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlCgItmOepDO[] findCgItmInfo(String stId) throws BizException{
		
		DAFacade daf = new DAFacade();
		List<BlCgItmOepDO> cgList = (List<BlCgItmOepDO>)daf.findByAttrValString(
				BlCgItmOepDO.class, BlCgItmOepDO.ID_STOEP, stId, null);
		
		if(ListUtil.isEmpty(cgList)){
			throw new BizException("门诊取消划价:未查询到记账信息");
		}
		
		return cgList.toArray(new BlCgItmOepDO[0]);
	}

	/**
	 * 删除挂起数据
	 * @param unCgList
	 * @throws BizException
	 */
	private void deleteSuspData(List<BlCgItmOepDO> unCgList) throws BizException{
		
		List<ReserveReqDTO> reserveList = new ArrayList<ReserveReqDTO>();
		Set<String> cgIdSet = new HashSet<String>();
		List<String> orsrvIdList = new ArrayList<String>();
		
		for (BlCgItmOepDO cgItmDO : unCgList) {
			if(FBoolean.TRUE.equals(cgItmDO.getFg_mm())){
				ReserveReqDTO reqDto = new ReserveReqDTO();
				reqDto.setId_mm(cgItmDO.getId_mm());
				reqDto.setId_dep(cgItmDO.getId_dep_wh());
				reqDto.setReq_num(cgItmDO.getQuan());
				reqDto.setReq_unit_id(cgItmDO.getSrvu());
				reqDto.setId_orsrv(cgItmDO.getId_orsrv());
				reserveList.add(reqDto);
				orsrvIdList.add(cgItmDO.getId_orsrv());
			}
			cgIdSet.add(cgItmDO.getId_cgoep());
		}
		if(reserveList.size() > 0){
			
			IMaterialStockService mlService = ServiceFinder.find(IMaterialStockService.class);
			//过滤已经退的预留
			List<ReserveReqDTO> needRefundList = new ArrayList<ReserveReqDTO>();
			Map<String, FBoolean> checkNeedRefundMap = mlService.getOrsrvReserveFlag(orsrvIdList.toArray(new String[0]));
			for (ReserveReqDTO reqDto : reserveList) {
				if(FBoolean.TRUE.equals(checkNeedRefundMap.get(reqDto.getId_orsrv()))){
					needRefundList.add(reqDto);
				}
			}
			
			//退预留
			if(needRefundList.size() > 0){
				mlService.reserveMaterials(IMaterialStockService.TYPE_RETURN, needRefundList.toArray(new ReserveReqDTO[] {}));
			}
		}
		
		//删除子表
		DAFacade daf = new DAFacade();
		daf.deleteDOs(unCgList.toArray(new BlCgItmOepDO[0]));
		
		//删除主表
		daf.deleteByPKs(BlCgOepDO.class, cgIdSet.toArray(new String[0]));
	}
	
	/**
	 * 还原记账数据
	 * @param cgList
	 * @throws BizException
	 */
	private void restoreSuspData(List<BlCgItmOepDO> cgList) throws BizException{
		
		IBlCgItmOepDOCudService itmService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
		for (BlCgItmOepDO cgItmDO : cgList) {
			cgItmDO.setFg_susp(FBoolean.FALSE);
			cgItmDO.setFg_st(FBoolean.FALSE);
			cgItmDO.setId_stoep(null);
			cgItmDO.setDt_st(null);
			cgItmDO.setStatus(DOStatus.UPDATED);
		}
		
		itmService.update(cgList.toArray(new BlCgItmOepDO[0]));
	}

	/**
	 * 删除结算数据
	 * @param stDO
	 * @throws BizException
	 */
	private void deleteStData(BlStOepDO stDO) throws BizException{
		IBlstoepCudService stService = ServiceFinder.find(IBlstoepCudService.class);
		stDO.setStatus(DOStatus.DELETED);
		stService.delete(new BlStOepDO[] { stDO });
	}
}
