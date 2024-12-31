package iih.bl.cg.s.bp;

import java.util.List;

import org.nutz.mvc.adaptor.convertor.StringParamConvertor;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.dto.d.EntRecrodDTO;
import iih.bl.cg.dto.d.NurseFeeTemplateDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获得初始化的费用模板
 * @author shaokx
 */
public class GetInitFeeTplBp {

	public NurseFeeTemplateDTO[] exec (String id_dep) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select ");
		sb.append(" id_bltpl, ");
		sb.append(" name name_bltpl");
		sb.append(" from bd_bltpl");
		sb.append(" where ");
		sb.append(" id_dep = ?");
		sb.append(" and sd_bltpltp <> '01' ");//0132857: 门诊通用补费管理，费用模板需要过滤掉住院床位费用类型的模板（bd_bltpl.sd_bltpltp<>'01'）
		
		SqlParam sp = new SqlParam();
		sp.addParam(id_dep);
		
		List<NurseFeeTemplateDTO> list = (List<NurseFeeTemplateDTO>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(NurseFeeTemplateDTO.class));
		
		return list.toArray(new NurseFeeTemplateDTO[] {});
	}
	
	
}
