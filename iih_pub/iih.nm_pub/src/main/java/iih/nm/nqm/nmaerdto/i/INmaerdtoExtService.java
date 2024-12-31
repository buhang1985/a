package iih.nm.nqm.nmaerdto.i;

import iih.nm.nqm.nmaerdto.d.NmAerDTO;
import xap.mw.core.data.BizException;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年6月6日 上午10:27:18
 * 类说明：不良事件上报自定义扩展服务
 * Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public interface INmaerdtoExtService {

	public NmAerDTO[] find(NmAerDTO conDto)throws BizException;
	
	public void delete(NmAerDTO[] dtos)throws BizException;
	
	public NmAerDTO[] save(NmAerDTO[] dtos)throws BizException; 
}
