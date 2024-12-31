package iih.bl.st.s.bp.oepcharge.help;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import iih.bd.base.utils.MapUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundItmDTO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.mm.itf.material.d.ReserveReqDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mp.dg.i.IMpDgOutService;

/**
 * 退费时退药品处理类
 * @author ly 2018/12/15
 *
 */
public class BlReturnDrugBP {

	/**
	 * 退费时退药品处理
	 * @param cgItmDtos 退费数据
	 * @param oldCgItmMap 原记账数据
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void exec(BlOepRefundItmDTO[] cgItmDtos,Map<String, BlCgItmOepDO> oldCgItmMap) throws BizException{
	
		List<String> drugPutList = new ArrayList<String>();//已发药集合
		List<String> drugNotPutList = new ArrayList<String>();//未发药集合
		List<ReserveReqDTO> reserveList = new ArrayList<ReserveReqDTO>();//退预留集合
		
		Set<String> orsrvIdSet = new HashSet<String>();
		for (BlOepRefundItmDTO cgItmDto : cgItmDtos) {
			BlCgItmOepDO cgItmDO = oldCgItmMap.get(cgItmDto.getId_cgitm());
			if(FBoolean.TRUE.equals(cgItmDO.getFg_mm()) && !StringUtil.isEmpty(cgItmDO.getId_orsrv())){
				orsrvIdSet.add(cgItmDO.getId_orsrv());
			}
		}
		
		Map<String,OrdSrvDO> orsrvMMMap = new HashMap<String,OrdSrvDO>();
		if(orsrvIdSet.size() > 0){
			DAFacade daf = new DAFacade();
			List<OrdSrvDO> orsrvList = (List<OrdSrvDO>)daf.findByPKs(OrdSrvDO.class, orsrvIdSet.toArray(new String[0]));
			if(!ListUtil.isEmpty(orsrvList)){
				orsrvMMMap = MapUtils.convertListToMap(orsrvList, OrdSrvDO.ID_ORSRV);
			}
		}
		
		for (BlOepRefundItmDTO cgItmDto : cgItmDtos) {
			BlCgItmOepDO cgItmDO = oldCgItmMap.get(cgItmDto.getId_cgitm());
			
			if(!FBoolean.TRUE.equals(cgItmDO.getFg_mm()) || StringUtil.isEmpty(cgItmDO.getId_orsrv()))
				continue;
			
			OrdSrvDO orsrvDO = orsrvMMMap.get(cgItmDO.getId_orsrv());
			if (orsrvDO != null && FBoolean.FALSE.equals(orsrvDO.getFg_or())) 
				continue;
			
			if(FBoolean.TRUE.equals(cgItmDto.getFg_getdrug())){
				drugPutList.add(cgItmDO.getId_orsrv());
			}else{
				drugNotPutList.add(cgItmDO.getId_orsrv());
				
				ReserveReqDTO reserveDto = new ReserveReqDTO();
				reserveDto.setId_mm(cgItmDO.getId_mm());
				reserveDto.setId_dep(cgItmDO.getId_dep_wh());
				reserveDto.setReq_num(cgItmDto.getQuan_bk());
				reserveDto.setReq_unit_id(cgItmDO.getSrvu());
				reserveDto.setId_orsrv(cgItmDO.getId_orsrv());
				reserveList.add(reserveDto);
			}
		}
		
		IMpDgOutService dgService = ServiceFinder.find(IMpDgOutService.class);
		IMaterialStockService mmService = ServiceFinder.find(IMaterialStockService.class);
		if(drugPutList.size() > 0){
			//回写药品退费状态
			dgService.writebackDispItmAfterRefundCharge(drugPutList.toArray(new String[0]));
		}
		
		if(drugNotPutList.size() > 0){
			//释放队列
			dgService.releaseQueueAfterRefundCharge(drugNotPutList.toArray(new String[0]));
			//退预留
			mmService.reserveMaterials(IMaterialStockService.TYPE_RETURN, reserveList.toArray(new ReserveReqDTO[0]));
		}
	}
}
