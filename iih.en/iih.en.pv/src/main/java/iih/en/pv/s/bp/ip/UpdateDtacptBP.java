package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.i.external.provide.ICiOrdEnService;
import iih.en.comm.ep.EnEvtEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.out.d.EnEvtDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.pv.s.event.IpModifyEntryAcptEnevt;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 修改入院、入科接收时间
 * 
 * @author fanlq
 *
 */
public class UpdateDtacptBP {
/***
 * 
 * @param newregInfoDTO
 * @param oldregInfoDTO
 * @throws BizException 
 */
	public void exec(IpRegInfoDTO newregInfoDTO,IpRegInfoDTO oldregInfoDTO) throws BizException{
		if(newregInfoDTO == null || oldregInfoDTO == null){
			return;
		}
		if(newregInfoDTO.getDt_entry() == null || newregInfoDTO.getDt_acpt() == null){
			return;
		}
		//1.校验入院时间是否在入科接收时间之前
		this.dtEntryIsBeforAcpt(newregInfoDTO);
		//2.校验修改入院日期是否是当天
		this.dtEntryIsSame(newregInfoDTO,oldregInfoDTO);
		//3.校验修改入科接收日期是否是当天
		this.dtAcptIsSame(newregInfoDTO, oldregInfoDTO);
		//4.调用医嘱，校验是否有开立的医嘱
		this.checkOrder(newregInfoDTO);
		//5.修改en_en表
		this.updateEnt(newregInfoDTO);
		//6.插入就诊事件
		Integer count = 0;
		if(FDateTime.getSecondsBetween(oldregInfoDTO.getDt_entry(), newregInfoDTO.getDt_entry())!=0){
			this.sendEntryEnevt(new  EnEvtEP(), newregInfoDTO, oldregInfoDTO);
			count++;
		}
		if(FDateTime.getSecondsBetween(oldregInfoDTO.getDt_acpt(), newregInfoDTO.getDt_acpt())!=0){
			this.sendAcptEnevt(new  EnEvtEP(), newregInfoDTO, oldregInfoDTO);
			count++;
		}
		//7.发送修改入科时间、入院时间消息 
		if(count!=0){
			new IpModifyEntryAcptEnevt().invoke(newregInfoDTO);
		}
	}
	
	/***
	 * 校验入院时间是否在入科接收时间之前
	 * 
	 * @param newregInfoDTO
	 * @throws BizException
	 */
	private void dtEntryIsBeforAcpt(IpRegInfoDTO newregInfoDTO) throws BizException{
		if(newregInfoDTO.getDt_entry().after(newregInfoDTO.getDt_acpt())){
			throw new BizException("入院登记时间在入科接收之间之后，不能修改！");
		}
	}
	
	/***
	 * 校验入院登记时间
	 * @param newregInfoDTO
	 * @param oldregInfoDTO
	 * @return
	 * @throws BizException 
	 */
	private void dtEntryIsSame(IpRegInfoDTO newregInfoDTO,IpRegInfoDTO oldregInfoDTO) throws BizException{
		FDate date = oldregInfoDTO.getDt_entry().getDate();
		if(newregInfoDTO.getDt_entry().getDate().isSameDate(date)){
			return;
		}
		   throw new BizException("入院登记时间和原入院登记时间是不是同一天，不能修改！");
	}
	/***
	 * 校验入科接收时间
	 * @param newregInfoDTO
	 * @param oldregInfoDTO
	 * @return
	 * @throws BizException 
	 */
	private void dtAcptIsSame(IpRegInfoDTO newregInfoDTO,IpRegInfoDTO oldregInfoDTO) throws BizException{
		FDate date = oldregInfoDTO.getDt_acpt().getDate();
		if(newregInfoDTO.getDt_acpt().getDate().isSameDate(date)){
			return;
		}
			throw new BizException("入科接收时间和原入科接收时间是不是同一天，不能修改！");
	}
	/***
	 * 调用医嘱，校验是否有开立的医嘱
	 * @param newregInfoDTO
	 * @throws BizException
	 */
	private void checkOrder(IpRegInfoDTO newregInfoDTO) throws BizException{
		if(EnValidator.isEmpty(newregInfoDTO.getId_ent()) || newregInfoDTO.getDt_acpt() == null){
			throw new BizException("未找到就诊！");
		}
		ICiOrdEnService service = ServiceFinder.find(ICiOrdEnService.class);
		service.checkLiveOrdBeforeDtAcpt(newregInfoDTO.getId_ent(), newregInfoDTO.getDt_acpt());
	}
	
	/***
	 * 修改患者就诊表入院登记时间和入科接收时间
	 * @param newregInfoDTO
	 * @throws BizException
	 */
	private void updateEnt(IpRegInfoDTO newregInfoDTO) throws BizException{
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		IPativisitCudService cudservice = ServiceFinder.find(IPativisitCudService.class);
		PatiVisitDO entDO = service.findById(newregInfoDTO.getId_ent());
		entDO.setDt_entry(newregInfoDTO.getDt_entry());
		entDO.setDt_insert(newregInfoDTO.getDt_entry());
		entDO.setDt_acpt(newregInfoDTO.getDt_acpt());
		entDO.setStatus(DOStatus.UPDATED);
		cudservice.save(new PatiVisitDO[]{entDO});
	}
	/***
	 * 发送入院时间修改信息
	 * @param newregInfoDTO
	 * @throws BizException
	 */
	private void sendEntryEnevt(EnEvtEP ep,IpRegInfoDTO newregInfoDTO,IpRegInfoDTO oldregInfoDTO) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(newregInfoDTO.getId_ent());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_MODIFY_ENTRY);
		evt.setShort_des("修改入院时间");
		evt.setDes(" 患者编码："+newregInfoDTO.getCode_pat()+" 入院时间修改前："+oldregInfoDTO.getDt_entry()+",入院时间修改后："+newregInfoDTO.getDt_entry()+"");
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setVal_old(oldregInfoDTO.getDt_entry().toString());
		evt.setVal_new(newregInfoDTO.getDt_entry().toString());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
		
	}
	/***
	 * 发送入科时间修改信息
	 * @param newregInfoDTO
	 * @throws BizException
	 */
	private void sendAcptEnevt(EnEvtEP ep,IpRegInfoDTO newregInfoDTO,IpRegInfoDTO oldregInfoDTO) throws BizException{
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(newregInfoDTO.getId_ent());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_MODIFY_ACPT);
		evt.setShort_des("修改入科时间");
		evt.setDes(" 患者编码："+newregInfoDTO.getCode_pat()+" 入科时间修改前："+oldregInfoDTO.getDt_acpt()+",入科时间修改后："+newregInfoDTO.getDt_acpt()+"");
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDt_insert(evt.getDt_evt());
		evt.setVal_old(oldregInfoDTO.getDt_acpt().toString());
		evt.setVal_new(newregInfoDTO.getDt_acpt().toString());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[]{evt});
		
	}
}
