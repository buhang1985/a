package iih.bd.fc.s.bp.orpltpconfig;

import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.i.IOrpltpMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱闭环类型保存逻辑 2018年8月6日19:40:04
 * 
 * @author zhaoyangyang
 *
 */
public class SaveOrpltpBp {

	/**
	 * 主入口
	 * 
	 * @param param
	 * @return
	 */
	public void exec(OrpltpDO para) throws BizException {

		// 1、基础校验
		validation(para);

		// 2、保存医嘱闭环信息
		save(para);

	}

	/**
	 * 基础校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validation(OrpltpDO para) throws BizException {
		if (para.getSortno() ==null || para.getCode()==null  || para.getName()==null)
			throw new BizException("医嘱闭环类型信息保存，参数空异常！");
	}

	private void save(OrpltpDO para) throws BizException {
		ServiceFinder.find(IOrpltpMDOCudService.class).save(new OrpltpDO[] { para });
	}
}
