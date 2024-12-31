package iih.ei.std.s.v1.bp.bd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.ei.std.d.v1.bd.comm.d.QueryNodeDTO;
import iih.ei.std.d.v1.bd.comm.d.QueryNodeListType;
import iih.ei.std.d.v1.bd.comm.d.QueryNodeOper;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

public class BuildWherePartByQueryNodeDtoBP {

	public String exec(QueryNodeDTO queryNodeDTO) throws BizException {

		String wherePart = buildWherePart(queryNodeDTO);
		return wherePart;

	}

	private String buildWherePart(QueryNodeDTO queryNodeDTO) throws BizException {
		if (queryNodeDTO == null) {
			return null;
		}
		if (StringUtils.isNotBlank(queryNodeDTO.getType_child())) {
			return buildWherePart(queryNodeDTO.getType_child(), queryNodeDTO.getNode_child());
		}

		if (StringUtils.isNotBlank(queryNodeDTO.getValue_field())
				&& StringUtils.isNotBlank(queryNodeDTO.getCode_oper())) {
			return buildWherePart(queryNodeDTO.getCode_field(), queryNodeDTO.getCode_oper(),
					queryNodeDTO.getValue_field());
		}

		return null;
	}

	private String buildWherePart(String code_field, String code_oper, String value_field) throws BizException {
		if (QueryNodeOper.EQUALS.equals(code_oper) && StringUtils.isNotBlank(value_field)) {
			return String.format("%s = '%s'", code_field, value_field);
		} else if (QueryNodeOper.NOTEQUALS.equals(code_oper) && StringUtils.isNotBlank(value_field)) {
			return String.format("%s <> '%s'", code_field, value_field);
		} else if (QueryNodeOper.LIKE.equals(code_oper) && StringUtils.isNotBlank(value_field)) {
			return String.format("%s like '%%%s%%'", code_field, value_field);
		} else if (QueryNodeOper.LEFTLIKE.equals(code_oper) && StringUtils.isNotBlank(value_field)) {
			return String.format("%s like '%s%%'", code_field, value_field);
		} else if (QueryNodeOper.RIGHTLIKE.equals(code_oper) && StringUtils.isNotBlank(value_field)) {
			return String.format("%s like '%%%s'", code_field, value_field);
		} else if (QueryNodeOper.ISNULL.equals(code_oper)) {
			return String.format("%s is null", code_field, value_field);
		} else if (QueryNodeOper.ISNOTNULL.equals(code_oper)) {
			return String.format("%s is not null", code_field, value_field);
		} else if (QueryNodeOper.EQUALSIC.equals(code_oper) && StringUtils.isNotBlank(value_field)) {
			return String.format("upper(%s) = '%s'", code_field, value_field.toUpperCase());
		} else if (QueryNodeOper.NOTEQUALSIC.equals(code_oper) && StringUtils.isNotBlank(value_field)) {
			return String.format("upper(%s) <> '%s'", code_field, value_field.toUpperCase());
		} else if (QueryNodeOper.LIKEIC.equals(code_oper) && StringUtils.isNotBlank(value_field)) {
			return String.format("upper(%s) like '%%%s%%'", code_field, value_field.toUpperCase());
		} else if (QueryNodeOper.LEFTLIKEIC.equals(code_oper) && StringUtils.isNotBlank(value_field)) {
			return String.format("upper(%s) like '%s%%'", code_field, value_field.toUpperCase());
		} else if (QueryNodeOper.RIGHTLIKEIC.equals(code_oper) && StringUtils.isNotBlank(value_field)) {
			return String.format("upper(%s) like '%%%s'", code_field, value_field.toUpperCase());
		} else {
			String msg = String.format("不支持的查询条件操作符:%s.", code_oper);
			throw new BizException(msg);
		}
	}

	@SuppressWarnings("unchecked")
	private String buildWherePart(String type_child, FArrayList node_child) throws BizException {
		if (node_child == null || node_child.size() <= 0) {
			return null;
		}
		List<String> wherePartList = new ArrayList<>();
		Iterator<QueryNodeDTO> iterator = node_child.iterator();
		while (iterator.hasNext()) {
			QueryNodeDTO queryNodeDTO = iterator.next();
			String wherePart = buildWherePart(queryNodeDTO);
			if (StringUtils.isNotBlank(wherePart)) {
				wherePartList.add(wherePart);
			}
		}

		String oper = null;
		if (QueryNodeListType.AND.equals(type_child)) {
			oper = " and ";
		} else if (QueryNodeListType.OR.equals(type_child)) {
			oper = " or ";
		} else {
			String msg = String.format("不支持的查询方案子集类型:%s.", type_child);
			throw new BizException(msg);
		}
		if (wherePartList.size() > 0) {
			String wherePart = String.format("(%s)", StringUtils.join(wherePartList, oper));
			return wherePart;
		}
		return null;
	}
}
