package iih.ci.ord.s.bp.ordprn;

import java.util.List;

import iih.ci.core.utils.ObjectUtils;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.ordprn.dto.d.CiOrdSheetParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 清空医嘱单打印数据（逻辑删除）
 * @author Young
 *
 */
public class ClearOrdPrintDOsBP {

	public FBoolean exec(CiOrdSheetParamDTO paramDTO, Integer page_no, Integer row_no) 
			throws BizException {
		
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(paramDTO.getId_en());
		sqlparam.addParam(paramDTO.getId_ordsheet());
		// 根据行号是否为空，获取前台清空界面是否选中页号、行号，拼接页号行号SQL条件
		if (ObjectUtils.isEmpty(row_no)) {
			sqlparam.addParam(page_no - 1);
		} else {
			sqlparam.addParam(page_no - 1);
			sqlparam.addParam(row_no - 1);
			sqlparam.addParam(page_no - 1);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(" ds<1 and id_en=? and id_ordsheet=?");
		if (ObjectUtils.isEmpty(row_no)) {
			sb.append(" and page_num>=?");
		} else {
			sb.append(" and ((page_num=? and row_num>=?) or page_num>?)");
		}
		
		@SuppressWarnings("unchecked")
		List<OrdPrintDO> ordPrintDOs = (List<OrdPrintDO>) new DAFacade()
				.findByCond(OrdPrintDO.class, sb.toString(), sqlparam);
		if (!ObjectUtils.isEmpty(ordPrintDOs)) {
			// 本次之前清空的医嘱单打印数据进行物理删除
			SqlParam sqlparam1 = new SqlParam();
			sqlparam1.addParam(paramDTO.getId_en());
			sqlparam1.addParam(paramDTO.getId_ordsheet());
			new DAFacade().deleteByClause(OrdPrintDO.class, " ds>0 and id_en=? and id_ordsheet=?", sqlparam1);
			
			// 本次清空的医嘱单打印数据进行逻辑删除
			for (OrdPrintDO ordPrintDO : ordPrintDOs) {
				ordPrintDO.setDs(1);
			}
			new DAFacade().updateDOArray(ordPrintDOs.toArray(new OrdPrintDO[0]), new String[] { OrdPrintDO.DS });
			// 清空操作时调用执行域的接口
			OrdPrintUtils.execMPService(ordPrintDOs, FBoolean.FALSE);
			return FBoolean.TRUE;
		}
		
		return FBoolean.FALSE;
	}
}
