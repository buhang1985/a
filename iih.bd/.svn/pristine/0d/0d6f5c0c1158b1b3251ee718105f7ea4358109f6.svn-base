package iih.bd.mm.drugcombctl.s.bp;

import iih.bd.mm.drugcombctl.d.DrugCombCtlDTO;
import iih.bd.mm.drugcombctl.s.bp.qry.FindDrugCombCtlQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 查询联合用药限制信息业务逻辑
 * 
 * @author hao_wu 2018-11-6
 *
 */
public class FindDrugCombCtlBp {

	public DrugCombCtlDTO[] exec() throws BizException {
		FindDrugCombCtlQry qry = new FindDrugCombCtlQry();
		
		DrugCombCtlDTO[] drugCombCtls = (DrugCombCtlDTO[]) AppFwUtil.getDORstWithDao(qry, DrugCombCtlDTO.class);
		return drugCombCtls;
	}

}
