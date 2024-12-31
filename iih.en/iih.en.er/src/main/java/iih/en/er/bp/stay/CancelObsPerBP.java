package iih.en.er.bp.stay;


import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.er.dto.d.EnObsPermitDTO;
import iih.en.utils.EnContextUtils;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消留观许可
 * 
 */
public class CancelObsPerBP {
	/**
	 * 取消留观许可
	 * 
	 * @param erPreTriage
	 * @return
	 * @throws BizException
	 */
	public void exec(EnObsPermitDTO obspermit)
			throws BizException {
		//1. 如果SC_APT_IP.sd_status=4-入院， 提示用户已经入院，不允许取消。
		IAptipMDORService rServ=ServiceFinder.find(IAptipMDORService.class);
		AptIpDO aptIp = rServ.findById(obspermit.getId_aptip());
		if(aptIp == null)
			return ;
		if(IScDictCodeConst.SD_APTIP_STATUS_INHOS.equals(aptIp.getSd_status())){
			throw new BizException("患者已经留观登记,不允许撤销！");
		}
		if(FBoolean.TRUE.equals(aptIp.getFg_canc())){
			throw new BizException("患者留观许可已撤销！");
		}
		//2. 修改SC_APT_IP.
		aptIp.setStatus(DOStatus.UPDATED);
		aptIp.setFg_canc(FBoolean.TRUE);
		aptIp.setId_emp_canc(EnContextUtils.getPsnId());
		aptIp.setDt_canc(EnAppUtils.getServerDateTime());
		IAptipMDOCudService cudServ=ServiceFinder.find(IAptipMDOCudService.class);
		cudServ.save(new AptIpDO[]{aptIp});
	}
}	
