package iih.ci.ord.i.op.fee;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.FeeListCrtDTO;
import iih.ci.ord.i.meta.FeeListLoadDTO;
import iih.ci.ord.i.meta.FeeListRstDTO;
import iih.ci.ord.i.meta.FeeListSaveDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 费用清单操作服务
 * @author wangqingzhu
 *
 */
public interface ICiFeeListMainService {

	/**
	 * 创建费用项目
	 * @param crt
	 * @return
	 * @throws BizException
	 */
	public abstract FeeListRstDTO create(CiEnContextDTO ctx, FeeListCrtDTO crt) throws BizException ;
	
	/**
	 * 加载费用清单数据
	 * @param ld
	 * @return
	 * @throws BizException
	 */
	public abstract FeeListRstDTO load(CiEnContextDTO ctx, FeeListLoadDTO ld) throws BizException ;
	
	/**
	 * 保存费用清单数据修改
	 * @param sv
	 * @return
	 * @throws BizException
	 */
	public abstract FeeListRstDTO save(CiEnContextDTO ctx, FeeListSaveDTO sv) throws BizException ;
	
	/**
	 * 临床费用项目数量是否可调整
	 * 
	 * @param code_or	医嘱编码
	 * @param id_srv_bl 定价服务id
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean isQuantityAdjustable(String code_or, String id_srv_bl) throws BizException;
}
