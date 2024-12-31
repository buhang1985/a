package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.comm.IBlConst;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSetDTO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import iih.mm.itf.material.d.ReserveReqDTO;
import iih.mm.itf.material.d.ReserveResultDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 
 * 门诊预划价
 * @author ly 2019/02/24
 *
 */
public class BlOepChargePrepricingBP {

	/**
	 * 门诊预划价
	 * @param dtos 待划价数据
	 * @return 划价结果
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlOepChargePricingRltDTO[] exec(BlOepChargePricingDTO[] dtos, BlOepChargeSetDTO chargeSet) throws BizException{
	
		if(ArrayUtil.isEmpty(dtos))
			return null;
		
		Set<String> srvIdSet = new HashSet<String>();
		Set<String> orsrvIdSet = new HashSet<String>();
		Set<String> patPriIdSet = new HashSet<String>();
		List<ReserveReqDTO> reserveList = new ArrayList<ReserveReqDTO>();
		Set<String> otMMHashSet = new HashSet<String>();
		
		Map<String, MedSrvDO> medsrvMap = new HashMap<String, MedSrvDO>();
		Map<String, OrdSrvDO> orsrvMap = new HashMap<String, OrdSrvDO>();
		
		for (BlOepChargePricingDTO chargeDto : dtos) {
			
			if(FBoolean.TRUE.equals(chargeDto.getFg_mm())){
				if(FBoolean.FALSE.equals(chargeDto.getFg_or())){
					String key = chargeDto.getId_mm() + "," + chargeDto.getSrvu();
					otMMHashSet.add(key);
				}else{
					ReserveReqDTO reqDto = new ReserveReqDTO();
					reqDto.setId_mm(chargeDto.getId_mm());
					reqDto.setId_dep(chargeDto.getId_dep_wh());
					reqDto.setReq_num(chargeDto.getQuan());
					reqDto.setReq_unit_id(chargeDto.getSrvu());
					reqDto.setId_orsrv(chargeDto.getId_orsrv());
					reserveList.add(reqDto);
				}
			}else{
				srvIdSet.add(chargeDto.getId_srv());
			}
			
			if(!StringUtil.isEmpty(chargeDto.getId_pripat())){
				patPriIdSet.add(chargeDto.getId_pripat());
			}
			
			if(!StringUtil.isEmpty(chargeDto.getId_orsrv())){
				orsrvIdSet.add(chargeDto.getId_orsrv());
			}
		}
		
		//查询服务数据
		DAFacade daf = new DAFacade();
		if(srvIdSet.size() > 0){
			List<MedSrvDO> srvList = (List<MedSrvDO>)daf.findByPKs(MedSrvDO.class, srvIdSet.toArray(new String[0]));
			if(!ListUtil.isEmpty(srvList)){
				medsrvMap = MapUtils.convertListToMap(srvList, MedSrvDO.ID_SRV);
			}
		}
		
		//查询医嘱服务数据
		if(orsrvIdSet.size() > 0){
			List<OrdSrvDO> orsrvList = (List<OrdSrvDO>)daf.findByPKs(OrdSrvDO.class, orsrvIdSet.toArray(new String[0]));
			if(!ListUtil.isEmpty(orsrvList)){
				orsrvMap = MapUtils.convertListToMap(orsrvList, OrdSrvDO.ID_ORSRV);
			}
		}
		
		//计算服务价格
		Map<String, BdPriViewDTO> priMap = new HashMap<String, BdPriViewDTO>();
		if (srvIdSet.size() > 0){
			IBdPriCalService calService = ServiceFinder.find(IBdPriCalService.class);
			BdPriViewDTO[] priViewDtos = calService.calSrvPrice(
					srvIdSet.toArray(new String[0]),
					patPriIdSet.toArray(new String[0]));
			
			if(!ArrayUtil.isEmpty(priViewDtos)){
				priMap = (Map<String, BdPriViewDTO>) MapUtils
						.convertArrayToMap(priViewDtos, "Id_srv,Id_pripat");
			}
		}
		
		//计算药品价格
		Map<String, ReserveResultDTO> reserveMap = new HashMap<String, ReserveResultDTO>();
		if(reserveList.size() > 0){
			IMaterialStockService materialService = ServiceFinder.find(IMaterialStockService.class);
			ReserveResultDTO[] reserveRlt = materialService.getPreReserveMaterialsPrice(reserveList.toArray(new ReserveReqDTO[0]));
			reserveMap = (Map<String, ReserveResultDTO>)MapUtils.
					convertArrayToMap(reserveRlt, "Id_orsrv");
		}
		Map<String, GetMaterialPriceDTO> otMMMap = new HashMap<String,GetMaterialPriceDTO>();
		if(otMMHashSet.size() > 0){
			IMaterialBaseInfoService materialBaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
			for (String key : otMMHashSet) {
				String[] values = key.split(",");
				GetMaterialPriceDTO otMMRlt = materialBaseService.MaterialPriceForOt(values[0], values[1]);
				otMMMap.put(key, otMMRlt);
			}
		}
		
		List<BlOepChargePricingRltDTO> pricingRltList  = new ArrayList<BlOepChargePricingRltDTO>();
		for (BlOepChargePricingDTO pricingDto : dtos) {
			
			BlOepChargePricingRltDTO pricingRltDto = new BlOepChargePricingRltDTO();
			pricingRltDto.setId_orsrv(pricingDto.getId_orsrv());
			pricingRltDto.setId_srv(pricingDto.getId_srv());
			if(FBoolean.TRUE.equals(pricingDto.getFg_mm())){
				
				if(FBoolean.FALSE.equals(pricingDto.getFg_or())){
					String key = pricingDto.getId_mm() + "," + pricingDto.getSrvu();
					GetMaterialPriceDTO priceDto = otMMMap.get(key);
					if(priceDto != null){
						pricingRltDto.setPrice_std(PrecisionUtils.formatPrice(priceDto.getPrice_act()));
						pricingRltDto.setPrice_ratio(PrecisionUtils.formatPrice(priceDto.getPrice_act()));
					}
				}else{
					ReserveResultDTO reserveDto = reserveMap.get(pricingDto.getId_orsrv());
					if(reserveDto != null){
						pricingRltDto.setPrice_std(PrecisionUtils.formatPrice(reserveDto.getPrice_act()));
						pricingRltDto.setPrice_ratio(PrecisionUtils.formatPrice(reserveDto.getPrice_act()));
					}else{
						pricingRltDto.setPrice_std(FDouble.ZERO_DBL);
						pricingRltDto.setPrice_ratio(FDouble.ZERO_DBL);
					}
				}
			}else{
				MedSrvDO srvDO = medsrvMap.get(pricingDto.getId_srv());
				if(MedSrvBlModeEnum.MANUALBL == srvDO.getEu_blmd() && !StringUtil.isEmpty(pricingDto.getId_orsrv())){
					OrdSrvDO orsrvDO = orsrvMap.get(pricingDto.getId_orsrv());
					pricingRltDto.setPrice_ratio(orsrvDO.getPri());
					pricingRltDto.setPrice_std(orsrvDO.getPri());
				}else{
					String key = pricingDto.getId_srv() + pricingDto.getId_pripat();
					BdPriViewDTO priDto = priMap.get(key);
					if(priDto != null){
						pricingRltDto.setPrice_std(priDto.getPrice_std());
						pricingRltDto.setPrice_ratio(priDto.getPrice_ratio());
					}else{
						pricingRltDto.setPrice_std(FDouble.ZERO_DBL);
						pricingRltDto.setPrice_ratio(FDouble.ZERO_DBL);
					}
				}
			}
			pricingRltDto.setQuan(pricingDto.getQuan());
			pricingRltDto.setAmt_std(pricingRltDto.getPrice_std().multiply(pricingRltDto.getQuan(),IBlConst.PRECISION_AMOUNT));
			pricingRltDto.setAmt_ratio(pricingRltDto.getPrice_ratio().multiply(pricingRltDto.getQuan(),IBlConst.PRECISION_AMOUNT));
			pricingRltDto.setAmt(pricingRltDto.getAmt_ratio());
			pricingRltDto.setAmt_hp(FDouble.ZERO_DBL);
			pricingRltDto.setAmt_pat(FDouble.ZERO_DBL);
			pricingRltDto.setCode_inccaitm(null);
			pricingRltDto.setName_inccaitm(null);
			pricingRltDto.setCode_apply(null);
			
			pricingRltList.add(pricingRltDto);
		}
		
		return pricingRltList.toArray(new BlOepChargePricingRltDTO[0]);
	}
}
