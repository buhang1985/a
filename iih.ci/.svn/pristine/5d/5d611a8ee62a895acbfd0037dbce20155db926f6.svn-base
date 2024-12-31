package iih.ci.preop.order.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.tsip.d.CitsorderAggDO;
import iih.ci.tsip.i.ICitsorderRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 复制动作
 * @author zhangwq
 *
 */
public class OrderCopyAction {
	public OrderRstDTO copy(CiEnContextDTO ctx,OrderOperateDTO param) throws BizException{
		return this.exec(ctx, (String[])param.getDocument().toArray(new String[0]));
	}
	public OrderRstDTO exec(CiEnContextDTO ctx,String[] id_ors) throws BizException{
		OrderRstDTO rstDTO = new OrderRstDTO();
		ICitsorderRService citsOrderService = ServiceFinder.find(ICitsorderRService.class);
		CitsorderAggDO[] tsOrderAggs = citsOrderService.findByIds(id_ors, FBoolean.FALSE);
		Map<String,List<CitsorderAggDO>> classifcationOrders = classificationOrders(tsOrderAggs);
		if(classifcationOrders == null){
			rstDTO.setIsSuccess(FBoolean.FALSE);
			rstDTO.setMessageInfo("没有可复制的数据");
			return rstDTO;
		}
	
		for(String key : classifcationOrders.keySet()){
			List<CitsorderAggDO> orderAggs = classifcationOrders.get(key);
			String sd_srvtp = orderAggs.get(0).getParentDO().getSd_srvtp();
			BasePreopCopyBP copybp = this.getCopyBp(sd_srvtp);
			if(copybp != null){
				OrderRstDTO singleRst = copybp.copy(ctx, orderAggs);

				String messageInfo = rstDTO.getMessageInfo();
				messageInfo=((StringUtils.isEmpty(messageInfo)||"null".equals(messageInfo)?"":messageInfo)+
						(StringUtils.isEmpty(singleRst.getMessageInfo()) ? "" : singleRst.getMessageInfo()));
				
				rstDTO.setMessageInfo(messageInfo);
				rstDTO.setIsSuccess(new FBoolean((rstDTO.getIsSuccess()==null||FBoolean.TRUE.equals(rstDTO.getIsSuccess()))&&FBoolean.TRUE.equals(singleRst.getIsSuccess())));
				rstDTO.setDocument(singleRst.getDocument());
				FMap2 singleErrorMap2 = singleRst.getExtension();
				if(singleErrorMap2 != null && singleErrorMap2.containsKey("errorEmsList")){
					if(rstDTO.getExtension() != null && rstDTO.getExtension().containsKey("errorEmsList")){
						FArrayList errorList = (FArrayList)rstDTO.getExtension().get("errorEmsList");
						errorList.addAll((FArrayList)singleErrorMap2.get("errorEmsList"));
					}else{
						FMap2 errorMap2 = new FMap2();
						errorMap2.put("errorEmsList",(FArrayList)singleErrorMap2.get("errorEmsList"));
						rstDTO.setExtension(errorMap2);
					}
				}
			}
		}
		return rstDTO;
	}
	/**
	 * 通过服务类型归类
	 * @param tsOrderAggs
	 * @return
	 */
	private Map<String,List<CitsorderAggDO>> classificationOrders(CitsorderAggDO[] tsOrderAggs)
	{
		if(tsOrderAggs == null || tsOrderAggs.length ==0){
			return null;
		}
		Map<String,List<CitsorderAggDO>> map = new HashMap<String,List<CitsorderAggDO>>();
		for (CitsorderAggDO citsorderAggDO : tsOrderAggs) {
			String sd_srvtp = citsorderAggDO.getParentDO().getSd_srvtp();
			String subTp = sd_srvtp.substring(0, 2);
			if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)){
				subTp = IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI;
			}
			if(map.containsKey(subTp)){
				map.get(subTp).add(citsorderAggDO);
			}else{
				List<CitsorderAggDO> list = new ArrayList<CitsorderAggDO>();
				list.add(citsorderAggDO);
				map.put(subTp,list);
			}
		}
		return map;
	}
	private BasePreopCopyBP getCopyBp(String sd_srvtp){
		if(CopyBPMap.containsKey(sd_srvtp)){
			return CopyBPMap.get(sd_srvtp);
		}
		return null;
	}
	private Map<String,BasePreopCopyBP> CopyBPMap = new HashMap<String,BasePreopCopyBP>()
	{
		{
			put(IBdSrvDictCodeConst.SD_SRVTP_LIS,new LisPreopCopyBP());
			put(IBdSrvDictCodeConst.SD_SRVTP_RIS,new RisPreopCopyBP());
			put(IBdSrvDictCodeConst.SD_SRVTP_TREAT,new TreatPreopCopyBP());
		}
	};
}
