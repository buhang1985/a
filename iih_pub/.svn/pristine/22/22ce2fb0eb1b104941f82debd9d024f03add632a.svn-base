package iih.bd.res.warehouse.refs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ctc.wstx.util.StringUtil;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.util.WhDataperUtil;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefTreeModel;
import xap.sys.dataper.i.IDataperExtQry;
import xap.sys.permfw.dataper.d.DataPerRuleDO;

@SuppressWarnings("serial")
public class WareHouseRefModelByDataper extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { WarehouseDO.CODE, WarehouseDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { WarehouseDO.ID_WH,WarehouseDO.ID_CYCLEU,WarehouseDO.SD_CYCLEU,
				WarehouseDO.FG_LOC, WarehouseDO.ID_PARENT, WarehouseDO.INNERCODE,WarehouseDO.ID_DEP_BELONG};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return WarehouseDO.ID_WH;
	}

	@Override
	public String getRefCodeField() {
		return WarehouseDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return WarehouseDO.NAME;
	}

	@Override
	public String getTableName() {
		return new WarehouseDO().getTableName();
	}
	
	@Override
	public String getFatherField() {
		return WarehouseDO.ID_PARENT;
	}
	
	@Override
	public String getChildField() {
		return WarehouseDO.ID_WH;
	}
	
	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(WarehouseDO.CODE);
		return orderPart;
	}
	
	@Override
	public String getRefSql() {
		
		StringBuffer wherePartBuffer = new StringBuffer();
		wherePartBuffer.append(" ds=0 ");
		wherePartBuffer.append(" and fg_active = 'Y' ");
		wherePartBuffer.append(" and fg_last = 'Y' ");	
		 
		//期初结存不过滤仓库启账状态
		String fg_PostFilter = (String) this.getExtendAttributeValue("fg_PostFilter");
		if (!"N".equals(fg_PostFilter)) {
			wherePartBuffer.append(" and id_wh in (select id_wh from mm_ini where id_su_st = '@@@@AA1000000004NW06' and sd_su_st = '1') "); // 已启账
		}

		String id_wh_list = (String) this.getExtendAttributeValue("id_wh_list");
		if(!StringUtils.isBlank(id_wh_list)){
			wherePartBuffer.append(" and id_wh in " + id_wh_list);
		}
		
		String sd_whtp = (String) this.getExtendAttributeValue("sd_whtp");
		if(!StringUtils.isBlank(sd_whtp)){
			wherePartBuffer.append(" and sd_whtp = '" + sd_whtp + "' ");
		}
		
		String sd_whtp_list = (String) this.getExtendAttributeValue("sd_whtp_list");
		if(!StringUtils.isBlank(sd_whtp_list)){
			wherePartBuffer.append(" and sd_whtp in " + sd_whtp_list + " ");
		}
		
		//TODO
		//所有仓库列表单独走数据权限， 不与部门挂钩 
		String id_dep_belong = (String) this.getExtendAttributeValue("id_dep_belong");
		if(!StringUtils.isBlank(id_dep_belong)){
			wherePartBuffer.append(" and id_dep_belong = '" + id_dep_belong + "'");
		}
		
		//组织过滤
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new WarehouseDO(), false);
		wherePartBuffer.append(String.format(" and (%s) ", BdModeWherePart));
		
		//仓库类型过滤(药库、药房、基数药房)
		String whtpStr = String.format(" and sd_whtp in ('%s','%s','%s') ", IBdResDictCodeConst.SD_WHTP_YAOKU, 
				IBdResDictCodeConst.SD_WHTP_YAOFANG, IBdResDictCodeConst.SD_WHTP_JISHU);
		wherePartBuffer.append(whtpStr);
		
		//数据权限
		if(!StringUtils.isBlank(Context.get().getUserId())){
			try {
				String sql = WhDataperUtil.getDataperSql(Context.get().getUserId(),FBoolean.FALSE);
				if(!StringUtil.isAllWhitespace(sql)){
					wherePartBuffer.append("and (" + sql + ") ");
				}				
			} catch (BizException e) {
				// TODO Auto-generated catch block
			}
			
		}
		
		this.setDataper(wherePartBuffer);

		String wherePart = wherePartBuffer.toString();
		this.addWherePart(wherePart);
		String sql = null;
		try {
			sql = super.getRefSql();
		} finally {
			this.removeWherePart(wherePart);
		}

		return sql;
	}
	
	private void setDataper(StringBuffer wherePartBuffer) {
		String funcode = (String) this.getExtendAttributeValue("funcode");
		
		if(StringUtils.isBlank(funcode)) {
			return;
		}
		
		IDataperExtQry ideq = ServiceFinder.find(IDataperExtQry.class);
		String whereSql = "";
	
		try {
			List<DataPerRuleDO> listruledo = ideq.getSysDataperRuleByUserRole(
					Context.get().getUserId(), funcode);
			if (listruledo != null && listruledo.size() > 0) {
				DataPerRuleDO ruleDo = listruledo.get(0);
				whereSql = ideq.getwhere(ruleDo);
			}
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		if(!StringUtils.isBlank(whereSql)) {
			wherePartBuffer.append(" and " + whereSql + " ");
		}
	}

	@Override
	public String afterBuilderSql(String sql) {
		return super.afterBuilderSql(sql);
	}
	 
	@Override
	public String[] getBlurFields() {
		return new String[]{WarehouseDO.NAME, WarehouseDO.CODE, WarehouseDO.PYCODE,
				WarehouseDO.WBCODE, WarehouseDO.MNECODE};
	}	
	
	@Override
	public String getRefTitle(){
		return "仓库";				
	}
}
