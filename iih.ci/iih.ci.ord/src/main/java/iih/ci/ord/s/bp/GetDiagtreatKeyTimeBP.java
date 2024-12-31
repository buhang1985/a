package iih.ci.ord.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.ci.ord.dto.blexorder.d.DiagTreatViewRntDataDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.mp.nr.foreign.d.GetTemDataParamDTO;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.temperaturechart.d.Temcharitemdto;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class GetDiagtreatKeyTimeBP {
	
	public FArrayList2 exec(OrSrvSplitParamDTO orparams)throws BizException{
		FArrayList2 result=new FArrayList2();
		if(orparams==null||orparams.getDt_split_start()==null)return null;
		DiagTreatViewRntDataDTO rntdto = new DiagTreatViewRntDataDTO();
		FDateTime start=null;
		FDateTime end=null;  
		start=(FDateTime)orparams.getDt_split_start();
		if(orparams.getDt_split_end()==null){
			
			FDateTime	e1=CiOrdAppUtils.getServerDateTime();
//			Date d=new Date(e1.getYear(),e1.getMonth(),e1.getDay(),23,59,59);
			String dstr=e1.getYear()+"-"+e1.getMonth()+"-"+e1.getDay()+" "+23+":"+59+":"+59;
			end=new FDateTime(dstr);
			}else{
				end=(FDateTime)orparams.getDt_split_end();
			}
		
		// 生命体征数据和临床事件
		IForeignService foreignservice = ServiceFinder.find(IForeignService.class);
		GetTemDataParamDTO tmpparam = new GetTemDataParamDTO();
		tmpparam.setId_ent(orparams.getId_ens());
		tmpparam.setDt_begin(start);
		tmpparam.setDt_end(end);
		tmpparam.setFg_temsheet(FBoolean.TRUE);
		Temcharitemdto[] temp1 = foreignservice.getTemData(tmpparam);
		Map<String,Object> map=new HashMap<>();
		if(temp1!=null) {
			for (Temcharitemdto t : temp1) {
				if(t.getCode_event()!=null) {
					String key=t.getLogtime().getDate().toString();
					if(!map.containsKey(key)) {
						map.put(key, t);
					    result.add(t.getLogtime().getDate());
					}
				}
			}
		}
		return result;
	}

}
