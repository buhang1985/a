package iih.ci.ord.s.external.provide.bp.partner;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.util.ConvertDTOs2XmlUtils;
import iih.bd.base.util.ConvertXml2DTOsUtils;
import iih.ci.ord.i.external.provide.meta.partner.IpOrderCancelStateParamDTO;
import iih.ci.ord.i.external.provide.meta.partner.IpOrderCancelStateRstDTO;
import iih.ci.ord.s.external.provide.bp.partner.qry.GetIpOrderCancelStateQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 医嘱是否已作废确认
 * @author zhangwq
 *
 */
public class GetIpOrderCancelStateBP {
	public String exec(String xmlParam) throws BizException{
		ConvertXml2DTOsUtils xmlUtils = new ConvertXml2DTOsUtils();
		IpOrderCancelStateParamDTO paramDTO = (IpOrderCancelStateParamDTO) xmlUtils.exec(xmlParam, IpOrderCancelStateParamDTO.class);
		IpOrderCancelStateRstDTO[] rstDTOs;
		if (StringUtils.isNullOrEmpty(paramDTO.getCode_or())) {
			rstDTOs = new IpOrderCancelStateRstDTO[] {};
		} else {
			ITransQry qry = new GetIpOrderCancelStateQry(paramDTO);
			rstDTOs = (IpOrderCancelStateRstDTO[]) AppFwUtil.getDORstWithDao(qry, IpOrderCancelStateRstDTO.class);
		}
		ConvertDTOs2XmlUtils dtoUtils = new ConvertDTOs2XmlUtils();
		return dtoUtils.exec(rstDTOs, "Root", "orderitem");
	}
}
