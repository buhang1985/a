package iih.pi.reg.s.bp.help;

import iih.bl.params.BlParams;
import iih.pe.papi.i.his.IChargeService;
import iih.pi.banner.d.PatientBannerDTO;
import iih.pi.common.idcheck.IDChecker;
import iih.pi.reg.dto.pipeqry.d.PiPeQryCondDTO;
import iih.pi.reg.dto.pipeqry.d.PiPeQryRltDTO;
import iih.pi.reg.i.IPiCustomService;
import iih.pi.reg.s.bp.GetPatiBannerBP;
import iih.pi.reg.s.bp.qry.PiBannerQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 患者banner检索,从第三方体检系统加载数据
 * 
 * @author ly 2018/09/02
 *
 */
public class GetPatiBannerFromThirdPeBP {

	/**
	 * 患者banner检索，从第三方体检系统加载数据
	 * 
	 * @param services
	 * @param valueText
	 * @return
	 * @throws BizException
	 */
	public PatientBannerDTO exec(String[] services, String valueText) throws BizException {

		if (!this.ifQueryFromPe(services))
			return null;

		PiPeQryRltDTO rltDto = null;

		if (FBoolean.TRUE.equals(BlParams.BLITF0002())) {
			rltDto = this.findPatFromThirdPe(valueText);
		} else {
			rltDto = this.findPatFromIIHPe(valueText);
		}
		// 添加患者姓名检索
		if (rltDto == null) {
			PatientBannerDTO[] result = this.findPatByName(valueText);
			if (ArrayUtil.isEmpty(result)) {
				return null;
			}else
			{
				return result[0];
			}

		}
		String newCond = "and id_pat = '" + rltDto.getId_pat() + "'";
		PiBannerQry qry = new PiBannerQry(null, newCond);

		PatientBannerDTO[] result = (PatientBannerDTO[]) AppFwUtil.getDORstWithDao(qry, PatientBannerDTO.class);

		if (ArrayUtil.isEmpty(result))
			return null;

		result[0].setPecode(rltDto.getPe_code());
		return result[0];
	}

	private PatientBannerDTO[] findPatByName(String valueText) throws BizException {
		String newCond = "and name like '%" + valueText + "%'";
		PiBannerQry qry = new PiBannerQry(null, newCond);

		PatientBannerDTO[] result = (PatientBannerDTO[]) AppFwUtil.getDORstWithDao(qry, PatientBannerDTO.class);

		if (ArrayUtil.isEmpty(result))
			return null;
		return result;
	}

	/**
	 * 从IIH体检系统加载患者
	 * 
	 * @param valueText
	 * @return
	 * @throws BizException
	 */
	private PiPeQryRltDTO findPatFromIIHPe(String valueText) throws BizException {

		IChargeService peService = ServiceFinder.find(IChargeService.class);
		PiPeQryCondDTO cond = new PiPeQryCondDTO();
		if (IDChecker.checkIDCard(valueText)) {
			cond.setId_code(valueText);
		} else {
			cond.setPe_code(valueText);
		}
		PiPeQryRltDTO rltDto = peService.piFindPe(cond);
		return rltDto;
	}

	/**
	 * 从第三方体检系统加载患者
	 * 
	 * @param valueText
	 * @return
	 * @throws BizException
	 */
	private PiPeQryRltDTO findPatFromThirdPe(String valueText) throws BizException {

		IPiCustomService piCusService = ServiceFinder.find(IPiCustomService.class);
		if (piCusService == null)
			return null;

		// 暂时只支持身份证和流水号检索
		PiPeQryCondDTO cond = new PiPeQryCondDTO();
		if (IDChecker.checkIDCard(valueText)) {
			cond.setId_code(valueText);
		} else {
			cond.setPe_code(valueText);
		}

		PiPeQryRltDTO rltDto = piCusService.findPatFromPeSystem(cond);
		return rltDto;
	}

	/**
	 * 是否从体检系统加载数据
	 * 
	 * @param services
	 * @return
	 * @throws BizException
	 */
	private boolean ifQueryFromPe(String[] services) throws BizException {

		if (ArrayUtil.isEmpty(services))
			return false;

		for (String str : services) {

			if (GetPatiBannerBP.PE_PATIENT_QUERY.equals(str))
				return true;
		}

		return false;
	}
}
