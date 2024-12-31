package iih.bd.pp.sys.refs;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 
 * 病区参照
 * 
 * @author hao_wu
 * @date 2020年3月15日
 *
 */
public class WardRefGridModel extends BdRefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected IBaseDO getDo() {
		return new DeptDO();
	}

	@Override
	protected StringBuilder buildWhereParter() {
		StringBuilder whereBuilder = super.buildWhereParter();
		whereBuilder.append(String.format(" and Sd_depttp = '%s'", ISysDictCodeConst.SD_DEPTTP_NURSE));

		whereBuilder.append(String.format(" and Activestate = '%s'", ActiveStateEnum.ACTIVE));
		return whereBuilder;
	}
}
