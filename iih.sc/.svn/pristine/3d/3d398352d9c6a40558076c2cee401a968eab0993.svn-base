package iih.sc.apt.s.bp.ip;

import iih.bd.res.bed.d.BedAttrDTO;
import iih.bd.res.bed.d.BedAttrDefDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取床位的特征集合BP
 * 
 * @author zhouliming
 * @modifier zhengcm 整理和规范
 * @modifier zhengcm 增加集团管控
 *
 */
public class GetBedsAttrListBP {
	/**
	 * 获取床位的特征集合
	 * 
	 * @param bedId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BedAttrDTO[] exec(String bedId) throws BizException {
		if (StringUtils.isBlank(bedId)) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("attr.name_bedattr_tp,");
		sb.append("def.name ");
		sb.append("from bd_bed_attr attr ");
		sb.append("inner join bd_bed_attr_def def on attr.sd_bedattr_tp = def.sd_bedattr_tp and attr.val = def.val and def.ds = '0' ");
		sb.append("where attr.id_bed = ? ");
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new BedAttrDefDO(), "def"));
		SqlParam params = new SqlParam();
		params.addParam(bedId);
		List<BedAttrDTO> list = (List<BedAttrDTO>) new DAFacade().execQuery(sb.toString(), params, new BeanListHandler(
				BedAttrDTO.class));
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return list.toArray(new BedAttrDTO[0]);
	}
}
