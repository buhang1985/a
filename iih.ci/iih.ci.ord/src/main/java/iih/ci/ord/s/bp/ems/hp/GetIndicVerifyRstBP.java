package iih.ci.ord.s.bp.ems.hp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mysql.jdbc.StringUtils;

import iih.ci.mi.ord.i.ICiMiOrdRService;
import iih.ci.mi.ord.i.meta.OrdIndicParamDTO;
import iih.ci.mi.ord.i.meta.OrdIndicRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvIndicParamDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordext.d.HpJudgeEnum;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetIndicVerifyRstBP {

	private ICiMiOrdRService ciMiOrdRService ; 
	public GetIndicVerifyRstBP(){
		ciMiOrdRService = ServiceFinder.find(ICiMiOrdRService.class);
	}
	
	public OrdIndicRstDTO getIndicRst(CiEnContextDTO ctx, CiOrAggAndRelDatum orAggAndRelDatum) throws BizException{
		CiorderAggDO orderAgg = orAggAndRelDatum.getOraggdo();
		FMap ordSrvMmMap = null;
		if (!CiOrdUtils.isEmpty(orAggAndRelDatum.getOrattachht()))
			ordSrvMmMap = (FMap) orAggAndRelDatum.getOrattachht().get(OrdSrvMmDODesc.CLASS_FULLNAME);
		
		CiOrderDO order = orderAgg.getParentDO();
		OrdSrvDO[] ordSrvs = orderAgg.getOrdSrvDO();
		
		OrdIndicParamDTO ordIndic = new OrdIndicParamDTO();
		String id_or = order.getId_or();
		if(StringUtils.isNullOrEmpty(id_or)){
			id_or =UUID.randomUUID().toString();
		}
		ordIndic.setId_or(order.getId_or());
		ordIndic.setCode_or(order.getCode_or());
		ordIndic.setName_or(order.getName_or());
		ordIndic.setSd_srvtp(order.getSd_srvtp());
		ordIndic.setId_srv(order.getId_srv());
		//ordIndic.setCode_srv(order.getCode_srv());
		//ordIndic.setName_srv(order.getCode_srv());
		
		ordIndic.setEu_orhp(order.getEu_orhp());
		ordIndic.setEu_hpjudge(order.getEu_hpjudge());
		
		ordIndic.setEu_orsrcmdtp(order.getEu_orsrcmdtp());
		
		for(OrdSrvDO ordSrv : ordSrvs){
			if(ordSrv.getId_srv().equals(ordIndic.getId_srv())){
				ordIndic.setCode_srv(ordSrv.getCode_srv());
				ordIndic.setName_srv(ordSrv.getName_srv());
			}
			
			if((ordSrv.getDs() != null && ordSrv.getDs() != 0 || ordSrv.getStatus() == DOStatus.DELETED )){
				continue;					
			}
			
			OrdSrvIndicParamDTO ordSrvIndic = new OrdSrvIndicParamDTO();
			
			ordSrvIndic.setId_or(id_or);
			ordSrvIndic.setId_orsrv(ordSrv.getId_orsrv());
			ordSrvIndic.setSd_srvtp(ordSrv.getSd_srvtp());
			
			ordSrvIndic.setId_srv(ordSrv.getId_srv());
			ordSrvIndic.setCode_srv(ordSrv.getCode_srv());
			ordSrvIndic.setName_srv(ordSrv.getName());
			ordSrvIndic.setPrice(ordSrv.getPri());
			
			ordSrvIndic.setFg_self(ordSrv.getFg_self());
			ordSrvIndic.setFg_selfsrv(ordSrv.getFg_selfsrv());
			ordSrvIndic.setFg_bl(ordSrv.getFg_bl());
			
			if(FBoolean.TRUE.equals(ordSrv.getFg_bl()) ){
				if(HpJudgeRstEnum.SELFPAY.equals(order.getEu_orhp()) && HpJudgeEnum.DOCTOR_JUDGE.equals(order.getEu_hpjudge())){
					
					ordIndic.setEu_hpjudge(HpJudgeEnum.DOCTOR_JUDGE);
					ordIndic.setEu_orhp(HpJudgeRstEnum.SELFPAY);
					
					ordSrv.setEu_hpjudge(HpJudgeEnum.DOCTOR_JUDGE);
					ordSrv.setEu_orsrvhp(HpJudgeRstEnum.SELFPAY);	
				}				
			}
			ordSrvIndic.setEu_hpjudge(ordSrv.getEu_hpjudge());
			ordSrvIndic.setEu_orsrvhp(ordSrv.getEu_orsrvhp());
			
			if (FBoolean.TRUE.equals(ordSrv.getFg_mm()) && ordSrvMmMap != null) {
				String idsrvmm = ordSrv.getId_srv() + "_" + ordSrv.getId_mm();
				if (ordSrvMmMap.containsKey(idsrvmm) && ordSrvMmMap.get(idsrvmm) != null) {
					@SuppressWarnings("unchecked")
					OrdSrvMmDO ordSrvMm = ((List<OrdSrvMmDO>) ordSrvMmMap.get(idsrvmm)).get(0);

					ordSrvIndic.setId_mm(ordSrvMm.getId_mm());
					ordSrvIndic.setCode_mm(ordSrvMm.getCode_mm());
					ordSrvIndic.setName_mm(ordSrvMm.getName_mm());
					ordSrvIndic.setPrice(ordSrvMm.getPrice_pgku_cur());
				}
			}
			
			ordIndic.addChild(ordSrvIndic);
		}
		
		if(ordIndic.getChildSzie() == 0 ){
			return null;
		}
	
		List<OrdIndicParamDTO> orderList = new ArrayList<OrdIndicParamDTO>();
		orderList.add(ordIndic);
		List<OrdIndicRstDTO> ordIndicRstList = ciMiOrdRService.checkIndicationRule(ctx, orderList);
		return ordIndicRstList.get(0);
		
	}
	
}
