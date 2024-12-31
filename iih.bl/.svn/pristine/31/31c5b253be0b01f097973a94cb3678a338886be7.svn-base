package iih.bl.st.ip.s.bp;

import iih.bl.st.blcgipdto.d.BlStBaseInfo;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 
 * @author xy.zhou
 * @date 2018年6月29日
 */
public class DoIpCancelSettleBP {

	public FBoolean exec(InsureContext insureContext,BlStBaseInfo blStBaseInfo) throws BizException {
		//1.删除结算数据
		IBlstipCudService stService = ServiceFinder.find(IBlstipCudService.class);
		IBlstipRService iBlstipRService= ServiceFinder.find(IBlstipRService.class);
		BlStIpDO blStIpDO = iBlstipRService.findById(blStBaseInfo.getId_st());
		blStIpDO.setStatus(DOStatus.DELETED);
		stService.delete(new BlStIpDO[] { blStIpDO });
		
		//2.修改记账数据	
		String udtSql = "update bl_cg_ip set fg_st = 'N',id_stip = null,dt_st = null"
				+ " where id_stip = '" + blStIpDO.getId_stip() + "'";
		new DAFacade().execUpdate(udtSql);
		//3.如果是出院结算，修改就诊表信息		
		if (StTypeEnum.ST_INP.equals(blStIpDO.getEu_sttp())) {
			//无论母婴是否结算，则取消结算时，只修改母亲的就诊结算状态
			IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
			PatiVisitDO patiVisitDO = entService.findById(blStIpDO.getId_ent());
			IPativisitCudService entCService = ServiceFinder.find(IPativisitCudService.class);
			patiVisitDO.setFg_st(FBoolean.FALSE);
			patiVisitDO.setStatus(DOStatus.UPDATED);
			entCService.save(new PatiVisitDO[] { patiVisitDO });		
		}
		//4、如果有医保，处理下医保分摊数据，这里做红冲操作
		if(insureContext!=null && !insureContext.getIdHp().isEmpty()){
			HisPropertyRefHpDTO hisPropertyDto=new HisPropertyRefHpDTO();
			hisPropertyDto.setId_refold(blStIpDO.getId_stip());
			//医保分摊数据红冲
			InsureFacade facade=new InsureFacade(insureContext);
			facade.savePreFlowBackPropData(hisPropertyDto);
		}
		return FBoolean.TRUE;
	}
}
