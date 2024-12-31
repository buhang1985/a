package iih.ci.ord.s.bp.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.cg.i.IBlOutCmdService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱完成时，组装数据,并调用费用停止计费
 * @author zhangwq
 *
 */
public class CompleteOrderBlOutCmdBP {
	public void exec(List<CiOrderDO> listOrder) throws BizException{
		//每个患者计费信息集合
		List<PatOrderMaxDtBlDTO> patList = new ArrayList<PatOrderMaxDtBlDTO>();
		//key:id_pat,value:每个患者的计费信息
		Map<String,PatOrderMaxDtBlDTO> teamMap = new HashMap<String,PatOrderMaxDtBlDTO>();
		for (CiOrderDO ciOrderDO : listOrder) {
			if(teamMap.containsKey(ciOrderDO.getId_pat())){
				teamMap.get(ciOrderDO.getId_pat()).getId_ors().add(ciOrderDO.getId_or());
				if(teamMap.get(ciOrderDO.getId_pat()).getMaxDtBl().compareTo(ciOrderDO.getDt_end())<=0){
					teamMap.get(ciOrderDO.getId_pat()).setMaxDtBl(ciOrderDO.getDt_end());
				}
			}else{
				PatOrderMaxDtBlDTO patBlDto = new PatOrderMaxDtBlDTO();
				patBlDto.setId_pat(ciOrderDO.getId_pat());
				patBlDto.getId_ors().add(ciOrderDO.getId_or());
				patBlDto.setMaxDtBl(ciOrderDO.getDt_end());
				teamMap.put(ciOrderDO.getId_pat(), patBlDto);
				patList.add(patBlDto);
			}
			
		}
		
		if(patList.size()>0){
			IBlOutCmdService blOutCmdService = ServiceFinder.find(IBlOutCmdService.class);
			for(PatOrderMaxDtBlDTO patBlDto:patList){
				blOutCmdService.chargePrnOrd(patBlDto.getId_pat(), patBlDto.getId_ors().toArray(new String[0]), patBlDto.getMaxDtBl());
			}
		}	
	}
	class PatOrderMaxDtBlDTO{
		private String id_pat;
		private List<String> id_ors;
		private FDateTime maxDtBl;//最大记账日期
		public PatOrderMaxDtBlDTO(){
			id_ors = new ArrayList<String>();
			this.maxDtBl = new FDateTime();
		}
		public String getId_pat() {
			return id_pat;
		}
		public void setId_pat(String id_pat) {
			this.id_pat = id_pat;
		}
		public List<String> getId_ors() {
			return id_ors;
		}
		public void setId_ors(List<String> id_ors) {
			this.id_ors = id_ors;
		}
		public FDateTime getMaxDtBl() {
			return maxDtBl;
		}
		public void setMaxDtBl(FDateTime maxDtBl) {
			this.maxDtBl = maxDtBl;
		}
		
		
	}
}
