package iih.en.ip.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.d.AptipAggDO;
import iih.sc.apt.aptip.i.IAptipCudService;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import iih.sc.apt.aptip.i.IAptipRService;
import iih.sc.apt.dto.d.AptIpDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 取消入院通知单
 * @author renying
 *
 */
public class CancAptIpBP {
	/**
	 * 取消入院通知单-删除
	 * 
	 * @param entipntDTO
	 * @param entId
	 * @throws BizException
	 */
	public void exec(AptIpDTO aptIpDTO) throws BizException {		
		EnValidator.validateParam("申请单主键", aptIpDTO.getId_scaptip());
		IAptipRService rService = ServiceFinder.find(IAptipRService.class);		
		IAptipCudService service = ServiceFinder.find(IAptipCudService.class);
		AptipAggDO aggdo = rService.findById(aptIpDTO.getId_scaptip());	
		service.delete(new AptipAggDO[] { aggdo });
		return;
	}
	
	/**
	 * 取消入院申请单-修改状态
	 * @param aptIpId
	 * @throws BizException
	 */
	public void canc(String aptIpId) throws BizException{
		
		IAptipMDOCudService iCudService = ServiceFinder.find(IAptipMDOCudService.class);
		IAptipMDORService iRService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO aptIPDO = iRService.findById(aptIpId);
		if (EnValidator.isEmpty(aptIPDO)) {
			throw new BizException("未检索到患者的入院申请单，请刷新重试！");
		}
		if (!IEnDictCodeConst.SD_STATUS_NOTICE_CREATE.equals(aptIPDO.getSd_status())) {
			throw new BizException("患者的申请单状态已发生改变，请刷新重试！");
		}
		aptIPDO.setFg_canc(FBoolean.TRUE);
		aptIPDO.setId_emp_canc(EnContextUtils.getPsnId());
		aptIPDO.setDt_canc(EnAppUtils.getServerDateTime());
		aptIPDO.setStatus(DOStatus.UPDATED);

		iCudService.save(new AptIpDO[] { aptIPDO });
	}

}
