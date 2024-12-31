package iih.ci.mr.cdss.s;

import iih.ci.mr.cdss.i.IMrCdssService;
import iih.ci.mr.cdss.s.bp.MrCdssBp;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.mrcdssdto.d.MrCdssDTO;
import iih.ci.mr.mrcdssmaindto.d.MrCdssMainDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IMrCdssService.class }, binding = Binding.JSONRPC)
public class MrCdssServiceImpl implements IMrCdssService{

	/**
	 * 获取cdss报文数据
	 * @param id_ent
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	@Override
	public MrCdssDTO[] getMrCdssDtos(Ent4BannerDTO bannerDto, CiMrDO ciMrDo, String userCode, String userName,
			String orgName) throws BizException {
		MrCdssBp mrCdssBp = new MrCdssBp();
		return mrCdssBp.getMrCdssDtos(bannerDto, ciMrDo, userCode, userName, orgName);
	}

	/**
	 * 获取cdss主dto数据
	 * @param bannerDto
	 * @param userCode
	 * @param userName
	 * @param deptName
	 * @param orgCode
	 * @param orgName
	 * @param cdssKey
	 * @return
	 * @throws BizException
	 */
	@Override
	public MrCdssMainDTO getMrCdssMainDto(Ent4BannerDTO bannerDto, String userCode, String userName, String deptName,
			String orgCode, String orgName, String cdssKey) throws BizException {
		MrCdssBp mrCdssBp = new MrCdssBp();
		return mrCdssBp.getMrCdssMainDto(bannerDto, userCode, userName, deptName, orgCode, orgName, cdssKey);
	}

}
