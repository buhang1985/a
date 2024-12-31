package iih.bl.st.s.bp;

import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 住院取消结算BP
 * 
 * @author liwq
 *
 */
public class DoIpCancelSettlementBP {

	public FBoolean exec(BlStIpDO blStIpDO) throws BizException {
		//1.删除结算数据
		IBlstipCudService stService = ServiceFinder.find(IBlstipCudService.class);
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
		return FBoolean.TRUE;
	}
}
