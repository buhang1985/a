package iih.bl.hp.s.bp;

import iih.bl.hp.dto.d.HpPatiSettledDTO;
import iih.bl.hp.s.bp.qry.GetHpPatiSettledTransInfoQry;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/** 
 * 获取导出CSV的患者交易信息
 * @param  结算id和就诊类型code组合map
 * @author liwq 
 * @return
 * @throws BizException
 */
public class GetHpPatiTransInfoBP {

	public HpPatiSettledDTO[] exec(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereSql = ser.getQueryStringWithoutDesc(qryRootNodeDTO);		
		HpPatiSettledDTO[] hpDto = null;
		hpDto = (HpPatiSettledDTO[]) AppFwUtil.getDORstWithDao(new GetHpPatiSettledTransInfoQry(whereSql), HpPatiSettledDTO.class);
		
		return hpDto;
	}
}
