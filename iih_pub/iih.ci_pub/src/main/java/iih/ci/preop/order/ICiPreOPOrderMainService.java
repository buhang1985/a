package iih.ci.preop.order;

import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 门诊医生站 - 预住院患者申请单服务项目列表
 * @author wangqingzhu
 *
 */
public interface ICiPreOPOrderMainService {

	/**
	 * 患者预住院服务列表加载后台逻辑接口
	 * @param ctx
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException;
	
	/**
	 * 患者预住院服务签署逻辑接口
	 * @param ctx
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO sign(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException;
	
	/**
	 * 患者预住院服务作废逻辑接口
	 * @param ctx
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO cancel(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException;
	
	/**
	 * 患者预住院服务删除逻辑接口
	 * @param ctx
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO delete(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException;
	/**
	 * 患者预住院服务复制逻辑接口
	 * @param ctx
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException;
	/**
	 * 患者预住院模板保存服务
	 * @param ctx
	 * @param ortplItemDO
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO saveOrtmpl(CiEnContextDTO ctx, OrTplNItmDO[] ortplItemDO) throws BizException;
	
	/**
	 * 患者预住院模板保存服务
	 * @param ctx
	 * @param ortplItemDO
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO saveMedSrv(CiEnContextDTO ctx, OrTplNItmDO[] ortplItemDO) throws BizException;
}
