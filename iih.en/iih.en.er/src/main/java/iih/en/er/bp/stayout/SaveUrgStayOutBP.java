package iih.en.er.bp.stayout;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.er.dto.d.UrgStayOutDTO;
import iih.en.er.ip.d.EnEntIpErDO;
import iih.en.er.ip.i.IEnentiperCudService;
import iih.en.er.ip.i.IEnentiperRService;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.i.IEnerpreCudService;
import iih.en.er.pre.i.IEnerpreRService;
import iih.en.pv.enres.d.EnEvtDO;
import iih.en.pv.enres.i.IEnevtCudService;
import iih.en.pv.enres.i.IEnevtRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存出急诊留观
 * 
 */
public class SaveUrgStayOutBP {
	/**
	 * 保存出急诊留观
	 * 
	 * @param urgstayout
	 * @return
	 * @throws BizException
	 */
	public UrgStayOutDTO exec(UrgStayOutDTO urgstayout)
			throws BizException {
		//1.保存数据表en_ent_ip_er
		this.saveEnEntIpEr(urgstayout);
		//2.更新en_erpre
		this.updateEnErpre(urgstayout);
		//3.调用出院的保存
		//4.发布就诊变更事件(待定)
		//this.saveEnEntEvt(urgstayout);
    	urgstayout.setStatus(DOStatus.UPDATED);
		return urgstayout;
	}
	
	/**
	 * 1.保存数据表en_ent_ip_er
	 * 
	 * @param urgstayout
	 * @throws BizException 
	 */
	private void saveEnEntIpEr(UrgStayOutDTO urgstayout) throws BizException {
		    EnEntIpErDO enEntIpErDO = null;
			IEnentiperRService serv = ServiceFinder.find(IEnentiperRService.class);
			EnEntIpErDO[] enEntIpErDOs = serv.findByAttrValString(EnEntIpErDO.ID_ENT, urgstayout.getId_ent());
			if(enEntIpErDOs == null || enEntIpErDOs.length<=0)
				return;
		enEntIpErDO = enEntIpErDOs[0];
		urgstayout.setId_erpre(enEntIpErDO.getId_erpre());
		
		enEntIpErDO.setStatus(DOStatus.UPDATED);
		enEntIpErDO.setDt_leave(urgstayout.getDt_leave());
		enEntIpErDO.setOut_sence(urgstayout.getOut_sensy());
		enEntIpErDO.setSd_gowhere_er(urgstayout.getName_out_gowhere());
		enEntIpErDO.setId_gowhere_er(urgstayout.getId_out_gowhere());
		enEntIpErDO.setEu_out_way(urgstayout.getName_out_way());
		IEnentiperCudService serv2 = ServiceFinder.find(IEnentiperCudService.class);
		serv2.save(new EnEntIpErDO[]{enEntIpErDO});
	}
	/**
	 * 2.更新en_erpre
	 * 
	 * @param urgstayout
	 * @throws BizException 
	 */
	private void updateEnErpre(UrgStayOutDTO urgstayout) throws BizException {
		EnErPreDO enerpredo = null;
		if(urgstayout.getId_erpre() == null)
			return;
		IEnerpreRService serv = ServiceFinder.find(IEnerpreRService.class);
		enerpredo = serv.findById(urgstayout.getId_erpre());
		if(enerpredo == null)
			return;
		enerpredo.setStatus(DOStatus.UPDATED);
		enerpredo.setSd_status_ip(IEnDictCodeConst.SD_STATUS_ERPRE_CANCEL);
		enerpredo.setDt_end(urgstayout.getDt_leave());
		IEnerpreCudService serv2 = ServiceFinder.find(IEnerpreCudService.class);
		serv2.save(new EnErPreDO[]{enerpredo});
	}
	/**
	 * 4.发布就诊变更事件(出院的时候才会写)
	 * 
	 * @param urgstayout
	 * @throws BizException 
	 */
	private void saveEnEntEvt(UrgStayOutDTO urgstayout) throws BizException {
		EnEvtDO evt = null;
		if(urgstayout.getStatus() == DOStatus.UPDATED){
			IEnevtRService serv = ServiceFinder.find(IEnevtRService.class);
			EnEvtDO[] enevts = serv.findByAttrValString(EnEvtDO.ID_ENT, urgstayout.getId_ent());
			if(enevts == null || enevts.length<=1)
				return;
			evt = enevts[0];
		}else{
			evt = new EnEvtDO();
			evt.setStatus(DOStatus.NEW);
			evt.setId_erpre(urgstayout.getId_erpre());
			evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_LVHOS);
		}
		evt.setDt_evt(EnAppUtils.getServerDateTime());
		evt.setDes("出院");
		IEnevtCudService serv2 = ServiceFinder.find(IEnevtCudService.class);
		serv2.save(new EnEvtDO[]{evt});
	}
	
}	
