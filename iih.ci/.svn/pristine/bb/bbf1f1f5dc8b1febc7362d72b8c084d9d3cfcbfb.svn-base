package iih.ci.ord.s.external.thirdws.op.base;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.external.thirdws.base.IEmsSaveBP;
import iih.ci.ord.s.external.thirdws.base.IValidate;

/**
 * 医疗单保存接口
 * @author zhangwq
 *
 */
public abstract class OpEmsBaseSaveBP implements IEmsSaveBP{
	private IEmsSaveBP saveAction;
	private IValidate validate;
	private EntWsDTO dataSource;
	public OpEmsBaseSaveBP(){};
	public OpEmsBaseSaveBP(EntWsDTO dataSource){
		this.dataSource = dataSource;
	}
	public IEmsSaveBP getSaveAction() {
		return saveAction;
	}
	public void setSaveAction(IEmsSaveBP saveAction) {
		this.saveAction = saveAction;
	}
	public EntWsDTO getDataSource() {
		return dataSource;
	}
	public void setDataSource(EntWsDTO dataSource) {
		this.dataSource = dataSource;
	}
	public IValidate getValidate() {
		return validate;
	}
	public void setValidate(IValidate validate) {
		this.validate = validate;
	}
	
}
