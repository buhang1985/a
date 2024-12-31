package iih.bl.cg.s.bp;

import java.util.List;

import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.cg.dto.d.NurseFeeTemplateDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据费用模板id获取费用模板明细
 * @author shaokx
 */
public class GetFeeTplItmBp {

	public NurseCompFeeItmDTO[] exec (String id_bltpl) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select ");
		sb.append(" srv.eu_blmd, ");
		sb.append(" srv.sd_srvtp, ");
		sb.append(" srv.id_srvca, ");
		sb.append(" srv.fg_mm, ");
		sb.append(" srv.id_srv, ");
		sb.append(" srv.name name_srv, ");
		sb.append(" mm.spec, ");
		sb.append(" tplitm.quan_medu quan_mend, ");
		sb.append(" meas.name name_srvu, ");
		sb.append(" meas.id_measdoc srvu ");
		//标准单价和折扣单价取服务价表(本服务定价)的价格
//		sb.append(" srv.pri price, ");
//		sb.append(" srv.pri price_ratio ");
		sb.append(" from bd_bltpl_itm tplitm ");
		sb.append(" left join bd_srv srv ");
		sb.append(" on tplitm.id_srv = srv.id_srv ");
		sb.append(" left join bd_mm mm ");
		sb.append(" on tplitm.id_srv = mm.id_srv ");
		sb.append(" left join bd_measdoc meas ");
		sb.append(" on tplitm.id_unit = meas.id_measdoc ");
		sb.append(" where ");
		sb.append(" tplitm.id_bltpl = ? ");

		
		SqlParam sp = new SqlParam();
		sp.addParam(id_bltpl);
		
		List<NurseCompFeeItmDTO> list = (List<NurseCompFeeItmDTO>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(NurseCompFeeItmDTO.class));
		
		return list.toArray(new NurseCompFeeItmDTO[] {});
	}
	
	
}
