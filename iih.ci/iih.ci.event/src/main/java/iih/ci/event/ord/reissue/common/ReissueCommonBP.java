package iih.ci.event.ord.reissue.common;

import com.enterprisewechat.cp.util.StringUtils;

import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.reissue.d.IEMsgReissueDTO;
import iih.ci.event.reissue.d.IEMsgReissueRstDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.ip.mapping.MappingService;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 组装返回数据的基类
 * @author zhangwq
 *
 */
public class ReissueCommonBP {
	protected MappingService mappingService;
	protected OPIPSendIECommonListener listener;
	protected IEMsgReissueDTO iEMsgReissueDTO;
	public void setiEMsgReissueDTO(IEMsgReissueDTO iEMsgReissueDTO) {
		this.iEMsgReissueDTO = iEMsgReissueDTO;
	}
	private CiOrderDO[] orders;
	public ReissueCommonBP(){
		mappingService = ServiceFinder.find(MappingService.class);
	}
	public CiOrderDO[] getOrders() {
		return orders;
	}
	public void setOrders(CiOrderDO[] orders) {
		this.orders = orders;
	}
	public String getIdors(){
		if(this.orders != null && this.orders.length >0){
			StringBuilder sb = new StringBuilder();
			for (CiOrderDO order : this.orders) {
				sb.append(String.format(",%s", order.getId_or()));
			}
			return sb.toString().substring(1);
		}
		return null;
	}
	
	public IEMsgReissueRstDTO asseble() throws BizException {
		String idors = this.getIdors();
		if(StringUtils.isEmpty(idors)){
			return null;
		}
		OrdEventFireDTO ordEventFireDTO = new OrdEventFireDTO();
		ordEventFireDTO.setIdors(idors);
		ordEventFireDTO.setIdent(this.getOrders()[0].getId_en());
		BaseDTO[] ieOpLisOrEnDtos = this.listener.assembleData(ordEventFireDTO);
		if(ieOpLisOrEnDtos == null || ieOpLisOrEnDtos.length == 0){
			return null;
		}
		return assembleData(ieOpLisOrEnDtos);
	}
	
	public BaseDTO[] getAssebleData() throws BizException {
		String idors = this.getIdors();
		if(StringUtils.isEmpty(idors)){
			return null;
		}
		OrdEventFireDTO ordEventFireDTO = new OrdEventFireDTO();
		ordEventFireDTO.setIdors(idors);
		ordEventFireDTO.setIdent(this.getOrders()[0].getId_en());
		BaseDTO[] ieOpLisOrEnDtos = this.listener.assembleData(ordEventFireDTO);
		return ieOpLisOrEnDtos;
	}
	
	protected IEMsgReissueRstDTO assembleData(BaseDTO[] baseDTOs)throws BizException{
		return null;
	}
}
