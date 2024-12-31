package iih.bl.hp.s.bp;

import iih.bd.utils.BdEnvContextUtil;
import iih.bl.hp.dto.d.HpPatiSettledDTO;
import iih.bl.hp.s.bp.qry.GetHpPatiSettledTransInfoQry;
import iih.bl.st.blstoep.d.BlStOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保结算交易信息查询
 * @author Administrator
 *
 */
public class GetHpSettledTransInfoBp {

	public PagingRtnData<HpPatiSettledDTO>  exec(QryRootNodeDTO qryRootNodeDTO, PaginationInfo pg) throws BizException {
		IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereStr = ser.getQueryStringWithoutDesc(qryRootNodeDTO);
		// 获取结算信息查询SQL
		GetHpPatiSettledTransInfoQry qrySql = new GetHpPatiSettledTransInfoQry(whereStr);
		StringBuilder sql = new StringBuilder(qrySql.getQrySQLStr());
		
		HpPatiSettledDTO hpDto = new HpPatiSettledDTO();		
		
		PagingServiceImpl<HpPatiSettledDTO> pagingServiceImpl = new PagingServiceImpl<HpPatiSettledDTO>();

		PagingRtnData<HpPatiSettledDTO> prd = pagingServiceImpl.findByPageInfo(hpDto, pg, sql.toString(), "", null);
		
		return prd;		
	}
}
