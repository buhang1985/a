package iih.pe.pbd.pediroom.refs;

import iih.pe.pbd.pediroom.d.PeDiDiRoomDO;
import iih.pe.pbd.pediroom.d.desc.PeDiDiRoomDODesc;
import iih.pe.pbd.pefuncarea.d.PeFuncAreaDO;
import iih.pe.pitm.pesrvitem.d.PeSrvItemDO;
import iih.pe.comm.utils.PeEnvContextUtil;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

/**
 * @author 作者 :wangyuchun
 * @version 创建时间：2018年9月25日 下午8:35:16
 * 类说明：体检常用结论参照模型
 * Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public class PeDiDiRoomRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeDiDiRoomDO.CODE, PeDiDiRoomDO.NAME };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeDiDiRoomDO.ID_PEDIROOM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeDiDiRoomDO.ID_PEDIROOM;
	}

	@Override
	public String getRefCodeField() {
		return PeDiDiRoomDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeDiDiRoomDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeDiDiRoomDO().getTableName();
	}
	
	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeDiDiRoomDO.ID_PEDEPTSET);
		return listOrderParts;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeDiDiRoomDO(), false));
		return listWhereParts;
	}
}
