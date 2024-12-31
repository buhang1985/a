package iih.bl.st.s.bp.oepcharge.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.mm.itf.material.d.ReserveReqDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

public class BlOepCancelPricingBaseBP {

	/**
	 * 删除挂起数据
	 * @param unCgList
	 * @throws BizException
	 */
	protected void deleteSuspData(List<BlCgItmOepDO> unCgList) throws BizException{
		
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
	protected void restoreSuspData(List<BlCgItmOepDO> cgList) throws BizException{
		
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
	protected void deleteStData(BlStOepDO stDO) throws BizException{
		new DAFacade().deleteDO(stDO);
	}
	
	/**
	 * 删除结算数据
	 * @param stDoArr
	 * @throws BizException
	 */
	protected void deleteStData(BlStOepDO[] stDoArr) throws BizException
	{
		new DAFacade().deleteDOs(stDoArr);
	}
	
}
