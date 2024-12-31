package iih.sc.out.refs;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefGridModel;
import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.desc.DaysLotDODesc;
import iih.bd.utils.BdEnvContextUtil;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
/**
 * 根据排班分类中的日期分组分类查询对应的日期分组
 * @author renying
 *
 */
public class DaysLotRefsFoSc extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DaysLotDO.CODE, DaysLotDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DaysLotDO.ID_DAYSLOT, DaysLotDO.TIME_BEGIN };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DaysLotDO.ID_DAYSLOT;
	}

	@Override
	public String getRefCodeField() {
		return DaysLotDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return DaysLotDO.NAME;
	}

	public String getRefTimeEndField() {
		return DaysLotDO.TIME_BEGIN;
	}

	@Override
	public String getTableName() {
		return DaysLotDODesc.TABLE_NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DaysLotDO.CODE, DaysLotDO.NAME, DaysLotDO.PYCODE, DaysLotDO.WBCODE, DaysLotDO.MNECODE };
	}

	@Override
	public String getRefSql() {
		
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		String sccaCon =null;
		try {
			sccaCon = this.getDayslotcaConditionFromSc();
		} catch (BizException e) {
			e.printStackTrace();
		}
		if(!StringUtil.isEmpty(sccaCon)){
			wherePart += sccaCon +" and fg_active ='Y'";
		}
		try {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();

		} finally {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().remove(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().remove(orderPart);}
		}
		return refSql;
	}
	
	/**
	 * 根据排班分类查找对应的日期分组
	 * @return
	 * @throws BizException
	 */
	private String getDayslotcaConditionFromSc() throws BizException{
		String sd_sctp = (String) getExtendAttributeValue("sd_sctp");
		String sd_sctps = (String) getExtendAttributeValue("sd_sctps");
		ISchedulecaRService service = ServiceFinder.find(ISchedulecaRService.class);
		ScheduleCADO[] cados = null;
		if(!StringUtil.isEmpty(sd_sctp)){
			cados = service.find("sd_sctp ='"+sd_sctp+"'", "", FBoolean.FALSE);
		}else if(!StringUtil.isEmpty(sd_sctps)){
			String[] sd_sctp_arr = sd_sctps.split(",");
			if(!ArrayUtil.isEmpty(sd_sctp_arr)){
				String cond = SqlUtils.getInSqlByBigIds("sd_sctp", sd_sctp_arr);
				cados = service.find(cond, "", FBoolean.FALSE);
			}
		}
		if(ArrayUtil.isEmpty(cados))
			return null;
		boolean isNull = true;
		List<String> id_dayslottp_list = new ArrayList<String>();
		for (ScheduleCADO scheduleCADO : cados) {
			if(!StringUtil.isEmpty(scheduleCADO.getId_dayslottp())){
				isNull = false;
				id_dayslottp_list.add(scheduleCADO.getId_dayslottp());
			}
		}
		if(isNull){
			return null; 
		}
		String result_cond = SqlUtils.getInSqlByIds(DaysLotDODesc.TABLE_NAME+".id_dayslotca", id_dayslottp_list);
		return "and "+result_cond;
	}
	

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DaysLotDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", DaysLotDO.SORTNO));
		return stringBuilder.toString();
	}

}
