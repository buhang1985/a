package iih.bd.srv.emrtpl.i;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrctmca.d.MrCaCtmItmDO;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医疗记录模板扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IEmrtplExtRService {

	/**
	 * 替换基础模板
	 * 
	 * @param emrTplDo
	 * @param emrBaseTplDo
	 * @throws BizException
	 */
	public abstract EmrTplDO ReplaceBaseMrtpl(EmrTplDO emrTplDo, EmrBaseTplDO emrBaseTplDo) throws BizException;

	/**
	 * 获取新序号
	 * 
	 * @param emrTplDo
	 *            医疗模板_Id_mrtp和Sd_owtp不允许为空
	 * @return
	 * @throws BizException
	 */
	public abstract int GetNewOrderId(EmrTplDO emrTplDo) throws BizException;

	/**
	 * 根据查询方案和医疗模板分类查询医疗记录模板分页信息
	 * 
	 * @param sdOwtp
	 *            所属类型编码
	 * @param mrCtmCaDo
	 *            医疗模板分类
	 * @param mrCaCtmItmDo
	 *            医疗模板分类项目
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param pg
	 *            分页信息
	 * @return
	 */
	public abstract PagingRtnData<EmrTplDO> FindPagingByQcondAndMrCtmCa(String sdOwtp, MrCtmCaDO mrCtmCaDo,
			MrCaCtmItmDO mrCaCtmItmDo, QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException;
}
