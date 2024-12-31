package iih.bd.srv.udidoc.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 服务类型
 * 
 * @author hao_wu
 *
 */
public class MedSrvTpRefModel extends BdRefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected IBaseDO getDo() {
		return new UdidocDO();
	}

	@Override
	protected List<String> getHiddenFieldCodeList() {
		List<String> fieldCodeList = super.getHiddenFieldCodeList();
		fieldCodeList.add(UdidocDO.ID_UDIDOCLIST);
		fieldCodeList.add(UdidocDO.CODE_STD);
		fieldCodeList.add(UdidocDO.ID_PARENT);
		fieldCodeList.add(UdidocDO.INNERCODE);
		fieldCodeList.add(UdidocDO.PYCODE);
		fieldCodeList.add(UdidocDO.WBCODE);
		fieldCodeList.add(UdidocDO.MNECODE);
		fieldCodeList.add(UdidocDO.CTRL1);
		fieldCodeList.add(UdidocDO.CTRL2);
		fieldCodeList.add(UdidocDO.CTRL3);
		fieldCodeList.add(UdidocDO.CTRL4);
		fieldCodeList.add(UdidocDO.CTRL5);
		fieldCodeList.add(UdidocDO.DES);
		return fieldCodeList;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { UdidocDO.CODE, UdidocDO.PYCODE, UdidocDO.NAME, UdidocDO.WBCODE, UdidocDO.MNECODE };
	}

	@Override
	protected StringBuilder buildWhereParter() {
		StringBuilder sqlBuilder = super.buildWhereParter();

		String wherePart = String.format(" and activestate = %s and id_udidoclist = '%s'", ActiveStateEnum.ACTIVE,
				IBdSrvDictCodeTypeConst.ID_SRVTP);
		sqlBuilder.append(wherePart);
		return sqlBuilder;
	}

	@Override
	public List<String> getOrderPart() {
		List<String> orderPartList = new ArrayList<>();
		orderPartList.add(UdidocDO.CODE);
		orderPartList.add(UdidocDO.ID_UDIDOC);
		return orderPartList;
	}
}
