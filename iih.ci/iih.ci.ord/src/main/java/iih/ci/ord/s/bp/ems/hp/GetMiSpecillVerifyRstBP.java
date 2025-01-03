package iih.ci.ord.s.bp.ems.hp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.mi.common.utils.MiEnContextUtil;
import iih.ci.mi.ord.i.ICiMiOrdRService;
import iih.ci.mi.ord.i.meta.OrdSpecillParamDTO;
import iih.ci.mi.ord.i.meta.OrdSpecillRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillParamDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取特殊病判断结果
 * @author HUMS
 *
 */
public class GetMiSpecillVerifyRstBP {
	
	private ICiMiOrdRService ciMiOrdRService ; 
	public GetMiSpecillVerifyRstBP(){
		ciMiOrdRService = ServiceFinder.find(ICiMiOrdRService.class);
	}
	
	public OrdSpecillRstDTO getMiSpecillRst(CiEnContextDTO ctx, CiOrAggAndRelDatum ordData) throws BizException{
		
		// 非特殊病患者不进行特殊病判断
		if(!MiEnContextUtil.IsHpSpecillPat(ctx)){
			return null;
		}
		
		List<OrdSpecillParamDTO> orderParamList = new ArrayList<OrdSpecillParamDTO>();;
		
		CiorderAggDO orderAgg = ordData.getOraggdo();
		FMap ordSrvMmMap = null;
		if (!CiOrdUtils.isEmpty(ordData.getOrattachht()))
			ordSrvMmMap = (FMap) ordData.getOrattachht().get(OrdSrvMmDODesc.CLASS_FULLNAME);
		
		CiOrderDO order = orderAgg.getParentDO();
		OrdSrvDO[] ordSrvs = orderAgg.getOrdSrvDO();
		
		OrdSpecillParamDTO ordSpecill = new OrdSpecillParamDTO();
		ordSpecill.setId_or(order.getId_or());
		ordSpecill.setCode_or(order.getCode_or());
		ordSpecill.setName_or(order.getName_or());
		ordSpecill.setSd_srvtp(order.getSd_srvtp());
		ordSpecill.setId_srv(order.getId_srv());
		
		for(OrdSrvDO ordSrv : ordSrvs){
			
			if(ordSrv.getId_srv().equals(ordSpecill.getId_srv())){
				ordSpecill.setCode_srv(ordSrv.getCode_srv());
				ordSpecill.setName_srv(ordSrv.getName_srv());
			}
			
			if(ordSrv.getStatus() == DOStatus.DELETED){
				continue;					
			}
			
			// 非医保不校验特殊病
			if(!HpJudgeRstEnum.HP.equals(ordSrv.getEu_orsrvhp())){
				continue;
			}
			
			OrdSrvSpecillParamDTO ordSrvSpecill = new OrdSrvSpecillParamDTO();
			
			ordSrvSpecill.setId_or(order.getId_or());
			ordSrvSpecill.setId_orsrv(ordSrv.getId_orsrv());
			ordSrvSpecill.setSd_srvtp(ordSrv.getSd_srvtp());
			
			ordSrvSpecill.setId_srv(ordSrv.getId_srv());
			ordSrvSpecill.setCode_srv(ordSrv.getCode_srv());
			ordSrvSpecill.setName_srv(ordSrv.getName());
			
			ordSrvSpecill.setId_dsdef(ordSrv.getId_dsdef());
			ordSrvSpecill.setCode_dsdef(ordSrv.getCode_dsdef());
			ordSrvSpecill.setName_dsdef(ordSrv.getName_dsdef());
			
			ordSrvSpecill.setFg_bl(ordSrv.getFg_bl());
			ordSrvSpecill.setFg_or(ordSrv.getFg_or());
			ordSrvSpecill.setFg_self(ordSrv.getFg_self());
			ordSrvSpecill.setEu_orsrvhp(ordSrv.getEu_orsrvhp());			
			
			if(FBoolean.TRUE.equals(ordSrv.getFg_mm()) && ordSrvMmMap != null){
				
				@SuppressWarnings("unchecked")
				OrdSrvMmDO ordSrvMm = ((List<OrdSrvMmDO>)ordSrvMmMap.get(ordSrv.getId_srv() + "_"+ ordSrv.getId_mm())).get(0);			
			
				ordSrvSpecill.setId_mm(ordSrvMm.getId_mm());
				ordSrvSpecill.setCode_mm(ordSrvMm.getCode_mm());
				ordSrvSpecill.setName_mm(ordSrvMm.getName_mm());
				
			}
			
			ordSpecill.addChild(ordSrvSpecill);
		}
		
		
		if(ordSpecill.getChildSzie() == 0 ){
			return null;
		}
	
		orderParamList.add(ordSpecill);
		List<OrdSpecillRstDTO> orderRstList = ciMiOrdRService.getPatSpecillVerify(ctx, orderParamList);
		return orderRstList.get(0);
	}
	
	/**
	 * 获取医嘱的特殊病判断结果
	 * @param ctx
	 * @param ordAggs
	 * @return
	 * @throws BizException
	 */
	public List<OrdSpecillRstDTO> getMiSpecillRsts(CiEnContextDTO ctx,CiorderAggDO[] ordAggs) throws BizException{
		
		// 非特殊病患者不进行特殊病判断
		if(!MiEnContextUtil.IsHpSpecillPat(ctx)){
			return null;
		}
		
		Map<String, OrdSrvMmDO> ordSrvMmMap = getOrdSrvMmMap(ordAggs);
		if(ordSrvMmMap.size() ==0){
			return null;
		}
		
		List<OrdSpecillParamDTO> orderParamList = new ArrayList<OrdSpecillParamDTO>();
		
		for(CiorderAggDO orderAgg : ordAggs){
			
			CiOrderDO order = orderAgg.getParentDO();
			OrdSrvDO[] ordSrvs = orderAgg.getOrdSrvDO();
			
			OrdSpecillParamDTO ordSpecill = new OrdSpecillParamDTO();
			ordSpecill.setId_or(order.getId_or());
			ordSpecill.setCode_or(order.getCode_or());
			ordSpecill.setName_or(order.getName_or());
			ordSpecill.setSd_srvtp(order.getSd_srvtp());
			ordSpecill.setId_srv(order.getId_srv());
			
			for(OrdSrvDO ordSrv : ordSrvs){
				
				if(ordSrv.getId_srv().equals(ordSpecill.getId_srv())){
					ordSpecill.setCode_srv(ordSrv.getCode_srv());
					ordSpecill.setName_srv(ordSrv.getName_srv());
				}
				
				if(ordSrv.getStatus() == DOStatus.DELETED){
					continue;					
				}
				
				OrdSrvSpecillParamDTO ordSrvSpecill = new OrdSrvSpecillParamDTO();
				
				ordSrvSpecill.setId_or(order.getId_or());
				ordSrvSpecill.setId_orsrv(ordSrv.getId_orsrv());
				ordSrvSpecill.setSd_srvtp(ordSrv.getSd_srvtp());
				
				ordSrvSpecill.setId_srv(ordSrv.getId_srv());
				ordSrvSpecill.setCode_srv(ordSrv.getCode_srv());
				ordSrvSpecill.setName_srv(ordSrv.getName());
				
				ordSrvSpecill.setId_dsdef(ordSrv.getId_dsdef());
				ordSrvSpecill.setCode_dsdef(ordSrv.getCode_dsdef());
				ordSrvSpecill.setName_dsdef(ordSrv.getName_dsdef());
				
				ordSrvSpecill.setFg_bl(ordSrv.getFg_bl());
				ordSrvSpecill.setFg_or(ordSrv.getFg_or());
				ordSrvSpecill.setFg_self(ordSrv.getFg_self());
				ordSrvSpecill.setEu_orsrvhp(ordSrv.getEu_orsrvhp());			
				
				if(FBoolean.TRUE.equals(ordSrv.getFg_mm()) && ordSrvMmMap != null){
					
					OrdSrvMmDO ordSrvMm = ordSrvMmMap.get(ordSrv.getId_orsrv());			
				
					ordSrvSpecill.setId_mm(ordSrvMm.getId_mm());
					ordSrvSpecill.setCode_mm(ordSrvMm.getCode_mm());
					ordSrvSpecill.setName_mm(ordSrvMm.getName_mm());
				}
				
				ordSpecill.addChild(ordSrvSpecill);
			}
			if(ordSpecill.getChildSzie() == 0 ){
				continue;
			}
			orderParamList.add(ordSpecill);
		}
		
		List<OrdSpecillRstDTO> orderRstList = ciMiOrdRService.getPatSpecillVerify(ctx, orderParamList);
		return orderRstList;
	}

	/**
	 * 获取医疗服务物品
	 * @param ordAggs 医嘱集合
	 * @return
	 * @throws BizException
	 */
	private Map<String, OrdSrvMmDO> getOrdSrvMmMap(CiorderAggDO[] ordAggs) throws BizException {

		Map<String, OrdSrvMmDO> map= new HashMap<String, OrdSrvMmDO>();
		
		FArrayList idOrsrvList = new FArrayList();
		for(CiorderAggDO orderAgg : ordAggs){
			
			OrdSrvDO[] ordSrvs = orderAgg.getOrdSrvDO();
			for(OrdSrvDO ordSrv : ordSrvs){
				
				if(ordSrv.getStatus() == DOStatus.DELETED || !FBoolean.TRUE.equals(ordSrv.getFg_bl())){
					continue;					
				}
				
				if(FBoolean.TRUE.equals(ordSrv.getFg_self())){
					continue;
				}
				
				// 费用关联出来的药品不做开单校验，费用关联出来的物品，fg_or=N 
				if(!FBoolean.TRUE.equals(ordSrv.getFg_or()) && FBoolean.TRUE.equals(ordSrv.getFg_mm())){
					continue;
				}				
				
				idOrsrvList.add(ordSrv.getId_orsrv());
			}
		}
		
		OrdSrvMmDO[] ordSrvMms = CiOrdAppUtils.getOrSrvMmQryService().findByAttrValList("Id_orsrv", idOrsrvList);
		if(ordSrvMms == null || ordSrvMms.length ==0){
			return map;	
		}
		
		for(OrdSrvMmDO ordSrvMm : ordSrvMms){
			map.put(ordSrvMm.getId_orsrv(), ordSrvMm);
		}
		
		return map;
	}
}
