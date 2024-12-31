package iih.bd.pp.anhuiinsur.i;

import xap.mw.core.data.BizException;

/**
 * 安徽东软医保诊疗目录扩展Cud服务
 * 
 * @author hao_wu
 *
 */
public interface IBdHpZlOrginalExtCudService {
	/**
	 * 删除所有诊疗目录
	 */
	public abstract void DeleteAllZlOrginal() throws BizException;
}
