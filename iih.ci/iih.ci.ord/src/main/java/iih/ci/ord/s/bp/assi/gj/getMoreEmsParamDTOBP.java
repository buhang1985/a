
package iih.ci.ord.s.bp.assi.gj;

import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.core.utils.ObjectUtils;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.s.bp.validate.CiOrOpenEntStatusValidateBP;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;

/**
 * 
 * @author Administrator
 *
 */
public class getMoreEmsParamDTOBP {

	public MoreEmsParamDTO exec(CiEnContextDTO envinfo, OrTplNItmDO[] ortplItemDOs, String clinicalzztz) throws BizException {
		//放入上下文信息
		Context.get().setAttribute("CiEnContextDTO", envinfo);
		// 判断患者就诊状态
		CiOrOpenEntStatusValidateBP entBp = new CiOrOpenEntStatusValidateBP();
		entBp.exec(envinfo.getCode_entp(), envinfo.getId_en(), envinfo.getId_dep_en(), envinfo.getId_dep_ns());
		ConvertOrtmlNItem2CiOrTmplBP bp = new ConvertOrtmlNItem2CiOrTmplBP(!ObjectUtils.isEmpty(envinfo) && !StringUtils.isEmpty(envinfo.getEu_orsrcmdtp()) 
				? envinfo.getEu_orsrcmdtp() : OrSourceFromEnum.IIHORTMPLHELPER);
		List<CiOrTmplDTO> ciOrtmplList = bp.exec(ortplItemDOs);
		
		if (ciOrtmplList == null)
			throw new BizException("选中的数据维护有错，去诊疗项目中排查错误！");
		// 映射成CiEmsDTO
		CiOrTmplAggDTOMappingCiEmsDTO ciEmsDTO = new CiOrTmplAggDTOMappingCiEmsDTO();
		return ciEmsDTO.Mapping(envinfo, ciOrtmplList.toArray(new CiOrTmplDTO[0]), clinicalzztz);
	}
}
