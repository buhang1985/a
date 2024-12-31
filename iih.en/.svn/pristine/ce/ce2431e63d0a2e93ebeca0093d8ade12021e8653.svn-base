package iih.en.pv.s.bp;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.sc.apt.aptip.d.AptIpAttrDO;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptIpAttrDOCudService;
import iih.sc.apt.aptip.i.IAptIpAttrDORService;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import iih.sc.apt.dto.d.AptIpDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 取消入院通知单
 * @author Sarah
 *
 */
public class EnCancAptIpBp {
	/**
	 * 取消入院通知单
	 * 
	 * @param entipntDTO
	 * @param entId
	 * @throws BizException
	 */
	public void exec(AptIpDTO entipntDTO, String entId) throws BizException {
		IAptipMDOCudService aptcudService = ServiceFinder.find(IAptipMDOCudService.class);
		IAptipMDORService aptRService = ServiceFinder.find(IAptipMDORService.class);

		IAptIpAttrDORService attRService = ServiceFinder.find(IAptIpAttrDORService.class);
		IAptIpAttrDOCudService attRCService = ServiceFinder.find(IAptIpAttrDOCudService.class);
		AptIpDO aptIPDO = aptRService.findById(entipntDTO.getId_scaptip());
		if (aptIPDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_APTIP);
		}
		if (!EnValidator.isEmpty(aptIPDO.getId_ent()) && (aptIPDO.getId_ent().equals(entId))) {
			AptIpAttrDO[] aptipAttrs = attRService.find("id_aptip = '" + entipntDTO.getId_scaptip() + "'", "", FBoolean.FALSE);
			if (!EnValidator.isEmpty(aptipAttrs)) {
				attRCService.delete(aptipAttrs);
			}
			aptcudService.delete(new AptIpDO[] { aptIPDO });
			return;
		}
		aptIPDO.setFg_canc(FBoolean.TRUE);
		aptIPDO.setId_emp_canc(EnContextUtils.getPsnId());
		aptIPDO.setDt_canc(EnAppUtils.getServerDateTime());
		aptIPDO.setStatus(DOStatus.UPDATED);

		aptcudService.save(new AptIpDO[] { aptIPDO });

		return;
	}

}
