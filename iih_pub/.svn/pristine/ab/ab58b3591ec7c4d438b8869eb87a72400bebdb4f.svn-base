package iih.sc.scbd.scdeptparam.refs;

import java.util.ArrayList;
import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.sch.i.IScSchQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefGridModel;

public class ScDepParamForSchRefModel  extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_ver" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ScDeptParamDO.ID_DEPTPARAM,ScDeptParamDO.VER,ScDeptParamDO.D_BEGIN,ScDeptParamDO.D_END };
	}
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		//增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new ScDeptParamDO(), "sc_dep_param"));
		return whereParts;
	}
	@Override
	public String getRefSql() {
		
		
		String sql = "select * from (select 'V'||sc_dep_param.ver||'('||sc_dep_param.d_begin||'~'||sc_dep_param.d_end||')' as name_ver,sc_dep_param.*  from sc_dep_param )sc_dep_param";
		StringBuilder sb = new StringBuilder(sql);
		sb.append(" where 1=1 ");
		List whereList = getWherePart();
		if (whereList.size() > 0) {
			for (String where : getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
				
		String dt_b = (String)getExtendAttributeValue("dt_b");
		String dt_e = (String)getExtendAttributeValue("dt_e");
		String room = (String)getExtendAttributeValue("room");

		 IScSchQryService service = ServiceFinder.find(IScSchQryService.class);
        FArrayList fArray =null;
		try {
			fArray = service.getDepParamIdList(dt_b, dt_e,room);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (fArray == null || fArray.size() == 0)
        {
            return sb.append(" and  1>2").toString();
        }
        List<String> idList = new ArrayList<String>();
        for (Object idDepParam :fArray)
        {
            idList.add((String)idDepParam);
        }
                     
        if (idList == null || idList.size() == 0)
        {
            return null;
        }
        String idStr = buildIdStr(idList);
		sb.append(" and id_deptparam in (" + idStr + ")");
		
		
		
		return sb.toString();
//		return	super.getRefSql();
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "版本" };
	}

	@Override
	public String getPkFieldCode() {
		return ScDeptParamDO.ID_DEPTPARAM;
	}

	@Override
	public String getRefNameField() {
		return "name_ver";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new ScDeptParamDO().getTableName();
	}
	
	/**
	 * 生成id的查询串
	 * 
	 * @param idList id集合
	 * @return
	 */
	private String buildIdStr(List<String> idList) {
		if (ListUtil.isEmpty(idList)) {
			return null;
		}

		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String id : idList) {
			if (StringUtil.isEmpty(id)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", id));
		}

		return builder.toString();
	}
}
