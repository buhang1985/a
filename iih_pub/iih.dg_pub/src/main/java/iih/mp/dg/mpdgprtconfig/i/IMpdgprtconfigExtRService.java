package iih.mp.dg.mpdgprtconfig.i;

import iih.mp.dg.dto.drugdocprt.d.DrugDocPrintArgsDTO;
import iih.mp.dg.mpdgprtconfig.d.MpdgPrtConfigDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 药单打印配置数据扩展服务
 * 
 * @author dj.zhang
 *
 * @data 2018年6月24日下午4:02:41
 */
public interface IMpdgprtconfigExtRService {
	/**
	 * 使用查询方案和使用场景查询打印配置信息
	 * 
	 * @param qryRootNodeDto
	 * @param usUdidocDo
	 * @param pg
	 * @return
	 */
	public abstract PagingRtnData<MpdgPrtConfigDO> findPagingDataByQCondAndUdidoc(QryRootNodeDTO qryRootNodeDto,
			UdidocDO usUdidocDo, PaginationInfo pg) throws BizException;

	/**
	 * 获取打印信息
	 * 
	 * @param argsDtos
	 * @param auto
	 *            自动打印
	 * @return
	 * @throws BizException
	 */
	public abstract FMap getPrintParamFMap(DrugDocPrintArgsDTO[] argsDtos, FBoolean auto) throws BizException;
}