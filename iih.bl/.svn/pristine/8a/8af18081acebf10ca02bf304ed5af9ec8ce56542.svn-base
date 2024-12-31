package iih.bl.cg.s.bp;

import iih.bl.cg.d.BlIpFeeDTO;
import iih.bl.cg.s.bp.qry.GetBlIpFeeDTOINfoQry;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 查询可补费信息
 * @author liwenqiang
 *
 */
public class GetBlIpFeeDTOINfoBp {
	
	
	public BlIpFeeDTO[] exec(QryRootNodeDTO query,String id_ent) throws BizException {
		//获得查询方案的String查询条件
	    IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
	    String whereStr = qrySQLGeneratorService.getQueryStringWithoutDesc(query);
		BlIpFeeDTO[] ipFeeArr = (BlIpFeeDTO[]) AppFwUtil.getDORstWithDao(new GetBlIpFeeDTOINfoQry(id_ent,whereStr), BlIpFeeDTO.class);
		return ipFeeArr;
	}
}
