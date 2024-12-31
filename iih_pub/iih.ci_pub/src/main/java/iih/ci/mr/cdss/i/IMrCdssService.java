package iih.ci.mr.cdss.i;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.mrcdssdto.d.MrCdssDTO;
import iih.ci.mr.mrcdssmaindto.d.MrCdssMainDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;

public interface IMrCdssService {
	/**
	 * 获取cdss报文数据
	 * @param id_ent
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public abstract MrCdssDTO[] getMrCdssDtos(Ent4BannerDTO bannerDto,CiMrDO ciMrDo,String userCode,String userName,String orgName) throws BizException;
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
	public abstract MrCdssMainDTO getMrCdssMainDto(Ent4BannerDTO bannerDto,String userCode,String userName,String deptName,String orgCode,String orgName,String cdssKey) throws BizException;
}
