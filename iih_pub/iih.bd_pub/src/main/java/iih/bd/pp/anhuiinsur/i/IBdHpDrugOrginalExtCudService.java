package iih.bd.pp.anhuiinsur.i;

import xap.mw.core.data.BizException;

/**
 * 安徽东软医保药品目录扩展Cud服务
 * 
 * @author hao_wu
 *
 */
public interface IBdHpDrugOrginalExtCudService {

	/**
	 * 删除所有药品目录
	 */
	public abstract void DeleteAllDrugOrginal() throws BizException;
}
