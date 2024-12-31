package iih.sc.scbd.schedulesrv.refs;

import java.util.ArrayList;
import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**排班服务参照模型
 * @author ccj
 *
 */
public class ScheduleSrvRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ScheduleSrvDO.CODE, ScheduleSrvDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ScheduleSrvDO.ID_SCSRV, ScheduleSrvDO.NOTE};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return ScheduleSrvDO.ID_SCSRV;
	}

	@Override
	public String getRefCodeField() {
		return ScheduleSrvDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ScheduleSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ScheduleSrvDO().getTableName();
	}
	/* 
	 *  拼音、五笔、助记码 过滤
	 */
	@Override
	public String[] getBlurFields() {
		return new String[]{"pycode","wbcode","mnecode","code","name"};
	}
	@Override
	public List<String> getWherePart() {
		List<String> wherePart = super.getWherePart();
		if (wherePart==null) {
			wherePart=new ArrayList<String>();
		}
		//增加集团管控
		wherePart.add(ScGroupControlUtils.getGroupControlFitler(new ScheduleSrvDO(), false));
		wherePart.add(ScheduleSrvDO.FG_ACTIVE+"='Y'");
		return wherePart;
	}
	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = super.getOrderPart();
		if (orderPart==null) {
			orderPart=new ArrayList<String>();
		}
		orderPart.add(ScheduleSrvDO.CODE);
		return orderPart;
	}
}

