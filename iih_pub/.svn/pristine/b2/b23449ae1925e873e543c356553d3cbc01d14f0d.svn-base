package iih.bd.pp.bdhpspec.refs;

import java.util.Arrays;
import java.util.List;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.srv.diagdef.d.DiagDefDO;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 特殊病诊断参照模型
 * 
 * @author
 * @version hao_wu 2019-1-22
 *
 */
public class BdDiSelfdefRefModel extends BdRefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DiagDefDO.CODE, DiagDefDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "特殊病诊断编码", "特殊病诊断名称" };
	}

	@Override
	protected IBaseDO getDo() {
		return new DiagDefDO();
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, String[] outBlurFields, PaginationInfo pg) {

		String fields[] = getBlurFields();
		if (fields == null) {
			fields = getShowFieldCode();
		}
		List<String> old = Arrays.asList(fields);
		if (outBlurFields != null) {
			List<String> news = Arrays.asList(outBlurFields);
			for (int i = news.size(); i > 0; i--) {
				String one = (String) news.get(i);
				if (!old.contains(one))
					news.remove(one);
			}

			if (news != null)
				fields = (String[]) news.toArray(new String[0]);
		}

		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("(");
		for (int i = 0; i < fields.length; i++) {
			if (i != 0) {
				wherePartBuilder.append(" or ");
			}
			String field = cutOffAs(fields[i]);
			String wherePart = String.format("lower(%s) like '%%%s%%'", field, blurValue.toLowerCase());
			wherePartBuilder.append(wherePart);
		}

		String wherePart = String.format(
				" or id_didef in (select distinct id_didef from bd_di_als where (lower(pycode) like '%s%%' or lower(wbcode) like '%s%%' or lower(mnecode) like '%%%s%%' or lower(alias) like '%%%s%%'))",
				blurValue.toLowerCase(), blurValue.toLowerCase(), blurValue.toLowerCase(), blurValue.toLowerCase());
		wherePartBuilder.append(wherePart);

		wherePartBuilder.append(")");
		wherePart = wherePartBuilder.toString();

		try {
			addWherePart(wherePart);
			RefResultSet refresultset;
			if (pg != null) {
				refresultset = getRefData(pg);
				return refresultset;
			} else {
				refresultset = getRefData();
				return refresultset;
			}
		} finally {
			removeWherePart(wherePart);
		}
	}
}
