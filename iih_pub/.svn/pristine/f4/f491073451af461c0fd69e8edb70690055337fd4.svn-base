package iih.nm.nhr.institutabatch.refs;

import xap.sys.appfw.refinfo.RefGridModel;
import iih.nm.nhr.institutabatch.d.NmBatchDO;

/**
 * 实习生批次参照
 * 
 * @author lijm
 *
 */
public class NmBatchModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {

		return new String[] { NmBatchDO.NAME, NmBatchDO.NO_BATCH };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "批次名称", "批次编号" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { NmBatchDO.ID_BATCH };
	}

	@Override
	public String getPkFieldCode() {

		return NmBatchDO.ID_BATCH;
	}

	@Override
	public String getRefCodeField() {

		return NmBatchDO.NO_BATCH;
	}

	@Override
	public String getRefNameField() {

		return NmBatchDO.NAME;
	}

	@Override
	public String getTableName() {

		return new NmBatchDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {

		return super.getBlurFields();
	}
}
