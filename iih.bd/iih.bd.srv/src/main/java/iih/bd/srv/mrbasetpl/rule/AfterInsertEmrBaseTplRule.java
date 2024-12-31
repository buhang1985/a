package iih.bd.srv.mrbasetpl.rule;

import iih.bd.srv.basemrtplfs.d.BaseMrTplStreamDO;
import iih.bd.srv.basemrtplfs.i.IBasemrtplfsCudService;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 基础病历模板插入后规则
 * 
 * @author hao_wu
 *
 */
public class AfterInsertEmrBaseTplRule implements IRule<EmrBaseTplDO> {

	@Override
	public void process(EmrBaseTplDO... arg0) throws BizException {
		for (EmrBaseTplDO emrBaseTplDO : arg0) {
			insertBaseMrTplStream(emrBaseTplDO);
		}
	}

	/**
	 * 插入基础病历模板流数据
	 * 
	 * @param emrBaseTplDO
	 * @throws BizException
	 */
	private void insertBaseMrTplStream(EmrBaseTplDO emrBaseTplDO) throws BizException {
		BaseMrTplStreamDO baseMrTplStreamDO = createBaseMrTplStream(emrBaseTplDO);
		if (baseMrTplStreamDO != null) {
			insertBaseMrTplStream(baseMrTplStreamDO);
		}
	}

	/**
	 * 创建基础病历模板流数据
	 * 
	 * @param emrBaseTplDO
	 * @return
	 */
	private BaseMrTplStreamDO createBaseMrTplStream(EmrBaseTplDO emrBaseTplDO) {
		if (emrBaseTplDO == null || emrBaseTplDO.getId_basemrtpl() == null || emrBaseTplDO.getFs() == null) {
			return null;
		}
		BaseMrTplStreamDO baseMrTplStreamDO = new BaseMrTplStreamDO();
		baseMrTplStreamDO.setId_basemrtpl(emrBaseTplDO.getId_basemrtpl());
		baseMrTplStreamDO.setFs(emrBaseTplDO.getFs());
		return baseMrTplStreamDO;
	}

	/**
	 * 调用服务保存基础病历模板流数据
	 * 
	 * @param baseMrTplStreamDO
	 * @throws BizException
	 */
	private void insertBaseMrTplStream(BaseMrTplStreamDO baseMrTplStreamDO) throws BizException {
		IBasemrtplfsCudService basemrtplfsCudService = ServiceFinder.find(IBasemrtplfsCudService.class);
		basemrtplfsCudService.insert(new BaseMrTplStreamDO[] { baseMrTplStreamDO });
	}

}
