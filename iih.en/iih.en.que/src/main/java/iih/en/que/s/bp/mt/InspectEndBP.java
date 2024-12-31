package iih.en.que.s.bp.mt;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.s.bp.EnQueBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查完毕
 * @author Administrator
 *
 */
public class InspectEndBP {
	/**
	 * 检查完毕
	 * @param appDTO 检查申请DTO
	 * @throws BizException
	 */
	public void exec(MedTechAppDTO appDTO) throws BizException {
		if(appDTO==null){
			throw new BizException("参数appDTO为null!");
		}
		if(EnValidator.isEmpty(appDTO.getId_or())){
			throw new BizException("没有找到MedTechAppDTO的医嘱id");
		}
		//1、更新队列
		EnQueBP enQueBP = new EnQueBP();
		enQueBP.updateStatus(appDTO.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_FINCHECKED);
		//2、更新医嘱状态
		ICiOrdQryService iciOrdService = ServiceFinder.find(ICiOrdQryService.class);
		iciOrdService.TransferStatusUpdates(appDTO.getId_or(), ICiDictCodeConst.SD_CI_OBS_YJC);
	}
	
	/**
	 * 通用分诊--检查完毕
	 * @param appDTO 检查申请DTO
	 * @throws BizException
	 */
	public void execAllQueue(MedTechAppDTO appDTO) throws BizException {
		if(appDTO==null){
			throw new BizException("参数appDTO为null!");
		}
		EnQueBP enQueBP = new EnQueBP();
		enQueBP.updateStatus(appDTO.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_FINCHECKED);
	}
}
