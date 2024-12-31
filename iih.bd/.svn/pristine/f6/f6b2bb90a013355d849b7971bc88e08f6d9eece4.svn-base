package iih.bd.pp.s.samppri.bp;

/**
 * 
 * @Description:标本费用对照,查询标本类型
 * @author zheng.yx@founder.com.cn
 * @version：2019年4月11日 上午10:29:63 创建
 */
import iih.bd.pp.s.samppri.qry.GetSamptpDocQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.udi.d.UdidocDO;

public class GetSamptpDocBp {

	/**
	 * 主入口
	 * 
	 * @return
	 * @throws BizException
	 */
	public UdidocDO[] exec() throws BizException {
		GetSamptpDocQry qry = new GetSamptpDocQry();
		return ((UdidocDO[]) AppFwUtil.getDORstWithDao(qry, UdidocDO.class));
	}
}
