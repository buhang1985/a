package iih.bd.pp.s.external.provide.bp;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.s.external.provide.bp.qry.FindCaItmRelBySrvQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 批量获取票据分类对照
 * @author ly 2018/06/28
 *
 */
public class FindCaItmRelBySrvBP {

	/**
	 * 批量获取票据分类对照
	 * @param sdIncca 票据分类编码
	 * @param srvIds 服务id数组
	 * @return 票据分类对照
	 * @throws BizException
	 */
	public IncCaItmRelDO[] exec(String sdIncca, String[] srvIds) throws BizException{
		
		if(StringUtil.isEmpty(sdIncca)){
			throw new ArgumentNullException("批量获取票据分类对照", "票据分类编码");
		}
		
		if(ArrayUtil.isEmpty(srvIds)){
			throw new ArgumentNullException("批量获取票据分类对照", "服务id数组");
		}
		
		FindCaItmRelBySrvQry qry = new FindCaItmRelBySrvQry(sdIncca,srvIds);
		IncCaItmRelDO[] dos = (IncCaItmRelDO[])AppFwUtil.getDORstWithDao(qry, IncCaItmRelDO.class);
		return dos;
	}
}
