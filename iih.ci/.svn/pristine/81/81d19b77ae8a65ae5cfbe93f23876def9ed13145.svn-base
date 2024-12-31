package iih.ci.ord.s.external.provide.bp.partner;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.util.ConvertDTOs2XmlUtils;
import iih.bd.base.util.ConvertXml2DTOsUtils;
import iih.ci.ord.i.external.provide.meta.partner.IpOrderAmountParamDTO;
import iih.ci.ord.i.external.provide.meta.partner.IpOrderAmountRstDTO;
import iih.ci.ord.s.external.provide.bp.partner.qry.GetIpOrdersAmount8EnQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 患者历史医嘱数量接口
 * @author zhangwq
 *
 */
public class GetIpOrdersAmount8EnBP {
	public String exec(String xmlParam) throws BizException{
		ConvertXml2DTOsUtils xmlUtils = new ConvertXml2DTOsUtils();
		IpOrderAmountParamDTO paramDTO = (IpOrderAmountParamDTO) xmlUtils.exec(xmlParam, IpOrderAmountParamDTO.class);
		IpOrderAmountRstDTO[] rstDTOs;
		if (StringUtils.isNullOrEmpty(paramDTO.getCode_dep_nur_or())) {
			rstDTOs = new IpOrderAmountRstDTO[] {};
		} else {
			ITransQry qry = new GetIpOrdersAmount8EnQry(paramDTO);
			rstDTOs = (IpOrderAmountRstDTO[]) AppFwUtil.getDORstWithDao(qry, IpOrderAmountRstDTO.class);
		}
		ConvertDTOs2XmlUtils dtoUtils = new ConvertDTOs2XmlUtils();
		return dtoUtils.exec(rstDTOs, "Root", "orderitem");
	}
}
