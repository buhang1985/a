package iih.ci.ord.nursorder;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

public class NursOrderControlBP {
	public EmsRstDTO[] exec(CiEnContextDTO ctx, CiOrderDO[] orders) throws BizException{
		NursOrderTreatSaveBP treatbp = new NursOrderTreatSaveBP();
		NursOrderTreatUpdateBP updatebp = new NursOrderTreatUpdateBP();
		List<EmsRstDTO> rstList = new ArrayList<EmsRstDTO>();
		for(int i = 0;i<orders.length;i++){
			CiOrderDO order = orders[i];
			EmsRstDTO rst = new EmsRstDTO();
			if(order.getStatus()==DOStatus.NEW){
				rst = treatbp.save(ctx, order);
			}else{
				rst = updatebp.save(ctx, order);
			}
			rstList.add(rst);
		}
		return rstList.toArray(new EmsRstDTO[0]);
	}
}
