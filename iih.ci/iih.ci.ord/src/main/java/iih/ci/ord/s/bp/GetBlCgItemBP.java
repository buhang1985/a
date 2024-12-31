package iih.ci.ord.s.bp;
import iih.ci.ord.ciordqry.d.CiOrdQryItemDTO;
import iih.ci.ord.s.bp.qry.GetBlCgItemQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.ci.ord.ciordqry.d.CiBlIpCgDTO;
public class GetBlCgItemBP {
	
	public CiBlIpCgDTO[] exe(CiOrdQryItemDTO cond) throws BizException{
		
		GetBlCgItemQry qry=new GetBlCgItemQry(cond.getId_or());
		CiBlIpCgDTO[] rnt =(CiBlIpCgDTO[])AppFwUtil.getDORstWithDao(qry, CiBlIpCgDTO.class);
		return rnt;
	}

}
