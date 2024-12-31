package iih.bl.inc.blecinccomp.s.bp;

import iih.bd.base.utils.StringUtils;
import iih.bl.inc.blecinccomp.dto.d.BlecIncCompDTO;
import iih.bl.inc.blecinccomp.s.bp.sql.FindIncCompDataListSql;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

public class FindIncCompDataListBP {
	public PagingRtnData<BlecIncCompDTO> exec(String id_udidoc, PaginationInfo pg) throws BizException{
		IUdidocRService rService = ServiceFinder.find(IUdidocRService.class);
		UdidocDO udidocDO = rService.findById(id_udidoc);
		String[] strings = udidocDO.getCtrl2().split(",");
		//校验数据
		CheckParam(strings);
		FindIncCompDataListSql sql = new FindIncCompDataListSql(strings,id_udidoc,udidocDO.getCtrl3());
		PagingServiceImpl<BlecIncCompDTO> pagingService = new PagingServiceImpl<BlecIncCompDTO>();
		PagingRtnData<BlecIncCompDTO> pagingRtnData = pagingService.findByPageInfo(new BlecIncCompDTO(),pg,sql.getQrySQLStr(), " ecinc.Id_ecinccomp ", sql.getQryParameter(null));
		return pagingRtnData;
		
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
