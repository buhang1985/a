package iih.bd.fc.mdwfcfg.i;

import iih.bd.fc.mdwfcfg.d.MdwftreeDTO;
import iih.bd.fc.mdwfconfig.d.MdWfDO;
import xap.mw.core.data.BizException;

public interface IMdwfcfgTreeService {
	/*
	 * 获取个性化医嘱流向树
	 */
	public abstract MdwftreeDTO[] getList() throws BizException;
	/*
	 * 根据MdwftreeDTO删除医嘱流向分类/医嘱流向 / 医嘱流向开立参数
	 */
	public abstract String delete(MdwftreeDTO DTO) throws BizException;

}
