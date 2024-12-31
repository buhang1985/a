package iih.bl.cg.s.bp;

import iih.bl.cg.dto.d.EntPatInfoDTO;
import iih.bl.cg.s.bp.qry.GetIpDayFeeDetailQry;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 一日费用清单（住院处）查询逻辑
 * @author shaokx
 *
 */

public class GetPatInfoByQry {

	/**
	 * 通过查询方案查询出患者信息（一日费用清单（住院处））
	 * @param queryNode
	 * @return
	 * @throws BizException
	 */
	public EntPatInfoDTO[] exec(QryRootNodeDTO queryNode) throws BizException{
		//获得查询方案的String查询条件
	    IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
	    String whereStr = qrySQLGeneratorService.getQueryStringWithoutDesc(queryNode);
		//调用接口查询
	    EntPatInfoDTO[] entPatInfoDto = null;
	    entPatInfoDto = (EntPatInfoDTO[]) AppFwUtil.getDORstWithDao(new GetIpDayFeeDetailQry(whereStr), EntPatInfoDTO.class);

		return entPatInfoDto;
	}
}
