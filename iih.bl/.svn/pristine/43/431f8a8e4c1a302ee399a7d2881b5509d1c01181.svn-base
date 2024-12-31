package iih.bl.inc.blecinccomp.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.StringUtils;
import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.bl.inc.blecinccomp.i.IBlecinccompCudService;
import iih.bl.inc.blecinccomp.s.bp.sql.LoadTableDataSql;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.udi.d.UdidocDO;

public class RefreshCompBP {
	public FBoolean exec(UdidocDO udidocDO) throws BizException{
		String[] strings = udidocDO.getCtrl2().split(",");
		//校验数据
		CheckParam(strings);
		LoadTableDataSql sql = new LoadTableDataSql(strings, udidocDO);
		DAFacade daFacade = new DAFacade();
		ArrayList<BlEcIncCompDO> list = (ArrayList<BlEcIncCompDO>) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(BlEcIncCompDO.class));
		if (list.size()<=0) {
			return FBoolean.TRUE;
		}
		IBlecinccompCudService cudService = ServiceFinder.find(IBlecinccompCudService.class);
		cudService.insert(list.toArray(new BlEcIncCompDO[list.size()]));
		return FBoolean.TRUE;
	}
	
	/**
	 * 校验数据
	 * @author zhang.hw
	 * @date 2020年2月12日
	 * @param udidocDO
	 * @throws BizException 
	 */
	private void CheckParam(String[] strings) throws BizException {
		//校验表名、对照的编码列、对照的名称列是否存在
		if (strings.length!=3) {
			throw new BizException("自定义档案【对应表名编码名称】列填写不正确！");
		}
		if (!StringUtils.isNotEmpty(strings[0])) {
			throw new BizException("自定义档案【对应表名编码名称】列中【表名】 填写不正确！");
		}
		if (!StringUtils.isNotEmpty(strings[1])) {
			throw new BizException("自定义档案【对应表名编码名称】列中【编码】 填写不正确！");
		}
		if (!StringUtils.isNotEmpty(strings[2])) {
			throw new BizException("自定义档案【对应表名编码名称】列中【名称】 填写不正确！");
		}
	}
}
