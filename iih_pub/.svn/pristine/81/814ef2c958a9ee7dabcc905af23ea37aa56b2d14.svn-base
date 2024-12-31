package iih.ci.rcm.contagion.refs;

import java.util.List;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrarea.d.MrAreaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.Context;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.refinfo.RefGirdModel;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.xbd.udi.d.UdidocDO;

public class CongationRefGridModel extends BdRefGridModel {

	/**
	 *参照模型，用于传染病参照，传染病上报卡自动带出附卡 
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
		return fieldCodeList;
	}

	@Override
	public String[] getShowFieldCode() {

		return new String[] { UdidocDO.DES, UdidocDO.CODE };
	}
	
	@Override
	public String [] getShowFieldName(){
		return new String[]{"名称","编码"};
	}

	@Override
	public String getRefCodeField(){
		return UdidocDO.CODE;
	}
	
	@Override
	public String getRefNameField(){
		return UdidocDO.DES;
	}
	
	@Override
	public String[] getBlurFields(){
		return new String[] {UdidocDO.DES,UdidocDO.CODE};
	}
	
	@Override
	public String getRefSql(){
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(wherePart != null && !"".equals(wherePart)){this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart)){this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();
			
		} finally {
			if(wherePart != null && !"".equals(wherePart)){this.getWherePart().remove(wherePart);}
			if(orderPart != null && !"".equals(orderPart)){this.getOrderPart().remove(orderPart);}
		}
		return refSql;
	}
	
	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart(){
		StringBuilder stringBudilder = new StringBuilder("1=1");
		stringBudilder.append(" and id_udidoclist in ('"+ICiMrDictCodeConst.ID_TYPE_CONGATION_A+"','"+ICiMrDictCodeConst.ID_TYPE_CONGATION_B+"','"+ICiMrDictCodeConst.ID_TYPE_CONGATION_C+"','"+ICiMrDictCodeConst.ID_TYPE_CONGATION_OTHER+"')");
		
		return stringBudilder.toString();
	}
	
	/**
	 *构建排序语句 
	 * 
	 */
	private String BuildOrderPart(){
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.toString();
	}

}
