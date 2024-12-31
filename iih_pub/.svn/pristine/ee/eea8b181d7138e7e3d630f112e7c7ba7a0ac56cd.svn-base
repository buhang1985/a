package iih.ei.itf.eiitfdo.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.refs.BdRefGridModel;
import iih.ei.itf.eiitfdo.d.EiItfDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 标准接口参照模型
 * 
 * @author hao_wu 2019-9-29
 *
 */
public class EiITfRefModel extends BdRefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	protected IBaseDO getDo() {
		return new EiItfDO();
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { EiItfDO.NAME, EiItfDO.SERVICENAME, EiItfDO.METHODNAME, EiItfDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "服务名", "方法名", "编码" };
	}

	@Override
	public List<String> getOrderPart() {
		List<String> orderPartList = new ArrayList<String>();
		orderPartList.add(EiItfDO.CODE);
		orderPartList.add(EiItfDO.ID_ITF);
		return orderPartList;
	}

	@Override
	protected List<String> getBlurFieldList() {
		List<String> fieldList = super.getBlurFieldList();
		fieldList.add(EiItfDO.SERVICENAME);
		fieldList.add(EiItfDO.METHODNAME);
		return fieldList;
	}
}
