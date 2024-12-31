package iih.ci.ord.s.external.provide.bp.partner;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import iih.bd.base.util.ConvertDTOs2XmlUtils;
import iih.bd.base.util.ConvertXml2DTOsUtils;
import iih.bd.utils.BdMmParamUtils;
import iih.ci.ord.i.external.provide.meta.bl.OrdOperInfo4BlDTO;
import iih.ci.ord.i.external.provide.meta.partner.IpOrderParamDTO;
import iih.ci.ord.i.external.provide.meta.partner.IpOrderRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.external.provide.bp.partner.qry.GetIpOrdersQry;
import iih.ci.ord.s.external.provide.bp.partner.qry.GetPivasOrdersQry;

/**
 * 住院医嘱查询接口
 * @author Young
 *
 */
public class GetIpOrdersBP {

	public String exec(String xmlParam) throws BizException{
		String msg = "住院医嘱查询接口，入参：";
		OrdBizLogger.debug(null, msg+xmlParam);
		ConvertXml2DTOsUtils xmlUtils = new ConvertXml2DTOsUtils();
		IpOrderParamDTO paramDTO = (IpOrderParamDTO) xmlUtils.exec(xmlParam, IpOrderParamDTO.class);
		IpOrderRstDTO[] rstDTOs;
		if (StringUtils.isNullOrEmpty(paramDTO.getCode_entp())||StringUtils.isNullOrEmpty(paramDTO.getFg_ip())) {
			rstDTOs = new IpOrderRstDTO[] {};
		} else {
			if((CiOrdUtils.isEmpty(paramDTO.getFg_crossdepnur())||"N".equals(paramDTO.getFg_crossdepnur()))&&StringUtils.isNullOrEmpty(paramDTO.getCode_pat())&&StringUtils.isNullOrEmpty(paramDTO.getCode_dep_nur_or())){
				rstDTOs = new IpOrderRstDTO[] {};
			}else{
				String drugManagementModel = BdMmParamUtils.GetDrugMCPropMM();
				ITransQry qry = new GetIpOrdersQry(paramDTO,drugManagementModel);
				rstDTOs = (IpOrderRstDTO[]) AppFwUtil.getDORstWithDao(qry, IpOrderRstDTO.class);
				//是Pivas的药房查询
				if(null!=paramDTO.getFg_pivas()&&"Y".equals(paramDTO.getFg_pivas())){
					List<String> code_ors = getCode_ors(rstDTOs);
					ITransQry pivasQry = new GetPivasOrdersQry(code_ors,drugManagementModel);
					rstDTOs = (IpOrderRstDTO[]) AppFwUtil.getDORstWithDao(pivasQry, IpOrderRstDTO.class);
				}
			}
		}
		ConvertDTOs2XmlUtils dtoUtils = new ConvertDTOs2XmlUtils();
		String rstXml = dtoUtils.exec(rstDTOs, "Root", "orderitem");
		msg = "住院医嘱查询接口，出参：";
		OrdBizLogger.debug(null, msg+rstXml);
		return rstXml;
	}
	private List<String> getCode_ors(IpOrderRstDTO[] orderRsts){
		List<String> code_ors = new ArrayList<String>();
		for(IpOrderRstDTO orderRst : orderRsts){
			if(null!=orderRst.getCode_or()&&!code_ors.contains(orderRst.getCode_or())){
				code_ors.add(orderRst.getCode_or());
			}
		}
		return code_ors;
	}
}
