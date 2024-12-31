package iih.bd.pp.anhuiinsur.i;

import xap.mw.core.data.BizException;

/**
 * 安徽东软医保病种目录扩展Cud服务
 * @author guoyang
 *
 */
public interface IBdHpDiOrginalExtCudService {

	/**
	 * 删除所有诊断目录
	 */
	public abstract void DeleteAllDiOrginal() throws BizException;
}
