package iih.bd.srv.s.bp;

import iih.bd.srv.d.MmPriceDTO;
import iih.bd.srv.s.bp.qry.GetOutlineSrvRefMmQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取服务关联物品概要信息
 * @author qzwang
 *
 */
public class GetOutlineSrvRefMmBP {

	public MmPriceDTO[] exec(String[] szIdSrv)throws BizException
	{
		GetOutlineSrvRefMmQry qry = new GetOutlineSrvRefMmQry(szIdSrv);
		MmPriceDTO[] rtn =	(MmPriceDTO[])AppFwUtil.getDORstWithDao(qry, MmPriceDTO.class);
		return rtn;
	}
	public MmPriceDTO[] exec(String IdSrv)throws BizException
	{
		String s = "";
		GetOutlineSrvRefMmQry qry = new GetOutlineSrvRefMmQry(new String[]{IdSrv});
		MmPriceDTO[] rtn =	(MmPriceDTO[])AppFwUtil.getDORstWithDao(qry, MmPriceDTO.class);
		return rtn;
	}
}
